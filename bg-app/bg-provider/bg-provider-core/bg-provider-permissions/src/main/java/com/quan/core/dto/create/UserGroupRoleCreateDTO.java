package com.quan.core.dto.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户组与角色 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */

@Getter
@Setter
@Data
public class UserGroupRoleCreateDTO {

    /**
     * 用户组ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long userGroupId;
    /**
     * 角色ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long roleId;

}
