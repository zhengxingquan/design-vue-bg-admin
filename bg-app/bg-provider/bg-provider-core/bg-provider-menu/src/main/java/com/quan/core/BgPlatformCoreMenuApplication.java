/**
 *
 */
package com.quan.core;

import com.quan.core.annotation.EnableLogging;
import com.quan.core.common.annotation.EnableApiIdempotent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 * 系统核心功能(菜单)
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/1 23:08
 */

/* 启动日志*/
@EnableLogging
@EnableDiscoveryClient
@SpringBootApplication
/* 启动幂登 控制*/
@EnableApiIdempotent
public class BgPlatformCoreMenuApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgPlatformCoreMenuApplication.class, args);
    }

}
