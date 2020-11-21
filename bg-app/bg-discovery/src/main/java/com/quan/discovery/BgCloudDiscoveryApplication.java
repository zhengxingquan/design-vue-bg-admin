package com.quan.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/11/18
 * 描述：
 * <p>
 * 配置中心
 */

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class BgCloudDiscoveryApplication {

    public static void main(String[] args) {

        SpringApplication.run(BgCloudDiscoveryApplication.class, args);

    }
}
