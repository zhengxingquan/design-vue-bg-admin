package com.quan.core.event.sync;

import com.quan.core.event.IEvent;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述： 异步事件 类型
 */
public interface IAsyncEvent extends IEvent {

    /**
     * 获取事件类型
     *
     * @return 事件类型
     */
    IAsyncEventType eventType();
}
