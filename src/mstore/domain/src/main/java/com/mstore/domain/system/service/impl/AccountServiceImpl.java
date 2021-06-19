package com.mstore.domain.system.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mstore.domain.system.entity.Account;
import com.mstore.domain.system.service.AccountService;

public class AccountServiceImpl implements AccountService{

	@Override
	public Account findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Account> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account entity) {
		// TODO Auto-generated method stub
		
	}

}
