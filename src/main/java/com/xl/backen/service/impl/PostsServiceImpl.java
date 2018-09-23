package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.PostPeopleThumbsMapper;
import com.xl.backen.dao.PostsMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.PostPeopleThumbs;
import com.xl.backen.entity.Posts;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.PostModel;
import com.xl.backen.service.PostsService;
import com.xl.backen.util.ArrayUtil;
import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsMapper pm;

    @Autowired
    private PostPeopleThumbsMapper pptm;

    @Override
    public int add(Posts posts) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        posts.setUuid(uuid);
        posts.setCreateTime(new Date());
        posts.setUpdateTime(new Date());
        posts.setFlag(CommonConst.NORMAL_STATUS);
        Object object = SecurityUtils.getSubject().getPrincipal();
        if (object instanceof Peoples) {
            posts.setCreateId(((Peoples) object).getUuid());
        }

        if(object instanceof Users) {
            posts.setCreateId(((Users) object).getUuid());
        }
        return pm.insertSelective(posts);
    }

    @Override
    public int update(Posts posts) {
        if (StringUtil.isEmpty(posts.getUuid())) {
            throw new BusinessException(999, "uuid不能为空");
        }
        posts.setUpdateTime(new Date());
        return pm.updateByPrimaryKeySelective(posts);
    }

    /**
     * 点赞
     *
     * @param posts
     * @return
     */
    @Override
    @Transactional
    public int thumbsUp(Posts posts) {
        Peoples peoples = (Peoples) SecurityUtils.getSubject().getPrincipal();
        synchronized (posts) {
            // 判断是否点赞
            PostPeopleThumbs ppt = new PostPeopleThumbs();
            ppt.setPostId(posts.getUuid());
            ppt.setPeopleId(peoples.getUuid());
            int count = pptm.queryByPeopleAndPost(ppt);

            int thumbs = pm.selectByPrimaryKey(posts.getUuid()).getThumbs();
            if (count == 0) {
                // 帖子点赞数 +1
                posts.setThumbs(thumbs + 1);
            } else {
                // 取消点赞
                posts.setThumbs(thumbs - 1);
            }
            pm.updateByPrimaryKeySelective(posts);
        }

        synchronized (peoples) {
            // 添加积分
        }

        return 0;
    }

    @Override
    public Page<Posts> queryAll(Map<String, Object> map) {
        Peoples peoples = (Peoples) SecurityUtils.getSubject().getPrincipal();
        if (map.get("pageSize") != null && map.get("pageNum") != null) {
            PageHelper.startPage((Integer) map.get("pageSize"), (Integer) map.get("pageNum"));
        }
        // 所有符合条件的posts
        Page<Posts> posts = pm.queryPosts(map);
        // 我点赞的posts
        Page<Posts> myPosts = pm.queryMyThumbPosts(peoples.getUuid());

        // 取数组交集
        List<Posts> postsList = ArrayUtil.compareArrSame(posts.getResult(), myPosts.getResult());

        for (Posts i : posts) {
            int flag = 2;
            for (Posts j : postsList) {
                // 已点赞
                if (i.getUuid().equals(j.getUuid())) {
                    flag = 1;
                }
            }
            i.setIsThumbs(flag);
        }

        return (Page<Posts>) posts;
    }

    @Override
    public PostModel queryOne(String uuid) {
        return null;
    }
}
