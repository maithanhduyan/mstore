/**
 * @author Mai Thành Duy An
 */
package com.mstore.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AppService {
	public static Map<String, Object> context = new HashMap<>(); // GLOBAL VARIABLE

	public static Map<String, Object> getContext() {
		return context;
	}

	// Put data in global cache variable
	public void setContext(String key, Object value) {
		context.put(key, value);
	}
}
