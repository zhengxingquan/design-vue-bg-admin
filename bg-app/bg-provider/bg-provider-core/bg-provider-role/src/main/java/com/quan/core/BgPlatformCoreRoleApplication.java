/**
 *
 */
package com.quan.core;

import com.quan.core.annotation.EnableLogging;
import com.quan.core.cache.annotation.EnableRedisCache;
import com.quan.core.common.annotation.EnableApiIdempotent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/***
 * 系统核心角色 服务 功能
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/1 23:08
 */

/* 启动日志*/
@EnableLogging
@EnableDiscoveryClient
@SpringBootApplication
/* 启动幂登 控制*/
@EnableApiIdempotent
@EnableRedisCache
public class BgPlatformCoreRoleApplication {


    public static void main(String[] args) {
        SpringApplication.run(BgPlatformCoreRoleApplication.class, args);
    }

}
