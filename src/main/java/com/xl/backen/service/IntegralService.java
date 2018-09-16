package com.xl.backen.service;

import com.xl.backen.entity.PeoplesIntegralInt;
import com.xl.backen.entity.PeoplesIntegralOut;
import com.xl.backen.entity.Tasks;

import java.util.List;
import java.util.Map;

public interface IntegralService {

    /**
     * 积分派发
     *
     * type: (获取积分的途径（1. 活动  2.任务 3.垃圾分类）)
     * integral: (积分)
     * people_id: ()
     *  foreign_id: (外键id)
     *  description: (描述)
     *  foreign_name: (外键name)
     */
    int distribute(PeoplesIntegralInt pil);

    /**
     * 积分兑换
     */
    int exchange(PeoplesIntegralOut pio);
}
