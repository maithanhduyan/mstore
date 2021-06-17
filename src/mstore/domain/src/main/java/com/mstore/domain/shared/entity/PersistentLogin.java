package com.mstore.domain.shared.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "PERSISTENT_LOGINS")
public class PersistentLogin {
	@Id
	@Column(name = "ID")
	String id;
	@Column(name = "USERNAME")
	String username;
	@Column(name = "SERIES")
	String series;
	@Column(name = "TOKEN")
	String token;
	@Column(name = "LASTUSED")
	@Temporal(TemporalType.TIMESTAMP)
	Date lastUsed;
}
