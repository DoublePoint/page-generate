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
   ID                   varchar(32) not null comment '�߼�����',
   DOMAIN_CODE          varchar(32) not null comment '�����',
   DOMAIN_NAME          varchar(64) not null comment '����',
   DOMAIN_TYPE          varchar(32) comment '�����ͣ��ֶμ���ͨ���������ҳ�漶��',
   COM_CODE             varchar(32) comment '�������',
   PARENT_DOMAIN_CODE   varchar(32) comment '���������',
   DOMAIN_RELA_TYPE     varchar(32) comment '��������ͣ�ҳ�棬�ֶΣ��ȣ���������',
   DEFINE               text comment '�����ԣ����Ϊjson���ʽ',
   ENABLE               varchar(8) comment '�Ƿ�����',
   REMARK               varchar(1024) comment '��ע',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
   primary key (ID)
);

alter table CG_DOMAIN comment 'CG DOMAIN

��ͬ����ģ���е���ĸ��ͬJava�е�ʵ���ĸ��
һ����';

/*==============================================================*/
/* Table: CG_META_COM                                           */
/*==============================================================*/
create table CG_META_COM
(
   ID                   varchar(32) not null comment '�߼�����',
   COM_CODE             varchar(32) not null comment '�������',
   COM_NAME             varchar(64) not null comment '�������',
   COM_TYPE             varchar(32) comment '������ͣ�form��table��input��button',
   ENABLE               varchar(8) comment '�Ƿ�����',
   REMARK               varchar(1024) comment '��ע',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
   primary key (ID)
);

alter table CG_META_COM comment 'CG META COMPONENT
�����Ԫ����';

/*==============================================================*/
/* Table: CG_META_COM_PROP                                      */
/*==============================================================*/
create table CG_META_COM_PROP
(
   ID                   varchar(32) not null comment '�߼�����',
   PROP_CODE            varchar(32) not null comment '���Ա���',
   PROP_NAME            varchar(64) not null comment '��������',
   PROP_VALUE_TYPE      varchar(256) comment '����ֵ����,string/number',
   PROP_TYPE_DOMAIN     varchar(32) comment '����������true false��left/center/right	l',
   DEFAULT_VALUE        varchar(256) comment 'Ĭ��ֵ',
   ENABLE               varchar(8) comment '�Ƿ�����',
   DOM_TYPE             varchar(32) comment 'DOM�е�����,���ԣ������¼�',
   SORT                 int comment '����',
   REMARK               varchar(1024) comment '��ע',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
   primary key (ID)
);

alter table CG_META_COM_PROP comment 'CG COMPONENT PROPERTY META
�������Ԫ����';

/*==============================================================*/
/* Table: CG_META_COM_PROP_GROUP                                */
/*==============================================================*/
create table CG_META_COM_PROP_GROUP
(
   ID                   varchar(32) not null comment '�߼�����',
   GROUP_CODE           varchar(32) not null comment '�������',
   GROUP_NAME           varchar(64) not null comment '��������',
   GROUP_TYPE           char(10) comment '��������',
   ENABLE               varchar(8) comment '�Ƿ�����',
   SORT                 int comment '����',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
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
   PROP_CODE            varchar(32) not null comment '���Ա���',
   GROUP_CODE           varchar(32) not null comment '�������',
   SORT                 int comment '����',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
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
   COM_CODE             varchar(32) not null comment '�������',
   PROP_CODE            varchar(32) not null comment '���Ա���',
   RELA_TYPE            varchar(32) not null comment '��������,form������ѯ��ť��table�У�table������ť��',
   SORT                 int comment '����',
   REMARK               varchar(1024) comment '��ע',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
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
   CG__ID               varchar(32) comment '�߼�����',
   COM_CODE             varchar(32) not null comment '�������',
   PARENT_COM_CODE      varchar(32) not null comment '�ϼ�����',
   SORT                 int comment '����',
   REMARK               varchar(1024) comment '��ע',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
   primary key (ID)
);

alter table CG_META_COM_REL comment 'CG META COMPONENT RELATION
�����������������������֮��Ĺ�ϵ������form����';

/*==============================================================*/
/* Table: CG_OBJECT_PROP                                        */
/*==============================================================*/
create table CG_OBJECT_PROP
(
   ID                   varchar(32) not null comment '�߼�����',
   PROP_CODE            varchar(32) not null comment '���Ա���',
   PROP_VALUE           varchar(64) not null comment '����ֵ',
   PROP_TYPE            varchar(32) comment '�������ͣ�String��int��',
   OBJECT_TYPE          varchar(32) comment '�������ͣ����ֶΣ�ҳ���',
   OBJECT_CODE          varchar(32) comment '�������',
   CRAETE_TIME          datetime,
   UPDATE_TIME          datetime,
   CREATE_USER_ID       varchar(32),
   UPDATE_USER_ID       varchar(32),
   primary key (ID)
);

alter table CG_OBJECT_PROP comment 'CG OBJECT PROPERTY 
�������ԣ�����ҳ������ֶζ���������';

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

