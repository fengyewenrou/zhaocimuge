-- 2016-1-21 软盈与岩卓订单表ID长度不一致
alter table t_managementfeeorderinfo    modify column id  varchar(50);
alter table t_monthlyparkingfeeorderinfo    modify column id  varchar(50);
alter table t_temporaryparkfeeorderinfo    modify column id  varchar(50);

-- 2016-1-22 添加优惠券菜单
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES 
	('1003006','优惠券','left.gif','2','products/coupon/list.html','6','','1003','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES 
	('1003006','超级管理员','1','','1');
	
-- 2016-1-22 添加优惠券字典
insert into T_DICTIONARY (DICT_CODE,DICT_NAME,DICT_VALUE,MEMO,IS_USED,CREATEOR,CREATE_DATE) values 
	('vouchers_type','停车券','1','优惠券表--通用券类型','1','admin',current_timestamp()),
	('coupon_type','定额','1','优惠券表--优惠券类型','1','admin',current_timestamp()),
	('coupon_type','折扣','2','优惠券表--优惠券类型','1','admin',current_timestamp())

-- 2016-1-22 添加优惠券字段‘领取时间’
alter table t_coupon add column receive_time varchar(30) COMMENT '领取时间'; 

-- 2016-1-26 添加短信发送菜单
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES 
	('1004006','短信发送','left.gif','2','system/sms/list.html','6','','1004','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES 
	('1004006','超级管理员','1','','1');
	
drop table if exists t_parking_ticket;
/*==============================================================*/
/* Table: t_parking_ticket                                      */
/*==============================================================*/
create table T_PARKING_TICKET
(
   ID                   int(10) not null auto_increment,
   CUSTOMER_ID          varchar(50) comment '用户ID',
   MOBILE               varchar(20) comment '用户手机号',
   START_DATE           datetime comment '有效期开始时间',
   END_DATE             datetime comment '有效期结束时间',
   CODE                 varchar(11) comment '停车码',
   IS_USED              char(1) not null comment '是否可用',
   CREATEOR             varchar(30) not null comment '创建人',
   MODIFIED             varchar(30) default NULL comment '修改人',
   CREATE_DATE          datetime not null comment '创建日期',
   MODIFY_DATE          datetime default NULL comment '修改日期',
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table T_PARKING_TICKET comment '短信推送停车券信息';

drop table if exists T_SMS;
/*==============================================================*/
/* Table: t_sms                                                 */
/*==============================================================*/
create table T_SMS
(
   RECORD_ID            int(10) not null auto_increment,
   CONTENT              varchar(300) default '' comment '推送内容',
   MOBILE               varchar(20) not null comment '手机号',
   ADD_TIME             varchar(50) not null default '0000-00-00 00:00:00' comment '添加时间',
   primary key (RECORD_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table T_PARKING_TICKET comment '短信推送信息';

alter table t_user_info modify column user_num  varchar(50);	

-- 2016-2-1 添加优惠券菜单
INSERT INTO T_MENU (menu_code,menu_name,icon,levels,urls,sort,memo,parent_code,is_leaf) VALUES 
	('1003007','意见反馈','left.gif','2','products/feelback/list.html','7','','1003','1');
INSERT INTO T_MENU_ROLE (menu_code,role_name,role_power,memo,is_used) VALUES 
	('1003007','超级管理员','1','','1');	
-- ------------------------------------------
	
-- 2016-1-27 订单类开、添加加油卡充值类型、加油卡类型
insert into T_DICTIONARY (DICT_CODE,DICT_NAME,DICT_VALUE,MEMO,IS_USED,CREATEOR,CREATE_DATE) values 
	('order_type','加油卡充值','1','订单主表订单类型','1','admin',current_timestamp()),
	('order_type','共享临停','2','订单主表订单类型','1','admin',current_timestamp()),
	('order_type','临停缴费','3','订单主表订单类型','1','admin',current_timestamp()),
	('order_type','我要代泊','4','订单主表订单类型','1','admin',current_timestamp()),
	('order_type','月租产权','5','订单主表订单类型','1','admin',current_timestamp()),
	('charge_type','中石化','1','加油卡订单表加油卡类型','1','admin',current_timestamp()),
	('charge_type','中石油','2','加油卡订单表加油卡类型','1','admin',current_timestamp()),
	('topup_type','中石化50元加油卡','10000','加油卡订单表充值类型','1','admin',current_timestamp()),
	('topup_type','中石化100元加油卡','10001','加油卡订单表充值类型','1','admin',current_timestamp()),
	('topup_type','中石化500元加油卡','10003','加油卡订单表充值类型','1','admin',current_timestamp()),
	('topup_type','中石化1000元加油卡','10004','加油卡订单表充值类型','1','admin',current_timestamp()),
	('topup_type','中石化任意金额充值','10007','加油卡订单表充值类型','1','admin',current_timestamp()),
	('topup_type','中石油任意金额充值','10008','加油卡订单表充值类型','1','admin',current_timestamp())

-- 2016-2-2
create table T_PAYMENT_INFO
(
   ID                   int(10) not null auto_increment,
   ORDER_ID             varchar(50) not null comment '订单主表ID(uuid)',
   PAY_TYPE             char(2) comment '支付类型 00:支付宝，01:微信，02:银联',
   USE_TYPE             char(1) comment '1支付请求，2支付回调',
   USE_INFO             varchar(2000) comment '支付请求信息或回调信息',
   CREATEOR             varchar(30) not null comment '创建人',
   CREATE_DATE          datetime not null comment '创建日期',
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_PAYMENT_INFO comment '支付请求回调信息表';

	
insert into T_DICTIONARY (DICT_CODE,DICT_NAME,DICT_VALUE,MEMO,IS_USED,CREATEOR,CREATE_DATE) values 
	('coupon_kind','通用券','10','优惠券表--优惠券种类','1','admin',current_timestamp()),
	('coupon_kind','月租产权券','11','优惠券表--优惠券种类','1','admin',current_timestamp()),
	('coupon_kind','停车券','12','优惠券表--优惠券种类','1','admin',current_timestamp()),
	('coupon_kind','代泊券','13','优惠券表--优惠券种类','1','admin',current_timestamp())