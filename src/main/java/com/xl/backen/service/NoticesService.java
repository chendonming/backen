/**
 * 
 */
package com.xl.backen.service;

import java.util.Map;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Notices;

/**
 * @author chendm
 *
 */
public interface NoticesService {
	int add(Notices notices);
	int update(Notices notices);
	int del(Notices notices);
	Page<Notices> query(Map<String, Object> map);
	Notices queryOne(String uuid);
}
