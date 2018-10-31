/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-14 22:16:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_merchant`
-- ----------------------------
DROP TABLE IF EXISTS `tb_merchant`;
CREATE TABLE `tb_merchant` (
  `uuid` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL COMMENT '店铺名称',
  `address` varchar(255) DEFAULT NULL COMMENT '店铺地址',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `label` varchar(255) DEFAULT NULL COMMENT '标签',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `flag` int(1) DEFAULT NULL COMMENT '是否有效（1.有效 2.无效）',
  `weight` int(1) DEFAULT NULL COMMENT '权重',
  `description` varchar(400) DEFAULT NULL COMMENT '描述',
  `pic` varchar(255) DEFAULT NULL COMMENT '商家图标',
  `classify` varchar(255) DEFAULT NULL COMMENT '所属分类',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_merchant
-- ----------------------------
INSERT INTO `tb_merchant` VALUES ('01eb345c99c847e28aa76b62ef5d710f', '1231231', '12131', '1212', '', '2018-10-13 17:32:52', '2018-10-13 17:32:52', '1', '12', '1212', '\"static/upload/upload-120-120.png\"', '1b3c7582f3b64d988b70bd017a33e6b3,7f9226f703b74eeea9612df5013a589c');
INSERT INTO `tb_merchant` VALUES ('6ad891839fd04602bcb82d187aaa09cb', '店铺', '啊实打实大苏打', '18588773301', '新店开张', '2018-10-06 18:07:35', '2018-10-06 20:38:53', '1', '67', '描述啊实打实的-----------------描述啊实打实的-----------------描述啊实打实的-----------------描述啊实打实的-----------------\n描述啊实打实的-----------------', '\"http://192.168.199.231/ueditor/jsp/upload/image/2018/10/6/04e0c2e7f4c94088aae25eafa6657c1e.jpg\"', null);
INSERT INTO `tb_merchant` VALUES ('95b628d00d304b7aa94348e8b13a315d', 'diasndasdh;a', '123424234', '1211', 'eqwqw', '2018-10-14 22:14:27', '2018-10-14 22:14:27', '1', '12', '21312', '\"static/upload/upload-120-120.png\"', '1b3c7582f3b64d988b70bd017a33e6b3,7f9226f703b74eeea9612df5013a589c');
INSERT INTO `tb_merchant` VALUES ('a24803a55cee4696a1947add46125e33', 'shangjia1', '12121', '12', 'asq', '2018-10-14 22:13:33', '2018-10-14 22:13:33', '1', '12', '12', '\"static/upload/upload-120-120.png\"', '1b3c7582f3b64d988b70bd017a33e6b3,7f9226f703b74eeea9612df5013a589c');
