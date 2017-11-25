drop table if exists T_DICTIONARY;

/*==============================================================*/
/* Table: T_DICTIONARY                                          */
/*==============================================================*/
create table T_DICTIONARY
(
   ID                   int(10) not null auto_increment,
   DICT_CODE            varchar(30) not null comment '代码',
   DICT_NAME            varchar(80) not null comment '名称',
   DICT_VALUE           varchar(30) not null comment '属性值',
   MEMO                 varchar(100) comment '备注',
   IS_USED              char(1) not null comment '是否可用',
   CREATEOR             varchar(30) not null comment '创建人',
   MODIFIED             varchar(30) comment '修改人',
   CREATE_DATE          datetime not null comment '创建日期',
   MODIFY_DATE          datetime comment '修改日期',
   primary key (ID)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

alter table T_DICTIONARY comment '数据字典表';
insert into T_DICTIONARY (DICT_CODE,DICT_NAME,DICT_VALUE,MEMO,IS_USED,CREATEOR,CREATE_DATE) values 
	('customer_type','私营业主','1','客户信息表客户类型','1','admin',current_timestamp()),
	('customer_type','事业单位','2','客户信息表客户类型','1','admin',current_timestamp()),
	('customer_type','企业单位','3','客户信息表客户类型','1','admin',current_timestamp()),
	('customer_type','其他','4','客户信息表客户类型','1','admin',current_timestamp()),
	('customer_level','普通','1','客户信息表客户等级','1','admin',current_timestamp()),
	('customer_level','白银','2','客户信息表客户等级','1','admin',current_timestamp()),
	('customer_level','黄金','3','客户信息表客户等级','1','admin',current_timestamp()),
	('customer_level','白金','4','客户信息表客户等级','1','admin',current_timestamp()),
	('customer_level','钻石','5','客户信息表客户等级','1','admin',current_timestamp()),
	('customer_job','私营业主','1','客户信息表职业','1','admin',current_timestamp()),
	('customer_job','事业单位','2','客户信息表职业','1','admin',current_timestamp()),
	('customer_job','企业单位','3','客户信息表职业','1','admin',current_timestamp()),
	('customer_job','其他','4','客户信息表职业','1','admin',current_timestamp()),
	('sex','男','1','性别','1','admin',current_timestamp()),
	('sex','女','2','性别','1','admin',current_timestamp()),
	('sex','未知','3','性别','1','admin',current_timestamp()),
	('customer_source','手机APP','app','客户信息表客户来源','1','admin',current_timestamp()),
	('customer_source','客服中心','csr','客户信息表客户来源','1','admin',current_timestamp()),
	('customer_source','微信','weixin','客户信息表客户来源','1','admin',current_timestamp()),
	('srv_type','保养类','10','服务信息表服务类型','1','admin',current_timestamp()),
	('srv_type','咨询类','11','服务信息表服务类型','1','admin',current_timestamp()),
	('car_type','轿车','1','车场服务计费表车型','1','admin',current_timestamp()),
	('car_type','商务车','2','车场服务计费表车型','1','admin',current_timestamp()),
	('coupon_status','未过期未领取','100101','优惠券表--优惠券状态','1','admin',current_timestamp()),
	('coupon_status','未过期已领取未使用','100201','优惠券表--优惠券状态','1','admin',current_timestamp()),
	('coupon_status','未过期已领取已使用','100202','优惠券表--优惠券状态','1','admin',current_timestamp()),
	('coupon_status','已过期未领取','200101','优惠券表--优惠券状态','1','admin',current_timestamp()),
	('coupon_kind','通用券','10','优惠券表--优惠券种类','1','admin',current_timestamp()),
	('coupon_kind','月租产权券','11','优惠券表--优惠券种类','1','admin',current_timestamp()),
	('coupon_kind','停车券','12','优惠券表--优惠券种类','1','admin',current_timestamp()),
	('coupon_kind','代泊券','13','优惠券表--优惠券种类','1','admin',current_timestamp()),
	('coupon_type','定额','1','优惠券表--优惠券类型','1','admin',current_timestamp()),
	('coupon_type','折扣','2','优惠券表--优惠券种类','1','admin',current_timestamp()),
	('order_state','已预约','1','用户预约--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','已接车','2','泊车员 接受订单接口--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','已交车','3','泊车员 接车，拍照上传车辆信息--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','已停车','4','泊车员 订停车拍照留证据--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','已完成','5','泊车员 用户取车(停车结束)--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','已取车','6','--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','已拒绝','7','泊车员 拒绝泊车--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','待取车','8','用户 我要取车--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','提车中','9','APP端临停车辆订单获取服务--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','未付款','10','共享--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','已付款','11','共享--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp()),
	('order_state','已取消','12','共享--订单表订单状态（代泊、临停、共享临停）','1','admin',current_timestamp())



