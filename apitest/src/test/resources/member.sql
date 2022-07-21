/*
Navicat MySQL Data Transfer

Source Server         : localhost_qa
Source Server Version : 50738
Source Host           : localhost:3306
Source Database       : futureloan

Target Server Type    : MYSQL
Target Server Version : 50738
File Encoding         : 65001

Date: 2022-07-21 16:38:19
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
  `mobile_phone` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '张三', '男', '南京', '4', 'zhangsan@test.com', '2022-07-21 10:50:07', '2', null);
INSERT INTO `member` VALUES ('2', '李四', '男', '上海', '4', 'lisi@test.com', '2022-07-21 16:32:09', '100', '18900011000');
INSERT INTO `member` VALUES ('3', '王五', '男', '深圳', '5', 'wangwu@test.com', '2022-07-21 10:50:15', '3', null);
INSERT INTO `member` VALUES ('4', '赵六', '女', '广州', '4', 'zhaoliu@test.com', '2022-07-21 16:37:52', '20', '18900000000');
INSERT INTO `member` VALUES ('5', '张三上', '男', '长沙', '4', 'tianqi@test.com', '2022-07-21 10:50:31', '30', null);
INSERT INTO `member` VALUES ('6', '黄八', '女', '北京', '4', 'huangba@test.com', '2022-07-21 10:50:37', '0', null);
