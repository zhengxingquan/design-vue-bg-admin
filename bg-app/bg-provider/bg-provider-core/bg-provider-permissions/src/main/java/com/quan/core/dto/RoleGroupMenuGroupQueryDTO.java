package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色组与菜单组 查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:58:57
 */

@Getter
@Setter
@Data
public class RoleGroupMenuGroupQueryDTO {

        /**
    * 角色组ID
    */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long roleGroupId;
            /**
    * 菜单组ID
    */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long menuGroupId;
    
}
