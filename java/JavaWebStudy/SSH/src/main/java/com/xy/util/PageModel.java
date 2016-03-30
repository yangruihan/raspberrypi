package com.xy.util;
/**
 * 分页模板类【初级版】
 * @author BearSmall
 *
 * @param <T>
 */
public class PageModel<T> {
	private int currentPage = 1;//当前页【默认值为1】
	private int pageSize = 15;//每页大小【默认值为15】
	private QueryResult<T> results;//一页数据
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//获取总页数
	public int getTotalPage() {
		return (int) ((results.getTotalCount()+pageSize-1)/pageSize);
	}
	public QueryResult<T> getResults() {
		return results;
	}
	public void setResults(QueryResult<T> results) {
		this.results = results;
	}
	
}