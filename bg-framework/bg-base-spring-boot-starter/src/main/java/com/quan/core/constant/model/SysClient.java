package com.quan.core.constant.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.quan.core.constant.auth.details.DefaultClientDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/***
 *   应用实体
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/15 16:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysClient extends BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -8185413579135897885L;

    private String clientId;
    private String clientSecret;
    private String clientSecretStr;
    private String scope = "all";
    private String resourceIds = "";
    private String authorizedGrantTypes = "authorization_code,password,refresh_token,client_credentials";
    private String webServerRedirectUri;
    private String authorities = "";
    private Integer accessTokenValidity = 18000;
    private Integer refreshTokenValidity = 18000;
    private String additionalInformation = "{}";
    private String autoapprove = "true";
    private Boolean status;
    private Integer ifLimit;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long limitCount = 10000L;
    private List<Long> permissionIds;
    private Set<Long> serviceIds;

    public DefaultClientDetails map() {
        DefaultClientDetails defaultClientDetails = new DefaultClientDetails(this.clientId, this.resourceIds, this.scope, this.authorizedGrantTypes, this.authorities, this.webServerRedirectUri);
        defaultClientDetails.setId(getId());
        defaultClientDetails.setClientSecret(this.clientSecret);
        defaultClientDetails.setAccessTokenValiditySeconds(this.accessTokenValidity);
        defaultClientDetails.setRefreshTokenValiditySeconds(this.refreshTokenValidity);
        defaultClientDetails.setAutoApproveScopes(StringUtils.commaDelimitedListToSet(this.scope));
        defaultClientDetails.setIfLimit(this.ifLimit);
        defaultClientDetails.setLimitCount(this.limitCount);
        return defaultClientDetails;
    }
}
