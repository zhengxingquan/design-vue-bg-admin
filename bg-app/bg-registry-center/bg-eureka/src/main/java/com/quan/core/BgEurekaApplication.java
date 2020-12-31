package com.quan.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/18 14:58
 * 注册中心
 *
 * Turbine集群监控
 * http://localhost:1111/hystrix 输入  http://localhost:1111/turbine.stream
 *
 */
@EnableHystrixDashboard
@EnableTurbine
@EnableEurekaServer
@SpringBootApplication
public class BgEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgEurekaApplication.class, args);
    }
}
