package com.quan.core.store.impl;

import com.quan.core.store.WxAccessTokenStore;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
@Slf4j
public class MemoryAccessTokenStore implements WxAccessTokenStore {

    WxAccessToken at;

    @Override
    public WxAccessToken get() {
        return at;
    }

    @Override
    public void save(String token, int time, long lastCacheTimeMillis) {
        at = new WxAccessToken();
        at.setToken(token);
        at.setExpires(time);
        at.setLastCacheTimeMillis(lastCacheTimeMillis);
        log.debug("new wx access token generated : {} ",at );
    }
}
