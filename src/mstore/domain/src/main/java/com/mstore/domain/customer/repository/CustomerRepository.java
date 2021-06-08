package com.mstore.domain.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
