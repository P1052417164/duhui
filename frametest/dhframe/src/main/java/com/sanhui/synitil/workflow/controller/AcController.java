package com.sanhui.synitil.workflow.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.sanhui.synitil.kafka.KafkaSen;
import com.sanhui.synitil.util.GetId;
import com.sanhui.synitil.util.RedisUtil;
import com.sanhui.synitil.workflow.dto.AcDto;
import com.sanhui.synitil.workflow.service.AcService;

@RestController

@RequestMapping("/user")
@CrossOrigin
public class AcController {
	@Resource
	private AcService acService;
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private KafkaSen kafkaSen;
	@RequestMapping("/getUserById")
	public Map<String, Object> getUser(HttpServletRequest request) {
		Map<String, Object> dd = new HashMap<String, Object>();
		AcDto dto = new AcDto();
		dto.setId(request.getParameter("id"));
		Object d = acService.getUserById(dto);
		dd.put("dd", d);

		Object ddd = redisUtil.get("user:id:" + dto.getId());
		return dd;
	}
	@RequestMapping("/getUserByName")
	public Map<String, Object> getUserByName(HttpServletRequest request) {
		Map<String, Object> dd = new HashMap<String, Object>();
		AcDto dto = new AcDto();
		dto.setName(request.getParameter("name"));
		AcDto d = acService.getUserByName(dto);
		dd.put("dd", d);
		return dd;
	}
	@RequestMapping("/saveUser")
	public Map<String, Object> saveUser(HttpServletRequest request) {
		Map<String, Object> dd = new HashMap<String, Object>();
		AcDto dto = new AcDto();
		dto.setId(GetId.getId());
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dd.put("data", dto);
		// acService.saveUser(dto);
		return dd;
	}
	@RequestMapping("/updateUser")
	public Map<String, Object> updateUser(HttpServletRequest request) {
		Map<String, Object> dd = new HashMap<String, Object>();
		AcDto dto = new AcDto();
		dto.setId(request.getParameter("id"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		acService.updateUser(dto);
		return dd;
	}
	@RequestMapping("/deleteUser")
	public Map<String, Object> deleteUser(HttpServletRequest request) {
		Map<String, Object> dd = new HashMap<String, Object>();
		AcDto dto = new AcDto();
		dto.setId(request.getParameter("id"));
		acService.deleteUser(dto);
		return dd;
	}

	@GetMapping("/testRedis")
	public String testRedis() {
		redisTemplate.opsForValue().set("synitil", "aa");
		String a = redisTemplate.opsForValue().get("synitil");
		return a;
	}

	@GetMapping("/testK")
	public String testK() {
		kafkaSen.send();
		System.out.println("1");
		return "dd";
	}
	@GetMapping("/testRocketMqP")
	public String testRocketMq() throws MQClientException {
		DefaultMQProducer producer = new DefaultMQProducer("dhPGroup");
		producer.setNamesrvAddr("192.168.220.133:9876");
		producer.start();
		try {
			for (int i = 0; i < 100; i++) {
				AcDto user = new AcDto();
				user.setId(i + "");
				user.setName("duhui");

				Message message = new Message("dhTopic2", "dhTopicTag2",
						JSON.toJSONString(user).getBytes());
				SendResult result = producer.send(message);
				System.err.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:"
						+ result.getSendStatus());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		producer.shutdown();
		return "1";
	}
	@GetMapping("/testRocketMqC")
	public String testRocketMqC() throws MQClientException {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("dhCGroup");

		consumer.setNamesrvAddr("192.168.220.133:9876");
		consumer.subscribe("dhTopic2", "dhTopicTag2");

		consumer.registerMessageListener(new MessageListenerConcurrently() {

			public ConsumeConcurrentlyStatus consumeMessage(
					List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				int i = 0;
				i = i + 1;
				for (MessageExt msg : msgs) {
					System.out.println("消费者消费数据:" + new String(msg.getBody()));
				}
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		consumer.start();
		return "1";
	}
	@GetMapping("/testRocketMqGet")
	public String testRocketMqGet() throws MQClientException {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("dhCGroup");
		consumer.setNamesrvAddr("192.168.220.143:9876");
		Map<String, String> dd = consumer.getSubscription();

		return "1";
	}
	public static void main(String[] args) {
		String a = "hello";
		String b = "hello";
		String c = new String("hello");
		String d = new String("hello");
		char[] aa = {'h', 'e', 'l', 'l', 'o'};

		System.out.println("a=b:" + a == b);
		System.out.println("a e b" + a.equals(b));

		System.out.println("a=c" + a == c);
		System.out.println("a e c" + a.equals(c));

		System.out.println("d=c" + d == c);
		System.out.println("d e c" + d.equals(c));

		System.out.println("c=aa" + c.equals(aa));
		System.out.println("c=aa" + c.equals(aa));
		Map<String, Object> sd = new HashMap<String, Object>();
		List<Object> Listsd = new ArrayList<>();
		TestObject object = new TestObject();
		object.setDf("2324");
		Listsd.add("das");
		Listsd.add("232");
		sd.put("obj", object);
		sd.put("list", Listsd);
		sd.put("1231", 123);
		Listsd.clear();
		object.setSd(23);
		String dd = 1 + "k";
		while ((dd + 1) == (dd + 1)) {
			System.out.print(dd);
		}
		object = new TestObject();
		int i = 0;

	}
}
