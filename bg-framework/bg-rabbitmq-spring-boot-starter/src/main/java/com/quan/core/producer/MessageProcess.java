package com.quan.core.producer;


import com.quan.core.common.DetailResponse;

public interface MessageProcess<T> {
    DetailResponse process(T message);
}
