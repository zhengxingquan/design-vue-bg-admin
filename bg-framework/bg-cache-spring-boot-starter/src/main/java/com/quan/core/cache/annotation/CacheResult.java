package com.quan.core.cache.annotation;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 *
 * 缓存结果
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheResult {
    /***
     * 缓存的名称
     */
    String cacheName() default "";

    /***
     * 缓存的具体KEY
     */
    String cacheKey() default "";

    /***
     * 缓存的时间
     */
    long cacheLiveTime() default 0;

}
