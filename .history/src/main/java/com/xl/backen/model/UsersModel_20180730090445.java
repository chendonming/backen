package com.xl.backen.model;

import com.xl.backen.entity.Menus;
import com.xl.backen.entity.Powers;
import com.xl.backen.entity.Roles;
import com.xl.backen.entity.Users;

import java.util.List;

public class UsersModel extends Users {
    private List<Roles> roles;
    private List<Menus> menus;

    public List<Menus> getMenus() {
        return menus;
    }

    public void setMenus(List<Menus> menus) {
        this.menus = menus;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
