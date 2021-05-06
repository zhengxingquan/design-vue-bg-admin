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
 * 系统单位表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-31 15:39:39
 */

@Getter
@Setter
@Data
@TableName("sys_unit")
public class Unit extends BaseEntity{

private static final long serialVersionUID=1L;

                            /**
         * 父级ID
         */
        @TableField(value = "parent_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long parentId;
                                /**
         * 单位名称
         */
        @TableField(value = "name")
                private String name;
                                /**
         * 单位别名
         */
        @TableField(value = "alias_name")
                private String aliasName;
                                /**
         * 机构编码
         */
        @TableField(value = "unit_code")
                private String unitCode;
                                /**
         * 路径
         */
        @TableField(value = "path")
                private String path;
                                /**
         * 附加值一
         */
        @TableField(value = "field1")
                private String field1;
                                /**
         * 附加值二
         */
        @TableField(value = "field2")
                private String field2;
                                /**
         * 附加值三
         */
        @TableField(value = "field3")
                private String field3;
                                /**
         * 单位介绍
         */
        @TableField(value = "note")
                private String note;
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
