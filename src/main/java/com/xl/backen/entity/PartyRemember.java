package com.xl.backen.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 党员信息表(TbPartyRemember)实体类
 *
 * @author chendm
 * @since 2018-11-15 00:20:59
 */
public class PartyRemember implements Serializable {
  private static final long serialVersionUID = 756235740351665610L;

  private String uuid;
  //真实姓名
  private String truename;
  //社区id
  private String communityId;

  private Date createTime;

  private Date updateTime;
  //用户id
  private String userId;
  //手机号码
  private String phone;
  //党员类型1.直管党员 2.在职党员 3.退休党员
  private Integer type;

  // 1.通过 2.驳回
  private Integer status;

  private Integer pageSize;

  private Integer pageNum;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

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

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
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