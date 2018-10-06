package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Circle;
import com.xl.backen.entity.CirclePeople;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CircleMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Circle record);

    int insertSelective(Circle record);

    Circle selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Circle record);

    int updateByPrimaryKey(Circle record);

    Page<Circle> queryAll(Map<String, Object> map);

    /**
     * 是否加入了圈子
     * @param uuid  圈子uuid
     * @return
     */
    Integer isJoinCircle(@Param(value = "uuid")String uuid, @Param(value = "peopleId")String peopleId);

    /**
     * 加入圈子
     * @param uuid 圈子uuid
     * @return
     */
    Integer joinCircle(CirclePeople cp);
}