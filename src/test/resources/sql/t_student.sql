/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2014-09-19 17:14:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `STU_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '学生主键ID',
  `STU_NAME` varchar(20) NOT NULL COMMENT '学生姓名',
  UNIQUE KEY `INDEX_STU_ID` (`STU_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '张三');
INSERT INTO `t_student` VALUES ('2', '李四');
INSERT INTO `t_student` VALUES ('3', '王五');
