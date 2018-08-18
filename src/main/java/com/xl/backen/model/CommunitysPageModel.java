package com.xl.backen.model;

import com.xl.backen.entity.Communitys;

import javax.validation.constraints.NotNull;

public class CommunitysPageModel extends Communitys {
	private static final long serialVersionUID = 8751937647474523595L;

	@NotNull
	private Integer pageSize;

	@NotNull
	private Integer pageNum;

	@Override
	public String toString() {
		return "CommunitysPageModel{" +
				"pageSize=" + pageSize +
				", pageNum=" + pageNum +
				",super=" +super.toString() +
				'}';
	}

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
