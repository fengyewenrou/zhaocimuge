drop table if exists T_CARLIFE_SRV_NEWTAG;

/*==============================================================*/
/* Table: T_CARLIFE_SRV_NEWTAG                                  */
/*==============================================================*/
create table T_CARLIFE_SRV_NEWTAG
(
   ID                   int(10) not null auto_increment,
   CUSTOMER_ID          varchar(50) not null comment '客户ID',
   SRV_ID               int(10) not null comment '服务ID',
   FLAG                 char(10) not null comment '标签已点击值为1',
   IS_USED              char(1) not null comment '是否可用',
   CREATEOR             varchar(30) not null comment '创建人',
   MODIFIED             varchar(30) comment '修改人',
   CREATE_DATE          datetime not null comment '创建日期',
   MODIFY_DATE          datetime comment '修改日期',
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_CARLIFE_SRV_NEWTAG comment '新服务提醒标签';
