/*
Navicat MySQL Data Transfer

Source Server         : 139.129.89.69
Source Server Version : 50736
Source Host           : 139.129.89.69:3306
Source Database       : base

Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001

Date: 2021-12-06 11:00:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cg_config_table
-- ----------------------------
DROP TABLE IF EXISTS `cg_config_table`;
CREATE TABLE `cg_config_table` (
  `ID` varchar(32) NOT NULL COMMENT '逻辑主键',
  `TABLE_CODE` varchar(32) NOT NULL COMMENT '表明',
  `IS_SHOW_RETRIEVE_FORM` varchar(64) NOT NULL COMMENT '是否显示查询Form',
  `IS_SHOW_DEL_BTN` varchar(8) DEFAULT NULL,
  `IS_SHOW_UPDATE_BTN` varchar(8) DEFAULT NULL,
  `IS_SHOW_SAVE_BTN` varchar(8) DEFAULT NULL,
  `IS_SHOW_ADD_BTN` varchar(8) DEFAULT NULL,
  `WHERE_PROP_CODE` varchar(8) DEFAULT NULL COMMENT '分组类型',
  `ENABLE` varchar(8) DEFAULT NULL COMMENT '是否启用',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(32) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='单表维护表数据';

-- ----------------------------
-- Records of cg_config_table
-- ----------------------------
INSERT INTO `cg_config_table` VALUES ('915558641136828416', 'sys_notice', '1', '1', null, null, '1', null, null, '2021-12-01 11:03:10', '2021-12-01 11:03:10', null, null);
INSERT INTO `cg_config_table` VALUES ('915924412115451904', 'cg_meta_com', '1', '1', null, null, '1', null, null, '2021-12-02 11:16:36', '2021-12-02 11:16:36', null, null);
INSERT INTO `cg_config_table` VALUES ('916083306968121344', 'cg_meta_com_rel', '1', '1', null, null, '1', null, null, '2021-12-02 21:48:00', '2021-12-02 21:48:00', null, null);
INSERT INTO `cg_config_table` VALUES ('916087255372660736', 'cg_meta_com_prop_rel', '1', '1', null, null, '1', null, null, '2021-12-02 22:03:41', '2021-12-02 22:03:41', null, null);
INSERT INTO `cg_config_table` VALUES ('916090063513714688', 'cg_meta_com_prop', '1', '1', null, null, '1', null, null, '2021-12-02 22:14:51', '2021-12-02 22:14:51', null, null);
INSERT INTO `cg_config_table` VALUES ('916288470878519296', 'cg_meta_com_prop_group', '1', '1', null, null, '1', null, null, '2021-12-03 11:23:15', '2021-12-03 11:23:15', null, null);
INSERT INTO `cg_config_table` VALUES ('916288987327365120', 'cg_meta_com_prop_group_rel', '1', '1', null, null, '1', null, null, '2021-12-03 11:25:18', '2021-12-03 11:25:18', null, null);

-- ----------------------------
-- Table structure for cg_config_table_field
-- ----------------------------
DROP TABLE IF EXISTS `cg_config_table_field`;
CREATE TABLE `cg_config_table_field` (
  `ID` varchar(32) NOT NULL COMMENT '逻辑主键',
  `CONFIG_TABLE_ID` varchar(32) NOT NULL COMMENT '表明',
  `FIELD_CODE` varchar(32) DEFAULT NULL,
  `PROP_CODE` varchar(64) NOT NULL COMMENT '是否显示查询Form',
  `PROP_NAME` varchar(64) DEFAULT NULL,
  `COM_CODE` varchar(32) DEFAULT NULL,
  `DOMAIN_CODE` varchar(32) DEFAULT NULL,
  `DROP_NAME` varchar(32) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(32) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='单表维护表字段数据';

-- ----------------------------
-- Records of cg_config_table_field
-- ----------------------------
INSERT INTO `cg_config_table_field` VALUES ('915589745008967680', '915558641136828416', 'notice_id', 'noticeId', '通知 ID', 'SELECT', 'BASE', '3', '0', '2021-12-01 13:06:46', '2021-12-01 13:06:46', null, null);
INSERT INTO `cg_config_table_field` VALUES ('915589785668550656', '915558641136828416', 'notice_title', 'noticeTitle', '通知标题', 'INPUT', 'BASE', '3', '0', '2021-12-01 13:06:55', '2021-12-01 13:06:55', null, null);
INSERT INTO `cg_config_table_field` VALUES ('915590048466862080', '915558641136828416', 'notice_type', 'noticeType', '通知类型', 'INPUT', 'TZLX', '3', '0', '2021-12-01 13:07:58', '2021-12-01 13:07:58', null, null);
INSERT INTO `cg_config_table_field` VALUES ('915924511327518720', '915924412115451904', 'com_code', 'comCode', '编码', null, null, '', '0', '2021-12-02 11:17:00', '2021-12-02 11:17:00', null, null);
INSERT INTO `cg_config_table_field` VALUES ('915924670304223232', '915924412115451904', 'com_name', 'comName', '组件名称', null, null, '', '0', '2021-12-02 11:17:38', '2021-12-02 11:17:38', null, null);
INSERT INTO `cg_config_table_field` VALUES ('915924737694105600', '915924412115451904', 'com_type', 'comType', '组件类型', null, null, '', '0', '2021-12-02 11:17:54', '2021-12-02 11:17:54', null, null);
INSERT INTO `cg_config_table_field` VALUES ('915924774557843456', '915924412115451904', 'remark', 'remark', '备注信息', null, null, '', '0', '2021-12-02 11:18:03', '2021-12-02 11:18:03', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916083433938092032', '916083306968121344', 'prop_code', 'propCode', 'PROP CODE', null, null, '', '0', '2021-12-02 21:48:30', '2021-12-02 21:48:30', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916083819801477120', '916083306968121344', 'com_code', 'comCode', 'COM_CODE', null, null, '', '0', '2021-12-02 21:50:02', '2021-12-02 21:50:02', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916083937413955584', '916083306968121344', 'rela_type', 'relaType', 'RELA TYPE', null, null, '', '0', '2021-12-02 21:50:30', '2021-12-02 21:50:30', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916087386813759488', '916087255372660736', 'com_code', 'comCode', 'Com Code', null, null, '', '0', '2021-12-02 22:04:13', '2021-12-02 22:04:13', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916087459270361088', '916087255372660736', 'prop_code', 'propCode', 'Prop Code', null, null, '', '0', '2021-12-02 22:04:30', '2021-12-02 22:04:30', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916087548575481856', '916087255372660736', 'rela_type', 'relaType', 'Rela Type', null, null, '', '0', '2021-12-02 22:04:51', '2021-12-02 22:04:51', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916087591328022528', '916087255372660736', 'remark', 'remark', 'remark', null, null, '', '0', '2021-12-02 22:05:01', '2021-12-02 22:05:01', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916090179918233600', '916090063513714688', 'prop_code', 'propCode', '属性编码', null, null, '', '0', '2021-12-02 22:15:19', '2021-12-02 22:15:19', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916090255818358784', '916090063513714688', 'prop_name', 'propName', '属性名称', null, null, '', '0', '2021-12-02 22:15:37', '2021-12-02 22:15:37', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916090329424199680', '916090063513714688', 'prop_value', 'propValue', '属性值', null, null, '', '0', '2021-12-02 22:15:54', '2021-12-02 22:15:54', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916288666853179392', '916288470878519296', 'group_code', 'groupCode', '分组编码', null, null, '', '0', '2021-12-03 11:24:01', '2021-12-03 11:24:01', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916288813972586496', '916288470878519296', 'group_name', 'groupName', '分组名称', null, null, '', '0', '2021-12-03 11:24:37', '2021-12-03 11:24:37', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916289051823177728', '916288987327365120', 'prop_code', 'propCode', '属性编码', null, null, '', '0', '2021-12-03 11:25:33', '2021-12-03 11:25:33', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916289166797438976', '916288987327365120', 'group_code', 'groupCode', '分组编码', null, null, '', '0', '2021-12-03 11:26:01', '2021-12-03 11:26:01', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916289214507646976', '916288987327365120', 'sort', 'sort', '排序', null, null, '', '0', '2021-12-03 11:26:12', '2021-12-03 11:26:12', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916289492229292032', '916288987327365120', 'id', 'id', 'id', null, null, '', '0', '2021-12-03 11:27:18', '2021-12-03 11:27:18', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916306139216347136', '916288470878519296', 'sort', 'sort', '排序', null, null, '', '0', '2021-12-03 12:33:27', '2021-12-03 12:33:27', null, null);
INSERT INTO `cg_config_table_field` VALUES ('916394617081954304', '915924412115451904', 'id', 'id', 'ID', null, null, '', '0', '2021-12-03 18:25:02', '2021-12-03 18:25:02', null, null);

-- ----------------------------
-- Table structure for cg_domain
-- ----------------------------
DROP TABLE IF EXISTS `cg_domain`;
CREATE TABLE `cg_domain` (
  `ID` varchar(32) NOT NULL COMMENT '逻辑主键',
  `DOMAIN_CODE` varchar(32) NOT NULL COMMENT '域编码',
  `DOMAIN_NAME` varchar(64) NOT NULL COMMENT '域名',
  `DOMAIN_TYPE` varchar(32) DEFAULT NULL COMMENT '域类型，字段级、通用组件级、页面级别',
  `COM_CODE` varchar(32) DEFAULT NULL COMMENT '组件编码',
  `PARENT_DOMAIN_CODE` varchar(32) DEFAULT NULL COMMENT '父级域编码',
  `DOMAIN_RELA_TYPE` varchar(32) DEFAULT NULL COMMENT '域关联类型，页面，字段，等，基本属性',
  `DEFINE` text COMMENT '域属性，存的为json表达式',
  `ENABLE` varchar(8) DEFAULT NULL COMMENT '是否启用',
  `REMARK` varchar(1024) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(32) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='CG DOMAIN\r\n\r\n域，同物理模型中的域的概念，同Java中的实例的概念。\r\n一个组';

-- ----------------------------
-- Records of cg_domain
-- ----------------------------
INSERT INTO `cg_domain` VALUES ('1', 'CA_NO', '合约账户编号', '01', 'INPUT', null, '01', null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_domain` VALUES ('10', 'BASE_LABEL', '显示Label', 'base', 'INPUT', 'BASE', 'base', null, '01', 'text,textarea', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_domain` VALUES ('11', 'TZLX_LABEL', 'LABEL', 'base', 'INPUT', 'TZLX', 'base', null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', null, null);
INSERT INTO `cg_domain` VALUES ('12', 'TZLX_FIELD_TYPE', '组件类型', 'base', 'INPUT', 'TZLX', 'base', null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', null, null);
INSERT INTO `cg_domain` VALUES ('13', 'BASE_FIELD_TYPE', '组件类型', 'base', 'INPUT', 'BASE', 'base', null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', null, null);
INSERT INTO `cg_domain` VALUES ('14', 'BASE_DROP_TABLE_NAME', '下拉表名称', 'base', 'SELECT', 'BASE', 'base', null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_domain` VALUES ('15', 'BASE_WIDTH', 'width', 'base', 'INPUT', 'BASE', 'base', null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_domain` VALUES ('2', 'BUSICATGCD', '业务类别', '01', 'SELECT', null, '01', null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_domain` VALUES ('3', 'BUSICATGCD_DROP_NAME', '业务类别下拉名称', '01', null, null, null, null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_domain` VALUES ('4', 'SFBT', '是否必填', 'base', 'SWITCH', 'BASE', 'base', null, '01', 'text,textarea', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_domain` VALUES ('5', 'SX', '顺序', 'base', 'INPUT', 'BASE', 'base', null, '01', 'text,textarea', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_domain` VALUES ('6', 'BASE', '基本属性域名', 'base', 'INPUT', null, 'base', null, '01', 'text,textarea', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_domain` VALUES ('7', 'BASE_DROPNAME', '下拉名称', 'base', 'SELECT', 'BASE', 'base', null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_domain` VALUES ('8', 'TZLX', '通知类型', 'base', 'SELECT', null, 'base', null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', null, null);
INSERT INTO `cg_domain` VALUES ('9', 'TZLX_XLMC', '下拉名称', 'base', 'SELECT', 'TZLX', 'base', null, '01', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');

-- ----------------------------
-- Table structure for cg_meta_com
-- ----------------------------
DROP TABLE IF EXISTS `cg_meta_com`;
CREATE TABLE `cg_meta_com` (
  `ID` varchar(32) NOT NULL COMMENT '逻辑主键',
  `COM_CODE` varchar(32) NOT NULL COMMENT '组件编码',
  `COM_NAME` varchar(64) NOT NULL COMMENT '组件名称',
  `DOM_TYPE` varchar(32) DEFAULT NULL COMMENT '组件类型，form，table，input，button',
  `ENABLE` varchar(8) DEFAULT NULL COMMENT '是否启用',
  `REMARK` varchar(1024) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(32) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='CG META COMPONENT\r\n组件的元数据';

-- ----------------------------
-- Records of cg_meta_com
-- ----------------------------
INSERT INTO `cg_meta_com` VALUES ('1', 'QueryForm', '查询表单', '01', '01', '查询表单', '2021-11-29 19:20:36', '2021-11-29 19:20:38', '01', '01');
INSERT INTO `cg_meta_com` VALUES ('1000', 'noticeid', '通知ID', '01', null, '通知ID', null, null, null, null);
INSERT INTO `cg_meta_com` VALUES ('2', 'Table', '展示表格', '02', '01', '展示表格', '2021-11-29 19:21:21', '2021-11-29 19:21:23', '01', '01');
INSERT INTO `cg_meta_com` VALUES ('3', 'INPUT', '输入框', '0301', '01', '输入框', '2021-11-29 19:21:21', '2021-11-29 19:21:21', '01', '01');
INSERT INTO `cg_meta_com` VALUES ('4', 'SELECT', '下拉', '03', '01', '下拉框', '2021-11-29 19:21:21', '2021-11-29 19:21:21', '01', '01');
INSERT INTO `cg_meta_com` VALUES ('5', 'SWITCH', 'SWITCH', '0302', '01', null, '2021-11-29 19:21:21', '2021-11-29 19:21:21', '01', '01');

-- ----------------------------
-- Table structure for cg_meta_com_prop
-- ----------------------------
DROP TABLE IF EXISTS `cg_meta_com_prop`;
CREATE TABLE `cg_meta_com_prop` (
  `ID` varchar(32) NOT NULL COMMENT '逻辑主键',
  `PROP_CODE` varchar(32) NOT NULL COMMENT '属性编码',
  `PROP_NAME` varchar(64) NOT NULL COMMENT '属性名称',
  `PROP_VALUE_TYPE` varchar(256) DEFAULT NULL COMMENT '属性值类型,string/number',
  `PROP_TYPE_DOMAIN` varchar(32) DEFAULT NULL COMMENT '属性类型域，true false，left/center/right	l',
  `DEFAULT_VALUE` varchar(256) DEFAULT NULL COMMENT '默认值',
  `ENABLE` varchar(8) DEFAULT NULL COMMENT '是否启用',
  `DOM_TYPE` varchar(32) DEFAULT NULL COMMENT 'DOM中的类型,属性，还是事件',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `REMARK` varchar(1024) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(32) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='CG COMPONENT PROPERTY META\r\n组件属性元数据';

-- ----------------------------
-- Records of cg_meta_com_prop
-- ----------------------------
INSERT INTO `cg_meta_com_prop` VALUES ('1', 'sql', 'sql', '01', 'String', null, '01', '01', '1', 'SQL', '2021-11-29 19:14:13', '2021-11-29 19:14:15', '01', '01');
INSERT INTO `cg_meta_com_prop` VALUES ('10', 'SELECT_DROP_LABEL', 'label', '01', null, null, '01', null, '3', 'Label', '2021-11-29 19:14:13', '2021-11-29 19:14:13', '01', '01');
INSERT INTO `cg_meta_com_prop` VALUES ('12', 'DOM_TYPE', 'domtype', '01', null, null, null, null, '3', '组件类型', '2021-11-29 19:14:13', null, null, null);
INSERT INTO `cg_meta_com_prop` VALUES ('2', 'com_name', 'name', '01', null, null, '01', '01', '1', '绑定的name属性', '2021-11-29 19:14:13', '2021-11-29 19:14:13', '01', '01');
INSERT INTO `cg_meta_com_prop` VALUES ('3', 'INPUT_TYPE', 'type', '01', 'CG_INPUT_TYPE', null, '01', null, '1', '类型', '2021-11-29 19:14:13', '2021-11-29 19:14:13', '01', '01');
INSERT INTO `cg_meta_com_prop` VALUES ('4', 'INPUT_VALUE', 'value', '01', null, null, '01', null, '2', '绑定值', '2021-11-29 19:14:13', '2021-11-29 19:14:13', '01', '01');
INSERT INTO `cg_meta_com_prop` VALUES ('5', 'INPUT_MAXLENGTH', 'maxlength', '01', null, null, '01', null, '3', '最大输入长度', '2021-11-29 19:14:13', '2021-11-29 19:14:13', '01', '01');
INSERT INTO `cg_meta_com_prop` VALUES ('6', 'INPUT_MINLENGTH', 'minlength', '01', null, null, '01', null, '4', '最小输入长度', '2021-11-29 19:14:13', '2021-11-29 19:14:13', '01', '01');
INSERT INTO `cg_meta_com_prop` VALUES ('7', 'INPUT_SHOW_WORD_LIMIT', 'showwordlimit', '01', null, null, '01', null, '5', '是否显示输入字数统计', '2021-11-29 19:14:13', '2021-11-29 19:14:13', '01', '01');
INSERT INTO `cg_meta_com_prop` VALUES ('8', 'SELECT_VALUE', 'value', '01', null, null, '01', null, '1', '绑定值', '2021-11-29 19:14:13', '2021-11-29 19:14:13', '01', '01');
INSERT INTO `cg_meta_com_prop` VALUES ('9', 'SELECT_DROP_NAME', 'dropname', '01', null, null, '01', null, '2', '下拉名称', '2021-11-29 19:14:13', '2021-11-29 19:14:13', '01', '01');

-- ----------------------------
-- Table structure for cg_meta_com_prop_group
-- ----------------------------
DROP TABLE IF EXISTS `cg_meta_com_prop_group`;
CREATE TABLE `cg_meta_com_prop_group` (
  `ID` varchar(32) NOT NULL COMMENT '逻辑主键',
  `GROUP_CODE` varchar(32) NOT NULL COMMENT '分组编码',
  `GROUP_NAME` varchar(64) NOT NULL COMMENT '分组名称',
  `GROUP_TYPE` char(10) DEFAULT NULL COMMENT '分组类型',
  `ENABLE` varchar(8) DEFAULT NULL COMMENT '是否启用',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(32) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='CG COMPONENT PROPERTY META GROUP\r\n组件属性元数据分组';

-- ----------------------------
-- Records of cg_meta_com_prop_group
-- ----------------------------
INSERT INTO `cg_meta_com_prop_group` VALUES ('1001', 'LJSX', '逻辑属性', null, null, '2', null, null, null, null);
INSERT INTO `cg_meta_com_prop_group` VALUES ('1002', 'QTSX', '其它属性', null, null, '3', null, null, null, null);

-- ----------------------------
-- Table structure for cg_meta_com_prop_group_rel
-- ----------------------------
DROP TABLE IF EXISTS `cg_meta_com_prop_group_rel`;
CREATE TABLE `cg_meta_com_prop_group_rel` (
  `ID` varchar(32) NOT NULL COMMENT '逻辑主键',
  `PROP_CODE` varchar(32) NOT NULL COMMENT '属性编码',
  `GROUP_CODE` varchar(32) NOT NULL COMMENT '分组编码',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(32) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='CG COMPONENT PROPERTY META GROUP RELATION\r\n组件属性元数据分组关联';

-- ----------------------------
-- Records of cg_meta_com_prop_group_rel
-- ----------------------------
INSERT INTO `cg_meta_com_prop_group_rel` VALUES ('1001', 'SELECT_VALUE', 'LJSX', '1', null, null, null, null);
INSERT INTO `cg_meta_com_prop_group_rel` VALUES ('1002', 'SELECT_DROP_NAME', 'QTSX', '2', null, null, null, null);

-- ----------------------------
-- Table structure for cg_meta_com_prop_rel
-- ----------------------------
DROP TABLE IF EXISTS `cg_meta_com_prop_rel`;
CREATE TABLE `cg_meta_com_prop_rel` (
  `ID` varchar(32) NOT NULL COMMENT '逻辑主键',
  `COM_CODE` varchar(32) NOT NULL COMMENT '组件编码',
  `PROP_CODE` varchar(32) NOT NULL COMMENT '属性编码',
  `RELA_TYPE` varchar(32) NOT NULL COMMENT '关联类型,form表单，查询按钮，table列，table操作按钮等',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `REMARK` varchar(1024) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(32) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='CG COMPONENT PROPERTY META RELATION\r\n组件属性元数据-组件元数据关联';

-- ----------------------------
-- Records of cg_meta_com_prop_rel
-- ----------------------------
INSERT INTO `cg_meta_com_prop_rel` VALUES ('1', 'QueryForm', 'sql', '01', '1', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_meta_com_prop_rel` VALUES ('10', 'SELECT', 'SELECT_DROP_NAME', '04', '2', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_meta_com_prop_rel` VALUES ('1001', 'SELECT', 'INPUT_TYPE', '01', null, null, null, null, null, null);
INSERT INTO `cg_meta_com_prop_rel` VALUES ('1002', 'SELECT', 'INPUT_VALUE', '01', null, null, null, null, null, null);
INSERT INTO `cg_meta_com_prop_rel` VALUES ('1003', 'noticeid', 'INPUT_TYPE', '01', null, 'Input Type', null, null, null, null);
INSERT INTO `cg_meta_com_prop_rel` VALUES ('1004', 'noticeid', 'DROP_NAME', '01', null, null, null, null, null, null);
INSERT INTO `cg_meta_com_prop_rel` VALUES ('2', 'QueryForm', 'com_name', '02', '1', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_meta_com_prop_rel` VALUES ('3', 'Table', 'com_name', '02', '1', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_meta_com_prop_rel` VALUES ('4', 'INPUT', 'INPUT_TYPE', '03', '1', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_meta_com_prop_rel` VALUES ('5', 'INPUT', 'INPUT_VALUE', '03', '2', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_meta_com_prop_rel` VALUES ('6', 'INPUT', 'INPUT_MAXLENGTH', '03', '3', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_meta_com_prop_rel` VALUES ('7', 'INPUT', 'INPUT_MINLENGTH', '03', '4', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_meta_com_prop_rel` VALUES ('8', 'INPUT', 'INPUT_SHOW_WORD_LIMIT', '03', '5', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_meta_com_prop_rel` VALUES ('9', 'SELECT', 'SELECT_VALUE', '03', '1', null, '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');

-- ----------------------------
-- Table structure for cg_meta_com_rel
-- ----------------------------
DROP TABLE IF EXISTS `cg_meta_com_rel`;
CREATE TABLE `cg_meta_com_rel` (
  `ID` varchar(32) NOT NULL COMMENT '逻辑主键',
  `CG__ID` varchar(32) DEFAULT NULL COMMENT '逻辑主键',
  `COM_CODE` varchar(32) NOT NULL COMMENT '组件编码',
  `PARENT_COM_CODE` varchar(32) NOT NULL COMMENT '上级名称',
  `SORT` int(11) DEFAULT NULL COMMENT '排序',
  `REMARK` varchar(1024) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(32) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='CG META COMPONENT RELATION\r\n组件关联，用来描述组件组件之间的关系，例如form的子';

-- ----------------------------
-- Records of cg_meta_com_rel
-- ----------------------------

-- ----------------------------
-- Table structure for cg_object_prop
-- ----------------------------
DROP TABLE IF EXISTS `cg_object_prop`;
CREATE TABLE `cg_object_prop` (
  `ID` varchar(32) NOT NULL COMMENT '逻辑主键',
  `PROP_CODE` varchar(32) NOT NULL COMMENT '属性编码',
  `PROP_VALUE` varchar(64) NOT NULL COMMENT '属性值',
  `PROP_TYPE` varchar(32) DEFAULT NULL COMMENT '属性类型，String，int等',
  `OBJECT_TYPE` varchar(32) DEFAULT NULL COMMENT '对象类型，域，字段，页面等',
  `OBJECT_CODE` varchar(32) DEFAULT NULL COMMENT '对象编码',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(32) DEFAULT NULL,
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='CG OBJECT PROPERTY \r\n对象属性，包含页面对象、字段对象、域对象等';

-- ----------------------------
-- Records of cg_object_prop
-- ----------------------------
INSERT INTO `cg_object_prop` VALUES ('1', 'INPUT_VALUE', 'cano', '01', '01', 'CA_NO', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('10', 'SELECT_DROP_NAME', 'YES_OR_NO', '01', '01', 'BASE_DROPNAME', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('11', 'SELECT_DROP_LABEL', '下拉名称', '01', '01', 'BASE_DROPNAME', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('12', 'SELECT_DROP_LABEL', '下拉名称', '01', '01', 'BASE_DROPNAME', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('13', 'SELECT_DROP_NAME', 'sys_notice_type', '01', '01', 'TZLX_XLMC', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('14', 'SELECT_DROP_NAME', 'YES_OR_NO', '01', '01', 'FIELD_TYPE', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('15', 'DOM_TYPE', '03', '01', '01', 'TZLX_FIELD_TYPE', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('16', 'DOM_TYPE', '03', '01', '01', 'BASE_FIELD_TYPE', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('2', 'INPUT_LABEL', '合约账户编号', '01', '01', 'CA_NO', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('3', 'INPUT_TYPE', 'input', '01', '01', 'SX', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('4', 'INPUT_VALUE', 'sx', '01', '01', 'SX', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('5', 'INPUT_MAXLENGTH', '10', '02', '01', 'SX', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('6', 'INPUT_LABEL', '输入框类型', '02', '01', 'SX', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('7', 'INPUT_TYPE', 'input', '01', '01', 'SFBT', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('8', 'INPUT_VALUE', 'inputLabel', '01', '01', 'SFBT', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('9', 'INPUT_LABEL', '标签名称', '01', '01', 'SFBT', '2021-11-29 19:23:56', '2021-11-29 19:23:56', '01', '01');
INSERT INTO `cg_object_prop` VALUES ('916778780989587456', 'SFBT', '01', null, '02', '915589745008967680', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('916789139725090817', 'SX', '11', null, '02', '915589745008967680', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('916929373234266112', 'LABEL', '通知类型', null, '02', '915590048466862080', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('916929408839712768', 'LABEL', '通知ID', null, '02', '915589745008967680', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('916930989404454912', 'FIELD_TYPE', '00', null, '02', '915589745008967680', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('916931060984446976', 'FIELD_TYPE', '03', null, '02', '915590048466862080', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('916939393078394880', 'BASE_LABEL', '通知标题', null, '02', '915589785668550656', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('916939393078394881', 'BASE_FIELD_TYPE', '03', null, '02', '915589785668550656', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('916939393078394882', 'SFBT', '01', null, '02', '915589785668550656', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('916939393078394883', 'SX', '3', null, '02', '915589785668550656', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('917077055110119424', 'TZLX_LABEL', '1111', null, '02', '915589785668550656', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('917077055110119425', 'TZLX_FIELD_TYPE', '2222', null, '02', '915589785668550656', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('917141792988594176', 'BASE_LABEL', '通知ID', null, '02', '915589745008967680', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('917141862890864640', 'BASE_LABEL', '通知类型', null, '02', '915590048466862080', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('917141862890864641', 'SX', '3', null, '02', '915590048466862080', null, null, null, null);
INSERT INTO `cg_object_prop` VALUES ('917158013599481856', 'BASE_WIDTH', '350', null, '02', '915589785668550656', null, null, null, null);

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table` (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='代码生成业务表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES ('1', 'CG_META_COM_PROP', 'CG COMPONENT PROPERTY META\r\n组件属性元数据', null, null, 'CgMetaComProp', 'crud', 'com.ruoyi.system', 'system', 'PROP', 'CG COMPONENT PROPERTY META\r\n组件属性元数据', 'ruoyi', '0', '/', null, 'admin', '2021-11-30 05:57:51', '', null, null);

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='代码生成业务表字段';

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES ('1', '1', 'id', '逻辑主键', 'varchar(32)', 'String', 'id', '1', '0', null, '1', null, null, null, 'EQ', 'input', '', '1', 'admin', '2021-11-30 05:57:51', '', null);
INSERT INTO `gen_table_column` VALUES ('2', '1', 'propCode', '属性编码', 'varchar(32)', 'String', 'propcode', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', '2', 'admin', '2021-11-30 05:57:51', '', null);
INSERT INTO `gen_table_column` VALUES ('3', '1', 'propName', '属性名称', 'varchar(64)', 'String', 'propname', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', '3', 'admin', '2021-11-30 05:57:52', '', null);
INSERT INTO `gen_table_column` VALUES ('4', '1', 'propValueType', '属性值类型,string/number', 'varchar(256)', 'String', 'propvaluetype', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '4', 'admin', '2021-11-30 05:57:52', '', null);
INSERT INTO `gen_table_column` VALUES ('5', '1', 'propTypeDomain', '属性类型域，true false，left/center/right	l', 'varchar(32)', 'String', 'proptypedomain', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '5', 'admin', '2021-11-30 05:57:52', '', null);
INSERT INTO `gen_table_column` VALUES ('6', '1', 'defaultValue', '默认值', 'varchar(256)', 'String', 'defaultvalue', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '6', 'admin', '2021-11-30 05:57:52', '', null);
INSERT INTO `gen_table_column` VALUES ('7', '1', 'enable', '是否启用', 'varchar(8)', 'String', 'enable', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '7', 'admin', '2021-11-30 05:57:53', '', null);
INSERT INTO `gen_table_column` VALUES ('8', '1', 'domType', 'DOM中的类型,属性，还是事件', 'varchar(32)', 'String', 'domtype', '0', '0', null, '1', '1', '1', '1', 'EQ', 'select', '', '8', 'admin', '2021-11-30 05:57:53', '', null);
INSERT INTO `gen_table_column` VALUES ('9', '1', 'sort', '排序', 'int(11)', 'Long', 'sort', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '9', 'admin', '2021-11-30 05:57:53', '', null);
INSERT INTO `gen_table_column` VALUES ('10', '1', 'remark', '备注', 'varchar(1024)', 'String', 'remark', '0', '0', null, '1', '1', '1', null, 'EQ', 'textarea', '', '10', 'admin', '2021-11-30 05:57:53', '', null);
INSERT INTO `gen_table_column` VALUES ('11', '1', 'createTime', null, 'datetime', 'Date', 'createtime', '0', '0', null, '1', '1', '1', '1', 'EQ', 'datetime', '', '11', 'admin', '2021-11-30 05:57:54', '', null);
INSERT INTO `gen_table_column` VALUES ('12', '1', 'updateTime', null, 'datetime', 'Date', 'updatetime', '0', '0', null, '1', '1', '1', '1', 'EQ', 'datetime', '', '12', 'admin', '2021-11-30 05:57:54', '', null);
INSERT INTO `gen_table_column` VALUES ('13', '1', 'createUserId', null, 'varchar(32)', 'String', 'createuserid', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '13', 'admin', '2021-11-30 05:57:54', '', null);
INSERT INTO `gen_table_column` VALUES ('14', '1', 'updateUserId', null, 'varchar(32)', 'String', 'updateuserid', '0', '0', null, '1', '1', '1', '1', 'EQ', 'input', '', '14', 'admin', '2021-11-30 05:57:54', '', null);

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(200) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `cron_expression` varchar(200) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', '0/15 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(200) DEFAULT NULL,
  `job_group` varchar(200) DEFAULT NULL,
  `is_nonconcurrent` varchar(1) DEFAULT NULL,
  `requests_recovery` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `job_class_name` varchar(250) NOT NULL,
  `is_durable` varchar(1) NOT NULL,
  `is_nonconcurrent` varchar(1) NOT NULL,
  `is_update_data` varchar(1) NOT NULL,
  `requests_recovery` varchar(1) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', null, 'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001E636F6D2E72756F79692E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720027636F6D2E72756F79692E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017D6F91ADF078707400007070707400013174000E302F3130202A202A202A202A203F74001172795461736B2E72794E6F506172616D7374000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000001740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC8974000133740001317800);
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', null, 'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001E636F6D2E72756F79692E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720027636F6D2E72756F79692E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017D6F91ADF078707400007070707400013174000E302F3135202A202A202A202A203F74001572795461736B2E7279506172616D7328277279272974000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000002740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC8974000133740001317800);
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', null, 'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001E636F6D2E72756F79692E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720027636F6D2E72756F79692E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017D6F91ADF078707400007070707400013174000E302F3230202A202A202A202A203F74003872795461736B2E72794D756C7469706C65506172616D7328277279272C20747275652C20323030304C2C203331362E3530442C203130302974000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000003740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E5A49AE58F82EFBC8974000133740001317800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RuoyiScheduler', 'LIULEI1638700064400', '1638754089689', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `str_prop_1` varchar(512) DEFAULT NULL,
  `str_prop_2` varchar(512) DEFAULT NULL,
  `str_prop_3` varchar(512) DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) DEFAULT NULL,
  `bool_prop_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', 'TASK_CLASS_NAME1', 'DEFAULT', null, '1638700070000', '-1', '5', 'PAUSED', 'CRON', '1638700064000', '0', null, '2', '');
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', 'TASK_CLASS_NAME2', 'DEFAULT', null, '1638700065000', '-1', '5', 'PAUSED', 'CRON', '1638700064000', '0', null, '2', '');
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', 'TASK_CLASS_NAME3', 'DEFAULT', null, '1638700080000', '-1', '5', 'PAUSED', 'CRON', '1638700065000', '0', null, '2', '');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2021-11-30 14:39:18', '', null, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2021-11-30 14:39:18', '', null, '初始化密码 123456');
INSERT INTO `sys_config` VALUES ('3', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2021-11-30 14:39:18', '', null, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES ('4', '账号自助-验证码开关', 'sys.account.captchaOnOff', 'true', 'Y', 'admin', '2021-11-30 14:39:18', '', null, '是否开启验证码功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES ('5', '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2021-11-30 14:39:18', '', null, '是否开启注册用户功能（true开启，false关闭）');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('100', '0', '0', '若依科技', '0', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-11-30 14:39:17', '', null);
INSERT INTO `sys_dept` VALUES ('101', '100', '0,100', '深圳总公司', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-11-30 14:39:17', '', null);
INSERT INTO `sys_dept` VALUES ('102', '100', '0,100', '长沙分公司', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-11-30 14:39:17', '', null);
INSERT INTO `sys_dept` VALUES ('103', '101', '0,100,101', '研发部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-11-30 14:39:17', '', null);
INSERT INTO `sys_dept` VALUES ('104', '101', '0,100,101', '市场部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-11-30 14:39:17', '', null);
INSERT INTO `sys_dept` VALUES ('105', '101', '0,100,101', '测试部门', '3', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-11-30 14:39:17', '', null);
INSERT INTO `sys_dept` VALUES ('106', '101', '0,100,101', '财务部门', '4', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-11-30 14:39:17', '', null);
INSERT INTO `sys_dept` VALUES ('107', '101', '0,100,101', '运维部门', '5', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-11-30 14:39:17', '', null);
INSERT INTO `sys_dept` VALUES ('108', '102', '0,100,102', '市场部门', '1', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-11-30 14:39:17', '', null);
INSERT INTO `sys_dept` VALUES ('109', '102', '0,100,102', '财务部门', '2', '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-11-30 14:39:17', '', null);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1', '1', '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2021-11-30 14:39:18', '', null, '性别男');
INSERT INTO `sys_dict_data` VALUES ('2', '2', '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '性别女');
INSERT INTO `sys_dict_data` VALUES ('3', '3', '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '性别未知');
INSERT INTO `sys_dict_data` VALUES ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2021-11-30 14:39:18', '', null, '显示菜单');
INSERT INTO `sys_dict_data` VALUES ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2021-11-30 14:39:18', '', null, '正常状态');
INSERT INTO `sys_dict_data` VALUES ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '停用状态');
INSERT INTO `sys_dict_data` VALUES ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2021-11-30 14:39:18', '', null, '正常状态');
INSERT INTO `sys_dict_data` VALUES ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '停用状态');
INSERT INTO `sys_dict_data` VALUES ('10', '1', '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2021-11-30 14:39:18', '', null, '默认分组');
INSERT INTO `sys_dict_data` VALUES ('11', '2', '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '系统分组');
INSERT INTO `sys_dict_data` VALUES ('12', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2021-11-30 14:39:18', '', null, '系统默认是');
INSERT INTO `sys_dict_data` VALUES ('13', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '系统默认否');
INSERT INTO `sys_dict_data` VALUES ('14', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2021-11-30 14:39:18', '', null, '通知');
INSERT INTO `sys_dict_data` VALUES ('15', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '公告');
INSERT INTO `sys_dict_data` VALUES ('16', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2021-11-30 14:39:18', '', null, '正常状态');
INSERT INTO `sys_dict_data` VALUES ('17', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '关闭状态');
INSERT INTO `sys_dict_data` VALUES ('18', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '新增操作');
INSERT INTO `sys_dict_data` VALUES ('19', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '修改操作');
INSERT INTO `sys_dict_data` VALUES ('20', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '删除操作');
INSERT INTO `sys_dict_data` VALUES ('21', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '授权操作');
INSERT INTO `sys_dict_data` VALUES ('22', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '导出操作');
INSERT INTO `sys_dict_data` VALUES ('23', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '导入操作');
INSERT INTO `sys_dict_data` VALUES ('24', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '强退操作');
INSERT INTO `sys_dict_data` VALUES ('25', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '生成操作');
INSERT INTO `sys_dict_data` VALUES ('26', '9', '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '清空操作');
INSERT INTO `sys_dict_data` VALUES ('27', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '正常状态');
INSERT INTO `sys_dict_data` VALUES ('28', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2021-11-30 14:39:18', '', null, '停用状态');
INSERT INTO `sys_dict_data` VALUES ('100', '1', '基本属性', '01', 'CG_PROP_GROUP_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-29 18:05:08', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('101', '2', '组件属性', '02', 'CG_PROP_GROUP_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-29 18:05:29', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('102', '3', '样式属性', '03', 'CG_PROP_GROUP_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-29 18:05:46', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('103', '4', '其它', '99', 'CG_PROP_GROUP_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-29 18:06:19', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('104', '0', '字段级', '01', 'CG_DOMAIN_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-29 18:46:12', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('105', '1', '表单级', '02', 'CG_DOMAIN_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-29 18:46:44', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('106', '3', '表格级', '03', 'CG_DOMAIN_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-29 18:47:06', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('107', '4', '复合组件级', '04', 'CG_DOMAIN_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-29 18:47:33', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('108', '5', '页面级', '05', 'CG_DOMAIN_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-29 18:47:47', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('109', '0', 'Form', '01', 'CG_DOM_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-30 05:48:37', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('110', '0', 'Table', '02', 'CG_DOM_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-30 05:48:58', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('111', '0', 'String', '01', 'CG_PROP_VALUE_TYPE', null, 'default', 'N', '0', 'admin', '2021-11-30 05:50:35', '', null, null);
INSERT INTO `sys_dict_data` VALUES ('112', '0', '下拉', '0301', 'CG_COM_TYPE', null, 'default', 'N', '0', 'admin', '2021-12-04 07:37:51', '', null, null);

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1', '用户性别', 'sys_user_sex', '0', 'admin', '2021-11-30 14:39:18', '', null, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2021-11-30 14:39:18', '', null, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2021-11-30 14:39:18', '', null, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES ('4', '任务状态', 'sys_job_status', '0', 'admin', '2021-11-30 14:39:18', '', null, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES ('5', '任务分组', 'sys_job_group', '0', 'admin', '2021-11-30 14:39:18', '', null, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES ('6', '系统是否', 'sys_yes_no', '0', 'admin', '2021-11-30 14:39:18', '', null, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES ('7', '通知类型', 'sys_notice_type', '0', 'admin', '2021-11-30 14:39:18', '', null, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES ('8', '通知状态', 'sys_notice_status', '0', 'admin', '2021-11-30 14:39:18', '', null, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES ('9', '操作类型', 'sys_oper_type', '0', 'admin', '2021-11-30 14:39:18', '', null, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES ('10', '系统状态', 'sys_common_status', '0', 'admin', '2021-11-30 14:39:18', '', null, '登录状态列表');
INSERT INTO `sys_dict_type` VALUES ('102', '域类型', 'CG_DOMAIN_TYPE', '0', 'admin', '2021-11-29 18:45:33', '', null, '域类型');
INSERT INTO `sys_dict_type` VALUES ('103', '组件类型', 'CG_DOM_TYPE', '0', 'admin', '2021-11-30 05:48:13', 'admin', '2021-12-04 07:33:54', '组件类型');
INSERT INTO `sys_dict_type` VALUES ('104', '属性值类型', 'CG_PROP_VALUE_TYPE', '0', 'admin', '2021-11-30 05:50:18', '', null, null);

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('1', '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2021-11-30 14:39:18', '', null, '');
INSERT INTO `sys_job` VALUES ('2', '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2021-11-30 14:39:18', '', null, '');
INSERT INTO `sys_job` VALUES ('3', '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2021-11-30 14:39:18', '', null, '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8mb4 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES ('100', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-11-30 15:10:44');
INSERT INTO `sys_logininfor` VALUES ('101', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '验证码错误', '2021-11-30 15:24:24');
INSERT INTO `sys_logininfor` VALUES ('102', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-11-30 15:24:27');
INSERT INTO `sys_logininfor` VALUES ('103', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-11-30 15:30:26');
INSERT INTO `sys_logininfor` VALUES ('104', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-11-30 16:55:55');
INSERT INTO `sys_logininfor` VALUES ('105', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '1', '验证码已失效', '2021-11-30 16:55:55');
INSERT INTO `sys_logininfor` VALUES ('106', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-11-30 18:08:20');
INSERT INTO `sys_logininfor` VALUES ('107', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-11-30 21:37:05');
INSERT INTO `sys_logininfor` VALUES ('108', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '1', '验证码错误', '2021-12-01 05:22:38');
INSERT INTO `sys_logininfor` VALUES ('109', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '1', '验证码错误', '2021-12-01 05:22:38');
INSERT INTO `sys_logininfor` VALUES ('110', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-01 05:22:42');
INSERT INTO `sys_logininfor` VALUES ('111', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-01 08:08:49');
INSERT INTO `sys_logininfor` VALUES ('112', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-01 08:47:29');
INSERT INTO `sys_logininfor` VALUES ('113', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '验证码已失效', '2021-12-01 08:47:29');
INSERT INTO `sys_logininfor` VALUES ('114', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-01 12:19:25');
INSERT INTO `sys_logininfor` VALUES ('115', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-01 12:45:35');
INSERT INTO `sys_logininfor` VALUES ('116', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '1', '验证码已失效', '2021-12-01 16:44:40');
INSERT INTO `sys_logininfor` VALUES ('117', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-01 16:44:40');
INSERT INTO `sys_logininfor` VALUES ('118', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '1', '验证码已失效', '2021-12-01 16:44:40');
INSERT INTO `sys_logininfor` VALUES ('119', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-01 18:58:26');
INSERT INTO `sys_logininfor` VALUES ('120', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-01 19:02:42');
INSERT INTO `sys_logininfor` VALUES ('121', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-01 20:18:46');
INSERT INTO `sys_logininfor` VALUES ('122', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '验证码已失效', '2021-12-02 08:22:03');
INSERT INTO `sys_logininfor` VALUES ('123', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-02 08:22:06');
INSERT INTO `sys_logininfor` VALUES ('124', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-02 09:09:55');
INSERT INTO `sys_logininfor` VALUES ('125', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-02 09:55:06');
INSERT INTO `sys_logininfor` VALUES ('126', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-02 11:02:37');
INSERT INTO `sys_logininfor` VALUES ('127', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 11:28:09');
INSERT INTO `sys_logininfor` VALUES ('128', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 12:28:12');
INSERT INTO `sys_logininfor` VALUES ('129', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '1', '验证码已失效', '2021-12-02 12:28:12');
INSERT INTO `sys_logininfor` VALUES ('130', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 13:44:34');
INSERT INTO `sys_logininfor` VALUES ('131', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 14:35:23');
INSERT INTO `sys_logininfor` VALUES ('132', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-12-02 15:01:20');
INSERT INTO `sys_logininfor` VALUES ('133', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 15:03:44');
INSERT INTO `sys_logininfor` VALUES ('134', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-02 17:41:39');
INSERT INTO `sys_logininfor` VALUES ('135', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 17:42:17');
INSERT INTO `sys_logininfor` VALUES ('136', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 17:54:12');
INSERT INTO `sys_logininfor` VALUES ('137', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 20:23:29');
INSERT INTO `sys_logininfor` VALUES ('138', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 20:30:42');
INSERT INTO `sys_logininfor` VALUES ('139', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 21:23:27');
INSERT INTO `sys_logininfor` VALUES ('140', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-02 22:03:19');
INSERT INTO `sys_logininfor` VALUES ('141', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-03 09:22:56');
INSERT INTO `sys_logininfor` VALUES ('142', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-03 11:22:48');
INSERT INTO `sys_logininfor` VALUES ('143', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-03 12:15:38');
INSERT INTO `sys_logininfor` VALUES ('144', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-03 17:40:53');
INSERT INTO `sys_logininfor` VALUES ('145', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '退出成功', '2021-12-03 18:08:30');
INSERT INTO `sys_logininfor` VALUES ('146', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-03 18:09:33');
INSERT INTO `sys_logininfor` VALUES ('147', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-04 06:30:10');
INSERT INTO `sys_logininfor` VALUES ('148', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-04 09:17:55');
INSERT INTO `sys_logininfor` VALUES ('149', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-04 09:29:14');
INSERT INTO `sys_logininfor` VALUES ('150', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-04 09:41:03');
INSERT INTO `sys_logininfor` VALUES ('151', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-04 09:46:12');
INSERT INTO `sys_logininfor` VALUES ('152', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-04 10:45:12');
INSERT INTO `sys_logininfor` VALUES ('153', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-04 11:48:24');
INSERT INTO `sys_logininfor` VALUES ('154', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-04 13:23:41');
INSERT INTO `sys_logininfor` VALUES ('155', 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '0', '登录成功', '2021-12-04 13:27:04');
INSERT INTO `sys_logininfor` VALUES ('156', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-04 14:04:07');
INSERT INTO `sys_logininfor` VALUES ('157', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-04 14:40:20');
INSERT INTO `sys_logininfor` VALUES ('158', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-04 19:22:40');
INSERT INTO `sys_logininfor` VALUES ('159', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-04 19:31:09');
INSERT INTO `sys_logininfor` VALUES ('160', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-05 05:15:20');
INSERT INTO `sys_logininfor` VALUES ('161', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-05 15:01:16');
INSERT INTO `sys_logininfor` VALUES ('162', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-12-05 15:42:18');
INSERT INTO `sys_logininfor` VALUES ('163', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-05 15:42:23');
INSERT INTO `sys_logininfor` VALUES ('164', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-12-05 16:01:25');
INSERT INTO `sys_logininfor` VALUES ('165', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-05 16:01:33');
INSERT INTO `sys_logininfor` VALUES ('166', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-05 17:46:20');
INSERT INTO `sys_logininfor` VALUES ('167', 'admin', '127.0.0.1', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-12-05 19:43:07');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `is_frame` int(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2005 DEFAULT CHARSET=utf8mb4 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', 'system', null, '1', '0', 'M', '0', '0', '', 'system', 'admin', '2021-11-30 14:39:17', '', null, '系统管理目录');
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '2', 'monitor', null, '1', '0', 'M', '0', '0', '', 'monitor', 'admin', '2021-11-30 14:39:17', '', null, '系统监控目录');
INSERT INTO `sys_menu` VALUES ('3', '系统工具', '0', '3', 'tool', null, '1', '0', 'M', '0', '0', '', 'tool', 'admin', '2021-11-30 14:39:17', '', null, '系统工具目录');
INSERT INTO `sys_menu` VALUES ('4', '若依官网', '0', '4', 'http://ruoyi.vip', null, '0', '0', 'M', '0', '0', '', 'guide', 'admin', '2021-11-30 14:39:17', '', null, '若依官网地址');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', 'user', 'system/user/index', '1', '0', 'C', '0', '0', 'system:user:list', 'user', 'admin', '2021-11-30 14:39:17', '', null, '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', 'role', 'system/role/index', '1', '0', 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2021-11-30 14:39:17', '', null, '角色管理菜单');
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', 'menu', 'system/menu/index', '1', '0', 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2021-11-30 14:39:17', '', null, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES ('103', '部门管理', '1', '4', 'dept', 'system/dept/index', '1', '0', 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2021-11-30 14:39:17', '', null, '部门管理菜单');
INSERT INTO `sys_menu` VALUES ('104', '岗位管理', '1', '5', 'post', 'system/post/index', '1', '0', 'C', '0', '0', 'system:post:list', 'post', 'admin', '2021-11-30 14:39:17', '', null, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES ('105', '字典管理', '1', '6', 'dict', 'system/dict/index', '1', '0', 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2021-11-30 14:39:17', '', null, '字典管理菜单');
INSERT INTO `sys_menu` VALUES ('106', '参数设置', '1', '7', 'config', 'system/config/index', '1', '0', 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2021-11-30 14:39:17', '', null, '参数设置菜单');
INSERT INTO `sys_menu` VALUES ('107', '通知公告', '1', '8', 'notice', 'system/notice/index', '1', '0', 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2021-11-30 14:39:17', '', null, '通知公告菜单');
INSERT INTO `sys_menu` VALUES ('108', '日志管理', '1', '9', 'log', '', '1', '0', 'M', '0', '0', '', 'log', 'admin', '2021-11-30 14:39:17', '', null, '日志管理菜单');
INSERT INTO `sys_menu` VALUES ('109', '在线用户', '2', '1', 'online', 'monitor/online/index', '1', '0', 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2021-11-30 14:39:17', '', null, '在线用户菜单');
INSERT INTO `sys_menu` VALUES ('110', '定时任务', '2', '2', 'job', 'monitor/job/index', '1', '0', 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2021-11-30 14:39:17', '', null, '定时任务菜单');
INSERT INTO `sys_menu` VALUES ('111', '数据监控', '2', '3', 'druid', 'monitor/druid/index', '1', '0', 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2021-11-30 14:39:17', '', null, '数据监控菜单');
INSERT INTO `sys_menu` VALUES ('112', '服务监控', '2', '4', 'server', 'monitor/server/index', '1', '0', 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2021-11-30 14:39:17', '', null, '服务监控菜单');
INSERT INTO `sys_menu` VALUES ('113', '缓存监控', '2', '5', 'cache', 'monitor/cache/index', '1', '0', 'C', '0', '0', 'monitor:cache:list', 'redis', 'admin', '2021-11-30 14:39:17', '', null, '缓存监控菜单');
INSERT INTO `sys_menu` VALUES ('114', '表单构建', '3', '1', 'build', 'tool/build/index', '1', '0', 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2021-11-30 14:39:17', '', null, '表单构建菜单');
INSERT INTO `sys_menu` VALUES ('115', '代码生成', '3', '2', 'gen', 'tool/gen/index', '1', '0', 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2021-11-30 14:39:17', '', null, '代码生成菜单');
INSERT INTO `sys_menu` VALUES ('116', '系统接口', '3', '3', 'swagger', 'tool/swagger/index', '1', '0', 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2021-11-30 14:39:17', '', null, '系统接口菜单');
INSERT INTO `sys_menu` VALUES ('500', '操作日志', '108', '1', 'operlog', 'monitor/operlog/index', '1', '0', 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2021-11-30 14:39:17', '', null, '操作日志菜单');
INSERT INTO `sys_menu` VALUES ('501', '登录日志', '108', '2', 'logininfor', 'monitor/logininfor/index', '1', '0', 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2021-11-30 14:39:17', '', null, '登录日志菜单');
INSERT INTO `sys_menu` VALUES ('1001', '用户查询', '100', '1', '', '', '1', '0', 'F', '0', '0', 'system:user:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1002', '用户新增', '100', '2', '', '', '1', '0', 'F', '0', '0', 'system:user:add', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1003', '用户修改', '100', '3', '', '', '1', '0', 'F', '0', '0', 'system:user:edit', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1004', '用户删除', '100', '4', '', '', '1', '0', 'F', '0', '0', 'system:user:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1005', '用户导出', '100', '5', '', '', '1', '0', 'F', '0', '0', 'system:user:export', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1006', '用户导入', '100', '6', '', '', '1', '0', 'F', '0', '0', 'system:user:import', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1007', '重置密码', '100', '7', '', '', '1', '0', 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1008', '角色查询', '101', '1', '', '', '1', '0', 'F', '0', '0', 'system:role:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1009', '角色新增', '101', '2', '', '', '1', '0', 'F', '0', '0', 'system:role:add', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1010', '角色修改', '101', '3', '', '', '1', '0', 'F', '0', '0', 'system:role:edit', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1011', '角色删除', '101', '4', '', '', '1', '0', 'F', '0', '0', 'system:role:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1012', '角色导出', '101', '5', '', '', '1', '0', 'F', '0', '0', 'system:role:export', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1013', '菜单查询', '102', '1', '', '', '1', '0', 'F', '0', '0', 'system:menu:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1014', '菜单新增', '102', '2', '', '', '1', '0', 'F', '0', '0', 'system:menu:add', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1015', '菜单修改', '102', '3', '', '', '1', '0', 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1016', '菜单删除', '102', '4', '', '', '1', '0', 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1017', '部门查询', '103', '1', '', '', '1', '0', 'F', '0', '0', 'system:dept:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1018', '部门新增', '103', '2', '', '', '1', '0', 'F', '0', '0', 'system:dept:add', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1019', '部门修改', '103', '3', '', '', '1', '0', 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1020', '部门删除', '103', '4', '', '', '1', '0', 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1021', '岗位查询', '104', '1', '', '', '1', '0', 'F', '0', '0', 'system:post:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1022', '岗位新增', '104', '2', '', '', '1', '0', 'F', '0', '0', 'system:post:add', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1023', '岗位修改', '104', '3', '', '', '1', '0', 'F', '0', '0', 'system:post:edit', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1024', '岗位删除', '104', '4', '', '', '1', '0', 'F', '0', '0', 'system:post:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1025', '岗位导出', '104', '5', '', '', '1', '0', 'F', '0', '0', 'system:post:export', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1026', '字典查询', '105', '1', '#', '', '1', '0', 'F', '0', '0', 'system:dict:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1027', '字典新增', '105', '2', '#', '', '1', '0', 'F', '0', '0', 'system:dict:add', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1028', '字典修改', '105', '3', '#', '', '1', '0', 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1029', '字典删除', '105', '4', '#', '', '1', '0', 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1030', '字典导出', '105', '5', '#', '', '1', '0', 'F', '0', '0', 'system:dict:export', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1031', '参数查询', '106', '1', '#', '', '1', '0', 'F', '0', '0', 'system:config:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1032', '参数新增', '106', '2', '#', '', '1', '0', 'F', '0', '0', 'system:config:add', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1033', '参数修改', '106', '3', '#', '', '1', '0', 'F', '0', '0', 'system:config:edit', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1034', '参数删除', '106', '4', '#', '', '1', '0', 'F', '0', '0', 'system:config:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1035', '参数导出', '106', '5', '#', '', '1', '0', 'F', '0', '0', 'system:config:export', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1036', '公告查询', '107', '1', '#', '', '1', '0', 'F', '0', '0', 'system:notice:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1037', '公告新增', '107', '2', '#', '', '1', '0', 'F', '0', '0', 'system:notice:add', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1038', '公告修改', '107', '3', '#', '', '1', '0', 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1039', '公告删除', '107', '4', '#', '', '1', '0', 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1040', '操作查询', '500', '1', '#', '', '1', '0', 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1041', '操作删除', '500', '2', '#', '', '1', '0', 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1042', '日志导出', '500', '4', '#', '', '1', '0', 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1043', '登录查询', '501', '1', '#', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1044', '登录删除', '501', '2', '#', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1045', '日志导出', '501', '3', '#', '', '1', '0', 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1046', '在线查询', '109', '1', '#', '', '1', '0', 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1047', '批量强退', '109', '2', '#', '', '1', '0', 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1048', '单条强退', '109', '3', '#', '', '1', '0', 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1049', '任务查询', '110', '1', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1050', '任务新增', '110', '2', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1051', '任务修改', '110', '3', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1052', '任务删除', '110', '4', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1053', '状态修改', '110', '5', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1054', '任务导出', '110', '7', '#', '', '1', '0', 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1055', '生成查询', '115', '1', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1056', '生成修改', '115', '2', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1057', '生成删除', '115', '3', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1058', '导入代码', '115', '2', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1059', '预览代码', '115', '4', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('1060', '生成代码', '115', '5', '#', '', '1', '0', 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_menu` VALUES ('2001', '自动生成', '0', '2', 'cg', null, '1', '0', 'M', '0', '0', '', 'build', 'admin', '2021-11-29 16:43:37', 'admin', '2021-11-29 16:59:52', '');
INSERT INTO `sys_menu` VALUES ('2002', 'Single Table', '2001', '1', 'single-table', 'cg/single-Table', '1', '0', 'C', '0', '1', 'cg:singleTable', 'code', 'admin', '2021-11-29 16:44:18', 'admin', '2021-12-02 09:15:55', '');
INSERT INTO `sys_menu` VALUES ('2003', '单表配置1.0', '2001', '2', '/singleTableConfig1', 'cg/singleTableModifyV1', '1', '0', 'C', '0', '0', 'cg:singleTable1', 'documentation', 'admin', '2021-12-01 08:55:13', 'admin', '2021-12-01 08:56:55', '');
INSERT INTO `sys_menu` VALUES ('2004', '单表维护1.0', '2001', '3', 'singleTableView/915558641136828416', 'cg/singleTableView', '1', '0', 'C', '0', '0', '', 'button', 'admin', '2021-12-02 09:15:36', 'admin', '2021-12-02 10:27:19', '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('1', '温馨提醒：2018-07-01 若依新版本发布啦', '2', 0xE696B0E78988E69CACE58685E5AEB9, '0', 'admin', '2021-11-30 14:39:18', '', null, '管理员');
INSERT INTO `sys_notice` VALUES ('2', '维护通知：2018-07-01 若依系统凌晨维护', '1', 0xE7BBB4E68AA4E58685E5AEB9, '0', 'admin', '2021-11-30 14:39:18', '', null, '管理员');
INSERT INTO `sys_notice` VALUES ('3', '3', '3', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES ('100', '菜单管理', '1', 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"documentation\",\"orderNum\":\"2\",\"menuName\":\"单表配置1.0\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"/singleTableConfig1\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-01 08:55:13');
INSERT INTO `sys_oper_log` VALUES ('101', '菜单管理', '2', 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"documentation\",\"orderNum\":\"2\",\"menuName\":\"单表配置1.0\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"/singleTableConfig1\",\"component\":\"singleTableModifyV1\",\"children\":[],\"createTime\":1638320113000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2003,\"menuType\":\"C\",\"perms\":\"cg:singleTable1\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-01 08:56:44');
INSERT INTO `sys_oper_log` VALUES ('102', '菜单管理', '2', 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"documentation\",\"orderNum\":\"2\",\"menuName\":\"单表配置1.0\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"/singleTableConfig1\",\"component\":\"cg/singleTableModifyV1\",\"children\":[],\"createTime\":1638320113000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2003,\"menuType\":\"C\",\"perms\":\"cg:singleTable1\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-01 08:56:55');
INSERT INTO `sys_oper_log` VALUES ('103', '代码生成', '6', 'com.ruoyi.generator.controller.GenController.importTableSave()', 'POST', '1', 'admin', null, '/tool/gen/importTable', '127.0.0.1', '内网IP', 'cg_meta_com_prop_rel', 'null', '1', '导入失败：\r\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'function_name\' at row 1\r\n### The error may exist in file [F:\\PersonalProject\\Design\\source\\ruoyi-generator\\target\\classes\\mapper\\generator\\GenTableMapper.xml]\r\n### The error may involve com.ruoyi.generator.mapper.GenTableMapper.insertGenTable-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into gen_table (     table_name,      table_comment,      class_name,           package_name,      module_name,      business_name,      function_name,      function_author,                      create_by,     create_time          )values(     ?,      ?,      ?,           ?,      ?,      ?,      ?,      ?,                      ?,     sysdate()          )\r\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'function_name\' at row 1\n; Data truncation: Data too long for column \'function_name\' at row 1; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'function_name\' at row 1', '2021-12-01 12:26:23');
INSERT INTO `sys_oper_log` VALUES ('104', '菜单管理', '1', 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"button\",\"orderNum\":\"3\",\"menuName\":\"单表测试\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"cg/singleTableView\",\"component\":\"cg/singleTableView\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-02 09:15:36');
INSERT INTO `sys_oper_log` VALUES ('105', '菜单管理', '2', 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"code\",\"orderNum\":\"1\",\"menuName\":\"Single Table\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"single-table\",\"component\":\"cg/single-Table\",\"children\":[],\"createTime\":1638175458000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2002,\"menuType\":\"C\",\"perms\":\"cg:singleTable\",\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-02 09:15:55');
INSERT INTO `sys_oper_log` VALUES ('106', '菜单管理', '2', 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"button\",\"orderNum\":\"3\",\"menuName\":\"单表测试\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"cg/singleTableView/1234\",\"component\":\"cg/singleTableView\",\"children\":[],\"createTime\":1638407736000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2004,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-02 09:19:40');
INSERT INTO `sys_oper_log` VALUES ('107', '菜单管理', '2', 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"button\",\"orderNum\":\"3\",\"menuName\":\"单表维护1.0\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"cg/singleTableView/1234\",\"component\":\"cg/singleTableView\",\"children\":[],\"createTime\":1638407736000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2004,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-02 09:20:31');
INSERT INTO `sys_oper_log` VALUES ('108', '菜单管理', '2', 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"button\",\"orderNum\":\"3\",\"menuName\":\"单表维护1.0\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"singleTableView/1234\",\"component\":\"cg/singleTableView\",\"children\":[],\"createTime\":1638407736000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2004,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-02 10:26:33');
INSERT INTO `sys_oper_log` VALUES ('109', '菜单管理', '2', 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', '1', 'admin', null, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"button\",\"orderNum\":\"3\",\"menuName\":\"单表维护1.0\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"singleTableView/915558641136828416\",\"component\":\"cg/singleTableView\",\"children\":[],\"createTime\":1638407736000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2004,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-02 10:27:19');
INSERT INTO `sys_oper_log` VALUES ('110', '字典类型', '2', 'com.ruoyi.web.controller.system.SysDictTypeController.edit()', 'PUT', '1', 'admin', null, '/system/dict/type', '127.0.0.1', '内网IP', '{\"createBy\":\"admin\",\"createTime\":1638222493000,\"updateBy\":\"admin\",\"dictName\":\"组件类型\",\"remark\":\"组件类型\",\"dictId\":103,\"params\":{},\"dictType\":\"CG_DOM_TYPE\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-04 07:33:54');
INSERT INTO `sys_oper_log` VALUES ('111', '字典数据', '1', 'com.ruoyi.web.controller.system.SysDictDataController.add()', 'POST', '1', 'admin', null, '/system/dict/data', '127.0.0.1', '内网IP', '{\"dictValue\":\"0301\",\"listClass\":\"default\",\"dictSort\":0,\"params\":{},\"dictType\":\"CG_COM_TYPE\",\"dictLabel\":\"下拉\",\"createBy\":\"admin\",\"default\":false,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', '0', null, '2021-12-04 07:37:51');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES ('1', 'ceo', '董事长', '1', '0', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_post` VALUES ('2', 'se', '项目经理', '2', '0', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_post` VALUES ('3', 'hr', '人力资源', '3', '0', 'admin', '2021-11-30 14:39:17', '', null, '');
INSERT INTO `sys_post` VALUES ('4', 'user', '普通员工', '4', '0', 'admin', '2021-11-30 14:39:17', '', null, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) DEFAULT '1' COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) DEFAULT '1' COMMENT '部门树选择项是否关联显示',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'admin', '1', '1', '1', '1', '0', '0', 'admin', '2021-11-30 14:39:17', '', null, '超级管理员');
INSERT INTO `sys_role` VALUES ('2', '普通角色', 'common', '2', '2', '1', '1', '0', '0', 'admin', '2021-11-30 14:39:17', '', null, '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('2', '100');
INSERT INTO `sys_role_dept` VALUES ('2', '101');
INSERT INTO `sys_role_dept` VALUES ('2', '105');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '3');
INSERT INTO `sys_role_menu` VALUES ('2', '4');
INSERT INTO `sys_role_menu` VALUES ('2', '100');
INSERT INTO `sys_role_menu` VALUES ('2', '101');
INSERT INTO `sys_role_menu` VALUES ('2', '102');
INSERT INTO `sys_role_menu` VALUES ('2', '103');
INSERT INTO `sys_role_menu` VALUES ('2', '104');
INSERT INTO `sys_role_menu` VALUES ('2', '105');
INSERT INTO `sys_role_menu` VALUES ('2', '106');
INSERT INTO `sys_role_menu` VALUES ('2', '107');
INSERT INTO `sys_role_menu` VALUES ('2', '108');
INSERT INTO `sys_role_menu` VALUES ('2', '109');
INSERT INTO `sys_role_menu` VALUES ('2', '110');
INSERT INTO `sys_role_menu` VALUES ('2', '111');
INSERT INTO `sys_role_menu` VALUES ('2', '112');
INSERT INTO `sys_role_menu` VALUES ('2', '113');
INSERT INTO `sys_role_menu` VALUES ('2', '114');
INSERT INTO `sys_role_menu` VALUES ('2', '115');
INSERT INTO `sys_role_menu` VALUES ('2', '116');
INSERT INTO `sys_role_menu` VALUES ('2', '500');
INSERT INTO `sys_role_menu` VALUES ('2', '501');
INSERT INTO `sys_role_menu` VALUES ('2', '1000');
INSERT INTO `sys_role_menu` VALUES ('2', '1001');
INSERT INTO `sys_role_menu` VALUES ('2', '1002');
INSERT INTO `sys_role_menu` VALUES ('2', '1003');
INSERT INTO `sys_role_menu` VALUES ('2', '1004');
INSERT INTO `sys_role_menu` VALUES ('2', '1005');
INSERT INTO `sys_role_menu` VALUES ('2', '1006');
INSERT INTO `sys_role_menu` VALUES ('2', '1007');
INSERT INTO `sys_role_menu` VALUES ('2', '1008');
INSERT INTO `sys_role_menu` VALUES ('2', '1009');
INSERT INTO `sys_role_menu` VALUES ('2', '1010');
INSERT INTO `sys_role_menu` VALUES ('2', '1011');
INSERT INTO `sys_role_menu` VALUES ('2', '1012');
INSERT INTO `sys_role_menu` VALUES ('2', '1013');
INSERT INTO `sys_role_menu` VALUES ('2', '1014');
INSERT INTO `sys_role_menu` VALUES ('2', '1015');
INSERT INTO `sys_role_menu` VALUES ('2', '1016');
INSERT INTO `sys_role_menu` VALUES ('2', '1017');
INSERT INTO `sys_role_menu` VALUES ('2', '1018');
INSERT INTO `sys_role_menu` VALUES ('2', '1019');
INSERT INTO `sys_role_menu` VALUES ('2', '1020');
INSERT INTO `sys_role_menu` VALUES ('2', '1021');
INSERT INTO `sys_role_menu` VALUES ('2', '1022');
INSERT INTO `sys_role_menu` VALUES ('2', '1023');
INSERT INTO `sys_role_menu` VALUES ('2', '1024');
INSERT INTO `sys_role_menu` VALUES ('2', '1025');
INSERT INTO `sys_role_menu` VALUES ('2', '1026');
INSERT INTO `sys_role_menu` VALUES ('2', '1027');
INSERT INTO `sys_role_menu` VALUES ('2', '1028');
INSERT INTO `sys_role_menu` VALUES ('2', '1029');
INSERT INTO `sys_role_menu` VALUES ('2', '1030');
INSERT INTO `sys_role_menu` VALUES ('2', '1031');
INSERT INTO `sys_role_menu` VALUES ('2', '1032');
INSERT INTO `sys_role_menu` VALUES ('2', '1033');
INSERT INTO `sys_role_menu` VALUES ('2', '1034');
INSERT INTO `sys_role_menu` VALUES ('2', '1035');
INSERT INTO `sys_role_menu` VALUES ('2', '1036');
INSERT INTO `sys_role_menu` VALUES ('2', '1037');
INSERT INTO `sys_role_menu` VALUES ('2', '1038');
INSERT INTO `sys_role_menu` VALUES ('2', '1039');
INSERT INTO `sys_role_menu` VALUES ('2', '1040');
INSERT INTO `sys_role_menu` VALUES ('2', '1041');
INSERT INTO `sys_role_menu` VALUES ('2', '1042');
INSERT INTO `sys_role_menu` VALUES ('2', '1043');
INSERT INTO `sys_role_menu` VALUES ('2', '1044');
INSERT INTO `sys_role_menu` VALUES ('2', '1045');
INSERT INTO `sys_role_menu` VALUES ('2', '1046');
INSERT INTO `sys_role_menu` VALUES ('2', '1047');
INSERT INTO `sys_role_menu` VALUES ('2', '1048');
INSERT INTO `sys_role_menu` VALUES ('2', '1049');
INSERT INTO `sys_role_menu` VALUES ('2', '1050');
INSERT INTO `sys_role_menu` VALUES ('2', '1051');
INSERT INTO `sys_role_menu` VALUES ('2', '1052');
INSERT INTO `sys_role_menu` VALUES ('2', '1053');
INSERT INTO `sys_role_menu` VALUES ('2', '1054');
INSERT INTO `sys_role_menu` VALUES ('2', '1055');
INSERT INTO `sys_role_menu` VALUES ('2', '1056');
INSERT INTO `sys_role_menu` VALUES ('2', '1057');
INSERT INTO `sys_role_menu` VALUES ('2', '1058');
INSERT INTO `sys_role_menu` VALUES ('2', '1059');
INSERT INTO `sys_role_menu` VALUES ('2', '1060');
INSERT INTO `sys_role_menu` VALUES ('2', '2001');
INSERT INTO `sys_role_menu` VALUES ('2', '2002');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '103', 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2021-12-05 19:43:09', 'admin', '2021-11-30 14:39:17', '', '2021-12-05 19:43:06', '管理员');
INSERT INTO `sys_user` VALUES ('2', '105', 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2021-11-30 14:39:17', 'admin', '2021-11-30 14:39:17', '', null, '测试员');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES ('1', '1');
INSERT INTO `sys_user_post` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
