package com.quan.core.request.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;

/**
 * 用户与角色组 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:23:48
 */

@Getter
@Setter
@Data
@ApiModel
public class UserRoleGroupCreateRequest {


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
