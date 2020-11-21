package com.quan.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/***
 *
 * @author zxq(956607644@qq.com)
 * @date 2020/11/18 15:43
 *
 * The class Paas cloud zipkin application.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class BgCloudZipkinApplication {


	public static void main(String[] args) {
		SpringApplication.run(BgCloudZipkinApplication.class, args);
	}
}
