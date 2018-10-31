package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;

public class WxUsers implements Serializable {
    private static final long serialVersionUID = -6429899944610385873L;
    private String uuid;

    private String nickName;

    private Integer isRealName;

    private String openId;

    private String bindUser;

    private Integer gender;

    private String avatarUrl;

    //微信临时code
    private String code;

    private Date createTime;

    private Date updateTime;

    private String appId;

    @Override
    public String toString() {
        return "WxUsers{" +
          "uuid='" + uuid + '\'' +
          ", nickName='" + nickName + '\'' +
          ", isRealName=" + isRealName +
          ", openId='" + openId + '\'' +
          ", bindUser='" + bindUser + '\'' +
          ", gender=" + gender +
          ", avatarUrl='" + avatarUrl + '\'' +
          ", code='" + code + '\'' +
          ", createTime=" + createTime +
          ", updateTime=" + updateTime +
          '}';
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getIsRealName() {
        return isRealName;
    }

    public void setIsRealName(Integer isRealName) {
        this.isRealName = isRealName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getBindUser() {
        return bindUser;
    }

    public void setBindUser(String bindUser) {
        this.bindUser = bindUser == null ? null : bindUser.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
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