/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-04 10:32:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_activitys`
-- ----------------------------
DROP TABLE IF EXISTS `tb_activitys`;
CREATE TABLE `tb_activitys` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `community_id` varchar(255) DEFAULT NULL COMMENT '所属社区',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `join_start_time` datetime DEFAULT NULL COMMENT '报名开始时间',
  `join_end_time` datetime DEFAULT NULL COMMENT '报名结束时间',
  `location` varchar(255) DEFAULT NULL COMMENT '地点',
  `limit_people` int(1) DEFAULT NULL COMMENT '人数上限',
  `integral` int(1) DEFAULT NULL COMMENT '任务积分（每人）',
  `join_people` int(1) DEFAULT NULL COMMENT '报名人数',
  `data_form` int(1) DEFAULT NULL COMMENT '数据来源(1.总后台 2.社区）',
  `create_user` varchar(255) DEFAULT NULL COMMENT '发布者',
  `coverpic` varchar(255) DEFAULT NULL COMMENT '活动的封面图',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '1.正常2.删除',
  PRIMARY KEY (`uuid`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动表';

-- ----------------------------
-- Records of tb_activitys
-- ----------------------------
INSERT INTO `tb_activitys` VALUES ('c5c3d92d40e54d09bf81ada990858e47', '新建活动', null, '2018-08-01 12:00:00', '2018-08-02 02:00:00', '2018-08-03 00:00:00', '2018-08-04 00:00:00', '湖南申', null, null, null, '1', '47c0562c5e744776b61f3489c1e5b1bf', null, null, '2018-08-02 20:54:34', '2018-08-02 20:54:34', '1');

-- ----------------------------
-- Table structure for `tb_communitys`
-- ----------------------------
DROP TABLE IF EXISTS `tb_communitys`;
CREATE TABLE `tb_communitys` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '社区名称',
  `integral` int(1) DEFAULT NULL COMMENT '当前积分',
  `create_user` varchar(255) DEFAULT NULL COMMENT '发布者',
  `total_integral` int(1) DEFAULT NULL COMMENT '总积分',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '是否有效 1正常 2删除',
  PRIMARY KEY (`uuid`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社区表';

-- ----------------------------
-- Records of tb_communitys
-- ----------------------------
INSERT INTO `tb_communitys` VALUES ('efd630deba124713bc45082ec6cda0e5', '新建的社区', null, '47c0562c5e744776b61f3489c1e5b1bf', null, null, '2018-08-02 23:11:07', '2018-08-02 23:11:07', '1');

-- ----------------------------
-- Table structure for `tb_menus`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menus`;
CREATE TABLE `tb_menus` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `up_menu_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of tb_menus
-- ----------------------------
INSERT INTO `tb_menus` VALUES ('2ec6095845eb4b00b9df3069244d84a8', '任务管理', 'task', '2018-07-28 20:52:46', '2018-07-28 20:52:48', 'cf6ac315faf048f7bb9016726914b8c4\r');
INSERT INTO `tb_menus` VALUES ('c3d436685e1c493fa2554c87a21dec89', ' 权限管理', 'permiss', '2018-07-29 18:11:41', '2018-07-29 18:11:43', 'cf6ac315faf048f7bb9016726914b8c4\r');
INSERT INTO `tb_menus` VALUES ('f8c2d15acb374a16a03cc881548fbd14', '活动管理', 'activity', '2018-07-28 20:53:14', '2018-07-28 20:53:17', 'cf6ac315faf048f7bb9016726914b8c4\r');

-- ----------------------------
-- Table structure for `tb_parent_menus`
-- ----------------------------
DROP TABLE IF EXISTS `tb_parent_menus`;
CREATE TABLE `tb_parent_menus` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='父级菜单表';

-- ----------------------------
-- Records of tb_parent_menus
-- ----------------------------
INSERT INTO `tb_parent_menus` VALUES ('cf6ac315faf048f7bb9016726914b8c4', '内容管理', 'content', '2018-07-30 14:24:16', '2018-07-30 14:24:19');

-- ----------------------------
-- Table structure for `tb_peoples`
-- ----------------------------
DROP TABLE IF EXISTS `tb_peoples`;
CREATE TABLE `tb_peoples` (
  `uuid` varchar(255) NOT NULL,
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `truename` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `mobile` varchar(11) DEFAULT NULL COMMENT '11位手机号码',
  `sex` int(1) DEFAULT NULL COMMENT '性别： 1男 2女',
  `password` varchar(255) DEFAULT NULL,
  `is_real_name` int(1) DEFAULT NULL COMMENT '是否实名: 1 实名 2非实名',
  `id_card` varchar(18) DEFAULT NULL COMMENT '18   位身份证号码',
  `community_id` varchar(255) DEFAULT NULL COMMENT '所属社区id',
  `total_integral` int(1) DEFAULT NULL COMMENT '总积分（会一直增加）',
  `integral` int(1) DEFAULT NULL COMMENT '现有积分',
  `status` int(1) DEFAULT NULL COMMENT ' 状态 1正常 2.禁用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `identity_flag` int(1) DEFAULT '0' COMMENT '身份标识 0 居民 1.志愿者  2社工',
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `mobile` (`mobile`) USING BTREE,
  KEY `status` (`status`),
  KEY `identity_flag` (`identity_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_peoples
-- ----------------------------
INSERT INTO `tb_peoples` VALUES ('123', 'zhangsan ', '0', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_peoples` VALUES ('123213', 'lisi', '1', null, '18588773304', null, '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `tb_powers`
-- ----------------------------
DROP TABLE IF EXISTS `tb_powers`;
CREATE TABLE `tb_powers` (
  `uuid` varchar(255) NOT NULL,
  `code` varchar(20) DEFAULT NULL COMMENT '权限标识',
  `meun_id` varchar(255) DEFAULT NULL COMMENT ' 菜单id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `meun_id` (`meun_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of tb_powers
-- ----------------------------
INSERT INTO `tb_powers` VALUES ('15458a40fc6a4de098bb8621deaa0864', 'task:add', '2ec6095845eb4b00b9df3069244d84a8', null, '2018-07-28 20:54:26', '2018-07-28 20:54:28');
INSERT INTO `tb_powers` VALUES ('1e1f78db5e854fcaa8ce9df1db45b267', 'permiss', 'c3d436685e1c493fa2554c87a21dec89', '  权限管理所有的权限', '2018-07-29 18:20:32', '2018-07-29 18:20:35');
INSERT INTO `tb_powers` VALUES ('37f7b4e881984c9d818c6133f84c5585', 'task:del', '2ec6095845eb4b00b9df3069244d84a8', null, '2018-07-29 11:41:57', '2018-07-29 11:41:59');
INSERT INTO `tb_powers` VALUES ('47f03c9d1c36462da0fd0884c5b34c63', 'task:update', '2ec6095845eb4b00b9df3069244d84a8', null, '2018-07-29 18:19:41', '2018-07-29 18:19:43');
INSERT INTO `tb_powers` VALUES ('784239c65fcb4f1cac028eecda7bbab6', 'activity:query', 'f8c2d15acb374a16a03cc881548fbd14', null, '2018-07-28 20:54:58', '2018-07-28 20:55:00');
INSERT INTO `tb_powers` VALUES ('cfad135466ad4da8b84ce93b45e0031e', 'task:query', '2ec6095845eb4b00b9df3069244d84a8', '任务管理的查询权限', '2018-07-28 20:53:53', '2018-07-28 20:53:56');

-- ----------------------------
-- Table structure for `tb_roles`
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles`;
CREATE TABLE `tb_roles` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT ' 描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '1正常 2删除',
  PRIMARY KEY (`uuid`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of tb_roles
-- ----------------------------
INSERT INTO `tb_roles` VALUES ('1aeba04bda824f54a3fc01d8b1af389a', '新增的角色', '没事出来玩的', '2018-07-29 01:25:36', '2018-07-29 01:25:36', '1');
INSERT INTO `tb_roles` VALUES ('50e41d6abb654f7c97b022757ff1d8e6', '小型管理员', '部分操作', '2018-07-28 20:49:24', '2018-07-28 20:49:27', '1');
INSERT INTO `tb_roles` VALUES ('69bb65467a4a40a88fc2e42f3672220', '大型管理员', '绝大部分操作', '2018-07-28 20:51:41', '2018-07-28 20:51:45', '1');

-- ----------------------------
-- Table structure for `tb_roles_power`
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles_power`;
CREATE TABLE `tb_roles_power` (
  `uuid` varchar(255) NOT NULL,
  `power_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) NOT NULL,
  `status` int(1) DEFAULT NULL COMMENT '是否有效（1.有效 2.无效）',
  PRIMARY KEY (`uuid`),
  KEY `power_id` (`power_id`),
  KEY `role_id` (`role_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of tb_roles_power
-- ----------------------------
INSERT INTO `tb_roles_power` VALUES ('1b00d632664f44049c7eed171010d8bf', '1e1f78db5e854fcaa8ce9df1db45b267', '69bb65467a4a40a88fc2e42f3672220', '2');
INSERT INTO `tb_roles_power` VALUES ('326f3ef8f9d14ce8993aaab14d20e68a', '37f7b4e881984c9d818c6133f84c5585', '69bb65467a4a40a88fc2e42f3672220', '1');
INSERT INTO `tb_roles_power` VALUES ('383050b7fbd641d18c22f3453263fc9', 'cfad135466ad4da8b84ce93b45e0031e', '69bb65467a4a40a88fc2e42f3672220', '2');
INSERT INTO `tb_roles_power` VALUES ('5b14f32abf6c485dbff6de612eec4f63', '784239c65fcb4f1cac028eecda7bbab6', '69bb65467a4a40a88fc2e42f3672220', '2');
INSERT INTO `tb_roles_power` VALUES ('6cc7215721ab4593be8e325ae7458dba', '15458a40fc6a4de098bb8621deaa0864', '1aeba04bda824f54a3fc01d8b1af389a', '1');
INSERT INTO `tb_roles_power` VALUES ('ce0996b066954066b1944f26819af2fc', '784239c65fcb4f1cac028eecda7bbab6', '1aeba04bda824f54a3fc01d8b1af389a', '1');

-- ----------------------------
-- Table structure for `tb_tasks`
-- ----------------------------
DROP TABLE IF EXISTS `tb_tasks`;
CREATE TABLE `tb_tasks` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `community_id` varchar(255) DEFAULT NULL COMMENT '所属社区',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `location` varchar(255) DEFAULT NULL COMMENT '地点',
  `limit_people` int(1) DEFAULT NULL COMMENT '人数上限',
  `integral` int(1) DEFAULT NULL COMMENT '任务积分（每人）',
  `join_people` int(1) DEFAULT NULL COMMENT '报名人数',
  `data_form` int(1) DEFAULT NULL COMMENT '数据来源(1.总后台 2.社区）',
  `create_user` varchar(255) DEFAULT NULL COMMENT '发布者',
  `coverpic` varchar(255) DEFAULT NULL COMMENT '任务的封面图',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '1.正常2.删除',
  PRIMARY KEY (`uuid`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务表';

-- ----------------------------
-- Records of tb_tasks
-- ----------------------------
INSERT INTO `tb_tasks` VALUES ('6240a019e17349d3b7b5730304fdf9e4', '新建的任务', null, '2018-08-01 12:00:00', '2018-08-02 02:00:00', '湖南申', null, null, null, '1', '47c0562c5e744776b61f3489c1e5b1bf', null, null, null, null, '1');
INSERT INTO `tb_tasks` VALUES ('819146d6015e4026bc1e7a7fd52f636d', '任务一', '1', '2018-07-31 21:28:00', '2018-10-18 21:28:09', '1', '1', '1', '1', '1', '1', '1', '1', '2018-07-31 21:28:27', '2018-07-31 21:28:30', '1');

-- ----------------------------
-- Table structure for `tb_users`
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `uuid` varchar(255) NOT NULL,
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `truename` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `head_pic` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `mobile` varchar(11) DEFAULT NULL COMMENT '11位手机号码',
  `sex` int(1) DEFAULT NULL COMMENT '性别： 1男 2女',
  `password` varchar(255) DEFAULT NULL,
  `is_real_name` int(1) DEFAULT NULL COMMENT '是否实名: 1 实名 2非实名',
  `id_card` varchar(18) DEFAULT NULL COMMENT '18   位身份证号码',
  `community_id` varchar(255) DEFAULT NULL COMMENT '所属社区id',
  `total_integral` int(1) DEFAULT NULL COMMENT '总积分（会一直增加）',
  `integral` int(1) DEFAULT NULL COMMENT '现有积分',
  `status` int(1) DEFAULT NULL COMMENT ' 状态 1正常 2.禁用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `mobile` (`mobile`) USING BTREE,
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES ('47c0562c5e744776b61f3489c1e5b1bf', '测试1', '大张伟', null, '15974253641', '1', '202cb962ac59075b964b07152d234b70', '1', '430725199610197119', '1', '20', '20', '1', '2018-07-28 20:48:24', '2018-07-28 20:48:27');
INSERT INTO `tb_users` VALUES ('7fb3f785eedf4a9ebd7c2e9ba47a0634', null, null, null, '18588773304', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, '1', null, null, '1', '2018-07-30 17:17:39', '2018-07-30 17:17:39');

-- ----------------------------
-- Table structure for `tb_users_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_users_role`;
CREATE TABLE `tb_users_role` (
  `uuid` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '是否有效(1  有效 2 无效)',
  PRIMARY KEY (`uuid`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员角色关系表';

-- ----------------------------
-- Records of tb_users_role
-- ----------------------------
INSERT INTO `tb_users_role` VALUES ('1608258d5dc94f3f99b2a494f8726783', '47c0562c5e744776b61f3489c1e5b1bf', '69bb65467a4a40a88fc2e42f3672220', '1');
INSERT INTO `tb_users_role` VALUES ('295d9c837ea94ef8ba318e6164467b09', '7fb3f785eedf4a9ebd7c2e9ba47a0634', '50e41d6abb654f7c97b022757ff1d8e6', '1');
INSERT INTO `tb_users_role` VALUES ('fa65febd02f24f4a8825eb356dc99e3c', '47c0562c5e744776b61f3489c1e5b1bf', '50e41d6abb654f7c97b022757ff1d8e6', '1');
