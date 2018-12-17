package com.xl.backen.entity;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

/**
 * (TbMerchant)实体类
 *
 * @author chendm
 * @since 2018-11-14 21:24:46
 */
public class Merchant implements Serializable {
  private static final long serialVersionUID = 634228480292968207L;

  private String uuid;
  //店铺名称
  private String name;
  //店铺地址
  private String address;
  //电话
  private String phone;
  //标签
  private String label;

  private Date createTime;

  private Date updateTime;
  //是否有效（1.有效 2.无效）
  private Integer flag;
  //权重
  private Integer weight;
  //描述
  private String description;
  //商家图标
  private String pic;
  //所属分类
  private String classify;

  private String communityId;

  private Integer pageSize;

  private Integer pageNum;

  private Coupon coupon;

  public Coupon getCoupon() {
    return coupon;
  }

  public void setCoupon(Coupon coupon) {
    this.coupon = coupon;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
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

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  public String getClassify() {
    return classify;
  }

  public void setClassify(String classify) {
    this.classify = classify;
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