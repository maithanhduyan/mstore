/**
 * @author Mai Thành Duy An
 */
package com.mstore.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mstore.entities.ProductCategory;

public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Override
	public ProductCategory findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ProductCategory> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCategory> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductCategory> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProductCategory entity) {
		// TODO Auto-generated method stub
		
	}

}
