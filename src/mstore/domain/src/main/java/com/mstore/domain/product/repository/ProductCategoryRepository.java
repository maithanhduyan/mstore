package com.mstore.domain.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.product.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String>{

}
