package com.xl.backen.service.impl;

import com.xl.backen.dao.PeoplesIntegralIntMapper;
import com.xl.backen.dao.PeoplesMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.PeoplesIntegralInt;
import com.xl.backen.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class IntegralServiceImpl implements IntegralService {
    @Autowired
    private PeoplesIntegralIntMapper pilm;

    @Autowired
    private PeoplesMapper pm;

    /**
     * 派发积分
     */
    @Override
    @Transactional
    public int distribute(PeoplesIntegralInt pil) {
        //新增积分记录
        pil.setUuid(UUID.randomUUID().toString().replace("-",""));
        pil.setCreateTime(new Date());
        pilm.insertSelective(pil);

        //积分操作
        Peoples peoples = pm.selectByPrimaryKey(pil.getPeopleId());
        synchronized (pm) {
            peoples.setTotalIntegral(peoples.getTotalIntegral() + pil.getIntegral());
            peoples.setIntegral(peoples.getIntegral() + pil.getIntegral());
            pm.updateByPrimaryKeySelective(peoples);
        }
        return 0;
    }
}
