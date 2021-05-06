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
 * 用户组与角色
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */

@Getter
@Setter
@Data
@TableName("sys_user_group_role")
public class UserGroupRole extends BaseEntity{

private static final long serialVersionUID=1L;

                    /**
         * 用户组ID
         */
        @TableField(value = "user_group_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long userGroupId;
                                /**
         * 角色ID
         */
        @TableField(value = "role_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long roleId;
            
}
