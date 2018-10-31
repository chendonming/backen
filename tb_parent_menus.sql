/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-14 21:32:46
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
INSERT INTO `tb_parent_menus` VALUES ('281441f88d8343fb95311013cf78e37f', '网格化管理', 'articles', '2018-10-13 16:58:48', '2018-10-13 16:58:48', '12', '2', '网格化管理');
INSERT INTO `tb_parent_menus` VALUES ('35ee463e182e4d03b1578192e2a65a97', '内容管理', 'content', '2018-08-06 20:23:56', '2018-08-06 20:23:58', '100', '2', '内容管理');
INSERT INTO `tb_parent_menus` VALUES ('4d861014ae9b429bb80709e16771d385', '商品管理', 'shop', '2018-08-06 20:13:27', '2018-08-06 20:13:30', '60', '1', '商品管理');
INSERT INTO `tb_parent_menus` VALUES ('51cb67630bda47d39ca2c6b435e13829', '商家管理', '', '2018-10-13 09:05:35', '2018-10-13 09:05:35', '90', '2', '商家管理');
INSERT INTO `tb_parent_menus` VALUES ('5e07d62df08b40ff85d345f5fa411e0b', '党建', '', '2018-10-13 17:11:03', '2018-10-13 17:11:03', null, '2', '党建');
INSERT INTO `tb_parent_menus` VALUES ('720f8eba80e448e2be9afa14bbc3240d', '社区管理', 'community', '2018-08-06 20:12:45', '2018-08-06 20:12:49', '80', '1', '社区管理');
INSERT INTO `tb_parent_menus` VALUES ('7bebcde2f584408cafca49a36394e7cd', '权限管理', 'permiss', '2018-08-06 20:24:35', '2018-08-06 20:24:38', '60', '2', '权限管理');
INSERT INTO `tb_parent_menus` VALUES ('b0ed1083bfef45ecabe9137332827274', '用户管理', 'user', '2018-08-06 20:14:52', '2018-08-06 20:14:54', '80', '1', '用户管理');
INSERT INTO `tb_parent_menus` VALUES ('b585b8f843c14e0d8fd2a41cb5018e39', '邻里圈子', 'circle', '2018-10-07 18:07:21', '2018-10-07 18:07:23', '90', '2', '邻里圈子');
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
INSERT INTO `tb_powers` VALUES ('2fd2210aab50497eb9ae2e3eb15a8b60', 'permiss', '菜单管理', 'miao1', '2018-10-12 20:40:23', '2018-10-12 20:40:23', '7bebcde2f584408cafca49a36394e7cd', '/meun', '2', '64');
INSERT INTO `tb_powers` VALUES ('35012730d0934fa2bb57c4107a2230f0', 'task', '任务管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '35ee463e182e4d03b1578192e2a65a97', '/home/sqContern/task', '2', '59');
INSERT INTO `tb_powers` VALUES ('3a7811613b0e4b428b0877cae1f8521b', 'shop', '商品管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '4d861014ae9b429bb80709e16771d385', '/home/zhtGoods/goodsList', '1', '100');
INSERT INTO `tb_powers` VALUES ('3f73c91dad984436b8c3fabdf3d0b2ae', 'circlePost', '圈子公告', null, '2018-10-07 18:10:27', '2018-10-07 18:10:30', 'b585b8f843c14e0d8fd2a41cb5018e39', '/home/sqCircle/circleNotice', '2', '89');
INSERT INTO `tb_powers` VALUES ('5cdc3daca0d5443ebb3578fcd7de8fd9', 'permiss', '管理员', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '7bebcde2f584408cafca49a36394e7cd', '/home/sqPower/powerUser', '2', '100');
INSERT INTO `tb_powers` VALUES ('62905b09be194465bd5afff2dc2e1feb', 'classification', '分类管理', '分类', '2018-10-07 18:03:02', '2018-10-07 18:03:02', '35ee463e182e4d03b1578192e2a65a97', '/classify', '2', '90');
INSERT INTO `tb_powers` VALUES ('63f93b0fabe84a6589a190625f38adf4', 'merchant', '商家管理', 'shangjia', '2018-10-13 16:44:19', '2018-10-13 16:44:19', '51cb67630bda47d39ca2c6b435e13829', '/shangjia', '2', '100');
INSERT INTO `tb_powers` VALUES ('6801cdfc59bf43b4b87081c43c9773dd', 'post', '帖子管理', null, '2018-10-07 18:09:11', '2018-10-07 18:09:14', 'b585b8f843c14e0d8fd2a41cb5018e39', '/postManage', '2', '99');
INSERT INTO `tb_powers` VALUES ('75a24b38a30b4ee3b452df2b4a0b9145', 'permiss', '权限组', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'e9af029ec3e5461b9c523dc3274c6037', '/home/zhtPower/powerPowerGroup', '1', '99');
INSERT INTO `tb_powers` VALUES ('75d331a9519a468d9a74156be9048038', 'permiss', '管理员', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'e9af029ec3e5461b9c523dc3274c6037', '/home/zhtPower/powerUser', '1', '100');
INSERT INTO `tb_powers` VALUES ('775f65f918fc4277a5821f86c24b203f', 'articles', '文章管理', '文章', '2018-10-07 18:00:46', '2018-10-07 18:00:46', '35ee463e182e4d03b1578192e2a65a97', '/article', '2', '100');
INSERT INTO `tb_powers` VALUES ('7a6765f5a1ef4d258260724298d6a73c', 'coupon', '优惠券', '优惠券', '2018-10-13 09:54:22', '2018-10-13 09:54:22', '51cb67630bda47d39ca2c6b435e13829', '/coupon', '2', '89');
INSERT INTO `tb_powers` VALUES ('933e1f63db0f4445ae37c22509d923ac', 'complaint', '建议投诉', null, '2018-10-08 19:58:43', '2018-10-08 19:58:45', '35ee463e182e4d03b1578192e2a65a97', '/home/sqComplaint/complaintManage', '2', '100');
INSERT INTO `tb_powers` VALUES ('9605275ee5744fddab35a6c9934536cb', 'people', '居民管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '720f8eba80e448e2be9afa14bbc3240d', '/home/zhtCommunity/personnel', '1', '99');
INSERT INTO `tb_powers` VALUES ('97e06a3c405f45f3a9c816f006c39eb0', 'comment', '评论管理', null, '2018-10-07 18:11:15', '2018-10-07 18:11:18', 'b585b8f843c14e0d8fd2a41cb5018e39', '/home/sqCircle/circleComment', '2', '88');
INSERT INTO `tb_powers` VALUES ('9dcca2d3e6f747c09f00da4143e616d1', 'classification', '分类管理', 'frnlei1', '2018-10-14 19:20:12', '2018-10-14 19:20:12', '5e07d62df08b40ff85d345f5fa411e0b', '/dangjian/class', '2', '12');
INSERT INTO `tb_powers` VALUES ('a45df126794f44f881999e5d9e6ad2eb', 'activity', '活动管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '35ee463e182e4d03b1578192e2a65a97', '/home/sqContern/activity', '2', '60');
INSERT INTO `tb_powers` VALUES ('b35826c487894d91ac7ae54ced353115', 'articles', '党建文章', '121', '2018-10-13 17:12:22', '2018-10-13 17:12:22', '5e07d62df08b40ff85d345f5fa411e0b', '/dangjian', '2', '90');
INSERT INTO `tb_powers` VALUES ('b58fc43daa8d4e29b502d476b008334f', 'volunteer', '志愿者管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'b0ed1083bfef45ecabe9137332827274', '/home/sqCommunity/volunteer', '1', '99');
INSERT INTO `tb_powers` VALUES ('b61d5793b4774e7d8d47dc4a5d8b1c33', 'notice', '公告管理', '公告管理', '2018-09-18 21:51:04', '2018-09-18 21:51:07', '35ee463e182e4d03b1578192e2a65a97', '/home/zhtContern/notice', '1', '100');
INSERT INTO `tb_powers` VALUES ('c0978bc8b19a499fb1c20428f95921a5', 'classification', '分类管理', '', '2018-10-14 19:20:44', '2018-10-14 19:20:44', '281441f88d8343fb95311013cf78e37f', '/grid/class', '2', '12');
INSERT INTO `tb_powers` VALUES ('c3d436685e1c493fa2554c87a21dec89', 'garbage', '垃圾分类', '权限管理所有的权限', '2018-07-29 18:11:00', '2018-07-29 18:11:00', 'cf6ac315faf048f7bb9016726914b8c4', '/home/zhtContern/garbageType', '1', '60');
INSERT INTO `tb_powers` VALUES ('ddfff053a8d04e479effa1ab26e8592b', 'circle', '圈子管理', null, '2018-10-07 18:08:30', '2018-10-07 18:08:32', 'b585b8f843c14e0d8fd2a41cb5018e39', '/home/sqCircle/circleManage', '2', '100');
INSERT INTO `tb_powers` VALUES ('e31f5afe751448b0bf924d88ba1fb260', 'articles', '网格化管理', 'ssss', '2018-10-13 17:00:49', '2018-10-13 17:00:49', '281441f88d8343fb95311013cf78e37f', '/grid', '2', '80');
INSERT INTO `tb_powers` VALUES ('ec4435e28c9c42c7a80c5d6b60175945', 'people', '居民管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'b0ed1083bfef45ecabe9137332827274', '/home/sqCommunity/personnel', '2', '100');
INSERT INTO `tb_powers` VALUES ('f8c2d15acb374a16a03cc881548fbd14', 'activity', '活动管理', '权限管理所有的权限', '2018-07-28 20:53:00', '2018-07-28 20:53:00', 'cf6ac315faf048f7bb9016726914b8c4', '/home/zhtContern/activity', '1', '58');
INSERT INTO `tb_powers` VALUES ('fc84e7c2a400420082b823bfa338a84b', 'permiss', '权限组', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', '7bebcde2f584408cafca49a36394e7cd', '/home/sqPower/powerPowerGroup', '2', '99');

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
INSERT INTO `tb_roles_power` VALUES ('08173ffcd91e414d9dba454ae3c6e9a8', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('10fa903da55e4da98fd9d45f1925168b', '35012730d0934fa2bb57c4107a2230f0', 'a2ba32b8c57f45f5adcd6cb11ba34857', '2');
INSERT INTO `tb_roles_power` VALUES ('180a994d72f148459109e3419d34503b', 'f8c2d15acb374a16a03cc881548fbd14', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('180f16e4dac04ff188e7d6df41b09a99', '51cb67630bda47d39ca2c6b435e13829', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('18785cd126db423b8f27a4849b7e4865', 'ec4435e28c9c42c7a80c5d6b60175945', 'a2ba32b8c57f45f5adcd6cb11ba34857', '2');
INSERT INTO `tb_roles_power` VALUES ('1b74a67a44754f16b0ffe4299ff5bf41', '2ec6095845eb4b00b9df3069244d84a8', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('2364fbe5475b4da1ba29130303b44ac3', 'fc84e7c2a400420082b823bfa338a84b', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('2377e4999e3c4bb9bd4cec1b894084e3', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('238592746d5c4ac3a63aae0c98512407', 'b0ed1083bfef45ecabe9137332827274', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('25c768bacf1c494e97c67bf9b4f1cdf4', '35012730d0934fa2bb57c4107a2230f0', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('284e1ad0a5104fcb9f99bd6912bb0f89', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('2bf1b46d883343f2928c4ce90de45ee1', '7a6765f5a1ef4d258260724298d6a73c', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('2c79edcce8ab42ad837d031c6c382da8', '2fd2210aab50497eb9ae2e3eb15a8b60', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('2f5bdfc3be874e84b98b988c5ddbe89d', 'e9af029ec3e5461b9c523dc3274c6037', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('306c3ac08f5f42bea1df2cd0b9ec9a13', 'a45df126794f44f881999e5d9e6ad2eb', '2181d904dd52458a9e9517ede8d625b6', '1');
INSERT INTO `tb_roles_power` VALUES ('32249bfff8db4976ab8a9f0e3aa67b0d', '51cb67630bda47d39ca2c6b435e13829', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('367f60267c5c40388cefb0d3ddc5c8d8', '75a24b38a30b4ee3b452df2b4a0b9145', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('3746150ec6df45269b3cad5259d71f3f', '9dcca2d3e6f747c09f00da4143e616d1', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('37987ae1e7ab4b94b7f815ae38136213', 'c0978bc8b19a499fb1c20428f95921a5', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('3b969247bb404b95aa9a9edc7e4f4bba', 'b58fc43daa8d4e29b502d476b008334f', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('3fe21718b6cb418bb601c98cb0cb3e2e', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('3fe5fbf1e5554887870c99a708d51e63', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('3ff5f2090c524240b85914565d1f767e', '281441f88d8343fb95311013cf78e37f', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('42181ea4da5e42848b7b47bd58ff9ffe', 'b0ed1083bfef45ecabe9137332827274', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('423d7c7f09054f38beb01087ef7bec6b', 'b0ed1083bfef45ecabe9137332827274', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('42d3c8a9dba24d9797507a684a1bfa31', '1c5b369b85504e27ab1f49dc1d0bd80f', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('433fcc6832b2438db3b870d2009abf15', '51cb67630bda47d39ca2c6b435e13829', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('441822d301d848938eb45df13769c5d7', '3a7811613b0e4b428b0877cae1f8521b', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('49470b6f9ec6482bad0203dfc27d40ac', 'e31f5afe751448b0bf924d88ba1fb260', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('4988686bc197461c8132ff76c332faa8', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('4999e396a8014d76bd6dd73745ae9ae2', 'c3d436685e1c493fa2554c87a21dec89', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('4a8f05e3f71247e2ac52d6cf087928aa', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('4ae38ea4dfd6488c84eda5ae20acd7d9', '51cb67630bda47d39ca2c6b435e13829', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('4ba400fda26c4633907b996193bc2c87', '720f8eba80e448e2be9afa14bbc3240d', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('537b28b94e594cf5994a24d3ff19c1ef', '97e06a3c405f45f3a9c816f006c39eb0', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('59138405b66d4c98bb63dc744a43d0ab', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('5d4d980851e349868f03b0c703d77d42', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('600322e1de844c8caececebf835b2222', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('610dc3a9d0464f16a9df39e62d844b11', '51cb67630bda47d39ca2c6b435e13829', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('61ba6d19b993480a8889b3dd0711f20d', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('61f25a131c334f519ae15019e330a18c', '9605275ee5744fddab35a6c9934536cb', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('66928b7830ba4b11ad95ef0f3d261599', '4d861014ae9b429bb80709e16771d385', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('6842576283724e818f70779235bf1e55', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('71e5b6a322d34a83b153d98f877e6a84', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('72a8361a8c0b4ede97362cf0aa9708a3', '75d331a9519a468d9a74156be9048038', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('74a4730929eb4e2483cb8de0aff47cfb', '35ee463e182e4d03b1578192e2a65a97', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('7705cdaab3a1409780d97e861b1a1567', '63f93b0fabe84a6589a190625f38adf4', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('7b4f8303656f405aada5bf0007526095', '033ecad1ce284bd8ad2f12d316fdc790', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('7fe479a848924f568e1314cdf61ea6ab', 'cf6ac315faf048f7bb9016726914b8c4', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('80036bc9f0c440bd8fc5d14da032b758', 'fc84e7c2a400420082b823bfa338a84b', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('816bdfd71cbd469b99b6fbe435b6c1c1', '3a7811613b0e4b428b0877cae1f8521b', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('818e405b1e8f47bcbfcf8635248f722d', 'a45df126794f44f881999e5d9e6ad2eb', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('832aaa62c0754ba687c5c0d96a60c25c', '75a24b38a30b4ee3b452df2b4a0b9145', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('88f70eeb3bb54d589a15ee1438fbfb46', '775f65f918fc4277a5821f86c24b203f', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('8ed747c064354a8c80e15db95d270dbe', '35ee463e182e4d03b1578192e2a65a97', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('906b64f192bc455186b0e7ae8fb21655', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('912ff916a8a94082aba563ab3ba1118c', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('921d4fb92b264da6b2b1f48345fe062e', '3f73c91dad984436b8c3fabdf3d0b2ae', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('9352772cd0aa46e6810c2ef81af6282e', '281441f88d8343fb95311013cf78e37f', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('985c2c3867704b279746b5ad0912d64b', '51cb67630bda47d39ca2c6b435e13829', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('9aa3ae501a4447cab4d6998e54fb3fe5', '35012730d0934fa2bb57c4107a2230f0', '2181d904dd52458a9e9517ede8d625b6', '1');
INSERT INTO `tb_roles_power` VALUES ('9ad217062bd94325b83d8e9f2ebf3fe2', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('9dfb5049ae1b4136b11541d083a8188a', 'ec4435e28c9c42c7a80c5d6b60175945', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('a9f96e77acd8457eb1d1312481f33c10', '281441f88d8343fb95311013cf78e37f', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('aca57271b604430fb00b042cfe2d74f8', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('adb1d8e85221492689fffde51abc99d8', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('b214a41b8bf543459cb5ab1ef69a2c2b', '2ec6095845eb4b00b9df3069244d84a8', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('b32dbf2b18c84a5bb124c113ddab6b4e', '4d861014ae9b429bb80709e16771d385', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('b76d8b3c5b4a4f4681e0a1eab0495e6d', 'b0ed1083bfef45ecabe9137332827274', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('be629836c6af47088c17a5afa5f846eb', '35ee463e182e4d03b1578192e2a65a97', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('c0dde85bbfff475083ea8c68f211dd04', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('c0f85134ea804a2a9e9aa4405f030296', '51cb67630bda47d39ca2c6b435e13829', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('c26323f1730f40a191b954c3694ab707', '5cdc3daca0d5443ebb3578fcd7de8fd9', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('c69c0d92b2e34153935a50f40ec8d1e1', '933e1f63db0f4445ae37c22509d923ac', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('ca457570a36146a2a43752ef25503295', '9605275ee5744fddab35a6c9934536cb', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('ce1653bfbc8f45c08b94b087db298440', 'f8c2d15acb374a16a03cc881548fbd14', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('cfbd8741dae54bc897e9c0d49b870700', '5cdc3daca0d5443ebb3578fcd7de8fd9', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('d3e9856392c04fc1848610684b824c35', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('d60270ef37e0413ba08660de43240524', 'cf6ac315faf048f7bb9016726914b8c4', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('d65101b7f9f24d4b9ee2147b93ac8138', 'c3d436685e1c493fa2554c87a21dec89', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('d75e3539861044a3874f8c32c2106c8a', 'b35826c487894d91ac7ae54ced353115', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('d7de4e747aea4c188dc698b1ab573f0e', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('d7ecd7221fe04a9c94c78c7c952bffc8', 'b0ed1083bfef45ecabe9137332827274', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('dd58ae7eae004544ac8de4bca987d0c2', 'b58fc43daa8d4e29b502d476b008334f', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('e034357ea5694e5180fb2a1da2cb6423', '51cb67630bda47d39ca2c6b435e13829', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('e2bd5cfd2c634859863216a3c07ecfdf', '5e07d62df08b40ff85d345f5fa411e0b', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('e7c1b859f6ce4bbf894fff1f3c7ab879', 'b585b8f843c14e0d8fd2a41cb5018e39', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('e980c3d9432b42abb271f3eaa230c1ca', '5e07d62df08b40ff85d345f5fa411e0b', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('eb36775eabfe4ca3b5c1b36b74a476fd', 'ddfff053a8d04e479effa1ab26e8592b', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('eb37665d7d50469bbc651c938d1baf8b', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('eb84b92656574fc7a07747b3b82d4d7a', '7bebcde2f584408cafca49a36394e7cd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('f959bf008bc7468bb49250c78f1947ff', '9725991cc39a4916a37dc61548b92752', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
INSERT INTO `tb_roles_power` VALUES ('fecbe599ad8a42a0afc587ca4777f6d4', '6801cdfc59bf43b4b87081c43c9773dd', 'a2ba32b8c57f45f5adcd6cb11ba34857', '1');
