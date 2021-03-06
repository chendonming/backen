package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.PeoplesMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.VolunteerModel;
import com.xl.backen.service.VolunteerService;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * VolunteerServiceImpl
 */
@Service
@CacheConfig(cacheNames = "volunteer")
public class VolunteerServiceImpl implements VolunteerService {
  @Autowired
  private PeoplesMapper pm;

  @Override
  @CacheEvict(allEntries=true)
  public int add(VolunteerModel volunteerModel) {
    // 1.查询手机号码
    Peoples peoples = pm.findByMobile(volunteerModel.getMobile());
    if (peoples == null) {
      throw new BusinessException(BusinessStatus.AUTHC_APP_NULL);
    }

    //2.修改people信息
    Peoples p = new Peoples();
    p.setUuid(peoples.getUuid());

    //修改description
    p.setDescription(volunteerModel.getDescription());
    //修改role
    p.setRole(CommonConst.VOLUNTEER_USER);
    p.setIdentityFlag(volunteerModel.getIdentityFlag());

    pm.updateByPrimaryKeySelective(p);

    return 1;
  }

  @Override
  @CacheEvict(allEntries=true)
  public int update(VolunteerModel volunteerModel) {
    Peoples p = new Peoples();
    p.setUuid(volunteerModel.getUuid());
    p.setDescription(volunteerModel.getDescription());
    p.setRole(volunteerModel.getRole());
    p.setIdentityFlag(volunteerModel.getIdentityFlag());

    pm.updateByPrimaryKeySelective(p);
    return 1;
  }

  @Override
  @Cacheable(keyGenerator = "keyGenerator")
  public VolunteerModel queryOne(String uuid) {
    Peoples peoples = pm.selectByPrimaryKey(uuid);
    VolunteerModel volunteerModel = new VolunteerModel();
    volunteerModel.setUuid(peoples.getUuid());
    volunteerModel.setDescription(peoples.getDescription());
    volunteerModel.setRole(peoples.getRole());
    volunteerModel.setIdentityFlag(peoples.getIdentityFlag());
    volunteerModel.setMobile(peoples.getMobile());
    //真实姓名
    volunteerModel.setTruename(peoples.getTruename());
    return volunteerModel;
  }

  @Override
  @Cacheable(keyGenerator = "keyGenerator")
  public Page<VolunteerModel> queryList(VolunteerModel volunteerModel) {
    if(volunteerModel.getPageSize() != null && volunteerModel.getPageSize() != null) {
      PageHelper.startPage(volunteerModel.getPageNum(), volunteerModel.getPageSize());
    }

    Users users = (Users) SecurityUtils.getSubject().getPrincipal();

    return pm.queryList(users.getCommunityId());
  }

}