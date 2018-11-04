package com.xl.backen.service.impl;

import com.xl.backen.entity.PartyRemember;
import com.xl.backen.dao.PartyRememberMapper;
import com.xl.backen.service.PartyRememberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.Date;
import java.util.UUID;

import com.xl.backen.handler.BusinessException;
import com.xl.backen.util.StringUtil;

/**
 * 党员信息表(TbPartyRemember)表服务实现类
 *
 * @author chendm
 * @since 2018-11-01 22:08:03
 */
@Service
public class PartyRememberServiceImpl implements PartyRememberService {
  @Resource
  private PartyRememberMapper partyRememberDao;


  /**
   * 通过ID查询单条数据
   *
   * @param uuid 主键
   * @return 实例对象
   */
  @Override
  public PartyRemember queryById(String uuid) {
    return this.partyRememberDao.queryById(uuid);
  }

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit  查询条数
   * @return 对象列表
   */
  @Override
  public List<PartyRemember> queryAllByLimit(int offset, int limit) {
    return this.partyRememberDao.queryAllByLimit(offset, limit);
  }

  /**
   * 新增数据
   *
   * @param partyRemember 实例对象
   * @return 实例对象
   */
  @Override
  public PartyRemember insert(PartyRemember partyRemember) {
    partyRemember.setUuid(UUID.randomUUID().toString().replace("-", ""));
    partyRemember.setUpdateTime(new Date());
    partyRemember.setCreateTime(new Date());
    this.partyRememberDao.insert(partyRemember);
    return partyRemember;
  }

  /**
   * 修改数据
   *
   * @param partyRemember 实例对象
   * @return 实例对象
   */
  @Override
  public PartyRemember update(PartyRemember partyRemember) {
    if (StringUtil.isEmpty(partyRemember.getUuid())) {
      throw new BusinessException(500, "uuid必传");
    }
    partyRemember.setUpdateTime(new Date());
    this.partyRememberDao.update(partyRemember);
    return this.queryById(partyRemember.getUuid());
  }

  /**
   * 通过主键删除数据
   *
   * @param uuid 主键
   * @return 是否成功
   */
  @Override
  public boolean deleteById(String uuid) {
    return this.partyRememberDao.deleteById(uuid) > 0;
  }


  /**
   * 通过实体作为筛选条件查询(分页查询)
   *
   * @param partyRemember 实例对象
   * @return 对象列表
   */
  @Override
  public Page<PartyRemember> queryAll(PartyRemember partyRemember) {
    if (partyRemember.getPageSize() != null && partyRemember.getPageNum() != null) {
      PageHelper.startPage(partyRemember.getPageNum(), partyRemember.getPageSize());
    }
    Page<PartyRemember> pages = this.partyRememberDao.queryAll(partyRemember);
    return pages;
  }

  @Override
  public int auth(PartyRemember partyRemember) {
    return 0;
  }
}