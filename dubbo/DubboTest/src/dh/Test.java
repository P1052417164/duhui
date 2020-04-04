package dh;

import java.util.ArrayList;
import java.util.List;

public class Test {
	static class OOMObject {

	}
	public static void mains(String[] arts) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		int i = 0;
		while (true) {
			list.add(new OOMObject());
			System.out.println(i);
			i++;
		}
	}
}
