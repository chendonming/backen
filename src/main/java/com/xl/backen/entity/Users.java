package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class Users implements Serializable{
	
    private static final long serialVersionUID = -6786945409233275148L;

	private String uuid;

    private String nickname;

    private String truename;

    private String headPic;

    @NotEmpty
    private String mobile;

    private Integer sex;

    private Integer isRealName;

    private String idCard;
    
    private String password;

    private String communityId;

    private Integer totalIntegral;

    private Integer integral;

    private Integer status;

    private Date createTime;

    private Date updateTime;

	@Override
	public String toString() {
		return "{" +
			" uuid='" + getUuid() + "'" +
			", nickname='" + getNickname() + "'" +
			", truename='" + getTruename() + "'" +
			", headPic='" + getHeadPic() + "'" +
			", mobile='" + getMobile() + "'" +
			", sex='" + getSex() + "'" +
			", isRealName='" + getIsRealName() + "'" +
			", idCard='" + getIdCard() + "'" +
			", password='" + getPassword() + "'" +
			", communityId='" + getCommunityId() + "'" +
			", totalIntegral='" + getTotalIntegral() + "'" +
			", integral='" + getIntegral() + "'" +
			", status='" + getStatus() + "'" +
			", createTime='" + getCreateTime() + "'" +
			", updateTime='" + getUpdateTime() + "'" +
			"}";
	}

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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