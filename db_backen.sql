/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-06 23:01:08
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
  `sys_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动表';

-- ----------------------------
-- Records of tb_activitys
-- ----------------------------
INSERT INTO `tb_activitys` VALUES ('c5c3d92d40e54d09bf81ada990858e47', '新建活动', null, '2018-08-01 12:00:00', '2018-08-02 02:00:00', '2018-08-03 00:00:00', '2018-08-04 00:00:00', '湖南申', null, null, null, '1', '47c0562c5e744776b61f3489c1e5b1bf', null, null, '2018-08-02 20:54:34', '2018-08-02 20:54:34', '1', '0ec9448b84e042ab8f983e20b89148c1');

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
  `sys_type` varchar(255) DEFAULT NULL COMMENT '系统标识',
  `leader_name` varchar(20) DEFAULT NULL COMMENT '负责人',
  `leader_mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`uuid`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='社区表';

-- ----------------------------
-- Records of tb_communitys
-- ----------------------------
INSERT INTO `tb_communitys` VALUES ('474cc6c479354f6bbc582b4bbddb93d5', '八方A', null, '24102ea95a394ddb8e1302dc15b48323', '20000', 'asd', '2018-08-06 19:19:11', '2018-08-06 19:19:11', '1', '0ec9448b84e042ab8f983e20b89148c1', null, null);
INSERT INTO `tb_communitys` VALUES ('89b296320c824f52afc2d3b330e572bc', '社区名称', '20', '47c0562c5e744776b61f3489c1e5b1bf', null, '描述', '2018-08-04 12:31:46', '2018-08-04 12:31:46', '1', '0ec9448b84e042ab8f983e20b89148c1', null, null);
INSERT INTO `tb_communitys` VALUES ('8a28d68faee048d0b5955f242f7ee6bb', '八方小区', null, '47c0562c5e744776b61f3489c1e5b1bf', '20000', '暂无', '2018-08-04 20:06:37', '2018-08-04 20:06:37', '1', '0ec9448b84e042ab8f983e20b89148c1', '陈小民', '12345678901');
INSERT INTO `tb_communitys` VALUES ('efd630deba124713bc45082ec6cda0e5', '新建的社区', null, '47c0562c5e744776b61f3489c1e5b1bf', null, null, '2018-08-02 23:11:07', '2018-08-02 23:11:07', '1', '0ec9448b84e042ab8f983e20b89148c1', null, null);

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
  `weight` int(1) DEFAULT NULL COMMENT '权重（1-100）',
  `type` int(1) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='父级菜单表';

-- ----------------------------
-- Records of tb_parent_menus
-- ----------------------------
INSERT INTO `tb_parent_menus` VALUES ('35ee463e182e4d03b1578192e2a65a97', '内容管理', 'content', '2018-08-06 20:23:56', '2018-08-06 20:23:58', '100', '2');
INSERT INTO `tb_parent_menus` VALUES ('4d861014ae9b429bb80709e16771d385', '商品管理', 'shop', '2018-08-06 20:13:27', '2018-08-06 20:13:30', '60', '1');
INSERT INTO `tb_parent_menus` VALUES ('720f8eba80e448e2be9afa14bbc3240d', '社区管理', 'community', '2018-08-06 20:12:45', '2018-08-06 20:12:49', '80', '1');
INSERT INTO `tb_parent_menus` VALUES ('7bebcde2f584408cafca49a36394e7cd', '权限管理', 'permiss', '2018-08-06 20:24:35', '2018-08-06 20:24:38', '60', '2');
INSERT INTO `tb_parent_menus` VALUES ('b0ed1083bfef45ecabe9137332827274', '用户管理', 'user', '2018-08-06 20:14:52', '2018-08-06 20:14:54', '80', '1');
INSERT INTO `tb_parent_menus` VALUES ('cf6ac315faf048f7bb9016726914b8c4', '内容管理', 'content', '2018-07-30 14:24:16', '2018-07-30 14:24:19', '100', '1');
INSERT INTO `tb_parent_menus` VALUES ('e9af029ec3e5461b9c523dc3274c6037', '权限管理', 'permiss', '2018-08-06 20:13:54', '2018-08-06 20:13:58', '40', '1');

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
  `sys_type` varchar(255) DEFAULT NULL,
  `role` int(1) DEFAULT NULL COMMENT '身份标识（1.普通居民 2.志愿者 3.社工）',
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `mobile` (`mobile`) USING BTREE,
  KEY `status` (`status`),
  KEY `identity_flag` (`identity_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_peoples
-- ----------------------------
INSERT INTO `tb_peoples` VALUES ('123', 'zhangsan ', '0', null, '18588772236', '1', null, null, null, null, null, null, '1', null, null, null, null, null);
INSERT INTO `tb_peoples` VALUES ('123213', 'lisi', '1', null, '18588773304', '1', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for `tb_peoples_shop`
-- ----------------------------
DROP TABLE IF EXISTS `tb_peoples_shop`;
CREATE TABLE `tb_peoples_shop` (
  `uuid` varchar(255) NOT NULL,
  `people_id` varchar(255) DEFAULT NULL COMMENT '用户的uuid',
  `shop_id` varchar(255) DEFAULT NULL COMMENT '商品的uuid',
  `count` int(1) DEFAULT NULL COMMENT '数量',
  `status` int(1) DEFAULT NULL COMMENT '是否有效（1有效 2无效）',
  `create_time` datetime DEFAULT NULL COMMENT '创建的时间',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和商品的关系表';

-- ----------------------------
-- Records of tb_peoples_shop
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_powers`
-- ----------------------------
DROP TABLE IF EXISTS `tb_powers`;
CREATE TABLE `tb_powers` (
  `uuid` varchar(255) NOT NULL,
  `code` varchar(20) DEFAULT NULL COMMENT '权限标识',
  `meun_name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `up_menus_id` varchar(255) DEFAULT NULL COMMENT '父级菜单id',
  `front_path` varchar(255) DEFAULT NULL COMMENT '路径',
  `type` int(1) DEFAULT NULL,
  `weight` int(1) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `meun_id` (`meun_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of tb_powers
-- ----------------------------
INSERT INTO `tb_powers` VALUES ('1c5b369b85504e27ab1f49dc1d0bd80f', 'community', '社区管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '720f8eba80e448e2be9afa14bbc3240d', '/home/zhtCommunity/organization', '1', '100');
INSERT INTO `tb_powers` VALUES ('2ec6095845eb4b00b9df3069244d84a8', 'task', '任务管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'cf6ac315faf048f7bb9016726914b8c4', '/home/zhtContern/task', '1', '59');
INSERT INTO `tb_powers` VALUES ('35012730d0934fa2bb57c4107a2230f0', 'task', '任务管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '35ee463e182e4d03b1578192e2a65a97', '/home/sqContern/task', '2', '59');
INSERT INTO `tb_powers` VALUES ('3a7811613b0e4b428b0877cae1f8521b', 'shop', '商品管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '4d861014ae9b429bb80709e16771d385', '/home/zhtGoods/goodsList', '1', '100');
INSERT INTO `tb_powers` VALUES ('5cdc3daca0d5443ebb3578fcd7de8fd9', 'permiss', '管理员', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '7bebcde2f584408cafca49a36394e7cd', '/home/sqPower/powerUser', '2', '100');
INSERT INTO `tb_powers` VALUES ('75a24b38a30b4ee3b452df2b4a0b9145', 'permiss', '权限组', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'e9af029ec3e5461b9c523dc3274c6037', '/home/zhtPower/powerPowerGroup', '1', '99');
INSERT INTO `tb_powers` VALUES ('75d331a9519a468d9a74156be9048038', 'permiss', '管理员', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'e9af029ec3e5461b9c523dc3274c6037', '/home/zhtPower/powerUser', '1', '100');
INSERT INTO `tb_powers` VALUES ('9605275ee5744fddab35a6c9934536cb', 'people', '居民管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '720f8eba80e448e2be9afa14bbc3240d', '/home/zhtCommunity/personnel', '1', '99');
INSERT INTO `tb_powers` VALUES ('a45df126794f44f881999e5d9e6ad2eb', 'activity', '活动管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '35ee463e182e4d03b1578192e2a65a97', '/home/sqContern/activity', '2', '60');
INSERT INTO `tb_powers` VALUES ('b58fc43daa8d4e29b502d476b008334f', 'volunteer', '志愿者管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'b0ed1083bfef45ecabe9137332827274', '/home/sqCommunity/volunteer', '2', '99');
INSERT INTO `tb_powers` VALUES ('c3d436685e1c493fa2554c87a21dec89', 'trash', '垃圾分类', '权限管理所有的权限', '2018-07-29 18:11:00', '2018-07-29 18:11:00', 'cf6ac315faf048f7bb9016726914b8c4', '/home/zhtContern/garbageType', '1', '60');
INSERT INTO `tb_powers` VALUES ('ec4435e28c9c42c7a80c5d6b60175945', 'people', '居民管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'b0ed1083bfef45ecabe9137332827274', '/home/sqCommunity/personnel', '2', '100');
INSERT INTO `tb_powers` VALUES ('f8c2d15acb374a16a03cc881548fbd14', 'activity', '活动管理', '权限管理所有的权限', '2018-07-28 20:53:00', '2018-07-28 20:53:00', 'cf6ac315faf048f7bb9016726914b8c4', '/home/zhtContern/activity', '1', '58');
INSERT INTO `tb_powers` VALUES ('fc84e7c2a400420082b823bfa338a84b', 'permiss', '权限组', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '7bebcde2f584408cafca49a36394e7cd', '/home/sqPower/powerPowerGroup', '2', '99');

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
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`uuid`),
  KEY `status` (`status`),
  KEY `create_user` (`create_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of tb_roles
-- ----------------------------
INSERT INTO `tb_roles` VALUES ('12f716b8e92f405faa6c5399f2d6ff41', 'sdfasdsd', 'dsf', '2018-08-05 01:03:26', '2018-08-05 01:03:26', '2', null);
INSERT INTO `tb_roles` VALUES ('1aeba04bda824f54a3fc01d8b1af389a', '新增的角色', '没事出来玩的', '2018-07-29 01:25:36', '2018-07-29 01:25:36', '1', null);
INSERT INTO `tb_roles` VALUES ('324287d83e4148faaf079f88022c6129', 'fgh', 'fgh', '2018-08-05 00:06:34', '2018-08-05 00:06:34', '2', null);
INSERT INTO `tb_roles` VALUES ('4f48695f96d9417191bd15b04a06b603', '124214', '214', '2018-08-05 00:03:39', '2018-08-05 00:03:39', '2', null);
INSERT INTO `tb_roles` VALUES ('50e41d6abb654f7c97b022757ff1d8e6', '小型管理员', '部分操作', '2018-07-28 20:49:24', '2018-07-28 20:49:27', '1', null);
INSERT INTO `tb_roles` VALUES ('56152332e4d74d60992694fec93870f8', '陈东敏测试数据', '没事出来玩的', '2018-08-06 22:36:59', '2018-08-06 22:36:59', '1', '47c0562c5e744776b61f3489c1e5b1bf');
INSERT INTO `tb_roles` VALUES ('69bb65467a4a40a88fc2e42f3672220', '大型管理员', '绝大部分操作', '2018-07-28 20:51:41', '2018-07-28 20:51:45', '1', null);
INSERT INTO `tb_roles` VALUES ('75166575f87d44baa63d208a6051e75a', 'sdfsdf', 'sdf', '2018-08-05 00:02:03', '2018-08-05 00:02:03', '2', null);
INSERT INTO `tb_roles` VALUES ('7ef50f2d34e9470fb46322769a4570d8', 'sdf', 'sd', '2018-08-05 00:06:12', '2018-08-05 00:06:12', '2', null);
INSERT INTO `tb_roles` VALUES ('8847a92d076f45de9e0f4edfb8fa06cd', 'gf', 'hgf', '2018-08-05 00:06:26', '2018-08-05 00:06:26', '2', null);
INSERT INTO `tb_roles` VALUES ('96d669d2a1074507ab05c5f948801d09', 'fg', 'hgf', '2018-08-05 00:06:39', '2018-08-05 00:06:39', '2', null);
INSERT INTO `tb_roles` VALUES ('adbfe5124bdf49fa85df41f10277302b', 'ddddddd', '', '2018-08-05 13:47:17', '2018-08-05 13:47:17', '1', null);
INSERT INTO `tb_roles` VALUES ('c78d9bfed8034be5ac3e632d42a84da6', 'sdfsd', 'fdsf', '2018-08-05 00:04:02', '2018-08-05 00:04:02', '2', null);
INSERT INTO `tb_roles` VALUES ('cd2349c0d1cd4086a167a2959d59ee5b', 'fgh', 'gf', '2018-08-05 00:06:29', '2018-08-05 00:06:29', '2', null);
INSERT INTO `tb_roles` VALUES ('ded84b03c9294a568ad80d39b51e618b', '213', '124214', '2018-08-04 22:19:52', '2018-08-04 22:19:52', '2', null);
INSERT INTO `tb_roles` VALUES ('e0d2ff73d6174ed8ae6702e1c2ca1caf', '14214214', '214214', '2018-08-05 00:01:27', '2018-08-05 00:01:27', '2', null);
INSERT INTO `tb_roles` VALUES ('e1b05b9e9d124e84a8343d76c7cf4d4e', 'fgh', 'gfh', '2018-08-05 00:06:47', '2018-08-05 00:06:47', '2', null);
INSERT INTO `tb_roles` VALUES ('f69c07c184a245a29f75efc5aea96f3e', 'a\'s', '发顺丰', '2018-08-05 00:58:05', '2018-08-05 00:58:05', '2', null);

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
INSERT INTO `tb_roles_power` VALUES ('02be044d877d4957adc37a0ec8ce2e44', '2ec6095845eb4b00b9df3069244d84a8', '12f716b8e92f405faa6c5399f2d6ff41', '1');
INSERT INTO `tb_roles_power` VALUES ('1b00d632664f44049c7eed171010d8bf', '1e1f78db5e854fcaa8ce9df1db45b267', '69bb65467a4a40a88fc2e42f3672220', '2');
INSERT INTO `tb_roles_power` VALUES ('1c8b458b35ff4318bc1a9ffe3dfae374', '1e1f78db5e854fcaa8ce9df1db45b267', '12f716b8e92f405faa6c5399f2d6ff41', '1');
INSERT INTO `tb_roles_power` VALUES ('21d0792d7ab24b1fbb0afe84ac1331ee', '2ec6095845eb4b00b9df3069244d84a8', '56152332e4d74d60992694fec93870f8', '1');
INSERT INTO `tb_roles_power` VALUES ('2526955dcc744ca5aeb3878dff0c4f92', '75d331a9519a468d9a74156be9048038', '69bb65467a4a40a88fc2e42f3672220', '1');
INSERT INTO `tb_roles_power` VALUES ('2c4f641af6574f059c0de89c14757d88', '3a7811613b0e4b428b0877cae1f8521b', '56152332e4d74d60992694fec93870f8', '1');
INSERT INTO `tb_roles_power` VALUES ('2e7c4d8dd658487eb63281aa4e6953d7', '784239c65fcb4f1cac028eecda7bbab6', 'adbfe5124bdf49fa85df41f10277302b', '1');
INSERT INTO `tb_roles_power` VALUES ('347bedc3bb72468b856816c654a26b84', '15458a40fc6a4de098bb8621deaa0864', '12f716b8e92f405faa6c5399f2d6ff41', '2');
INSERT INTO `tb_roles_power` VALUES ('3c3a9e3ed686412396be02471f7f2236', '2ec6095845eb4b00b9df3069244d84a8', '69bb65467a4a40a88fc2e42f3672220', '1');
INSERT INTO `tb_roles_power` VALUES ('51aa7085e4c84301ad26fa9d3f0641ff', '1e1f78db5e854fcaa8ce9df1db45b267', '69bb65467a4a40a88fc2e42f3672220', '2');
INSERT INTO `tb_roles_power` VALUES ('5a1937a7b2ef495fa6bcc56305323e5e', '75a24b38a30b4ee3b452df2b4a0b9145', '56152332e4d74d60992694fec93870f8', '1');
INSERT INTO `tb_roles_power` VALUES ('5ae1e3f309da4335a07c47916d889b53', '15458a40fc6a4de098bb8621deaa0864', 'adbfe5124bdf49fa85df41f10277302b', '1');
INSERT INTO `tb_roles_power` VALUES ('60578987d2eb4c81a5c9e90289037459', '1e1f78db5e854fcaa8ce9df1db45b267', 'adbfe5124bdf49fa85df41f10277302b', '2');
INSERT INTO `tb_roles_power` VALUES ('6dcd62ba0e15415faba9d4eb538d3158', '784239c65fcb4f1cac028eecda7bbab6', '69bb65467a4a40a88fc2e42f3672220', '1');
INSERT INTO `tb_roles_power` VALUES ('75441ce8d38a47909b6227f9a79f8fd7', 'f8c2d15acb374a16a03cc881548fbd14', '12f716b8e92f405faa6c5399f2d6ff41', '1');
INSERT INTO `tb_roles_power` VALUES ('86ddcf85551c49749f343dd6ec746e88', '15458a40fc6a4de098bb8621deaa0864', '69bb65467a4a40a88fc2e42f3672220', '2');
INSERT INTO `tb_roles_power` VALUES ('87918e9b9ff9423a8bb11b3ef1ba6f4b', '75a24b38a30b4ee3b452df2b4a0b9145', '69bb65467a4a40a88fc2e42f3672220', '1');
INSERT INTO `tb_roles_power` VALUES ('8c4ce2c78a2f4ced8c21b05142824964', '2ec6095845eb4b00b9df3069244d84a8', '1aeba04bda824f54a3fc01d8b1af389a', '1');
INSERT INTO `tb_roles_power` VALUES ('989b1b60eef743908804f076d6fa221e', '1c5b369b85504e27ab1f49dc1d0bd80f', '56152332e4d74d60992694fec93870f8', '1');
INSERT INTO `tb_roles_power` VALUES ('a60d480657da4958a6669c1825e1d642', '1e1f78db5e854fcaa8ce9df1db45b267', '69bb65467a4a40a88fc2e42f3672220', '2');
INSERT INTO `tb_roles_power` VALUES ('b0661f0f18ca4f638997aabe3b7f5034', '75d331a9519a468d9a74156be9048038', '56152332e4d74d60992694fec93870f8', '1');
INSERT INTO `tb_roles_power` VALUES ('b0a14099532641329a419bf67fc0b07e', '5cdc3daca0d5443ebb3578fcd7de8fd9', '69bb65467a4a40a88fc2e42f3672220', '2');
INSERT INTO `tb_roles_power` VALUES ('bfb5ee0f7c9b4074b7c9aa84647c5b59', '784239c65fcb4f1cac028eecda7bbab6', '12f716b8e92f405faa6c5399f2d6ff41', '2');
INSERT INTO `tb_roles_power` VALUES ('c5b11ceb9a2a4f73b93d5dfcc797c716', 'c3d436685e1c493fa2554c87a21dec89', '12f716b8e92f405faa6c5399f2d6ff41', '1');
INSERT INTO `tb_roles_power` VALUES ('cb839211607d4d39801b5626b11fefc6', 'f8c2d15acb374a16a03cc881548fbd14', '1aeba04bda824f54a3fc01d8b1af389a', '1');
INSERT INTO `tb_roles_power` VALUES ('cbd84fb4a6e746b88379df0f6dc91299', '15458a40fc6a4de098bb8621deaa0864', '12f716b8e92f405faa6c5399f2d6ff41', '1');
INSERT INTO `tb_roles_power` VALUES ('d489b02a61704724adfb8044bb039a20', '15458a40fc6a4de098bb8621deaa0864', '69bb65467a4a40a88fc2e42f3672220', '2');
INSERT INTO `tb_roles_power` VALUES ('d6275184cd064787a7b68809be37e4a6', '1c5b369b85504e27ab1f49dc1d0bd80f', '69bb65467a4a40a88fc2e42f3672220', '1');
INSERT INTO `tb_roles_power` VALUES ('de822242b66c4971a8d59af53f9b1303', '3a7811613b0e4b428b0877cae1f8521b', '69bb65467a4a40a88fc2e42f3672220', '1');
INSERT INTO `tb_roles_power` VALUES ('e1ed349294bb4422bb89b647ae905f2c', 'c3d436685e1c493fa2554c87a21dec89', '1aeba04bda824f54a3fc01d8b1af389a', '1');

-- ----------------------------
-- Table structure for `tb_shops`
-- ----------------------------
DROP TABLE IF EXISTS `tb_shops`;
CREATE TABLE `tb_shops` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `description` varchar(2000) DEFAULT NULL COMMENT '商品描述',
  `integral` int(1) DEFAULT NULL COMMENT '兑换单个商品的积分',
  `store` int(1) DEFAULT NULL COMMENT '库存',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人uuid',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建人name',
  `status` int(1) DEFAULT NULL COMMENT '是否有效（1.有效 2.无效）',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of tb_shops
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_sys_type`
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_type`;
CREATE TABLE `tb_sys_type` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '系统名称',
  `status` int(1) DEFAULT NULL COMMENT '是否有效 (1. 有效  2.无效)',
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统类型表';

-- ----------------------------
-- Records of tb_sys_type
-- ----------------------------
INSERT INTO `tb_sys_type` VALUES ('0ec9448b84e042ab8f983e20b89148c1', '测试专用系统', '1', '2018-08-04 12:40:32', '2018-08-04 12:40:17');

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
  `sys_type` varchar(255) DEFAULT NULL COMMENT '所属的系统id',
  `role` varchar(255) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `mobile` (`mobile`) USING BTREE,
  KEY `status` (`status`),
  KEY `sys_type` (`sys_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES ('24102ea95a394ddb8e1302dc15b48323', null, 'admin', null, '18588773333', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, '', null, null, '1', '2018-08-04 20:49:37', '2018-08-04 20:49:37', '0ec9448b84e042ab8f983e20b89148c1', '69bb65467a4a40a88fc2e42f3672220');
INSERT INTO `tb_users` VALUES ('2a2ea0215153442aa52b52d39f0d17fe', '陈东民', '陈东民', null, '17589635587', null, '202cb962ac59075b964b07152d234b70', null, null, '89b296320c824f52afc2d3b330e572bc', null, null, '2', '2018-08-04 12:31:46', '2018-08-04 12:31:46', '0ec9448b84e042ab8f983e20b89148c1', '50e41d6abb654f7c97b022757ff1d8e6');
INSERT INTO `tb_users` VALUES ('47c0562c5e744776b61f3489c1e5b1bf', '测试1', '大张伟1', null, '15974253641', '1', '202cb962ac59075b964b07152d234b70', '1', '430725199610197119', '', '20', '20', '1', '2018-07-28 20:48:24', '2018-07-28 20:48:27', '0ec9448b84e042ab8f983e20b89148c1', '69bb65467a4a40a88fc2e42f3672220');
INSERT INTO `tb_users` VALUES ('6b1697f4581041df9dc8e8d80033ed80', null, 'admin2', null, '18588773331', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, '', null, null, '1', '2018-08-04 21:00:00', '2018-08-04 21:00:00', '0ec9448b84e042ab8f983e20b89148c1', '324287d83e4148faaf079f88022c6129');
INSERT INTO `tb_users` VALUES ('6cb5352918cd4692927b187df3a52289', 'aa', 'aa', null, '12345678911', null, '202cb962ac59075b964b07152d234b70', null, null, '474cc6c479354f6bbc582b4bbddb93d5', null, null, '1', '2018-08-06 19:19:11', '2018-08-06 19:19:11', '0ec9448b84e042ab8f983e20b89148c1', null);
INSERT INTO `tb_users` VALUES ('6e95b1fa8d8b432cb268193564ed30ff', '陈小民', '陈小民', null, '12345678901', null, '202cb962ac59075b964b07152d234b70', null, null, '8a28d68faee048d0b5955f242f7ee6bb', null, null, '2', '2018-08-04 20:06:37', '2018-08-04 20:06:37', '0ec9448b84e042ab8f983e20b89148c1', '69bb65467a4a40a88fc2e42f3672220');
INSERT INTO `tb_users` VALUES ('7fb3f785eedf4a9ebd7c2e9ba47a0634', null, '我自己', null, '18588773304', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, '', null, null, '1', '2018-07-30 17:17:39', '2018-07-30 17:17:39', '0ec9448b84e042ab8f983e20b89148c1', '69bb65467a4a40a88fc2e42f3672220');
INSERT INTO `tb_users` VALUES ('8f207043385a4b5f90eba2086b613988', null, 'test00000001', null, '15974253698', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, '', null, null, '1', '2018-08-04 20:55:02', '2018-08-04 20:55:02', '0ec9448b84e042ab8f983e20b89148c1', '69bb65467a4a40a88fc2e42f3672220');

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
INSERT INTO `tb_users_role` VALUES ('2fa70ed2a3a34f25ab125629251e4890', '24102ea95a394ddb8e1302dc15b48323', '1aeba04bda824f54a3fc01d8b1af389a', '1');
INSERT INTO `tb_users_role` VALUES ('70edab66d1e6427a83b0fecd6cf48737', '8f207043385a4b5f90eba2086b613988', '50e41d6abb654f7c97b022757ff1d8e6', '1');
INSERT INTO `tb_users_role` VALUES ('8db716c4e04a4dc6a04141aa082bbbb7', '6b1697f4581041df9dc8e8d80033ed80', '1aeba04bda824f54a3fc01d8b1af389a', '1');
INSERT INTO `tb_users_role` VALUES ('f3c6e516da9d4827a4c987b970fb3bf6', '7fb3f785eedf4a9ebd7c2e9ba47a0634', '69bb65467a4a40a88fc2e42f3672220', '2');
INSERT INTO `tb_users_role` VALUES ('fa65febd02f24f4a8825eb356dc99e3c', '47c0562c5e744776b61f3489c1e5b1bf', '50e41d6abb654f7c97b022757ff1d8e6', '2');
INSERT INTO `tb_users_role` VALUES ('fedad7127c1e4689b8efc0e87346dad6', '7fb3f785eedf4a9ebd7c2e9ba47a0634', '1aeba04bda824f54a3fc01d8b1af389a', '2');

-- ----------------------------
-- Table structure for `tb_wx_users`
-- ----------------------------
DROP TABLE IF EXISTS `tb_wx_users`;
CREATE TABLE `tb_wx_users` (
  `uuid` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `is_real_name` int(1) DEFAULT NULL COMMENT '是否实名 （1.实名 2.未实名）',
  `open_id` varchar(255) DEFAULT NULL COMMENT '微信用户唯一id',
  `bind_user` varchar(255) DEFAULT NULL COMMENT '绑定的people用户',
  `gender` int(1) DEFAULT NULL COMMENT '性别（1.男 2女）',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  KEY `bind_user` (`bind_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信登录的用户表';

-- ----------------------------
-- Records of tb_wx_users
-- ----------------------------
