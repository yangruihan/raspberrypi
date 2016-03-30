package com.xy.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Pasevaluation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pasevaluation", catalog = "sharingcar")
public class Pasevaluation implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 4129561839647437612L;
	private Integer id;
	private Passenger passenger;
	private Driver driver;
	private Timestamp time;
	private Integer score;
	private String leaveMsg;

	// Constructors

	/** default constructor */
	public Pasevaluation() {
	}

	/** minimal constructor */
	public Pasevaluation(Passenger passenger, Driver driver, Timestamp time,
			Integer score) {
		this.passenger = passenger;
		this.driver = driver;
		this.time = time;
		this.score = score;
	}

	/** full constructor */
	public Pasevaluation(Passenger passenger, Driver driver, Timestamp time,
			Integer score, String leaveMsg) {
		this.passenger = passenger;
		this.driver = driver;
		this.time = time;
		this.score = score;
		this.leaveMsg = leaveMsg;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driverID", nullable = false)
	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "score", nullable = false)
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "leaveMsg", length = 65535)
	public String getLeaveMsg() {
		return this.leaveMsg;
	}

	public void setLeaveMsg(String leaveMsg) {
		this.leaveMsg = leaveMsg;
	}

}