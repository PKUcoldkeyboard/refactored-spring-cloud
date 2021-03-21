package com.cuterwrite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**  
 * @author Pang S.Z.
 * @create 2021-03-01 18:01:55 
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
