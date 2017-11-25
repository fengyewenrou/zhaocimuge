drop table if exists T_CARLIFE_SRV_INFO;

/*==============================================================*/
/* Table: T_CARLIFE_SRV_INFO                                    */
/*==============================================================*/
create table T_CARLIFE_SRV_INFO
(
   ID                   int(10) not null auto_increment,
   SRV_NAME             varchar(30) not null comment '服务名称',
   LOGO_PATH            varchar(100) comment '服务logo',
   SRV_TYPE             varchar(10) comment '所属服务分类,数据字典表',
   INTRO                varchar(250) comment '服务简介',
   STATUS               char(1) not null comment '服务状态已上线1/预上线0,',
   DESCRIPTION          varchar(250) comment '服务标准介绍',
   SRV_LINK             varchar(30) comment '服务链接地址',
   IS_USED              char(1) not null comment '是否可用',
   CREATEOR             varchar(30) not null comment '创建人',
   MODIFIED             varchar(30) comment '修改人',
   CREATE_DATE          datetime not null comment '创建日期',
   MODIFY_DATE          datetime comment '修改日期',
   primary key (ID)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

alter table T_CARLIFE_SRV_INFO comment '车生活服务信息';

insert into T_CARLIFE_SRV_INFO (ID,SRV_NAME,SRV_TYPE,INTRO,STATUS,DESCRIPTION,IS_USED,CREATEOR,CREATE_DATE) values 
	(1,'违章查询','10','轻松查违章','1','轻松查违章','1','admin',current_timestamp()),
	(2,'加油卡充值','10','快速线上充值','1','快速线上充值','1','admin',current_timestamp()),
	(3,'洗车','10','洗车17元起','1','洗车17元起','1','admin',current_timestamp()),
	(4,'汽车内里清洁','10','260包你干净','1','260包你干净','1','admin',current_timestamp()),
	(5,'汽车打蜡','10','80元含3M蜡','1','80元含3M蜡','1','admin',current_timestamp()),
	(6,'新服务','10','敬请期待','1','敬请期待','1','admin',current_timestamp())
	
	
	
	
	
	
	
	
	
	