package com.xl.backen.model;

import com.xl.backen.entity.Users;

public class UsersRegisterRoleModel{

    private Users user;

    private String roleId;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
