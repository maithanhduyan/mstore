package com.mstore.domain.system.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.system.entity.AccountRole;

public interface AccountRoleService extends JpaRepository<AccountRole, String>{

}
