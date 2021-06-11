package com.mstore.domain.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.system.entity.AccountRole;

public interface AccountRoleRepository extends JpaRepository<AccountRole, String> {
	
}
