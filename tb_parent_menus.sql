/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-07 20:59:57
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `meun_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='父级菜单表';

-- ----------------------------
-- Records of tb_parent_menus
-- ----------------------------
INSERT INTO `tb_parent_menus` VALUES ('35ee463e182e4d03b1578192e2a65a97', '内容管理', 'content', '2018-08-06 20:23:56', '2018-08-06 20:23:58', '100', '2', '内容管理');
INSERT INTO `tb_parent_menus` VALUES ('4d861014ae9b429bb80709e16771d385', '商品管理', 'shop', '2018-08-06 20:13:27', '2018-08-06 20:13:30', '60', '1', '商品管理');
INSERT INTO `tb_parent_menus` VALUES ('720f8eba80e448e2be9afa14bbc3240d', '社区管理', 'community', '2018-08-06 20:12:45', '2018-08-06 20:12:49', '80', '1', '社区管理');
INSERT INTO `tb_parent_menus` VALUES ('7bebcde2f584408cafca49a36394e7cd', '权限管理', 'permiss', '2018-08-06 20:24:35', '2018-08-06 20:24:38', '60', '2', '权限管理');
INSERT INTO `tb_parent_menus` VALUES ('b0ed1083bfef45ecabe9137332827274', '用户管理', 'user', '2018-08-06 20:14:52', '2018-08-06 20:14:54', '80', '1', '用户管理');
INSERT INTO `tb_parent_menus` VALUES ('b585b8f843c14e0d8fd2a41cb5018e39', '邻里圈子', 'circle', '2018-10-07 18:07:21', '2018-10-07 18:07:23', '90', '2', null);
INSERT INTO `tb_parent_menus` VALUES ('cf6ac315faf048f7bb9016726914b8c4', '内容管理', 'content', '2018-07-30 14:24:16', '2018-07-30 14:24:19', '100', '1', '内容管理');
INSERT INTO `tb_parent_menus` VALUES ('e9af029ec3e5461b9c523dc3274c6037', '权限管理', 'permiss', '2018-08-06 20:13:54', '2018-08-06 20:13:58', '40', '1', '权限管理');

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
INSERT INTO `tb_powers` VALUES ('', 'community', '社区管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '720f8eba80e448e2be9afa14bbc3240d', '/home/zhtCommunity/organization', '1', '100');
INSERT INTO `tb_powers` VALUES ('033ecad1ce284bd8ad2f12d316fdc790', 'notices', '公告管理', '描述', '2018-10-07 17:42:37', '2018-10-07 17:42:37', '35ee463e182e4d03b1578192e2a65a97', '/home/sqContern/notice', '2', '100');
INSERT INTO `tb_powers` VALUES ('2ec6095845eb4b00b9df3069244d84a8', 'task', '任务管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'cf6ac315faf048f7bb9016726914b8c4', '/home/zhtContern/task', '1', '59');
INSERT INTO `tb_powers` VALUES ('35012730d0934fa2bb57c4107a2230f0', 'task', '任务管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '35ee463e182e4d03b1578192e2a65a97', '/home/sqContern/task', '2', '59');
INSERT INTO `tb_powers` VALUES ('3a7811613b0e4b428b0877cae1f8521b', 'shop', '商品管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '4d861014ae9b429bb80709e16771d385', '/home/zhtGoods/goodsList', '1', '100');
INSERT INTO `tb_powers` VALUES ('3f73c91dad984436b8c3fabdf3d0b2ae', 'circlePost', '圈子公告', null, '2018-10-07 18:10:27', '2018-10-07 18:10:30', 'b585b8f843c14e0d8fd2a41cb5018e39', '/home/sqCircle/circleNotice', '2', '89');
INSERT INTO `tb_powers` VALUES ('5cdc3daca0d5443ebb3578fcd7de8fd9', 'permiss', '管理员', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '7bebcde2f584408cafca49a36394e7cd', '/home/sqPower/powerUser', '2', '100');
INSERT INTO `tb_powers` VALUES ('62905b09be194465bd5afff2dc2e1feb', 'classification', '分类管理', '分类', '2018-10-07 18:03:02', '2018-10-07 18:03:02', '35ee463e182e4d03b1578192e2a65a97', '/classify', '2', '90');
INSERT INTO `tb_powers` VALUES ('6801cdfc59bf43b4b87081c43c9773dd', 'post', '帖子管理', null, '2018-10-07 18:09:11', '2018-10-07 18:09:14', 'b585b8f843c14e0d8fd2a41cb5018e39', '/postManage', '2', '99');
INSERT INTO `tb_powers` VALUES ('75a24b38a30b4ee3b452df2b4a0b9145', 'permiss', '权限组', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'e9af029ec3e5461b9c523dc3274c6037', '/home/zhtPower/powerPowerGroup', '1', '99');
INSERT INTO `tb_powers` VALUES ('75d331a9519a468d9a74156be9048038', 'permiss', '管理员', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'e9af029ec3e5461b9c523dc3274c6037', '/home/zhtPower/powerUser', '1', '100');
INSERT INTO `tb_powers` VALUES ('775f65f918fc4277a5821f86c24b203f', 'articles', '文章管理', '文章', '2018-10-07 18:00:46', '2018-10-07 18:00:46', '35ee463e182e4d03b1578192e2a65a97', '/article', '2', '100');
INSERT INTO `tb_powers` VALUES ('9605275ee5744fddab35a6c9934536cb', 'people', '居民管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '720f8eba80e448e2be9afa14bbc3240d', '/home/zhtCommunity/personnel', '1', '99');
INSERT INTO `tb_powers` VALUES ('9725991cc39a4916a37dc61548b92752', 'merchant', '商家管理', null, '2018-10-07 18:12:01', '2018-10-07 18:12:04', 'b585b8f843c14e0d8fd2a41cb5018e39', '/shangjia', '2', '87');
INSERT INTO `tb_powers` VALUES ('97e06a3c405f45f3a9c816f006c39eb0', 'comment', '评论管理', null, '2018-10-07 18:11:15', '2018-10-07 18:11:18', 'b585b8f843c14e0d8fd2a41cb5018e39', '/home/sqCircle/circleComment', '2', '88');
INSERT INTO `tb_powers` VALUES ('a45df126794f44f881999e5d9e6ad2eb', 'activity', '活动管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '35ee463e182e4d03b1578192e2a65a97', '/home/sqContern/activity', '2', '60');
INSERT INTO `tb_powers` VALUES ('b58fc43daa8d4e29b502d476b008334f', 'volunteer', '志愿者管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'b0ed1083bfef45ecabe9137332827274', '/home/sqCommunity/volunteer', '1', '99');
INSERT INTO `tb_powers` VALUES ('b61d5793b4774e7d8d47dc4a5d8b1c33', 'notice', '公告管理', '公告管理', '2018-09-18 21:51:04', '2018-09-18 21:51:07', '35ee463e182e4d03b1578192e2a65a97', '/home/zhtContern/notice', '1', '100');
INSERT INTO `tb_powers` VALUES ('c3d436685e1c493fa2554c87a21dec89', 'garbage', '垃圾分类', '权限管理所有的权限', '2018-07-29 18:11:00', '2018-07-29 18:11:00', 'cf6ac315faf048f7bb9016726914b8c4', '/home/zhtContern/garbageType', '1', '60');
INSERT INTO `tb_powers` VALUES ('ddfff053a8d04e479effa1ab26e8592b', 'circle', '圈子管理', null, '2018-10-07 18:08:30', '2018-10-07 18:08:32', 'b585b8f843c14e0d8fd2a41cb5018e39', '/home/sqCircle/circleManage', '2', '100');
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
INSERT INTO `tb_roles` VALUES ('1d519affd43d4f12aabd6645796d218c', '系统管理员', '系统管理员', '2018-08-07 22:35:06', '2018-08-07 22:35:06', '1', '24102ea95a394ddb8e1302dc15b48323');
INSERT INTO `tb_roles` VALUES ('2181d904dd52458a9e9517ede8d625b6', '系统权限', '全部', '2018-08-07 23:32:15', '2018-08-07 23:32:15', '1', '487ab12439814069b85b176056631c43');
INSERT INTO `tb_roles` VALUES ('30f8d2eb12514bd4aaf847d2ebe1594d', '社区的最高权限管理', '社区的最高权限管理，请勿删除', '2018-08-07 22:50:10', '2018-08-07 22:50:10', '1', 'a620d2624bf74c389be1b65ac4f27f13');
INSERT INTO `tb_roles` VALUES ('9393b172278e449585d192ff72a02f88', '总后台最高系统权限', '最高权限，请勿删除！', '2018-08-07 22:26:05', '2018-08-07 22:26:05', '1', '24102ea95a394ddb8e1302dc15b48323');
INSERT INTO `tb_roles` VALUES ('a2ba32b8c57f45f5adcd6cb11ba34857', 'chendm', 'chendm的', '2018-10-07 17:57:46', '2018-10-07 17:57:46', '1', '683afa2504dc48f7b1d4c3a9fad242ef');

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
INSERT INTO `tb_roles_power` VALUES ('032a7b1a8fa24dac93281ba48c4f40d6', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('0696a3d702ab4fb1b770d6f0fb68c6f7', '1c5b369b85504e27ab1f49dc1d0bd80f', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('0696a3d702ab4fb1b770d6f0fb68c6f74', 'b61d5793b4774e7d8d47dc4a5d8b1c33', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('0710bf9674d943deb35355cd08f669df', '62905b09be194465bd5afff2dc2e1feb', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('080ad8b8452c4253be9b19798d27c70', 'a45df126794f44f881999e5d9e6ad2eb', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('080ad8b8452c4253be9b19798d27c70f', '75d331a9519a468d9a74156be9048038', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('10fa903da55e4da98fd9d45f1925168b', '35012730d0934fa2bb57c4107a2230f0', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('180a994d72f148459109e3419d34503b', 'f8c2d15acb374a16a03cc881548fbd14', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('18785cd126db423b8f27a4849b7e4865', 'ec4435e28c9c42c7a80c5d6b60175945', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('1b74a67a44754f16b0ffe4299ff5bf41', '2ec6095845eb4b00b9df3069244d84a8', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('2364fbe5475b4da1ba29130303b44ac3', 'fc84e7c2a400420082b823bfa338a84b', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('25c768bacf1c494e97c67bf9b4f1cdf4', '35012730d0934fa2bb57c4107a2230f0', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('2f5bdfc3be874e84b98b988c5ddbe89d', 'e9af029ec3e5461b9c523dc3274c6037', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('306c3ac08f5f42bea1df2cd0b9ec9a13', 'a45df126794f44f881999e5d9e6ad2eb', '2181d904dd52458a9e9517ede8d625b6', '1');
INSERT INTO `tb_roles_power` VALUES ('367f60267c5c40388cefb0d3ddc5c8d8', '75a24b38a30b4ee3b452df2b4a0b9145', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('3b969247bb404b95aa9a9edc7e4f4bba', 'b58fc43daa8d4e29b502d476b008334f', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('423d7c7f09054f38beb01087ef7bec6b', 'b0ed1083bfef45ecabe9137332827274', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('42d3c8a9dba24d9797507a684a1bfa31', '1c5b369b85504e27ab1f49dc1d0bd80f', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('441822d301d848938eb45df13769c5d7', '3a7811613b0e4b428b0877cae1f8521b', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('4999e396a8014d76bd6dd73745ae9ae2', 'c3d436685e1c493fa2554c87a21dec89', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('4ba400fda26c4633907b996193bc2c87', '720f8eba80e448e2be9afa14bbc3240d', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('537b28b94e594cf5994a24d3ff19c1ef', '97e06a3c405f45f3a9c816f006c39eb0', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('61f25a131c334f519ae15019e330a18c', '9605275ee5744fddab35a6c9934536cb', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('66928b7830ba4b11ad95ef0f3d261599', '4d861014ae9b429bb80709e16771d385', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('72a8361a8c0b4ede97362cf0aa9708a3', '75d331a9519a468d9a74156be9048038', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('74a4730929eb4e2483cb8de0aff47cfb', '35ee463e182e4d03b1578192e2a65a97', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('7b4f8303656f405aada5bf0007526095', '033ecad1ce284bd8ad2f12d316fdc790', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('7fe479a848924f568e1314cdf61ea6ab', 'cf6ac315faf048f7bb9016726914b8c4', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('80036bc9f0c440bd8fc5d14da032b758', 'fc84e7c2a400420082b823bfa338a84b', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('816bdfd71cbd469b99b6fbe435b6c1c1', '3a7811613b0e4b428b0877cae1f8521b', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('818e405b1e8f47bcbfcf8635248f722d', 'a45df126794f44f881999e5d9e6ad2eb', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('832aaa62c0754ba687c5c0d96a60c25c', '75a24b38a30b4ee3b452df2b4a0b9145', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('88f70eeb3bb54d589a15ee1438fbfb46', '775f65f918fc4277a5821f86c24b203f', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('912ff916a8a94082aba563ab3ba1118c', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('921d4fb92b264da6b2b1f48345fe062e', '3f73c91dad984436b8c3fabdf3d0b2ae', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('9aa3ae501a4447cab4d6998e54fb3fe5', '35012730d0934fa2bb57c4107a2230f0', '2181d904dd52458a9e9517ede8d625b6', '1');
INSERT INTO `tb_roles_power` VALUES ('9dfb5049ae1b4136b11541d083a8188a', 'ec4435e28c9c42c7a80c5d6b60175945', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('aca57271b604430fb00b042cfe2d74f8', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('b214a41b8bf543459cb5ab1ef69a2c2b', '2ec6095845eb4b00b9df3069244d84a8', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('b32dbf2b18c84a5bb124c113ddab6b4e', '4d861014ae9b429bb80709e16771d385', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('b76d8b3c5b4a4f4681e0a1eab0495e6d', 'b0ed1083bfef45ecabe9137332827274', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('be629836c6af47088c17a5afa5f846eb', '35ee463e182e4d03b1578192e2a65a97', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('c26323f1730f40a191b954c3694ab707', '5cdc3daca0d5443ebb3578fcd7de8fd9', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('ca457570a36146a2a43752ef25503295', '9605275ee5744fddab35a6c9934536cb', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('ce1653bfbc8f45c08b94b087db298440', 'f8c2d15acb374a16a03cc881548fbd14', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('cfbd8741dae54bc897e9c0d49b870700', '5cdc3daca0d5443ebb3578fcd7de8fd9', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('d60270ef37e0413ba08660de43240524', 'cf6ac315faf048f7bb9016726914b8c4', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('d65101b7f9f24d4b9ee2147b93ac8138', 'c3d436685e1c493fa2554c87a21dec89', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('dd58ae7eae004544ac8de4bca987d0c2', 'b58fc43daa8d4e29b502d476b008334f', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('eb36775eabfe4ca3b5c1b36b74a476fd', 'ddfff053a8d04e479effa1ab26e8592b', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('f959bf008bc7468bb49250c78f1947ff', '9725991cc39a4916a37dc61548b92752', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('fecbe599ad8a42a0afc587ca4777f6d4', '6801cdfc59bf43b4b87081c43c9773dd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');

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
INSERT INTO `tb_users` VALUES ('24102ea95a394ddb8e1302dc15b48323', 'admin', 'admin', null, '18588773304', '1', 'e10adc3949ba59abbe56e057f20f883e', null, null, '', null, null, '1', '2018-08-04 20:49:37', '2018-08-04 20:49:37', '0ec9448b84e042ab8f983e20b89148c1', '9393b172278e449585d192ff72a02f88');
INSERT INTO `tb_users` VALUES ('33ecb4fdde1e4bf78d33b0aedce5efb0', null, '八方Atest人员', null, '18588771111', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, '47e3a4ddc7b24609b995da160a815eb2', null, null, '1', '2018-08-07 23:36:17', '2018-08-07 23:36:17', '0ec9448b84e042ab8f983e20b89148c1', '2181d904dd52458a9e9517ede8d625b6');
INSERT INTO `tb_users` VALUES ('683afa2504dc48f7b1d4c3a9fad242ef', 'aaaa', 'aaaa', null, '18588773301', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, '47e3a4ddc7b24609b995da160a815eb2', null, null, '1', '2018-08-07 23:31:28', '2018-08-07 23:31:28', '0ec9448b84e042ab8f983e20b89148c1', '30f8d2eb12514bd4aaf847d2ebe1594d');
INSERT INTO `tb_users` VALUES ('810dd5476bde4c7eb62ddda7b5830677', null, '陈东民', null, '15974253641', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, '47e3a4ddc7b24609b995da160a815eb2', null, null, '1', '2018-08-07 22:35:37', '2018-08-07 22:35:37', '0ec9448b84e042ab8f983e20b89148c1', 'a2ba32b8c57f45f5adcd6cb11ba34857');
INSERT INTO `tb_users` VALUES ('cbba404ad93a44d8a8c99803f2116cd2', 'bbbb', 'bbbb', null, '18588773302', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, 'c5df0f89e8bf4936a916d11075741557', null, null, '1', '2018-08-07 23:32:58', '2018-08-07 23:32:58', '0ec9448b84e042ab8f983e20b89148c1', '30f8d2eb12514bd4aaf847d2ebe1594d');
