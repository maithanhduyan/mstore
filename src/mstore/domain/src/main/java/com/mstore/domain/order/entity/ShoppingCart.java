package com.mstore.domain.order.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = -6168033607891593091L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "ACTIVE")
	private int active;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Column(name = "DESCRIPTION")
	private String description;

	public ShoppingCart() {
	}

	public ShoppingCart(String id, String userId, int active, String createdBy, String updatedBy, Date createdDate,
			Date updatedDate, String description) {
		super();
		this.id = id;
		this.userId = userId;
		this.active = active;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.description = description;
	}

	private static ShoppingCart _shoppingCart = null;

	public static ShoppingCart getInstance() {
		if (_shoppingCart == null) {
			_shoppingCart = new ShoppingCart();
		}
		return _shoppingCart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static ShoppingCart get_shoppingCart() {
		return _shoppingCart;
	}

	public static void set_shoppingCart(ShoppingCart _shoppingCart) {
		ShoppingCart._shoppingCart = _shoppingCart;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", userId=" + userId + ", active=" + active + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", description=" + description + "]";
	}

}
