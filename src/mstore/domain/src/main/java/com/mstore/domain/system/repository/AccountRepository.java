package com.mstore.domain.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.system.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
