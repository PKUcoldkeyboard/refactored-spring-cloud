package com.cuterwrite.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**  
 * @author Pang S.Z.
 * @create 2021-07-14 14:51:36 
 */
@Component
@Slf4j
public class KafkaProducer {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static String TOPIC = "testTopic";
	
	/**
	 * 生产消息
	 */
	public void send(String str) {
		log.info("生产消息：" + str);
		kafkaTemplate.send(TOPIC, str);
	}
}
