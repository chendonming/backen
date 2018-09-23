package com.xl.backen.dao;

import com.xl.backen.entity.CirclePeople;
import org.springframework.stereotype.Repository;

@Repository
public interface CirclePeopleMapper {
    int insert(CirclePeople record);

    int insertSelective(CirclePeople record);
}