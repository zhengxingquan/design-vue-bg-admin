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
 * @date 2021-01-05 18:42:13
 */

@Getter
@Setter
@Data
public class MenuGroupCreateRequest {


    
            /**
    * 父级ID
    */
    @ApiModelProperty(value = "父级ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
        
            /**
    * 组名称
    */
    @ApiModelProperty(value = "组名称")
        private String groupName;
        
            /**
    * 组别名
    */
    @ApiModelProperty(value = "组别名")
        private String groupAliasName;
        
            /**
    * 编码
    */
    @ApiModelProperty(value = "编码")
        private String groupCode;
        
            
            /**
    * 菜单介绍
    */
    @ApiModelProperty(value = "菜单介绍")
        private String note;
        
            
            
            
            
            
            
            
}
