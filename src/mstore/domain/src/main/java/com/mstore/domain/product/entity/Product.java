package com.mstore.domain.product.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = -2629599562342979524L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CODE")
	private String code;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUB_CATEGORY_ID")
	private ProductSubCategory subCategory;

	@Column(name = "COST_PRICE")
	private double costPrice;

	@Column(name = "SALE_PRICE")
	private double salePrice;

	@Column(name = "PROMO_PRICE")
	private double promoPrice;

	@Column(name = "PROMO_STATUS")
	private int promoStatus;

	@Column(name = "SKU")
	private String sku;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LINK_URL")
	private String linkURL;

	@Column(name = "IMAGE_URL")
	private String imageURL;

	@Column(name = "ACTIVE")
	private int active;

	@Column(name = "BADGE")
	private String badge;

	@Column(name = "IN_STOCK")
	private int inStock;

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

	public Product() {
	}

	private static Product _product = null;

	public static Product getInstance() {
		if (_product == null) {
			// Using Thread safe for instance Product
			synchronized (Product.class) {
				_product = new Product();
			}
		}
		return _product;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ProductSubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(ProductSubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getPromoPrice() {
		return promoPrice;
	}

	public void setPromoPrice(double promoPrice) {
		this.promoPrice = promoPrice;
	}

	public int getPromoStatus() {
		return promoStatus;
	}

	public void setPromoStatus(int promoStatus) {
		this.promoStatus = promoStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getLinkURL() {
		return linkURL;
	}

	public void setLinkURL(String linkURL) {
		this.linkURL = linkURL;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
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

	public static Product get_product() {
		return _product;
	}

	public static void set_product(Product _product) {
		Product._product = _product;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", code=" + code + ", subCategory=" + subCategory
				+ ", costPrice=" + costPrice + ", salePrice=" + salePrice + ", promoPrice=" + promoPrice
				+ ", promoStatus=" + promoStatus + ", sku=" + sku + ", description=" + description + ", linkURL="
				+ linkURL + ", imageURL=" + imageURL + ", active=" + active + ", badge=" + badge + ", inStock="
				+ inStock + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}