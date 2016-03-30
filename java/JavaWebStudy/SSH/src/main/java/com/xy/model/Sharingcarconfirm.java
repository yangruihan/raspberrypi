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
 * Sharingcarconfirm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sharingcarconfirm", catalog = "sharingcar")
public class Sharingcarconfirm implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 3987674484965008500L;
	private Integer id;
	private Sharingcarinfo sharingcarinfo;
	private Passenger passenger;
	private Sharingcarapply sharingcarapply;
	private Driver driver;
	private Timestamp confirm;
	private Timestamp drivSafeTime;
	private String drivSafeNum;
	private Timestamp passSafeTime;
	private String passSafeNum;
	private Integer drivConfirm;
	private Integer passConfirm;
	private Integer driverConfirm;
	private Integer pasConfirm;

	// Constructors

	/** default constructor */
	public Sharingcarconfirm() {
	}

	/** minimal constructor */
	public Sharingcarconfirm(Timestamp confirm, Integer driverConfirm,
			Integer pasConfirm) {
		this.confirm = confirm;
		this.driverConfirm = driverConfirm;
		this.pasConfirm = pasConfirm;
	}

	/** full constructor */
	public Sharingcarconfirm(Sharingcarinfo sharingcarinfo,
			Passenger passenger, Sharingcarapply sharingcarapply,
			Driver driver, Timestamp confirm, Timestamp drivSafeTime,
			String drivSafeNum, Timestamp passSafeTime, String passSafeNum,
			Integer drivConfirm, Integer passConfirm, Integer driverConfirm,
			Integer pasConfirm) {
		this.sharingcarinfo = sharingcarinfo;
		this.passenger = passenger;
		this.sharingcarapply = sharingcarapply;
		this.driver = driver;
		this.confirm = confirm;
		this.drivSafeTime = drivSafeTime;
		this.drivSafeNum = drivSafeNum;
		this.passSafeTime = passSafeTime;
		this.passSafeNum = passSafeNum;
		this.drivConfirm = drivConfirm;
		this.passConfirm = passConfirm;
		this.driverConfirm = driverConfirm;
		this.pasConfirm = pasConfirm;
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
	@JoinColumn(name = "carInfo")
	public Sharingcarinfo getSharingcarinfo() {
		return this.sharingcarinfo;
	}

	public void setSharingcarinfo(Sharingcarinfo sharingcarinfo) {
		this.sharingcarinfo = sharingcarinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pasID")
	public Passenger getPassenger() {
		return this.passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carApply")
	public Sharingcarapply getSharingcarapply() {
		return this.sharingcarapply;
	}

	public void setSharingcarapply(Sharingcarapply sharingcarapply) {
		this.sharingcarapply = sharingcarapply;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driverID")
	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Column(name = "confirm", nullable = false, length = 19)
	public Timestamp getConfirm() {
		return this.confirm;
	}

	public void setConfirm(Timestamp confirm) {
		this.confirm = confirm;
	}

	@Column(name = "driv_safe_time", length = 19)
	public Timestamp getDrivSafeTime() {
		return this.drivSafeTime;
	}

	public void setDrivSafeTime(Timestamp drivSafeTime) {
		this.drivSafeTime = drivSafeTime;
	}

	@Column(name = "driv_safe_num", length = 11)
	public String getDrivSafeNum() {
		return this.drivSafeNum;
	}

	public void setDrivSafeNum(String drivSafeNum) {
		this.drivSafeNum = drivSafeNum;
	}

	@Column(name = "pass_safe_time", length = 19)
	public Timestamp getPassSafeTime() {
		return this.passSafeTime;
	}

	public void setPassSafeTime(Timestamp passSafeTime) {
		this.passSafeTime = passSafeTime;
	}

	@Column(name = "pass_safe_num", length = 11)
	public String getPassSafeNum() {
		return this.passSafeNum;
	}

	public void setPassSafeNum(String passSafeNum) {
		this.passSafeNum = passSafeNum;
	}

	@Column(name = "driv_confirm")
	public Integer getDrivConfirm() {
		return this.drivConfirm;
	}

	public void setDrivConfirm(Integer drivConfirm) {
		this.drivConfirm = drivConfirm;
	}

	@Column(name = "pass_confirm")
	public Integer getPassConfirm() {
		return this.passConfirm;
	}

	public void setPassConfirm(Integer passConfirm) {
		this.passConfirm = passConfirm;
	}

	@Column(name = "driverConfirm", nullable = false)
	public Integer getDriverConfirm() {
		return this.driverConfirm;
	}

	public void setDriverConfirm(Integer driverConfirm) {
		this.driverConfirm = driverConfirm;
	}

	@Column(name = "pasConfirm", nullable = false)
	public Integer getPasConfirm() {
		return this.pasConfirm;
	}

	public void setPasConfirm(Integer pasConfirm) {
		this.pasConfirm = pasConfirm;
	}

}