package com.quan.core.common.annotation.batis;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 * <p>
 * 在执行更新操作时触发
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface PrevUpdate {

    /**
     * 执行一个EL表达式,如果返回值不是null,赋值到当前字段
     */
    EL[] els() default {};

    /**
     * 设置为当前时间,通常是updateTime字段
     */
    boolean now() default false;

    /**
     * nullEffective=true时上面的赋值规则要起效必须是在[当前字段==null]时才能生效
     */
    boolean nullEffective() default false;

}
