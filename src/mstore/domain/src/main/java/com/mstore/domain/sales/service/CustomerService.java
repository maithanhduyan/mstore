package com.mstore.domain.sales.service;

import com.mstore.domain.sales.entity.Customer;
import com.mstore.domain.shared.service.BaseService;

public interface CustomerService extends BaseService<Customer, String> {

	public Customer fetchById(String id);
}
