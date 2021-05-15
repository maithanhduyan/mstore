package com.mstore.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mstore.entities.Product;
import com.mstore.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product fetchOne(String id) {
		// TODO Fecth One Product
		return productRepository.getById(id);
	}

}
