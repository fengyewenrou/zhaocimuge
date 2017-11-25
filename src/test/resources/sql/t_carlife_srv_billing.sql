drop table if exists T_CARLIFE_SRV_BILLING;

/*==============================================================*/
/* Table: T_CARLIFE_SRV_BILLING                                 */
/*==============================================================*/
create table T_CARLIFE_SRV_BILLING
(
   ID                   int(10) not null auto_increment,
   PARKING_ID           varchar(50) comment '车场ID',
   SRV_ID               int(10) comment '服务ID',
   CAR_TYPE             varchar(10) comment '车型 数据字典表',
   SRV_FEE              int(10) comment '服务费',
   SRV_PRICE            int(10) comment '服务价格',
   IS_USED              char(1) not null comment '是否可用',
   CREATEOR             varchar(30) not null comment '创建人',
   MODIFIED             varchar(30) comment '修改人',
   CREATE_DATE          datetime not null comment '创建日期',
   MODIFY_DATE          datetime comment '修改日期',
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_CARLIFE_SRV_BILLING comment '车场服务计费表';
