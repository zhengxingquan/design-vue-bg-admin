package com.quan.core.rabbitmq.producer;


import com.quan.core.rabbitmq.common.DetailResponse;

public interface MessageProcess<T> {
    DetailResponse process(T message);
}
