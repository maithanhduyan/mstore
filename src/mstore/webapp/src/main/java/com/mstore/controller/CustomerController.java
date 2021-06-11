package com.mstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mstore.domain.sales.repository.CustomerCommandRepository;
import com.mstore.domain.sales.repository.CustomerRepository;
import com.mstore.domain.sales.service.CustomerService;

@Controller
public class CustomerController {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerCommandRepository customerCommandRepository;

	@RequestMapping("/customer/{id}")
	@ResponseBody
	public String viewCustomer(@PathVariable String id) {
		//LOG.info("ID: " + id + customerService.fetchById("").toString());
		//LOG.info(customerCommandRepository.getOne(id).toString());
		LOG.info(""+ customerRepository.count());
		return "index";
	}
}
