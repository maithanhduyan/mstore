package com.mstore.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	public AdminController() {

	}

	@RequestMapping(value = { "/", "dashboard.html", "dashboard", "index.html" })
	public String viewDashBoard(HttpSession session) {
		LOG.debug("DashBoard Endpoint");
		LOG.info("SessionID: " + session.getId());
		return "dashboard";
	}

	@RequestMapping(value = { "login", "login.html" })
	public String viewLogin() {
		return "view/system/login";
	}

	@RequestMapping(value = { "/admin/accountInfo" }, method = RequestMethod.GET)
	public String accountInfo(Model model) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		LOG.debug(userDetails.getUsername());

		model.addAttribute("userDetails", userDetails);
		return "accountInfo";
	}
}
