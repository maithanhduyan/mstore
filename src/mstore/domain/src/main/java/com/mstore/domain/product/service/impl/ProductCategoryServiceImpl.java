package com.mstore.domain.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mstore.domain.product.entity.ProductCategory;
import com.mstore.domain.product.repository.ProductCategoryRepository;
import com.mstore.domain.product.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

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
		return productCategoryRepository.findAll();
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
