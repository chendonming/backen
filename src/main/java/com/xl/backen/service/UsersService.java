package com.xl.backen.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Users;
import com.xl.backen.model.UsersModel;


public interface UsersService {

    String Register(Users users);

    Users findByMobile(String uuid);

    /**
     * 登录
     */
    UsersModel login(String username, String password);

    /**
     * 查询所有的用户
     */
    Page<Users> queryAll(int pageNum, int pageSize);
}
