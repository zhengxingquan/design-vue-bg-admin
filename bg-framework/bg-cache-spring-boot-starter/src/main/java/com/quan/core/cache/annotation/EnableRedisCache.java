package com.quan.core.cache.annotation;

import com.quan.core.cache.constant.CacheType;
import com.quan.core.cache.selector.CacheImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：redis 缓存开启
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CacheImportSelector.class)
public @interface EnableRedisCache {

    /***
     * 缓存名称的前缀
     */
    String cacheNamePrefix() default "redis:";

    /***
     * 缓存的时间
     */
    int cacheLiveTime() default 0;

    /***
     *  缓存介质
     */
    CacheType model() default CacheType.REDIS;
}
