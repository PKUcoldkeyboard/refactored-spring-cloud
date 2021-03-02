package com.cuterwrite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**  
 * @author Pang S.Z.
 * @create 2021-03-02 02:07:44 
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OssConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(OssConsumerApplication.class, args);
	}
}
