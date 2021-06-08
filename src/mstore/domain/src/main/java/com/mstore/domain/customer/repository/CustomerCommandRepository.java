package com.mstore.domain.customer.repository;

import com.mstore.domain.customer.entity.Customer;

public interface CustomerCommandRepository {
	public Customer getOne(String id);
}
