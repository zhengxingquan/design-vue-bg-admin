/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : bg-user

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2021-01-07 20:33:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_data_field
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_field`;
CREATE TABLE `sys_data_field` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` varchar(128) NOT NULL COMMENT '数据表ID',
  `name` varchar(100) NOT NULL COMMENT '中文名称',
  `data_field_code` varchar(128) DEFAULT NULL COMMENT '编码',
  `physical_name` varchar(100) NOT NULL COMMENT '物理名称',
  `enum_data_field_id` bigint(20) DEFAULT NULL COMMENT '枚举依赖字段id',
  `enum_depend_field_id` varchar(500) DEFAULT NULL COMMENT '被依赖字段id',
  `association_id` varchar(128) DEFAULT NULL COMMENT '关联编号',
  `enum_id` bigint(20) DEFAULT NULL COMMENT '枚举值id',
  `data_field_property` tinyint(1) NOT NULL COMMENT '字段属性：1=逻辑字段，2=物理字段',
  `data_field_length` int(32) DEFAULT NULL COMMENT '字段长度',
  `required_data_field` tinyint(1) DEFAULT '0' COMMENT '字段是否必填',
  `data_field_type_id` bigint(20) NOT NULL COMMENT '字段类型ID',
  `decimal_length` tinyint(1) DEFAULT '0' COMMENT '小数位数长度，（主要针对于 实数类型 ）',
  `regex_expression` varchar(500) DEFAULT NULL COMMENT '正则表达式',
  `expression_id` varchar(500) DEFAULT NULL COMMENT '字段记录引用id',
  `tooltip` varchar(200) DEFAULT NULL COMMENT '提示信息',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `index_able` tinyint(1) DEFAULT '0' COMMENT '是否建立索引(0 不是索引 ， 1 是索引)',
  `data_field_state` tinyint(1) DEFAULT '0' COMMENT '字段类别(0 共有字段 1 私有字段)',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `path` varchar(255) NOT NULL COMMENT '树路径',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员ID',
  `data_state` tinyint(1) DEFAULT NULL COMMENT '数据状态 (0启动 -1 冻结 1删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字段表';

-- ----------------------------
-- Table structure for sys_data_field_property
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_field_property`;
CREATE TABLE `sys_data_field_property` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父节点',
  `name` varchar(60) NOT NULL COMMENT '名称',
  `code` varchar(50) NOT NULL,
  `sys_code` varchar(128) DEFAULT NULL COMMENT '系统编码(用于查询使用，全局唯一)',
  `db_field_type` varchar(60) NOT NULL COMMENT '数据库中数据类型',
  `note` varchar(255) DEFAULT NULL COMMENT '简介',
  `path` varchar(128) NOT NULL COMMENT '路径',
  `sort` int(32) NOT NULL COMMENT '排序字段',
  `has_children` tinyint(1) DEFAULT '0' COMMENT '是否有子节点',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 (0启动 -1 冻结 1删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字段属性表';

-- ----------------------------
-- Table structure for sys_data_table
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_table`;
CREATE TABLE `sys_data_table` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` bigint(20) NOT NULL COMMENT '仓库的ID',
  `name` varchar(100) NOT NULL COMMENT '中文名称',
  `physical_name` varchar(100) NOT NULL COMMENT '物理名称',
  `table_type` tinyint(1) DEFAULT NULL COMMENT '表类型，1=主表， 2=从表',
  `table_code` varchar(50) DEFAULT NULL COMMENT '编码',
  `note` varchar(255) DEFAULT NULL COMMENT '简介',
  `tooltip` varchar(255) DEFAULT NULL COMMENT '提示信息',
  `copy_table_id` bigint(20) DEFAULT NULL COMMENT '复制表结构id',
  `path` varchar(100) NOT NULL,
  `has_children` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `sort` int(5) DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 (0启动 -1 冻结 1删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统数据表';

-- ----------------------------
-- Table structure for sys_database
-- ----------------------------
DROP TABLE IF EXISTS `sys_database`;
CREATE TABLE `sys_database` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` varchar(128) DEFAULT NULL COMMENT '父节点',
  `name` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `physical_name` varchar(100) DEFAULT NULL COMMENT '物理名称',
  `database_code` varchar(50) DEFAULT NULL COMMENT '编码',
  `path` varchar(255) DEFAULT NULL COMMENT '树路径',
  `has_children` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `note` varchar(255) DEFAULT NULL COMMENT '简介',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 (0启动 -1 冻结 1删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统数据仓库表';

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `path` varchar(255) DEFAULT NULL COMMENT '树路径',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(20) DEFAULT NULL COMMENT '编码',
  `sys_code` varchar(128) DEFAULT NULL COMMENT '系统编码(用于查询使用，全局唯一)',
  `has_children` tinyint(1) DEFAULT NULL COMMENT '有子节点',
  `field1` varchar(200) DEFAULT NULL COMMENT '附加值一',
  `field2` varchar(200) DEFAULT NULL COMMENT '附加值二',
  `field3` varchar(200) DEFAULT NULL COMMENT '附加值三',
  `note` varchar(200) DEFAULT NULL COMMENT '字典简介',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '操作人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(1) DEFAULT NULL COMMENT '更新人员的ID',
  `data_state` tinyint(1) DEFAULT '0' COMMENT '数据状态 (0启动 -1 冻结 1删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_DICT_PATH` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典表';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `alias_name` varchar(100) DEFAULT NULL COMMENT '菜单别名',
  `code` varchar(50) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `type` tinyint(1) DEFAULT NULL COMMENT '资源类型(0 资源对象 1 菜单对象)',
  `href` varchar(255) DEFAULT NULL COMMENT '菜单链接',
  `target` varchar(50) DEFAULT NULL COMMENT '打开方式',
  `menu_icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `note` varchar(255) DEFAULT NULL COMMENT '菜单介绍',
  `has_children` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime NOT NULL COMMENT '操作时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '操作人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL,
  `data_state` tinyint(1) DEFAULT '0' COMMENT '数据状态 (0启动 -1 冻结 1删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Table structure for sys_menu_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_group`;
CREATE TABLE `sys_menu_group` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `group_name` varchar(100) DEFAULT NULL COMMENT '组名称',
  `group_alias_name` varchar(100) DEFAULT NULL COMMENT '组别名',
  `group_code` varchar(50) DEFAULT NULL COMMENT '编码',
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `note` varchar(255) DEFAULT NULL COMMENT '菜单介绍',
  `has_children` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime NOT NULL COMMENT '操作时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '操作人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL,
  `data_state` tinyint(1) DEFAULT '0' COMMENT '数据状态 (0启动 -1 冻结 1删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_MENU_PATH` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单分组表';

-- ----------------------------
-- Table structure for sys_menu_group_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_group_details`;
CREATE TABLE `sys_menu_group_details` (
  `menu_group_id` bigint(20) NOT NULL COMMENT '菜单分组ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单分组与菜单对应表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父节点',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `code` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `alias_name` varchar(50) DEFAULT NULL COMMENT '角色别名',
  `has_children` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `path` varchar(128) DEFAULT NULL COMMENT '路径编码用于查询与删除',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 (0启动 -1 冻结 1删除)',
  PRIMARY KEY (`id`),
  KEY `INDEX_SYS_ROLE_PATH` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Table structure for sys_role_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_group`;
CREATE TABLE `sys_role_group` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父节点',
  `group_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `group_code` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `group_alias_name` varchar(50) DEFAULT NULL COMMENT '角色别名',
  `has_children` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `path` varchar(128) DEFAULT NULL COMMENT '路径编码用于查询与删除',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime DEFAULT NULL,
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 (0启动 -1 冻结 1删除)',
  PRIMARY KEY (`id`),
  KEY `INDEX_SYS_ROLE_PATH` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色分组表';

-- ----------------------------
-- Table structure for sys_role_group_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_group_details`;
CREATE TABLE `sys_role_group_details` (
  `role_group_id` bigint(20) NOT NULL COMMENT '角色分组ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色分组与角色对应表';

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_menu_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_group`;
CREATE TABLE `sys_role_menu_group` (
  `menu_group_id` bigint(20) NOT NULL,
  `role_group_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_unit
-- ----------------------------
DROP TABLE IF EXISTS `sys_unit`;
CREATE TABLE `sys_unit` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `name` varchar(100) DEFAULT NULL COMMENT '单位名称',
  `alias_name` varchar(100) DEFAULT NULL COMMENT '单位别名',
  `unit_code` varchar(32) DEFAULT NULL COMMENT '机构编码',
  `path` varchar(128) DEFAULT NULL COMMENT '路径',
  `field1` varchar(200) DEFAULT NULL COMMENT '附加值一',
  `field2` varchar(200) DEFAULT NULL COMMENT '附加值二',
  `field3` varchar(200) DEFAULT NULL COMMENT '附加值三',
  `note` varchar(255) DEFAULT NULL COMMENT '单位介绍',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `has_children` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '编辑人员ID',
  `data_state` tinyint(1) DEFAULT '0' COMMENT '数据状态 (0启动 -1 冻结 1删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_UNIT_UNITCODE` (`unit_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统单位表';

-- ----------------------------
-- Table structure for sys_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
  `menu_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_group`;
CREATE TABLE `sys_user_role_group` (
  `group_role_id` bigint(20) NOT NULL,
  `group_user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
