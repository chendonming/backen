package com.xl.backen.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Users;
import com.xl.backen.model.UsersModel;
import com.xl.backen.model.UsersPageModel;
import com.xl.backen.model.UsersRegisterRoleModel;


public interface UsersService {

    String Register(Users users);

    Users findByMobile(String uuid);

    /**
     * 登录
     */
    Users login(String username, String password);

    /**
     * 查询所有的用户
     */
    Page<Users> queryAll(UsersPageModel model);

    /**
     * 修改管理员
     */
    int update(UsersRegisterRoleModel model);

    /**
     * 查询单个
     */
    Users findById(String uuid);
}
