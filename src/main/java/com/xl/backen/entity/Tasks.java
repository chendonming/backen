package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;

public class Tasks implements Serializable {

    private static final long serialVersionUID = -186100421421128053L;

    private String uuid;

    private String name;

    private String communityId;

    private String communityName;

    private Date startTime;

    private Date endTime;

    private String location;

    private Integer limitPeople;

    private Integer integral;

    private Integer joinPeople;

    private Integer dataForm;

    private String createUser;

    private String createName;

    private String coverpic;

    private String description;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private Integer flag;

    private String sysType;

    /*是否已经兑换积分*/
    private Boolean isDistribute;

    @Override
    public String toString() {
        return "{" +
                " uuid='" + getUuid() + "'" +
                ", name='" + getName() + "'" +
                ", communityId='" + getCommunityId() + "'" +
                ", startTime='" + getStartTime() + "'" +
                ", endTime='" + getEndTime() + "'" +
                ", location='" + getLocation() + "'" +
                ", limitPeople='" + getLimitPeople() + "'" +
                ", integral='" + getIntegral() + "'" +
                ", joinPeople='" + getJoinPeople() + "'" +
                ", dataForm='" + getDataForm() + "'" +
                ", createUser='" + getCreateUser() + "'" +
                ", coverpic='" + getCoverpic() + "'" +
                ", description='" + getDescription() + "'" +
                ", createTime='" + getCreateTime() + "'" +
                ", updateTime='" + getUpdateTime() + "'" +
                ", status='" + getStatus() + "'" +
                "}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tasks) {
            Tasks tasks = (Tasks) obj;
            if (tasks.uuid.equals(this.uuid)) {
                return true;
            } else {
                return false;
            }
        } else {
            return super.equals(obj);
        }
    }

    public Boolean getDistribute() {
        return isDistribute;
    }

    public void setDistribute(Boolean distribute) {
        isDistribute = distribute;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getStatus() {
        return this.status;
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

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId == null ? null : communityId.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getLimitPeople() {
        return limitPeople;
    }

    public void setLimitPeople(Integer limitPeople) {
        this.limitPeople = limitPeople;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getJoinPeople() {
        return joinPeople;
    }

    public void setJoinPeople(Integer joinPeople) {
        this.joinPeople = joinPeople;
    }

    public Integer getDataForm() {
        return dataForm;
    }

    public void setDataForm(Integer dataForm) {
        this.dataForm = dataForm;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCoverpic() {
        return coverpic;
    }

    public void setCoverpic(String coverpic) {
        this.coverpic = coverpic == null ? null : coverpic.trim();
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