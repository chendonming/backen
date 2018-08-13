package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.ShopsMapper;
import com.xl.backen.entity.Shops;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.service.ShopsService;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopsServiceImpl implements ShopsService {

	@Autowired
	private ShopsMapper sm;

	@Override
	public int insertSelective(Shops record) {
		record.setUuid(UUID.randomUUID().toString().replace("-", ""));
		record.setCommunityId(record.getCommunityId());
		record.setStatus(CommonConst.NORMAL_STATUS);
		
		return sm.insertSelective(record);
	}

	@Override
	public Shops selectByPrimaryKey(String uuid) {
		return sm.selectByPrimaryKey(uuid);
	}

	@Override
	public int updateByPrimaryKeySelective(Shops record) {
		return sm.updateByPrimaryKeySelective(record);
	}

	@Override
	public Page<Shops> query(Map<String, Object> map) {
		Integer pageNum = (Integer)map.get("pageNum");
		Integer pageSize = (Integer)map.get("pageSize");
		
		if (pageNum != null && pageSize != null) {
			PageHelper.startPage(pageNum, pageSize);
		}

		return sm.query(map);
	}

}
