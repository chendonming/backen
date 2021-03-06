package com.xl.backen.model;

import java.util.List;

public class RolesPowerModel {
	private String roleId;

	private List<String> powers;

	@Override
	public String toString() {
		return "RolesPowerModel{" +
				"roleId='" + roleId + '\'' +
				", powers=" + powers +
				",super=" +super.toString() +
				'}';
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<String> getPowers() {
		return powers;
	}

	public void setPowers(List<String> powers) {
		this.powers = powers;
	}
}
