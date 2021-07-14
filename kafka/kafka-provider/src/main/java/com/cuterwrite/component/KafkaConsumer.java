package com.cuterwrite.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**  
 * @author Pang S.Z.
 * @create 2021-07-14 14:55:47 
 */
@Component
@Slf4j
public class KafkaConsumer {
	
	@KafkaListener(topics = "testTopic")
	public void onMessage(String str) {
		log.info("监听到：" + str);
	}
}
