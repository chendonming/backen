package com.xl.backen.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbComplaintComment)实体类
 *
 * @author chendm
 * @since 2018-10-06 21:44:00
 */
public class ComplaintComment implements Serializable {
    private static final long serialVersionUID = 614386772834166139L;
    
    private String uuid;
    //关联投诉建议主键
    private String complaintUuid;
    //内容
    private String content;
    //图片
    private String files;
    //创建时间
    private Date createTime;
    //是否有效 1、有效  2、无效
    private Integer flag;
    //创建人id
    private String createId;
    
    private Date updateTime;

	private Integer pageSize;

	private Integer pageNum;

    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getComplaintUuid() {
        return complaintUuid;
    }

    public void setComplaintUuid(String complaintUuid) {
        this.complaintUuid = complaintUuid;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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