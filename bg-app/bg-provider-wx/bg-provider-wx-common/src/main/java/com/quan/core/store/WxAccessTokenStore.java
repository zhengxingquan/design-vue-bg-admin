package com.quan.core.store;


import com.quan.core.bean.*;
/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxAccessTokenStore {

    WxAccessToken get();

    void save(String token, int expires, long lastCacheTimeMillis);
}
