package com.quan.core.event;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 *
 * 事件执行器  ，有子类具体的实现
 */
public interface IEventHandle <T extends IEvent> extends IEventExecAdapter {

    /**
     * 事件类型
     *
     * @return
     */
    Class<T> eventClass();

    /**
     * 错误处理
     *
     * @param event 事件消息
     * @param e     错误
     */
    void exceptionHandle(T event, Exception e);
}