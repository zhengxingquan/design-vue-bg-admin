package com.quan.redis.util;

 
public interface RedisSubscribeCallback {
    void callback(String msg);
}
