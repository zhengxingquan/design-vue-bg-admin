package com.quan.es.client.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BgZipkinEsClientApplication {


	public static void main(String[] args) {
		SpringApplication.run(BgZipkinEsClientApplication.class, args);
	}
}
