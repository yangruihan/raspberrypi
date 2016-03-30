package com.xy.util;

import java.util.List;
/**
 * 查询结果集模板类【初级版】
 * @author BearSmall
 *
 * @param <T>
 */
public class QueryResult<T> {
	private long totalCount;//总的记录数
	private List<T> datas;//一次查询出来的数据集
	
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
}
