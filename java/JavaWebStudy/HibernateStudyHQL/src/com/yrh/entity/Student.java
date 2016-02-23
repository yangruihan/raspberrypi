package com.yrh.entity;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Grade grade;
	private String gname;
	private String gender;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String gname) {
		this.gname = gname;
	}

	/** full constructor */
	public Student(Grade grade, String gname, String gender) {
		this.grade = grade;
		this.gname = gname;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", grade name=" + grade.getGname() + ", gname=" + gname
				+ ", gender=" + gender + "]";
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}