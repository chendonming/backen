package com.xl.backen.dao;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Peoples;
import com.xl.backen.model.PeoplesPageModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
	 * @param
	 */
	Peoples findByMobile(String mobile);

	/**
	 * 查询所有的居民信息
	 */
	List<Peoples> queryAll(String communityId);

	Peoples queryByOpenId(String openId);
}