package com.xl.backen.service.impl;

import com.xl.backen.entity.Merchant;
import com.xl.backen.dao.MerchantMapper;
import com.xl.backen.service.MerchantService;
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
 * (TbMerchant)表服务实现类
 *
 * @author chendm
 * @since 2018-10-06 16:05:45
 */
@Service
public class MerchantServiceImpl implements MerchantService {
    @Resource
    private MerchantMapper merchantDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public Merchant queryById(String uuid) {
        return this.merchantDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Merchant> queryAllByLimit(int offset, int limit) {
        return this.merchantDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param merchant 实例对象
     * @return 实例对象
     */
    @Override
    public Merchant insert(Merchant merchant) {
        merchant.setUuid(UUID.randomUUID().toString().replace("-", ""));
        merchant.setUpdateTime(new Date());
        merchant.setCreateTime(new Date());
        merchant.setFlag(CommonConst.NORMAL_STATUS);
        this.merchantDao.insert(merchant);
        return merchant;
    }

    /**
     * 修改数据
     *
     * @param merchant 实例对象
     * @return 实例对象
     */
    @Override
    public Merchant update(Merchant merchant) {
        if(StringUtil.isEmpty(merchant.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        merchant.setUpdateTime(new Date());
        this.merchantDao.update(merchant);
        return this.queryById(merchant.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.merchantDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param merchant 实例对象
     * @return 对象列表
     */
    @Override
    public Page<Merchant> queryAll(Merchant merchant) {
        if(merchant.getPageSize() != null && merchant.getPageNum() != null) {
            PageHelper.startPage(merchant.getPageNum(), merchant.getPageSize());
        }
        Page<Merchant> pages =  this.merchantDao.queryAll(merchant);
        return pages;
    }
}