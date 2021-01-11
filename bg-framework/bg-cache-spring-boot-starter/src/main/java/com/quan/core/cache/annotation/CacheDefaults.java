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
public @interface CacheDefaults {

    /***
     * 缓存的名称
     */
    String cacheName() default "bg";

    /***
     * 缓存的时间 默认缓存 5 分钟
     */
    int cacheLiveTime() default 5 * 60;
}
