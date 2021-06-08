package com.mstore.domain.humanresource.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.humanresource.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
