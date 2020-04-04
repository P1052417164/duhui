package com.dh.dubbo.test;

import java.util.ArrayList;
import java.util.List;

public class TestMemory {
	static class OOMObject {

	}
	public void createObject() {
		List<OOMObject> list = new ArrayList<OOMObject>();
		int i = 0;
		while (true) {
			list.add(new OOMObject());
			System.out.println(i);
			i++;
		}
	}

}
