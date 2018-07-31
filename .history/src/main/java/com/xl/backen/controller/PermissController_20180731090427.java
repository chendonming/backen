package com.xl.backen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.github.pagehelper.Page;
import com.xl.backen.entity.*;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.model.UsersRegisterRoleModel;
import com.xl.backen.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.handler.ResultForPage;

@RestController
@RequestMapping("/permiss")
public class PermissController {
    private static Logger log = LoggerFactory.getLogger(PermissController.class);

    @Autowired
    private RolesService rs;

    @Autowired
    private RolesPowerService rps;

    @Autowired
    private UsersRoleService urs;

    @Autowired
    private MenusService ms;

    @Autowired
    private PowersService ps;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/role/query", method = RequestMethod.POST)
    public Result RoleQuery() {
        List<Roles> roles = rs.queryAll();
        return new Result(BusinessStatus.SUCCESS, roles);
    }

    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    public Result RoleAdd(@RequestBody @Valid Roles role) {
        log.info("角色新增接口参数: {}", role);
        rs.insertSelective(role);
        return new Result(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public Result RoleUpdate(@RequestBody @Valid Roles role) {
        log.info("角色update接口参数: {}", role);
        rs.updateRole(role);
        return new Result(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/role/del", method = RequestMethod.GET)
    @Transactional
    public Result RoleDel(@RequestParam("uuid") String roleId) {
        log.info("角色删除接口参数: {}", roleId);
        List<Users> users = urs.findByRoleId(roleId);
        if (users == null) {
            Roles r = new Roles();
            r.setUuid(roleId);
            r.setStatus(CommonConst.DEL_STATUS);
            rs.updateRole(r);
            return new Result(BusinessStatus.SUCCESS);
        } else {
            throw new BusinessException(BusinessStatus.ROLE_ERROR);
        }
    }

    @RequestMapping(value = "/rolepower/givePermiss", method = RequestMethod.POST)
    public Result RolepowerAdd(@RequestBody @Valid List<RolesPower> rp) throws Exception {
        log.info("给角色赋权接口参数: {}", rp);
        rps.givePermiss(rp);
        return new Result(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/role/allocationRole", method = RequestMethod.POST)
    public Result allocationRole(@RequestBody @Valid List<UsersRole> ur) throws Exception {
        log.info("给用户赋予角色接口参数: {}", ur);
        urs.allocationRole(ur);
        return new Result(BusinessStatus.SUCCESS);
    }

    /**
     * 所有的菜单
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/menus/queryAll", method = RequestMethod.GET)
    public Result menusAll() throws Exception {
        List<Menus> me = ms.queryAll();
        return new Result(BusinessStatus.SUCCESS, me);
    }

    /**
     * 所有的权限
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/powers/queryAll", method = RequestMethod.GET)
    public Result powersAll() throws Exception {
        List<Powers> lp = ps.queryAll();
        return new Result(BusinessStatus.SUCCESS, lp);
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @Transactional
    public Result register(@RequestBody @Valid UsersRegisterRoleModel model) {
        log.info("注册并赋予初始权限接口参数: {}", model);
        //注册
        String uuid = usersService.Register(model.getUser());
        log.info("注册成功！uuid为: {}", uuid);
        //赋权
        List<UsersRole> usersRoleList = new ArrayList<UsersRole>();
        UsersRole ur = new UsersRole();
        ur.setRoleId(model.getRoleId());
        ur.setUserId(uuid);
        usersRoleList.add(ur);
        urs.allocationRole(usersRoleList);
        return new Result(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/user/queryAll", method = RequestMethod.GET)
    public ResultForPage usersAll(@RequestParam("pageSize") int pageSize,
                           @RequestParam("pageNum") int pageNum) throws Exception {
        Page<Users> users = usersService.queryAll(pageNum, pageSize);
        PageInfo<Users> pageInfo = new PageInfo<Users>(users);
        return new ResultForPage(BusinessStatus.SUCCESS,pageInfo);
    }
}
