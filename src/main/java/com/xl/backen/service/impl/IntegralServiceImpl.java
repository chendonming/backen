package com.xl.backen.service.impl;

import com.xl.backen.dao.PeoplesIntegralIntMapper;
import com.xl.backen.dao.PeoplesIntegralOutMapper;
import com.xl.backen.dao.PeoplesMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.PeoplesIntegralInt;
import com.xl.backen.entity.PeoplesIntegralOut;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.service.IntegralService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@CacheConfig(cacheNames = "peoples")
public class IntegralServiceImpl implements IntegralService {
    @Autowired
    private PeoplesIntegralIntMapper pilm;

    @Autowired
    private PeoplesIntegralOutMapper piom;

    @Autowired
    private PeoplesMapper pm;

    /**
     * 派发积分
     */
    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public int distribute(PeoplesIntegralInt pil) {
        //避免重复验证
        if (!pil.getType().equals(3)) {
            //不是垃圾分类
            int count = pilm.countByPeopleIdAndForeignId(pil);
            if (count > 0) {
                throw new BusinessException(BusinessStatus.INTEGRAL_PF);
            }
        }


        //新增积分记录
        pil.setUuid(UUID.randomUUID().toString().replace("-", ""));
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

    /**
     * 积分兑换
     *
     * @param pio
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public int exchange(PeoplesIntegralOut pio) {
        synchronized (pio) {
            Peoples peoples = (Peoples) SecurityUtils.getSubject().getPrincipal();
            //剩余积分
            int integral = pm.queryIntegral(peoples.getUuid());
            //需要的积分
            int needIntegral = pio.getShopIntegral() * pio.getCount();

            if (integral <= 0 || integral <= needIntegral) {
                throw new BusinessException(BusinessStatus.INTEGRAL_ERROR);
            }

            //添加记录
            pio.setUuid(UUID.randomUUID().toString().replace("-", ""));
            pio.setCreateTime(new Date());
            piom.insertSelective(pio);

            //用户积分降低
            peoples.setIntegral(peoples.getIntegral() - needIntegral);
            pm.updateByPrimaryKeySelective(peoples);
        }

        return 0;
    }
}
