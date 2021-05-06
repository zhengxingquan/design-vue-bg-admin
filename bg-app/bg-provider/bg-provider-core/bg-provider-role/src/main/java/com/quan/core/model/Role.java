package com.quan.core.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.constant.model.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * 系统角色表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-30 17:42:13
 */

@Getter
@Setter
@Data
@TableName("sys_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父节点
     */
    @TableField(value = "parent_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;
    /**
     * 角色名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 角色编码
     */
    @TableField(value = "code")
    private String code;
    /**
     * 角色别名
     */
    @TableField(value = "alias_name")
    private String aliasName;
    /**
     * 是否有子节点
     */
    @TableField(value = "has_children")
    private Integer hasChildren;
    /**
     * 路径编码用于查询与删除
     */
    @TableField(value = "path")
    private String path;
    /**
     * 备注
     */
    @TableField(value = "note")
    private String note;
    /**
     * 排序字段
     */
    @TableField(value = "sort")
    private Integer sort;

}
