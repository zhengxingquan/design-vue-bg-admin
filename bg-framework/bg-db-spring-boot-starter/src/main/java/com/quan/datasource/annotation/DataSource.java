package com.quan.datasource.annotation;

import java.lang.annotation.*;


/***
 * 数据源选择
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/18 16:16
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    //数据库名称
    String name();
}