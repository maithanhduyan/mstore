package com.mstore.services.product;

import org.springframework.stereotype.Service;

import com.mstore.entities.Product;

@Service
public interface ProductService {
	public Product fetchOne(String id) ;
}
