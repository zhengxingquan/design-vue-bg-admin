package com.quan.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/18 14:58
 * 注册中心
 *
 * Turbine集群监控
 * http://localhost:1111/hystrix 输入  http://localhost:1111/turbine.stream
 *
 * 参考项目 ： https://gitee.com/catshen/zscat_sw
 *
 *  参考项目 ：https://gitee.com/zlt2000/microservices-platform
 *
 *
 */
//@EnableHystrixDashboard
//@EnableTurbine
@EnableEurekaServer
@SpringBootApplication
public class BgEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgEurekaApplication.class, args);
    }
}
