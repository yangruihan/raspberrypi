package com.xy.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Complain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "complain", catalog = "sharingcar")
public class Complain implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -2903194703980673584L;
	private Integer id;
	private Integer passid;
	private Integer drivid;
	private String content;
	private Integer type;
	private Integer state;
	private String passName;
	private String drivName;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Complain() {
	}

	/** minimal constructor */
	public Complain(Integer passid, Integer drivid, Integer type,
			Integer state, Timestamp time) {
		this.passid = passid;
		this.drivid = drivid;
		this.type = type;
		this.state = state;
		this.time = time;
	}

	/** full constructor */
	public Complain(Integer passid, Integer drivid, String content,
			Integer type, Integer state, String passName, String drivName,
			Timestamp time) {
		this.passid = passid;
		this.drivid = drivid;
		this.content = content;
		this.type = type;
		this.state = state;
		this.passName = passName;
		this.drivName = drivName;
		this.time = time;
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

	@Column(name = "passid", nullable = false)
	public Integer getPassid() {
		return this.passid;
	}

	public void setPassid(Integer passid) {
		this.passid = passid;
	}

	@Column(name = "drivid", nullable = false)
	public Integer getDrivid() {
		return this.drivid;
	}

	public void setDrivid(Integer drivid) {
		this.drivid = drivid;
	}

	@Column(name = "content", length = 128)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "state", nullable = false)
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "passName", length = 32)
	public String getPassName() {
		return this.passName;
	}

	public void setPassName(String passName) {
		this.passName = passName;
	}

	@Column(name = "drivName", length = 32)
	public String getDrivName() {
		return this.drivName;
	}

	public void setDrivName(String drivName) {
		this.drivName = drivName;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}