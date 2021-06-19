package com.mstore.domain.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.system.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

}
