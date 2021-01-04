package com.quan.core.store.impl;

import com.quan.core.bean.*;
import com.quan.core.store.WxJsapiTicketStore;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class MemoryJsapiTicketStore implements WxJsapiTicketStore {

    WxJsapiTicket jt;

    @Override
    public WxJsapiTicket get() {
        return jt;
    }

    @Override
    public void save(String ticket, int expires, long lastCacheTimeMillis) {
        jt = new WxJsapiTicket(ticket, expires, lastCacheTimeMillis);
    }
}
