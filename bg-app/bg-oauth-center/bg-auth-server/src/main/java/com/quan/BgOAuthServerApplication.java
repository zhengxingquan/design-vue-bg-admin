/**
 *
 */
package com.quan;

import com.quan.common.feign.GlobalFeignConfig;
import com.quan.log.annotation.EnableLogging;
import com.quan.oauth.server.OAuthServerConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/***
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/18 16:21
 */
/* 启动日志记录 */
@EnableLogging
@EnableDiscoveryClient
@SpringBootApplication
@Import(OAuthServerConfig.class)
@EnableFeignClients(defaultConfiguration = GlobalFeignConfig.class)
@MapperScan("com.quan.*.dao")
public class BgOAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgOAuthServerApplication.class, args);

    }

}