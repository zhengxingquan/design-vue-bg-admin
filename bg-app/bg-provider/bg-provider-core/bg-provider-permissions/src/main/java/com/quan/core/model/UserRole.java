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
 * 用户与角色
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:23:48
 */

@Getter
@Setter
@Data
@TableName("sys_user_role")
public class UserRole extends BaseEntity{

private static final long serialVersionUID=1L;

                    /**
         * 用户ID
         */
        @TableField(value = "user_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long userId;
                                /**
         * 角色ID
         */
        @TableField(value = "role_id")
                @JsonSerialize(using = ToStringSerializer.class)
                private Long roleId;
            
}