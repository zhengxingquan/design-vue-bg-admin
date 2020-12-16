package com.quan.plugins.cache.annotation;

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
public @interface CacheDefaults {

    /***
     * 缓存的名称
     */
    String cacheName() default "bg";

    /***
     * 缓存的时间
     */
    int cacheLiveTime() default 0;
}
