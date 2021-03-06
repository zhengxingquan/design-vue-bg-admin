package com.quan.core.controller.request.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户与角色组 编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:23:48
 */

@Getter
@Setter
@Data
@ApiModel
public class UserRoleGroupUpdateRequest {

        /**
    * 用户ID
    */
        @ApiModelProperty(value = "用户ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long userId;
            /**
    * 角色组ID
    */
        @ApiModelProperty(value = "角色组ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long roleGroupId;
    
}
