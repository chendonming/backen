package com.xl.backen.dao;

import com.xl.backen.entity.PartyRemember;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;


/**
 * 党员信息表(TbPartyRemember)表数据库访问层
 *
 * @author chendm
 * @since 2018-11-01 22:08:03
 */
@Repository
public interface PartyRememberMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    PartyRemember queryById(@Param(value="uuid")String uuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PartyRemember> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param partyRemember 实例对象
     * @return 对象列表
     */
    Page<PartyRemember> queryAll(PartyRemember partyRemember);

    /**
     * 新增数据
     *
     * @param partyRemember 实例对象
     * @return 影响行数
     */
    int insert(PartyRemember partyRemember);

    /**
     * 修改数据
     *
     * @param partyRemember 实例对象
     * @return 影响行数
     */
    int update(PartyRemember partyRemember);

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 影响行数
     */
    int deleteById(String uuid);

}