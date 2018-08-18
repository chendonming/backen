package com.xl.backen.model;

import java.io.Serializable;

/**
 * 志愿者model
 */
public class VolunteerModel implements Serializable {
    private static final long serialVersionUID = 1425940435476843175L;
    private String uuid;

    private String truename;

    private String mobile;

    private String description;

    private Integer role;

    private String identityFlag;

    private Integer pageSize;

    private Integer pageNum;

    @Override
    public String toString() {
        return "VolunteerModel{" +
                "uuid='" + uuid + '\'' +
                ", truename='" + truename + '\'' +
                ", mobile='" + mobile + '\'' +
                ", description='" + description + '\'' +
                ", role=" + role +
                ", identityFlag='" + identityFlag + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }

    public String getIdentityFlag() {
        return identityFlag;
    }

    public void setIdentityFlag(String identityFlag) {
        this.identityFlag = identityFlag;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTruename() {
        return this.truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}