package com.quan.core.rabbitmq.model;

import lombok.Data;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/3 9:39

 */
@Data
public class ColumnEntity {

    //列名
    private String columnName;
    //列名类型
    private String dataType;
    //列名备注
    private String comments;

    //属性名称(第一个字母大写)，如：user_name => UserName
    private String attrName;
    //属性名称(第一个字母小写)，如：user_name => userName
    private String attrname;
    //属性类型
    private String attrType;
    /***
     * 自动增长  auto_increment
     */
    private String extra;
    /***
     * 查询是否忽略
     */
    private boolean reqIgnore;

    /***
     * DTO是否忽略
     */
    private boolean dtoIgnore;

    /***
     * model 是否忽略
     */
    private boolean modelIgnore;
    /***
     * 编辑 是否忽略
     */
    private boolean updateIgnore;
    /***
     * 新增 是否忽略
     */
    private boolean createIgnore;


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrname() {
        return attrname;
    }

    public void setAttrname(String attrname) {
        this.attrname = attrname;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public boolean isDtoIgnore() {
        return dtoIgnore;
    }

    public void setDtoIgnore(boolean dtoIgnore) {
        this.dtoIgnore = dtoIgnore;
    }

    public boolean isModelIgnore() {
        return modelIgnore;
    }

    public void setModelIgnore(boolean modelIgnore) {
        this.modelIgnore = modelIgnore;
    }

    public boolean isReqIgnore() {
        return reqIgnore;
    }

    public void setReqIgnore(boolean reqIgnore) {
        this.reqIgnore = reqIgnore;
    }

    public boolean isUpdateIgnore() {
        return updateIgnore;
    }

    public void setUpdateIgnore(boolean updateIgnore) {
        this.updateIgnore = updateIgnore;
    }

    public boolean isCreateIgnore() {
        return createIgnore;
    }

    public void setCreateIgnore(boolean createIgnore) {
        this.createIgnore = createIgnore;
    }
}
