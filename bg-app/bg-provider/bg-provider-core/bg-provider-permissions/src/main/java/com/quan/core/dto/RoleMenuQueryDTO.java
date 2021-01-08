package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *  查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */

@Getter
@Setter
@Data
public class RoleMenuQueryDTO {

        /**
    * 角色ID
    */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long roleId;
            /**
    * 菜单ID
    */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long menuId;
    
}
