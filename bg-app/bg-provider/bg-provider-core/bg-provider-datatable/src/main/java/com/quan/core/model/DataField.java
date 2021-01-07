package com.quan.core.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;




/**
 * 系统字段表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:29:07
 */

@Getter
@Setter
@Data
@TableName("sys_data_field")
public class DataField extends BaseEntity{

private static final long serialVersionUID=1L;

                            /**
         * 数据表ID
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
         * 编码
         */
        @TableField(value = "data_field_code")
                private String dataFieldCode;
                                /**
         * 物理名称
         */
        @TableField(value = "physical_name")
                private String physicalName;
                                /**
         * 枚举依赖字段id
         */
        @TableField(value = "enum_data_field_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long enumDataFieldId;
                                /**
         * 被依赖字段id
         */
        @TableField(value = "enum_depend_field_id")
                private String enumDependFieldId;
                                /**
         * 关联编号
         */
        @TableField(value = "association_id")
                private String associationId;
                                /**
         * 枚举值id
         */
        @TableField(value = "enum_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long enumId;
                                /**
         * 字段属性：1=逻辑字段，2=物理字段
         */
        @TableField(value = "data_field_property")
                private Integer dataFieldProperty;
                                /**
         * 字段长度
         */
        @TableField(value = "data_field_length")
                private Integer dataFieldLength;
                                /**
         * 字段是否必填
         */
        @TableField(value = "required_data_field")
                private Integer requiredDataField;
                                /**
         * 字段类型ID
         */
        @TableField(value = "data_field_type_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long dataFieldTypeId;
                                /**
         * 小数位数长度，（主要针对于 实数类型 ）
         */
        @TableField(value = "decimal_length")
                private Integer decimalLength;
                                /**
         * 正则表达式
         */
        @TableField(value = "regex_expression")
                private String regexExpression;
                                /**
         * 字段记录引用id
         */
        @TableField(value = "expression_id")
                private String expressionId;
                                /**
         * 提示信息
         */
        @TableField(value = "tooltip")
                private String tooltip;
                                /**
         * 备注
         */
        @TableField(value = "note")
                private String note;
                                /**
         * 是否建立索引(0 不是索引 ， 1 是索引)
         */
        @TableField(value = "index_able")
                private Integer indexAble;
                                /**
         * 字段类别(0 共有字段 1 私有字段)
         */
        @TableField(value = "data_field_state")
                private Integer dataFieldState;
                                /**
         * 排序字段
         */
        @TableField(value = "sort")
                private Integer sort;
                                /**
         * 树路径
         */
        @TableField(value = "path")
                private String path;
                                                                                            
}
