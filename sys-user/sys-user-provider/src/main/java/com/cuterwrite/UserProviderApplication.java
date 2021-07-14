package com.cuterwrite;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**  
 * @author Pang S.Z.
 * @create 2021-07-14 15:30:21 
 */
@SpringBootApplication
@EnableDiscoveryClient
@DubboComponentScan
public class UserProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserProviderApplication.class, args);
	}
}
