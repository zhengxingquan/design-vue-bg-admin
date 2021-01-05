package com.quan.core.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.common.model.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * 系统字典表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 16:01:09
 */

@Getter
@Setter
@Data
@TableName("sys_dict")
public class Dict extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父级ID
     */
    @TableField(value = "parent_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;
    /**
     * 树路径
     */
    @TableField(value = "path")
    private String path;
    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 编码
     */
    @TableField(value = "code")
    private String code;
    /**
     * 系统编码(用于查询使用，全局唯一)
     */
    @TableField(value = "sys_code")
    private String sysCode;
    /**
     * 有子节点
     */
    @TableField(value = "has_children")
    private Integer hasChildren;
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
     * 字典简介
     */
    @TableField(value = "note")
    private String note;
    /**
     * 排序字段
     */
    @TableField(value = "sort")
    private Integer sort;

}
