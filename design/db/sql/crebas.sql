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
   id                   varchar(32) not null comment '�߼�����',
   domainCode           varchar(32) not null comment '�����',
   domainName           varchar(64) not null comment '����',
   domainType           varchar(32) comment '�����ͣ��ֶμ���ͨ���������ҳ�漶��',
   comCode              varchar(32) comment '�������',
   parentDomainCode     varchar(32) comment '���������',
   domainRelaType       varchar(32) comment '��������ͣ�ҳ�棬�ֶΣ��ȣ���������',
   define               text comment '�����ԣ����Ϊjson���ʽ',
   enable               varchar(8) comment '�Ƿ�����',
   remark               varchar(1024) comment '��ע',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (id)
);

alter table CG_DOMAIN comment 'CG DOMAIN

��ͬ����ģ���е���ĸ��ͬJava�е�ʵ���ĸ��
һ����';

/*==============================================================*/
/* Table: CG_META_COM                                           */
/*==============================================================*/
create table CG_META_COM
(
   id                   varchar(32) not null comment '�߼�����',
   comCode              varchar(32) not null comment '�������',
   comName              varchar(64) not null comment '�������',
   comType              varchar(32) comment '������ͣ�form��table��input��button',
   enable               varchar(8) comment '�Ƿ�����',
   remark               varchar(1024) comment '��ע',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (id)
);

alter table CG_META_COM comment 'CG META COMPONENT
�����Ԫ����';

/*==============================================================*/
/* Table: CG_META_COM_PROP                                      */
/*==============================================================*/
create table CG_META_COM_PROP
(
   id                   varchar(32) not null comment '�߼�����',
   propCode             varchar(32) not null comment '���Ա���',
   propName             varchar(64) not null comment '��������',
   propValueType        varchar(256) comment '����ֵ����,string/number',
   propTypeDomain       varchar(32) comment '����������true false��left/center/right	l',
   defaultValue         varchar(256) comment 'Ĭ��ֵ',
   enable               varchar(8) comment '�Ƿ�����',
   domType              varchar(32) comment 'DOM�е�����,���ԣ������¼�',
   sort                 int comment '����',
   remark               varchar(1024) comment '��ע',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (id)
);

alter table CG_META_COM_PROP comment 'CG COMPONENT PROPERTY META
�������Ԫ����';

/*==============================================================*/
/* Table: CG_META_COM_PROP_GROUP                                */
/*==============================================================*/
create table CG_META_COM_PROP_GROUP
(
   ID                   varchar(32) not null comment '�߼�����',
   groupCode            varchar(32) not null comment '�������',
   groupName            varchar(64) not null comment '��������',
   groupType            char(10) comment '��������',
   enable               varchar(8) comment '�Ƿ�����',
   sort                 int comment '����',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (ID)
);

alter table CG_META_COM_PROP_GROUP comment 'CG COMPONENT PROPERTY META GROUP
�������Ԫ���ݷ���';

/*==============================================================*/
/* Table: CG_META_COM_PROP_GROUP_REL                            */
/*==============================================================*/
create table CG_META_COM_PROP_GROUP_REL
(
   ID                   varchar(32) not null comment '�߼�����',
   cgId                 varchar(32) comment '�߼�����',
   propCode             varchar(32) not null comment '���Ա���',
   groupCode            varchar(32) not null comment '�������',
   sort                 int comment '����',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (ID)
);

alter table CG_META_COM_PROP_GROUP_REL comment 'CG COMPONENT PROPERTY META GROUP RELATION
�������Ԫ���ݷ������';

/*==============================================================*/
/* Table: CG_META_COM_PROP_REL                                  */
/*==============================================================*/
create table CG_META_COM_PROP_REL
(
   ID                   varchar(32) not null comment '�߼�����',
   cgId                 varchar(32) comment '�߼�����',
   cgId2                varchar(32) comment '�߼�����',
   comCode              varchar(32) not null comment '�������',
   propCode             varchar(32) not null comment '���Ա���',
   relaType             varchar(32) not null comment '��������,form������ѯ��ť��table�У�table������ť��',
   sort                 int comment '����',
   remark               varchar(1024) comment '��ע',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (ID)
);

alter table CG_META_COM_PROP_REL comment 'CG COMPONENT PROPERTY META RELATION
�������Ԫ����-���Ԫ���ݹ���';

/*==============================================================*/
/* Table: CG_META_COM_REL                                       */
/*==============================================================*/
create table CG_META_COM_REL
(
   ID                   varchar(32) not null comment '�߼�����',
   cgId                 varchar(32) comment '�߼�����',
   comCode              varchar(32) not null comment '�������',
   parentComCode        varchar(32) not null comment '�ϼ�����',
   sort                 int comment '����',
   remark               varchar(1024) comment '��ע',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (ID)
);

alter table CG_META_COM_REL comment 'CG META COMPONENT RELATION
�����������������������֮��Ĺ�ϵ������form����';

/*==============================================================*/
/* Table: CG_OBJECT_PROP                                        */
/*==============================================================*/
create table CG_OBJECT_PROP
(
   id                   varchar(32) not null comment '�߼�����',
   propCode             varchar(32) not null comment '���Ա���',
   propValue            varchar(64) not null comment '����ֵ',
   propType             varchar(32) comment '�������ͣ�String��int��',
   objectType           varchar(32) comment '�������ͣ����ֶΣ�ҳ���',
   objectCode           varchar(32) comment '�������',
   createTime           datetime,
   updateTime           datetime,
   createUserId         varchar(32),
   updateUserId         varchar(32),
   primary key (id)
);

alter table CG_OBJECT_PROP comment 'CG OBJECT PROPERTY 
�������ԣ�����ҳ������ֶζ���������';

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

