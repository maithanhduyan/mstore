package com.mstore.domain.shared.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CURRENCY")
public class Currency implements Serializable {

	private static final long serialVersionUID = -7065735396173929498L;
	@Id
	@Column(name = "ID")
	String id;
	@Column(name = "CODE")
	String code;
	@Column(name = "NAME")
	String name;
	@Column(name = "SYMBOL")
	String symbol;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	public Currency() {
	}

	public Currency(String id, String code, String name, String symbol, Date createdDate, Date updatedDate) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.symbol = symbol;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
		return "Currency [id=" + id + ", code=" + code + ", name=" + name + ", symbol=" + symbol + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}

}