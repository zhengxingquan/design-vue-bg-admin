package com.quan.core.annotations;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/11/18
 * 描述：
 * <p>
 * 配合 SqlLogInterceptor 对指定方法 禁止打印SQL到控制台
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface NotDisplaySql {
}
