package com.xl.backen.service;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Circle;

import java.util.Map;

public interface CircleService {
    int add(Circle circle);

    int update(Circle circle);

    Page<Circle> query(Map<String, Object> map);
}
