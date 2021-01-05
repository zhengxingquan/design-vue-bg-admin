package com.quan.core.event.sync;

import com.quan.core.enums.AsyncEventGroupType;
import com.quan.core.event.IEventType;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
public interface IAsyncEventType extends IEventType {

    /**
     * 队列类型
     *
     * @return 队列类型
     */
    AsyncEventGroupType getQueueType();


    /**
     * 获取事件码
     *
     * @return 事件码
     */
    default int getCode() {
        return getQueueType().getCode() + getType();
    }
}
