package com.quan.core.constant.annotation.batis;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 *
 * 声明一个数据表的索引
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface Index {

    /**
     * 是否是唯一性索引
     */
    boolean unique() default true;

    /**
     * 索引的名称
     */
    String name() default "";

    /**
     * 按顺序给出索引的字段名（推荐，用 Java 的字段名）. 当@Index标注在属性上, fields无效
     */
    String[] fields();
}
