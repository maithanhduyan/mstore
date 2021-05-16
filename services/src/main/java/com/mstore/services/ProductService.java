package com.mstore.services;

import com.mstore.entities.Product;

public interface ProductService {
	public Product fetchOne(String id) ;
	public Long count();
}
