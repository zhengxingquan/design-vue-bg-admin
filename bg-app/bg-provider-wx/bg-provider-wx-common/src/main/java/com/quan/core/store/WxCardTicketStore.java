package com.quan.core.store;

import com.quan.core.bean.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxCardTicketStore {

    WxCardTicket get();

    void save(String ticket, int expires, long lastCacheTimeMillis);

}
