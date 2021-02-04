package com.quan.core.controller.request.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 系统单位表 编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-31 15:39:39
 */

@Getter
@Setter
@Data
public class UnitUpdateRequest {

        /**
    * ID
    */
        @NotNull
        @ApiModelProperty(value = "ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long id;
            /**
    * 父级ID
    */
        @ApiModelProperty(value = "父级ID")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long parentId;
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
    * 单位介绍
    */
        @ApiModelProperty(value = "单位介绍")
        private String note;
                                
}
