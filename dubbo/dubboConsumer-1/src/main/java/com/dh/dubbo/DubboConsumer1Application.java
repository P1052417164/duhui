package com.dh.dubbo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DubboConsumer1Application {
	static class OOMObject {

	}
	public static void main(String[] args) {
		SpringApplication.run(DubboConsumer1Application.class, args);
		System.out.println("helloWord");
		List<OOMObject> list = new ArrayList<OOMObject>();
		int i = 0;
		while (true) {
			list.add(new OOMObject());
			System.out.println(i);
			i++;
		}
	}

}
