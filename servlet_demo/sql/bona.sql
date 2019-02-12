/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : bona

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-02-12 18:19:15
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
  `quantity` int(10) unsigned NOT NULL DEFAULT '0',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '0', '1', '电脑', '100', '10', '0', '0');
INSERT INTO `goods` VALUES ('2', '0', '2', '衣服', '200', '20', '0', '0');

-- ----------------------------
-- Table structure for goods_attribute
-- ----------------------------
DROP TABLE IF EXISTS `goods_attribute`;
CREATE TABLE `goods_attribute` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT 'goods_attribute_name主键',
  `attribute_name_id` int(10) unsigned NOT NULL DEFAULT '0',
  `attribute_value` varchar(255) NOT NULL DEFAULT '',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_attribute
-- ----------------------------
INSERT INTO `goods_attribute` VALUES ('1', '1', '1', '游戏型', '0', '0');
INSERT INTO `goods_attribute` VALUES ('2', '1', '2', '黑色', '0', '0');
INSERT INTO `goods_attribute` VALUES ('3', '2', '3', 'L', '0', '0');
INSERT INTO `goods_attribute` VALUES ('4', '2', '2', '白色', '0', '0');

-- ----------------------------
-- Table structure for goods_attribute_name
-- ----------------------------
DROP TABLE IF EXISTS `goods_attribute_name`;
CREATE TABLE `goods_attribute_name` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_attribute_name
-- ----------------------------
INSERT INTO `goods_attribute_name` VALUES ('1', '型号', '0', '0');
INSERT INTO `goods_attribute_name` VALUES ('2', '颜色', '0', '0');
INSERT INTO `goods_attribute_name` VALUES ('3', '尺寸', '0', '0');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `order_number` bigint(20) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '1-未支付；2-已支付',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('22', '6', '1902121501218551682', '1', '1549954881', '0');
INSERT INTO `order` VALUES ('23', '6', '1902121633287803290', '1', '1549960408', '0');

-- ----------------------------
-- Table structure for order_goods
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `order_id` int(10) unsigned NOT NULL,
  `goods_id` int(10) NOT NULL,
  `shop_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '店铺id',
  `price` decimal(10,0) unsigned NOT NULL DEFAULT '0',
  `buy_number` int(10) unsigned NOT NULL DEFAULT '0',
  `attribute_json` text NOT NULL,
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_goods
-- ----------------------------
INSERT INTO `order_goods` VALUES ('10', '6', '22', '1', '0', '100', '1', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1549954882', '0');
INSERT INTO `order_goods` VALUES ('11', '6', '22', '2', '0', '200', '1', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1549954882', '0');
INSERT INTO `order_goods` VALUES ('12', '6', '23', '1', '0', '100', '1', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1549960409', '0');
INSERT INTO `order_goods` VALUES ('13', '6', '23', '2', '0', '200', '1', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1549960409', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `token` char(32) NOT NULL DEFAULT '',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

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
INSERT INTO `user` VALUES ('16', 'xin3', '310dcbbf4cce62f762a2aaa148d556bd', 'ec219b41c7f44fd39e86f7cfd300f80f', '1548141952', '1548906939');
INSERT INTO `user` VALUES ('17', 'xin4', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548326408', '0');
INSERT INTO `user` VALUES ('18', 'xin5', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829180', '0');
INSERT INTO `user` VALUES ('19', '1548829271', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829271', '0');
INSERT INTO `user` VALUES ('20', '1548829287', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829288', '0');
INSERT INTO `user` VALUES ('21', '1548829291', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829292', '0');
INSERT INTO `user` VALUES ('22', '1548829514', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829514', '0');
INSERT INTO `user` VALUES ('23', '1548829577', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829577', '0');
INSERT INTO `user` VALUES ('24', '1548829581', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829582', '0');
INSERT INTO `user` VALUES ('25', '1548838598', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548838598', '0');
SET FOREIGN_KEY_CHECKS=1;
