/*
Navicat MySQL Data Transfer

Source Server         : haha
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : mydemo

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-02-24 13:23:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `nickName` varchar(20) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '张三', '小三', '18888888888', 'zs@163.com');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(50) NOT NULL,
  `orderTime` date DEFAULT NULL,
  `peopleCount` int(11) DEFAULT NULL,
  `orderDesc` varchar(500) DEFAULT NULL,
  `payType` int(11) DEFAULT NULL,
  `orderStatus` int(11) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `memberid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk1` (`productid`),
  KEY `fk2` (`memberid`),
  CONSTRAINT `fk1` FOREIGN KEY (`productid`) REFERENCES `product` (`id`),
  CONSTRAINT `fk2` FOREIGN KEY (`memberid`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '12345', '2020-02-19', '2', '没什么', '0', '1', '1', '1');
INSERT INTO `orders` VALUES ('2', '54321', '2020-02-19', '2', '没什么', '0', '1', '1', '1');
INSERT INTO `orders` VALUES ('3', '67890', '2020-02-19', '2', '没什么', '0', '1', '2', '1');
INSERT INTO `orders` VALUES ('4', '98765', '2020-02-19', '2', '没什么', '0', '1', '2', '1');
INSERT INTO `orders` VALUES ('5', '11111', '2020-02-19', '2', '没什么', '0', '1', '2', '1');
INSERT INTO `orders` VALUES ('6', '22222', '2020-02-19', '2', '没什么', '0', '1', '2', '1');
INSERT INTO `orders` VALUES ('7', '33333', '2020-02-19', '2', '没什么', '0', '1', '3', '1');
INSERT INTO `orders` VALUES ('8', '44444', '2020-02-19', '2', '没什么', '0', '1', '3', '1');
INSERT INTO `orders` VALUES ('9', '55555', '2020-02-19', '2', '没什么', '0', '1', '3', '1');

-- ----------------------------
-- Table structure for `order_traveller`
-- ----------------------------
DROP TABLE IF EXISTS `order_traveller`;
CREATE TABLE `order_traveller` (
  `orderId` int(11) NOT NULL,
  `travellerId` int(11) NOT NULL,
  PRIMARY KEY (`orderId`,`travellerId`),
  KEY `fk22` (`travellerId`),
  CONSTRAINT `fk21` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`),
  CONSTRAINT `fk22` FOREIGN KEY (`travellerId`) REFERENCES `traveller` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_traveller
-- ----------------------------
INSERT INTO `order_traveller` VALUES ('1', '1');
INSERT INTO `order_traveller` VALUES ('3', '1');
INSERT INTO `order_traveller` VALUES ('4', '1');
INSERT INTO `order_traveller` VALUES ('6', '1');
INSERT INTO `order_traveller` VALUES ('8', '1');
INSERT INTO `order_traveller` VALUES ('9', '1');
INSERT INTO `order_traveller` VALUES ('1', '2');
INSERT INTO `order_traveller` VALUES ('2', '2');
INSERT INTO `order_traveller` VALUES ('5', '2');
INSERT INTO `order_traveller` VALUES ('7', '2');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'user findAll', '/user/findAll.do');
INSERT INTO `permission` VALUES ('2', 'user findById', '/user/findById.do');
INSERT INTO `permission` VALUES ('3', 'role findAll', '/role/findAll.do');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `productNum` varchar(50) NOT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `cityName` varchar(50) DEFAULT NULL,
  `DepartureTime` date DEFAULT NULL,
  `productPrice` float DEFAULT NULL,
  `productDesc` varchar(500) DEFAULT NULL,
  `productStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'itcast-002', '北京三日游', '北京', '2018-10-10', '1200', '不错的旅行', '1');
INSERT INTO `product` VALUES ('2', 'itcast-003', '上海五日游', '上海', '2018-04-25', '1800', '魔都我来了', '0');
INSERT INTO `product` VALUES ('3', 'itcast-001', '北京三日游', '北京', '2018-10-10', '1200', '不错的旅行', '1');
INSERT INTO `product` VALUES ('4', 'itcast-004', '甘南十日游', '甘南', '2020-02-19', '500', '这里有著名的音河水库', '1');
INSERT INTO `product` VALUES ('5', 'itcast-005', '哈尔滨三日游', '哈尔滨', '2020-02-19', '999', '冰雪大世界', '1');
INSERT INTO `product` VALUES ('6', 'itcast-006', '宁夏三日游', '宁夏', '2020-02-22', '1222', '美好风光', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN', '管理员');
INSERT INTO `role` VALUES ('2', 'ROLE_USER', '普通用户');
INSERT INTO `role` VALUES ('3', 'ROLE_VIP', 'VIP用户特殊服务');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `permissionId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`permissionId`,`roleId`),
  KEY `RP2` (`roleId`),
  CONSTRAINT `RP1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`),
  CONSTRAINT `RP2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1');
INSERT INTO `role_permission` VALUES ('2', '1');
INSERT INTO `role_permission` VALUES ('1', '2');
INSERT INTO `role_permission` VALUES ('3', '2');
INSERT INTO `role_permission` VALUES ('3', '3');

-- ----------------------------
-- Table structure for `syslog`
-- ----------------------------
DROP TABLE IF EXISTS `syslog`;
CREATE TABLE `syslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visitTime` date DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `executionTime` int(11) DEFAULT NULL,
  `method` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syslog
-- ----------------------------
INSERT INTO `syslog` VALUES ('1', '2020-02-23', 'smh', '0:0:0:0:0:0:0:1', '/product/findAll.do', '34', '[类]: com.smh.controller.ProductController [方法]: findAll');
INSERT INTO `syslog` VALUES ('2', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/orders/findAll.do', '0', '[类]: com.smh.controller.OrdersController [方法]: findAll');
INSERT INTO `syslog` VALUES ('3', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/orders/findAll.do', '153', '[类]: com.smh.controller.OrdersController [方法]: findAll');
INSERT INTO `syslog` VALUES ('4', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '89', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('5', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '109', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('6', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/role/findAll.do', '13', '[类]: com.smh.controller.RoleController [方法]: findAll');
INSERT INTO `syslog` VALUES ('7', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/user/findAll.do', '25', '[类]: com.smh.controller.UserController [方法]: findAll');
INSERT INTO `syslog` VALUES ('8', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/product/findAll.do', '22', '[类]: com.smh.controller.ProductController [方法]: findAll');
INSERT INTO `syslog` VALUES ('9', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/orders/findAll.do', '38', '[类]: com.smh.controller.OrdersController [方法]: findAll');
INSERT INTO `syslog` VALUES ('10', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/user/findAll.do', '9', '[类]: com.smh.controller.UserController [方法]: findAll');
INSERT INTO `syslog` VALUES ('11', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/role/findAll.do', '12', '[类]: com.smh.controller.RoleController [方法]: findAll');
INSERT INTO `syslog` VALUES ('12', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/role/findById.do', '8', '[类]: com.smh.controller.RoleController [方法]: findById');
INSERT INTO `syslog` VALUES ('13', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '9', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('14', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '10', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('15', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '7', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('16', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '6', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('17', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '13', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('18', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '8', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('19', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '4', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('20', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '100', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('21', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/orders/findAll.do', '38', '[类]: com.smh.controller.OrdersController [方法]: findAll');
INSERT INTO `syslog` VALUES ('22', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/orders/findAll.do', '27', '[类]: com.smh.controller.OrdersController [方法]: findAll');
INSERT INTO `syslog` VALUES ('23', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', 'sysLog/findAll.do', '9', '[类]: com.smh.controller.SysLogController [方法]: findAll');
INSERT INTO `syslog` VALUES ('24', '2020-02-23', 'root', '0:0:0:0:0:0:0:1', '/orders/findAll.do', '31', '[类]: com.smh.controller.OrdersController [方法]: findAll');

-- ----------------------------
-- Table structure for `traveller`
-- ----------------------------
DROP TABLE IF EXISTS `traveller`;
CREATE TABLE `traveller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `credentialsType` int(11) DEFAULT NULL,
  `credentialsNum` varchar(50) DEFAULT NULL,
  `travellerType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traveller
-- ----------------------------
INSERT INTO `traveller` VALUES ('1', '张龙', '男', '13333333333', '0', '5630267', '0');
INSERT INTO `traveller` VALUES ('2', '张小龙', '男', '15555555555', '1', '1324568', '1');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phoneNum` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `in1` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '1113935784@qq.com', 'root', '$2a$10$4uIpvWSUrjvzHFJMBLibAepTk59jcXHHbFgKmiCoIBa4KmrNMyaua', '18103695167', '1');
INSERT INTO `users` VALUES ('2', '5630267@163.com', 'smh', '$2a$10$OpaVsyXlyYNsaY3OZlroGuUzJAgy0X4ALkJ.hlrQevHueCoW0HsF.', '18746281577', '1');

-- ----------------------------
-- Table structure for `users_role`
-- ----------------------------
DROP TABLE IF EXISTS `users_role`;
CREATE TABLE `users_role` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `UR2` (`roleId`),
  CONSTRAINT `UR1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
  CONSTRAINT `UR2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_role
-- ----------------------------
INSERT INTO `users_role` VALUES ('1', '1');
INSERT INTO `users_role` VALUES ('1', '2');
INSERT INTO `users_role` VALUES ('2', '2');
INSERT INTO `users_role` VALUES ('1', '3');
INSERT INTO `users_role` VALUES ('2', '3');
