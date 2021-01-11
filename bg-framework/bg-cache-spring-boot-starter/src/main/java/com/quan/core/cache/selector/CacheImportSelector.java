package com.quan.core.cache.selector;

import com.quan.core.cache.aop.CacheRemoveAllAop;
import com.quan.core.cache.aop.CacheRemoveAop;
import com.quan.core.cache.aop.CacheResultAop;
import com.quan.core.cache.aop.CacheUpdateAop;
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

        // TODO 这里可以采用 自定注入的方式吧 配置在文件中
//        SpringFactoriesLoader.loadFactories();
        return new String[]{
                CacheRemoveAop.class.getName(),
                CacheRemoveAllAop.class.getName(),
                CacheResultAop.class.getName(),
                CacheUpdateAop.class.getName()
        };
    }
}
