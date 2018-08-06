package com.xl.backen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.dao.CommunitysMapper;
import com.xl.backen.dao.UsersMapper;
import com.xl.backen.entity.Communitys;
import com.xl.backen.entity.Users;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.CommunitysForAddModel;
import com.xl.backen.model.CommunitysPageModel;
import com.xl.backen.model.UsersModel;
import com.xl.backen.service.CommunitysService;
import com.xl.backen.util.MD5;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class CommunitysServiceImpl implements CommunitysService {

    @Autowired
    private CommunitysMapper cm;

    @Autowired
    private UsersMapper um;

    @Override
    public int add(Communitys communitys) throws Exception {
        UsersModel model = (UsersModel) SecurityUtils.getSubject().getPrincipal();
        //新增
        String uuid = addCommunity(communitys);

        //指定管理员
        Users users = new Users();
        users.setUuid(UUID.randomUUID().toString().replace("-", ""));
        users.setCommunityId(uuid);
        users.setMobile(communitys.getLeaderMobile());
        users.setNickname(communitys.getLeaderName());
        users.setTruename(communitys.getLeaderName());
        users.setCreateTime(new Date());
        users.setUpdateTime(new Date());
        users.setPassword(MD5.md5(CommonConst.PASSWORD));
        users.setSysType(model.getSysType());
        users.setStatus(CommonConst.NORMAL_STATUS);

        //指定初始角色值


        um.insertSelective(users);

        return 0;
    }

    @Override
    public int update(Communitys communitys) {
        if (StringUtils.isEmpty(communitys.getUuid())) {
            throw new BusinessException(BusinessStatus.UUID_REQ);
        }
        return cm.updateByPrimaryKeySelective(communitys);
    }

    @Override
    public Page<Communitys> query(CommunitysPageModel model) {
        PageHelper.startPage(model.getPageNum(), model.getPageSize());

        UsersModel usersModel = (UsersModel)SecurityUtils.getSubject().getPrincipal();

        model.setSysType(usersModel.getSysType());

        return cm.query(model);
    }

    @Override
    public Communitys findById(String uuid) {
        if (StringUtils.isEmpty(uuid)) {
            throw new BusinessException(BusinessStatus.UUID_REQ);
        }
        return cm.selectByPrimaryKey(uuid);
    }

    public String addCommunity(Communitys communitys) {
        UsersModel model = (UsersModel) SecurityUtils.getSubject().getPrincipal();

        String uuid = UUID.randomUUID().toString().replace("-", "");

        communitys.setUuid(uuid);
        communitys.setStatus(CommonConst.NORMAL_STATUS);
        communitys.setCreateTime(new Date());
        communitys.setUpdateTime(new Date());
        communitys.setSysType(model.getSysType());

        communitys.setCreateUser(model.getUuid());
        cm.insertSelective(communitys);

        return uuid;
    }
}
