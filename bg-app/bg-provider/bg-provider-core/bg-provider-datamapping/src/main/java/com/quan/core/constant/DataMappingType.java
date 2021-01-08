package com.quan.core.constant;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/8
 * 描述：
 */
public enum DataMappingType {
    /***
     *  字段名
     */
    FIELD(0),
    /***
     *  字段列表
     */
    MULTI_FIELD(1),
    /***
     *  表名
     */
    TABLE(2),
    /***
     *  数据库名
     */
    DATABASE(3),
    /***
     *  表数据集合(表示将会查询一张表的多个字段组成一条数据集合)
     */
    MULTI_TABLE(4),
    /***
     *  插入SQL
     */
    INSERT_SQL(5),
    /***
     *  更新SQL
     */
    UPDATE_SQL(6),
    /***
     *  删除SQL
     */
    DELETE_SQL(7),
    /***
     *  查询SQL
     */
    SELECT_SQL(8),
    /***
     *  JS动态SQL语句
     */
    JS_SQL(9),

    /***
     *  视图
     */
    VIEW(10);

    private Integer code;

    DataMappingType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
