package com.mstore.domain.system.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mstore.domain.system.entity.Role;
import com.mstore.domain.system.repository.AccountRoleExtendRepository;

@Repository
@Transactional
public class AccountRoleExtendRepositoryImpl implements AccountRoleExtendRepository {

	private static final Logger LOG = LoggerFactory.getLogger(AccountRoleExtendRepository.class);

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Role> findAllByAccountId(String accountId) {

		String sql = "SELECT ar.role FROM AccountRole ar WHERE ar.account.id = :accountId";

		Query query = this.entityManager.createQuery(sql, Role.class);
		query.setParameter("accountId", accountId);
		List<Role> resultList = query.getResultList();
		return resultList;
	}

}
