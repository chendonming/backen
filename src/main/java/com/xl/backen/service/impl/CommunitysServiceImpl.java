package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.CommunitysMapper;
import com.xl.backen.dao.UsersMapper;
import com.xl.backen.entity.Communitys;
import com.xl.backen.entity.RolesPower;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.CommunitysForAddModel;
import com.xl.backen.model.CommunitysPageModel;
import com.xl.backen.service.CommunitysService;
import com.xl.backen.service.RolesPowerService;
import com.xl.backen.util.MD5;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
@CacheConfig(cacheNames = "community")
public class CommunitysServiceImpl implements CommunitysService {

  @Autowired
  private CommunitysMapper cm;

  @Autowired
  private UsersMapper um;

  @Override
  @CacheEvict(allEntries = true)
  public Users add(CommunitysForAddModel communitys) throws Exception {
    Users model = (Users) SecurityUtils.getSubject().getPrincipal();

    //新增
    CommunitysForAddModel communitysForAddModel = addCommunity(communitys);

    Map<String, String> map = new HashMap<>();
    map.put("mobile", communitysForAddModel.getMobile());
    Users u = um.findByMobile(map);

    if (u == null) {
      //指定管理员
      Users users = new Users();
      Map<String, String> map1 = new HashMap<>();
      map1.put("mobile", communitys.getMobile());
      map1.put("communityId", "");
      if (um.findByMobile(map1) != null) {
        // 存在手机号码重复
        throw new BusinessException(500, "手机号码重复");
      }

      users.setUuid(UUID.randomUUID().toString().replace("-", ""));
      users.setCommunityId(communitysForAddModel.getUuid());
      users.setMobile(communitys.getMobile());
      users.setNickname(communitys.getCommunityLeader());
      users.setTruename(communitys.getCommunityLeader());
      users.setCreateTime(new Date());
      users.setUpdateTime(new Date());
      users.setPassword(MD5.md5(CommonConst.PASSWORD));
      users.setSysType(model.getSysType());
      users.setStatus(CommonConst.NORMAL_STATUS);
      um.insertSelective(users);
      return users;
    }

    return u;
  }

  @Override
  @CacheEvict(allEntries = true)
  public int update(Communitys communitys) {
    if (StringUtils.isEmpty(communitys.getUuid())) {
      throw new BusinessException(BusinessStatus.UUID_REQ);
    }
    return cm.updateByPrimaryKeySelective(communitys);
  }

  @Override
  @Cacheable(keyGenerator = "keyGenerator")
  public Page<Communitys> query(CommunitysPageModel model) {
    PageHelper.startPage(model.getPageNum(), model.getPageSize());

    Users usersModel = (Users) SecurityUtils.getSubject().getPrincipal();

    model.setSysType(usersModel.getSysType());

    return cm.query(model);
  }

  @Override
  @Cacheable(keyGenerator = "keyGenerator")
  public Communitys findById(String uuid) {
    if (StringUtils.isEmpty(uuid)) {
      throw new BusinessException(BusinessStatus.UUID_REQ);
    }
    return cm.selectByPrimaryKey(uuid);
  }

  public CommunitysForAddModel addCommunity(CommunitysForAddModel communitys) {
    Users model = (Users) SecurityUtils.getSubject().getPrincipal();

    String uuid = UUID.randomUUID().toString().replace("-", "");

    communitys.setUuid(uuid);
    communitys.setStatus(CommonConst.NORMAL_STATUS);
    communitys.setCreateTime(new Date());
    communitys.setUpdateTime(new Date());
    communitys.setSysType(model.getSysType());
    communitys.setLeaderName(communitys.getCommunityLeader());
    communitys.setLeaderMobile(communitys.getMobile());


    communitys.setCreateUser(model.getUuid());
    cm.insertSelective(communitys);

    return communitys;
  }
}
