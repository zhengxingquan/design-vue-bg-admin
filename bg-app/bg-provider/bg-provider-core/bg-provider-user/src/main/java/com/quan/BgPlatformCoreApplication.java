/**
 *
 */
package com.quan;

import com.quan.common.annotation.EnableApiIdempotent;
import com.quan.log.annotation.EnableLogging;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 * 系统核心功能
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/1 23:08
 */

/* 启动日志*/
@EnableLogging
@EnableDiscoveryClient
@SpringBootApplication
/* 启动幂登 控制*/
@EnableApiIdempotent
@MapperScan({"com.quan.*.dao"})
public class BgPlatformCoreApplication {

    public static void main(String[] args) {
//		固定端口启动
        SpringApplication.run(BgPlatformCoreApplication.class, args);

        //随机端口启动
//        SpringApplication app = new SpringApplication(BgPlatformCoreApplication.class);
//        app.addListeners(new PortApplicationEnvironmentPreparedEventListener());
//        app.run(args);

    }

}
