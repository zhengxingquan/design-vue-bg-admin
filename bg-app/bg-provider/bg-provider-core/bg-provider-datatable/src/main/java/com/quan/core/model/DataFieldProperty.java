package com.quan.core.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.constant.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;




/**
 * 系统字段属性表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:19:31
 */

@Getter
@Setter
@Data
@TableName("sys_data_field_property")
public class DataFieldProperty extends BaseEntity{

private static final long serialVersionUID=1L;

                            /**
         * 父节点
         */
        @TableField(value = "parent_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long parentId;
                                /**
         * 名称
         */
        @TableField(value = "name")
                private String name;
                                /**
         * 
         */
        @TableField(value = "code")
                private String code;
                                /**
         * 系统编码(用于查询使用，全局唯一)
         */
        @TableField(value = "sys_code")
                private String sysCode;
                                /**
         * 数据库中数据类型
         */
        @TableField(value = "db_field_type")
                private String dbFieldType;
                                /**
         * 简介
         */
        @TableField(value = "note")
                private String note;
                                /**
         * 路径
         */
        @TableField(value = "path")
                private String path;
                                /**
         * 排序字段
         */
        @TableField(value = "sort")
                private Integer sort;
                                /**
         * 是否有子节点
         */
        @TableField(value = "has_children")
                private Integer hasChildren;
                                                                                            
}
