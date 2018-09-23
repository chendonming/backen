/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-09-23 13:08:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_ peoples_integral_int`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ peoples_integral_int`;
CREATE TABLE `tb_ peoples_integral_int` (
  `uuid` varchar(255) NOT NULL,
  `people_id` varchar(255) NOT NULL COMMENT '用户id',
  `integral` int(1) NOT NULL COMMENT '获得的积分',
  `create_time` datetime NOT NULL COMMENT '收入时间',
  `type` int(1) NOT NULL COMMENT '获取积分的途径（ 1. 帖子点赞 2.帖子<comment>评论  3.帖子发布）',
  `foreign_id` varchar(255) DEFAULT NULL COMMENT '来源id',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收入表';

-- ----------------------------
-- Records of tb_ peoples_integral_int
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_ peoples_integral_out`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ peoples_integral_out`;
CREATE TABLE `tb_ peoples_integral_out` (
  `uuid` varchar(255) NOT NULL,
  `people_id` varchar(255) NOT NULL COMMENT '用户id',
  `shop_id` varchar(255) NOT NULL,
  `shop_name` varchar(255) NOT NULL COMMENT '商品名称',
  `shop_integral` int(1) NOT NULL COMMENT '商品单价',
  `integral` int(1) NOT NULL COMMENT '支出的积分',
  `count` int(1) NOT NULL COMMENT '购买的数量',
  `create_time` datetime DEFAULT NULL COMMENT '订单时间',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户支出表';

-- ----------------------------
-- Records of tb_ peoples_integral_out
-- ----------------------------

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
INSERT INTO `tb_activitys` VALUES ('40413c006b1e49529666bbade0f50bef', 'test活动啊', '47e3a4ddc7b24609b995da160a815eb2', '2018-08-21 00:00:00', '2018-08-24 00:00:00', '2018-08-16 00:00:00', '2018-08-18 00:00:00', '1的', '123', '12', '1', '1', '24102ea95a394ddb8e1302dc15b48323', '', '124214', '2018-08-13 22:08:16', '2018-08-13 22:08:16', '1');
INSERT INTO `tb_activitys` VALUES ('b1f27848cedd45dd818be0728c9d3d2d', '八方跳水', '47e3a4ddc7b24609b995da160a815eb2', '2018-08-10 00:00:00', '2018-08-11 00:00:00', '2018-08-08 00:00:00', '2018-08-10 00:00:00', '湖南啊尝试', '15', '20', null, '1', '24102ea95a394ddb8e1302dc15b48323', '', '实打', '2018-08-08 00:07:05', '2018-08-08 00:07:05', '1');
INSERT INTO `tb_activitys` VALUES ('b671f414bb494d28a30e21fbfea9b3d0', '新建活动1111', null, '2018-08-01 12:00:00', '2018-08-02 02:00:00', '2018-08-03 00:00:00', '2018-08-04 00:00:00', '湖南申', null, null, null, '1', '47c0562c5e744776b61f3489c1e5b1bf', null, null, '2018-08-07 21:57:23', '2018-08-07 21:57:23', '1');
INSERT INTO `tb_activitys` VALUES ('c5c3d92d40e54d09bf81ada990858e47', '新建活动', null, '2018-08-01 12:00:00', '2018-08-02 02:00:00', '2018-08-03 00:00:00', '2018-08-04 00:00:00', '湖南申', null, null, null, '1', '47c0562c5e744776b61f3489c1e5b1bf', null, null, '2018-08-02 20:54:34', '2018-08-02 20:54:34', '1');
INSERT INTO `tb_activitys` VALUES ('d1fd50c5c7c1450db2a234614f0531e8', '阿斯顿撒旦阿德', '47e3a4ddc7b24609b995da160a815eb2', '2018-08-24 00:00:00', '2018-08-25 00:00:00', '2018-08-15 00:00:00', '2018-08-17 00:00:00', '123213', '213', '8', null, '1', '24102ea95a394ddb8e1302dc15b48323', '', '1233333333', '2018-08-12 13:59:52', '2018-08-12 13:59:52', '1');
INSERT INTO `tb_activitys` VALUES ('eba653a6f9f44fd7b351b19e9f2f15e7', '活动名称以', '47e3a4ddc7b24609b995da160a815eb2', '2018-08-13 00:00:00', '2018-08-16 00:00:00', '2018-08-12 00:00:00', '2018-08-15 00:00:00', '湖南', '120', '12', null, '1', '24102ea95a394ddb8e1302dc15b48323', '', '123', '2018-08-12 13:59:32', '2018-08-12 13:59:32', '1');
INSERT INTO `tb_activitys` VALUES ('ec1ba6ea85e345228c3a7931f65b9a85', '新建活动1111', null, '2018-08-01 12:00:00', '2018-08-02 02:00:00', '2018-08-03 00:00:00', '2018-08-04 00:00:00', '湖南申', null, null, null, '1', '47c0562c5e744776b61f3489c1e5b1bf', null, null, '2018-08-07 01:28:03', '2018-08-07 01:28:03', '1');

-- ----------------------------
-- Table structure for `tb_activitys_peoples`
-- ----------------------------
DROP TABLE IF EXISTS `tb_activitys_peoples`;
CREATE TABLE `tb_activitys_peoples` (
  `uuid` varchar(255) NOT NULL,
  `activity_id` varchar(255) DEFAULT NULL,
  `people_id` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `activity_id` (`activity_id`),
  KEY `people_id` (`people_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动和people的关系表';

-- ----------------------------
-- Records of tb_activitys_peoples
-- ----------------------------
INSERT INTO `tb_activitys_peoples` VALUES ('33f1ca6e3f194bd9994c991807e63c56', 'd1fd50c5c7c1450db2a234614f0531e8', '3e8ec0e988144edfa79d5057538f2eb5', '2018-08-13 22:09:50', '2018-08-13 22:09:50');
INSERT INTO `tb_activitys_peoples` VALUES ('c91d409b1b7a49fc9c904cb61255a016', '40413c006b1e49529666bbade0f50bef', '3e8ec0e988144edfa79d5057538f2eb5', '2018-08-13 22:25:39', '2018-08-13 22:25:39');

-- ----------------------------
-- Table structure for `tb_circle`
-- ----------------------------
DROP TABLE IF EXISTS `tb_circle`;
CREATE TABLE `tb_circle` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `orgId` varchar(255) NOT NULL,
  `weight` int(1) NOT NULL,
  `head_pic` varchar(255) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '状态（1 正常  2.推荐）',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `flag` int(1) DEFAULT NULL COMMENT '是否有效（1，有效 2无效）',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_circle
-- ----------------------------
INSERT INTO `tb_circle` VALUES ('9e8ee6d584464f0ea1004d4d595ecb1f', '圈子1', '47e3a4ddc7b24609b995da160a815eb2', '0', null, null, '1', '2018-09-19 20:35:04', '2018-09-22 01:20:21', '1');
INSERT INTO `tb_circle` VALUES ('aa303b510cd34478acde6ea727363699', 'sdsd1', '47e3a4ddc7b24609b995da160a815eb2', '0', 'http://192.168.199.231/ueditor/jsp/upload/image/2018/9/22/7107992e7a484d4ba29032a5e65bc6b4.jpg', '21323', '1', '2018-09-22 00:39:20', '2018-09-22 01:22:25', '1');

-- ----------------------------
-- Table structure for `tb_circle_people`
-- ----------------------------
DROP TABLE IF EXISTS `tb_circle_people`;
CREATE TABLE `tb_circle_people` (
  `uuid` varchar(255) DEFAULT NULL,
  `circle_id` varchar(255) DEFAULT NULL COMMENT '圈子ID',
  `people_id` varchar(255) DEFAULT NULL COMMENT '加入圈子peopleID',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `flag` int(1) DEFAULT NULL COMMENT '是否有效（1有效 2无效）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_circle_people
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_circle_posts`
-- ----------------------------
DROP TABLE IF EXISTS `tb_circle_posts`;
CREATE TABLE `tb_circle_posts` (
  `uuid` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` varchar(2000) DEFAULT NULL COMMENT '内容',
  `picture` varchar(255) DEFAULT NULL COMMENT '图片',
  `circle_id` varchar(255) DEFAULT NULL,
  `create_id` varchar(255) DEFAULT NULL,
  `thumbs` int(1) DEFAULT NULL COMMENT '点赞次数',
  `flag` int(1) DEFAULT NULL COMMENT '状态（1有效2无效）',
  `create_time` datetime DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '状态( 1.待审核 2.已通过（正常） 3.草稿  4.推荐 )',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='圈子帖子表';

-- ----------------------------
-- Records of tb_circle_posts
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_circle_post_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tb_circle_post_comment`;
CREATE TABLE `tb_circle_post_comment` (
  `uuid` varchar(255) NOT NULL,
  `content` varchar(2000) DEFAULT NULL COMMENT '内容',
  `create_id` varchar(255) DEFAULT NULL COMMENT '发布人',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `flag` int(1) DEFAULT NULL COMMENT '是否有效（1. 有效 2无效）',
  `post_id` varchar(255) DEFAULT NULL COMMENT '帖子ID',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_circle_post_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_classification`
-- ----------------------------
DROP TABLE IF EXISTS `tb_classification`;
CREATE TABLE `tb_classification` (
  `uuid` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `flag` int(1) DEFAULT NULL COMMENT '是否有效（1.有效 2无效）',
  `up_id` varchar(255) DEFAULT NULL COMMENT '上级ID',
  `pic` varchar(255) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`uuid`),
  KEY `name` (`up_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类管理表';

-- ----------------------------
-- Records of tb_classification
-- ----------------------------
INSERT INTO `tb_classification` VALUES ('2a3a4677d4b44f3299d39f8a2985fa04', '父分类', '2018-09-22 00:50:29', '2018-09-22 00:50:29', '1', '0', null);
INSERT INTO `tb_classification` VALUES ('a314ee381c304214af28541914cca06d', '孙子子分类1', '2018-09-22 00:58:42', '2018-09-22 00:58:42', '1', 'fbbf123eeea44272965ea158d26726ef', null);
INSERT INTO `tb_classification` VALUES ('e993a86bf36f4a1183fb7df504d0f240', '子分类2', '2018-09-22 00:58:23', '2018-09-22 00:58:23', '1', '2a3a4677d4b44f3299d39f8a2985fa04', null);
INSERT INTO `tb_classification` VALUES ('fbbf123eeea44272965ea158d26726ef', '子分类1', '2018-09-22 00:58:19', '2018-09-22 00:58:19', '1', '2a3a4677d4b44f3299d39f8a2985fa04', null);

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
INSERT INTO `tb_communitys` VALUES ('47e3a4ddc7b24609b995da160a815eb2', '八方A', '20000', '24102ea95a394ddb8e1302dc15b48323', '20000', '1234', '2018-08-07 23:31:28', '2018-08-07 23:31:28', '1', '0ec9448b84e042ab8f983e20b89148c1', 'aaaa', '18588773301');
INSERT INTO `tb_communitys` VALUES ('c5df0f89e8bf4936a916d11075741557', '八方b', '20000', '24102ea95a394ddb8e1302dc15b48323', '20000', 'adasd', '2018-08-07 23:32:58', '2018-08-07 23:32:58', '1', '0ec9448b84e042ab8f983e20b89148c1', 'bbbb', '18588773302');

-- ----------------------------
-- Table structure for `tb_complaint`
-- ----------------------------
DROP TABLE IF EXISTS `tb_complaint`;
CREATE TABLE `tb_complaint` (
  `uuid` varchar(255) NOT NULL DEFAULT '' COMMENT 'uuid',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `content` varchar(2000) NOT NULL COMMENT '内容',
  `create_id` varchar(255) DEFAULT NULL COMMENT '创建人id',
  `create_name` varchar(255) NOT NULL COMMENT '姓名',
  `phone` varchar(255) NOT NULL COMMENT '手机号码',
  `files` varchar(2000) NOT NULL COMMENT '图片',
  `status` int(11) DEFAULT NULL COMMENT '状态（1、未回复，2、回复）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `community_id` varchar(255) DEFAULT NULL COMMENT '组织机构',
  `flag` int(11) DEFAULT NULL COMMENT '是否有效 1、有效  2、无效',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='建议投诉';

-- ----------------------------
-- Records of tb_complaint
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_complaint_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tb_complaint_comment`;
CREATE TABLE `tb_complaint_comment` (
  `uuid` varchar(255) NOT NULL DEFAULT '',
  `complaint_uuid` varchar(255) DEFAULT NULL COMMENT '关联投诉建议主键',
  `content` varchar(2000) NOT NULL COMMENT '内容',
  `files` varchar(2000) NOT NULL COMMENT '图片',
  `create_time` date NOT NULL COMMENT '创建时间',
  `flag` int(11) DEFAULT NULL COMMENT '是否有效 1、有效  2、无效',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_complaint_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_garbage_rule`
-- ----------------------------
DROP TABLE IF EXISTS `tb_garbage_rule`;
CREATE TABLE `tb_garbage_rule` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '规则名称',
  `description` varchar(255) DEFAULT NULL COMMENT '规则描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `sys_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='垃圾分类单表';

-- ----------------------------
-- Records of tb_garbage_rule
-- ----------------------------
INSERT INTO `tb_garbage_rule` VALUES ('a25f7275ab3e4abe90f06811912d0936', '12412424', '124', null, null, '{\"domains1\":[{\"value\":\"214\",\"value1\":\"214\"}],\"domains2\":[{\"value\":\"214\",\"value1\":\"214\"}],\"domains3\":[{\"value\":\"124\",\"value1\":\"214\"}]}', '0ec9448b84e042ab8f983e20b89148c1');

-- ----------------------------
-- Table structure for `tb_hotline`
-- ----------------------------
DROP TABLE IF EXISTS `tb_hotline`;
CREATE TABLE `tb_hotline` (
  `uuid` varchar(255) NOT NULL DEFAULT '',
  `phone` varchar(255) DEFAULT NULL COMMENT '服务热线',
  `update_time` datetime DEFAULT NULL,
  `community_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务热线';

-- ----------------------------
-- Records of tb_hotline
-- ----------------------------
INSERT INTO `tb_hotline` VALUES ('aeff9a024f7e4ec099a8734ac11313a1', '18588773304', '2018-09-22 02:50:10', '47e3a4ddc7b24609b995da160a815eb2');

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
-- Table structure for `tb_notices`
-- ----------------------------
DROP TABLE IF EXISTS `tb_notices`;
CREATE TABLE `tb_notices` (
  `uuid` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(3000) DEFAULT NULL COMMENT '公告内容',
  `community_id` varchar(255) DEFAULT NULL COMMENT '社区Id',
  `community_name` varchar(255) DEFAULT NULL COMMENT '社区名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `type` int(1) DEFAULT NULL COMMENT '1系统发布 2.圈子发布',
  `circle_id` varchar(255) DEFAULT NULL COMMENT '所属圈子Id（没有置空）',
  `flag` int(1) DEFAULT NULL COMMENT '是否有效（1 有效 2无效）',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告表';

-- ----------------------------
-- Records of tb_notices
-- ----------------------------
INSERT INTO `tb_notices` VALUES ('09d9dc5bcdf9497c8879d47e70cbe51a', '213213123213sd', '<p>213123dsfdsf</p><p>qwewqesd</p><p>sdfsdf</p><p>sdf</p><p>dsfsdf</p><p><img src=\"http://192.168.199.231/ueditor/jsp/upload/image/2018/9/21/b9fc719760ab49bdbe975424fb7bafd6.jpg\"/></p>', '47e3a4ddc7b24609b995da160a815eb2', null, '2018-09-21 23:51:05', '2018-09-21 23:51:05', '1', null, '1');
INSERT INTO `tb_notices` VALUES ('2ed54cb798a04ae0815979e8a55ce2f9', '213213', '<p>213123</p>', '47e3a4ddc7b24609b995da160a815eb2', null, '2018-09-21 23:44:08', '2018-09-21 23:44:08', '1', null, '1');
INSERT INTO `tb_notices` VALUES ('33b6c080a7024a1aabf69ae2db511cee', '21321', '<p>3213</p>', '47e3a4ddc7b24609b995da160a815eb2', null, '2018-09-21 23:32:09', '2018-09-21 23:32:09', '1', null, '2');

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
INSERT INTO `tb_parent_menus` VALUES ('cf6ac315faf048f7bb9016726914b8c4', '内容管理', 'content', '2018-07-30 14:24:16', '2018-07-30 14:24:19', '100', '1', '内容管理');
INSERT INTO `tb_parent_menus` VALUES ('e9af029ec3e5461b9c523dc3274c6037', '权限管理', 'permiss', '2018-08-06 20:13:54', '2018-08-06 20:13:58', '40', '1', '权限管理');

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
  `role` varchar(10) DEFAULT NULL COMMENT '身份标识（1.普通居民 2.志愿者 3.社工）',
  `open_id` varchar(255) DEFAULT NULL COMMENT '微信唯一标识',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `status` (`status`),
  KEY `identity_flag` (`identity_flag`),
  KEY `mobile` (`mobile`) USING BTREE,
  KEY `id_card` (`id_card`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_peoples
-- ----------------------------
INSERT INTO `tb_peoples` VALUES ('3e8ec0e988144edfa79d5057538f2eb5', '一点痕寂', 'dage1', 'https://wx.qlogo.cn/mmopen/vi_32/ewrXbOtA5T85wLOjAksn7nkqnuCibAHv6Zcl5xOaY9IRPzibPfk2OnicMEm18TSNpRn1yhFxOVWP3icnD1l7Xa8gQg/132', '18588772236', '0', 'e10adc3949ba59abbe56e057f20f883e', '1', '123213213123', '47e3a4ddc7b24609b995da160a815eb2', '20', '20', '1', '2018-08-08 20:03:01', '2018-08-09 23:56:41', '0', '0ec9448b84e042ab8f983e20b89148c1', '1', 'oBzz60NTwxlBs6oBn4Dh7WBKWoNE', null);
INSERT INTO `tb_peoples` VALUES ('4d922d3c009046f48f691ddd049c66dc', null, '哈撒开', null, '15674215369', '1', 'e10adc3949ba59abbe56e057f20f883e', '1', '123123123123131231', '47e3a4ddc7b24609b995da160a815eb2', null, null, '1', '2018-08-08 20:03:01', '2018-08-08 20:03:01', '0', '0ec9448b84e042ab8f983e20b89148c1', '1', null, null);
INSERT INTO `tb_peoples` VALUES ('801900b1f0b04597a772d9e9beb67332', null, '彭桂', null, '12312321313', '2', 'e10adc3949ba59abbe56e057f20f883e', '1', '123123123123131231', '47e3a4ddc7b24609b995da160a815eb2', null, null, '1', '2018-08-08 20:03:01', '2018-08-08 20:03:01', '0', '0ec9448b84e042ab8f983e20b89148c1', '1', null, null);

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
-- Table structure for `tb_post_people_thumbs`
-- ----------------------------
DROP TABLE IF EXISTS `tb_post_people_thumbs`;
CREATE TABLE `tb_post_people_thumbs` (
  `uuid` varchar(255) NOT NULL DEFAULT '',
  `post_id` varchar(255) DEFAULT NULL COMMENT '帖子Id',
  `people_id` varchar(255) DEFAULT NULL COMMENT 'people id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `flag` int(1) DEFAULT NULL COMMENT '是否有效（1，有效 2无效）',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子点赞表';

-- ----------------------------
-- Records of tb_post_people_thumbs
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
INSERT INTO `tb_powers` VALUES ('b58fc43daa8d4e29b502d476b008334f', 'volunteer', '志愿者管理', '权限管理所有的权限', '2018-07-28 20:52:00', '2018-07-28 20:52:00', 'b0ed1083bfef45ecabe9137332827274', '/home/sqCommunity/volunteer', '1', '99');
INSERT INTO `tb_powers` VALUES ('b61d5793b4774e7d8d47dc4a5d8b1c33', 'notice', '公告管理', '公告管理', '2018-09-18 21:51:04', '2018-09-18 21:51:07', 'cf6ac315faf048f7bb9016726914b8c4', '/home/zhtContern/notice', '1', '100');
INSERT INTO `tb_powers` VALUES ('c3d436685e1c493fa2554c87a21dec89', 'garbage', '垃圾分类', '权限管理所有的权限', '2018-07-29 18:11:00', '2018-07-29 18:11:00', 'cf6ac315faf048f7bb9016726914b8c4', '/home/zhtContern/garbageType', '1', '60');
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
INSERT INTO `tb_roles_power` VALUES ('0696a3d702ab4fb1b770d6f0fb68c6f7', '1c5b369b85504e27ab1f49dc1d0bd80f', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('0696a3d702ab4fb1b770d6f0fb68c6f74', 'b61d5793b4774e7d8d47dc4a5d8b1c33', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('080ad8b8452c4253be9b19798d27c70', 'a45df126794f44f881999e5d9e6ad2eb', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('080ad8b8452c4253be9b19798d27c70f', '75d331a9519a468d9a74156be9048038', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('180a994d72f148459109e3419d34503b', 'f8c2d15acb374a16a03cc881548fbd14', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('1b74a67a44754f16b0ffe4299ff5bf41', '2ec6095845eb4b00b9df3069244d84a8', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('2364fbe5475b4da1ba29130303b44ac3', 'fc84e7c2a400420082b823bfa338a84b', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('25c768bacf1c494e97c67bf9b4f1cdf4', '35012730d0934fa2bb57c4107a2230f0', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('2f5bdfc3be874e84b98b988c5ddbe89d', 'e9af029ec3e5461b9c523dc3274c6037', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('306c3ac08f5f42bea1df2cd0b9ec9a13', 'a45df126794f44f881999e5d9e6ad2eb', '2181d904dd52458a9e9517ede8d625b6', '1');
INSERT INTO `tb_roles_power` VALUES ('367f60267c5c40388cefb0d3ddc5c8d8', '75a24b38a30b4ee3b452df2b4a0b9145', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('3b969247bb404b95aa9a9edc7e4f4bba', 'b58fc43daa8d4e29b502d476b008334f', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('42d3c8a9dba24d9797507a684a1bfa31', '1c5b369b85504e27ab1f49dc1d0bd80f', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('441822d301d848938eb45df13769c5d7', '3a7811613b0e4b428b0877cae1f8521b', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('4999e396a8014d76bd6dd73745ae9ae2', 'c3d436685e1c493fa2554c87a21dec89', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('4ba400fda26c4633907b996193bc2c87', '720f8eba80e448e2be9afa14bbc3240d', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('61f25a131c334f519ae15019e330a18c', '9605275ee5744fddab35a6c9934536cb', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('66928b7830ba4b11ad95ef0f3d261599', '4d861014ae9b429bb80709e16771d385', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('72a8361a8c0b4ede97362cf0aa9708a3', '75d331a9519a468d9a74156be9048038', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('7fe479a848924f568e1314cdf61ea6ab', 'cf6ac315faf048f7bb9016726914b8c4', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('816bdfd71cbd469b99b6fbe435b6c1c1', '3a7811613b0e4b428b0877cae1f8521b', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('832aaa62c0754ba687c5c0d96a60c25c', '75a24b38a30b4ee3b452df2b4a0b9145', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('9aa3ae501a4447cab4d6998e54fb3fe5', '35012730d0934fa2bb57c4107a2230f0', '2181d904dd52458a9e9517ede8d625b6', '1');
INSERT INTO `tb_roles_power` VALUES ('9dfb5049ae1b4136b11541d083a8188a', 'ec4435e28c9c42c7a80c5d6b60175945', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('b214a41b8bf543459cb5ab1ef69a2c2b', '2ec6095845eb4b00b9df3069244d84a8', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('b32dbf2b18c84a5bb124c113ddab6b4e', '4d861014ae9b429bb80709e16771d385', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('c26323f1730f40a191b954c3694ab707', '5cdc3daca0d5443ebb3578fcd7de8fd9', '30f8d2eb12514bd4aaf847d2ebe1594d', '1');
INSERT INTO `tb_roles_power` VALUES ('ca457570a36146a2a43752ef25503295', '9605275ee5744fddab35a6c9934536cb', '9393b172278e449585d192ff72a02f88', '1');
INSERT INTO `tb_roles_power` VALUES ('ce1653bfbc8f45c08b94b087db298440', 'f8c2d15acb374a16a03cc881548fbd14', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('d65101b7f9f24d4b9ee2147b93ac8138', 'c3d436685e1c493fa2554c87a21dec89', '1d519affd43d4f12aabd6645796d218c', '1');
INSERT INTO `tb_roles_power` VALUES ('dd58ae7eae004544ac8de4bca987d0c2', 'b58fc43daa8d4e29b502d476b008334f', '1d519affd43d4f12aabd6645796d218c', '1');

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
  `community_id` varchar(255) DEFAULT NULL,
  `cover_pic` varchar(255) DEFAULT NULL COMMENT '封面图',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of tb_shops
-- ----------------------------
INSERT INTO `tb_shops` VALUES ('4813169159ca43ff82187e4e6cac8851', '阿斯顿撒', '', '213', '123', null, null, '1', '', null);
INSERT INTO `tb_shops` VALUES ('7fc312a8a6634886a8a97f72a940f1c6', '我的一世英名', '', '12', '12', null, null, '1', '47e3a4ddc7b24609b995da160a815eb2', null);
INSERT INTO `tb_shops` VALUES ('992922207a0245a0a0e9886d3e2512c8', '撒旦撒', '', '123', '123', null, null, '1', '', null);
INSERT INTO `tb_shops` VALUES ('a8ce923e468d4d76a8e84f73eb9b7e41', '12', '', '214214', '124', null, null, '1', '', null);

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
INSERT INTO `tb_tasks` VALUES ('39780157296643e5a481fdf4489405a2', '剪纸一期1', '47e3a4ddc7b24609b995da160a815eb2', '2018-08-09 00:00:00', '2018-08-10 00:00:00', '湖南长沙', '30', '15', null, '1', '487ab12439814069b85b176056631c43', '', '是', '2018-08-07 23:59:54', '2018-08-07 23:59:54', '1');
INSERT INTO `tb_tasks` VALUES ('4f0dbb7b2e0743d4a2e7d51da6be9e68', '第一届垃圾分类', 'c5df0f89e8bf4936a916d11075741557', '2018-08-10 00:00:00', '2018-08-11 00:00:00', '湖南长晒', '10', '13', null, '1', '24102ea95a394ddb8e1302dc15b48323', '', '实打', '2018-08-08 00:03:43', '2018-08-08 00:03:43', '1');
INSERT INTO `tb_tasks` VALUES ('6240a019e17349d3b7b5730304fdf9e4', '新建的任务', null, '2018-08-01 12:00:00', '2018-08-02 02:00:00', '湖南申', null, null, null, '1', '47c0562c5e744776b61f3489c1e5b1bf', null, null, null, null, '1');
INSERT INTO `tb_tasks` VALUES ('6ed2f145c2b1415984522b9132d7a6cb', '11111', '47e3a4ddc7b24609b995da160a815eb2', '2018-08-16 00:00:00', '2018-08-25 00:00:00', '士大夫', '12', '20', '1', '1', '24102ea95a394ddb8e1302dc15b48323', '', '124', '2018-08-13 22:10:29', '2018-08-13 22:10:29', '1');
INSERT INTO `tb_tasks` VALUES ('775529bde5fc4d2bb2825c2e99de257a', '任务名称', '47e3a4ddc7b24609b995da160a815eb2', '2018-08-07 00:00:00', '2018-08-08 00:00:00', '湖南长沙市', '30', '15', null, '1', '24102ea95a394ddb8e1302dc15b48323', 'http://localhost/static/78f48c3c472f499f83daf77f37e52e6d.png', '124124', '2018-08-07 23:42:17', '2018-08-07 23:42:17', '1');
INSERT INTO `tb_tasks` VALUES ('819146d6015e4026bc1e7a7fd52f636d', '任务一', '1', '2018-07-31 21:28:00', '2018-10-18 21:28:09', '1', '1', '1', '1', '1', '1', '1', '1', '2018-07-31 21:28:27', '2018-07-31 21:28:30', '1');
INSERT INTO `tb_tasks` VALUES ('c2e4bcf1fb8740cd92d7c29a47f05a00', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '47e3a4ddc7b24609b995da160a815eb2', '2018-08-14 00:00:00', '2018-08-16 00:00:00', '123', '12', '12', null, '1', '24102ea95a394ddb8e1302dc15b48323', '', '213213', '2018-08-12 16:36:42', '2018-08-12 16:36:42', '1');
INSERT INTO `tb_tasks` VALUES ('f2a6bca0533f4a899ade0ae7bcaab272', '任务啊啊啊', '47e3a4ddc7b24609b995da160a815eb2', '2018-08-13 00:00:00', '2018-08-15 00:00:00', '湖南长沙啊', '20', '15', null, '1', '24102ea95a394ddb8e1302dc15b48323', '', '12321321', '2018-08-12 15:38:57', '2018-08-12 15:38:57', '1');

-- ----------------------------
-- Table structure for `tb_tasks_peoples`
-- ----------------------------
DROP TABLE IF EXISTS `tb_tasks_peoples`;
CREATE TABLE `tb_tasks_peoples` (
  `uuid` varchar(255) NOT NULL,
  `task_id` varchar(255) DEFAULT NULL,
  `people_id` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `task_id` (`task_id`),
  KEY `people_id` (`people_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务和people的关系表';

-- ----------------------------
-- Records of tb_tasks_peoples
-- ----------------------------
INSERT INTO `tb_tasks_peoples` VALUES ('29ad84e7a68d42a1a8303e72df31eb6a', 'c2e4bcf1fb8740cd92d7c29a47f05a00', '3e8ec0e988144edfa79d5057538f2eb5', '2018-08-12 16:36:57', '2018-08-12 16:36:57');
INSERT INTO `tb_tasks_peoples` VALUES ('45e227a97cb74af88322cdd3866cb4cc', 'f2a6bca0533f4a899ade0ae7bcaab272', '3e8ec0e988144edfa79d5057538f2eb5', '2018-08-12 16:35:32', '2018-08-12 16:35:32');
INSERT INTO `tb_tasks_peoples` VALUES ('8ec8d93da6fe4120b98d4f25dbd06173', '6ed2f145c2b1415984522b9132d7a6cb', '3e8ec0e988144edfa79d5057538f2eb5', '2018-08-13 22:23:51', '2018-08-13 22:23:51');

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
INSERT INTO `tb_users` VALUES ('487ab12439814069b85b176056631c43', 'aaaa', 'aaaa', null, '18588773301', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, '47e3a4ddc7b24609b995da160a815eb2', null, null, '1', '2018-08-07 23:31:28', '2018-08-07 23:31:28', '0ec9448b84e042ab8f983e20b89148c1', '30f8d2eb12514bd4aaf847d2ebe1594d');
INSERT INTO `tb_users` VALUES ('810dd5476bde4c7eb62ddda7b5830677', null, '陈东民', null, '15974253641', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, '', null, null, '1', '2018-08-07 22:35:37', '2018-08-07 22:35:37', '0ec9448b84e042ab8f983e20b89148c1', '1d519affd43d4f12aabd6645796d218c');
INSERT INTO `tb_users` VALUES ('cbba404ad93a44d8a8c99803f2116cd2', 'bbbb', 'bbbb', null, '18588773302', null, 'e10adc3949ba59abbe56e057f20f883e', null, null, 'c5df0f89e8bf4936a916d11075741557', null, null, '1', '2018-08-07 23:32:58', '2018-08-07 23:32:58', '0ec9448b84e042ab8f983e20b89148c1', '30f8d2eb12514bd4aaf847d2ebe1594d');

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
  PRIMARY KEY (`uuid`),
  KEY `bind_user` (`bind_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信登录的用户表';

-- ----------------------------
-- Records of tb_wx_users
-- ----------------------------
INSERT INTO `tb_wx_users` VALUES ('1d54bdc4b7f0479ca0d2737bd4ba35f1', '一点痕寂', null, null, null, '0', 'https://wx.qlogo.cn/mmopen/vi_32/ewrXbOtA5T85wLOjAksn7nkqnuCibAHv6Zcl5xOaY9IRPzibPfk2OnicMEm18TSNpRn1yhFxOVWP3icnD1l7Xa8gQg/132', '2018-08-09 18:43:21', '2018-08-09 18:43:21');
INSERT INTO `tb_wx_users` VALUES ('4f2945aa3d544c308838fc965230a347', null, null, null, null, null, null, '2018-08-09 22:27:55', '2018-08-09 22:27:55');
INSERT INTO `tb_wx_users` VALUES ('5fa8b32accfb457ebf0c9ca7c36e0d26', null, null, null, null, null, null, '2018-08-09 22:07:56', '2018-08-09 22:07:56');
INSERT INTO `tb_wx_users` VALUES ('ad97ec58958c49b39182029dee6d2a05', null, null, 'oBzz60KcpdjYEAe_rN91SL6r0cBU', null, '1', 'https://wx.qlogo.cn/mmopen/vi_32/pbjIJqM0Sxv6iaIXmrrqb8saO0weAVqaBhC2u68tmNNxJ7BGGsebVeQgKye8b37ykXFdauXic7TST7QsJEuYicsng/132', '2018-08-13 20:38:29', '2018-08-13 20:38:29');
INSERT INTO `tb_wx_users` VALUES ('c154baa55fbd48d7a0d76690b31b5824', '一点痕寂', null, 'oBzz60NTwxlBs6oBn4Dh7WBKWoNE', null, '0', 'https://wx.qlogo.cn/mmopen/vi_32/ewrXbOtA5T85wLOjAksn7nkqnuCibAHv6Zcl5xOaY9IRPzibPfk2OnicMEm18TSNpRn1yhFxOVWP3icnD1l7Xa8gQg/132', '2018-08-09 18:45:18', '2018-08-09 18:45:18');
INSERT INTO `tb_wx_users` VALUES ('e33a3d4ffe6f4e0ca1cfa161752d35fd', null, null, null, null, null, null, '2018-08-09 21:56:24', '2018-08-09 21:56:24');
