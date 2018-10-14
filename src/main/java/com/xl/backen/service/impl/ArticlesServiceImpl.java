package com.xl.backen.service.impl;

import com.xl.backen.entity.Articles;
import com.xl.backen.dao.ArticlesMapper;
import com.xl.backen.entity.Users;
import com.xl.backen.service.ArticlesService;
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
 * 文章表(TbArticles)表服务实现类
 *
 * @author chendm
 * @since 2018-10-04 19:50:09
 */
@Service
public class ArticlesServiceImpl implements ArticlesService {
    @Resource
    private ArticlesMapper articlesDao;

    
    /**
     * 通过ID查询单条数据
     *
     * @param uuid 主键
     * @return 实例对象
     */
    @Override
    public Articles queryById(String uuid) {
        return this.articlesDao.queryById(uuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Articles> queryAllByLimit(int offset, int limit) {
        return this.articlesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param articles 实例对象
     * @return 实例对象
     */
    @Override
    public Articles insert(Articles articles) {
        Users users = (Users)SecurityUtils.getSubject().getPrincipal();

        articles.setUuid(UUID.randomUUID().toString().replace("-", ""));
        articles.setUpdateTime(new Date());
        articles.setCreateTime(new Date());
        articles.setFlag(CommonConst.NORMAL_STATUS);
        articles.setCreateId(users.getUuid());


        this.articlesDao.insert(articles);
        return articles;
    }

    /**
     * 修改数据
     *
     * @param articles 实例对象
     * @return 实例对象
     */
    @Override
    public Articles update(Articles articles) {
        if(StringUtil.isEmpty(articles.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        articles.setUpdateTime(new Date());
        this.articlesDao.update(articles);
        return this.queryById(articles.getUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String uuid) {
        return this.articlesDao.deleteById(uuid) > 0;
    }


    /**
     * 通过实体作为筛选条件查询(分页查询)
     *
     * @param articles 实例对象
     * @return 对象列表
     */
    @Override
    public Page<Articles> queryAll(Articles articles) {
        if(articles.getPageSize() != null && articles.getPageNum() != null) {
            PageHelper.startPage(articles.getPageNum(), articles.getPageSize());
        }
        Page<Articles> pages =  this.articlesDao.queryAll(articles);
        return pages;
    }
}