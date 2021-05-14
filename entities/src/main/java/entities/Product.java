package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
@Entity
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2629599562342979524L;
	@Id
	@Column(name = "PRODUCT_ID", unique=true, nullable=false)
	@GeneratedValue(generator = "UUID")
	private String id;
	
	private String name;
	
}
