package javaSeTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {
	@SuppressWarnings({ "unused", "unchecked" })
	public static void main() throws Exception {
		Inteface1.dd();

		Inteface1Class dd = new Inteface1Class();
		dd.getI();
		AbstractTest1.dddd();
		AbstractTest1E ddd = new AbstractTest1E();
		@SuppressWarnings("rawtypes")
		Class t = Class.forName("");
		t.getName();
		SingleTest dds = new SingleTest();
		Method ddskjkjk = t.getDeclaredMethod("d");
		Field ddf = t.getField("dd");

	}
}
