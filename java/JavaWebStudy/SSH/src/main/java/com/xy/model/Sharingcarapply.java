package com.xy.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sharingcarapply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sharingcarapply", catalog = "sharingcar")
public class Sharingcarapply implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 7417676573458191757L;
	private Integer id;
	private Passenger passenger;
	private Float price;
	private String carType;
	private String sharingCarType;
	private String start;
	private String end;
	private Timestamp time;
	private Set<Sharingcarconfirm> sharingcarconfirms = new HashSet<Sharingcarconfirm>(
			0);

	// Constructors

	/** default constructor */
	public Sharingcarapply() {
	}

	/** minimal constructor */
	public Sharingcarapply(Passenger passenger, Float price, String carType,
			String sharingCarType, String start, String end, Timestamp time) {
		this.passenger = passenger;
		this.price = price;
		this.carType = carType;
		this.sharingCarType = sharingCarType;
		this.start = start;
		this.end = end;
		this.time = time;
	}

	/** full constructor */
	public Sharingcarapply(Passenger passenger, Float price, String carType,
			String sharingCarType, String start, String end, Timestamp time,
			Set<Sharingcarconfirm> sharingcarconfirms) {
		this.passenger = passenger;
		this.price = price;
		this.carType = carType;
		this.sharingCarType = sharingCarType;
		this.start = start;
		this.end = end;
		this.time = time;
		this.sharingcarconfirms = sharingcarconfirms;
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
	@JoinColumn(name = "pasID", nullable = false)
	public Passenger getPassenger() {
		return this.passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@Column(name = "price", nullable = false, precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "carType", nullable = false, length = 20)
	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Column(name = "sharingCarType", nullable = false, length = 50)
	public String getSharingCarType() {
		return this.sharingCarType;
	}

	public void setSharingCarType(String sharingCarType) {
		this.sharingCarType = sharingCarType;
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

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sharingcarapply")
	public Set<Sharingcarconfirm> getSharingcarconfirms() {
		return this.sharingcarconfirms;
	}

	public void setSharingcarconfirms(Set<Sharingcarconfirm> sharingcarconfirms) {
		this.sharingcarconfirms = sharingcarconfirms;
	}

}