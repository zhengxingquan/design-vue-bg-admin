package com.quan.log.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/***
 *   log-spring-boot-starter 自动装配
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/15 17:15
 */

public class LogImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{
                "com.quan.log.aop.SLogAOP",
//				"com.quan.log.config.SentryAutoConfig",
//                "com.quan.log.service.impl.LogServiceImpl",
                "com.quan.log.config.LogAutoConfig"

        };
    }

}