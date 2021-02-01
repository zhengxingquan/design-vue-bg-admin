package com.quan.core;

import com.quan.core.config.AppDispatcherServletConfiguration;
import com.quan.core.config.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/***
 * 工作流中心
 * @author zxq(956607644 @ qq.com)
 * @date 2021/1/22 22:21
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2021/1/20 17:05
 *
 * demo: https://gitee.com/foolish93/flowable_demo
 * 官方说明：https://flowable.com/open-source/docs/form/ch03-API/
 */
/* 启动日志*/
//@EnableLogging
@EnableDiscoveryClient
@Import({
        ApplicationConfiguration.class,
        AppDispatcherServletConfiguration.class
})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BgWorkCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgWorkCenterApplication.class, args);
    }

}

