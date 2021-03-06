package com.quan.core.controller.request.del;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotNull;

/**
 * 用户组与角色组 删除请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:18:17
 */

@Getter
@Setter
@Data
@ApiModel
public class UserGroupRoleGroupDeleteRequest {

    @ApiModelProperty("删除id")
    @NotNull
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

}
