package com.quan.core.cache.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：cache-spring-boot-starter 自动装配
 */
public class CacheImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "com.quan.plugins.cache.aop.CacheRemoveAop",
                "com.quan.plugins.cache.aop.CacheRemoveAllAop"
        };
    }
}
