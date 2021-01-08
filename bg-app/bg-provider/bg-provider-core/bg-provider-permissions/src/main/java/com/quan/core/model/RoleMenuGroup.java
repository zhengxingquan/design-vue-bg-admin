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
 * 角色与菜单组
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */

@Getter
@Setter
@Data
@TableName("sys_role_menu_group")
public class RoleMenuGroup extends BaseEntity{

private static final long serialVersionUID=1L;

                    /**
         * 角色ID
         */
        @TableField(value = "role_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long roleId;
                                /**
         * 菜单组ID
         */
        @TableField(value = "menu_group_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long menuGroupId;
            
}
