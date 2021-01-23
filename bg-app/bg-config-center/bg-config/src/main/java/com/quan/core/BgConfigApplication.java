package com.quan.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/11/18
 * 描述：
 * <p>
 * 配置中心
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class BgConfigApplication {

    public static void main(String[] args) {

        SpringApplication.run(BgConfigApplication.class, args);

    }
}
