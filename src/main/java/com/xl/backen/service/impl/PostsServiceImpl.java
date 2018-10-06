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
    public Posts thumbsUp(Posts posts) {
        Peoples peoples = (Peoples) SecurityUtils.getSubject().getPrincipal();
        synchronized (posts) {
            // 判断是否点赞
            PostPeopleThumbs ppt = new PostPeopleThumbs();
            ppt.setPostId(posts.getUuid());
            ppt.setPeopleId(peoples.getUuid());
            List<PostPeopleThumbs> postPeopleThumbs = pptm.queryByPeopleAndPost(ppt);
            int count = postPeopleThumbs.size();
            System.out.println("count ------------" + count);

            int thumbs = pm.selectByPrimaryKey(posts.getUuid()).getThumbs() == null ? 0 : pm.selectByPrimaryKey(posts.getUuid()).getThumbs();
            if (count == 0) {
                ppt.setUuid(UUID.randomUUID().toString().replace("-", ""));
                ppt.setCreateTime(new Date());
                ppt.setUpdateTime(new Date());
                ppt.setFlag(CommonConst.NORMAL_STATUS);
                pptm.insertSelective(ppt);

                // 帖子点赞数 +1
                posts.setThumbs(thumbs + 1);
                // 设置点赞状态
                posts.setIsThumbs(1);
            } else {
                // 取消点赞
                PostPeopleThumbs pt = postPeopleThumbs.get(0);
                pt.setFlag(CommonConst.DEL_STATUS);
                pptm.updateByPrimaryKeySelective(pt);
                posts.setThumbs(thumbs - 1);
                // 设置未点赞状态
                posts.setIsThumbs(2);
            }
            pm.updateByPrimaryKeySelective(posts);
        }


        synchronized (peoples) {
            // 添加积分
        }

        return posts;
    }

    /**
     *  map: loginType( 1.PC添加  2.微信端添加的 )
     * @param map( pageSize, pageNum , circleId)
     * @return
     */
    @Override
    public Page<Posts> queryAll(Map<String, Object> map) {
        String uuid = null;
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if(obj instanceof Peoples) {
            uuid = ((Peoples) obj).getUuid();
        }
        if(obj instanceof Users) {
            uuid = ((Users) obj).getUuid();
        }
        if (map.get("pageSize") != null && map.get("pageNum") != null) {
            PageHelper.startPage((Integer) map.get("pageNum"), (Integer) map.get("pageSize"));
        }
        // 所有符合条件的posts
        Page<Posts> posts = pm.queryPosts(map);
        // 我点赞的posts
        Page<Posts> myPosts = pm.queryMyThumbPosts(uuid);

        // 取数组交集
        List<Posts> postsList = ArrayUtil.compareArrSame(posts.getResult(), myPosts.getResult());

        for (Posts i : posts) {

            i.setCommentCount(pm.commentCount(i.getUuid()) == null ? 0: pm.commentCount(i.getUuid()));

            for (Posts j : postsList) {
                // 已点赞
                if (i.getUuid().equals(j.getUuid())) {
                    int flag = 1;
                    i.setIsThumbs(flag);
                }
            }
        }

        return (Page<Posts>) posts;
    }

    @Override
    public Posts queryOne(String uuid) {
        Peoples peoples = (Peoples) SecurityUtils.getSubject().getPrincipal();
        PostPeopleThumbs ppt = new PostPeopleThumbs();
        ppt.setPostId(uuid);
        ppt.setPeopleId(peoples.getUuid());
        List<PostPeopleThumbs> postPeopleThumbs = pptm.queryByPeopleAndPost(ppt);

        Posts posts = pm.selectByPrimaryKey(uuid);
        posts.setCommentCount(pm.commentCount(posts.getUuid()) == null ? 0: pm.commentCount(posts.getUuid()));
        if(postPeopleThumbs.size() > 0) {
            // 设置已点赞
            posts.setIsThumbs(1);
        }else{
            // 设置未点赞
            posts.setIsThumbs(2);
        }
        return posts;
    }
}
