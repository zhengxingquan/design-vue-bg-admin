package com.quan.core.store.impl;

import com.quan.core.bean.*;
import com.quan.core.store.WxCardTicketStore;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class MemoryCardTicketStore implements WxCardTicketStore {

    private WxCardTicket ct;

    @Override
    public WxCardTicket get() {
        return ct;
    }

    @Override
    public void save(String ticket, int expires, long lastCacheTimeMillis) {
        ct = new WxCardTicket(ticket, expires, lastCacheTimeMillis);
    }

}
