package com.xl.backen.entity;

import javax.validation.constraints.NotEmpty;

public class UsersRole {
    private String uuid;

    @NotEmpty
    private String userId;

    @NotEmpty
    private String roleId;
    
    private Integer status;
    
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof UsersRole) {
    		UsersRole r = (UsersRole)obj;
    		if(r.getRoleId().equals(this.roleId) && r.getUserId().equals(this.userId)) {
    			return true;
    		}else {
    			return false;
    		}
    	}else {
    		return super.equals(obj);
    	}
    }
    
    
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}