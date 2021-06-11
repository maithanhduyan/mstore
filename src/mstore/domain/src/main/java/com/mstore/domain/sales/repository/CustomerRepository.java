package com.mstore.domain.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.sales.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
