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
 * 角色组与菜单
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:43:42
 */

@Getter
@Setter
@Data
@TableName("sys_role_group_menu")
public class RoleGroupMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色组ID
     */
    @TableField(value = "role_group_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleGroupId;
    /**
     * 菜单ID
     */
    @TableField(value = "menu_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;

}
