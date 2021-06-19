package com.mstore.domain.person.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Address implements Serializable {
	private static final long serialVersionUID = 5673264011152883127L;

	@Id
	@Column(name = "ID", nullable = false)
	private String id;

	@Column(name = "ADDRESS_LINE1", nullable = false)
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	@Column(name = "CITY")
	private String city;

	public Address() {
	}
}
