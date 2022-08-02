/*
Navicat MySQL Data Transfer

Source Server         : localhost_qa
Source Server Version : 50738
Source Host           : localhost:3306
Source Database       : futureloan

Target Server Type    : MYSQL
Target Server Version : 50738
File Encoding         : 65001

Date: 2022-07-22 09:21:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(10) NOT NULL,
  `name` char(10) NOT NULL,
  `sex` char(10) DEFAULT NULL,
  `addr` char(50) DEFAULT '北京',
  `age` int(10) DEFAULT NULL,
  `email` char(50) DEFAULT NULL,
  `reg_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `leave_amount` decimal(20,0) DEFAULT NULL,
  `mobile_phone` char(20) DEFAULT NULL,
  `password` char(18) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '张三', '男', '南京', '4', 'zhangsan@test.com', '2022-07-22 08:48:07', '2', '18900211000', '12345678');
INSERT INTO `member` VALUES ('2', '李四', '男', '上海', '4', 'lisi@test.com', '2022-07-22 08:48:07', '100', '18900011000', '12345678');
INSERT INTO `member` VALUES ('3', '王五', '男', '深圳', '5', 'wangwu@test.com', '2022-07-22 08:48:07', '3', '18902011000', '12345678');
INSERT INTO `member` VALUES ('4', '赵六', '女', '广州', '4', 'zhaoliu@test.com', '2022-07-22 08:48:07', '20', '18900000000', '12345678');
INSERT INTO `member` VALUES ('5', '张三上', '男', '长沙', '4', 'tianqi@test.com', '2022-07-22 08:48:07', '30', '18902011500', '12345678');
INSERT INTO `member` VALUES ('6', '黄八', '女', '北京', '4', 'huangba@test.com', '2022-07-22 08:48:07', '0', '18902011040', '12345678');
