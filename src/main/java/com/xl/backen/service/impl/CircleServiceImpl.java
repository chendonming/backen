package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.CircleMapper;
import com.xl.backen.entity.Circle;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.service.CircleService;
import com.xl.backen.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CircleServiceImpl implements CircleService {

    @Autowired
    private CircleMapper cm;

    @Override
    public int add(Circle circle) {
        return cm.insertSelective(circle);
    }

    @Override
    public int update(Circle circle) {
        if (StringUtil.isEmpty(circle.getUuid())) {
            throw new BusinessException(500, "uuid不能为空");
        }

        return cm.updateByPrimaryKeySelective(circle);
    }

    @Override
    public Page<Circle> query(Map<String, Object> map) {
        if(map.get("pageSize") != null && map.get("pageNum") != null) {
            PageHelper.startPage((Integer) map.get("pageSize"), (Integer)map.get("pageNum"));
        }
        Page<Circle> circlePage = cm.queryAll(map);
        return circlePage;
    }
}
