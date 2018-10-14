package com.xl.backen.service.impl;

import com.xl.backen.entity.ParentMenus;
import com.xl.backen.dao.ParentMenusMapper;
import com.xl.backen.service.ParentMenusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.Date;
import java.util.UUID;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.util.StringUtil;

/**
 * 父级菜单表(TbParentMenus)表服务实现类
 *
 * @author chendm
 * @since 2018-10-12 20:09:07
 */
@Service
public class ParentMenusServiceImpl implements ParentMenusService {
    @Resource
    private ParentMenusMapper parentMenusDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public ParentMenus queryById(String uuid) {
        return this.parentMenusDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ParentMenus> queryAllByLimit(int offset, int limit) {
        return this.parentMenusDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param parentMenus 实例对象
     * @return 实例对象
     */
    @Override
    public ParentMenus insert(ParentMenus parentMenus) {
        parentMenus.setUuid(UUID.randomUUID().toString().replace("-", ""));
        parentMenus.setUpdateTime(new Date());
        parentMenus.setCreateTime(new Date());
        this.parentMenusDao.insert(parentMenus);
        return parentMenus;
    }

    /**
     * 修改数据
     *
     * @param parentMenus 实例对象
     * @return 实例对象
     */
    @Override
    public ParentMenus update(ParentMenus parentMenus) {
        if(StringUtil.isEmpty(parentMenus.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        parentMenus.setUpdateTime(new Date());
        this.parentMenusDao.update(parentMenus);
        return this.queryById(parentMenus.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.parentMenusDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param parentMenus 实例对象
     * @return 对象列表
     */
    @Override
    public Page<ParentMenus> queryAll(ParentMenus parentMenus) {
        if(parentMenus.getPageSize() != null && parentMenus.getPageNum() != null) {
            PageHelper.startPage(parentMenus.getPageNum(), parentMenus.getPageSize());
        }
        Page<ParentMenus> pages =  this.parentMenusDao.queryAll(parentMenus);
        return pages;
    }
}