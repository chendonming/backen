package com.xl.backen.service.impl;

import com.xl.backen.entity.Pictures;
import com.xl.backen.dao.PicturesMapper;
import com.xl.backen.service.PicturesService;
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
 * 轮播图管理(TbPictures)表服务实现类
 *
 * @author chendm
 * @since 2018-11-03 21:05:11
 */
@Service
public class PicturesServiceImpl implements PicturesService {
    @Resource
    private PicturesMapper picturesDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public Pictures queryById(String uuid) {
        return this.picturesDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Pictures> queryAllByLimit(int offset, int limit) {
        return this.picturesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param pictures 实例对象
     * @return 实例对象
     */
    @Override
    public Pictures insert(Pictures pictures) {
        pictures.setUuid(UUID.randomUUID().toString().replace("-", ""));
        pictures.setUpdateTime(new Date());
        pictures.setCreateTime(new Date());
        pictures.setFlag(CommonConst.NORMAL_STATUS);
        this.picturesDao.insert(pictures);
        return pictures;
    }

    /**
     * 修改数据
     *
     * @param pictures 实例对象
     * @return 实例对象
     */
    @Override
    public Pictures update(Pictures pictures) {
        if(StringUtil.isEmpty(pictures.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        pictures.setUpdateTime(new Date());
        this.picturesDao.update(pictures);
        return this.queryById(pictures.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.picturesDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param pictures 实例对象
     * @return 对象列表
     */
    @Override
    public Page<Pictures> queryAll(Pictures pictures) {
        if(pictures.getPageSize() != null && pictures.getPageNum() != null) {
            PageHelper.startPage(pictures.getPageNum(), pictures.getPageSize());
        }
        Page<Pictures> pages =  this.picturesDao.queryAll(pictures);
        return pages;
    }
}