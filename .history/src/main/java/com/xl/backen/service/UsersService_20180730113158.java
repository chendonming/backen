package com.xl.backen.service;

import com.xl.backen.entity.Users;
import com.xl.backen.model.UsersModel;

public interface UsersService {

    

    Users findByMobile(String uuid);

    /**
     * 登录
     */
    UsersModel login(String username, String password);
}
