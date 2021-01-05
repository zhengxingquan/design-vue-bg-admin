package com.quan.core.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quan.core.event.sync.IAsyncEvent;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述： 用于 子类实现
 */
public abstract class BaseAsyncEvent implements IAsyncEvent {

    /**
     * 事件编码
     */
    protected String eventCode;

    @JsonProperty("eventTypeCode")
    public Integer getEventTypeCode() {
        return eventType().getCode();
    }

    @Override
    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
}
