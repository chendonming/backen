package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.ComplaintMapper;
import com.xl.backen.entity.Complaint;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.service.ComplaintService;
import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintMapper co;

    @Override
    public int add(Complaint complaint) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Users peoples = (Users) SecurityUtils.getSubject().getPrincipal();
        complaint.setUuid(uuid);
        complaint.setCreateId(peoples.getUuid());
        complaint.setStatus(CommonConst.COMPLAINT_NOREPYY_STATUS);
        complaint.setCreateTime(new Date());
        complaint.setUpdateTime(new Date());
        complaint.setFlag(CommonConst.NORMAL_STATUS);
        return co.insertSelective(complaint);
    }

    @Override
    public int update(Complaint complaint) {
        if (StringUtil.isEmpty(complaint.getUuid())) {
            throw new BusinessException(500, "建议投诉uuid不能为空");
        }
        Users peoples = (Users) SecurityUtils.getSubject().getPrincipal();
        complaint.setUpdateTime(new Date());
        return co.updateByPrimaryKeySelective(complaint);
    }

    @Override
    public Complaint quertOne(String uuid) {
        if (StringUtil.isEmpty(uuid)) {
            throw new BusinessException(500, "建议投诉uuid不能为空");
        }
        return co.selectByPrimaryKey(uuid);
    }

    @Override
    public Page<Complaint> queryAll(Map<String, Object> map) {
        if (map.get("pageNum") != null && map.get("pageSize") != null) {
            PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
        }
        Page<Complaint> complaints = co.queryAll(map);
        return complaints;
    }

}
