package com.yrh.model;

/**
 * 新闻类
 * @author Yrh
 *
 */
public class News {

	private int id;				// ID
	private String title;		// 新闻标题
	private String author;		// 新闻作者
	private int newsTypeId;		// 新闻类型id
	private int userId;			// 录入者id
	private String keywords;	// 关键字
	private String source;		// 新闻来源
	private String content;		// 新闻正文
	private String createTime;	// 新闻创建时间
	private int click;			// 点击量
	private int state;			// 状态（0：未审核；1：已发布；2：已废除）
	private int del;			// 是否被删除（0：未删除；1：已删除）
	
	public News() {
		id = 0;
		title = "";
		author = "";
		newsTypeId = 0;
		userId = 0;
		keywords = "";
		source = "";
		content = "";
		createTime = "";
		click = 0;
		state = 0;
		del = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNewsTypeId() {
		return newsTypeId;
	}
	public void setNewsTypeId(int newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
}
