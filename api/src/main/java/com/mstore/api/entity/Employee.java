package com.mstore.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	private Long id;

	@Column(name = "Emp_No", length = 30, nullable = false)
	private String empNo;

	@Column(name = "Full_Name", length = 128, nullable = false)
	private String fullName;

	@Temporal(TemporalType.DATE)
	@Column(name = "Hire_Date", nullable = false)
	private Date hireDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return this.getEmpNo() + ", " + this.getFullName();
	}

}