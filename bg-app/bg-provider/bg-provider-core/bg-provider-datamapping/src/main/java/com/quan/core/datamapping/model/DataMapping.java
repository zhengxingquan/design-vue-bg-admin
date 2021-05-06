package com.quan.core.datamapping.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.constant.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;




/**
 * 系统映射配置表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 16:02:13
 */

@Getter
@Setter
@Data
@TableName("sys_data_mapping")
public class DataMapping extends BaseEntity{

private static final long serialVersionUID=1L;

                            /**
         * 
         */
        @TableField(value = "parent_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long parentId;
                                /**
         * 模块名称
         */
        @TableField(value = "model_name")
                private String modelName;
                                /**
         * 模块显示字段名称
         */
        @TableField(value = "name")
                private String name;
                                /**
         * 字段所在仓库的ID
         */
        @TableField(value = "database_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long databaseId;
                                /**
         * 字段所在表的ID
         */
        @TableField(value = "table_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long tableId;
                                /**
         * 字段ID
         */
        @TableField(value = "filed_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long filedId;
                                /**
         * 数据查询条件
         */
        @TableField(value = "condition")
                private String condition;
                                /**
         * 系统编码(用作查询使用，全局唯一)
         */
        @TableField(value = "sys_code")
                private String sysCode;
                                /**
         * 需要更新的字段或者插入的字段(多字段)
         */
        @TableField(value = "fields")
                private String fields;
                                /**
         * 映射类型 
0 字段名 
1 字段列表 
2 表名 
3 数据库名 
4 表数据集合(表示将会查询一张表的多个字段组成一条数据集合)
5 插入SQL
6 更新SQL
7 删除SQL
8 查询SQL
9 JS语句
         */
        @TableField(value = "type")
                private Integer type;
                                /**
         * 描述
         */
        @TableField(value = "note")
                private String note;
                                /**
         * SQL语句
         */
        @TableField(value = "sql")
                private String sql;
                                /**
         * 是否有子节点
         */
        @TableField(value = "has_children")
                private Integer hasChildren;
                                /**
         * 排序号
         */
        @TableField(value = "sort")
                private Integer sort;
                                /**
         * 树路径
         */
        @TableField(value = "path")
                private String path;
                                                                                            
}
