/**
 * 
 */
package com.quan.oauth.server;

import com.quam.common.feign.GlobalFeignConfig;
import com.quam.common.port.PortApplicationEnvironmentPreparedEventListener;
import com.quan.log.annotation.EnableLogging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/** 
* @author owen 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51
* 类说明 
*/
@EnableLogging
@EnableDiscoveryClient
@SpringBootApplication
@Import(OAuthServerConfig.class)
@EnableFeignClients(defaultConfiguration= GlobalFeignConfig.class)
public class BgOAuthServerApplication {
	
	public static void main(String[] args) {
//		固定端口启动
		SpringApplication.run(BgOAuthServerApplication.class, args);
		
		//随机端口启动
//		SpringApplication app = new SpringApplication(BgOAuthServerApplication.class);
//        app.addListeners(new PortApplicationEnvironmentPreparedEventListener());
//        app.run(args);
		
	}

}
