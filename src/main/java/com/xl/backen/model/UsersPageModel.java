package com.xl.backen.model;

import com.xl.backen.entity.Users;

public class UsersPageModel extends Users {
	private static final long serialVersionUID = 3169195159548108536L;

	private Integer pageSize;

	private Integer pageNum;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}
