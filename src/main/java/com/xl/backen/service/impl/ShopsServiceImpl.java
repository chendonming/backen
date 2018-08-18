package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.ShopsMapper;
import com.xl.backen.entity.Shops;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.service.ShopsService;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "shop")
public class ShopsServiceImpl implements ShopsService {

	@Autowired
	private ShopsMapper sm;

	@Override
	@CacheEvict(allEntries=true)
	public int insertSelective(Shops record) {
		Users users = (Users)SecurityUtils.getSubject().getPrincipal();

		record.setUuid(UUID.randomUUID().toString().replace("-", ""));
		record.setCommunityId(record.getCommunityId());
		record.setStatus(CommonConst.NORMAL_STATUS);
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		record.setCreateName(users.getTruename());
		record.setCreateUser(users.getUuid());
		
		return sm.insertSelective(record);
	}

	@Override
	@Cacheable(keyGenerator = "keyGenerator")
	public Shops selectByPrimaryKey(String uuid) {
		return sm.selectByPrimaryKey(uuid);
	}

	@Override
	@CacheEvict(allEntries=true)
	public int updateByPrimaryKeySelective(Shops record) {
		return sm.updateByPrimaryKeySelective(record);
	}

	@Override
	@Cacheable(keyGenerator = "keyGenerator")
	public Page<Shops> query(Map<String, Object> map) {
		Integer pageNum = (Integer)map.get("pageNum");
		Integer pageSize = (Integer)map.get("pageSize");
		
		if (pageNum != null && pageSize != null) {
			PageHelper.startPage(pageNum, pageSize);
		}

		return sm.query(map);
	}

}
