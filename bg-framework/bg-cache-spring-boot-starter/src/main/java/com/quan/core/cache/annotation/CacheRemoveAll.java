package com.quan.core.cache.annotation;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 *
 * 删除全部
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheRemoveAll {
    /***
     * 缓存的名称
     */
    String cacheName() default "";
}
