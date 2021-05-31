package com.mstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.entities.Product;


public interface ProductRepository extends JpaRepository<Product, String>{

}
