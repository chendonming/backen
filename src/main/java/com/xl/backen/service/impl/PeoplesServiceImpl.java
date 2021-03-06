package com.xl.backen.service.impl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.PeoplesMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.PeoplesPageModel;
import com.xl.backen.service.PeoplesService;
import com.xl.backen.util.ArrayUtil;
import com.xl.backen.util.MD5;
import com.xl.backen.util.PeoplesPOI;

import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * PeoplesServiceImpl
 */
@Service
@CacheConfig(cacheNames = "peoples")
public class PeoplesServiceImpl implements PeoplesService {

  private static Logger log = LoggerFactory.getLogger(PeoplesServiceImpl.class);

  @Autowired
  private PeoplesMapper pm;

  @Value("${filePath}")
  private String filePath;

  @Value("${nginxPath}")
  private String nginxPath;

  @Value("${server.session.timeout}")
  private Long sessionTimeOut;

  @Override
  @CacheEvict(allEntries = true)
  public int add(Peoples peoples) {
    peoples.setUuid(UUID.randomUUID().toString().replace("-", ""));
    peoples.setCreateTime(new Date());
    peoples.setUpdateTime(new Date());
    peoples.setStatus(CommonConst.NORMAL_STATUS);
    if (StringUtil.isEmpty(peoples.getIdCard())) {
      peoples.setIsRealName(CommonConst.NO_REAL_NAME);
    } else {
      peoples.setIsRealName(CommonConst.IS_REAL_NAME);
    }
    return pm.insertSelective(peoples);
  }

  @Override
  @CacheEvict(allEntries = true)
  public int update(Peoples peoples) {
    if (StringUtil.isEmpty(peoples.getUuid())) {
      throw new BusinessException(BusinessStatus.UUID_REQ);
    }

    String code = (String) SecurityUtils.getSubject().getSession().getAttribute("code");
    if (StringUtil.isEmpty(code)) {
      throw new BusinessException(500, "验证码过期");
    }

    if (!code.equals(peoples.getCode())) {
      throw new BusinessException(500, "验证码不匹配");
    }

    int i = pm.updateByPrimaryKeySelective(peoples);

    Subject subject = SecurityUtils.getSubject();

    Peoples p = (Peoples) subject.getPrincipal();

    PrincipalCollection principalCollection = subject.getPrincipals();

    if (i > 0) {
      Field[] fields = peoples.getClass().getDeclaredFields();
      for (int j = 0; j < fields.length; j++) {
        fields[j].setAccessible(true);
        try {
          if (fields[j].get(peoples) != null && fields[j].getType().toString().endsWith("String") || fields[j].getType().toString().endsWith("Integer")) {
            fields[j].set(p, fields[j].get(peoples));
          }
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
    String realName = principalCollection.getRealmNames().iterator().next();
    PrincipalCollection newPrn = new SimplePrincipalCollection(p, realName);
    subject.runAs(newPrn);

    return i;
  }

  @Override
  @CacheEvict(allEntries = true)
  public String exportPeople() throws IOException {
    PeoplesPageModel pp = new PeoplesPageModel();
    Users users = (Users) SecurityUtils.getSubject().getPrincipal();

    pp.setCommunityId(users.getCommunityId());

    Page<Peoples> p = query(pp);
    List<Peoples> peoplesList = p.getResult();

    File file = new File(filePath + UUID.randomUUID().toString().replace("-", "") + ".xlsx");

    return nginxPath + PeoplesPOI.exportUser(file, peoplesList);
  }

  @Override
  @Transactional
  @CacheEvict(allEntries = true)
  public int importPeople(MultipartFile file, Integer isparty) throws Exception {
    Users u = (Users) SecurityUtils.getSubject().getPrincipal();
    List<Peoples> peoples = PeoplesPOI.importUser(file);
    List<Peoples> servicePeoples = pm.queryAll(u.getCommunityId());

    log.info("导入的用户信息列表:", peoples);

    //手机号码和身份证的去重
    List<Peoples> p = ArrayUtil.compareArr(peoples, servicePeoples);


    for (Peoples i : p) {
      //登录人的社区
      i.setUuid(UUID.randomUUID().toString().replace("- ", ""));
      i.setCommunityId(u.getCommunityId());
      i.setSysType(u.getSysType());
      //是否实名
      if (StringUtil.isEmpty(i.getIdCard()) && StringUtil.isEmpty(i.getMobile())) {
        i.setIsRealName(CommonConst.NO_REAL_NAME);
      } else {
        i.setIsRealName(CommonConst.IS_REAL_NAME);
      }

      i.setCreateTime(new Date());
      i.setUpdateTime(new Date());
      //默认密码(微信登录不需要)
      i.setPassword(MD5.md5(CommonConst.PASSWORD));
      //默认是普通居民
      if (!StringUtil.isEmpty(isparty)) {
        i.setRole(isparty);
      } else {
        i.setRole(CommonConst.NOMARL_USER);
      }

      add(i);
    }

    return p.size();
  }

  @Override
  @Cacheable(keyGenerator = "keyGenerator")
  public Page<Peoples> query(PeoplesPageModel model) {
    if (model.getPageNum() != null && model.getPageSize() != null) {
      PageHelper.startPage(model.getPageNum(), model.getPageSize());
    }
    return pm.query(model);
  }

  @Override
  public int queryIntegral(String peoples) {
    return pm.queryIntegral(peoples);
  }

  @Override
  public Peoples queryOne(String uuid) {
    return pm.selectByPrimaryKey(uuid);
  }
}