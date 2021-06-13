package com.mstore.domain.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

	private static final long serialVersionUID = 5657145333317528921L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	public Role() {
	}

	private static Role instance;

	public static Role getInstance() {
		if (instance == null) {
			synchronized (Role.class) {
				instance = new Role();
			}
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
