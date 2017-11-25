DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `role_power` int(10) DEFAULT NULL COMMENT '角色权限',
  `is_used` varchar(10) DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `t_user_role` VALUES ('1', '超级管理员', '1', '1');
INSERT INTO `t_user_role` VALUES ('2', '小区管理员', '2', '1');
INSERT INTO `t_user_role` VALUES ('3', '客服', '3', '1');
INSERT INTO `t_user_role` VALUES ('4', '代泊员主管', '4', '1');
INSERT INTO `t_user_role` VALUES ('5', '高级代泊员', '5', '1');
INSERT INTO `t_user_role` VALUES ('6', '初级代泊员', '6', '1');