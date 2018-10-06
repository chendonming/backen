package com.xl.backen.service.impl;

import com.xl.backen.dao.PostsMapper;
import com.xl.backen.entity.CirclePostComment;
import com.xl.backen.dao.CirclePostCommentMapper;
import com.xl.backen.service.CirclePostCommentService;
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
import org.springframework.transaction.annotation.Transactional;

/**
 * (TbCirclePostComment)表服务实现类
 *
 * @author chendm
 * @since 2018-10-04 16:07:42
 */
@Service
public class CirclePostCommentServiceImpl implements CirclePostCommentService {
    @Resource
    private CirclePostCommentMapper circlePostCommentDao;

    @Resource
    private PostsMapper pm;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public CirclePostComment queryById(String uuid) {
        return this.circlePostCommentDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CirclePostComment> queryAllByLimit(int offset, int limit) {
        return this.circlePostCommentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param circlePostComment 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public CirclePostComment insert(CirclePostComment circlePostComment) {
        circlePostComment.setUuid(UUID.randomUUID().toString().replace("-", ""));
        circlePostComment.setUpdateTime(new Date());
        circlePostComment.setCreateTime(new Date());
        circlePostComment.setFlag(CommonConst.NORMAL_STATUS);
        this.circlePostCommentDao.insert(circlePostComment);
        return circlePostComment;
    }

    /**
     * 修改数据
     *
     * @param circlePostComment 实例对象
     * @return 实例对象
     */
    @Override
    public CirclePostComment update(CirclePostComment circlePostComment) {
        if(StringUtil.isEmpty(circlePostComment.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        circlePostComment.setUpdateTime(new Date());
        this.circlePostCommentDao.update(circlePostComment);
        return this.queryById(circlePostComment.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.circlePostCommentDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param circlePostComment 实例对象
     * @return 对象列表
     */
    @Override
    public Page<CirclePostComment> queryAll(CirclePostComment circlePostComment) {
        if(circlePostComment.getPageSize() != null && circlePostComment.getPageNum() != null) {
            PageHelper.startPage(circlePostComment.getPageNum(), circlePostComment.getPageSize());
        }
        Page<CirclePostComment> pages =  this.circlePostCommentDao.queryAll(circlePostComment);
        return pages;
    }
}