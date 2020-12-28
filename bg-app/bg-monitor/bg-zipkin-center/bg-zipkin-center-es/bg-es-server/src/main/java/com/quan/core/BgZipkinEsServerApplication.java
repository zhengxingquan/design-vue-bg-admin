package com.quan.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class BgZipkinEsServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BgZipkinEsServerApplication.class, args);
    }
}
 