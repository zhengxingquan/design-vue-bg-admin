package com.quan.core.dto.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色组与菜单 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:43:42
 */

@Getter
@Setter
@Data
public class RoleGroupMenuCreateDTO {

    /**
     * 角色组ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long roleGroupId;
    /**
     * 菜单ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long menuId;

}
