package com.yrh.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable {

	// Fields

	private Integer gid;
	private String gname;
	private String gdesc;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Grade() {
	}

	/** minimal constructor */
	public Grade(String gname) {
		this.gname = gname;
	}

	/** full constructor */
	public Grade(String gname, String gdesc, Set students) {
		this.gname = gname;
		this.gdesc = gdesc;
		this.students = students;
	}
	
	
	// Property accessors

	@Override
	public String toString() {
		return "Grade [gid=" + gid + ", gname=" + gname + ", gdesc=" + gdesc
				+ ", students=" + students + "]";
	}

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGdesc() {
		return this.gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}