package com.mstore.repositories.humanresource;

import java.util.Date;

public interface EmployeeRepositoryCustom {

	public Long getMaxEmpId();

	public long updateEmployee(String empId, String fullName, Date hireDate);

}