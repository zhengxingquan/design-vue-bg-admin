package com.quan.sms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 短信中心
 *
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/3
 * 描述：
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.quan.*"})
public class BgSmsCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgSmsCoreApplication.class, args);
    }

}
