package com.quan.core.producer;

import com.quan.core.common.DetailResponse;

public interface MessageProducer {

    DetailResponse send(Object message);

}