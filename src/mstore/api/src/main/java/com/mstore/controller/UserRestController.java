package com.mstore.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mstore.domain.system.entity.Account;
import com.mstore.domain.system.repository.AccountRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

	private static final Logger LOG = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	AccountRepository accountRepository;

	@RequestMapping(value = "/fetchById", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Account fetchById(@RequestParam Map<String, String> data) {
		LOG.info(data.get("accountId"));
		Account account = null;
		try {
			account = accountRepository.findAll().get(0);
			LOG.info(account.toString());
		} catch (Exception ex) {
			LOG.info(ex.getMessage());
		}
		return account;
	}

	@RequestMapping("/heathCheck")
	@ResponseBody
	public String heathCheck() {
		return "OK";
	}
}
