/**
 * @author Mai Thành Duy An
 */
package com.mstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.entities.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

}
