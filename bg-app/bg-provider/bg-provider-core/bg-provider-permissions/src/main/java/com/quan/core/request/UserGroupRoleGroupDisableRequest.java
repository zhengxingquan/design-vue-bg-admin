package com.quan.core.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 用户组与角色组 禁用请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */

@Getter
@Setter
@Data
@ApiModel
public class UserGroupRoleGroupDisableRequest {

    @ApiModelProperty("记录ID编号")
    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

}
