drop table if exists `t_parking_info`;
CREATE TABLE `t_parking_info` (
   id                   int(12)      not null auto_increment,
   parking_code         varchar(50)  not null comment '车场代码',
   parking_name         varchar(50)  not null comment '车场名称',
   parking_country      varchar(50)  comment '国家',
   parking_province     varchar(50)  comment '省',
   parking_city         varchar(50)  comment '市',
   parking_county       varchar(50)  comment '县',
   parking_area         varchar(50)  comment '小区',
   parking_address      varchar(50)  comment '地址',
   parking_latitude     varchar(50)  default 0 comment '经度',
   parking_longitude    varchar(50)  default 0 comment '纬度',
   parking_count        int(6)       default 0 comment '车位数',
   parking_can_use      int(6)       default 0 comment '空位数',
   parking_status       varchar(6)   comment '车位状态',
   parking_info         varchar(255) comment '车场简介',
   parking_path         varchar(255) comment '车场照片路径',
   is_used              varchar(1)   DEFAULT '1' COMMENT '是否有效',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
drop table if exists `t_parking_attribute`;
CREATE TABLE `t_parking_attribute` (
   id                   int(12)     not null auto_increment,
   attribute_code       varchar(50) not null comment '属性代码',
   attribute_name       varchar(50) not null comment '属性名称',
   memo                 varchar(50) not null comment '备注',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
drop table if exists `t_parking_attribute_rel`;
CREATE TABLE `t_parking_attribute_rel` (
   id                 int(12)     not null auto_increment,
   parking_code       varchar(50) not null comment '车场代码',
   attribute_code     varchar(50) not null comment '属性代码',
   attribute_value    varchar(50) not null comment '属性代码',
   memo               varchar(50) not null comment '备注',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


   charge_type      int(1) comment '收费类型(1、时间 2、按次)',
   price_times             decimal(5,2) default 0 comment '按次数收费',
   price_max             decimal(5,2) comment '封顶费用',
   discount              int(2) default 0 comment '折扣',
   isIn            int(1) comment '是否入场（1：待入场 2：已入场）',
   can_use            int(1)(10) comment '是否可代泊（1：不可代泊 2：可代泊）',
   is_direct          int(1) comment '1：直连 2：非直连',
   is_cooperate          int(1) comment '1:合作2：非合作',
   is_open          int(1) comment '1：开放2：非开改',
   is_index          int(1) comment '1：首屏2：非首屏',