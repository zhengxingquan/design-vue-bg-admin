package com.quan.config;

import com.quan.properties.CoreProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/11/18
 * 描述：
 */
@Configuration
@EnableConfigurationProperties(CoreProperties.class)
public class BgCoreConfig {
}
