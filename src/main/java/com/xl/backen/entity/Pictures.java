package com.xl.backen.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 轮播图管理(TbPictures)实体类
 *
 * @author chendm
 * @since 2018-11-03 21:05:11
 */
public class Pictures implements Serializable {
  private static final long serialVersionUID = 362864484998613166L;

  private String uuid;
  //图片路径
  private String url;
  //外链接
  private String fUrl;
  //1 有效 2无效
  private Integer flag;

  private Date createTime;

  private Date updateTime;
  //标题
  private String title;
  //轮播位置( 1. 微信首页 )
  private Integer position;

  private String communityId;
  //权重
  private Integer weight;

  private Integer pageSize;

  private Integer pageNum;


  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getFUrl() {
    return fUrl;
  }

  public void setFUrl(String fUrl) {
    this.fUrl = fUrl;
  }

  public Integer getFlag() {
    return flag;
  }

  public void setFlag(Integer flag) {
    this.flag = flag;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public String getCommunityId() {
    return communityId;
  }

  public void setCommunityId(String communityId) {
    this.communityId = communityId;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
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