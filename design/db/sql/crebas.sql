/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/11/29 19:11:24                          */
/*==============================================================*/


drop table if exists CG_DOMAIN;

drop table if exists CG_META_COM;

drop table if exists CG_META_COM_PROP;

drop table if exists CG_META_COM_PROP_GROUP;

drop table if exists CG_META_COM_PROP_GROUP_REL;

drop table if exists CG_META_COM_PROP_REL;

drop table if exists CG_META_COM_REL;

drop table if exists CG_OBJECT_PROP;

/*==============================================================*/
/* Table: CG_DOMAIN                                             */
/*==============================================================*/
create table CG_DOMAIN
(
   id                   varchar(32) not null comment '逻辑主键',
   domainCode           varchar(32) not null comment '域编码',
   domainName           varchar(64) not null comment '域名',
   domainType           varchar(32) comment '域类型，字段级、通用组件级、页面级别',
   comCode              varchar(32) comment '组件编码',
   parentDomainCode     varchar(32) comment '父级域编码',
   domainRelaType       varchar(32) comment '域关联类型，页面，字段，等，基本属性',
   define               text comment '域属性，存的为json表达式',
   enable               varchar(8) comment '是否启用',
   remark               varchar(1024) comment '备注',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (id)
);

alter table CG_DOMAIN comment 'CG DOMAIN

域，同物理模型中的域的概念，同Java中的实例的概念。
一个组';

/*==============================================================*/
/* Table: CG_META_COM                                           */
/*==============================================================*/
create table CG_META_COM
(
   id                   varchar(32) not null comment '逻辑主键',
   comCode              varchar(32) not null comment '组件编码',
   comName              varchar(64) not null comment '组件名称',
   comType              varchar(32) comment '组件类型，form，table，input，button',
   enable               varchar(8) comment '是否启用',
   remark               varchar(1024) comment '备注',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (id)
);

alter table CG_META_COM comment 'CG META COMPONENT
组件的元数据';

/*==============================================================*/
/* Table: CG_META_COM_PROP                                      */
/*==============================================================*/
create table CG_META_COM_PROP
(
   id                   varchar(32) not null comment '逻辑主键',
   propCode             varchar(32) not null comment '属性编码',
   propName             varchar(64) not null comment '属性名称',
   propValueType        varchar(256) comment '属性值类型,string/number',
   propTypeDomain       varchar(32) comment '属性类型域，true false，left/center/right	l',
   defaultValue         varchar(256) comment '默认值',
   enable               varchar(8) comment '是否启用',
   domType              varchar(32) comment 'DOM中的类型,属性，还是事件',
   sort                 int comment '排序',
   remark               varchar(1024) comment '备注',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (id)
);

alter table CG_META_COM_PROP comment 'CG COMPONENT PROPERTY META
组件属性元数据';

/*==============================================================*/
/* Table: CG_META_COM_PROP_GROUP                                */
/*==============================================================*/
create table CG_META_COM_PROP_GROUP
(
   ID                   varchar(32) not null comment '逻辑主键',
   groupCode            varchar(32) not null comment '分组编码',
   groupName            varchar(64) not null comment '分组名称',
   groupType            char(10) comment '分组类型',
   enable               varchar(8) comment '是否启用',
   sort                 int comment '排序',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (ID)
);

alter table CG_META_COM_PROP_GROUP comment 'CG COMPONENT PROPERTY META GROUP
组件属性元数据分组';

/*==============================================================*/
/* Table: CG_META_COM_PROP_GROUP_REL                            */
/*==============================================================*/
create table CG_META_COM_PROP_GROUP_REL
(
   ID                   varchar(32) not null comment '逻辑主键',
   cgId                 varchar(32) comment '逻辑主键',
   propCode             varchar(32) not null comment '属性编码',
   groupCode            varchar(32) not null comment '分组编码',
   sort                 int comment '排序',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (ID)
);

alter table CG_META_COM_PROP_GROUP_REL comment 'CG COMPONENT PROPERTY META GROUP RELATION
组件属性元数据分组关联';

/*==============================================================*/
/* Table: CG_META_COM_PROP_REL                                  */
/*==============================================================*/
create table CG_META_COM_PROP_REL
(
   ID                   varchar(32) not null comment '逻辑主键',
   cgId                 varchar(32) comment '逻辑主键',
   cgId2                varchar(32) comment '逻辑主键',
   comCode              varchar(32) not null comment '组件编码',
   propCode             varchar(32) not null comment '属性编码',
   relaType             varchar(32) not null comment '关联类型,form表单，查询按钮，table列，table操作按钮等',
   sort                 int comment '排序',
   remark               varchar(1024) comment '备注',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (ID)
);

alter table CG_META_COM_PROP_REL comment 'CG COMPONENT PROPERTY META RELATION
组件属性元数据-组件元数据关联';

/*==============================================================*/
/* Table: CG_META_COM_REL                                       */
/*==============================================================*/
create table CG_META_COM_REL
(
   ID                   varchar(32) not null comment '逻辑主键',
   cgId                 varchar(32) comment '逻辑主键',
   comCode              varchar(32) not null comment '组件编码',
   parentComCode        varchar(32) not null comment '上级名称',
   sort                 int comment '排序',
   remark               varchar(1024) comment '备注',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (ID)
);

alter table CG_META_COM_REL comment 'CG META COMPONENT RELATION
组件关联，用来描述组件组件之间的关系，例如form的子';

/*==============================================================*/
/* Table: CG_OBJECT_PROP                                        */
/*==============================================================*/
create table CG_OBJECT_PROP
(
   id                   varchar(32) not null comment '逻辑主键',
   propCode             varchar(32) not null comment '属性编码',
   propValue            varchar(64) not null comment '属性值',
   propType             varchar(32) comment '属性类型，String，int等',
   objectType           varchar(32) comment '对象类型，域，字段，页面等',
   objectCode           varchar(32) comment '对象编码',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (id)
);

alter table CG_OBJECT_PROP comment 'CG OBJECT PROPERTY 
对象属性，包含页面对象、字段对象、域对象等';

alter table CG_DOMAIN add constraint FK_relationship6 foreign key (id)
      references CG_META_COM (id) on delete restrict on update restrict;

alter table CG_META_COM_PROP_GROUP_REL add constraint FK_relationship1 foreign key (ID)
      references CG_META_COM_PROP_GROUP (ID) on delete restrict on update restrict;

alter table CG_META_COM_PROP_GROUP_REL add constraint FK_relationship2 foreign key (cgId)
      references CG_META_COM_PROP (id) on delete restrict on update restrict;

alter table CG_META_COM_PROP_REL add constraint FK_relationship3 foreign key (cgId)
      references CG_META_COM_PROP (id) on delete restrict on update restrict;

alter table CG_META_COM_PROP_REL add constraint FK_relationship4 foreign key (cgId2)
      references CG_META_COM (id) on delete restrict on update restrict;

alter table CG_META_COM_REL add constraint FK_relationship5 foreign key (cgId)
      references CG_META_COM (id) on delete restrict on update restrict;

alter table CG_OBJECT_PROP add constraint FK_relationship12 foreign key (id)
      references CG_DOMAIN (id) on delete restrict on update restrict;

