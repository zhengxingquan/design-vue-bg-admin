package com.quan.core.event;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 *
 * 事件抽象
 */
public interface IEvent {

    /**
     * 获取事件编码
     *
     * @return 唯一码用于标识事件
     */
    String getEventCode();
}
