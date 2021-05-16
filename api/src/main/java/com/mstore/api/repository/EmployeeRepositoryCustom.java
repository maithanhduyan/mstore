package com.mstore.api.repository;

import java.util.Date;

public interface EmployeeRepositoryCustom {

	public Long getMaxEmpId();

	public long updateEmployee(Long empId, String fullName, Date hireDate);

}