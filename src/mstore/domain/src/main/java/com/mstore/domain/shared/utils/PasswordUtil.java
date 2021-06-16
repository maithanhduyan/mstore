package com.mstore.domain.shared.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	private static BCryptPasswordEncoder bCryptPasswordEncoder;

	public static String encryt(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	public static BCryptPasswordEncoder bCryptPasswordEncoder() {

		if (bCryptPasswordEncoder == null) {
			synchronized (PasswordUtil.class) {
				bCryptPasswordEncoder = new BCryptPasswordEncoder();
			}
		}
		return bCryptPasswordEncoder;
	}

}
