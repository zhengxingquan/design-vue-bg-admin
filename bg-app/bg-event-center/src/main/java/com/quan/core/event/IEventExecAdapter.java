package com.quan.core.event;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
public interface IEventExecAdapter<T extends IEvent> {

    /**
     * 处理
     *
     * @param event 事件
     * @return 输出
     */
    void handle(T event);
}
