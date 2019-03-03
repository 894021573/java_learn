/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : bona

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-02-15 18:38:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '分类1', '0', '0', '0');
INSERT INTO `category` VALUES ('2', '分类2', '0', '0', '0');
INSERT INTO `category` VALUES ('3', '分类1-子类a', '1', '0', '0');
INSERT INTO `category` VALUES ('4', '分类2-子类b', '2', '0', '0');
INSERT INTO `category` VALUES ('5', 'hello', '3', '0', '1550218431');

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
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '1-未支付；2-已支付；3-已取消；4-已删除',
  `created_at` int(10) unsigned NOT NULL DEFAULT '0',
  `updated_at` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('22', '6', '1902121501218551682', '1', '1549954881', '0');
INSERT INTO `order` VALUES ('23', '6', '1902121633287803290', '1', '1549960408', '0');
INSERT INTO `order` VALUES ('24', '1', '2', '1', '3', '0');
INSERT INTO `order` VALUES ('25', '1', '2', '1', '3', '0');
INSERT INTO `order` VALUES ('26', '1', '2', '1', '3', '0');
INSERT INTO `order` VALUES ('27', '1', '2', '1', '3', '0');
INSERT INTO `order` VALUES ('28', '6', '1902131750278008886', '1', '1550051427', '0');
INSERT INTO `order` VALUES ('29', '6', '1902131753548372539', '1', '1550051634', '0');
INSERT INTO `order` VALUES ('30', '6', '1902131754478062344', '1', '1550051687', '0');
INSERT INTO `order` VALUES ('31', '6', '1902131759100799583', '1', '1550051950', '0');
INSERT INTO `order` VALUES ('32', '6', '1902131803551915205', '1', '1550052235', '0');
INSERT INTO `order` VALUES ('33', '6', '1902131812051941793', '1', '1550052725', '0');
INSERT INTO `order` VALUES ('34', '6', '1902151115573330007', '1', '1550200557', '0');
INSERT INTO `order` VALUES ('35', '6', '1902151650299136426', '1', '1550220629', '0');
INSERT INTO `order` VALUES ('36', '6', '1902151651085142742', '2', '1550220668', '0');

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
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_goods
-- ----------------------------
INSERT INTO `order_goods` VALUES ('10', '6', '22', '1', '0', '100', '1', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1549954882', '0');
INSERT INTO `order_goods` VALUES ('11', '6', '22', '2', '0', '200', '1', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1549954882', '0');
INSERT INTO `order_goods` VALUES ('14', '6', '1', '1', '0', '100', '2', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550051428', '0');
INSERT INTO `order_goods` VALUES ('12', '6', '23', '1', '0', '100', '1', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1549960409', '0');
INSERT INTO `order_goods` VALUES ('13', '6', '23', '2', '0', '200', '1', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1549960409', '0');
INSERT INTO `order_goods` VALUES ('15', '6', '1', '2', '0', '200', '2', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550051428', '0');
INSERT INTO `order_goods` VALUES ('16', '6', '1', '1', '0', '100', '2', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550051635', '0');
INSERT INTO `order_goods` VALUES ('17', '6', '1', '2', '0', '200', '2', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550051635', '0');
INSERT INTO `order_goods` VALUES ('18', '6', '1', '1', '0', '100', '2', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550051688', '0');
INSERT INTO `order_goods` VALUES ('19', '6', '1', '2', '0', '200', '2', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550051688', '0');
INSERT INTO `order_goods` VALUES ('20', '6', '1', '1', '0', '100', '2', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550051950', '0');
INSERT INTO `order_goods` VALUES ('21', '6', '1', '2', '0', '200', '2', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550051950', '0');
INSERT INTO `order_goods` VALUES ('22', '6', '1', '1', '0', '100', '3', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550052235', '0');
INSERT INTO `order_goods` VALUES ('23', '6', '1', '2', '0', '200', '3', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550052235', '0');
INSERT INTO `order_goods` VALUES ('24', '6', '1', '1', '0', '100', '4', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550052725', '0');
INSERT INTO `order_goods` VALUES ('25', '6', '1', '2', '0', '200', '4', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550052725', '0');
INSERT INTO `order_goods` VALUES ('26', '6', '1', '1', '0', '100', '1', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550220630', '0');
INSERT INTO `order_goods` VALUES ('27', '6', '1', '2', '0', '200', '1', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550220630', '0');
INSERT INTO `order_goods` VALUES ('28', '6', '1', '1', '0', '100', '1', '[{\"goods_id\":1,\"attribute_name_id\":1,\"attribute_value\":\"游戏型\",\"goods_attribute_name\":{\"name\":\"型号\"}},{\"goods_id\":1,\"attribute_name_id\":2,\"attribute_value\":\"黑色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550220668', '0');
INSERT INTO `order_goods` VALUES ('29', '6', '1', '2', '0', '200', '1', '[{\"goods_id\":2,\"attribute_name_id\":3,\"attribute_value\":\"L\",\"goods_attribute_name\":{\"name\":\"尺寸\"}},{\"goods_id\":2,\"attribute_name_id\":2,\"attribute_value\":\"白色\",\"goods_attribute_name\":{\"name\":\"颜色\"}}]', '1550220668', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

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
INSERT INTO `user` VALUES ('16', 'xin3', '310dcbbf4cce62f762a2aaa148d556bd', '54b89f9f4096475488b8c47c10a4a312', '1548141952', '1550200558');
INSERT INTO `user` VALUES ('17', 'xin4', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548326408', '0');
INSERT INTO `user` VALUES ('18', 'xin5', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829180', '0');
INSERT INTO `user` VALUES ('19', '1548829271', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829271', '0');
INSERT INTO `user` VALUES ('20', '1548829287', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829288', '0');
INSERT INTO `user` VALUES ('21', '1548829291', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829292', '0');
INSERT INTO `user` VALUES ('22', '1548829514', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829514', '0');
INSERT INTO `user` VALUES ('23', '1548829577', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829577', '0');
INSERT INTO `user` VALUES ('24', '1548829581', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548829582', '0');
INSERT INTO `user` VALUES ('25', '1548838598', '310dcbbf4cce62f762a2aaa148d556bd', '', '1548838598', '0');
INSERT INTO `user` VALUES ('26', 'aa', 'bb', '', '0', '0');
INSERT INTO `user` VALUES ('27', 'aa11', 'bb22', '', '0', '0');
INSERT INTO `user` VALUES ('28', 'aa11', 'bb22', '', '0', '0');
INSERT INTO `user` VALUES ('29', 'aa11', 'bb22', '', '0', '0');
INSERT INTO `user` VALUES ('30', 'ak', 'bk', '', '0', '0');
INSERT INTO `user` VALUES ('31', 'akhello', 'bk', '', '0', '0');
INSERT INTO `user` VALUES ('34', '1550050452', '310dcbbf4cce62f762a2aaa148d556bd', '', '1550050453', '0');
INSERT INTO `user` VALUES ('35', '1550051960', '310dcbbf4cce62f762a2aaa148d556bd', '', '1550051961', '0');
INSERT INTO `user` VALUES ('36', '1550052236', '310dcbbf4cce62f762a2aaa148d556bd', '', '1550052236', '0');
INSERT INTO `user` VALUES ('37', '1550052725', '310dcbbf4cce62f762a2aaa148d556bd', '', '1550052725', '0');
INSERT INTO `user` VALUES ('38', '1550200345', '310dcbbf4cce62f762a2aaa148d556bd', '', '1550200345', '0');
INSERT INTO `user` VALUES ('39', '1550200558', '310dcbbf4cce62f762a2aaa148d556bd', '', '1550200558', '0');
SET FOREIGN_KEY_CHECKS=1;
