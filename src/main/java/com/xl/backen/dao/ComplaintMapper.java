package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Complaint;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ComplaintMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    Complaint selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);

    Page<Complaint> queryAll(Map<String, Object> map);
}