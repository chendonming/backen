package com.xl.backen.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xl.backen.common.LoginService;
import com.xl.backen.dao.PeoplesMapper;
import com.xl.backen.entity.Peoples;
import com.xl.backen.handler.BusinessException;
import com.xl.backen.handler.BusinessStatus;
import com.xl.backen.handler.CommonConst;
import com.xl.backen.model.PeopleCodeModel;
import com.xl.backen.model.PeoplesPageModel;
import com.xl.backen.model.UsersModel;
import com.xl.backen.service.PeoplesService;
import com.xl.backen.shiro.CustomizedToken;
import com.xl.backen.util.HttpUrlUtil;
import com.xl.backen.util.MD5;
import com.xl.backen.util.PeoplesPOI;

import com.xl.backen.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * PeoplesServiceImpl
 */
@Service
public class PeoplesServiceImpl implements PeoplesService {

	private static Logger log = LoggerFactory.getLogger(PeoplesServiceImpl.class);

	@Autowired
	private PeoplesMapper pm;

	@Value("${filePath}")
	private String filePath;

	@Value("${nginxPath}")
	private String nginxPath;

	@Value("${server.session.timeout}")
	private Long sessionTimeOut;

	private final String appId = "wx886ac99b96a07e94";

	private final String appSecret = "4c2dce496c53dc2d655822ae25bebd8b";

	@Override
	public int add(Peoples peoples) {
		peoples.setUuid(UUID.randomUUID().toString().replace("-", ""));
		peoples.setCreateTime(new Date());
		peoples.setUpdateTime(new Date());
		peoples.setStatus(CommonConst.NORMAL_STATUS);
		if (StringUtil.isEmpty(peoples.getIdCard())) {
			peoples.setIsRealName(CommonConst.NO_REAL_NAME);
		} else {
			peoples.setIsRealName(CommonConst.IS_REAL_NAME);
		}
		return pm.insertSelective(peoples);
	}

	@Override
	public String exportPeople() throws IOException {
		PeoplesPageModel pp = new PeoplesPageModel();
		Page<Peoples> p = query(pp);
		List<Peoples> peoplesList = p.getResult();

		File file = new File(filePath + UUID.randomUUID().toString().replace("-", "") + ".xlsx");

		return nginxPath + PeoplesPOI.exportUser(file, peoplesList);
	}

	@Override
	@Transactional
	public int importPeople(MultipartFile file) throws Exception {
		List<Peoples> peoples = PeoplesPOI.importUser(file);

		log.info("导入的用户信息列表:", peoples);

		for (Peoples i : peoples) {
			add(i);
		}

		return 1;
	}

	@Override
	public Page<Peoples> query(PeoplesPageModel model) {
		if (model.getPageNum() != null && model.getPageSize() != null) {
			PageHelper.startPage(model.getPageNum(), model.getPageNum());
		}
		return pm.query(model);
	}

	/**
	 * 小程序登录接口
	 *
	 * @return 用户对象
	 */
	@Override
	public String login(PeopleCodeModel model) {
//		String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appId+"&secret="+appSecret+"&js_code="+model.getCode()+"&grant_type=authorization_code";
//		String content = HttpUrlUtil.httpURLConectionGET(url);
//		Peoples peoples = (Peoples)JSON.parse(content);

		Subject subject = SecurityUtils.getSubject();
		CustomizedToken token = new CustomizedToken(model.getOpenId(),model.getAppId(),CommonConst.LOGIN_TYPE_APP);

		subject.login(token);

		return "1";
	}
}