package com.quan.core.session;

import java.util.Enumeration;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 *
 * 微信会话  // 考虑继承HttpSession啦
 */
public interface WxSession {

    String getId();
    long getCreationTime();
    Object getAttribute(String name);
    void setAttribute(String name, Object value);
    Enumeration<String> getAttributeNames();
    long getLastAccessedTime();

    void setMaxInactiveInterval(int interval);
    int getMaxInactiveInterval();

    void invalidate();
}
