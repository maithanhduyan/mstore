package com.mstore.domain.system.repository;

import java.util.List;

import com.mstore.domain.system.entity.Role;

public interface AccountRoleExtendRepository {
	public List<Role> findAllByAccountId(String accountId);
}
