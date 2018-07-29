package com.xl.backen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xl.backen.dao.PowersMapper;
import com.xl.backen.entity.Powers;
import com.xl.backen.service.PowersService;

@Service
public class PowersServiceImpl implements PowersService {

	@Autowired
	private PowersMapper pm;
	
	@Override
	public List<Powers> queryAll() {
		return pm.queryAll();
	}

}
