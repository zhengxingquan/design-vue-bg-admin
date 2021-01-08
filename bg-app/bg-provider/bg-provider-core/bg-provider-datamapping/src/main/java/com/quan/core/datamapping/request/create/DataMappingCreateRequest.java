package com.quan.core.datamapping.request.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统映射配置表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 16:02:13
 */

@Getter
@Setter
@Data
@ApiModel
public class DataMappingCreateRequest {


    /**
     *
     */
    @ApiModelProperty(value = "父节点ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    /**
     * 模块名称
     */
    @ApiModelProperty(value = "模块名称")
    private String modelName;

    /**
     * 模块显示字段名称
     */
    @ApiModelProperty(value = "模块显示字段名称")
    private String name;

    /**
     * 字段所在仓库的ID
     */
    @ApiModelProperty(value = "字段所在仓库的ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long databaseId;

    /**
     * 字段所在表的ID
     */
    @ApiModelProperty(value = "字段所在表的ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long tableId;

    /**
     * 字段ID
     */
    @ApiModelProperty(value = "字段ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long filedId;

    /**
     * 数据查询条件
     */
    @ApiModelProperty(value = "数据查询条件")
    private String condition;

    /**
     * 系统编码(用作查询使用，全局唯一)
     */
    @ApiModelProperty(value = "系统编码(用作查询使用，全局唯一)")
    private String sysCode;

    /**
     * 需要更新的字段或者插入的字段(多字段)
     */
    @ApiModelProperty(value = "需要更新的字段或者插入的字段(多字段)")
    private String fields;

    /**
     * 映射类型
     * 0 字段名
     * 1 字段列表
     * 2 表名
     * 3 数据库名
     * 4 表数据集合(表示将会查询一张表的多个字段组成一条数据集合)
     * 5 插入SQL
     * 6 更新SQL
     * 7 删除SQL
     * 8 查询SQL
     * 9 JS语句
     */
    @ApiModelProperty(value = "映射类型 " +
            "0 字段名 " +
            "1 字段列表 " +
            "2 表名 " +
            "3 数据库名 " +
            "4 表数据集合(表示将会查询一张表的多个字段组成一条数据集合) " +
            "5 插入SQL " +
            "6 更新SQL " +
            "7 删除SQL " +
            "8 查询SQL " +
            "9 JS语句")
    private Integer type;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String note;

    /**
     * SQL语句
     */
    @ApiModelProperty(value = "SQL语句")
    private String sql;


}
