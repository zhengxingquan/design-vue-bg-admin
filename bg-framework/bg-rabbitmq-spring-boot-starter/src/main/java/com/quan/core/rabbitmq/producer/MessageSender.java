package com.quan.core.rabbitmq.producer;

import com.quan.core.rabbitmq.common.DetailResponse;

public interface MessageSender {


    DetailResponse send(Object message);

    DetailResponse send(MessageWithTime messageWithTime);
}