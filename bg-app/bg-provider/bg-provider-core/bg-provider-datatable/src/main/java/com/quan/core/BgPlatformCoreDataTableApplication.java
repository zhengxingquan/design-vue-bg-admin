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
 * 系统核心功能(数据表管理)
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/1 23:08
 */

/* 启动日志*/
@EnableLogging
@EnableDiscoveryClient
@SpringBootApplication
/* 启动幂登 控制*/
@EnableApiIdempotent
public class BgPlatformCoreDataTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgPlatformCoreDataTableApplication.class, args);

//        // 随机端口启动
//        SpringApplication app = new SpringApplication(BgPlatformCoreDataTableApplication.class);
//        app.addListeners(new PortApplicationEnvironmentPreparedEventListener());
//        app.run(args);
    }

}
