package com.xy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "sharingcar", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class User implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 7080181733477245904L;
	private Integer id;
	private String name;
	private String password;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, length = 12)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 12)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}