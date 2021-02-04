package com.quan.core.controller.request.token.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
@Data
public class ClientUpdateStateRequest {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "状态 启用 0 禁用 -1 删除 1 ")
    private Integer state;
}
