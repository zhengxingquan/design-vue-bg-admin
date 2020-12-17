package com.quan.plugins.cache.aop;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
public abstract class BaseCacheAop {

    protected String getRedisKey(String cacheName) {
        return cacheName + ":";
    }

}
