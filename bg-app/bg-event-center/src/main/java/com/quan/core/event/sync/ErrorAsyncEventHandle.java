package com.quan.core.event.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述： 默认的 异步处理事件处理器
 */
@Slf4j
public class ErrorAsyncEventHandle implements IAsyncEventHandle {
    @Override
    public IAsyncEventType getType() {
        return null;
    }

    @Override
    public void handle(IAsyncEvent event) {
        log.info("no found handle");
    }

    @Override
    public void exceptionHandle(IAsyncEvent event, Exception e) {
        log.error("no found eventHandle,msg is " + e, e);
    }
}
