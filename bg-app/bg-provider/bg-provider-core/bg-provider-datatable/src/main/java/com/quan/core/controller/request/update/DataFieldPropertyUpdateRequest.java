package com.quan.core.controller.request.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 系统字段属性表 编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 23:19:31
 */

@Getter
@Setter
@Data
public class DataFieldPropertyUpdateRequest {

        /**
    * ID
    */
        @NotNull
        @ApiModelProperty(value = "ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long id;
            /**
    * 父节点
    */
        @ApiModelProperty(value = "父节点")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
            /**
    * 名称
    */
        @ApiModelProperty(value = "名称")
        private String name;
            /**
    * 
    */
        @ApiModelProperty(value = "")
        private String code;
            /**
    * 系统编码(用于查询使用，全局唯一)
    */
        @ApiModelProperty(value = "系统编码(用于查询使用，全局唯一)")
        private String sysCode;
            /**
    * 数据库中数据类型
    */
        @ApiModelProperty(value = "数据库中数据类型")
        private String dbFieldType;
            /**
    * 简介
    */
        @ApiModelProperty(value = "简介")
        private String note;
                                    
}
