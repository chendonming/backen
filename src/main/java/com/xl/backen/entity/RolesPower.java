package com.xl.backen.entity;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class RolesPower implements Serializable {
	private static final long serialVersionUID = 135783863513366425L;

	private String uuid;

	@NotEmpty
	private String powerId;

	@NotEmpty
	private String roleId;

	private Integer status;

	@Override
	public String toString() {
		return "{" +
			" uuid='" + getUuid() + "'" +
			", powerId='" + getPowerId() + "'" +
			", roleId='" + getRoleId() + "'" +
			", status='" + getStatus() + "'" +
			"}";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RolesPower) {
			RolesPower rp = (RolesPower) obj;
			if (this.roleId.equals(rp.getRoleId()) && this.powerId.equals(rp.getPowerId())) {
				return true;
			} else {
				return false;
			}
		} else {
			return super.equals(obj);
		}
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	public String getPowerId() {
		return powerId;
	}

	public void setPowerId(String powerId) {
		this.powerId = powerId == null ? null : powerId.trim();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}
}