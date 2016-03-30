package com.xy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "car", catalog = "sharingcar")
public class Car implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 5180761458674659532L;
	private Integer id;
	private Driver driver;
	private String licensePlateNumber;
	private String type;
	private Integer seatNumber;
	private Integer haveAirCondition;

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** minimal constructor */
	public Car(Driver driver, String licensePlateNumber, String type,
			Integer seatNumber) {
		this.driver = driver;
		this.licensePlateNumber = licensePlateNumber;
		this.type = type;
		this.seatNumber = seatNumber;
	}

	/** full constructor */
	public Car(Driver driver, String licensePlateNumber, String type,
			Integer seatNumber, Integer haveAirCondition) {
		this.driver = driver;
		this.licensePlateNumber = licensePlateNumber;
		this.type = type;
		this.seatNumber = seatNumber;
		this.haveAirCondition = haveAirCondition;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driverID", nullable = false)
	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Column(name = "licensePlateNumber", nullable = false, length = 10)
	public String getLicensePlateNumber() {
		return this.licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	@Column(name = "type", nullable = false, length = 20)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "seatNumber", nullable = false)
	public Integer getSeatNumber() {
		return this.seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Column(name = "haveAirCondition")
	public Integer getHaveAirCondition() {
		return this.haveAirCondition;
	}

	public void setHaveAirCondition(Integer haveAirCondition) {
		this.haveAirCondition = haveAirCondition;
	}

}