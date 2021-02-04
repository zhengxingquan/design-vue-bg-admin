package com.quan.core.controller.request.token;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
@Data
public class ValidCodeTokenRequest {


    @ApiModelProperty("手机号")
    private String deviceId;

    @ApiModelProperty("验证码")
    private String validCode;
}
