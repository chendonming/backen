package com.xl.backen.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xl.backen.dao.PeoplesMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.handler.Result;
import com.xl.backen.service.PeoplesService;
import com.xl.backen.service.WxUsersService;
import com.xl.backen.util.HttpUrlUtil;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/wx")
public class WxController {

    @Resource
    private WxUsersService wx;

    @Resource
    private PeoplesService ps;

    private static Logger logger = LoggerFactory.getLogger(WxController.class);

    @RequestMapping(value = "/gzh", method = RequestMethod.GET)
    public String direct(@RequestParam("code") String code,
                         @RequestParam("state") String state,
                         HttpServletRequest request, HttpServletResponse response) {
        if (CommonConst.map.get(state.split(",")[0]) == null) {
            throw new BusinessException(500, "没有这个公众号");
        }

        String appid = state.split(",")[0];
        String communityId = state.split(",")[1];

        String REDIRECT_URI = (String) CommonConst.map.get(appid);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + REDIRECT_URI + "&code=" + code + "&grant_type=authorization_code";
        logger.info("公众号登录appid={} REDIRECT_URI={} code={}", appid, REDIRECT_URI, code);


        Peoples peoples = new Peoples();
        JSONObject object = (JSONObject) JSON.parse(HttpUrlUtil.httpURLConectionGET(url));
        System.out.println(JSON.toJSONString(object));
        if (object.get("openid") == null) {
            logger.info("返回的结果={}", JSON.toJSONString(object));
            throw new BusinessException(500, "获取不到openid");
        }

        String openid = (String) object.get("openid");

        // 获取access_token
        String access_token = (String) object.get("access_token");
        System.out.println("获取的token:" + JSON.toJSONString(object));

        //  openid
        peoples.setOpenId(openid);

        // 查询用户信息
        String url_path = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid + "&lang=zh_CN";
        JSONObject user = (JSONObject) JSON.parse(HttpUrlUtil.httpURLConectionGET(url_path));

        System.out.println("获取的user" + JSON.toJSONString(user));

        peoples.setNickname((String) user.get("nickname"));
        peoples.setSex((Integer) user.get("sex"));
        peoples.setHeadPic((String) user.get("headimgurl"));
        peoples.setCommunityId(communityId);

        Peoples px = wx.gzhLogin(openid, appid, peoples);
        String sessionId = (String) SecurityUtils.getSubject().getSession().getId();

        String uri = "https://www.xxsghp.cn/weDream/weAPP/#/index/tabbar1?openid=" + (String) object.get("openid") + "&appid=" + appid + "&t=" + sessionId;

        return "redirect:" + uri;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public Object getUser() {
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if(obj == null) {
            throw new BusinessException(500, "没有获取到用户信息");
        }
        return obj;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int add(@RequestBody Peoples peoples) {
        return ps.add(peoples);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public Peoples get(@RequestBody Peoples peoples) {
        return  ps.queryOne(peoples.getUuid());
    }
}
