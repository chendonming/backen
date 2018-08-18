package com.xl.backen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xl.backen.dao.MenusMapper;
import com.xl.backen.entity.Menus;
import com.xl.backen.service.MenusService;

@Service
@CacheConfig(cacheNames = "meuns")
public class MenusServiceImpl implements MenusService{

	@Autowired
	private MenusMapper mm;
	
	@Override
	@Cacheable(keyGenerator = "keyGenerator")
	public List<Menus> queryAll() {
		return mm.queryAll();
	}
}
