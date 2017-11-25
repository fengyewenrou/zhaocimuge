drop table if exists T_MESSAGE_PUB;

/*==============================================================*/
/* Table: T_MESSAGE_PUB                                         */
/*==============================================================*/
create table T_MESSAGE_PUB
(
   MESSAGE_ID           int(10) not null auto_increment,
   TITLE                varchar(255) comment '标题',
   MESSAGE              varchar(255) comment '小喇叭消息',
   MESSAGE_TWO          varchar(255) comment '消息（保留字段）',
   IS_USED              char(1) not null comment '是否可用',
   CREATEOR             varchar(30) not null comment '创建人',
   MODIFIED             varchar(30) comment '修改人',
   CREATE_DATE          datetime not null comment '创建日期',
   MODIFY_DATE          datetime comment '修改日期',
   primary key (MESSAGE_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_MESSAGE_PUB comment '小喇叭消息';