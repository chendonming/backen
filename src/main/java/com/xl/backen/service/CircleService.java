package com.xl.backen.service;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Circle;
import com.xl.backen.entity.CirclePeople;

import java.util.Map;

public interface CircleService {
    int add(Circle circle);

    int update(Circle circle);

    int del(Circle circle);

    Circle queryOne(Circle circle);

    Page<Circle> query(Map<String, Object> map);

    /**
     * 加入圈子
     * @param uuid
     * @return
     */
    int joinCircle(CirclePeople cp);
}
