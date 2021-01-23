package com.quan.core.session;

import com.quan.core.model.WxInMsg;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 * <p>
 * 微信会话管理器
 */
public interface WxSessionManager {

    WxSession getSession(String id);

    WxSession getSession(String id, boolean create);

    WxSession getSession(WxInMsg msg);

    WxSession getSession(WxInMsg msg, boolean create);

    WxSession remove(String id);
}
