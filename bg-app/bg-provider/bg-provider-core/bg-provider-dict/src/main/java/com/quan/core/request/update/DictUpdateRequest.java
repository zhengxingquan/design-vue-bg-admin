package com.quan.core.request.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 系统字典表 编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-05 16:01:09
 */

@Getter
@Setter
@Data
public class DictUpdateRequest {

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
    * 名称
    */
        @ApiModelProperty(value = "名称")
        private String name;
            /**
    * 编码
    */
        @ApiModelProperty(value = "编码")
        private String code;
            /**
    * 系统编码(用于查询使用，全局唯一)
    */
        @ApiModelProperty(value = "系统编码(用于查询使用，全局唯一)")
        private String sysCode;
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
    * 字典简介
    */
        @ApiModelProperty(value = "字典简介")
        private String note;
                            
}
