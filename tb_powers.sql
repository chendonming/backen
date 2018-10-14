/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-08 22:14:33
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `tb_powers` VALUES ('933e1f63db0f4445ae37c22509d923ac', 'complaint', '建议投诉', null, '2018-10-08 19:58:43', '2018-10-08 19:58:45', '35ee463e182e4d03b1578192e2a65a97', '/home/sqComplaint/complaintManage', '2', '100');
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
