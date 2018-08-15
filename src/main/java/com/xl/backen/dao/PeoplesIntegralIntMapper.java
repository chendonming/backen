package com.xl.backen.dao;

import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.PeoplesIntegralInt;
import com.xl.backen.entity.Tasks;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeoplesIntegralIntMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(PeoplesIntegralInt record);

    int insertSelective(PeoplesIntegralInt record);

    PeoplesIntegralInt selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(PeoplesIntegralInt record);

    int updateByPrimaryKey(PeoplesIntegralInt record);

    /**
     * 根据  peopleid 查询相应的  Tasks集合
     */
    List<Tasks> queryByPeopleId(String peopleId);

    /**
     * 根据  peopleid 查询相应的  Activitys
     */
    List<Activitys> queryActByPeopleId(String peopleId);
}