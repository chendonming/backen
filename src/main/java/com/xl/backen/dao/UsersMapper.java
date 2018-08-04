package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    /**
     * 根据手机号码查找用户
     * @param uuid
     * @return
     */
    Users findByMobile(String uuid);

    int deleteByPrimaryKey(String uuid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    /**
     * 查询所有的用户
     */
    Page<Users> queryAll(int pageSize, int pageNum, String sysType);
}