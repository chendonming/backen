package com.xl.backen.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 文章表(TbArticles)实体类
 *
 * @author chendm
 * @since 2018-10-04 19:50:09
 */
public class Articles implements Serializable {
    private static final long serialVersionUID = 356890968289930831L;
    
    private String uuid;
    //标题
    private String title;
    
    private Date createTime;
    
    private Date updateTime;
    //内容
    private String content;
    //是否有效（1 ， 2）
    private Integer flag;
    //发布人
    private String createId;

    // 发布人真实姓名
    private String createName;
    
    // 发布人昵称
    private String createNickName;

    //所属分类
    private String classify;
    private String className;
    //类型（1. 网格 2.活动风采 ）
    private Integer type;

	private Integer pageSize;

	private Integer pageNum;

	// 图片
	private String pic;

	// 描述
	private String description;

	//内容类型（1. 无图 2. 1张图 3. 2张图  4.3张或以上  5.视频  6.音频）
	private Integer contentType;

	// 0正常   1 推荐
	private Integer status;

	// 所属社区
	private String communityId;

    public String getCreateNickName() {
		return createNickName;
	}

	public void setCreateNickName(String createNickName) {
		this.createNickName = createNickName;
	}

	public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getCreateName() {
        return createName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    
    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }
    
    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
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