package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;

public class PeoplesShop implements Serializable {
    private static final long serialVersionUID = -327134205967064526L;
    private String uuid;

    private String peopleId;

    private String shopId;

    private Integer count;

    private Integer status;

    private Date createTime;

    @Override
    public String toString() {
        return "PeoplesShop{" +
                "uuid='" + uuid + '\'' +
                ", peopleId='" + peopleId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", count=" + count +
                ", status=" + status +
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
}