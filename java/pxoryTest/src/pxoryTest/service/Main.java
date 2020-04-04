package pxoryTest.service;

import pxoryTest.controller.DhTest;
import pxoryTest.controller.DhTestImpl;

public class Main {
	public static void main(String[] args) {
		DhTest hello = (DhTest) new JdkProxy().bind(new DhTestImpl(),
				new ProxyTestImpl());// 如果我们需要日志功能，则使用代理类
		hello.sayHello();
	}
}
