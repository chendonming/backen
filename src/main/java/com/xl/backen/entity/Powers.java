package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;

public class Powers implements Serializable {

    private static final long serialVersionUID = -4385605550931291948L;
    private String uuid;

    private String code;

    private String meunName;

    private String description;

    private Date createTime;

    private Date updateTime;

    private String upMenusId;

    private String upMenusName;

    /**
     * 管理后台的标识（1.后台 2.社区）
     */
    private Integer type;

    private Integer weight;

    private String frontPath;

    /**
     * 菜单类型 （1. 主菜单 2. 次级菜单）
     */
    private Integer meunType;

    @Override
    public String toString() {
        return "Powers{" +
                "uuid='" + uuid + '\'' +
                ", code='" + code + '\'' +
                ", meunName='" + meunName + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", upMenusId='" + upMenusId + '\'' +
                ", upMenusName='" + upMenusName + '\'' +
                ", type=" + type +
                ", weight=" + weight +
                ", frontPath='" + frontPath + '\'' +
                '}';
    }

    public Integer getMeunType() {
        return meunType;
    }

    public void setMeunType(Integer meunType) {
        this.meunType = meunType;
    }

    public String getFrontPath() {
        return frontPath;
    }

    public void setFrontPath(String frontPath) {
        this.frontPath = frontPath;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUpMenusId() {
        return upMenusId;
    }

    public void setUpMenusId(String upMenusId) {
        this.upMenusId = upMenusId;
    }

    public String getUpMenusName() {
        return upMenusName;
    }

    public void setUpMenusName(String upMenusName) {
        this.upMenusName = upMenusName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMeunName() {
        return meunName;
    }

    public void setMeunName(String meunName) {
        this.meunName = meunName;
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