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
 * Sharingcarinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sharingcarinfo", catalog = "sharingcar")
public class Sharingcarinfo implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 5126005476199473904L;
	private Integer id;
	private Driver driver;
	private Float totalDistance;
	private String start;
	private String end;
	private Timestamp time;
	private Integer state;
	private String carType;
	private Float gasolineCosts;
	private Float onewayCosts;
	private Integer maxPasNum;
	private Integer nowPasNum;
	private String addedInfo;
	private Set<Sharingcarconfirm> sharingcarconfirms = new HashSet<Sharingcarconfirm>(
			0);

	// Constructors

	/** default constructor */
	public Sharingcarinfo() {
	}

	/** minimal constructor */
	public Sharingcarinfo(Driver driver, Float totalDistance, String start,
			String end, Timestamp time, Integer maxPasNum, Integer nowPasNum) {
		this.driver = driver;
		this.totalDistance = totalDistance;
		this.start = start;
		this.end = end;
		this.time = time;
		this.maxPasNum = maxPasNum;
		this.nowPasNum = nowPasNum;
	}

	/** full constructor */
	public Sharingcarinfo(Driver driver, Float totalDistance, String start,
			String end, Timestamp time, Integer state, String carType,
			Float gasolineCosts, Float onewayCosts, Integer maxPasNum,
			Integer nowPasNum, String addedInfo,
			Set<Sharingcarconfirm> sharingcarconfirms) {
		this.driver = driver;
		this.totalDistance = totalDistance;
		this.start = start;
		this.end = end;
		this.time = time;
		this.state = state;
		this.carType = carType;
		this.gasolineCosts = gasolineCosts;
		this.onewayCosts = onewayCosts;
		this.maxPasNum = maxPasNum;
		this.nowPasNum = nowPasNum;
		this.addedInfo = addedInfo;
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
	@JoinColumn(name = "driverID", nullable = false)
	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Column(name = "totalDistance", nullable = false, precision = 12, scale = 0)
	public Float getTotalDistance() {
		return this.totalDistance;
	}

	public void setTotalDistance(Float totalDistance) {
		this.totalDistance = totalDistance;
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

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "carType", length = 20)
	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Column(name = "gasolineCosts", precision = 12, scale = 0)
	public Float getGasolineCosts() {
		return this.gasolineCosts;
	}

	public void setGasolineCosts(Float gasolineCosts) {
		this.gasolineCosts = gasolineCosts;
	}

	@Column(name = "onewayCosts", precision = 12, scale = 0)
	public Float getOnewayCosts() {
		return this.onewayCosts;
	}

	public void setOnewayCosts(Float onewayCosts) {
		this.onewayCosts = onewayCosts;
	}

	@Column(name = "maxPasNum", nullable = false)
	public Integer getMaxPasNum() {
		return this.maxPasNum;
	}

	public void setMaxPasNum(Integer maxPasNum) {
		this.maxPasNum = maxPasNum;
	}

	@Column(name = "nowPasNum", nullable = false)
	public Integer getNowPasNum() {
		return this.nowPasNum;
	}

	public void setNowPasNum(Integer nowPasNum) {
		this.nowPasNum = nowPasNum;
	}

	@Column(name = "addedInfo", length = 65535)
	public String getAddedInfo() {
		return this.addedInfo;
	}

	public void setAddedInfo(String addedInfo) {
		this.addedInfo = addedInfo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sharingcarinfo")
	public Set<Sharingcarconfirm> getSharingcarconfirms() {
		return this.sharingcarconfirms;
	}

	public void setSharingcarconfirms(Set<Sharingcarconfirm> sharingcarconfirms) {
		this.sharingcarconfirms = sharingcarconfirms;
	}

}