drop table if exists T_PAYMENT_INFO;

/*==============================================================*/
/* Table: T_PAYMENT_INFO                                        */
/*==============================================================*/
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