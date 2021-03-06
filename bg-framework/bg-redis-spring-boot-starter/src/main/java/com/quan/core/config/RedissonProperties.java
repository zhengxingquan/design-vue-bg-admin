package com.quan.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/11/24
 * 描述：
 */

@ConfigurationProperties(prefix = "spring.redis.redisson")
@Data
public class RedissonProperties {

    /***
     * 配置文件的路径 classpath:redisson.yaml
     */
    private String config;
    private String enable;
}
