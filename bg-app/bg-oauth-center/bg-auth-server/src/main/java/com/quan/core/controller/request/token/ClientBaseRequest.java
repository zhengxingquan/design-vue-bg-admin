package com.quan.core.controller.request.token;

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
public class ClientBaseRequest {

    @ApiModelProperty(value = "应用名称")
    @JsonSerialize(using = ToStringSerializer.class)
    private String clientId;

    @ApiModelProperty(value = "应用密钥(明文)")
    private String clientSecretStr;

    @ApiModelProperty(value = "范围")
    private String scope = "all";

    @ApiModelProperty(value = "资源限定串(逗号分割)")
    private String resourceIds;

    @ApiModelProperty(value = "5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)")
    private String authorizedGrantTypes;

    @ApiModelProperty(value = "回调地址")
    private String webServerRedirectUri;

    @ApiModelProperty(value = "权限")
    private String authorities;

    @ApiModelProperty(value = "access_token有效期")
    private Integer accessTokenValidity = 18000;

    @ApiModelProperty(value = "refresh_token有效期")
    private Integer refreshTokenValidity = 18000;

    @ApiModelProperty(value = "是否自动授权")
    private String autoapprove = "true";

    @ApiModelProperty(value = "是否自动授权")
    private Boolean status;

    @ApiModelProperty(value = "是否应用限流")
    private boolean ifLimit;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "限流阈值")
    private Long limitCount = 10000L;
}
