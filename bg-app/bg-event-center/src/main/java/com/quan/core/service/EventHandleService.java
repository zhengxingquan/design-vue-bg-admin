package com.quan.core.service;

import com.quan.core.adapater.AsyncQueueAdapter;
import com.quan.core.adapater.EventHandleAdapter;
import com.quan.core.event.IEvent;
import com.quan.core.event.sync.IAsyncEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
@Component
public class EventHandleService {

    @Autowired
    private EventHandleAdapter eventHandleAdapter;
    @Autowired
    private AsyncQueueAdapter asyncQueueAdapter;

    public <T extends IEvent> void handle(T event) {
        eventHandleAdapter.handle(event);
    }

    public <T extends IAsyncEvent> void handle(T event) {
        asyncQueueAdapter.add(event);
    }
}
