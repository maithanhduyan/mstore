/**
 * @author Mai Thành Duy An
 */
package com.mstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mstore.entities.ProductSubCategory;
import com.mstore.repositories.ProductSubCategoryRepository;

@Service
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {

	@Autowired
	ProductSubCategoryRepository productSubCategoryRepository;

	@Override
	public ProductSubCategory findById(String id) {
		// TODO Try-catch block
		return null;
	}

	@Override
	public Page<ProductSubCategory> findAll(Pageable pageable) {
		// TODO Try-catch block
		return productSubCategoryRepository.findAll(pageable);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductSubCategory> findAll() {
		// TODO Try-catch block
		return productSubCategoryRepository.findAll();
	}

	@Override
	public <S extends ProductSubCategory> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ProductSubCategory entity) {
		// TODO Auto-generated method stub

	}

}
