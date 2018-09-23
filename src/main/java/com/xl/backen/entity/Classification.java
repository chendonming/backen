package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Classification implements Serializable {
    private static final long serialVersionUID = -1681822154118417643L;

    private String uuid;

    private String name;

    private Date createTime;

    private Date updateTime;

    private Integer flag;

    private String upId;

    /**
     * 所属的classification: ------ 树形管理
     */
    private List<Classification> list;

    @Override
    public String toString() {
        return "Classification{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", flag=" + flag +
                ", upId='" + upId + '\'' +
                ", list=" + list +
                '}';
    }

    public List<Classification> getList() {
        return list;
    }

    public void setList(List<Classification> list) {
        this.list = list;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getUpId() {
        return upId;
    }

    public void setUpId(String upId) {
        this.upId = upId == null ? null : upId.trim();
    }
}