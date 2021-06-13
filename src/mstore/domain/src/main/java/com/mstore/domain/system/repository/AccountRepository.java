package com.mstore.domain.system.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mstore.domain.system.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	@Query(value = "SELECT acc FROM Account acc WHERE acc.userName = :username")
	public Optional<Account> findByUsername(@Param("username") String username);
}
