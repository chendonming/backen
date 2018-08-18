package com.xl.backen.model;

import com.xl.backen.entity.Peoples;

public class PeoplesPageModel extends Peoples{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8233070428891783382L;
	
	private Integer pageNum;
	
	private Integer pageSize;

	@Override
	public String toString() {
		return "PeoplesPageModel{" +
				"pageNum=" + pageNum +
				", pageSize=" + pageSize +
				",super=" +super.toString() +
				'}';
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
}
