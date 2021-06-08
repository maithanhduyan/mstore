package com.mstore.domain.user.repository;

import com.mstore.domain.user.entity.User;

public interface UserCommandRepository {
	public User findByUsername(String username);
}
