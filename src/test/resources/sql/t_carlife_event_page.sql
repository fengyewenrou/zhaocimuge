drop table if exists T_CARLIFE_EVENT_PAGE;

/*==============================================================*/
/* Table: T_CARLIFE_EVENT_PAGE                                  */
/*==============================================================*/
create table T_CARLIFE_EVENT_PAGE
(
   ID                   int(10) not null auto_increment,
   TITLE                varchar(50) comment '标题',
   IMAGE_PATH           varchar(100) not null comment '图片路径',
   IMAGE_LINK           varchar(255) comment '图片链接',
   IMAGE_TYPE           char(1) not null comment '图片分类，1=轮播图，2=车管家',
   SORT                 varchar(3) comment '排序',
   IS_USED              char(1) not null comment '是否可用',
   CREATEOR             varchar(30) not null comment '创建人',
   MODIFIED             varchar(30) comment '修改人',
   CREATE_DATE          datetime not null comment '创建日期',
   MODIFY_DATE          datetime comment '修改日期',
   primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_CARLIFE_EVENT_PAGE comment '车管家轮播活动页';
