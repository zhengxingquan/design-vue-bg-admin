package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户组与角色 查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */

@Getter
@Setter
@Data
public class UserGroupRoleQueryDTO {

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
