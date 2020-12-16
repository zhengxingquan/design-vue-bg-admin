package com.quan.core.service.impl;

import com.quan.common.annotation.PageQuery;
import com.quan.common.web.PageResult;
import com.quan.core.dao.SysGeneratorDao;
import com.quan.core.dto.GeneratorQueryDTO;
import com.quan.core.request.GeneratorQueryRequest;
import com.quan.core.service.SysGeneratorService;
import com.quan.core.utils.GenUtils;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/***
 * 服务类
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/9 15:36
 */
@Service
public class SysGeneratorServiceImpl implements SysGeneratorService {

    @Autowired
    private SysGeneratorDao sysGeneratorDao;

    @Override
    @PageQuery
    public Object queryList(GeneratorQueryRequest req) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
//        PageHelper.startPage(MapUtils.getInteger(map, "page"), MapUtils.getInteger(map, "limit"), true);
        GeneratorQueryDTO data = new GeneratorQueryDTO();
        data.setTableName(req.getTableName());
        data.setPageNumber(req.getPageNumber());
        data.setPageSize(req.getPageSize());
        return sysGeneratorDao.queryList(data);

//        PageInfo pageInfo = new PageInfo<>(list);
//        return PageResult.builder().data(pageInfo.getList()).code(0).count(pageInfo.getTotal()).build();
    }

    @Override
    public int queryTotal(GeneratorQueryRequest req) {
        return 0;
    }

    @Override
    public Map<String, String> queryTable(String tableName) {
        return sysGeneratorDao.queryTable(tableName);
    }

    @Override
    public List<Map<String, String>> queryColumns(String tableName) {
        return sysGeneratorDao.queryColumns(tableName);
    }

    @Override
    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (String tableName : tableNames) {
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
