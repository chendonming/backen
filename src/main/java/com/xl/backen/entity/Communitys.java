package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;

public class Communitys implements Serializable {
	private static final long serialVersionUID = 1092957841392029071L;

	private String uuid;

	private String name;

	private Integer integral;

	private String createUser;

	private Integer totalIntegral;

	private String remark;

	private Integer status;

	private Date createTime;

	private Date updateTime;

	private String sysType;

	private String leaderName;

	private String leaderMobile;

	@Override
	public String toString() {
		return "Communitys{" +
			"uuid='" + uuid + '\'' +
			", name='" + name + '\'' +
			", integral=" + integral +
			", createUser='" + createUser + '\'' +
			", totalIntegral=" + totalIntegral +
			", remark='" + remark + '\'' +
			", status=" + status +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			'}';
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getLeaderMobile() {
		return leaderMobile;
	}

	public void setLeaderMobile(String leaderMobile) {
		this.leaderMobile = leaderMobile;
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

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public Integer getTotalIntegral() {
		return totalIntegral;
	}

	public void setTotalIntegral(Integer totalIntegral) {
		this.totalIntegral = totalIntegral;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
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