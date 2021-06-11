package com.mstore.domain.product.service;

import java.util.List;

import com.mstore.domain.product.entity.Product;
import com.mstore.domain.shared.service.BaseService;

public interface ProductService extends BaseService<Product, String>{

	public List<Product> findAll();
}
