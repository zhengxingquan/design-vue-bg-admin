package com.quan.core.common.constant;

/***
 * 认证常量
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/25 14:35
 */
public interface OAuthConstant {

    /**
     * 缓存client的redis key，这里是hash结构存储
     */
    String CACHE_CLIENT_KEY = "oauth_client_details";

    String TOKEN_PARAM = "access_token";

    String TOKEN_HEADER = "accessToken";

    String AUTH = "auth";

    String TOKEN = "token";

    String AUTHORIZATION = "Authorization";

}
