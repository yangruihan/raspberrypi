package com.yrh.entity;

/**
 * Seller entity. @author MyEclipse Persistence Tools
 */

public class Seller implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String gender;
	private Integer star;

	// Constructors

	/** default constructor */
	public Seller() {
	}

	/** minimal constructor */
	public Seller(Integer star) {
		this.star = star;
	}

	/** full constructor */
	public Seller(String name, String gender, Integer star) {
		this.name = name;
		this.gender = gender;
		this.star = star;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", star=" + star + "]";
	}
	
	// Property accessors
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getStar() {
		return this.star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

}