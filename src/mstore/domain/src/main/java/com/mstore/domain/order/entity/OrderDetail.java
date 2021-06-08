package com.mstore.domain.order.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mstore.domain.product.entity.Product;

@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = -8523791895059129675L;

	@Id
	@Column(name = "ID", nullable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", nullable = false, //
			foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false, //
			foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK"))
	private Product product;

	@Column(name = "QUANTITY", nullable = false)
	private int quanity;

	@Column(name = "PRICE", nullable = false)
	private double price;

	@Column(name = "AMOUNT", nullable = false)
	private double amount;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order=" + order + ", product=" + product + ", quanity=" + quanity
				+ ", price=" + price + ", amount=" + amount + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}