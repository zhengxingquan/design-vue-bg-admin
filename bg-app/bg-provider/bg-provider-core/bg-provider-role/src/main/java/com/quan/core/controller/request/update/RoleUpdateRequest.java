package com.quan.core.controller.request.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 系统角色表 编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-30 17:42:13
 */

@Getter
@Setter
@Data
public class RoleUpdateRequest {

        /**
    * 主键ID
    */
        @NotNull
        @ApiModelProperty(value = "主键ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long id;
            /**
    * 父节点
    */
        @ApiModelProperty(value = "父节点")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
            /**
    * 角色名称
    */
        @ApiModelProperty(value = "角色名称")
        private String name;
            /**
    * 角色编码
    */
        @ApiModelProperty(value = "角色编码")
        private String code;
            /**
    * 角色别名
    */
        @ApiModelProperty(value = "角色别名")
        private String aliasName;
                    /**
    * 备注
    */
        @ApiModelProperty(value = "备注")
        private String note;
                            
}
