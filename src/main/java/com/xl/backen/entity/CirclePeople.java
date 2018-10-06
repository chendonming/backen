package com.xl.backen.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbCirclePeople)实体类
 *
 * @author chendm
 * @since 2018-10-05 14:42:24
 */
public class CirclePeople implements Serializable {
    private static final long serialVersionUID = 816185752204605041L;
    
    private String uuid;
    //圈子ID
    private String circleId;
    //加入圈子peopleID
    private String peopleId;
    
    private Date createTime;
    
    private Date updateTime;
    //是否有效（1有效 2无效）
    private Integer flag;

	private Integer pageSize;

	private Integer pageNum;

    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }
    
    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
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