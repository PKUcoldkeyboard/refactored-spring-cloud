package com.cuterwrite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**  
 * @author Pang S.Z.
 * @create 2021-07-15 23:19:47 
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UploadApplication {
	public static void main(String[] args) {
		SpringApplication.run(UploadApplication.class, args);
	}
}
