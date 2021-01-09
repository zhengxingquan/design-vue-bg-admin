package com.quan.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication()
public class BgEsLogMonitorApplication {
    public static void main(String[] args) {

        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(BgEsLogMonitorApplication.class, args);
    }
}
