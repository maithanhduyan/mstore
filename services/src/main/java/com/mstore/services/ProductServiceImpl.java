package com.mstore.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mstore.entities.Product;
import com.mstore.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	@Override
	public Long count() {
		Long count = 0L;
		try {
			count = this.productRepository.count();
		} catch (Exception ex) {
		}
		return count;
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public <S extends Product> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Product entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product findById(String id) {
		Product product = Product.getInstance();
		try {
			if (!id.equalsIgnoreCase(null)) {
				product = this.productRepository.findById(id).orElse(product);
			}
		} catch (Exception ex) {
			log.info(ex.getMessage());
		}
		return product;
	}

}
