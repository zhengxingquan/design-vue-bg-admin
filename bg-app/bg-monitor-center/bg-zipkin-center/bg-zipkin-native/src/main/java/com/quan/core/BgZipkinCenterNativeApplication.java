package com.quan.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/9
 * 描述： 默认采用HTTP通信方式启动ZipkinServer
 * <p>
 * 本地内存中存放服务跟踪信息
 *
 * 访问 http://127.0.0.1:9991/
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class BgZipkinCenterNativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgZipkinCenterNativeApplication.class, args);
    }

}


