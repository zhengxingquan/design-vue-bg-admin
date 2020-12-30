package com.quan.core.annotation;


import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/11/18
 * 描述：操作日志
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SLog {
    /**
     * 标签
     *
     * @return
     */
    String tag()  default "";

    /**
     * 消息
     *
     * @return
     */
    String msg() default "";

    /**
     * 模块
     *
     * @return
     */
    String module();

    /**
     * 是否保存请求的参数
     *
     * @return the boolean
     */
    boolean saveRequestData() default true;

    /**
     * 是否保存响应的结果
     *
     * @return the boolean
     */
    boolean saveResponseData() default false;

    /**
     * 是否异步执行,默认为true
     *
     * @return true, 如果需要异步执行
     */
    boolean async() default true;

}
