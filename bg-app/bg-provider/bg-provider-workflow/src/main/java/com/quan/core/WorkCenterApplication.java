package com.quan.core;

import com.quan.core.config.AppDispatcherServletConfiguration;
import com.quan.core.config.ApplicationConfiguration;
import com.quan.core.annotation.EnableLogging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * 工作流中心
 *
 * @author persie
 * @date 2018/07/19
 */
/* 启动日志*/
@EnableLogging
@EnableDiscoveryClient
@Import({
        ApplicationConfiguration.class,
        AppDispatcherServletConfiguration.class
})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class WorkCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkCenterApplication.class, args);
    }

}

