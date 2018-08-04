package com.xl.backen.model;

import com.xl.backen.entity.ParentMenus;
import com.xl.backen.entity.Roles;
import com.xl.backen.entity.Users;

import java.util.List;

public class UsersModel extends Users {
	private static final long serialVersionUID = 8667663881929794946L;
	private List<Roles> roles;
	private List<ParentMenus> parentMenus;

	public List<Roles> getRoles() {
		return roles;
	}

	/**
	 * @return the parentMenus
	 */
	public List<ParentMenus> getParentMenus() {
		return parentMenus;
	}

	/**
	 * @param parentMenus the parentMenus to set
	 */
	public void setParentMenus(List<ParentMenus> parentMenus) {
		this.parentMenus = parentMenus;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
}
