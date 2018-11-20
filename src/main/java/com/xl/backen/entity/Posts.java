package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Posts implements Serializable {
  private static final long serialVersionUID = -6176880599388137679L;

  private String uuid;

  private String title;

  private String content;

  private String picture;

  private String circleId;

  private String circleName;

  private String createId;

  private Integer thumbs;

  private Integer flag;

  private Date createTime;

  private Date updateTime;

  private Integer status;

  private String createName;

  private String headPic;

  /**
   * 是否点赞（1.点赞 2.未点赞）
   */
  private Integer isThumbs;

  private Integer commentCount;

  private String communityId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Posts)) return false;
    Posts posts = (Posts) o;
    return Objects.equals(getUuid(), posts.getUuid());
  }

  public String getCommunityId() {
    return communityId;
  }

  public void setCommunityId(String communityId) {
    this.communityId = communityId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUuid());
  }

  public String getCircleName() {
    return circleName;
  }

  public void setCircleName(String circleName) {
    this.circleName = circleName;
  }


  public Integer getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(Integer commentCount) {
    this.commentCount = commentCount;
  }

  public String getCreateName() {
    return createName;
  }

  public void setCreateName(String createName) {
    this.createName = createName;
  }

  public String getHeadPic() {
    return headPic;
  }

  public void setHeadPic(String headPic) {
    this.headPic = headPic;
  }

  public Integer getIsThumbs() {
    return isThumbs;
  }

  public void setIsThumbs(Integer isThumbs) {
    this.isThumbs = isThumbs;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid == null ? null : uuid.trim();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title == null ? null : title.trim();
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content == null ? null : content.trim();
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture == null ? null : picture.trim();
  }

  public String getCircleId() {
    return circleId;
  }

  public void setCircleId(String circleId) {
    this.circleId = circleId == null ? null : circleId.trim();
  }

  public String getCreateId() {
    return createId;
  }

  public void setCreateId(String createId) {
    this.createId = createId == null ? null : createId.trim();
  }

  public Integer getThumbs() {
    return thumbs;
  }

  public void setThumbs(Integer thumbs) {
    this.thumbs = thumbs;
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

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}