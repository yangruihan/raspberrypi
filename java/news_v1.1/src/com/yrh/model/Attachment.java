package com.yrh.model;

/**
 * ������
 * @author Yrh
 *
 */
public class Attachment {
	private int id;				// ����id
	private int news_id;		// ����id
	private String fileName;	// ������
	private String path;		// ����·��
	private String type;		// ��������
	private String uploadTime;	// �ϴ�ʱ��
	private int del;			// �Ƿ�ɾ��
	
	public Attachment() {
		id = 0;
		news_id = 0;
		fileName = "";
		path = "";
		type = "";
		uploadTime = "";
		del = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNews_id() {
		return news_id;
	}

	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
	
}
