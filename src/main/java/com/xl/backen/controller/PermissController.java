package com.xl.backen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.xl.backen.entity.*;
import com.xl.backen.model.UsersRegisterRoleModel;
import com.xl.backen.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;

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
		 return new Result(BusinessStatus.SUCCESS,roles);
	}
	
	@RequestMapping(value = "/role/add", method = RequestMethod.POST)
	public Result RoleAdd(@RequestBody @Valid Roles role) {
		 rs.insertSelective(role);
		 return new Result(BusinessStatus.SUCCESS);
	}

    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public Result RoleUpdate(@RequestBody @Valid Roles role) {
        rs.updateRole(role);
        return new Result(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/role/del", method = RequestMethod.GET)
    public Result RoleDel(@RequestParam String roleId) {
	    //TODO 角色删除  需要查询角色下的用户
        return new Result(BusinessStatus.SUCCESS);
    }
	
	@RequestMapping(value = "/rolepower/givePermiss", method = RequestMethod.POST)
	public Result RolepowerAdd(@RequestBody @Valid List<RolesPower> rp) throws Exception {
		rps.givePermiss(rp);
		return new Result(BusinessStatus.SUCCESS);
	}
	
	@RequestMapping(value = "/role/allocationRole", method = RequestMethod.POST)
	public Result allocationRole(@RequestBody @Valid List<UsersRole> ur) throws Exception {
		urs.allocationRole(ur);
		return new Result(BusinessStatus.SUCCESS);
	}
	
	/**
	 * 所有的菜单
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/menus/queryAll", method = RequestMethod.GET)
	public Result menusAll() throws Exception {
		List<Menus> me = ms.queryAll();
		return new Result(BusinessStatus.SUCCESS,me);
	}
	
	/**
	 * 所有的权限
	* @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/powers/queryAll", method = RequestMethod.GET)
	public Result powersAll() throws Exception {
		List<Powers> lp= ps.queryAll(); 
		return new Result(BusinessStatus.SUCCESS,lp);
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @Transactional
	public Result register(@RequestBody @Valid UsersRegisterRoleModel model) {
		//注册
		String uuid =  usersService.Register(model.getUser());
		//赋权
		List<UsersRole> usersRoleList = new ArrayList<UsersRole>();
		UsersRole ur = new UsersRole();
		ur.setRoleId(model.getRoleId());
		ur.setUserId(uuid);
        usersRoleList.add(ur);
        urs.allocationRole(usersRoleList);
		return new Result(BusinessStatus.SUCCESS);
	}
}
