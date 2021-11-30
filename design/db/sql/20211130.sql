/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/11/30 14:13:43                          */
/*==============================================================*/


drop table if exists CgDomain;

drop table if exists CgMetaCom;

drop table if exists CgMetaComProp;

drop table if exists CgMetaComPropGroup;

drop table if exists CgMetaComPropGroupRel;

drop table if exists CgMetaComPropRel;

drop table if exists CgMetaComRel;

drop table if exists CgObjectProp;

/*==============================================================*/
/* Table: CgDomain                                              */
/*==============================================================*/
create table CgDomain
(
   ID                   varchar(32) not null comment '逻辑主键',
   DomainCode           varchar(32) not null comment '域编码',
   DomainName           varchar(64) not null comment '域名',
   DomainType           varchar(32) comment '域类型，字段级、通用组件级、页面级别',
   ComCode              varchar(32) comment '组件编码',
   ParentDomainCode     varchar(32) comment '父级域编码',
   DomainRelaType       varchar(32) comment '域关联类型，页面，字段，等，基本属性',
   DEFINE               text comment '域属性，存的为json表达式',
   ENABLE               varchar(8) comment '是否启用',
   REMARK               varchar(1024) comment '备注',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgDomain comment 'CG DOMAIN

域，同物理模型中的域的概念，同Java中的实例的概念。
一个组';

/*==============================================================*/
/* Table: CgMetaCom                                             */
/*==============================================================*/
create table CgMetaCom
(
   ID                   varchar(32) not null comment '逻辑主键',
   ComCode              varchar(32) not null comment '组件编码',
   ComName              varchar(64) not null comment '组件名称',
   ComType              varchar(32) comment '组件类型，form，table，input，button',
   ENABLE               varchar(8) comment '是否启用',
   REMARK               varchar(1024) comment '备注',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaCom comment 'CG META COMPONENT
组件的元数据';

/*==============================================================*/
/* Table: CgMetaComProp                                         */
/*==============================================================*/
create table CgMetaComProp
(
   ID                   varchar(32) not null comment '逻辑主键',
   PropCode             varchar(32) not null comment '属性编码',
   PropName             varchar(64) not null comment '属性名称',
   PropValueType        varchar(256) comment '属性值类型,string/number',
   PropTypeDomain       varchar(32) comment '属性类型域，true false，left/center/right	l',
   DefaultValue         varchar(256) comment '默认值',
   ENABLE               varchar(8) comment '是否启用',
   DomType              varchar(32) comment 'DOM中的类型,属性，还是事件',
   SORT                 int comment '排序',
   REMARK               varchar(1024) comment '备注',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaComProp comment 'CG COMPONENT PROPERTY META
组件属性元数据';

/*==============================================================*/
/* Table: CgMetaComPropGroup                                    */
/*==============================================================*/
create table CgMetaComPropGroup
(
   ID                   varchar(32) not null comment '逻辑主键',
   GroupCode            varchar(32) not null comment '分组编码',
   GroupName            varchar(64) not null comment '分组名称',
   GroupType            char(10) comment '分组类型',
   ENABLE               varchar(8) comment '是否启用',
   SORT                 int comment '排序',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaComPropGroup comment 'CG COMPONENT PROPERTY META GROUP
组件属性元数据分组';

/*==============================================================*/
/* Table: CgMetaComPropGroupRel                                 */
/*==============================================================*/
create table CgMetaComPropGroupRel
(
   ID                   varchar(32) not null comment '逻辑主键',
   PropCode             varchar(32) not null comment '属性编码',
   GroupCode            varchar(32) not null comment '分组编码',
   SORT                 int comment '排序',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaComPropGroupRel comment 'CG COMPONENT PROPERTY META GROUP RELATION
组件属性元数据分组关联';

/*==============================================================*/
/* Table: CgMetaComPropRel                                      */
/*==============================================================*/
create table CgMetaComPropRel
(
   ID                   varchar(32) not null comment '逻辑主键',
   ComCode              varchar(32) not null comment '组件编码',
   PropCode             varchar(32) not null comment '属性编码',
   RelaType             varchar(32) not null comment '关联类型,form表单，查询按钮，table列，table操作按钮等',
   SORT                 int comment '排序',
   REMARK               varchar(1024) comment '备注',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaComPropRel comment 'CG COMPONENT PROPERTY META RELATION
组件属性元数据-组件元数据关联';

/*==============================================================*/
/* Table: CgMetaComRel                                          */
/*==============================================================*/
create table CgMetaComRel
(
   ID                   varchar(32) not null comment '逻辑主键',
   CgId                 varchar(32) comment '逻辑主键',
   ComCode              varchar(32) not null comment '组件编码',
   ParentComCode        varchar(32) not null comment '上级名称',
   SORT                 int comment '排序',
   REMARK               varchar(1024) comment '备注',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaComRel comment 'CG META COMPONENT RELATION
组件关联，用来描述组件组件之间的关系，例如form的子';

/*==============================================================*/
/* Table: CgObjectProp                                          */
/*==============================================================*/
create table CgObjectProp
(
   ID                   varchar(32) not null comment '逻辑主键',
   PropCode             varchar(32) not null comment '属性编码',
   PropValue            varchar(64) not null comment '属性值',
   PropType             varchar(32) comment '属性类型，String，int等',
   ObjectType           varchar(32) comment '对象类型，域，字段，页面等',
   ObjectCode           varchar(32) comment '对象编码',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgObjectProp comment 'CG OBJECT PROPERTY 
对象属性，包含页面对象、字段对象、域对象等';

alter table CgDomain add constraint FK_Relationship6 foreign key (ID)
      references CgMetaCom (ID) on delete restrict on update restrict;

alter table CgMetaComPropGroupRel add constraint FK_Relationship1 foreign key (ID)
      references CgMetaComPropGroup (ID) on delete restrict on update restrict;

alter table CgMetaComPropGroupRel add constraint FK_Relationship2 foreign key ()
      references CgMetaComProp (ID) on delete restrict on update restrict;

alter table CgMetaComPropRel add constraint FK_Relationship3 foreign key ()
      references CgMetaComProp (ID) on delete restrict on update restrict;

alter table CgMetaComPropRel add constraint FK_Relationship4 foreign key ()
      references CgMetaCom (ID) on delete restrict on update restrict;

alter table CgMetaComRel add constraint FK_Relationship5 foreign key (CgId)
      references CgMetaCom (ID) on delete restrict on update restrict;

alter table CgObjectProp add constraint FK_Relationship12 foreign key (ID)
      references CgDomain (ID) on delete restrict on update restrict;

