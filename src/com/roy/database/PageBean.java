package com.roy.database;

import java.util.List;

/**
 * 分页信息类
 * @author Roy
 * @date: 2017年5月23日  下午8:43:39
 * version:
 */
public class PageBean {
	private List<? extends Object> list;//要返回的某一页的列表
	private int totalPage;//总页数
	private int currentPage;//当前页
	private int pageSize;//每页记录数
	private int totalRecord;//总记录数
	
	@SuppressWarnings("unused")
	private boolean isFirstPage;//是否为第一页
	@SuppressWarnings("unused")
	private boolean isLastPage;//是否为最后一页
	@SuppressWarnings("unused")
	private boolean hasPreviousPage;//是否有前一页
	@SuppressWarnings("unused")
	private boolean hasNextPage;
	
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<? extends Object> getList() {
		return list;
	}
	public void setList(List<? extends Object> list) {
		this.list = list;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
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
	
	/**
	 * 以下判断页信息
	 */
	public boolean isOver() {
		return currentPage > totalPage;
	}
	public boolean isFirstPage() {
		return currentPage == 1;
	}
	
	public boolean isLastPage() {
		return currentPage == totalPage;
	}
	
	public boolean isHasPreviousPage() {
		return currentPage != 1;
	}
	
	public boolean isHasNextPage() {
		return currentPage != totalPage;
	}
	
	/**
	 * 计算总页数
	 */
	public static int countTotalPage(final int pageSize, final int allRow) {
		int totalPage = allRow % pageSize == 0? allRow / pageSize : allRow / pageSize + 1;
		return totalPage;
	}
	/**
	 * 计算当前页
	 */
	public static int countCurrentPage(int page) {
		final int curPage = (page == 0? 1: page);
		return curPage;
	}
}
