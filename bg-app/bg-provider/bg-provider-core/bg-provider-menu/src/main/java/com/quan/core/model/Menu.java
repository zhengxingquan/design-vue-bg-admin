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
 * 系统菜单表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 17:50:17
 */

@Getter
@Setter
@Data
@TableName("sys_menu")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父级ID
     */
    @TableField(value = "parent_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;
    /**
     * 菜单名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 菜单别名
     */
    @TableField(value = "alias_name")
    private String aliasName;
    /**
     *
     */
    @TableField(value = "code")
    private String code;
    /**
     * 树路径
     */
    @TableField(value = "path")
    private String path;
    /**
     * 资源类型(0 资源对象 1 菜单对象)
     */
    @TableField(value = "type")
    private Integer type;
    /**
     * 菜单链接
     */
    @TableField(value = "href")
    private String href;
    /**
     * 打开方式
     */
    @TableField(value = "target")
    private String target;
    /**
     * 菜单图标
     */
    @TableField(value = "menu_icon")
    private String menuIcon;
    /**
     * 权限标识
     */
    @TableField(value = "permission")
    private String permission;
    /**
     * 菜单介绍
     */
    @TableField(value = "note")
    private String note;
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
