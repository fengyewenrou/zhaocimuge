drop table if exists `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(10) NOT NULL COMMENT '菜单编号 ',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称 ',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标 ',
  `levels` char(1) NOT NULL COMMENT '层级',
  `urls` varchar(120) DEFAULT NULL COMMENT '地址',
  `sort` char(3) DEFAULT NULL COMMENT '排序',
  `memo` varchar(250) DEFAULT NULL COMMENT '备注',
  `parent_code` char(10) NOT NULL COMMENT '父节点',
  `is_leaf` char(1) DEFAULT '1' COMMENT '是否节点',
  `is_used` char(1) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('10','管理菜单','main_40.gif','0','','','','root','0');

INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1001','客户相关','main_47.gif','1','','1','','10','0');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1005','订单管理','main_47.gif','1','','2','','10','0');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1002','员工相关','main_47.gif','1','','4','','10','0');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1003','产品管理','main_47.gif','1','','3','','10','0');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1004','管理员'  ,'main_47.gif','1','','5','','10','0');

INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1001001','客户信息','left.gif','2','customer/info/list.html','1','','1001','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1001002','客户分配','left.gif','2','customer/asigns/list.html','2','','1001','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1001003','客户关怀','left.gif','2','customer/care/list.html','3','','1001','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1001004','客户类型','left.gif','2','customer/type/list.html','4','','1001','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1001005','客户状态','left.gif','2','customer/condition/list.html','5','','1001','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1001006','客户来源','left.gif','2','customer/source/list.html','6','','1001','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1001007','联系记录','left.gif','2','customer/linkrecord/list.html','7','','1001','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1001008','联系人','left.gif','2','customer/linkman/list.html','8','','1001','1');

INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1002001','员工信息','left.gif','2','users/userlist.html','1','','1002','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1002002','部门信息','left.gif','2','users/departlist.html','2','','1002','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1002003','公  告','left.gif','2','users/noticelist.html','3','','1002','1');

INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1003001','车场信息','left.gif','2','products/parking/list.html','1','','1003','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1003002','车场属性','left.gif','2','products/parking/attri/list.html','2','','1003','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1003003','轮播活动','left.gif','2','products/carlife/eventpage/list.html','3','','1003','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1003004','服务信息','left.gif','2','products/carlife/srvinfo/list.html','4','','1003','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1003005','车场服务费','left.gif','2','products/carlife/srvbilling/list.html','5','','1003','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1003006','优惠券','left.gif','2','products/coupon/list.html','6','','1003','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1003007','意见反馈','left.gif','2','products/feelback/list.html','7','','1003','1');

INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1004001','添加员工','left.gif','2','users/useradd.html','1','','1004','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1004002','添加部门','left.gif','2','users/departadd.html','2','','1004','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1004003','角色信息','left.gif','2','users/rolelist.html','3','','1004','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1004004','字典管理','left.gif','2','system/dict/list.html','4','','1004','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1004005','广播消息','left.gif','2','system/msgpub/list.html','5','','1004','1');
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1004006','短信发送','left.gif','2','system/sms/list.html','6','','1004','1');

INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES ('1005001','订单信息','left.gif','2','products/order/list.html','1','','1005','1');
