package com.mstore.domain.sales.repository;

import com.mstore.domain.sales.entity.Customer;

public interface CustomerCommandRepository {
	public Customer getOne(String id);
}
