package com.mstore.domain.customer.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mstore.domain.customer.entity.Customer;
import com.mstore.domain.customer.repository.CustomerCommandRepository;

@Repository
public class CustomerCommandRepositoryImpl implements CustomerCommandRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public Customer getOne(String id) {
		Customer customer = null;
		try {
			String sql = "SELECT * FROM Customer c WHERE id=" + id;
			Query query = entityManager.createQuery(sql);
			customer = (Customer) query.getSingleResult();
			return customer;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
