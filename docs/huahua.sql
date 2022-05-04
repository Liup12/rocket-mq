/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : huahua

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2022-05-04 21:49:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message_log
-- ----------------------------
DROP TABLE IF EXISTS `message_log`;
CREATE TABLE `message_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `biz_id` varchar(36) NOT NULL COMMENT '业务ID',
  `topic` varchar(36) NOT NULL COMMENT '消息投递topic',
  `tag` varchar(36) DEFAULT NULL COMMENT '消息标签tag',
  `status` int NOT NULL DEFAULT '0' COMMENT '消息状态(0: 已投递，1，消费成功，2，消费失败，-1 超时作废，-2 投递失败)',
  `message` text NOT NULL COMMENT '消息体',
  `retry_time` timestamp NULL DEFAULT NULL COMMENT '重试时间',
  `retry_count` int DEFAULT NULL COMMENT '重试次数',
  `gmt_create` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of message_log
-- ----------------------------
INSERT INTO `message_log` VALUES ('1', 'db616659-f0c0-4ccb-9763-6ec7f41cec6b', 'test-topic', '333', '1', '{\"bizId\":\"db616659-f0c0-4ccb-9763-6ec7f41cec6b\",\"object\":\"123\"}', null, '0', '2022-05-03 14:03:12', null);
INSERT INTO `message_log` VALUES ('2', '2296bc0e-6cf6-4e4d-9cc8-0ec73691502c', 'test-topic', '333', '1', '{\"bizId\":\"2296bc0e-6cf6-4e4d-9cc8-0ec73691502c\",\"body\":\"123\"}', null, '0', '2022-05-03 14:30:41', null);
INSERT INTO `message_log` VALUES ('3', '36016cb9-33d6-4928-b446-fd4e22b4e961', 'message-topic', '333', '1', '{\"bizId\":\"36016cb9-33d6-4928-b446-fd4e22b4e961\",\"body\":\"123\"}', null, '0', '2022-05-03 14:33:37', null);
INSERT INTO `message_log` VALUES ('4', 'e298786c-1a56-42f6-8a89-d4784fd94779', 'message-topic', '333', '1', '{\"bizId\":\"e298786c-1a56-42f6-8a89-d4784fd94779\",\"body\":\"123\"}', null, '0', '2022-05-03 14:46:58', null);
INSERT INTO `message_log` VALUES ('5', 'ffdd6893-389e-47f5-9710-7788221f8670', 'message-topic', '333', '1', '{\"bizId\":\"ffdd6893-389e-47f5-9710-7788221f8670\",\"body\":\"123\"}', null, '0', '2022-05-03 14:53:33', null);
INSERT INTO `message_log` VALUES ('6', '983611fa-a957-46db-9628-c1fa8af6a1d8', 'message-topic', '333', '1', '{\"bizId\":\"983611fa-a957-46db-9628-c1fa8af6a1d8\",\"body\":\"123\"}', null, '0', '2022-05-03 14:59:35', null);
INSERT INTO `message_log` VALUES ('7', '191d983a-2cf2-4bd0-8279-1e7ad4bf57a1', 'message-topic', '333', '1', '{\"bizId\":\"191d983a-2cf2-4bd0-8279-1e7ad4bf57a1\",\"body\":\"123\"}', null, '0', '2022-05-03 15:00:14', null);
INSERT INTO `message_log` VALUES ('8', 'a0ae1c00-f8ba-4b52-89d0-12d5c28f736b', 'message-topic', '333', '1', '{\"bizId\":\"a0ae1c00-f8ba-4b52-89d0-12d5c28f736b\",\"body\":\"123\"}', null, '0', '2022-05-03 15:00:53', null);
INSERT INTO `message_log` VALUES ('9', '94d172bb-6092-4969-b1b4-cc44b7d6a8f2', 'message-topic', '333', '1', '{\"bizId\":\"94d172bb-6092-4969-b1b4-cc44b7d6a8f2\",\"body\":\"123\"}', null, '0', '2022-05-03 17:01:57', null);
INSERT INTO `message_log` VALUES ('10', 'ee14d45e-cbdb-4f43-9acc-63c68afa8e4d', 'message-topic', '333', '1', '{\"bizId\":\"ee14d45e-cbdb-4f43-9acc-63c68afa8e4d\",\"body\":\"123\"}', null, '0', '2022-05-03 17:02:42', null);
INSERT INTO `message_log` VALUES ('11', '063a3e1b-8cb5-4d2d-9c1d-3cd3344c453a', 'message-topic', '333', '1', '{\"bizId\":\"063a3e1b-8cb5-4d2d-9c1d-3cd3344c453a\",\"body\":\"123\"}', null, '0', '2022-05-03 17:03:25', null);
INSERT INTO `message_log` VALUES ('12', 'b7941d5b-390b-4087-b58a-139b927dfb30', 'message-topic', '333', '1', '{\"bizId\":\"b7941d5b-390b-4087-b58a-139b927dfb30\",\"body\":\"3456\"}', null, '0', '2022-05-03 17:03:47', null);
INSERT INTO `message_log` VALUES ('13', '2d1b2a1f-6720-4466-9ae7-5a0474b49002', 'message-topic', '333', '1', '{\"bizId\":\"2d1b2a1f-6720-4466-9ae7-5a0474b49002\",\"body\":\"3456\"}', null, '0', '2022-05-03 17:05:46', null);
INSERT INTO `message_log` VALUES ('14', '1e4a2595-5343-45ed-bba6-1a76cecb4c0f', 'message-topic', '333', '1', '{\"bizId\":\"1e4a2595-5343-45ed-bba6-1a76cecb4c0f\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:06:11', null);
INSERT INTO `message_log` VALUES ('15', '99b58724-4532-4e14-8feb-74666f29d5e7', 'message-topic', '333', '1', '{\"bizId\":\"99b58724-4532-4e14-8feb-74666f29d5e7\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:06:59', null);
INSERT INTO `message_log` VALUES ('16', '214f3e07-e27c-483c-b617-14f9e71547e8', 'message-topic', '333', '1', '{\"bizId\":\"214f3e07-e27c-483c-b617-14f9e71547e8\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:08:18', null);
INSERT INTO `message_log` VALUES ('17', 'cbe23bdb-3039-4848-9edb-87a5d1fd0d36', 'message-topic', '333', '1', '{\"bizId\":\"cbe23bdb-3039-4848-9edb-87a5d1fd0d36\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:08:48', null);
INSERT INTO `message_log` VALUES ('18', '6f7a0409-a0f1-44f9-a2b3-e42f2e4b6374', 'message-topic', '333', '1', '{\"bizId\":\"6f7a0409-a0f1-44f9-a2b3-e42f2e4b6374\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:10:47', null);
INSERT INTO `message_log` VALUES ('19', '2e19c607-4b8b-495b-bb4b-0ae26f73ae44', 'message-topic', '333', '1', '{\"bizId\":\"2e19c607-4b8b-495b-bb4b-0ae26f73ae44\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:12:30', null);
INSERT INTO `message_log` VALUES ('20', 'ce364713-9dd4-4e5c-9056-ea337ea1c36b', 'message-topic', '333', '1', '{\"bizId\":\"ce364713-9dd4-4e5c-9056-ea337ea1c36b\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:13:53', null);
INSERT INTO `message_log` VALUES ('21', '0fc74011-ca8a-477d-88c3-7b0ef7e13309', 'message-topic', '333', '1', '{\"bizId\":\"0fc74011-ca8a-477d-88c3-7b0ef7e13309\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:15:45', null);
INSERT INTO `message_log` VALUES ('22', '46c5efc2-1ac9-48e0-9177-2ff0f431380a', 'message-topic', '333', '1', '{\"bizId\":\"46c5efc2-1ac9-48e0-9177-2ff0f431380a\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:20:26', null);
INSERT INTO `message_log` VALUES ('23', '80a8ba37-91e9-4457-b861-531c6c3c4cac', 'message-topic', '333', '1', '{\"bizId\":\"80a8ba37-91e9-4457-b861-531c6c3c4cac\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:21:01', null);
INSERT INTO `message_log` VALUES ('24', 'd2dd3717-56e0-485b-b6bb-40aec3192347', 'message-topic', '333', '2', '{\"bizId\":\"d2dd3717-56e0-485b-b6bb-40aec3192347\",\"body\":\"34564\"}', null, '0', '2022-05-03 17:22:33', null);
