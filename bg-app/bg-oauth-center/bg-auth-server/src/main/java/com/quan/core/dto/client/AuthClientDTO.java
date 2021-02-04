package com.quan.core.dto.client;

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
public class AuthClientDTO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /***
     * 应用标识
     */
    @ApiModelProperty("应用标识")
    private String clientId;

    /***
     * 应用密钥(密文)
     */
    @ApiModelProperty("应用密钥(密文)")
    private String clientSecret;

    /***
     * 应用密钥(明文)
     */
    @ApiModelProperty("应用密钥(明文)")
    private String clientSecretStr;

    /***
     * 范围
     */
    @ApiModelProperty("范围")
    private String scope = "all";

    /***
     * 资源限定串(逗号分割)
     */
    @ApiModelProperty("资源限定串(逗号分割)")
    private String resourceIds;

    /***
     * 5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)
     */
    @ApiModelProperty("authorizedGrantTypes")
    private String authorizedGrantTypes;

    /***
     * 回调地址
     */
    @ApiModelProperty("回调地址")
    private String webServerRedirectUri;

    /****
     * 权限
     */
    @ApiModelProperty("权限")
    private String authorities;

    /***
     * access_token有效期
     */
    @ApiModelProperty("access_token有效期")
    private Integer accessTokenValidity = 18000;

    /***
     * refresh_token有效期
     */
    @ApiModelProperty("refresh_token有效期")
    private Integer refreshTokenValidity = 18000;

    /***
     * 是否自动授权
     */
    @ApiModelProperty("是否自动授权")
    private String autoapprove = "true";

    /***
     * 是否应用限流
     */
    @ApiModelProperty("是否应用限流")
    private Boolean ifLimit;

    /***
     * 限流阈值
     */
    @ApiModelProperty("限流阈值")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long limitCount = 10000L;
}
