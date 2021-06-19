package com.mstore.domain.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mstore.domain.sales.entity.Shop;
import com.mstore.domain.sales.repository.ShopRepository;
import com.mstore.domain.sales.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopRepository shopRepository;
	@Override
	public Shop findById(String id) {
		return shopRepository.findById(id).orElse(Shop.getInstance());
	}

	@Override
	public Page<Shop> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shop> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Shop> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Shop entity) {
		// TODO Auto-generated method stub

	}

}