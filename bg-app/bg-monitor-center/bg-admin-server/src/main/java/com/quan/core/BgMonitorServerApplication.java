package com.quan.core;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/11/29
 * 描述：
 *
 * Spring boot 服务监控 访问地址：http://localhost:9001/
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class BgMonitorServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgMonitorServerApplication.class, args);

    }
}
