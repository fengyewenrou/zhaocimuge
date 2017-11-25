drop table if exists `t_menu_role`;
CREATE TABLE `t_menu_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(10) NOT NULL COMMENT '菜单编号 ',
  `role_name` varchar(20) NOT NULL COMMENT '角色名称 ',
  `role_power` varchar(2) NOT NULL COMMENT '角色权限 ',
  `memo` varchar(250) DEFAULT NULL COMMENT '备注',
  `is_used` char(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 超级管理员
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1002','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1004','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1005','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001001','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001002','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001003','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001004','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001005','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001006','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001007','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001008','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1002001','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1002002','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1002003','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003001','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003002','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003003','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003004','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003005','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003006','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003007','超级管理员','1','','1');	
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1004001','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1004002','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1004003','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1004004','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1004005','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1004006','超级管理员','1','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1005001','超级管理员','1','','1');

INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1002','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1004','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1005','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001001','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001002','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001003','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001004','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001005','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001006','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001007','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001008','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1002001','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1002002','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003001','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1004001','小区管理员','2','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1005001','小区管理员','2','','1');


INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1002','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1005','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001001','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001002','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001003','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001004','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001005','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001006','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001007','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1001008','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1002001','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1003001','CSR','3','','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES ('1005001','CSR','3','','1');