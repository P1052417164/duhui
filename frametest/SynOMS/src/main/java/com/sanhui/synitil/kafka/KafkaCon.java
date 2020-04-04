package com.sanhui.synitil.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Component
public class KafkaCon {
	@KafkaListener(topics = {"dhtest"})
	public void receive(ConsumerRecord<Integer, String> record) {
		System.out.println("app_log--消费消息:" + record.value());
	}
}
