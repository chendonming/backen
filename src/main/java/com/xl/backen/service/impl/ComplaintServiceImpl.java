package com.xl.backen.service.impl;

import com.xl.backen.entity.Complaint;
import com.xl.backen.dao.ComplaintMapper;
import com.xl.backen.service.ComplaintService;
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
 * 建议投诉(TbComplaint)表服务实现类
 *
 * @author chendm
 * @since 2018-10-06 21:44:00
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Resource
    private ComplaintMapper complaintDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public Complaint queryById(String uuid) {
        return this.complaintDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Complaint> queryAllByLimit(int offset, int limit) {
        return this.complaintDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 实例对象
     */
    @Override
    public Complaint insert(Complaint complaint) {
        complaint.setUuid(UUID.randomUUID().toString().replace("-", ""));
        complaint.setUpdateTime(new Date());
        complaint.setCreateTime(new Date());
        complaint.setFlag(CommonConst.NORMAL_STATUS);
        // 设置未回复
        complaint.setStatus(1);
        this.complaintDao.insert(complaint);
        return complaint;
    }

    /**
     * 修改数据
     *
     * @param complaint 实例对象
     * @return 实例对象
     */
    @Override
    public Complaint update(Complaint complaint) {
        if(StringUtil.isEmpty(complaint.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        complaint.setUpdateTime(new Date());
        this.complaintDao.update(complaint);
        return this.queryById(complaint.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.complaintDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param complaint 实例对象
     * @return 对象列表
     */
    @Override
    public Page<Complaint> queryAll(Complaint complaint) {
        if(complaint.getPageSize() != null && complaint.getPageNum() != null) {
            PageHelper.startPage(complaint.getPageNum(), complaint.getPageSize());
        }
        Page<Complaint> pages =  this.complaintDao.queryAll(complaint);
        return pages;
    }
}