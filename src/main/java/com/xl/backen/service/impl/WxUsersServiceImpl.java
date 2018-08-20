package com.xl.backen.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xl.backen.dao.PeoplesMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.service.WxUsersService;
import com.xl.backen.shiro.CustomizedToken;
import com.xl.backen.util.HttpUrlUtil;
import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@CacheConfig(cacheNames = "peoples")
public class WxUsersServiceImpl implements WxUsersService {

	private static Logger logger = LoggerFactory.getLogger(WxUsersServiceImpl.class);

	@Autowired
	private PeoplesMapper pm;

	@Value("${server.session.timeout}")
	private Long sessionTimeOut;

	@Override
	public Peoples login(Peoples peoples) {
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+CommonConst.APPID+"&secret="+CommonConst.APPSECRET+"&js_code="+peoples.getCode()+"&grant_type=authorization_code";
		logger.info("微信登录={}",peoples);

		//根据code获取用户信息
		JSONObject object = (JSONObject) JSON.parse(HttpUrlUtil.httpURLConectionGET(url));
		peoples.setOpenId((String)object.get("openid"));
		logger.info("根据code获取的用户信息: {}",peoples);

		Subject subject = SecurityUtils.getSubject();
		CustomizedToken token = null;

		try {
			token = new CustomizedToken();
			token.setPeoples(peoples);
			token.setLoginType(CommonConst.LOGIN_TYPE_APP);
		} catch (Exception e) {
			throw new BusinessException(BusinessStatus.MD5_ERROR);
		}

		try {
			subject.login(token);
			subject.getSession().setTimeout(sessionTimeOut);
			Peoples p = (Peoples) subject.getPrincipal();

			Object o = SecurityUtils.getSubject().getSession().getId();
			p.setSessionId((String)o);
			return p;
		} catch (UnknownAccountException e) {
			throw new BusinessException(BusinessStatus.USER_ERROR);
		} catch (IncorrectCredentialsException e) {
			throw new BusinessException(BusinessStatus.PASSWORD_ERROR);
		}
	}


	/**
	 * APP端实名认证
	 * @param peoples
	 * @return
	 */
	@Override
	@CacheEvict(allEntries=true)
	public int authentication(Peoples peoples) {
		if(StringUtil.isEmpty(peoples.getMobile()) && StringUtil.isEmpty(peoples.getIdCard())) {
			throw new BusinessException(BusinessStatus.AUTHC_APP_RQ);
		}

		//根据手机号码进行匹配
		Peoples p = pm.findByMobile(peoples.getMobile());
		if(p == null) {
				throw new BusinessException(BusinessStatus.AUTHC_APP_NULL);
		}

		Peoples app = (Peoples)SecurityUtils.getSubject().getPrincipal();

		p.setOpenId(app.getOpenId());
		//已实名
		p.setIsRealName(CommonConst.IS_REAL_NAME);
		//设置普通居民
		p.setRole(CommonConst.NOMARL_USER);
		//设置修改时间
		p.setUpdateTime(new Date());
		//设置昵称
		p.setNickname(app.getNickname());
		//设置头像
		p.setHeadPic(app.getHeadPic());
		//设置性别
		p.setSex(app.getSex());
		//设置初始积分
		p.setTotalIntegral(CommonConst.INIT_INTEGRAL);
		//设置剩余积分
		p.setIntegral(CommonConst.INIT_INTEGRAL);
		//设置状态
		p.setStatus(CommonConst.NORMAL_STATUS);
		//设置systype
		p.setSysType(app.getSysType());

		pm.updateByPrimaryKeySelective(p);
		return 1;
	}
}
