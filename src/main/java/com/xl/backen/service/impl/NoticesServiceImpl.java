/**
 * 
 */
package com.xl.backen.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.xl.backen.handler.CommonConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.NoticesMapper;
import com.xl.backen.entity.Notices;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.service.NoticesService;
import com.xl.backen.util.StringUtil;

/**
 * @author chendm
 *
 */
@Service
public class NoticesServiceImpl implements NoticesService {
	@Autowired
	private NoticesMapper nm;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xl.backen.service.NoticesService#add(com.xl.backen.entity.Notices)
	 */
	@Override
	public int add(Notices notices) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		notices.setUuid(uuid);
		notices.setFlag(CommonConst.NORMAL_STATUS);
		notices.setCreateTime(new Date());
		notices.setUpdateTime(new Date());
		return nm.insertSelective(notices);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xl.backen.service.NoticesService#update(com.xl.backen.entity.Notices)
	 */
	@Override
	public int update(Notices notices) {
		return nm.updateByPrimaryKeySelective(notices);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xl.backen.service.NoticesService#del(com.xl.backen.entity.Notices)
	 */
	@Override
	public int del(Notices notices) {
		if (StringUtil.isEmpty(notices.getUuid())) {
			throw new BusinessException(500, "公告uuid必传");
		}
		return nm.deleteByPrimaryKey(notices.getUuid());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xl.backen.service.NoticesService#query(java.util.Map)
	 */
	@Override
	public Page<Notices> query(Map<String, Object> map) {
		if (map.get("pageNum") != null && map.get("pageSize") != null) {
			PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
		}
		Page<Notices> notices = nm.queryAll(map);
		return notices;
	}

	@Override
	public Notices queryOne(String uuid) {
		return nm.selectByPrimaryKey(uuid);
	}

}