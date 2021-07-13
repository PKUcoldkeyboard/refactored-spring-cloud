package com.cuterwrite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**  
 * @author Pang S.Z.
 * @create 2021-07-11 20:57:00 
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CacheConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(CacheConsumerApplication.class, args);
	}
}
