package com.mstore.domain.customer.service.impl;

import org.springframework.stereotype.Service;

import com.mstore.domain.customer.entity.Customer;
import com.mstore.domain.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer fetchById(String id) {

		return new Customer("01", "Customer");
	}

}
