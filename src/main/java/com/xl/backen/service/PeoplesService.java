package com.xl.backen.service;


import com.github.pagehelper.Page;
import com.xl.backen.entity.Peoples;
import com.xl.backen.model.PeoplesPageModel;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * PeoplesService
 */
public interface PeoplesService {
  int add(Peoples peoples);

  /**
   * 导出居民信息
 * @throws IOException 
   */
  String exportPeople() throws IOException;

  /**
   * 导入居民信息
 * @throws Exception
   */
  int importPeople(MultipartFile file) throws Exception;
  
  /**
   * 条件查询居民分页
   */
  Page<Peoples> query(PeoplesPageModel model);


  /**
   * 登录接口
   */
  Peoples login(String username, String password);
}