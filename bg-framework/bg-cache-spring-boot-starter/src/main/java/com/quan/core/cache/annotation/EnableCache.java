package com.quan.core.cache.annotation;

import com.quan.core.cache.selector.CacheImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：缓存数据记录
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CacheImportSelector.class)
public @interface EnableCache {
}
