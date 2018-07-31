/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-07-30 17:32:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_roles
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles`;
CREATE TABLE `tb_roles` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT ' 描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '1正常 2删除',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_roles
-- ----------------------------
INSERT INTO `tb_roles` VALUES ('1aeba04bda824f54a3fc01d8b1af389a', '新增的角色', '没事出来玩的', '2018-07-29 01:25:36', '2018-07-29 01:25:36', '1');
INSERT INTO `tb_roles` VALUES ('50e41d6abb654f7c97b022757ff1d8e6', '小型管理员', '部分操作', '2018-07-28 20:49:24', '2018-07-28 20:49:27', '1');
INSERT INTO `tb_roles` VALUES ('69bb65467a4a40a88fc2e42f3672220', '大型管理员', '绝大部分操作', '2018-07-28 20:51:41', '2018-07-28 20:51:45', '1');
