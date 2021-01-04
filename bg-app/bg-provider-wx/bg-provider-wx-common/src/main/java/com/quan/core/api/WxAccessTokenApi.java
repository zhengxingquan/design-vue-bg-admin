package com.quan.core.api;

import com.quan.core.store.WxAccessTokenStore;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxAccessTokenApi {

    void setAccessTokenStore(WxAccessTokenStore ats);

    WxAccessTokenStore getAccessTokenStore();

    String getAccessToken();
}
