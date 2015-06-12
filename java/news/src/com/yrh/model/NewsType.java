package com.yrh.model;

/**
 * ����������
 * @author Yrh
 *
 */
public class NewsType {

	private int id;					// ��������id
	private String name;			// ������������
	private String description;		// ������������
	private String createTime;		// ����ʱ��
	private int orders;				// ��������Ĭ��0������
	private int del;				// �Ƿ�ɾ����0��δɾ����1����ɾ����
	
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
