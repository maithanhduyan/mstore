package com.mstore.domain.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

	private static final long serialVersionUID = -5241327163515811361L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	public Company() {
	}

	private static Company instance;

	public static Company getInstance() {
		if (instance == null) {
			instance = new Company();
		}
		return instance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", brand=" + brand + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
