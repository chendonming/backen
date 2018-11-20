package com.xl.backen.service;


import com.github.pagehelper.Page;
import com.xl.backen.entity.Peoples;
import com.xl.backen.model.PeoplesPageModel;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * PeoplesService
 */
public interface PeoplesService {
  int add(Peoples peoples);
  int update(Peoples peoples);

  /**
   * 导出居民信息
 * @throws IOException 
   */
  String exportPeople() throws IOException;

  /**
   * 导入居民信息
 * @throws Exception
   */
  int importPeople(MultipartFile file, Integer isparty) throws Exception;
  
  /**
   * 条件查询居民分页
   */
  Page<Peoples> query(PeoplesPageModel model);

  /**
   * 根据peopleic查询剩余积分
   */
  int queryIntegral(String peoples);

  Peoples queryOne(String uuid);
}