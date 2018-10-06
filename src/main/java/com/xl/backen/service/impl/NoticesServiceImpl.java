package com.xl.backen.service.impl;

import com.xl.backen.entity.Notices;
import com.xl.backen.dao.NoticesMapper;
import com.xl.backen.entity.Users;
import com.xl.backen.service.NoticesService;
import org.apache.shiro.SecurityUtils;
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
 * 公告表(TbNotices)表服务实现类
 *
 * @author chendm
 * @since 2018-10-04 19:50:09
 */
@Service
public class NoticesServiceImpl implements NoticesService {
    @Resource
    private NoticesMapper noticesDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public Notices queryById(String uuid) {
        return this.noticesDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Notices> queryAllByLimit(int offset, int limit) {
        return this.noticesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param notices 实例对象
     * @return 实例对象
     */
    @Override
    public Notices insert(Notices notices) {
        notices.setUuid(UUID.randomUUID().toString().replace("-", ""));
        notices.setUpdateTime(new Date());
        notices.setCreateTime(new Date());
        notices.setFlag(CommonConst.NORMAL_STATUS);

        Users i = (Users)SecurityUtils.getSubject().getPrincipal();
        notices.setCreateId(i.getUuid());

        this.noticesDao.insert(notices);
        return notices;
    }

    /**
     * 修改数据
     *
     * @param notices 实例对象
     * @return 实例对象
     */
    @Override
    public Notices update(Notices notices) {
        if(StringUtil.isEmpty(notices.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        notices.setUpdateTime(new Date());
        this.noticesDao.update(notices);
        return this.queryById(notices.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.noticesDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param notices 实例对象
     * @return 对象列表
     */
    @Override
    public Page<Notices> queryAll(Notices notices) {
        if(notices.getPageSize() != null && notices.getPageNum() != null) {
            PageHelper.startPage(notices.getPageNum(), notices.getPageSize());
        }
        Page<Notices> pages =  this.noticesDao.queryAll(notices);
        return pages;
    }
}