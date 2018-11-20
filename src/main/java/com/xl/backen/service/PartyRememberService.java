package com.xl.backen.service;

import com.xl.backen.entity.PartyRemember;
import java.util.List;
import com.github.pagehelper.Page;

/**
 * 党员信息表(TbPartyRemember)表服务接口
 *
 * @author chendm
 * @since 2018-11-15 00:20:59
 */
public interface PartyRememberService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    PartyRemember queryById(String uuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PartyRemember> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param partyRemember 实例对象
     * @return 实例对象
     */
    PartyRemember insert(PartyRemember partyRemember);

    /**
     * 修改数据
     *
     * @param partyRemember 实例对象
     * @return 实例对象
     */
    PartyRemember update(PartyRemember partyRemember);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    boolean deleteById(String uuid);

     /**
     * 通过实体作为筛选条件查询
     *
     * @param partyRemember 实例对象
     * @return 对象列表
     */
    Page<PartyRemember> queryAll(PartyRemember partyRemember);
}