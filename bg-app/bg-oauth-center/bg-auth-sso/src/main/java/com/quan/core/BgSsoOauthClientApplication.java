package com.quan.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/25 16:06
 */

@EnableDiscoveryClient
@SpringBootApplication
public class BgSsoOauthClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgSsoOauthClientApplication.class, args);
    }


}
