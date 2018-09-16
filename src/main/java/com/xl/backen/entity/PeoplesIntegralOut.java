package com.xl.backen.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class PeoplesIntegralOut implements Serializable {
    private static final long serialVersionUID = -5707219079491835483L;
    private String uuid;

    private String peopleId;

    @NotEmpty
    private String shopId;

    @NotEmpty
    private String shopName;

    @NotNull
    private Integer shopIntegral;

    @NotNull
    private Integer integral;

    @NotNull
    private Integer count;

    private Date createTime;

    @Override
    public String toString() {
        return "PeoplesIntegralOut{" +
                "uuid='" + uuid + '\'' +
                ", peopleId='" + peopleId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopIntegral=" + shopIntegral +
                ", integral=" + integral +
                ", count=" + count +
                ", createTime=" + createTime +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId == null ? null : peopleId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Integer getShopIntegral() {
        return shopIntegral;
    }

    public void setShopIntegral(Integer shopIntegral) {
        this.shopIntegral = shopIntegral;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}