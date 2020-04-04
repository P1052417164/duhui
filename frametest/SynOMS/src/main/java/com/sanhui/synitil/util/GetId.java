package com.sanhui.synitil.util;

import java.util.UUID;

public class GetId {

	public static String getId() {
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		return id;
	}

}
