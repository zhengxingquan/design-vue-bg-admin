package com.quan.core.constant.annotation;

import com.quan.core.constant.selector.ApiIdempotentImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/***
 * 启动幂等拦截器(自动装配starter实现)
 *
 * https://gitee.com/owenwangwen/open-capacity-platform
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2021/5/6 19:55
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ApiIdempotentImportSelector.class)
public @interface EnableApiIdempotent {
}
