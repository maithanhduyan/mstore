package com.mstore.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mstore.entities.Employee;
 
// This is an Interface.
// No need Annotation here.
public interface EmployeeRepository extends CrudRepository<Employee, Long> { // Long: Type of Employee ID.
 
    Employee findByEmpNo(String empNo);
 
    @Query("SELECT e FROM Employee e WHERE e.fullName LIKE %:keyword%")
    List<Employee> findByFullNameLike(@Param("keyword") String fullName);
 
    List<Employee> findByHireDateGreaterThan(Date hireDate);
 
    @Query("SELECT coalesce(max(e.id), 0) FROM Employee e")
    Long getMaxId();
 
}