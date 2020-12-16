package com.quan.common.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Data
public class ResponsePage2 implements Serializable {

    @ApiModelProperty(value = "要查询的起始页码")
    private int pageNumber = 0;
    @ApiModelProperty(value = "每页显示数量")
    private int pageSize = 10;
    @ApiModelProperty(value = "成功的状态码")
    private int code = 0;
    @ApiModelProperty(value = "错误消息")
    private String msg;
    @ApiModelProperty(value = "总结果数")
    private int count;
}
