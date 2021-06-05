/**
 * @author Mai Thành Duy An
 */
package com.mstore.entities;

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

@Entity
@Table(name = "SHOPPING_CART_ITEM")
public class ShoppingCartItem implements Serializable {

	private static final long serialVersionUID = -5595151840280526776L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOPPING_CART_ID", nullable = false, //
			foreignKey = @ForeignKey(name = "SHOPPING_CART_ITEM_SHOPPING_CART_FK"))
	private ShoppingCart shoppingCartId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", nullable = false, //
			foreignKey = @ForeignKey(name = "SHOPPING_CART_ITEM_PRODUCT_FK"))
	private Product product;

	@Column(name = "QUANTITY", nullable = false)
	private int quanity;

	@Column(name = "AMOUNT", nullable = false)
	private double amount;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "ACTIVE")
	private int active;

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

	public ShoppingCartItem() {
	}

	public ShoppingCartItem(String id, ShoppingCart shoppingCartId, Product product, int quanity, double amount,
			String createdBy, int active, String updatedBy, Date createdDate, Date updatedDate, String description) {
		super();
		this.id = id;
		this.shoppingCartId = shoppingCartId;
		this.product = product;
		this.quanity = quanity;
		this.amount = amount;
		this.createdBy = createdBy;
		this.active = active;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.description = description;
	}

	private static ShoppingCartItem _shoppingCartItem;

	public static ShoppingCartItem getInstance() {
		if (_shoppingCartItem == null) {
			_shoppingCartItem = new ShoppingCartItem();
		}
		return _shoppingCartItem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ShoppingCart getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(ShoppingCart shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
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

	public static ShoppingCartItem get_shoppingCartItem() {
		return _shoppingCartItem;
	}

	public static void set_shoppingCartItem(ShoppingCartItem _shoppingCartItem) {
		ShoppingCartItem._shoppingCartItem = _shoppingCartItem;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [id=" + id + ", shoppingCartId=" + shoppingCartId + ", product=" + product
				+ ", quanity=" + quanity + ", amount=" + amount + ", createdBy=" + createdBy + ", active=" + active
				+ ", updatedBy=" + updatedBy + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", description=" + description + "]";
	}

}
