package com.sanhui.synitil.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
@Component
public class KafkaSen {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	// 发送消息方法
	public void send() {

		kafkaTemplate.send("dhtest", "duhui");
	}
}
