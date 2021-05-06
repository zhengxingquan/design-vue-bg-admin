package com.quan.core.constant.annotation.batis;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 * <p>
 * 在执行删除操作前操作时触发
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface PrevDelete {

    /**
     * 执行一个EL表达式,如果返回值不是null,赋值到当前字段
     */
    EL[] els() default {};
}
