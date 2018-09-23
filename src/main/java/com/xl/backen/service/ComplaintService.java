package com.xl.backen.service;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Complaint;

import java.util.Map;

public interface ComplaintService {
    int add(Complaint complaint);
    int update(Complaint complaint);
    Complaint quertOne(String uuid);
    Page<Complaint> queryAll(Map<String, Object> map);
}
