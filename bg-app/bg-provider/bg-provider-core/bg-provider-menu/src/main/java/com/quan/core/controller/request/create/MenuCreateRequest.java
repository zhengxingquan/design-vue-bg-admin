package com.quan.core.controller.request.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;

/**
 * 系统菜单表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 17:50:17
 */

@Getter
@Setter
@Data
public class MenuCreateRequest {


    
            /**
    * 父级ID
    */
    @ApiModelProperty(value = "父级ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
        
            /**
    * 菜单名称
    */
    @ApiModelProperty(value = "菜单名称")
        private String name;
        
            /**
    * 菜单别名
    */
    @ApiModelProperty(value = "菜单别名")
        private String aliasName;
        
            /**
    * 
    */
    @ApiModelProperty(value = "")
        private String code;
        
            
            /**
    * 资源类型(0 资源对象 1 菜单对象)
    */
    @ApiModelProperty(value = "资源类型(0 资源对象 1 菜单对象)")
        private Integer type;
        
            /**
    * 菜单链接
    */
    @ApiModelProperty(value = "菜单链接")
        private String href;
        
            /**
    * 打开方式
    */
    @ApiModelProperty(value = "打开方式")
        private String target;
        
            /**
    * 菜单图标
    */
    @ApiModelProperty(value = "菜单图标")
        private String menuIcon;
        
            /**
    * 权限标识
    */
    @ApiModelProperty(value = "权限标识")
        private String permission;
        
            /**
    * 菜单介绍
    */
    @ApiModelProperty(value = "菜单介绍")
        private String note;
        
            
            
            
            
            
            
            
}
