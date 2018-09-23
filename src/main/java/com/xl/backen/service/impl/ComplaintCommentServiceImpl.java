package com.xl.backen.service.impl;

import com.xl.backen.entity.ComplaintComment;
import com.xl.backen.dao.ComplaintCommentMapper;
import com.xl.backen.service.ComplaintCommentService;
import com.xl.backen.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.Date;
import java.util.UUID;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.handler.BusinessException;

/**
 * (TbComplaintComment)表服务实现类
 *
 * @author chendm
 * @since 2018-09-23 20:31:00
 */
@Service
public class ComplaintCommentServiceImpl implements ComplaintCommentService {
    @Resource
    private ComplaintCommentMapper complaintCommentDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public ComplaintComment queryById(String uuid) {
        return this.complaintCommentDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ComplaintComment> queryAllByLimit(int offset, int limit) {
        return this.complaintCommentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param complaintComment 实例对象
     * @return 实例对象
     */
    @Override
    public ComplaintComment insert(ComplaintComment complaintComment) {
        complaintComment.setUuid(UUID.randomUUID().toString().replace("-", ""));
        complaintComment.setUpdateTime(new Date());
        complaintComment.setCreateTime(new Date());
        complaintComment.setFlag(CommonConst.NORMAL_STATUS);
        this.complaintCommentDao.insert(complaintComment);
        return complaintComment;
    }

    /**
     * 修改数据
     *
     * @param complaintComment 实例对象
     * @return 实例对象
     */
    @Override
    public ComplaintComment update(ComplaintComment complaintComment) {
        if(StringUtil.isEmpty(complaintComment.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        complaintComment.setUpdateTime(new Date());
        this.complaintCommentDao.update(complaintComment);
        return this.queryById(complaintComment.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.complaintCommentDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param complaintComment 实例对象
     * @return 对象列表
     */
    @Override
    public Page<ComplaintComment> queryAll(ComplaintComment complaintComment) {
        if(complaintComment.getPageSize() != null && complaintComment.getPageNum() != null) {
            PageHelper.startPage(complaintComment.getPageNum(), complaintComment.getPageSize());
        }
        Page<ComplaintComment> pages =  this.complaintCommentDao.queryAll(complaintComment);
        return pages;
    }
}