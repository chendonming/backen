/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-07-30 14:48:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_parent_menus
-- ----------------------------
DROP TABLE IF EXISTS `tb_parent_menus`;
CREATE TABLE `tb_parent_menus` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_parent_menus
-- ----------------------------
INSERT INTO `tb_parent_menus` VALUES ('cf6ac315faf048f7bb9016726914b8c4', '内容管理', 'content', '2018-07-30 14:24:16', '2018-07-30 14:24:19');
