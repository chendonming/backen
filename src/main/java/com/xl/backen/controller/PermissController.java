package com.xl.backen.controller;

import java.util.List;

import javax.validation.Valid;

import com.github.pagehelper.Page;
import com.xl.backen.entity.*;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.model.RolesPowerModel;
import com.xl.backen.model.UsersPageModel;
import com.xl.backen.model.UsersRegisterRoleModel;
import com.xl.backen.service.*;
import org.apache.shiro.SecurityUtils;
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
    private PowersService ps;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/role/query", method = RequestMethod.POST)
    public ResultForPage<Roles> RoleQuery(@RequestBody UsersPageModel model) {
        Page<Roles> roles = rs.queryAll(model.getPageNum(),model.getPageSize());
        PageInfo<Roles> pageInfo = new PageInfo<>(roles);
        return new ResultForPage<Roles>(BusinessStatus.SUCCESS, pageInfo);
    }

    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    public Result<Object> RoleAdd(@RequestBody @Valid Roles role) {
        log.info("角色新增接口参数: {}", role);
        rs.insertSelective(role);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public Result<Object> RoleUpdate(@RequestBody @Valid Roles role) {
        log.info("角色update接口参数: {}", role);
        rs.updateRole(role);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/role/queryOne", method = RequestMethod.POST)
    public Result<Roles> queryOne(@RequestBody Roles role) {
        log.info("角色update接口参数: {}", role);
        return new Result<Roles>(BusinessStatus.SUCCESS,rs.findById(role));
    }

    @RequestMapping(value = "/role/del", method = RequestMethod.POST)
    @Transactional
    public Result<Object> RoleDel(@RequestBody Roles roles) {
        log.info("角色删除接口参数: {}", roles.getUuid());
        List<Users> users = urs.findByRoleId(roles.getUuid());
        if (users == null) {
            Roles r = new Roles();
            r.setUuid(roles.getUuid());
            r.setStatus(CommonConst.DEL_STATUS);
            rs.updateRole(r);
            return new Result<>(BusinessStatus.SUCCESS);
        } else {
            throw new BusinessException(BusinessStatus.ROLE_ERROR);
        }
    }

    /**
     * 根据角色id查找权限菜单
     */
    @RequestMapping(value = "/menus/queryByRoleId", method = RequestMethod.POST)
    public Result<List<Powers>> queryByRoleId(@RequestBody Menus menus) {
        String uuid = menus.getUuid();
        List<Powers> powers = ps.queryByRoleId(uuid);
        return new Result<List<Powers>>(BusinessStatus.SUCCESS,powers);
    }

    @RequestMapping(value = "/rolepower/givePermiss", method = RequestMethod.POST)
    public Result<Object> RolepowerAdd(@RequestBody RolesPowerModel model) throws Exception {
        log.info("给角色赋权接口参数: {}", model);
        rps.givePermiss(model);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/role/allocationRole", method = RequestMethod.POST)
    public Result<Object> allocationRole(@RequestBody UsersRole ur) throws Exception {
        log.info("给用户赋予角色接口参数: {}", ur);
        urs.allocationRole(ur);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    /**
     * 所有的菜单(包括顶级菜单)
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/menus/queryAllHasMenus", method = RequestMethod.POST)
    public Result<List<ParentMenus>> queryAllHasMenus(){
        return new Result<List<ParentMenus>>(BusinessStatus.SUCCESS, ps.queryParentMenus());
    }

    /**
     * 所有的权限
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/powers/queryAll", method = RequestMethod.GET)
    public Result<List<Powers>> powersAll() throws Exception {
        List<Powers> lp = ps.queryAll();
        return new Result<List<Powers>>(BusinessStatus.SUCCESS, lp);
    }


    /**
     * 新增菜单
     * @param powers
     * @return
     */
    @RequestMapping(value = "/powers/add", method = RequestMethod.POST)
    public Result<Object> powersAdd(@RequestBody Powers powers) {
        ps.insertPowers(powers);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    /**
     * 删除菜单
     * @param powers
     * @return
     */
    @RequestMapping(value = "/powers/del", method = RequestMethod.POST)
    public Result<Object> powersDel(String uuid) {
        ps.delPowers(uuid);
        return new Result<>(BusinessStatus.SUCCESS);
    }


    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @Transactional
    public Result<Object> register(@RequestBody @Valid UsersRegisterRoleModel model) {
        log.info("注册并赋予初始权限接口参数: {}", model);
        //注册
        String uuid = usersService.Register(model.getUser());
        log.info("注册成功！uuid为: {}", uuid);
        //赋权
        Users users = new Users();
        users.setUuid(uuid);
        users.setRoleId(model.getRoleId());
        usersService.update(model);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/user/queryAll", method = RequestMethod.POST)
    public ResultForPage<Users> usersAll(@RequestBody UsersPageModel model) throws Exception {
        Users usersModel = (Users)SecurityUtils.getSubject().getPrincipal();

        model.setSysType(usersModel.getSysType());
        Page<Users> users = usersService.queryAll(model);
        PageInfo<Users> pageInfo = new PageInfo<Users>(users);
        return new ResultForPage<Users>(BusinessStatus.SUCCESS,pageInfo);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody UsersRegisterRoleModel model) throws Exception {
        usersService.update(model);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/user/queryOne", method = RequestMethod.POST)
    public Result<Users> queryOne(@RequestBody Users model) throws Exception {
        Users users = usersService.findById(model.getUuid());
        return new Result<Users>(BusinessStatus.SUCCESS,users);
    }
}
