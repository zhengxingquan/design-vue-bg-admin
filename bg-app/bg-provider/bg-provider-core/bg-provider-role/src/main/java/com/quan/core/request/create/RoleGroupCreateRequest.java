package com.quan.core.request.create;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 系统角色分组表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 20:07:02
 */

@Getter
@Setter
@Data
public class RoleGroupCreateRequest {


    
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
        private String groupName;
        
            /**
    * 角色编码
    */
    @ApiModelProperty(value = "角色编码")
        private String groupCode;
        
            /**
    * 角色别名
    */
    @ApiModelProperty(value = "角色别名")
        private String groupAliasName;
        
            
            
            /**
    * 备注
    */
    @ApiModelProperty(value = "备注")
        private String note;
        
            
            
            
            
            
            
}
