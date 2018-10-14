package com.xl.backen.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 建议投诉(TbComplaint)实体类
 *
 * @author chendm
 * @since 2018-10-06 21:44:00
 */
public class Complaint implements Serializable {
    private static final long serialVersionUID = -59616473938177936L;
    //uuid
    private String uuid;
    //名称
    private String name;
    //内容
    private String content;
    //创建人id
    private String createId;
    //姓名
    private String createName;
    //手机号码
    private String phone;
    //图片
    private String files;
    //状态（1、未回复，2、回复）
    private Integer status;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //组织机构
    private String communityId;
    //是否有效 1、有效  2、无效
    private Integer flag;

    private String headpic;

    private String truename;

	private Integer pageSize;

	private Integer pageNum;

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
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
    
    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
    
    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
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