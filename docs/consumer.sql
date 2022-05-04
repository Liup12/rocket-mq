/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : consumer

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2022-05-04 21:48:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for consume_log
-- ----------------------------
DROP TABLE IF EXISTS `consume_log`;
CREATE TABLE `consume_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `biz_id` varchar(36) NOT NULL COMMENT '业务ID',
  `consume_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '消费时间',
  `gmt_create` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of consume_log
-- ----------------------------
