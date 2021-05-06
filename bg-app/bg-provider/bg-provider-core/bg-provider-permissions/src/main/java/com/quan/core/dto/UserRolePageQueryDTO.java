package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.constant.dto.query.PageQueryDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户与角色 分页查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:23:48
 */

@Getter
@Setter
@Data
public class UserRolePageQueryDTO extends PageQueryDTO {

        /**
     * 用户ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long userId;
            /**
     * 角色ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long roleId;
    
}
