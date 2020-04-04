package pxoryTest.service;

import java.lang.reflect.Method;

public class ProxyTestImpl {
	public void start(Method mt) {
		System.out.println(mt.getName() + "start");
	}
	public void end(Method mt) {
		System.out.println(mt.getName() + "end");

	}
}
