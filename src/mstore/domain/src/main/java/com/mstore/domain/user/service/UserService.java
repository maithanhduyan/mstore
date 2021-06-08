package com.mstore.domain.user.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.user.entity.User;

public interface UserService extends JpaRepository<User, String>{

}
