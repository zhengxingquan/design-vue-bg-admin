package com.quan.core.unit.request.create;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 系统单位表 创建请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-22 19:04:56
 */

@Getter
@Setter
@Data
public class UnitCreateRequest {


    
            /**
    * 父级ID
    */
    @ApiModelProperty(value = "父级ID")
    private String parentId;
        
            /**
    * 单位名称
    */
    @ApiModelProperty(value = "单位名称")
    private String name;
        
            /**
    * 单位别名
    */
    @ApiModelProperty(value = "单位别名")
    private String aliasName;
        
            /**
    * 机构编码
    */
    @ApiModelProperty(value = "机构编码")
    private String unitCode;
        
            /**
    * 单位介绍
    */
    @ApiModelProperty(value = "单位介绍")
    private String note;
        
            /**
    * 附加值一
    */
    @ApiModelProperty(value = "附加值一")
    private String field1;
        
            /**
    * 附加值二
    */
    @ApiModelProperty(value = "附加值二")
    private String field2;
        
            /**
    * 附加值三
    */
    @ApiModelProperty(value = "附加值三")
    private String field3;
        
            /**
    * 排序字段
    */
    @ApiModelProperty(value = "排序字段")
    private Integer sort;
        
            /**
    * 是否禁用
    */
    @ApiModelProperty(value = "是否禁用")
    private Integer disabled;
        
            /**
    * 是否有子节点
    */
    @ApiModelProperty(value = "是否有子节点")
    private Integer hasChildren;
        
            /**
    * 单位logo
    */
    @ApiModelProperty(value = "单位logo")
    private String logo;
        
            
            /**
    * 创建人员ID
    */
    @ApiModelProperty(value = "创建人员ID")
    private Long createUserId;
        
            
            
            
}
