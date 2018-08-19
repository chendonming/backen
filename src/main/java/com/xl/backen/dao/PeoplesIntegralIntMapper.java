package com.xl.backen.dao;

import com.xl.backen.entity.Activitys;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.PeoplesIntegralInt;
import com.xl.backen.entity.Tasks;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据 actid 查询对应的已派发的 peopleid
     */
    List<Peoples> queryPeopleByAct(String actId);

    /**
     * 根据外键id和people_id查询有无数据
     */
    int countByPeopleIdAndForeignId(PeoplesIntegralInt pii);
}