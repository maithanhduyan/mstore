package com.mstore.domain.shared.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mstore.domain.sales.service.ShopService;

@Component
public class AdminSiteUtil {

	@Autowired
	ShopService shopService;
	@SuppressWarnings("unused")
	private String shopName;

	public AdminSiteUtil() {

	}

	public static String SHOP_NAME = "MStore";

}
