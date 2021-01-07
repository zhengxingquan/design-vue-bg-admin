package com.quan.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统角色分组与角色对应表 查询DTO
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:21:41
 */

@Getter
@Setter
@Data
public class RoleGroupDetailsQueryDTO {

    /**
     * 角色ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

}
