package com.mstore.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
