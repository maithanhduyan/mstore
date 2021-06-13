package com.mstore.domain.shared.utils;

import java.util.UUID;

public class IDUtil {

	public static String generate() {
		String id = UUID.randomUUID().toString();
		return id;
	}
}
