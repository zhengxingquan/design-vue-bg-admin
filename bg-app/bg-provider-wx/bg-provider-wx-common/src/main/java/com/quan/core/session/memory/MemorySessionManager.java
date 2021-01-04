package com.quan.core.session.memory;

import com.quan.core.model.WxInMsg;
import com.quan.core.session.AbstractWxSessionManager;
import com.quan.core.session.WxSession;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public class MemorySessionManager extends AbstractWxSessionManager {

    /**
     * 默认超时为2天
     */
    public static long DEF_TIMEOUT = 2*24*60;

    protected ConcurrentHashMap<String, MemoryWxSession> sessions = new ConcurrentHashMap<String, MemoryWxSession>();

    @Override
    public WxSession getSession(String id, boolean create) {
        String sessionId = id;
        MemoryWxSession session = sessions.get(sessionId);
        if (session != null) {
            int maxInterval = session.getMaxInactiveInterval();
            // 永不过期
            if (maxInterval < 1) {
                return session;
            }
            long interval = (System.currentTimeMillis() - session.getLastAccessedTime()) / 1000 / 60;
            if (maxInterval > interval) {
                session.setLastAccessedTime(System.currentTimeMillis());
                return session;
            }
            session = null;
        }
        synchronized (sessions) {
            session = sessions.get(sessionId);
            if (session == null) {
                session = new MemoryWxSession(sessionId, this);
                session.setCreateTime(System.currentTimeMillis());
                session.setLastAccessedTime(System.currentTimeMillis());
                sessions.put(sessionId, session);
                return session;
            }
        }
        return session;
    }

    @Override
    public WxSession remove(String id) {
        return sessions.remove(id);
    }
}
