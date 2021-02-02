package com.quan.core;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/2/2
 * 描述：
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
public class ServiceTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceTwoApplication.class, args);
    }
}
