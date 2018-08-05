package com.xl.backen.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ParentMenus
 */
public class ParentMenus implements Serializable {

	private static final long serialVersionUID = 1295270799660326885L;

	private String uuid;

	private String name;

	private String code;

	private Date createTime;

	private Date updateTime;

	private List<Powers> powers;
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	public List<Powers> getPowers() {
		return powers;
	}

	public void setPowers(List<Powers> powers) {
		this.powers = powers;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}