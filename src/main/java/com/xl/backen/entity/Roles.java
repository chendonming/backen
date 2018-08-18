package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Roles implements Serializable {
	private static final long serialVersionUID = -7196094634505335416L;
	private String uuid;

	@NotEmpty
	private String name;

	private String description;

	private Date createTime;

	private Date updateTime;

	@Max(value = 2)
	@Min(value = 1)
	private Integer status;

	private String sysType;

	private String createUser;

	@Override
	public String toString() {
		return "Roles{" +
				"uuid='" + uuid + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", status=" + status +
				", sysType='" + sysType + '\'' +
				", createUser='" + createUser + '\'' +
				'}';
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getSysType() {
		return sysType;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}