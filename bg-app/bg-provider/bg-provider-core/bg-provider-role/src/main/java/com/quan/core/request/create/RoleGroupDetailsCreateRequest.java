package com.quan.core.request.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统角色分组与角色对应表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:21:41
 */

@Getter
@Setter
@Data
public class RoleGroupDetailsCreateRequest {


    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    /**
     * 角色分组ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleGroupId;

}
