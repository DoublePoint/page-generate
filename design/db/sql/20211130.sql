/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/11/30 14:32:49                          */
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
   ID                   varchar(32) not null comment '逻辑主键',
   DOMAIN_CODE          varchar(32) not null comment '域编码',
   DOMAIN_NAME          varchar(64) not null comment '域名',
   DOMAIN_TYPE          varchar(32) comment '域类型，字段级、通用组件级、页面级别',
   COM_CODE             varchar(32) comment '组件编码',
   PARENT_DOMAIN_CODE   varchar(32) comment '父级域编码',
   DOMAIN_RELA_TYPE     varchar(32) comment '域关联类型，页面，字段，等，基本属性',
   DEFINE               text comment '域属性，存的为json表达式',
   ENABLE               varchar(8) comment '是否启用',
   REMARK               varchar(1024) comment '备注',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
   primary key (ID)
);

alter table CG_DOMAIN comment 'CG DOMAIN

域，同物理模型中的域的概念，同Java中的实例的概念。
一个组';

/*==============================================================*/
/* Table: CG_META_COM                                           */
/*==============================================================*/
create table CG_META_COM
(
   ID                   varchar(32) not null comment '逻辑主键',
   COM_CODE             varchar(32) not null comment '组件编码',
   COM_NAME             varchar(64) not null comment '组件名称',
   COM_TYPE             varchar(32) comment '组件类型，form，table，input，button',
   ENABLE               varchar(8) comment '是否启用',
   REMARK               varchar(1024) comment '备注',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
   primary key (ID)
);

alter table CG_META_COM comment 'CG META COMPONENT
组件的元数据';

/*==============================================================*/
/* Table: CG_META_COM_PROP                                      */
/*==============================================================*/
create table CG_META_COM_PROP
(
   ID                   varchar(32) not null comment '逻辑主键',
   PROP_CODE            varchar(32) not null comment '属性编码',
   PROP_NAME            varchar(64) not null comment '属性名称',
   PROP_VALUE_TYPE      varchar(256) comment '属性值类型,string/number',
   PROP_TYPE_DOMAIN     varchar(32) comment '属性类型域，true false，left/center/right	l',
   DEFAULT_VALUE        varchar(256) comment '默认值',
   ENABLE               varchar(8) comment '是否启用',
   DOM_TYPE             varchar(32) comment 'DOM中的类型,属性，还是事件',
   SORT                 int comment '排序',
   REMARK               varchar(1024) comment '备注',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
   primary key (ID)
);

alter table CG_META_COM_PROP comment 'CG COMPONENT PROPERTY META
组件属性元数据';

/*==============================================================*/
/* Table: CG_META_COM_PROP_GROUP                                */
/*==============================================================*/
create table CG_META_COM_PROP_GROUP
(
   ID                   varchar(32) not null comment '逻辑主键',
   GROUP_CODE           varchar(32) not null comment '分组编码',
   GROUP_NAME           varchar(64) not null comment '分组名称',
   GROUP_TYPE           char(10) comment '分组类型',
   ENABLE               varchar(8) comment '是否启用',
   SORT                 int comment '排序',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
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
   PROP_CODE            varchar(32) not null comment '属性编码',
   GROUP_CODE           varchar(32) not null comment '分组编码',
   SORT                 int comment '排序',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
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
   COM_CODE             varchar(32) not null comment '组件编码',
   PROP_CODE            varchar(32) not null comment '属性编码',
   RELA_TYPE            varchar(32) not null comment '关联类型,form表单，查询按钮，table列，table操作按钮等',
   SORT                 int comment '排序',
   REMARK               varchar(1024) comment '备注',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
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
   CG__ID               varchar(32) comment '逻辑主键',
   COM_CODE             varchar(32) not null comment '组件编码',
   PARENT_COM_CODE      varchar(32) not null comment '上级名称',
   SORT                 int comment '排序',
   REMARK               varchar(1024) comment '备注',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
   primary key (ID)
);

alter table CG_META_COM_REL comment 'CG META COMPONENT RELATION
组件关联，用来描述组件组件之间的关系，例如form的子';

/*==============================================================*/
/* Table: CG_OBJECT_PROP                                        */
/*==============================================================*/
create table CG_OBJECT_PROP
(
   ID                   varchar(32) not null comment '逻辑主键',
   PROP_CODE            varchar(32) not null comment '属性编码',
   PROP_VALUE           varchar(64) not null comment '属性值',
   PROP_TYPE            varchar(32) comment '属性类型，String，int等',
   OBJECT_TYPE          varchar(32) comment '对象类型，域，字段，页面等',
   OBJECT_CODE          varchar(32) comment '对象编码',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
   primary key (ID)
);

alter table CG_OBJECT_PROP comment 'CG OBJECT PROPERTY 
对象属性，包含页面对象、字段对象、域对象等';

alter table CG_DOMAIN add constraint FK_RELATIONSHIP_6 foreign key (ID)
      references CG_META_COM (ID) on delete restrict on update restrict;

alter table CG_META_COM_PROP_GROUP_REL add constraint FK_RELATIONSHIP_1 foreign key (ID)
      references CG_META_COM_PROP_GROUP (ID) on delete restrict on update restrict;

alter table CG_META_COM_PROP_GROUP_REL add constraint FK_RELATIONSHIP_2 foreign key ()
      references CG_META_COM_PROP (ID) on delete restrict on update restrict;

alter table CG_META_COM_PROP_REL add constraint FK_RELATIONSHIP_3 foreign key ()
      references CG_META_COM_PROP (ID) on delete restrict on update restrict;

alter table CG_META_COM_PROP_REL add constraint FK_RELATIONSHIP_4 foreign key ()
      references CG_META_COM (ID) on delete restrict on update restrict;

alter table CG_META_COM_REL add constraint FK_RELATIONSHIP_5 foreign key (CG__ID)
      references CG_META_COM (ID) on delete restrict on update restrict;

alter table CG_OBJECT_PROP add constraint FK_RELATIONSHIP_12 foreign key (ID)
      references CG_DOMAIN (ID) on delete restrict on update restrict;

