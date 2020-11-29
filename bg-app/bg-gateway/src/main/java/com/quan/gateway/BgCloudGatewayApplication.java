
package com.quan.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;


/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/11/18 15:18
 *
 *
 *  网关 启动器
 */
@Configuration
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrixDashboard
public class BgCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgCloudGatewayApplication.class, args);
    }
}
