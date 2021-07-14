package com.cuterwrite.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.cuterwrite.component.KafkaProducer;

/**  
 * @author Pang S.Z.
 * @create 2021-07-14 14:49:48 
 */
@DubboService(cluster = "failfast")
public class ProductService implements IProductService {
	
	@Autowired
	KafkaProducer kafkaProducer;

	@Override
	public boolean sendMessage(String message) {
		kafkaProducer.send(message);
		return true;
	}

}
