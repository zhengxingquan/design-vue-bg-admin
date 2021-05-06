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
 * 系统数据表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:05:24
 */

@Getter
@Setter
@Data
@TableName("sys_data_table")
public class DataTable extends BaseEntity{

private static final long serialVersionUID=1L;

                            /**
         * 仓库的ID
         */
        @TableField(value = "parent_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long parentId;
                                /**
         * 中文名称
         */
        @TableField(value = "name")
                private String name;
                                /**
         * 物理名称
         */
        @TableField(value = "physical_name")
                private String physicalName;
                                /**
         * 表类型，1=主表， 2=从表
         */
        @TableField(value = "table_type")
                private Integer tableType;
                                /**
         * 编码
         */
        @TableField(value = "table_code")
                private String tableCode;
                                /**
         * 简介
         */
        @TableField(value = "note")
                private String note;
                                /**
         * 提示信息
         */
        @TableField(value = "tooltip")
                private String tooltip;
                                /**
         * 复制表结构id
         */
        @TableField(value = "copy_table_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long copyTableId;
                                /**
         * 
         */
        @TableField(value = "path")
                private String path;
                                /**
         * 是否有子节点
         */
        @TableField(value = "has_children")
                private Integer hasChildren;
                                /**
         * 排序字段
         */
        @TableField(value = "sort")
                private Integer sort;
                                                                                            
}
