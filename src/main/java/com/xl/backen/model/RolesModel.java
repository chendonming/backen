package com.xl.backen.model;

import com.xl.backen.entity.Roles;
import com.xl.backen.entity.Users;

import java.util.List;

public class RolesModel extends Roles {
    private static final long serialVersionUID = -4061572718225192274L;
    private List<Users> users;

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
