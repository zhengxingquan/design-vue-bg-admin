package com.quan.core;

import com.quan.core.annotation.EnableLogging;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 *   代码生成中心
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/3 9:36
 */
@EnableLogging
@EnableDiscoveryClient
@SpringBootApplication
public class BgGeneratorCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(BgGeneratorCenterApplication.class, args);
    }
}
