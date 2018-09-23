package com.xl.backen.service.impl;

import com.xl.backen.dao.ComplaintMapper;
import com.xl.backen.entity.Complaint;
import com.xl.backen.entity.Users;
import com.xl.backen.service.ComplaintService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        complaint.setCommunityId(peoples.getCommunityId());
        return 0;
    }

    @Override
    public int update(Complaint complaint) {
        return 0;
    }

    @Override
    public Complaint quertOne(String uuid) {
        return null;
    }
}
