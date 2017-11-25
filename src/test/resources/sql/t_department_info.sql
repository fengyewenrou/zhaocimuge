CREATE TABLE `t_department_info` (
  `department_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '部门编号 ',
  `department_name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `department_desc` varchar(500) DEFAULT NULL COMMENT '部门描述',
  `is_used` varchar(10) DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `t_department_info` VALUES ('1', '产品部', '', '1');
INSERT INTO `t_department_info` VALUES ('2', '营运部', '', '1');
INSERT INTO `t_department_info` VALUES ('3', '市场部', '', '1');
INSERT INTO `t_department_info` VALUES ('4', '技术部', '', '1');