package com.xl.backen.service;

import com.xl.backen.entity.Complaint;

public interface ComplaintService {
    int add(Complaint complaint);
    int update(Complaint complaint);
    Complaint quertOne(String uuid);
}
