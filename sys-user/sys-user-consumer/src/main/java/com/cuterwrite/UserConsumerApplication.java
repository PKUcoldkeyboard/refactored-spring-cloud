package com.cuterwrite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**  
 * @author Pang S.Z.
 * @create 2021-07-14 15:28:09 
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserConsumerApplication.class, args);
	}
}
