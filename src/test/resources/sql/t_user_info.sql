DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `department_id` int(10) DEFAULT NULL COMMENT '部门编号',
  `role_id` int(10) DEFAULT NULL COMMENT '角色编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `user_sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `user_mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `user_age` int(10) DEFAULT NULL COMMENT '年龄',
  `user_address` varchar(500) DEFAULT NULL COMMENT '地址',
  `user_num` varchar(100) DEFAULT NULL COMMENT '用户账号',
  `user_pw` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `user_tel` varchar(20) DEFAULT NULL COMMENT '座机',
  `user_idnum` varchar(20) DEFAULT NULL COMMENT '户份证号码',
  `user_email` varchar(100) DEFAULT NULL COMMENT 'email',
  `user_addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  `user_addman` varchar(50) DEFAULT NULL COMMENT '添加人',
  `user_changetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'  COMMENT '修改时间',
  `user_changeman` varchar(50) DEFAULT NULL COMMENT '修改人',
  `user_intest` varchar(1000) DEFAULT NULL COMMENT '兴趣爱好',
  `user_diploma` varchar(20) DEFAULT NULL COMMENT '学历',
  `user_bankcard` varchar(20) DEFAULT NULL COMMENT '银行卡号',
  `user_nation` varchar(20) DEFAULT NULL COMMENT '种族',
  `is_married` varchar(10) DEFAULT NULL COMMENT '是否婚配',
  `is_used` varchar(10) DEFAULT '1' COMMENT '是否有效',
  `driver_age` varchar(10) DEFAULT '0' COMMENT '驾龄',
  `head` varchar(100)  COMMENT '头像',
  `driver_no` varchar(30) COMMENT '驾驶证号',
  `driver_image` varchar(100) COMMENT '驾驶证影像',
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_22` (`department_id`),
  KEY `FK_Reference_24` (`role_id`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`department_id`) REFERENCES `t_department_info` (`department_id`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`role_id`) REFERENCES `t_user_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `t_user_info` (user_id,department_id,role_id,user_name,user_sex,user_mobile,user_age,user_address,user_num,user_pw,user_tel,user_idnum,user_email,user_addtime,user_addman,user_changetime,user_changeman,user_intest,user_diploma,user_bankcard,user_nation,is_married,is_used) VALUES ('1', '3', '3', '张三', '男', '13525452584', '20', '万州', '456', 'f045cf38624d828908882e30b29a16ab', '52000112', '500234154545745474', '3797687@qq.com', '2013-05-25 09:37:18', '肉骨粉', '2013-05-25 09:31:39', '未修改', '很多', '本科', '5442232327863358787', '汉', '已婚', '1');
INSERT INTO `t_user_info` (user_id,department_id,role_id,user_name,user_sex,user_mobile,user_age,user_address,user_num,user_pw,user_tel,user_idnum,user_email,user_addtime,user_addman,user_changetime,user_changeman,user_intest,user_diploma,user_bankcard,user_nation,is_married,is_used) VALUES ('2', '2', '2', '猪八戒', '男', '13544477747', '2', '高老庄', '789', '0d8af43a6af4a40ec5f227a326df47b6', '52000112', '524154655895854744', '3963547@qq.com', '2013-05-25 09:36:59', '张三', '2013-05-25 09:29:33', '未修改', '吃西瓜', '初中', '3535355555454787887', '汉', '已婚', '1');
INSERT INTO `t_user_info` (user_id,department_id,role_id,user_name,user_sex,user_mobile,user_age,user_address,user_num,user_pw,user_tel,user_idnum,user_email,user_addtime,user_addman,user_changetime,user_changeman,user_intest,user_diploma,user_bankcard,user_nation,is_married,is_used) VALUES ('3', '2', '2', '王五', '男', '13254545454', '22', '重庆三峡学院', '123', 'f4d769c85aee9bf94270f80db6d926e1', '22323244', '522141444514744547', '87592@qq.com', '2013-05-25 09:37:07', '张三', '2013-05-25 09:29:05', '未修改', '斗地主', '本科', '2323232345555555522', '汉', '未婚', '1');
INSERT INTO `t_user_info` (user_id,department_id,role_id,user_name,user_sex,user_mobile,user_age,user_address,user_num,user_pw,user_tel,user_idnum,user_email,user_addtime,user_addman,user_changetime,user_changeman,user_intest,user_diploma,user_bankcard,user_nation,is_married,is_used) VALUES ('4', '4', '1', '孙悟空', '男', '13545454545', '55', '花果山', 'admin', 'c5ec3e029f39d699de19b6b64dce432e', '54584785', '524147444584574554', '39547@qq.com', '2013-05-25 09:37:04', '张三', '2013-05-25 09:30:14', '未修改', '吃桃子', '初中', '3535355488676754578', '汉', '离异', '1');
