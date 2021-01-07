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
 * 系统角色分组表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:07:02
 */

@Getter
@Setter
@Data
@TableName("sys_role_group")
public class RoleGroup extends BaseEntity {

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
    @TableField(value = "group_name")
    private String groupName;
    /**
     * 角色编码
     */
    @TableField(value = "group_code")
    private String groupCode;
    /**
     * 角色别名
     */
    @TableField(value = "group_alias_name")
    private String groupAliasName;
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
