package com.yrh.model;

/**
 * 新闻类型类
 * @author Yrh
 *
 */
public class NewsType {

	private int id;					// 新闻类型id
	private String name;			// 新闻类型名称
	private String description;		// 新闻类型描述
	private String createTime;		// 创建时间
	private int orders;				// 用于排序（默认0不排序）
	private int del;				// 是否被删除（0：未删除；1：已删除）
	
	public NewsType() {
		id = 0;
		name = "";
		description = "";
		createTime = "";
		orders = 0;
		del = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
	
}
