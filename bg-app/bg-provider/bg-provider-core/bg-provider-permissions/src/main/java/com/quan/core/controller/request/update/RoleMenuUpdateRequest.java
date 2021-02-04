package com.quan.core.controller.request.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *  编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 19:08:40
 */

@Getter
@Setter
@Data
@ApiModel
public class RoleMenuUpdateRequest {

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
