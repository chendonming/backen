package com.xl.backen.dao;

import com.xl.backen.entity.Complaint;

public interface ComplaintMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    Complaint selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);
}