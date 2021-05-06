package com.quan.core.constant.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/***
 **
  * 非网关应用限流
  * @author zxq(956607644@qq.com)
  * @date 2020/12/30 11:10
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface AccessLimit {
    /***
     * redis 时间戳
     */
    int seconds();

    /***
     * 最大次数
     */
    int maxCount();

    /***
     * 是否需要登录
     */
    boolean needLogin() default true;
}
