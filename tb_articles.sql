/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : db_backen

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2018-10-17 21:49:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_articles`
-- ----------------------------
DROP TABLE IF EXISTS `tb_articles`;
CREATE TABLE `tb_articles` (
  `uuid` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `content` text COMMENT '内容',
  `flag` int(1) DEFAULT NULL COMMENT '是否有效（1 ， 2）',
  `create_id` varchar(255) DEFAULT NULL COMMENT '发布人',
  `classify` varchar(255) DEFAULT NULL COMMENT '所属分类',
  `type` int(1) DEFAULT NULL COMMENT '类型（1. 网格 2.活动风采 ）同分类的type',
  `pic` varchar(255) NOT NULL DEFAULT '',
  `content_type` int(1) DEFAULT NULL COMMENT '内容类型（1. 无图 2. 1张图 3. 2张图  4.3张或以上  5.视频  6.音频）',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(1) DEFAULT NULL COMMENT '0正常   1 推荐',
  `community_id` varchar(255) DEFAULT NULL COMMENT '社区id',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of tb_articles
-- ----------------------------
INSERT INTO `tb_articles` VALUES ('22809778cad844db9823d06f05d53652', '好人好事好人好事好人好事', '2018-10-05 19:32:31', '2018-10-05 20:01:35', '<p>好人好事好人好事好人好事</p><p>好人好事</p><p>好人好事</p><p>好人好事</p><p>好人好事</p>', '1', null, '97330fc92c564e8890689cec095a3132', '1', '', null, null, null, null);
INSERT INTO `tb_articles` VALUES ('3e4849fee8a74d25986767d8fdc793fb', 'dqeqweqw', '2018-10-05 22:18:23', '2018-10-05 22:18:23', '<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;qweqweqwe<br/></p>', '1', null, '32a7d841602448e387163d0b2d66d478', '1', '', '1', 'qweqweqwe', null, null);
INSERT INTO `tb_articles` VALUES ('4db4879cbb8c46218de165fbaf47209e', 'wewewewewewew', '2018-10-05 22:16:36', '2018-10-05 22:16:36', '<p>sadfasfas</p>', '1', null, '97330fc92c564e8890689cec095a3132', '1', '[]', '1', 'sadfasfas', null, null);
INSERT INTO `tb_articles` VALUES ('79bfd81e5f2d46cebf996b21f40c503e', 'dajdoihaodfiahfs', '2018-10-05 22:19:52', '2018-10-05 22:19:52', '<p><img src=\"http://192.168.199.231/ueditor/jsp/upload/image/2018/10/5/93a9ca9f72734fa396c5b0e7eef0b6ab.jpg\"/></p><p>dasdasdas</p><p>vdsfsd</p><p>gfdgfdgdfhgdfhdf</p>', '1', null, 'ab8324c33aa748c88ddc84242aa36364', '1', 'http://192.168.199.231/ueditor/jsp/upload/image/2018/10/5/93a9ca9f72734fa396c5b0e7eef0b6ab.jpg', '2', 'dasdasdasvdsfsdgfdgfdgdfhgdfhdf', null, null);
INSERT INTO `tb_articles` VALUES ('98870a1a92074bee86dff5352dddff9e', '文章黑帮', '2018-10-05 19:47:19', '2018-10-05 19:53:48', '<p>文章黑帮文章黑帮文章黑帮文章黑帮文章黑帮</p><p>文章黑帮</p><p>文章黑帮</p><p>文章黑帮</p><p>文章黑帮</p><p>文章黑帮</p><p>文章黑帮</p><p>文章黑帮文章黑帮文章黑帮</p>', '1', null, '97330fc92c564e8890689cec095a3132', '1', '', null, null, null, null);
INSERT INTO `tb_articles` VALUES ('f43a35a2407546e39fd488f9e6ed152f', '文章', '2018-10-04 18:30:17', '2018-10-05 20:37:00', '<p><img src=\"http://192.168.199.231/ueditor/jsp/upload/image/2018/10/4/f72b6bcde3e24a76897f3514f393fd27.jpg\" width=\"70\" height=\"100\" border=\"0\" vspace=\"0\" title=\"\" alt=\"\" style=\"width: 70px; height: 100px;\"/></p><p>asdas</p><p><br/></p><p>das</p><p><br/></p><p>啊是大</p>', '2', '487ab12439814069b85b176056631c43', null, '2', '', null, null, null, null);
