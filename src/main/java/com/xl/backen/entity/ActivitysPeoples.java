package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;

public class ActivitysPeoples implements Serializable {

  private static final long serialVersionUID = -6657649078619444148L;

  private String uuid;

  private String activityId;

  private String peopleId;

  private Date createTime;

  private Date updateTime;

  @Override
  public String toString() {
    return "ActivitysPeoples{" +
      "uuid='" + uuid + '\'' +
      ", activityId='" + activityId + '\'' +
      ", peopleId='" + peopleId + '\'' +
      ", createTime=" + createTime +
      ", updateTime=" + updateTime +
      '}';
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid == null ? null : uuid.trim();
  }

  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId == null ? null : activityId.trim();
  }

  public String getPeopleId() {
    return peopleId;
  }

  public void setPeopleId(String peopleId) {
    this.peopleId = peopleId == null ? null : peopleId.trim();
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