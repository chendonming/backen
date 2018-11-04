package com.xl.backen.entity;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.io.Serializable;

/**
 * 党员信息表(TbPartyRemember)实体类
 *
 * @author chendm
 * @since 2018-11-01 22:08:03
 */
public class PartyRemember implements Serializable {
  private static final long serialVersionUID = 435141074098036932L;

  private String uuid;
  //真实姓名
  @NotBlank
  private String truename;
  //社区id
  @NotBlank
  private String communityId;

  private Date createTime;

  private Date updateTime;
  //用户id
  private String userId;
  //手机号码
  @NotBlank
  private String phone;

  private Integer pageSize;

  private Integer pageNum;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getTruename() {
    return truename;
  }

  public void setTruename(String truename) {
    this.truename = truename;
  }

  public String getCommunityId() {
    return communityId;
  }

  public void setCommunityId(String communityId) {
    this.communityId = communityId;
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

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }
}