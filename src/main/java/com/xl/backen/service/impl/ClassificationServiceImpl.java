package com.xl.backen.service.impl;

import com.xl.backen.dao.ClassificationMapper;
import com.xl.backen.entity.Classification;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.service.ClassificationService;
import com.xl.backen.util.StringUtil;
import com.xl.backen.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Autowired
    private ClassificationMapper cm;

    @Override
    public int add(Classification classification) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        classification.setUuid(uuid);
        classification.setCreateTime(new Date());
        classification.setUpdateTime(new Date());
        classification.setFlag(CommonConst.NORMAL_STATUS);
        return cm.insertSelective(classification);
    }

    @Override
    public int update(Classification classification) {
        if (StringUtil.isEmpty(classification.getUuid())) {
            throw new BusinessException(500, "uuid不能为空");
        }
        classification.setUpdateTime(new Date());
        return cm.updateByPrimaryKeySelective(classification);
    }

    /**
     * 查询完整的父类结构
     * @param classification
     * @return
     */
    @Override
    public Classification queryAll(Classification classification) {
        // 查询所有的父级分类
        Classification c = new Classification();
        c.setUpId("0");
        if(classification.getType() != null)
            c.setType(classification.getType());
        List<Classification> classificationList1 = cm.queryAll(c);

        // 所有条件查询结果
        List<Classification> classificationList2 = cm.queryAll(classification);

        for(Classification i : classificationList1) {
            TreeUtils.createTree(classificationList2, i, "uuid", "upId", "list");
        }

        /* 最终的结果 */
        Classification boss = new Classification();
        boss.setList(classificationList1);

        return boss;
    }

    @Override
    public List<Classification> queryByIf(Classification classification) {
        return cm.queryAll(classification);
    }

    @Override
    public Classification queryOne(String uuid) {
        return cm.selectByPrimaryKey(uuid);
    }
}
