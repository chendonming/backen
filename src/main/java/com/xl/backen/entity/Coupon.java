package com.xl.backen.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.io.Serializable;

/**
 * 优惠券(TbCoupon)实体类
 *
 * @author chendm
 * @since 2018-10-25 20:50:44
 */
public class Coupon implements Serializable {
  private static final long serialVersionUID = 472316951165130293L;

  private String uuid;

  private Date createTime;

  private Date updateTime;

  @NotBlank
  private String name;

  private String description;

  //开始时间
  @NotNull
  private Date startTime;
  //结束时间
  @NotNull
  private Date endTime;

  private Integer flag;

  private String merchantId;
  //社区id
  private String communityId;

  private Integer pageSize;

  private Integer pageNum;


  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public Integer getFlag() {
    return flag;
  }

  public void setFlag(Integer flag) {
    this.flag = flag;
  }

  public String getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  public String getCommunityId() {
    return communityId;
  }

  public void setCommunityId(String communityId) {
    this.communityId = communityId;
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