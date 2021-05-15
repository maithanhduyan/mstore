package com.mstore.services;

import org.springframework.stereotype.Service;

import entities.Product;

@Service
public interface ProductService {
	public Product fetchOne(String id) ;
}
