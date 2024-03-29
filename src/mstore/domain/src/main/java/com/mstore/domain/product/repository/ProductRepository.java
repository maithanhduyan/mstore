package com.mstore.domain.product.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mstore.domain.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	@Cacheable(cacheNames = "products")
	@Query("SELECT p FROM Product p WHERE p.active =1")
	public List<Product> findAll();
}
