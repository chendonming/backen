package com.xl.backen.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xl.backen.entity.Menus;
import com.xl.backen.entity.Powers;
import com.xl.backen.entity.Roles;
import com.xl.backen.entity.RolesPower;
import com.xl.backen.entity.UsersRole;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.Result;
import com.xl.backen.service.MenusService;
import com.xl.backen.service.PowersService;
import com.xl.backen.service.RolesPowerService;
import com.xl.backen.service.RolesService;
import com.xl.backen.service.UsersRoleService;

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
}
