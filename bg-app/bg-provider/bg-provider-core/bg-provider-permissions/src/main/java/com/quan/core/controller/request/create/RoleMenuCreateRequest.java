package com.quan.core.controller.request.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;

/**
 *  创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */

@Getter
@Setter
@Data
@ApiModel
public class RoleMenuCreateRequest {


            /**
    * 角色ID
    */
    @ApiModelProperty(value = "角色ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long roleId;
        
            /**
    * 菜单ID
    */
    @ApiModelProperty(value = "菜单ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long menuId;
        
}
