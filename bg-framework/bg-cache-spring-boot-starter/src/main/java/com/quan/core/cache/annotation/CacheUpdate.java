package com.quan.core.cache.annotation;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheUpdate {
    /***
     * 缓存的名称
     */
    String cacheName() default "bg";

    /***
     * 缓存的具体KEY
     */
    String cacheKey() default "";

    /***
     * 缓存的时间
     */
    int cacheLiveTime() default 0;
}
