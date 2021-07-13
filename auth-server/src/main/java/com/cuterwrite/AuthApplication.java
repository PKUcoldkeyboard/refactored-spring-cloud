package com.cuterwrite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**  
 * @author Pang S.Z.
 * @create 2021-07-12 15:39:36 
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
}
