package com.quan.core.api.impl;

import com.quan.core.api.WxApi2;
import com.quan.core.session.WxSessionManager;
import com.quan.core.session.memory.MemorySessionManager;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public abstract class AbstractLightWx extends AbstractWxHandler {

    protected WxApi2 api;

    protected WxSessionManager sessionManager;

    public AbstractLightWx() {
        api = new WxApi2Impl();
        sessionManager = new MemorySessionManager();
    }
}
