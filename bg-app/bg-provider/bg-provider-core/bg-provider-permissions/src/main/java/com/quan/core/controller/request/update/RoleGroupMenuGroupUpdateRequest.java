package com.quan.core.controller.request.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色组与菜单组 编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 18:58:57
 */

@Getter
@Setter
@Data
@ApiModel
public class RoleGroupMenuGroupUpdateRequest {

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
