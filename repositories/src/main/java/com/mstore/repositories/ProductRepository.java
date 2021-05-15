package com.mstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mstore.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
