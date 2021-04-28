package com.quan.core.common;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/4/28
 * 描述：
 */
public enum MqExchangeTypes {

    MQ_FANOUT("fanout"),
    MQ_DIRECT("direct"),
    MQ_TOPIC("topic"),
    MQ_HEADERS("headers");

    private String value;

    MqExchangeTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
