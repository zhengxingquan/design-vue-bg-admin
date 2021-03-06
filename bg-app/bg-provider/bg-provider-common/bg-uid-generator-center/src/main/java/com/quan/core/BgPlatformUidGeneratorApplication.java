/**
 *
 */
package com.quan.core;

import com.quan.core.annotation.EnableLogging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 * 系统分布式ID功能
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/1 23:08
 */
@EnableLogging
@EnableDiscoveryClient
@SpringBootApplication
public class BgPlatformUidGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgPlatformUidGeneratorApplication.class, args);
    }

}
