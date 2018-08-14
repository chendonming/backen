package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;

public class Peoples implements Serializable {
	private static final long serialVersionUID = 1474722109591883058L;

	private String uuid;

	private String nickname;

	private String truename;

	private String headPic;

	private String mobile;

	private Integer sex;

	private String password;

	private Integer isRealName;

	private String idCard;

	private String communityId;

	private String communityName;

	private Integer totalIntegral;

	private Integer integral;

	private Integer status;

	private Date createTime;

	private Date updateTime;

	private String sysType;

	private String role;

	private String openId;

	private String code;

	private String sessionId;

	private String description;

	@Override
	public String toString() {
		return "Peoples{" + "uuid='" + uuid + '\'' + ", nickname='" + nickname + '\'' + ", truename='" + truename + '\''
				+ ", headPic='" + headPic + '\'' + ", mobile='" + mobile + '\'' + ", sex=" + sex + ", password='" + password
				+ '\'' + ", isRealName=" + isRealName + ", idCard='" + idCard + '\'' + ", communityId='" + communityId + '\''
				+ ", totalIntegral=" + totalIntegral + ", integral=" + integral + ", status=" + status + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", sysType='" + sysType + '\'' + ", role=" + role + ", openId='"
				+ openId + '\'' + ", code='" + code + '\'' + ", sessionId='" + sessionId + '\'' + '}';
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Peoples) {
			Peoples peoples = (Peoples) obj;
			if (peoples.mobile.equals(this.mobile)) {
				// 手机号码相同 相等
				return true;
			}
		}
		return super.equals(obj);
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getSysType() {
		return sysType;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename == null ? null : truename.trim();
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic == null ? null : headPic.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getIsRealName() {
		return isRealName;
	}

	public void setIsRealName(Integer isRealName) {
		this.isRealName = isRealName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId == null ? null : communityId.trim();
	}

	public Integer getTotalIntegral() {
		return totalIntegral;
	}

	public void setTotalIntegral(Integer totalIntegral) {
		this.totalIntegral = totalIntegral;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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