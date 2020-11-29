package com.quan.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/18 14:58
 * 注册中心
 */

@EnableEurekaServer
@SpringBootApplication
public class BgCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgCloudEurekaApplication.class, args);
    }
}
