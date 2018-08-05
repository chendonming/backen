package com.xl.backen.model;

import com.xl.backen.entity.Peoples;

public class PeopleCodeModel extends Peoples {
	private static final long serialVersionUID = 1970932503058867032L;

	// code
	private String code;

	//头像
	private String avatarUrl;

	//性别
	private Integer gender;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
}
