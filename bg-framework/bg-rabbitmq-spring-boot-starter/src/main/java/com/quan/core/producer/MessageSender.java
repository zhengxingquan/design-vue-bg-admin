package com.quan.core.producer;

import com.quan.core.common.DetailResponse;

public interface MessageSender {


    DetailResponse send(Object message);

    DetailResponse send(MessageWithTime messageWithTime);
}