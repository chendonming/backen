package com.xl.backen.model;

import java.util.List;

import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.ActivitysPeoples;
import com.xl.backen.entity.Peoples;

/**
 * ActivitysPeopleModel
 */
public class ActivitysPeopleModel extends ActivitysPeoples {

  private static final long serialVersionUID = -594070191450500242L;

  private List<Activitys> activitysList;

  private List<Peoples> peoplesList;

  private Integer pageSize;

  private Integer pageNum;

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



  public List<Activitys> getActivitysList() {
    return this.activitysList;
  }

  public void setActivitysList(List<Activitys> activitysList) {
    this.activitysList = activitysList;
  }

  public List<Peoples> getPeoplesList() {
    return this.peoplesList;
  }

  public void setPeoplesList(List<Peoples> peoplesList) {
    this.peoplesList = peoplesList;
  }

}