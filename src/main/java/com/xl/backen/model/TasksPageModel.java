package com.xl.backen.model;

import com.xl.backen.entity.Tasks;

/**
 * 分页返回的tasks  model
 */
public class TasksPageModel extends Tasks{

	private static final long serialVersionUID = 617271621304258547L;
  
  private int pageSize;

	private int pageNum;
	
	private Integer flag;

	public Integer getPageSize() {
		return this.pageSize;
	}

	/**
	 * @return the flag
	 */
	public Integer getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
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