package com.xl.backen.model;

import com.xl.backen.entity.Tasks;

/**
 * 分页返回的tasks  model
 */
public class TasksPageModel extends Tasks{

	private static final long serialVersionUID = 617271621304258547L;
  
 	 private int pageSize;

	private int pageNum;

	@Override
	public String toString() {
		return "TasksPageModel{" +
				"pageSize=" + pageSize +
				", pageNum=" + pageNum +
				",super=" +super.toString() +
				'}';
	}

	public Integer getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


}