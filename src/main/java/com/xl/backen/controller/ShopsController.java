package com.xl.backen.controller;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Shops;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.PageInfo;
import com.xl.backen.handler.Result;
import com.xl.backen.handler.ResultForPage;
import com.xl.backen.service.ShopsService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopsController {
    @Autowired
    private ShopsService ss;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Object> add(@RequestBody Shops shops) {
        ss.insertSelective(shops);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Object> update(@RequestBody Shops shops) {
        ss.updateByPrimaryKeySelective(shops);
        return new Result<>(BusinessStatus.SUCCESS);
    }

    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public Result<Shops> queryOne(@RequestBody Shops shops) {
        return new Result<Shops>(BusinessStatus.SUCCESS, ss.selectByPrimaryKey(shops.getUuid()));
    }
    
    /*
     * 分页查询 : pageSize, pageNum
     */
    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public ResultForPage<Shops> queryList(@RequestBody Map<String, Object> map) {
    	Page<Shops> paShops = ss.query(map);
    	PageInfo<Shops> pageInfo = new PageInfo<>(paShops);
        return new ResultForPage<Shops>(BusinessStatus.SUCCESS, pageInfo);
    }
}
