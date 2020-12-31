/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50519
Source Host           : 127.0.0.1:3306
Source Database       : bg-db

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2021-01-01 00:12:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wx_config
-- ----------------------------
DROP TABLE IF EXISTS `wx_config`;
CREATE TABLE `wx_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_name` varchar(128) DEFAULT NULL COMMENT '公众号名称',
  `app_id` varchar(128) DEFAULT NULL COMMENT '小程序APPID',
  `app_secret` varchar(128) DEFAULT NULL COMMENT '小程序密钥',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '属于哪个单位',
  `encoding_aes_key` varchar(255) DEFAULT NULL COMMENT '公众号EncodingAESKey',
  `token` varchar(128) DEFAULT NULL COMMENT '公众号token',
  `access_token` varchar(255) DEFAULT NULL COMMENT '公众号access_token',
  `access_token_expires` int(10) DEFAULT NULL COMMENT '公众号有效期',
  `access_token_lastat` varchar(50) DEFAULT NULL COMMENT '公众号最后一次token',
  `pay_state` tinyint(1) DEFAULT NULL COMMENT '支付状态（0 禁用 1 启用）',
  `pay_info` varchar(2000) DEFAULT NULL COMMENT '支付信息',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员编号',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='微信配置';

-- ----------------------------
-- Records of wx_config
-- ----------------------------

-- ----------------------------
-- Table structure for wx_menu
-- ----------------------------
DROP TABLE IF EXISTS `wx_menu`;
CREATE TABLE `wx_menu` (
  `id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父ID',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位id',
  `path` varchar(255) DEFAULT NULL COMMENT '树路径',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `menu_type` tinyint(1) DEFAULT NULL COMMENT '菜单类型',
  `menu_key` varchar(255) DEFAULT NULL COMMENT '关键词',
  `url` varchar(255) DEFAULT NULL COMMENT '网址',
  `app_id` int(11) DEFAULT NULL COMMENT '小程序appid',
  `page_path` varchar(255) DEFAULT NULL COMMENT '小程序入口页',
  `has_children` tinyint(1) DEFAULT NULL COMMENT '有子节点',
  `wx_id` bigint(20) DEFAULT NULL,
  `sort` tinyint(2) DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员编号',
  `data_state` tinyint(1) DEFAULT NULL COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='微信菜单';

-- ----------------------------
-- Records of wx_menu
-- ----------------------------

-- ----------------------------
-- Table structure for wx_template_id
-- ----------------------------
DROP TABLE IF EXISTS `wx_template_id`;
CREATE TABLE `wx_template_id` (
  `id` bigint(20) NOT NULL,
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位id',
  `template_id` varchar(255) DEFAULT NULL COMMENT '模板编号',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员编号',
  `data_state` tinyint(1) DEFAULT NULL COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='微信发送消息模板ID';

-- ----------------------------
-- Records of wx_template_id
-- ----------------------------

-- ----------------------------
-- Table structure for wx_template_list
-- ----------------------------
DROP TABLE IF EXISTS `wx_template_list`;
CREATE TABLE `wx_template_list` (
  `id` bigint(20) NOT NULL,
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位id',
  `template_id` varchar(255) DEFAULT NULL COMMENT '模板编号',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员编号',
  `data_state` tinyint(1) DEFAULT NULL COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  `title` varchar(255) DEFAULT NULL COMMENT '模板标题',
  `content` varchar(255) DEFAULT NULL COMMENT '模板内容',
  `example` varchar(255) DEFAULT NULL COMMENT '模板示例',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='微信发送消息模板列表';

-- ----------------------------
-- Records of wx_template_list
-- ----------------------------

-- ----------------------------
-- Table structure for wx_template_log
-- ----------------------------
DROP TABLE IF EXISTS `wx_template_log`;
CREATE TABLE `wx_template_log` (
  `id` bigint(20) NOT NULL,
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位id',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `open_id` varchar(128) DEFAULT NULL COMMENT 'openid',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '微信昵称',
  `content` varchar(255) DEFAULT NULL COMMENT '发送内容',
  `result` varchar(255) DEFAULT NULL COMMENT '发送结果',
  `status` tinyint(1) DEFAULT NULL COMMENT '发送状态(0 默认 1 成功 2 失败)',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员编号',
  `data_state` tinyint(1) DEFAULT NULL COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='微信发送消息模板发送日志';

-- ----------------------------
-- Records of wx_template_log
-- ----------------------------

-- ----------------------------
-- Table structure for wx_user
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user` (
  `id` bigint(20) NOT NULL,
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位id',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `open_id` varchar(128) DEFAULT NULL COMMENT 'openid',
  `union_id` varchar(11) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL COMMENT '微信昵称',
  `subscribe` tinyint(1) DEFAULT NULL COMMENT '关注时间否 1 关注）',
  `subscribe_time` datetime DEFAULT NULL COMMENT '关注时间',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `country` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `head_img_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人员编号',
  `data_state` tinyint(1) DEFAULT NULL COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='微信会员列表';

-- ----------------------------
-- Records of wx_user
-- ----------------------------
