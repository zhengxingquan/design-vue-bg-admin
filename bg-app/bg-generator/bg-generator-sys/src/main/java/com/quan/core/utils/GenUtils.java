package com.quan.core.utils;

import com.quan.core.model.ColumnEntity;
import com.quan.core.model.TableEntity;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/***
 * 代码生成器   工具类
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/3 9:40
 */
public final class GenUtils {


    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("template/Model.java.vm");
        templates.add("template/Dao.java.vm");
        templates.add("template/Dao.xml.vm");
        templates.add("template/Service.java.vm");
        templates.add("template/ServiceImpl.java.vm");
        templates.add("template/Controller.java.vm");
        /* 表格查询使用 */
        templates.add("template/request/PageQueryRequest.java.vm");
        templates.add("template/request/CreateRequest.java.vm");
        templates.add("template/request/UpdateRequest.java.vm");
        templates.add("template/request/QueryRequest.java.vm");
        /* server 与 dao 层的转换类 */
        templates.add("template/dto/PageQueryDTO.java.vm");
        templates.add("template/dto/QueryDTO.java.vm");
        templates.add("template/dto/CreateDTO.java.vm");
        templates.add("template/dto/UpdateDTO.java.vm");

        templates.add("template/index.html.vm");

        return templates;
    }

    /**
     * 生成代码
     */
    public static void generatorCode(Map<String, String> table,
                                     List<Map<String, String>> columns, ZipOutputStream zip) {
        //配置信息
        Configuration config = getConfig();
        boolean hasBigDecimal = false;
        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName"));
        tableEntity.setComments(table.get("tableComment"));
        //表名转换成Java类名
        String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix"));
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnEntity> columsList = new ArrayList<>();
        for (Map<String, String> column : columns) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName"));
            columnEntity.setDataType(column.get("dataType"));
            columnEntity.setComments(column.get("columnComment"));
            columnEntity.setExtra(column.get("extra"));

            //列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));

            //列的数据类型，转换成Java类型
            String attrType = config.getString(columnEntity.getDataType(), "unknowType");
            columnEntity.setAttrType(attrType);
            if (!hasBigDecimal && "BigDecimal".equals(attrType)) {
                hasBigDecimal = true;
            }
            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableEntity.getPk() == null) {
                tableEntity.setPk(columnEntity);
            }

            columsList.add(columnEntity);
        }
        tableEntity.setColumns(columsList);

        //没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
        String mainPath = config.getString("mainPath");
        mainPath = StringUtils.isBlank(mainPath) ? "io.renren" : mainPath;
        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("pkgName", className.toLowerCase());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("mainPath", mainPath);
        map.put("package", config.getString("package"));
        map.put("moduleName", config.getString("moduleName"));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        List<String> templates = getTemplates();
        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);

            try {
                //添加到zip
                zip.putNextEntry(new ZipEntry(getFileName(template, tableEntity.getClassName(), config.getString("package"), tableEntity.getTableName())));
                IOUtils.write(sw.toString(), zip, "UTF-8");
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                throw new RuntimeException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
            }
        }
    }


    /**
     * 列名转换成Java属性名
     */
    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnToJava(tableName);
    }

    /**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException("获取配置文件失败，", e);
        }
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, String className, String packageName, String tableName) {
        String resourcesPath = "main" + File.separator + "resources" + File.separator;
        String packagePath = "main" + File.separator + "java" + File.separator;
        tableName = tableName.replace("-", "")
                .replace("_", "").toLowerCase();

        if (StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator + tableName + File.separator;
        }

        /* 实体类 PO */
        if (template.contains("Model.java.vm")) {
            return packagePath + "model" + File.separator + className + ".java";
        }

        /* dao 操作层 */
        if (template.contains("Dao.java.vm")) {
            return packagePath + "dao" + File.separator + className + "Dao.java";
        }

        /* Service 操作层 */
        if (template.contains("Service.java.vm")) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }

        /* Service 实现层 */
        if (template.contains("ServiceImpl.java.vm")) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }

        /* 控制层 */
        if (template.contains("Controller.java.vm")) {
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }

        /* xml 代码 */
        if (template.contains("Dao.xml.vm")) {
            return resourcesPath + "mapper" + File.separator + className + "Dao.xml";
        }

        /* CreateRequest request  */
        if (template.contains("CreateRequest.java.vm")) {
            return packagePath + "request" + File.separator + "create" + File.separator + className + "CreateRequest.java";
        }

        /* PageQueryRequest request  */
        if (template.contains("PageQueryRequest.java.vm")) {
            return packagePath + "request" + File.separator + className + "PageQueryRequest.java";
        }

        /* QueryRequest request  */
        if (template.contains("QueryRequest.java.vm")) {
            return packagePath + "request" + File.separator + className + "QueryRequest.java";
        }

        /* UpdateRequest request  */
        if (template.contains("UpdateRequest.java.vm")) {
            return packagePath + "request" + File.separator + "update" + File.separator + className + "UpdateRequest.java";
        }


        /* CreateDTO DTO  */
        if (template.contains("CreateDTO.java.vm")) {
            return packagePath + "dto" + File.separator + "create" + File.separator + className + "CreateDTO.java";
        }

        /* PageQueryDTO DTO  */
        if (template.contains("PageQueryDTO.java.vm")) {
            return packagePath + "dto" + File.separator + className + "PageQueryDTO.java";
        }

        /* PageQueryDTO DTO  */
        if (template.contains("QueryDTO.java.vm")) {
            return packagePath + "dto" + File.separator + className + "QueryDTO.java";
        }

        /* UpdateDTO DTO  */
        if (template.contains("UpdateDTO.java.vm")) {
            return packagePath + "dto" + File.separator + "update" + File.separator + className + "UpdateDTO.java";
        }


        if (template.contains("db.sql.vm")) {
            return className.toLowerCase() + ".sql";
        }

        if (template.contains("index.html.vm")) {
            return "main" + File.separator + "view" + File.separator + "pages" +
                    File.separator + tableName + File.separator + tableName + ".html";
        }
        return null;
    }
}
