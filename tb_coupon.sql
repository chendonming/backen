/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-19 23:12:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `tb_coupon`;
CREATE TABLE `tb_coupon` (
  `uuid` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `flag` int(1) DEFAULT NULL,
  `merchant_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券';

-- ----------------------------
-- Records of tb_coupon
-- ----------------------------
INSERT INTO `tb_coupon` VALUES ('9ba676634aaa4a5e969da0358041deed', '2018-10-13 10:50:11', '2018-10-13 10:50:11', '优惠券', '13123', '2018-10-19 00:00:00', '2018-11-11 00:00:00', '1', '6ad891839fd04602bcb82d187aaa09cb');
