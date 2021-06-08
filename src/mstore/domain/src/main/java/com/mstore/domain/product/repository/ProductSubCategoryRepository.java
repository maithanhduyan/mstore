package com.mstore.domain.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.product.entity.ProductSubCategory;

public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, String> {

}
