package com.quan.core.controller.request.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;

/**
 * 角色组与菜单组 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:58:57
 */

@Getter
@Setter
@Data
@ApiModel
public class RoleGroupMenuGroupCreateRequest {


            /**
    * 角色组ID
    */
    @ApiModelProperty(value = "角色组ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long roleGroupId;
        
            /**
    * 菜单组ID
    */
    @ApiModelProperty(value = "菜单组ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long menuGroupId;
        
}
