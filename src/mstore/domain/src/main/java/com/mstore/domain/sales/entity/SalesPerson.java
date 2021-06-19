package com.mstore.domain.sales.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SALES_PERSON")
public class SalesPerson implements Serializable {

	private static final long serialVersionUID = -844280112044178609L;

	@Id
	@Column(name = "ID", nullable = false)
	private String id;

	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "SALES_QUOTA")
	private double salesQuota;
	
	@Column(name = "SALES_YTD")
	private double salesYTD;
	
	@Column(name = "SALES_LAST_YEAR")
	private double salesLastYear;
	
	@Column(name = "BONUS")
	private double bonus;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

}
