/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : bona

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-01-23 18:28:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '分类1', '0', '0');
INSERT INTO `category` VALUES ('2', '分类2', '0', '0');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shop_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '店铺id',
  `category_id` int(10) unsigned NOT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `price` decimal(10,0) unsigned NOT NULL DEFAULT '0',
  `total` int(10) unsigned NOT NULL DEFAULT '0',
  `color` varchar(255) NOT NULL DEFAULT '0' COMMENT '属性id',
  `size` varchar(255) NOT NULL,
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '0', '1', 'a', '1', '10', '红', 'L', '0', '0');
INSERT INTO `goods` VALUES ('2', '0', '2', 'b', '2', '20', '白', 'M', '0', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `token` char(32) NOT NULL,
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'ht1', '111', '', '0', '0');
INSERT INTO `user` VALUES ('7', 'ht2', '222', '', '0', '0');
INSERT INTO `user` VALUES ('8', 'ht3', '333', '', '0', '0');
INSERT INTO `user` VALUES ('9', 'ht4', '444', '', '0', '0');
INSERT INTO `user` VALUES ('10', 'ht1', '111', '', '0', '0');
INSERT INTO `user` VALUES ('11', 'ht2', '222', '', '1548141125', '0');
INSERT INTO `user` VALUES ('12', 'ht2', '222', '', '1548141131', '0');
INSERT INTO `user` VALUES ('13', 'xin', '222', '', '1548141170', '0');
INSERT INTO `user` VALUES ('14', 'ht1', '111', '', '0', '0');
INSERT INTO `user` VALUES ('15', 'xin2', '222', '', '1548141477', '0');
INSERT INTO `user` VALUES ('16', 'xin3', '310dcbbf4cce62f762a2aaa148d556bd', 'c44aa61e30fe44ae88110ae1ac257395', '1548141952', '1548239200');
SET FOREIGN_KEY_CHECKS=1;
