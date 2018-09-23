package com.xl.backen.service;

import com.xl.backen.entity.Hotline;

public interface HotlineService {
    int add(Hotline hotline);
    int update(Hotline hotline);
    Hotline queryOne(String uuid);
}
