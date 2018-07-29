package com.xl.backen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xl.backen.dao.MenusMapper;
import com.xl.backen.entity.Menus;
import com.xl.backen.service.MenusService;

@Service
public class MenusServiceImpl implements MenusService{

	@Autowired
	private MenusMapper mm;
	
	@Override
	public List<Menus> queryAll() {
		return mm.queryAll();
	}

}
