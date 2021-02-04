package com.quan.core.controller.request.token.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/4
 * 描述：
 */
@Data
public class UserTokenRequest {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;
}
