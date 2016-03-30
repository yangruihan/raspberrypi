package com.xy.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Passenger entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "passenger", catalog = "sharingcar", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Passenger implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -4779344437219507222L;
	private Integer id;
	private String username;
	private String password;
	private String name;
	private String phoneNum;
	private Integer score;
	private Integer evaluateNum;
	private Set<Sharingcarconfirm> sharingcarconfirms = new HashSet<Sharingcarconfirm>(
			0);
	private Set<Drievaluation> drievaluations = new HashSet<Drievaluation>(0);
	private Set<Pasevaluation> pasevaluations = new HashSet<Pasevaluation>(0);
	private Set<Sharingcarapply> sharingcarapplies = new HashSet<Sharingcarapply>(
			0);

	// Constructors

	/** default constructor */
	public Passenger() {
	}

	/** minimal constructor */
	public Passenger(String username, String password, String name,
			String phoneNum, Integer score, Integer evaluateNum) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.phoneNum = phoneNum;
		this.score = score;
		this.evaluateNum = evaluateNum;
	}

	/** full constructor */
	public Passenger(String username, String password, String name,
			String phoneNum, Integer score, Integer evaluateNum,
			Set<Sharingcarconfirm> sharingcarconfirms,
			Set<Drievaluation> drievaluations,
			Set<Pasevaluation> pasevaluations,
			Set<Sharingcarapply> sharingcarapplies) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.phoneNum = phoneNum;
		this.score = score;
		this.evaluateNum = evaluateNum;
		this.sharingcarconfirms = sharingcarconfirms;
		this.drievaluations = drievaluations;
		this.pasevaluations = pasevaluations;
		this.sharingcarapplies = sharingcarapplies;
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

	@Column(name = "username", unique = true, nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phoneNum", nullable = false, length = 11)
	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Column(name = "score", nullable = false)
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "evaluateNum", nullable = false)
	public Integer getEvaluateNum() {
		return this.evaluateNum;
	}

	public void setEvaluateNum(Integer evaluateNum) {
		this.evaluateNum = evaluateNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "passenger")
	public Set<Sharingcarconfirm> getSharingcarconfirms() {
		return this.sharingcarconfirms;
	}

	public void setSharingcarconfirms(Set<Sharingcarconfirm> sharingcarconfirms) {
		this.sharingcarconfirms = sharingcarconfirms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "passenger")
	public Set<Drievaluation> getDrievaluations() {
		return this.drievaluations;
	}

	public void setDrievaluations(Set<Drievaluation> drievaluations) {
		this.drievaluations = drievaluations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "passenger")
	public Set<Pasevaluation> getPasevaluations() {
		return this.pasevaluations;
	}

	public void setPasevaluations(Set<Pasevaluation> pasevaluations) {
		this.pasevaluations = pasevaluations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "passenger")
	public Set<Sharingcarapply> getSharingcarapplies() {
		return this.sharingcarapplies;
	}

	public void setSharingcarapplies(Set<Sharingcarapply> sharingcarapplies) {
		this.sharingcarapplies = sharingcarapplies;
	}

}