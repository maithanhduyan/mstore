package com.mstore.domain.system.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mstore.domain.system.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	@Cacheable(cacheNames = "account")
	@Query(value = "SELECT acc FROM Account acc WHERE acc.userName = :username AND acc.active = 1")
	public Optional<Account> findByUsername(@Param("username") String username);

	@Cacheable(cacheNames = "accounts")
	@Query("SELECT a FROM Account a WHERE a.active = 1")
	public List<Account> findAll();

}
