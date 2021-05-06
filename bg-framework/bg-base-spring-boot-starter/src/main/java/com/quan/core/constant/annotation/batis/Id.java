package com.quan.core.constant.annotation.batis;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/7
 * 描述：
 *
 * 自动填充分布式ID
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface Id {
}
