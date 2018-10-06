package com.xl.backen.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbCirclePostComment)实体类
 *
 * @author chendm
 * @since 2018-10-04 16:07:42
 */
public class CirclePostComment implements Serializable {
    private static final long serialVersionUID = 172305803491618480L;
    
    private String uuid;
    //内容
    private String content;
    //发布人
    private String createId;
    
    private Date createTime;
    
    private Date updateTime;
    //是否有效（1. 有效 2无效）
    private Integer flag;
    //帖子ID
    private String postId;

	private Integer pageSize;

	private Integer pageNum;

    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
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
    
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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