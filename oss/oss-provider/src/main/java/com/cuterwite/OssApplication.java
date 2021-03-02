package com.cuterwite;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**  
 * @author Pang S.Z.
 * @create 2021-03-02 01:20:55 
 */
@SpringBootApplication
@EnableDiscoveryClient
@DubboComponentScan
public class OssApplication {
	public static void main(String[] args) {
		SpringApplication.run(OssApplication.class, args);
	}
}
