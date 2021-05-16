package com.mstore.repositories;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

	@Autowired
	EntityManager entityManager;

	@Override
	public String findCodeById(String id) {
		try {
			String sql = "SELECT p.code FROM Product p WHERE p.id = 'a' ";
			Query query = entityManager.createQuery(sql);
			return (String) query.getSingleResult();
		} catch (NoResultException e) {
			return "";
		}
	}

}
