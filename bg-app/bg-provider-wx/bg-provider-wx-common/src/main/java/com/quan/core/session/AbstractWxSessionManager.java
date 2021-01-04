package com.quan.core.session;

import com.quan.core.model.WxInMsg;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public abstract class AbstractWxSessionManager implements WxSessionManager {

    @Override
    public WxSession getSession(String id) {
        return getSession(id, true);
    }
    @Override
    public WxSession getSession(WxInMsg msg) {
        return getSession(msg, true);
    }
    @Override
    public WxSession getSession(WxInMsg msg, boolean create) {
        return getSession(msg.getFromUserName(), create);
    }


}
