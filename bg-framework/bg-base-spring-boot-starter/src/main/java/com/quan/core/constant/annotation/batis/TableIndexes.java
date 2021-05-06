package com.quan.core.constant.annotation.batis;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 *
 * 声明一组数据表的索引
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface TableIndexes {

    Index[] value();
}
