package com.xy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * City2cityinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "city2cityinfo", catalog = "sharingcar")
public class City2cityinfo implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 2864979897352099893L;
	private Integer id;
	private String start;
	private String end;
	private Float mileage;
	private String spendTime;
	private Float oilCost;
	private Float roadToll;

	// Constructors

	/** default constructor */
	public City2cityinfo() {
	}

	/** full constructor */
	public City2cityinfo(String start, String end, Float mileage,
			String spendTime, Float oilCost, Float roadToll) {
		this.start = start;
		this.end = end;
		this.mileage = mileage;
		this.spendTime = spendTime;
		this.oilCost = oilCost;
		this.roadToll = roadToll;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "start", nullable = false, length = 50)
	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Column(name = "end", nullable = false, length = 50)
	public String getEnd() {
		return this.end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Column(name = "mileage", nullable = false, precision = 12, scale = 0)
	public Float getMileage() {
		return this.mileage;
	}

	public void setMileage(Float mileage) {
		this.mileage = mileage;
	}

	@Column(name = "spendTime", nullable = false, length = 50)
	public String getSpendTime() {
		return this.spendTime;
	}

	public void setSpendTime(String spendTime) {
		this.spendTime = spendTime;
	}

	@Column(name = "oilCost", nullable = false, precision = 12, scale = 0)
	public Float getOilCost() {
		return this.oilCost;
	}

	public void setOilCost(Float oilCost) {
		this.oilCost = oilCost;
	}

	@Column(name = "roadToll", nullable = false, precision = 12, scale = 0)
	public Float getRoadToll() {
		return this.roadToll;
	}

	public void setRoadToll(Float roadToll) {
		this.roadToll = roadToll;
	}

}