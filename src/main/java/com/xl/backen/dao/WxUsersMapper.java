package com.xl.backen.dao;

import com.xl.backen.entity.WxUsers;
import org.springframework.stereotype.Repository;

@Repository
public interface WxUsersMapper {
    int insert(WxUsers record);

    int insertSelective(WxUsers record);

    WxUsers queryWxByOpenId(String openId);
}