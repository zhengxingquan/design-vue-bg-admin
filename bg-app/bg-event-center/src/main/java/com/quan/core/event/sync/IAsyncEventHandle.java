package com.quan.core.event.sync;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述： 异步任务处理器
 */
public interface IAsyncEventHandle<T extends IAsyncEvent> {
    /**
     * 处理的事件
     *
     * @return 事件类型
     */
    IAsyncEventType getType();

    /**
     * 处理
     *
     * @param event 事件
     * @return 输出
     */
    void handle(T event);

    /**
     * 错误处理
     *
     * @param event 事件消息
     * @param e     错误
     */
    void exceptionHandle(T event, Exception e);