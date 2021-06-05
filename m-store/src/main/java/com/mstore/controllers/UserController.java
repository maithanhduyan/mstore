/**
 * @author Mai Thành Duy An
 */
package com.mstore.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mstore.services.AppService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	UserController() {
		log.info("start ");
	}

	@RequestMapping(value = { "/register", "/register.html" }, method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("shop", AppService.context.get("shop"));
		log.info(" " + AppService.context);
		return "register";
	}

	@RequestMapping(value = { "/login", "/login.html" }, method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("shop", AppService.context.get("shop"));
		log.info(" " + AppService.context);
		return "login";
	}
}
