package com.quan.core.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 角色组与菜单 禁用请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:43:42
 */

@Getter
@Setter
@Data
@ApiModel
public class RoleGroupMenuDisableRequest {

    @ApiModelProperty("记录ID编号")
    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

}
