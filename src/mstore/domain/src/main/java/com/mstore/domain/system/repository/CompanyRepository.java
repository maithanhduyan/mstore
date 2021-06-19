package com.mstore.domain.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.system.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
