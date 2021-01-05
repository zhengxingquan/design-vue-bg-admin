package com.quan.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 */
@Component
@Data
public class EventThreadConfig {

    @Value(value = "${com.quan.event.executor.coreSize:1}")
    private Integer coreSize;
    @Value(value = "${com.quan.event.executor.maxSize:5}")
    private Integer maxSize;
    @Value(value = "${com.quan.event.executor.keepAlive:60}")
    private Integer keepAlive;
    /**
     * 无任务时的睡眠事件
     */
    @Value(value = "${com.quan.event.executor.sleepTime:1000}")
    private Integer sleepTime;
}
