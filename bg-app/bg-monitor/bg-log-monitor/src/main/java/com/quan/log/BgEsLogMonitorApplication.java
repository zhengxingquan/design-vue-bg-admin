package com.quan.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BgEsLogMonitorApplication {
	public static void main(String[] args) {
		System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(BgEsLogMonitorApplication.class, args);
	}
}
