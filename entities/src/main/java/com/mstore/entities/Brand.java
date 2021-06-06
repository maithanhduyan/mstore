/**
 * @author Mai Thành Duy An
 */
package com.mstore.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BRAND")
public class Brand implements BaseEntity {
	private static final long serialVersionUID = -8804328948000494995L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LINK_URL")
	private String linkURL;

	@Column(name = "IMAGE_URL")
	private String imageURL;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Brand [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description + ", linkURL="
				+ linkURL + ", imageURL=" + imageURL + ", active=" + active + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
