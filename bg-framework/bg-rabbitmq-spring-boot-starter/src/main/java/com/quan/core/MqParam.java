package com.quan.core;

import com.quan.core.constant.MqExchangeTypes;
import lombok.Builder;
import lombok.Data;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/4/30
 * 描述：
 */
@Data
@Builder
public class MqParam {
    /***
     * 交换器名称
     */
    private String exchange;
    /***
     * 路由KEY名称
     */
    private String routingKey;
    /***
     * 队列名称
     */
    private String queue;
    /***
     * 交换器类型
     */
    private MqExchangeTypes type;
}
