package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Peoples;
import com.xl.backen.model.PeoplesPageModel;

public interface PeoplesMapper {
	int deleteByPrimaryKey(String uuid);

	int insert(Peoples record);

	int insertSelective(Peoples record);

	Peoples selectByPrimaryKey(String uuid);

	int updateByPrimaryKeySelective(Peoples record);

	int updateByPrimaryKey(Peoples record);

	/**
	 * 查询居民
	 */
	Page<Peoples> query(PeoplesPageModel model);

	/**
	 * 根据手机号码查询用户信息
	 *
	 * @param 手机号码
	 */
	Peoples findByMobile(String mobile);
}