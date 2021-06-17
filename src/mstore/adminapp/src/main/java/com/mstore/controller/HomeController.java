package com.mstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "/" })
	public String viewHomePage() {
		// redirect:/admin/login
		return "view/index";
	}

	@RequestMapping(value = { "/login", "/login.html" })
	public String viewLogin() {
		return "view/system/login";
	}

	@RequestMapping(value = { "/403", "/403.html" })
	public String view403() {
		return "error/403";
	}
}
