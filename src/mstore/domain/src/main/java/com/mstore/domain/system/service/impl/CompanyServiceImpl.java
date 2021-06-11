package com.mstore.domain.system.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mstore.domain.system.entity.Company;
import com.mstore.domain.system.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Override
	public Company findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Company> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Company> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Company entity) {
		// TODO Auto-generated method stub
		
	}

}
