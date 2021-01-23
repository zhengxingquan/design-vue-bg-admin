package com.quan.core.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/****
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/3 9:39
 */
@Data
@Getter
@Setter
public class TableEntity {

    // 数据库的表名称 如：sys_user => SysUser
    private String dbTableName;
    //表的名称
    private String tableName;
    //表的备注
    private String comments;
    //表的主键
    private ColumnEntity pk;
    //表的列名(不包含主键)
    private List<ColumnEntity> columns;

    //类名(第一个字母大写)，如：sys_user => SysUser
    private String className;
    //类名(第一个字母小写)，如：sys_user => sysUser
    private String classname;

    // 权限前缀
    private String permissionNamePrefix;
    // 请求 URL 前缀
    private String requestUrlPrefix;

    // 是否序列化
    private Boolean serializableState = false;

    public String getDbTableName() {
        return dbTableName;
    }

    public void setDbTableName(String dbTableName) {
        this.dbTableName = dbTableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ColumnEntity getPk() {
        return pk;
    }

    public void setPk(ColumnEntity pk) {
        this.pk = pk;
    }

    public List<ColumnEntity> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnEntity> columns) {
        this.columns = columns;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getPermissionNamePrefix() {
        return permissionNamePrefix;
    }

    public void setPermissionNamePrefix(String permissionNamePrefix) {
        this.permissionNamePrefix = permissionNamePrefix;
    }

    public String getRequestUrlPrefix() {
        return requestUrlPrefix;
    }

    public void setRequestUrlPrefix(String requestUrlPrefix) {
        this.requestUrlPrefix = requestUrlPrefix;
    }

    public Boolean getSerializableState() {
        return serializableState;
    }

    public void setSerializableState(Boolean serializableState) {
        this.serializableState = serializableState;
    }
}
