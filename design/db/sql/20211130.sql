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
   ID                   varchar(32) not null comment '�߼�����',
   DomainCode           varchar(32) not null comment '�����',
   DomainName           varchar(64) not null comment '����',
   DomainType           varchar(32) comment '�����ͣ��ֶμ���ͨ���������ҳ�漶��',
   ComCode              varchar(32) comment '�������',
   ParentDomainCode     varchar(32) comment '���������',
   DomainRelaType       varchar(32) comment '��������ͣ�ҳ�棬�ֶΣ��ȣ���������',
   DEFINE               text comment '�����ԣ����Ϊjson���ʽ',
   ENABLE               varchar(8) comment '�Ƿ�����',
   REMARK               varchar(1024) comment '��ע',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgDomain comment 'CG DOMAIN

��ͬ����ģ���е���ĸ��ͬJava�е�ʵ���ĸ��
һ����';

/*==============================================================*/
/* Table: CgMetaCom                                             */
/*==============================================================*/
create table CgMetaCom
(
   ID                   varchar(32) not null comment '�߼�����',
   ComCode              varchar(32) not null comment '�������',
   ComName              varchar(64) not null comment '�������',
   ComType              varchar(32) comment '������ͣ�form��table��input��button',
   ENABLE               varchar(8) comment '�Ƿ�����',
   REMARK               varchar(1024) comment '��ע',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaCom comment 'CG META COMPONENT
�����Ԫ����';

/*==============================================================*/
/* Table: CgMetaComProp                                         */
/*==============================================================*/
create table CgMetaComProp
(
   ID                   varchar(32) not null comment '�߼�����',
   PropCode             varchar(32) not null comment '���Ա���',
   PropName             varchar(64) not null comment '��������',
   PropValueType        varchar(256) comment '����ֵ����,string/number',
   PropTypeDomain       varchar(32) comment '����������true false��left/center/right	l',
   DefaultValue         varchar(256) comment 'Ĭ��ֵ',
   ENABLE               varchar(8) comment '�Ƿ�����',
   DomType              varchar(32) comment 'DOM�е�����,���ԣ������¼�',
   SORT                 int comment '����',
   REMARK               varchar(1024) comment '��ע',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaComProp comment 'CG COMPONENT PROPERTY META
�������Ԫ����';

/*==============================================================*/
/* Table: CgMetaComPropGroup                                    */
/*==============================================================*/
create table CgMetaComPropGroup
(
   ID                   varchar(32) not null comment '�߼�����',
   GroupCode            varchar(32) not null comment '�������',
   GroupName            varchar(64) not null comment '��������',
   GroupType            char(10) comment '��������',
   ENABLE               varchar(8) comment '�Ƿ�����',
   SORT                 int comment '����',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaComPropGroup comment 'CG COMPONENT PROPERTY META GROUP
�������Ԫ���ݷ���';

/*==============================================================*/
/* Table: CgMetaComPropGroupRel                                 */
/*==============================================================*/
create table CgMetaComPropGroupRel
(
   ID                   varchar(32) not null comment '�߼�����',
   PropCode             varchar(32) not null comment '���Ա���',
   GroupCode            varchar(32) not null comment '�������',
   SORT                 int comment '����',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaComPropGroupRel comment 'CG COMPONENT PROPERTY META GROUP RELATION
�������Ԫ���ݷ������';

/*==============================================================*/
/* Table: CgMetaComPropRel                                      */
/*==============================================================*/
create table CgMetaComPropRel
(
   ID                   varchar(32) not null comment '�߼�����',
   ComCode              varchar(32) not null comment '�������',
   PropCode             varchar(32) not null comment '���Ա���',
   RelaType             varchar(32) not null comment '��������,form������ѯ��ť��table�У�table������ť��',
   SORT                 int comment '����',
   REMARK               varchar(1024) comment '��ע',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaComPropRel comment 'CG COMPONENT PROPERTY META RELATION
�������Ԫ����-���Ԫ���ݹ���';

/*==============================================================*/
/* Table: CgMetaComRel                                          */
/*==============================================================*/
create table CgMetaComRel
(
   ID                   varchar(32) not null comment '�߼�����',
   CgId                 varchar(32) comment '�߼�����',
   ComCode              varchar(32) not null comment '�������',
   ParentComCode        varchar(32) not null comment '�ϼ�����',
   SORT                 int comment '����',
   REMARK               varchar(1024) comment '��ע',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgMetaComRel comment 'CG META COMPONENT RELATION
�����������������������֮��Ĺ�ϵ������form����';

/*==============================================================*/
/* Table: CgObjectProp                                          */
/*==============================================================*/
create table CgObjectProp
(
   ID                   varchar(32) not null comment '�߼�����',
   PropCode             varchar(32) not null comment '���Ա���',
   PropValue            varchar(64) not null comment '����ֵ',
   PropType             varchar(32) comment '�������ͣ�String��int��',
   ObjectType           varchar(32) comment '�������ͣ����ֶΣ�ҳ���',
   ObjectCode           varchar(32) comment '�������',
   CraeteTime           datetime,
   UpdateTime           datetime,
   CreateUserId         varchar(32),
   UpdateUserId         varchar(32),
   primary key (ID)
);

alter table CgObjectProp comment 'CG OBJECT PROPERTY 
�������ԣ�����ҳ������ֶζ���������';

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

