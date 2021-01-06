/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50519
Source Host           : 127.0.0.1:3306
Source Database       : bg-db

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2021-01-06 23:43:43
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信配置';

-- ----------------------------
-- Records of wx_config
-- ----------------------------

-- ----------------------------
-- Table structure for wx_mass_msg
-- ----------------------------
DROP TABLE IF EXISTS `wx_mass_msg`;
CREATE TABLE `wx_mass_msg` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '群发名称',
  `type` tinyint(1) DEFAULT NULL COMMENT '群发类型（文本，图片，图文）',
  `media_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '媒体文件ID',
  `pic_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片文件',
  `scope` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '发送范围（全部会员，部分会员）',
  `content` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '发送内容',
  `status` tinyint(1) DEFAULT NULL COMMENT '成功与失败(0）',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(11) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `update_user_id` bigint(11) DEFAULT NULL COMMENT '编辑人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信群发消息配置表';

-- ----------------------------
-- Records of wx_mass_msg
-- ----------------------------

-- ----------------------------
-- Table structure for wx_mass_news
-- ----------------------------
DROP TABLE IF EXISTS `wx_mass_news`;
CREATE TABLE `wx_mass_news` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位',
  `thumb_media_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '缩略图ID',
  `pic_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '缩略图URL',
  `author` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '作者',
  `title` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
  `source_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '原地址',
  `content` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '图文内容',
  `digest` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '摘要',
  `show_cover_pic` tinyint(1) DEFAULT '0' COMMENT '显示封面(1显示0不显示)',
  `need_open_comment` tinyint(1) DEFAULT '0' COMMENT '是否打开评论(1打开0不打开)',
  `only_fans_can_comment` tinyint(1) DEFAULT NULL COMMENT '是否粉丝才可评论（0所有人可评论，1粉丝才可评论）',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(11) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `update_user_id` bigint(11) DEFAULT NULL COMMENT '编辑人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信群发素材配置表';

-- ----------------------------
-- Records of wx_mass_news
-- ----------------------------

-- ----------------------------
-- Table structure for wx_mass_send
-- ----------------------------
DROP TABLE IF EXISTS `wx_mass_send`;
CREATE TABLE `wx_mass_send` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位',
  `mass_id` bigint(20) DEFAULT NULL COMMENT '群发ID',
  `open_ids` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT 'Openid列表',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `msg_id` bigint(20) DEFAULT NULL COMMENT '消息ID',
  `status` tinyint(1) DEFAULT '0' COMMENT '发送状态(1成功 0 失败)',
  `error_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '错误状态码',
  `error_msg` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '错误消息',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(11) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `update_user_id` bigint(11) DEFAULT NULL COMMENT '编辑人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信群发具体发送状态表';

-- ----------------------------
-- Records of wx_mass_send
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信菜单';

-- ----------------------------
-- Records of wx_menu
-- ----------------------------

-- ----------------------------
-- Table structure for wx_msg_copy
-- ----------------------------
DROP TABLE IF EXISTS `wx_msg_copy`;
CREATE TABLE `wx_msg_copy` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位',
  `open_id` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '用户的唯一标识',
  `type` tinyint(1) DEFAULT NULL COMMENT '消息类型（文本，图片，图文）',
  `nick_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '微信昵称',
  `reply_id` bigint(20) DEFAULT NULL COMMENT '回复x消息的记录ID',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(11) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `update_user_id` bigint(11) DEFAULT NULL COMMENT '编辑人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户消息记录表';

-- ----------------------------
-- Records of wx_msg_copy
-- ----------------------------

-- ----------------------------
-- Table structure for wx_msg_reply
-- ----------------------------
DROP TABLE IF EXISTS `wx_msg_reply`;
CREATE TABLE `wx_msg_reply` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位',
  `msg_id` bigint(20) NOT NULL COMMENT '消息记录ID',
  `open_id` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '用户的唯一标识',
  `type` tinyint(1) DEFAULT NULL COMMENT '消息类型（文本，图片，图文）',
  `content` varchar(2000) CHARACTER SET utf8 DEFAULT NULL COMMENT '信息内容',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(11) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `update_user_id` bigint(11) DEFAULT NULL COMMENT '编辑人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户消息回复记录表';

-- ----------------------------
-- Records of wx_msg_reply
-- ----------------------------

-- ----------------------------
-- Table structure for wx_reply_event
-- ----------------------------
DROP TABLE IF EXISTS `wx_reply_event`;
CREATE TABLE `wx_reply_event` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位',
  `reply_type` tinyint(1) DEFAULT NULL COMMENT '回复类型（关注时间，关键字事件）',
  `msg_type` tinyint(1) DEFAULT NULL COMMENT '消息类型（文本，图片，图文）',
  `keyword` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '关键字',
  `content` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '回复内容（回复消息的ID）',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(11) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `update_user_id` bigint(11) DEFAULT NULL COMMENT '编辑人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自动回复事件消息';

-- ----------------------------
-- Records of wx_reply_event
-- ----------------------------

-- ----------------------------
-- Table structure for wx_reply_img
-- ----------------------------
DROP TABLE IF EXISTS `wx_reply_img`;
CREATE TABLE `wx_reply_img` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位',
  `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片地址',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `media_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '媒体ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(11) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `update_user_id` bigint(11) DEFAULT NULL COMMENT '编辑人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复消息图片消息';

-- ----------------------------
-- Records of wx_reply_img
-- ----------------------------

-- ----------------------------
-- Table structure for wx_reply_news
-- ----------------------------
DROP TABLE IF EXISTS `wx_reply_news`;
CREATE TABLE `wx_reply_news` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `title` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '摘要',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `link_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '文章链接路径',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(11) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `update_user_id` bigint(11) DEFAULT NULL COMMENT '编辑人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息回复图文消息';

-- ----------------------------
-- Records of wx_reply_news
-- ----------------------------

-- ----------------------------
-- Table structure for wx_reply_txt
-- ----------------------------
DROP TABLE IF EXISTS `wx_reply_txt`;
CREATE TABLE `wx_reply_txt` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '单位',
  `title` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '回复内容',
  `wx_id` bigint(20) DEFAULT NULL COMMENT '微信ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(11) NOT NULL COMMENT '创建人员ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `update_user_id` bigint(11) DEFAULT NULL COMMENT '编辑人员ID',
  `data_state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '数据状态 （0 启用 -1 禁用 1 删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自动回复文本消息';

-- ----------------------------
-- Records of wx_reply_txt
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信发送消息模板ID';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信发送消息模板列表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信发送消息模板发送日志';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信会员列表';

-- ----------------------------
-- Records of wx_user
-- ----------------------------
