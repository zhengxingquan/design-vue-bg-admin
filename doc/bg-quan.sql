/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : nutzbg

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2020-11-17 18:29:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_alarm_option
-- ----------------------------
DROP TABLE IF EXISTS `sys_alarm_option`;
CREATE TABLE `sys_alarm_option` (
  `alarmType` varchar(128) NOT NULL DEFAULT '',
  `percent` decimal(15,10) DEFAULT NULL,
  `email` tinyint(1) DEFAULT NULL,
  `sms` tinyint(1) DEFAULT NULL,
  `listeners` varchar(128) DEFAULT NULL,
  `listenersDesc` varchar(128) DEFAULT NULL,
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`alarmType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='监控项目';

-- ----------------------------
-- Records of sys_alarm_option
-- ----------------------------

-- ----------------------------
-- Table structure for sys_api
-- ----------------------------
DROP TABLE IF EXISTS `sys_api`;
CREATE TABLE `sys_api` (
  `appId` varchar(32) NOT NULL DEFAULT '',
  `appKey` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `note` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='API密钥管理';

-- ----------------------------
-- Records of sys_api
-- ----------------------------
INSERT INTO `sys_api` VALUES ('JVlzVo5jx5j1TZtc', 'XDO2Tt4LH4RXqRj89hqCojx5cIUi4c', '测试数据', '1', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-24 09:26:34', null, '0', null, '测试2323233');
INSERT INTO `sys_api` VALUES ('UGEL9u6lFQdfQVl5', 'xyS2XLnLonCUHcDB4av4ruz4A0Lizz', '测试接口', '1', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-24 09:26:35', null, '0', null, '测试4534653466');

-- ----------------------------
-- Table structure for sys_apm_alarm
-- ----------------------------
DROP TABLE IF EXISTS `sys_apm_alarm`;
CREATE TABLE `sys_apm_alarm` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `alarmType` varchar(128) DEFAULT NULL,
  `alarmTime` datetime DEFAULT NULL,
  `msg` varchar(128) DEFAULT NULL,
  `ip` varchar(128) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `device` varchar(128) DEFAULT NULL,
  `alarmUsage` decimal(15,10) DEFAULT NULL,
  `point` decimal(15,10) DEFAULT NULL,
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='警告信息表';

-- ----------------------------
-- Records of sys_apm_alarm
-- ----------------------------

-- ----------------------------
-- Table structure for sys_app_conf
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_conf`;
CREATE TABLE `sys_app_conf` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `confName` varchar(255) DEFAULT NULL COMMENT '实例名',
  `confVersion` varchar(32) DEFAULT NULL COMMENT '版本号',
  `confData` text COMMENT '配置内容',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用管理--配置文件表';

-- ----------------------------
-- Records of sys_app_conf
-- ----------------------------

-- ----------------------------
-- Table structure for sys_app_list
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_list`;
CREATE TABLE `sys_app_list` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `appName` varchar(255) DEFAULT NULL COMMENT '实例名',
  `appVersion` varchar(32) DEFAULT NULL COMMENT '版本号',
  `fileId` varchar(128) DEFAULT NULL COMMENT '文件实体',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用管理--配置文件表';

-- ----------------------------
-- Records of sys_app_list
-- ----------------------------
INSERT INTO `sys_app_list` VALUES ('6be1793c6494495f9fb6f7369e825604', 'sys-admin', '5.6.0', 'd7a4e635874842ef99dd225141713ade', '1', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-05-13 15:13:49', null, '0', '2020-05-13 15:39:40');
INSERT INTO `sys_app_list` VALUES ('7c0ad5d7284a452c86bb3804fd44b775', 'sys-admin', '5.7.0', '00968908532248a1aa92a907c64a283d', '0', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-05-13 16:37:06', '2020-05-13 16:37:21', '1', null);

-- ----------------------------
-- Table structure for sys_app_task
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_task`;
CREATE TABLE `sys_app_task` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `name` varchar(32) DEFAULT NULL COMMENT '实例名',
  `action` varchar(32) DEFAULT NULL COMMENT '执行动作',
  `appVersion` varchar(32) DEFAULT NULL COMMENT 'APP版本',
  `confVersion` varchar(32) DEFAULT NULL COMMENT '配置版本',
  `processId` varchar(32) DEFAULT NULL COMMENT '进程ID',
  `hostName` varchar(255) DEFAULT NULL COMMENT '推送主机',
  `hostAddress` varchar(255) DEFAULT NULL COMMENT '主机IP',
  `status` tinyint(4) DEFAULT NULL COMMENT '推送状态',
  `pushAt` timestamp NULL DEFAULT NULL COMMENT '反馈时间',
  `pushResult` varchar(255) DEFAULT NULL COMMENT '反馈结果',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用管理--配置文件表';

-- ----------------------------
-- Records of sys_app_task
-- ----------------------------

-- ----------------------------
-- Table structure for sys_attachment
-- ----------------------------
DROP TABLE IF EXISTS `sys_attachment`;
CREATE TABLE `sys_attachment` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `name` varchar(100) DEFAULT NULL COMMENT '文件名称',
  `extensions` varchar(30) DEFAULT NULL COMMENT '文件后缀名',
  `type` varchar(30) DEFAULT NULL COMMENT '附件类型',
  `path` varchar(200) DEFAULT NULL COMMENT '文件路径',
  `fileSize` int(32) DEFAULT NULL COMMENT '文件大小',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `ftpState` tinyint(1) DEFAULT '0' COMMENT '是否上传ftp',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `INDEX_SYS_ATTACHMENT_TYPE` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统附件表';

-- ----------------------------
-- Records of sys_attachment
-- ----------------------------
INSERT INTO `sys_attachment` VALUES ('00968908532248a1aa92a907c64a283d', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/vte7e3pvv8h8uqtuo80btjcg77.jar', '2577288', '21', '0', '', '2020-05-13 16:37:04', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('03d9949b053f454c9aaa6be6c9dee97a', '新进人员起薪 66666666666666666666666666666666666666666666666.xlsx', '.xlsx', 'FILE', '/upload/file/20200826/saenhtjdeigo9rj0uf3nijqjmr.xlsx', '13536', '25', '0', '', '2020-08-26 10:10:53', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('082b30a317694943bfb430f9266cd8c4', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/5h1muuko5ai7uq8cgkmu5u2tnj.jar', '2577288', '18', '0', '', '2020-05-13 14:55:26', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('345523a0c4fb4933b9b290078a2929f9', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/6bastnv1mahn4ovtbodcacpk93.jar', '2577288', '11', '0', '', '2020-05-13 14:47:34', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('3e8bbdc646c24a9eb39b9a5df6d477b8', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/s93fee8s40jndq35sqcemptc1e.jar', '2577288', '10', '0', '', '2020-05-13 14:44:24', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('46c71bf015f94da1b3aac3e9b4d44bdd', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/qaq913chr2jm3pd8k3hacntqtb.jar', '2577288', '14', '0', '', '2020-05-13 14:50:10', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('5ec1ad6720e042db9067bb682fda4645', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/vghokb2iluigiom6a7mceg0060.jar', '2577288', '6', '0', '', '2020-05-13 14:35:57', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('602b758f333c4956abdd247c76743148', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/pqiodduagmhq6r216jd1am3lab.jar', '2577288', '1', '0', '', '2020-05-13 14:18:24', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('609ad0b3de1f4ae6bd18aa87ebb40a59', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/0i7rqmsm06juqp8gtllh4qan6u.jar', '2577288', '19', '0', '', '2020-05-13 15:10:59', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('62c125f431074685bbd3c238b9386ba9', '基本工资调整 666666666666666666666666666666.xlsx', '.xlsx', 'FILE', '/upload/file/20200826/ut0ssajfs0jqfpel0lj6sskcai.xlsx', '9886', '23', '0', '', '2020-08-26 09:56:39', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('65342ea3b0ec45e8988208265688a7c5', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/3kq75cak70jnopv0dr9t757kr6.jar', '2577288', '12', '0', '', '2020-05-13 14:49:59', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('6fa8982fe25c4c8ba6256fe852d6ede7', '新进人员起薪 66666666666666666666666666666666666666666666666.xlsx', '.xlsx', 'FILE', '/upload/file/20200826/osksin6fiuhpkpjcbo885esoql.xlsx', '13536', '26', '0', '', '2020-08-26 10:18:14', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('702390bffd0b42968ee1c42979a37330', '津补贴调整333333333333333333333333333333333333333333333333.xlsx', '.xlsx', 'FILE', '/upload/file/20200826/udod527fluijbp65stkls53e7n.xlsx', '10214', '22', '0', '', '2020-08-26 09:51:10', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('805fe9cb6b9a4aedba4e9e3a059992cb', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/tgmnl55o8qibgo3mcrcuq75q2c.jar', '2577288', '16', '0', '', '2020-05-13 14:52:18', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('832aafa8fce841c1a5abcd8d01d3fab9', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/5jm52q60akg17o1o577blda08g.jar', '2577288', '8', '0', '', '2020-05-13 14:41:50', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('923d4c32a3a1447b8261811f6d4c8e0b', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/29kr627fcsie1qdhg08cf522nb.jar', '2577288', '9', '0', '', '2020-05-13 14:43:03', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('93ec2f05bc334688a4ebb76628aff9fd', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/v8chttikskg21oucli4894c4ke.jar', '2577288', '15', '0', '', '2020-05-13 14:51:34', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('9e8a071a9312469493c6e66f3ef3d95b', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/o2dg3c3naqh07qm3l855vm50lq.jar', '2577288', '17', '0', '', '2020-05-13 14:52:55', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('a223eb7258a64275b8a84a07c96fec17', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/5nnd6tnb26h16rgphtul1b2a8o.jar', '2577288', '5', '0', '', '2020-05-13 14:27:26', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('a5954a4a57514331a50c2f5590fcd21e', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/sedh3rfkici9pq7h7bkigr8mcv.jar', '2577288', '13', '0', '', '2020-05-13 14:50:03', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('a698c8135f6242cdb8580c80215e0f54', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/1evjkj6eksj35r8i9rm4o9l818.jar', '2577288', '3', '0', '', '2020-05-13 14:27:12', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('b650a5bd6e2d44b28c9c95667e9823a0', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/14stnn27bshd3pi1l3tkihuq31.jar', '2577288', '2', '0', '', '2020-05-13 14:24:30', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('bd6fabc216a048f99bbdc5c4ccaa442e', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/5lp5kceipciprrl7p0mcbj683q.jar', '2577288', '4', '0', '', '2020-05-13 14:27:19', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('c4350634a027408f804f95958592d8d4', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/1a6gh6pg3shf8rl6lf44dmui3r.jar', '2577288', '7', '0', '', '2020-05-13 14:39:35', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('cc779bc69b034cbfb5cc60bc17c1cd53', '教员名单导入模板 (1).xls', '.xls', 'FILE', '/upload/file/20200826/44ec86gooqg6iq2ebp2808ukcc.xls', '23040', '27', '0', '', '2020-08-26 10:22:41', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('d7a4e635874842ef99dd225141713ade', 'HiJson.jar', '.jar', 'FILE', '/upload/file/20200513/1keq02oh5chcvr2nu6k3iouekp.jar', '2577288', '20', '0', '', '2020-05-13 15:13:48', null, '0', null);
INSERT INTO `sys_attachment` VALUES ('e7958d4101b6409da6ad779fdedab966', '津补贴调整333333333333333333333333333333333333333333333333.xlsx', '.xlsx', 'FILE', '/upload/file/20200826/sofkuaprkehj5r73o5jsjeoh8r.xlsx', '10214', '24', '0', '', '2020-08-26 09:59:28', null, '0', null);

-- ----------------------------
-- Table structure for sys_blacklist_ip
-- ----------------------------
DROP TABLE IF EXISTS `sys_blacklist_ip`;
CREATE TABLE `sys_blacklist_ip` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `ip` varchar(255) DEFAULT NULL COMMENT 'IP地址',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统IP过滤表';

-- ----------------------------
-- Records of sys_blacklist_ip
-- ----------------------------
INSERT INTO `sys_blacklist_ip` VALUES ('f40ce10e665941b3922b6a6a1300dbfd', '127.0.0.1.5687.5345.5345', '1', '测试', '1', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-24 10:51:28', null, '0', '2020-08-24 10:52:37');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `configKey` varchar(100) NOT NULL DEFAULT '' COMMENT '唯一KEY名称',
  `configValue` varchar(100) DEFAULT NULL COMMENT 'KEY value 值',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`configKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('AppDomain', 'http://127.0.0.1:8080', '系统域名', '3', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_config` VALUES ('AppFileDomain', '', '文件访问域名', '4', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_config` VALUES ('AppName', 'Nutz-BG', '系统名称', '1', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_config` VALUES ('AppShortName', 'NutzBG', '系统短名称', '2', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_config` VALUES ('AppUploadBase', '/upload', '文件访问路径', '5', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_config` VALUES ('AppUserDefaultPassWord', '111111', '用户默认密码', '8', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_config` VALUES ('password', '111111', '初始默认密码', '11', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-25 18:18:35', '2020-08-25 18:19:02', '1', null);
INSERT INTO `sys_config` VALUES ('Redis 缓存时间', '0', '本地开发一般设置为0，线上设置为 10', '10', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-24 11:01:41', null, '0', null);
INSERT INTO `sys_config` VALUES ('SysUserSessionOnlyOne', 'true', '用户登录只允许一个Session实例(为true时退出登录会更新sys_user表在线状态)', '6', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_config` VALUES ('Test1', 'test2', '测试数据', '9', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 20:10:05', '2020-08-18 20:11:17', '1', null);
INSERT INTO `sys_config` VALUES ('WebNotification', 'false', '启用浏览器通知', '7', '', '2020-05-08 18:58:54', null, '0', null);

-- ----------------------------
-- Table structure for sys_data_field
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_field`;
CREATE TABLE `sys_data_field` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `physicalName` varchar(100) DEFAULT NULL COMMENT '物理名称',
  `enumDataFieldId` varchar(32) DEFAULT NULL COMMENT '枚举依赖字段id',
  `enumDepend` varchar(500) DEFAULT NULL COMMENT '被依赖字段id',
  `associationId` varchar(128) DEFAULT NULL COMMENT '关联编号',
  `parentId` varchar(128) DEFAULT NULL COMMENT '数据表ID',
  `enumId` varchar(128) DEFAULT NULL COMMENT '枚举值id',
  `dataFieldCode` varchar(50) DEFAULT NULL COMMENT '编码',
  `dataFieldProperty` int(32) DEFAULT NULL COMMENT '字段属性：1=逻辑字段，2=物理字段',
  `dataFieldLength` int(32) DEFAULT NULL COMMENT '字段长度',
  `requiredDataField` tinyint(1) DEFAULT NULL COMMENT '字段是否必填',
  `regexExpression` varchar(500) DEFAULT NULL COMMENT '正则表达式',
  `expressionId` varchar(500) DEFAULT NULL COMMENT '字段记录引用id',
  `disable` tinyint(1) DEFAULT NULL COMMENT '字段是否冻结',
  `tooltip` varchar(200) DEFAULT NULL COMMENT '提示信息',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `indexAble` tinyint(1) DEFAULT '0' COMMENT '是否建立索引',
  `privateState` tinyint(1) DEFAULT '0' COMMENT '是否是私有字段',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `dataFieldTypeId` varchar(32) DEFAULT NULL COMMENT '字段类型ID',
  `decimalLength` int(32) DEFAULT '0' COMMENT '小数位数长度，（主要针对于 实数类型 ）',
  `disabled` tinyint(1) DEFAULT '0' COMMENT '字段是否冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字段表';

-- ----------------------------
-- Records of sys_data_field
-- ----------------------------
INSERT INTO `sys_data_field` VALUES ('02f5e79fb9fc4e248a648669357a329a', '枚举值依赖', 'f_1_16', 'ebad34886e3b458f972a5cb102155197', null, null, '63fec9403ff644ac8a5a7a965733e5c3', '', '000100010016', '2', '0', '0', '', null, '0', '', '', '0', '0', '16', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-09-01 20:36:27', null, '0', null, 'e40a3907409f457c9a56ce9fc42597db', '0', '0');
INSERT INTO `sys_data_field` VALUES ('3d79dc4ed061442b804698ce8510c7f7', '年月类型', 'f_1_10', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010010', '2', '0', '0', null, null, '0', '年月类型', '年月类型', '0', '0', '10', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:10:15', null, '0', null, 'bc706eef81e04828a5fe7bdd06d3c37b', '0', '0');
INSERT INTO `sys_data_field` VALUES ('3deb38f0635c40559f8ed1c54c17c922', '测试5', 'f_1_5', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010005', '2', '20', '0', null, null, '0', '测试5', '测试5', '0', '0', '5', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:29:37', null, '0', null, 'c5ec4be7e9d5477aa4c14f408259cd03', '0', '0');
INSERT INTO `sys_data_field` VALUES ('4264f44ee5b443f4ac5c6155e06e0c69', '枚举附加值一依赖', 'f_1_17', '8330ae7ceef64dc0ab2ea37470d0d642', null, null, '63fec9403ff644ac8a5a7a965733e5c3', '', '000100010017', '2', '0', '0', '', null, '0', '', '', '0', '0', '17', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-09-01 20:37:47', null, '0', null, '6c95cafa9c1540759adca439a4e9e979', '0', '0');
INSERT INTO `sys_data_field` VALUES ('45cb2918e9ee4407866d599b3ec41aa2', '测试3', 'f_1_3', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010003', '2', '30', '1', null, null, '0', '测试3', '测试3', '1', '0', '3', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:28:50', null, '0', null, 'dad313f908e445bd8fdc2f9ccb2b6406', '0', '0');
INSERT INTO `sys_data_field` VALUES ('5b45cedb6f4c4ded9c6e2364c813e5b9', '测试1', 'f_2_1', null, null, null, 'a04f8b23a0cf48e0ae4649875c34f840', null, '000100020001', '1', '50', '1', null, null, '0', '测试1', '测试1', '1', '0', '5', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-21 14:51:26', null, '0', null, null, '0', '0');
INSERT INTO `sys_data_field` VALUES ('68a3baafb3bf40e2868d9692e7888f8b', '年月日类型', 'f_1_9', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010009', '2', '0', '0', null, null, '0', '年月日类型', '年月日类型', '0', '0', '9', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:09:42', null, '0', null, '5d029a51782a46cb98dcecfe00b67303', '0', '0');
INSERT INTO `sys_data_field` VALUES ('8330ae7ceef64dc0ab2ea37470d0d642', '枚举附加值3', 'f_1_15', '', '4264f44ee5b443f4ac5c6155e06e0c69', null, '63fec9403ff644ac8a5a7a965733e5c3', '8ebb5755bf20465fb98487af1ed83278', '000100010015', '2', '0', '0', '', null, '0', '', '', '0', '0', '15', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-09-01 20:29:26', null, '0', null, 'ee1b8fbee3a2481fb37648e5bb02fe98', '0', '0');
INSERT INTO `sys_data_field` VALUES ('847eae4933104bfbbe47be2be4da5b24', '枚举依赖', 'f_1_14', 'ebad34886e3b458f972a5cb102155197', null, null, '63fec9403ff644ac8a5a7a965733e5c3', '', '000100010014', '2', '0', '0', '', null, '0', '4234', '4324', '0', '0', '14', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-09-01 20:28:57', null, '0', null, 'c4e4f98871a34ecabb4072afc15fb2c2', '0', '0');
INSERT INTO `sys_data_field` VALUES ('8f777f390dd74ecaad9d6d54f16bc2a4', '测试7', 'f_1_7', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010007', '2', '20', '0', null, null, '0', '测试7', '测试7', '0', '0', '7', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:29:56', null, '0', null, 'eab8b4a7fcda4ce7a0de540715fc228a', '0', '0');
INSERT INTO `sys_data_field` VALUES ('9369631d55214a39b8f2e67c890a7a2b', '年月日类型时间', 'f_1_8', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010008', '2', '0', '0', null, null, '0', '测试年月日类型时间', '测试年月日类型时间', '0', '0', '8', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:02:39', null, '0', null, 'bd463b3275c244ba8247d5bb8bd5e215', '0', '0');
INSERT INTO `sys_data_field` VALUES ('98be5b8c55ae4b1a9fd14ade119611ad', '任意字符串类型', 'f_1_13', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010013', '2', '3', '0', null, null, '0', '', '', '0', '0', '13', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:32:59', null, '0', null, 'b99820a4b2a84befb0383f00e7c44937', '0', '0');
INSERT INTO `sys_data_field` VALUES ('9924068988dc4237889f3edebb307e5b', '测试4', 'f_1_4', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010004', '2', '0', '1', '', null, '0', '测试4', '测试4', '1', '0', '4', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:36:33', null, '0', null, '3746de673663489d86d0b359fd1edfa6', '5', '0');
INSERT INTO `sys_data_field` VALUES ('997de656dac64722a03b0c7da876fe67', '月日类型', 'f_1_11', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010011', '2', '0', '0', null, null, '0', '月日类型', '月日类型', '0', '0', '11', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:10:30', null, '0', null, 'cf95ad1cd67a45258d5b257945e1ac13', '0', '0');
INSERT INTO `sys_data_field` VALUES ('9f76ccf2431b42f2855212082b76b93f', '时间类型', 'f_1_12', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010012', '2', '0', '0', null, null, '0', '时间类型', '时间类型', '0', '0', '12', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:10:40', null, '0', null, 'f95ef43bcdba4a5c891432e46f0c7db9', '0', '0');
INSERT INTO `sys_data_field` VALUES ('bc6044bd71c24645bc2ca0abedca02e4', '测试6', 'f_1_6', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010006', '2', '10', '0', null, null, '0', '测试6', '测试6', '0', '0', '6', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:29:47', null, '0', null, 'dad313f908e445bd8fdc2f9ccb2b6406', '0', '0');
INSERT INTO `sys_data_field` VALUES ('ebad34886e3b458f972a5cb102155197', '测试1', 'f_1_1', null, '02f5e79fb9fc4e248a648669357a329a', null, '63fec9403ff644ac8a5a7a965733e5c3', 'cdbad77343ea41d482d214ee79f327bc', '000100010001', '2', '30', '0', '', null, '0', '12', '12', '0', '0', '1', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-09-01 18:55:04', null, '0', null, 'eab8b4a7fcda4ce7a0de540715fc228a', '0', '0');
INSERT INTO `sys_data_field` VALUES ('f11de97dadfb474f9ea7bd6fba82ce9f', '测试2', 'f_1_2', null, null, null, '63fec9403ff644ac8a5a7a965733e5c3', null, '000100010002', '2', '50', '1', null, null, '0', '测试2', '测试2', '1', '0', '2', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 15:28:42', null, '0', null, 'b99820a4b2a84befb0383f00e7c44937', '0', '0');

-- ----------------------------
-- Table structure for sys_data_field_property
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_field_property`;
CREATE TABLE `sys_data_field_property` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父节点',
  `path` varchar(128) DEFAULT NULL COMMENT '路径',
  `name` varchar(60) DEFAULT NULL COMMENT '名称',
  `sysCode` varchar(128) DEFAULT NULL COMMENT '系统编码，用于查询使用',
  `conciseDataFieldType` varchar(60) DEFAULT NULL COMMENT '数据简洁数据类型',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `note` varchar(255) DEFAULT NULL COMMENT '简介',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字段属性表';

-- ----------------------------
-- Records of sys_data_field_property
-- ----------------------------
INSERT INTO `sys_data_field_property` VALUES ('1055e3fe650148c98e54d8e7a4a30872', '40146e4c64504403bebf56ec481a7dba', '00030001', '数字符串类型', '0302', 'varchar', '0', '0', null, '7', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:47:54', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('159d064f77f64dc481d805b1dcd22ffa', '92d67353469048a18b6d765dff5aefa5', '00110001', '树型枚举名称', '1101', 'varchar', '0', '0', null, '32', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:05:54', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('273302564b814523b75c29b5e27a0263', '28e6ac8e616f481f9b191b40219d4a10', '00090002', '字符串表达式类型', '0802', 'varchar', '0', '0', null, '30', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:56:45', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('28e6ac8e616f481f9b191b40219d4a10', '', '0009', '表达式类型', '08', 'varchar', '1', '0', null, '28', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:56:08', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('3746de673663489d86d0b359fd1edfa6', 'ba6fe357329d416da08e6887d3faf518', '00020002', '实数类型', '0202', 'decimal', '0', '0', null, '4', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:45:55', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('40146e4c64504403bebf56ec481a7dba', '', '0003', '字符串类型', '03', 'varchar', '1', '0', null, '5', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:46:22', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('417c16847b16460a867b2f192aa477ea', 'd87e5e6ec5294afcbec6b9291abc86cb', '00080001', '文档附件', '0701', 'varchar', '0', '0', null, '26', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:54:58', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('44be0df8873b4ecca001e2718cc20db3', 'a49f48bdf3db40f19920f21384fb0d4d', '00100004', '枚举附加值二依赖', '1004', 'varchar', '0', '0', null, '45', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:11:20', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('55c95954789a4f20ac3bb6663e22e110', '92d67353469048a18b6d765dff5aefa5', '00110008', '下拉型枚举附加值一', '1108', 'varchar', '0', '0', null, '39', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:08:19', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('5d029a51782a46cb98dcecfe00b67303', 'fecb3f01d9444337ae578670ac30fc2b', '00050002', '年月日类型', '0402', 'datetime', '0', '0', null, '12', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:49:56', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('68595f39281d42a3b221360bfb6775c1', 'd76fccb0083a44718cf82053785620c4', '00070004', '关联字符型', '0604', 'varchar', '0', '0', null, '23', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:54:09', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('6c95cafa9c1540759adca439a4e9e979', 'a49f48bdf3db40f19920f21384fb0d4d', '00100003', '枚举附加值一依赖', '1003', 'varchar', '0', '0', null, '44', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:10:58', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('79057e350546403ba13bbf391099c981', 'd76fccb0083a44718cf82053785620c4', '00070003', '关联实数类型', '0603', 'decimal', '0', '0', null, '22', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:53:45', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('7d63170548ed47fabf17d61e830776d0', '28e6ac8e616f481f9b191b40219d4a10', '00090001', '数字类型表达式类型', '0801', 'varchar', '0', '0', null, '29', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:56:27', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('82953213564d4069be3c9760910592aa', 'd87e5e6ec5294afcbec6b9291abc86cb', '00080002', '图片附件', '0702', 'varchar', '0', '0', null, '27', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:55:12', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('8dab59d30e604632ac011b558a2dfd8d', '92d67353469048a18b6d765dff5aefa5', '00110007', '下拉型枚举值', '1107', 'varchar', '0', '0', null, '38', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:08:03', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('92d67353469048a18b6d765dff5aefa5', '', '0011', '枚举实体类型', '11', 'varchar', '1', '0', null, '17', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:51:45', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('94df484f929d414eafa327cd46d5a042', '', '0001', '布尔类型', '01', 'bit', '0', '0', '布尔类型', '1', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:44:40', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('95433ff79a58475183f6af74989a8aa3', '92d67353469048a18b6d765dff5aefa5', '00110003', '树型枚举附加值一', '1103', 'varchar', '0', '0', null, '34', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:06:36', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('a2a7472bbc5f4175a7142aa2a1ef9e91', 'd76fccb0083a44718cf82053785620c4', '00070002', '关联整型', '0602', 'int', '0', '0', null, '21', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:53:28', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('a49f48bdf3db40f19920f21384fb0d4d', '', '0010', '枚举依赖类型', '10', 'varchar', '1', '0', null, '18', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:52:07', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('a5fe243516824a51b930c0195f0b859a', '92d67353469048a18b6d765dff5aefa5', '00110009', '下拉型枚举附加值二', '1109', 'varchar', '0', '0', null, '40', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:08:33', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('af3e8e789fce44bcb7e2c6e4c1dbffe5', 'd76fccb0083a44718cf82053785620c4', '00070005', '关联时间类型', '0605', 'datetime', '0', '0', null, '24', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:54:25', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('b99820a4b2a84befb0383f00e7c44937', '40146e4c64504403bebf56ec481a7dba', '0004', '任意字符串类型', '0301', 'varchar', '0', '0', null, '6', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:46:44', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('ba6fe357329d416da08e6887d3faf518', '', '0002', '数值类型', '02', 'int', '1', '0', null, '2', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:45:03', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('bc706eef81e04828a5fe7bdd06d3c37b', 'fecb3f01d9444337ae578670ac30fc2b', '00050003', '年月类型', '0403', 'datetime', '0', '0', null, '13', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:50:15', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('bd463b3275c244ba8247d5bb8bd5e215', 'fecb3f01d9444337ae578670ac30fc2b', '00050001', '年月日类型时间', '0401', 'datetime', '0', '0', null, '11', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:49:41', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('c4e4f98871a34ecabb4072afc15fb2c2', 'a49f48bdf3db40f19920f21384fb0d4d', '00100001', '枚举名称依赖', '1001', 'varchar', '0', '0', null, '42', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:09:43', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('c5ec4be7e9d5477aa4c14f408259cd03', '40146e4c64504403bebf56ec481a7dba', '00030003', '数字字母混合类型', '0304', 'varchar', '0', '0', null, '9', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:48:36', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('cf95ad1cd67a45258d5b257945e1ac13', 'fecb3f01d9444337ae578670ac30fc2b', '00050004', '月日类型', '0404', 'datetime', '0', '0', null, '14', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:50:36', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('d76fccb0083a44718cf82053785620c4', '', '0007', '关联类型', '06', 'int', '1', '0', null, '19', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:52:34', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('d87e5e6ec5294afcbec6b9291abc86cb', '', '0008', '附件类型', '07', 'varchar', '1', '0', null, '25', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:54:43', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('dad313f908e445bd8fdc2f9ccb2b6406', '40146e4c64504403bebf56ec481a7dba', '00030002', '字母符串类型', '0303', 'varchar', '0', '0', null, '8', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:48:13', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('e40a3907409f457c9a56ce9fc42597db', 'a49f48bdf3db40f19920f21384fb0d4d', '00100002', '枚举值依赖', '1002', 'varchar', '0', '0', null, '43', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:09:58', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('e855653ca77644a585002821a1a1f7a1', 'ba6fe357329d416da08e6887d3faf518', '00020001', '整数类型', '0201', 'int', '0', '0', null, '3', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:45:37', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('eab8b4a7fcda4ce7a0de540715fc228a', '92d67353469048a18b6d765dff5aefa5', '00110002', '树型枚举值', '1102', 'varchar', '0', '0', null, '33', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:06:13', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('ee1b8fbee3a2481fb37648e5bb02fe98', '92d67353469048a18b6d765dff5aefa5', '00110010', '下拉型枚举附加值三', '1110', 'varchar', '0', '0', null, '41', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:08:54', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('f40fcf4e40984255982000dbac8b63b1', '28e6ac8e616f481f9b191b40219d4a10', '00090003', '日期表达式类型', '0803', 'varchar', '0', '0', null, '31', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:57:03', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('f48d7a9a4e1e4a0881bb83c163347bb5', '92d67353469048a18b6d765dff5aefa5', '00110004', '树型枚举附加值二', '1104', 'varchar', '0', '0', null, '35', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:06:56', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('f59bcf8804e14328b3ad85ebbfdc9f18', '', '0012', '测试', '', 'varchar', '1', '0', '测试', '47', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 20:33:41', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('f9354cc18ecd4822bd31945c8e920a7e', '92d67353469048a18b6d765dff5aefa5', '00110006', '下拉型枚举名称', '1106', 'varchar', '0', '0', null, '37', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:07:44', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('f95ef43bcdba4a5c891432e46f0c7db9', 'fecb3f01d9444337ae578670ac30fc2b', '00050005', '时间类型', '0405', 'datetime', '0', '0', null, '15', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:50:56', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('fd68c5a997044c22bac5838f2300f976', 'd76fccb0083a44718cf82053785620c4', '00070001', '关联布尔类型', '0601', 'bit', '0', '0', null, '20', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:52:57', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('fdb6fce8a1b6493184180d7feee7cdac', 'f59bcf8804e14328b3ad85ebbfdc9f18', '00120001', '测试1', '', 'varchar', '0', '0', null, '48', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 20:34:15', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('fddf881e1d974961b65520438983c53c', '92d67353469048a18b6d765dff5aefa5', '00110005', '树型枚举附加值三', '1105', 'varchar', '0', '0', null, '36', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 10:07:23', null, '0', null);
INSERT INTO `sys_data_field_property` VALUES ('fecb3f01d9444337ae578670ac30fc2b', '', '0005', '时间类型', '04', 'datetime', '1', '0', null, '10', 'bfade93225b446bfb2de0d1e23019a77', '2020-04-29 09:49:23', null, '0', null);

-- ----------------------------
-- Table structure for sys_data_table
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_table`;
CREATE TABLE `sys_data_table` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `physicalName` varchar(100) DEFAULT NULL COMMENT '物理名称',
  `tableType` int(32) DEFAULT NULL COMMENT '表类型，1=主表， 2=从表',
  `tableCode` varchar(50) DEFAULT NULL COMMENT '编码',
  `parentId` varchar(128) DEFAULT NULL COMMENT '仓库的ID',
  `note` varchar(255) DEFAULT NULL COMMENT '简介',
  `tooltip` varchar(255) DEFAULT NULL COMMENT '提示信息',
  `copyTableId` int(32) DEFAULT NULL COMMENT '复制表结构id',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统数据表';

-- ----------------------------
-- Records of sys_data_table
-- ----------------------------
INSERT INTO `sys_data_table` VALUES ('63fec9403ff644ac8a5a7a965733e5c3', '基本信息表', 'tb_1_1', '1', '00010001', '6b4155a6e775468fadd9ff84c57c4b6b', '', '基本信息表主表数据', null, '1', '0', '1', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-19 19:31:37', null, '0', null);
INSERT INTO `sys_data_table` VALUES ('a04f8b23a0cf48e0ae4649875c34f840', '附加信息表', 'tb_1_2', '1', '00010002', '6b4155a6e775468fadd9ff84c57c4b6b', '附加信息表', '附加信息表', null, '1', '0', '2', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-21 14:50:44', null, '0', null);

-- ----------------------------
-- Table structure for sys_database
-- ----------------------------
DROP TABLE IF EXISTS `sys_database`;
CREATE TABLE `sys_database` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `physicalName` varchar(100) DEFAULT NULL COMMENT '物理名称',
  `databaseCode` varchar(50) DEFAULT NULL COMMENT '编码',
  `parentId` varchar(128) DEFAULT NULL COMMENT '父节点',
  `note` varchar(255) DEFAULT NULL COMMENT '简介',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统数据仓库表';

-- ----------------------------
-- Records of sys_database
-- ----------------------------
INSERT INTO `sys_database` VALUES ('16d4b80344d0423e991f3889ed189d2e', '业务库4', 'Promotion_1', '0004', null, '', '0', '0', '5', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-20 20:03:00', null, '0', null);
INSERT INTO `sys_database` VALUES ('6b4155a6e775468fadd9ff84c57c4b6b', '基本信息库', 'Promotion_1', '0001', null, '', '1', '0', '1', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-19 19:26:33', null, '0', null);
INSERT INTO `sys_database` VALUES ('714b668488c845e494cf95aa0787a4b6', '业务数据库', 'Promotion_1', '0007', null, '', '0', '0', '3', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-20 19:58:03', null, '0', null);
INSERT INTO `sys_database` VALUES ('985c962d7aad47eda6a2beedbca07e27', '业务库3', 'Promotion_1', '0003', null, '', '0', '0', '6', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-20 20:02:37', null, '0', null);
INSERT INTO `sys_database` VALUES ('b6c282e9b69a4b0c8d6bf5e105347912', '而我却若群二', 'Promotion_1', '0006', null, '', '0', '0', '9', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-20 12:27:47', '2020-08-20 16:51:26', '1', null);
INSERT INTO `sys_database` VALUES ('c353f96913d4499da311632446842806', '业务库5', 'Promotion_1', '0008', '', '', '0', '0', '7', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-21 10:59:15', null, '0', null);
INSERT INTO `sys_database` VALUES ('e5cf3ae14065442bb45e6c288d0b192a', '业务库6', 'Promotion_1', '0009', '', '', '0', '0', '8', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-21 11:45:19', null, '0', null);
INSERT INTO `sys_database` VALUES ('ef6af9cd5651407f955540cd0c8dee96', '业务库2', 'Promotion_1', '0005', null, '', '0', '0', '4', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-20 19:58:38', null, '0', null);
INSERT INTO `sys_database` VALUES ('fa18a9bbca9c4a518d399257b555830f', '学籍信息库', 'Promotion_1', '0002', null, '', '0', '0', '2', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-20 10:06:14', null, '0', null);

-- ----------------------------
-- Table structure for sys_db_backup_attachment
-- ----------------------------
DROP TABLE IF EXISTS `sys_db_backup_attachment`;
CREATE TABLE `sys_db_backup_attachment` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `name` varchar(100) DEFAULT NULL COMMENT '文件名称',
  `path` varchar(200) DEFAULT NULL COMMENT '文件路径',
  `fileSize` int(32) DEFAULT NULL COMMENT '文件大小',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `backupTime` timestamp NULL DEFAULT NULL COMMENT '备份时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统数据库备份文件附件表';

-- ----------------------------
-- Records of sys_db_backup_attachment
-- ----------------------------
INSERT INTO `sys_db_backup_attachment` VALUES ('1', '测试备份', '11', '2000', '1', '1', '2020-08-25 15:08:27', null, '0', '2020-08-25 15:08:33', '2020-08-25 15:08:35');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(20) DEFAULT NULL COMMENT '编码',
  `sysCode` varchar(128) DEFAULT NULL COMMENT '系统编码，用于查询使用',
  `field1` varchar(200) DEFAULT NULL COMMENT '附加值一',
  `field2` varchar(200) DEFAULT NULL COMMENT '附加值二',
  `field3` varchar(200) DEFAULT NULL COMMENT '附加值三',
  `sysDict` tinyint(1) DEFAULT '0' COMMENT '是否是系统字典',
  `note` varchar(200) DEFAULT NULL COMMENT '字典简介',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '启用状态',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '有子节点',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `value` varchar(50) DEFAULT NULL COMMENT '用于生成下拉控件的value',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_DICT_PATH` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1b23f92b6dd7428aa8e66b32b62cbdfc', '8ebb5755bf20465fb98487af1ed83278', '0001000100020001', '逻辑字段', '00010201', '', '', '', '', '0', '', '0', '0', '7', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 11:17:20', null, '0', null, '1');
INSERT INTO `sys_dict` VALUES ('43bbc7461dcd499a972d3c2b66d9283e', '971414c5eccb4c4c92a8ef45d69da5e1', '0001000100010002', '从表', '00010102', '', '', '', '', '0', '', '0', '0', '5', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 11:17:39', null, '0', null, '2');
INSERT INTO `sys_dict` VALUES ('71600f48f68441cbb3fe892745579377', 'c41bf2b7e9c142159ed0ea6cee7a7309', '00010001', '数据表', '0001', null, null, null, null, '0', '数据表中的枚举', '0', '1', '2', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-20 17:14:15', null, '0', null, null);
INSERT INTO `sys_dict` VALUES ('810499a8ff2045b2b404823f0103fabb', '8ebb5755bf20465fb98487af1ed83278', '0001000100020002', '物理字段', '00010202', '', '', '', '', '0', '', '0', '0', '8', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 11:17:27', null, '0', null, '2');
INSERT INTO `sys_dict` VALUES ('8ebb5755bf20465fb98487af1ed83278', '71600f48f68441cbb3fe892745579377', '000100010002', '字段类型', '000102', 'system_datatable_field_type', '', '', '', '0', '', '0', '0', '0', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 10:58:17', null, '0', null, null);
INSERT INTO `sys_dict` VALUES ('971414c5eccb4c4c92a8ef45d69da5e1', '71600f48f68441cbb3fe892745579377', '000100010001', '表类型', '000101', 'system_datatable_table_type', '', '', '', '0', '', '0', '0', '3', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 11:13:44', null, '0', null, null);
INSERT INTO `sys_dict` VALUES ('c41bf2b7e9c142159ed0ea6cee7a7309', '', '0001', '系统枚举', 'sysdict', null, null, null, null, '0', null, '0', '1', '1', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 19:26:37', null, '0', null, null);
INSERT INTO `sys_dict` VALUES ('cdbad77343ea41d482d214ee79f327bc', '971414c5eccb4c4c92a8ef45d69da5e1', '0001000100010001', '主表', '00010101', '', '', '', '', '0', '', '0', '0', '4', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-29 11:17:34', null, '0', null, '1');

-- ----------------------------
-- Table structure for sys_email_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_email_config`;
CREATE TABLE `sys_email_config` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL COMMENT '唯一说明',
  `host` varchar(255) DEFAULT NULL COMMENT 'SMTP服务器',
  `post` varchar(255) DEFAULT NULL COMMENT 'SMTP端口号',
  `form` varchar(255) DEFAULT NULL COMMENT '发件人邮箱',
  `formName` varchar(255) DEFAULT NULL COMMENT '发件人昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '邮箱登入密码',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `systemState` tinyint(1) DEFAULT '0' COMMENT '是否是系统用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统邮件配置表';

-- ----------------------------
-- Records of sys_email_config
-- ----------------------------
INSERT INTO `sys_email_config` VALUES ('f128f13e224840b8be75f5d1ee3f47e8', '测试', '956607644@qq.com', '22', '956607644@qq.com', '郑兴泉', '111111', '1', '测试数据', '1', '0', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-24 10:01:57', null, '0', '2020-08-24 10:22:23');

-- ----------------------------
-- Table structure for sys_email_verify_code
-- ----------------------------
DROP TABLE IF EXISTS `sys_email_verify_code`;
CREATE TABLE `sys_email_verify_code` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `code` varchar(128) DEFAULT NULL COMMENT '验证码',
  `content` varchar(512) DEFAULT NULL COMMENT '内容',
  `emailName` varchar(128) DEFAULT NULL COMMENT '号码',
  `state` int(32) DEFAULT NULL COMMENT '状态',
  `errorMsg` varchar(128) DEFAULT NULL COMMENT '错误信息',
  `lastSendTime` timestamp NULL DEFAULT NULL COMMENT '最后发送时间',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统邮件验证码';

-- ----------------------------
-- Records of sys_email_verify_code
-- ----------------------------
INSERT INTO `sys_email_verify_code` VALUES ('1', '2586', '验证码 2586', '956607644@qq.com', '1', null, '2020-08-25 16:07:55', '1', '2020-08-25 16:07:59', null, '0', null);

-- ----------------------------
-- Table structure for sys_ftp_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_ftp_config`;
CREATE TABLE `sys_ftp_config` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL COMMENT '唯一说明',
  `host` varchar(255) DEFAULT NULL COMMENT '服务器地址',
  `post` varchar(255) DEFAULT NULL COMMENT '端口号',
  `username` varchar(255) DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `timeout` int(32) DEFAULT '30' COMMENT '登录超时时间',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `systemState` tinyint(1) DEFAULT '0' COMMENT '是否是系统用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统FTP文件配置表';

-- ----------------------------
-- Records of sys_ftp_config
-- ----------------------------
INSERT INTO `sys_ftp_config` VALUES ('883c220a3dc0409eafeea85e5ab59054', '测试数据', '127.0.0.1', '21', '956607644@qq.com', '123456789', '2000', '1', '测试数据', '1', '0', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-24 10:19:31', null, '0', '2020-08-24 10:22:06');

-- ----------------------------
-- Table structure for sys_lang
-- ----------------------------
DROP TABLE IF EXISTS `sys_lang`;
CREATE TABLE `sys_lang` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `langKey` varchar(128) DEFAULT NULL,
  `langValue` varchar(32) DEFAULT NULL,
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `LANG_KEY_INDEX` (`langKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='语言分类';

-- ----------------------------
-- Records of sys_lang
-- ----------------------------
INSERT INTO `sys_lang` VALUES ('151a2daa734f4f3baf8f7d829fb24fa0', 'en_US', 'en_US', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang` VALUES ('25e691a9012347708d7231fd09270664', 'jp', '日语', '', '2020-05-11 14:03:12', null, '0', null);
INSERT INTO `sys_lang` VALUES ('eaf5fe526ae747aea55348e6f9b0c223', 'ow', '欧文', '', '2020-05-11 17:31:24', null, '0', null);
INSERT INTO `sys_lang` VALUES ('fabee0495e6942359b2e40155654f935', 'zh_CN', 'zh_CN', '', '2020-05-11 14:02:42', null, '0', null);

-- ----------------------------
-- Table structure for sys_lang_msg
-- ----------------------------
DROP TABLE IF EXISTS `sys_lang_msg`;
CREATE TABLE `sys_lang_msg` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `langKey` varchar(128) DEFAULT NULL COMMENT '字符串标识 KEY',
  `langId` varchar(128) DEFAULT NULL COMMENT '语言分类ID',
  `langValue` varchar(512) DEFAULT NULL COMMENT '具体的类型',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='语言具体消息';

-- ----------------------------
-- Records of sys_lang_msg
-- ----------------------------
INSERT INTO `sys_lang_msg` VALUES ('0120eb7172934ce0adbdc51a8a05badb', 'globals.file.xls.uploadTip', 'fabee0495e6942359b2e40155654f935', '只能上传xls/xlsx，且不超过20M', '', '2020-08-25 19:48:20', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('01c387b2c0bc4194beebacc14a6085f3', 'sys.menu.type', 'fabee0495e6942359b2e40155654f935', '菜单类型', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('028e45b8692d4e939ad8875cac2a8a3c', 'index.user.setting', '151a2daa734f4f3baf8f7d829fb24fa0', 'Settings', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('02aade1e88d644efa8e209bb5ad532b2', 'login.submit', 'fabee0495e6942359b2e40155654f935', '登录', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('02dc3c2876a643939dfd5c941e81efba', 'sys.user.doBatchResetPassword', 'fabee0495e6942359b2e40155654f935', '批量重置密码', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('034fddf9eb644b94b9f5880d965f8836', 'index.user.rightPass', 'fabee0495e6942359b2e40155654f935', '确认密码', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0456cc468634419ab4e3d15f542d2ed2', 'sys.task.data', 'fabee0495e6942359b2e40155654f935', '执行参数', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('04ebe444f46341b7baafe8a199af84a7', 'system.exception', 'fabee0495e6942359b2e40155654f935', '服务器异常', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0534d5f81df04582bddfaf0185f70bca', 'sys.email.to', 'fabee0495e6942359b2e40155654f935', '发送地址', '', '2020-08-25 16:24:34', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0537218f924f474ea6b778c981f3d681', 'sys.user.mobile', 'fabee0495e6942359b2e40155654f935', '手机号码', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0549e62ec3404fd1aec976ad22622d07', 'globals.button.delete.notice', 'fabee0495e6942359b2e40155654f935', '删除后无法恢复，确定删除吗？', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('058f3060d1a843ec8e86ba89e783bae9', 'globals.button.delete.tip', '151a2daa734f4f3baf8f7d829fb24fa0', 'Deleting..', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('059d4407c9cf468b8843682b02394aa3', 'sys.fieldProperty.name', 'fabee0495e6942359b2e40155654f935', '属性名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('068351156db94845bc11d021d3968f89', 'sys.lang.key.notEmpty', 'fabee0495e6942359b2e40155654f935', '语言名称不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0782b70975e44ff4b8e40c6c278636cb', 'system.submit', '151a2daa734f4f3baf8f7d829fb24fa0', 'Loading...', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('087a87e8f4164fbe8b1a916d53616404', 'globals.button.delete.more', 'fabee0495e6942359b2e40155654f935', '删除选中', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0958e3a5f403475f9fd3c56c1b371796', 'sys.user.upTime', 'fabee0495e6942359b2e40155654f935', '更新时间', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0a8c3100b947462691c2a05f6379827a', 'system.confirm', 'fabee0495e6942359b2e40155654f935', '确 认', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0af4b2732982483b86b6ec3ed7c95e39', 'sys.dbBackup', 'fabee0495e6942359b2e40155654f935', '数据备份管理', '', '2020-08-25 11:33:58', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0c2d409e08f940188b03f789319005ec', 'system.exit', 'fabee0495e6942359b2e40155654f935', '全 选', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0cd4dd11cfb44938bb70dbd11cac90ab', 'sys.attachment.extensions', 'fabee0495e6942359b2e40155654f935', '文件后缀名', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0d2cee81a65f4a3ca95c4ee2ad1f9322', 'sys.menu.code.exists', 'fabee0495e6942359b2e40155654f935', '权限标识已存在', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0d33522a26a641339da945840f833469', 'sys.config.configKey', 'fabee0495e6942359b2e40155654f935', '唯一KEY名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0d7b50a9116247329c03870c07d62efb', 'sys.task.cron', 'fabee0495e6942359b2e40155654f935', '定时规则', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0d90dc4a031043e0af7222309eb5af79', 'system.ftp.username.notEmpty', 'fabee0495e6942359b2e40155654f935', '登录名不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0dae90dfc29d404f8bc8e3c79183c2cb', 'index.user.rightpass', '151a2daa734f4f3baf8f7d829fb24fa0', 'Confirm Password', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0e9d84b6654247e7ab8158d08d6ed1af', 'system.start', 'fabee0495e6942359b2e40155654f935', '发起', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0f02bd3a89904d62b58d86d332318ac7', 'sys.email.bcc', 'fabee0495e6942359b2e40155654f935', '密送地址', '', '2020-08-25 16:24:34', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('0f208a97a29f470e98fbb84168e3cf3d', 'index.panel', 'fabee0495e6942359b2e40155654f935', '自定义皮肤和布局', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('113db07534c54968bb9cd94e7ad72fa4', 'index.user.newpass', '151a2daa734f4f3baf8f7d829fb24fa0', 'New Password', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('11587c3f571a45dea31393cd8938d3da', 'index.notifications.title', '151a2daa734f4f3baf8f7d829fb24fa0', 'Notifications', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1161084dd9294a4ebefaf63fb75069d7', 'system.params.error', 'fabee0495e6942359b2e40155654f935', '表单参数错误', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('11afb6eef5444d26a1dd1e8075fb2c0f', 'system.send', 'fabee0495e6942359b2e40155654f935', '提 交', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('12bccaf2eadd4bd993d5375692577389', 'index.user.password', 'fabee0495e6942359b2e40155654f935', '修改密码', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('133b6ffce95543068fad7334b016e267', 'sys.lang.name1', 'fabee0495e6942359b2e40155654f935', '语言名称', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('14ff57472fee45cdbca1ed22d218485b', 'sys.task.lastexeResult', 'fabee0495e6942359b2e40155654f935', '最后一次执行结果', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1513149f8ff0441ea4c8511d59d98dd5', 'system.downloadTemplate', 'fabee0495e6942359b2e40155654f935', '下载模板', '', '2020-08-25 19:14:56', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('15d3f5e13a8c4d1faf09de26cd5c5763', 'system.web.login', 'fabee0495e6942359b2e40155654f935', '登录界面扫码登录开关', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('164a0c3e1958432ea6314a24afb879ca', 'sys.field.dataFieldProperty', 'fabee0495e6942359b2e40155654f935', '字段属性', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('16ab2ec27aec4b7ebdbddff9c8e993d0', 'system.all', 'fabee0495e6942359b2e40155654f935', '全 选', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('16ba1c2c5c544d01b3aef7560ca8c592', 'sys.unit.m.telephone', '151a2daa734f4f3baf8f7d829fb24fa0', 'Telephone', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('171f01dd99c0469ba570851a8355e8a4', 'sys.api', 'fabee0495e6942359b2e40155654f935', '密钥管理', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('182fca3424764e969d014fcf3e652d92', 'index.notifications.see', 'fabee0495e6942359b2e40155654f935', '查看更多', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('189d6ceb81314125b1911b3d6771531c', 'sys.api.name.notEmpty', 'fabee0495e6942359b2e40155654f935', '应用名称不能为空', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('19492e4996fd4bd7ba750071d57f1ee4', 'sys.log.type.opTime.hint', 'fabee0495e6942359b2e40155654f935', '时间查询', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('196a36566ee04f65900a84492559d54f', 'sys.unit.setTopUnit', 'fabee0495e6942359b2e40155654f935', '设为顶级单位', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('196ee481b9824159abbab10bb46c4629', 'globals.button.add', 'fabee0495e6942359b2e40155654f935', '新 增', '', '2020-05-11 14:02:43', null, '0', '2020-05-11 17:01:57');
INSERT INTO `sys_lang_msg` VALUES ('1975dd84dbfe47e1b3bdc8cbf850fa5f', 'sys.phone.state.success', 'fabee0495e6942359b2e40155654f935', '成功', '', '2020-08-25 17:03:16', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('197910f40ede4cddbd2f77a64643c6b8', 'sys.menu.defaultTopMenu', 'fabee0495e6942359b2e40155654f935', '不选择默认为顶级单位', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('19db2f118303479d967aa6834fbfee0b', 'system.not.allow', 'fabee0495e6942359b2e40155654f935', '不允许操作', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('19e5f18ad4e847c9b5146a6c183ace1b', 'index.menu', '151a2daa734f4f3baf8f7d829fb24fa0', 'MENU', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1a492c6b058143c6a788943fbb1460de', 'system.web.systemRegisterTime', 'fabee0495e6942359b2e40155654f935', '注册时间', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1a560fe0ff594a89ac0aef21c260f124', 'system.deploy', 'fabee0495e6942359b2e40155654f935', '部署', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1ab9fcb2a5a2458abe85581e5cf6d1a0', 'sys.route.type', 'fabee0495e6942359b2e40155654f935', '转发类型', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1ac567fe9a144877bc8d2cb6490893d5', 'sys.log.windowVersion', 'fabee0495e6942359b2e40155654f935', '操作系统', '', '2020-08-25 17:41:47', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1b5745b6df2441dea70417e38a8560ca', 'sys.database.name.error', 'fabee0495e6942359b2e40155654f935', '数据库名称不能为空', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1baf1dd4056f4193b6f0f869f7e5f318', 'login.error.locked', '151a2daa734f4f3baf8f7d829fb24fa0', 'Account Disabled', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1bee429e2f3f4519ad3194b80a7162f3', 'sys.field.dataFieldType', 'fabee0495e6942359b2e40155654f935', '字段类型', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1c0edcb2082d4d1880d5c8f93c5a3c3b', 'sys.role.allAuthor', 'fabee0495e6942359b2e40155654f935', '全部授权', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1c3b9c67dcde466e8d26767f0d2361d4', 'globals.button.update', '151a2daa734f4f3baf8f7d829fb24fa0', 'Update', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1ca462b579624570ba10bda6cb0ac50a', 'system.edit', 'fabee0495e6942359b2e40155654f935', '修改', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1d018c2acf4b49e1a5b3ed6da187397a', 'sys.field.note', 'fabee0495e6942359b2e40155654f935', '备注', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1d54c30679684922b048417e700c467d', 'sys.attachment.ftpState', 'fabee0495e6942359b2e40155654f935', '是否上传FTP', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1dc586b284b547418ba8a6023c58b429', 'sys.dict.selectParentmenu', 'fabee0495e6942359b2e40155654f935', '选择上级单位', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1df70300760a4fe88331d1ba6011bf55', 'sys.log.msg', 'fabee0495e6942359b2e40155654f935', '日志内容', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1e0c9421e58947ceb60b04cea1c74696', 'sys.user.loginName', 'fabee0495e6942359b2e40155654f935', '用户名', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1e5f30885c11424d9de3548474c653b1', 'sys.task.type.show', 'fabee0495e6942359b2e40155654f935', '显性转发', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1ee0045eeb7a4303ab3a4c200f617426', 'system.sms.formName', 'fabee0495e6942359b2e40155654f935', '发件人昵称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1f0926d9167c4a32bf23f3857fb1077e', 'system.graph', 'fabee0495e6942359b2e40155654f935', '流程图', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1fb37e20ff94476aaf10182604e3b3d4', 'system.email', 'fabee0495e6942359b2e40155654f935', '邮件配置', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('1fb9e3335c6d47b0a84dbc45f0f185c7', 'system.deletes', 'fabee0495e6942359b2e40155654f935', '批量删除', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2002c3c451ba4e80817bb73cfcbcd20f', 'sys.config.configValue.notEmpty', 'fabee0495e6942359b2e40155654f935', 'KEY值不能为空', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('20f8f05b38574864891e6376ebf38892', 'system.success', '151a2daa734f4f3baf8f7d829fb24fa0', 'Success', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2144eb0f4c3b405fb1cd5f8d7fc6503f', 'sys.route.url.error', 'fabee0495e6942359b2e40155654f935', '原始路径不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('217146e5fa0b40d9a6e2ef4ba72e00f7', 'sys.field.disable', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('21a86cb958c044b78a237a49ecfcddb2', 'index.panel', '151a2daa734f4f3baf8f7d829fb24fa0', 'Themes and Layout', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2279191172b34f70b604bbe5e66f44b9', 'sys.lang.key2', 'fabee0495e6942359b2e40155654f935', '语言标识符', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('233777e5b21f4d26acfc708e453ab400', 'system.ftp.host', 'fabee0495e6942359b2e40155654f935', '服务器地址', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('23983b5b58b7427f95b2d57eed8dacd9', 'sys.unit.field2', 'fabee0495e6942359b2e40155654f935', '附加值二', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('239f3e77549148458bb2df6803f3fddd', 'index.user.newPass.rightPass.noEq', 'fabee0495e6942359b2e40155654f935', '两次输入密码不相等', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('23dad8d361c94d6e8296f1a73271ae3e', 'index.custommenu.length', 'fabee0495e6942359b2e40155654f935', '常用菜单最多选择5个', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('244eb865c27b4834a8d33ca5c7e26b87', 'sys.systemField', 'fabee0495e6942359b2e40155654f935', '系统字段', '', '2020-08-28 11:58:11', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('24712820b2e94d038ea529d314b7f1d9', 'system.clear', 'fabee0495e6942359b2e40155654f935', '清 空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('24c8c7bca6d84b1dafb9a206368e0c09', 'globals.button.disable', '151a2daa734f4f3baf8f7d829fb24fa0', 'Disable', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2596f7b8ae174b7aa49a6e319dc3617b', 'index.menu', 'fabee0495e6942359b2e40155654f935', '菜单', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('25b5f6776c9d4470b44ff8227ffc15d8', 'system.ok', '151a2daa734f4f3baf8f7d829fb24fa0', 'Ok', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('25c06f4aa04e4b24ab53957b31bfbb94', 'sys.menu.aliasName.notEmpty', 'fabee0495e6942359b2e40155654f935', '菜单别名不能为空', '', '2020-08-19 09:37:54', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2635c789178d428d948f9afc1cb1b051', 'sys.table.tableType.error', 'fabee0495e6942359b2e40155654f935', '表类型不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('26502628a6f6447594d3e19a1800f224', 'sys.dict.value', 'fabee0495e6942359b2e40155654f935', '前端下拉值', '', '2020-08-29 11:17:01', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2676acfed6ee41559c753eb42229bc00', 'globals.button.confirm', 'fabee0495e6942359b2e40155654f935', '确 定', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2793058759e34dd1975c2b4df338a319', 'sys.attachment.name', 'fabee0495e6942359b2e40155654f935', '文件名称', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('27da20e4bec2445fb4634c647f9ac39c', 'sys.database.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('281afdcb2d364d20909c96bc2245421e', 'login.rememberme', '151a2daa734f4f3baf8f7d829fb24fa0', 'Remember Me', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('286b4c0836d8425b8171e282ccfd2037', 'sys.menu.target', 'fabee0495e6942359b2e40155654f935', '打开方式', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('29a9fd2f54a648a9af75d7bf8c95ef7a', 'sys.log.type.all', 'fabee0495e6942359b2e40155654f935', '全部日志', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2b0afdbc10f64ae1b6512eee65051cb8', 'sys.menu.permission.notEmpty', 'fabee0495e6942359b2e40155654f935', '权限标识不能为空', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2c451822c0944dbc83568477cf7538b8', 'sys.lang.name', 'fabee0495e6942359b2e40155654f935', '字符串标识', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2c615fba68a0450586257787c6ddc6ac', 'sys.task', 'fabee0495e6942359b2e40155654f935', '定时任务配置', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2cd2dd1aaa0b484b8ed83add2e001a3f', 'sys.user.note', 'fabee0495e6942359b2e40155654f935', '用户简介', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2d0d16ece1db4db088f3c5a31d429e56', 'sys.task.jobType', 'fabee0495e6942359b2e40155654f935', '任务类型', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2dac25eb5b2c416eba73db4d3da1bcc3', 'globals.button.delete', 'fabee0495e6942359b2e40155654f935', '删 除', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2e549ec41c4f4f0ebe5faad635d16d5f', 'sys.role.doBatchPermissionsUser', 'fabee0495e6942359b2e40155654f935', '批量分配用户', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2e9948258fe943e7a7c7277fa8f05fbd', 'system.email.host', 'fabee0495e6942359b2e40155654f935', '服务器地址', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2f4765e252e943f3a6610c3620a06848', 'system.ftp.host.notEmpty', 'fabee0495e6942359b2e40155654f935', '服务器地址不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2f621a18baac4fe68ece300a3076985e', 'globals.button.enable', '151a2daa734f4f3baf8f7d829fb24fa0', 'Enable', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2fbf454e430f4529bd620370ad51d4fe', 'sys.fieldProperty.disable', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('2febb9916d5a46e5a878431b2d293f97', 'sys.email.lastSendTime', 'fabee0495e6942359b2e40155654f935', '最后发送时间', '', '2020-08-25 16:02:13', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('301d13fe25dd457b8dbd499490b33165', 'sys.ip.note', 'fabee0495e6942359b2e40155654f935', '备注', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3078293817234bad93287d8925b431e3', 'sys.table.copyTable', 'fabee0495e6942359b2e40155654f935', '复制表结构', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('30bb2d7560c9469c88ed2d676596a5d8', 'index.links', '151a2daa734f4f3baf8f7d829fb24fa0', 'LINKS', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('313f57cc1846410ba87c41b1e966b67b', 'sys.field.useForCopy', 'fabee0495e6942359b2e40155654f935', '是否用于复制', '', '2020-08-28 11:58:09', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('31dcf8ab917341c7b4a2bbd77db2d374', 'sys.log.optTime', 'fabee0495e6942359b2e40155654f935', '操作时间', '', '2020-08-25 17:42:52', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('32974f326b104a1583ed839372290eae', 'login.register', 'fabee0495e6942359b2e40155654f935', '注册', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('330af7f24be94c9587b36ff5110c4d11', 'sys.unit.topUnit', '151a2daa734f4f3baf8f7d829fb24fa0', 'Top Unit', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('333c0ff363d146149a9e0d9fa0459aa7', 'sys.route.url', 'fabee0495e6942359b2e40155654f935', '原始路径', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('33bdafd5ee544e5aa8bdac5446121ff9', 'sys.menu.target.pjax', 'fabee0495e6942359b2e40155654f935', 'data-pjax', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3504bb76bae14dcca23e4c63b5db2747', 'sys.dbBackup.now', 'fabee0495e6942359b2e40155654f935', '立即备份', '', '2020-08-25 11:33:58', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('35c981ee93cf4493ac908038577265c2', 'sys.user.password', 'fabee0495e6942359b2e40155654f935', '登陆密码', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('35d61909ead04348962dc83fb57275f7', 'sys.lang.value2.notEmpty', 'fabee0495e6942359b2e40155654f935', '字符串标识符不能为空', '', '2020-05-11 14:24:32', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3613d69c1fd248d8bd60596eaf9cbc4a', 'system.close', '151a2daa734f4f3baf8f7d829fb24fa0', 'Close', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3782aca18073435288d748eb692cf247', 'system.close', 'fabee0495e6942359b2e40155654f935', '取 消', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('37eea3394ffc4792a58f0d495be5cd73', 'index.layout', '151a2daa734f4f3baf8f7d829fb24fa0', 'Layout', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('38ca47b989114eb98b0aa044d165e66f', 'sys.unit.selectParentUnit', 'fabee0495e6942359b2e40155654f935', '选择上级单位', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('38f0cc5dc5264a41b0cdc0d05d0b4936', 'sys.log.opTime', 'fabee0495e6942359b2e40155654f935', '操作时间', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3a42b374efcc41b2bdfbce9c841d36a3', 'sys.task.type.hide', 'fabee0495e6942359b2e40155654f935', '隐性转发', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3aac42bc964343bc8aaefe00949e2554', 'system.ftp.name', 'fabee0495e6942359b2e40155654f935', '唯一KEY', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3aebacc7416e466da3b57e7e6e930dba', 'sys.user.loginIp', 'fabee0495e6942359b2e40155654f935', '登陆IP', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3b32ef5dbad84046aebda1246894294b', 'globals.button.submit.tip', '151a2daa734f4f3baf8f7d829fb24fa0', 'Submitting...', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3b457dcba5094826a8a904385857f98f', 'system.ftp', 'fabee0495e6942359b2e40155654f935', '文件服务器（FTP）配置', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3be4b85a7aa44841acd02b6c5b8bd510', 'sys.fieldProperty.note', 'fabee0495e6942359b2e40155654f935', '备注', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3c55250907a34622aafeb2b02584a3c1', 'login.load', 'fabee0495e6942359b2e40155654f935', '正在登录...', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3cd75ae07d634cf8b645788f8af83772', 'system.default', 'fabee0495e6942359b2e40155654f935', '默认设置', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3d5a78e6dca34c68900311987356223e', 'system.query', 'fabee0495e6942359b2e40155654f935', '查 询', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3d6afff0f27c47c6b230d1e5255f283f', 'login.title', 'fabee0495e6942359b2e40155654f935', '系统登录', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3d6eae69556346e1877d0d8a2d6a765d', 'system.exception', '151a2daa734f4f3baf8f7d829fb24fa0', 'Server exception', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3dd45023246942479997b90aef9ee816', 'sys.task.jobStatus', 'fabee0495e6942359b2e40155654f935', '任务状态', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3e23dfdb8ea2478a9563df2200ae552a', 'system.delete.hint', 'fabee0495e6942359b2e40155654f935', '请确认是否删除', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3e3231221b274e3d85437f0c98caa0d6', 'sys.task.resum', 'fabee0495e6942359b2e40155654f935', '恢复', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3ea9ff04fceb4d79b37b17c01b7c07fe', 'sys.menu.note', 'fabee0495e6942359b2e40155654f935', '菜单介绍', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3eb22cd099b14e908ea344ec36008ee9', 'system.email.formName', 'fabee0495e6942359b2e40155654f935', '发件人昵称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3ecd3beae9414dda96e6490faec57413', 'system.email.form', 'fabee0495e6942359b2e40155654f935', '发件人邮箱', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('3f6c6f386e6143b2b35de887f1cf2d99', 'index.user.oldpass', '151a2daa734f4f3baf8f7d829fb24fa0', 'Old Password', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('40cfa3ce35a34fda882168b89cc898f6', 'system.details', 'fabee0495e6942359b2e40155654f935', '详细情况', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('40d1bcb128114ffbbf93ce91e2a587bd', 'sys.fieldProperty.conciseDataFieldType', 'fabee0495e6942359b2e40155654f935', '数据类型', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('41335f9e79494ed48c3fe7cdd30b1186', 'index.user.mode', '151a2daa734f4f3baf8f7d829fb24fa0', 'Mode', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4274a3cd2d4a4f8cbeee327e67d1035b', 'sys.task.history', 'fabee0495e6942359b2e40155654f935', '历史记录', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('439f10753f2746e1a2544d7c9bdd9e41', 'sys.unit.defaultTopUnit', '151a2daa734f4f3baf8f7d829fb24fa0', 'Default Top Unit', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('43b5ab14c5674b86854164a4bfb43bef', 'sys.menu.menuIcon', 'fabee0495e6942359b2e40155654f935', '菜单图标', '', '2020-08-24 15:24:08', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('452e87d1435e4bc1a88549616fb5197f', 'system.success', 'fabee0495e6942359b2e40155654f935', '操作成功', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('459f5e45245e4802a51593a954d5b2d4', 'globals.button.update', 'fabee0495e6942359b2e40155654f935', '修 改', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('46a2f543881c4742b654c55181abd5ef', 'sys.api.appKey', 'fabee0495e6942359b2e40155654f935', 'APP KEY', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('46c4a85ebfbe43a0a43406c037dd4050', 'login.foget', '151a2daa734f4f3baf8f7d829fb24fa0', 'Foget Password', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('46f08e04673345bc87caff80cfcca1bd', 'sys.task.name.error', 'fabee0495e6942359b2e40155654f935', '任务名不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('47cb411556544a97beeae22f21a9d38b', 'login.error.verifycode', 'fabee0495e6942359b2e40155654f935', '请输入验证码', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('487f006ed6c741019092c11f18302ea0', 'sys.dict.field1', 'fabee0495e6942359b2e40155654f935', '附加值一', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('489d8f76d05940f6b5dd16763df79f11', 'sys.verify.email.emailName', 'fabee0495e6942359b2e40155654f935', '发送邮件', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('492e8fbc4e354c2593f3d08294a9a88a', 'sys.role.batchAuthor', 'fabee0495e6942359b2e40155654f935', '批量授权', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('497e8397085a4823b1d55d1aaef17c71', 'sys.table.tableCode', 'fabee0495e6942359b2e40155654f935', '表编码', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4a64d6a7b5bf4f2e85cc10b4e0e1a263', 'sys.menu.name.notEmpty', 'fabee0495e6942359b2e40155654f935', '菜单名称不能为空', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4ab26c01095d40ae916059483228e851', 'sys.userImport', 'fabee0495e6942359b2e40155654f935', '数据导入', '', '2020-08-25 19:43:41', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4acd091afe2f4df6a3f954bbc1881d3d', 'sys.unit.selectParentUnit', '151a2daa734f4f3baf8f7d829fb24fa0', 'Select Parent Unit', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4c94bfb5199b4c6aab389f5a52662bb6', 'system.web.metaDescribe', 'fabee0495e6942359b2e40155654f935', 'META描述', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4d96f70c8fa842e389dcce86d794e15c', 'sys.unit.m.unitcode', '151a2daa734f4f3baf8f7d829fb24fa0', 'Code', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4de1af2499fc460a8761fc168dfa9361', 'sys.email.emailName', 'fabee0495e6942359b2e40155654f935', '发送邮件', '', '2020-08-25 16:02:12', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4e402854b07d49aeb0effd70e0e98e09', 'sys.unit.m.name', '151a2daa734f4f3baf8f7d829fb24fa0', 'Name', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4e72324c102f49c7b19de1f05311ae4b', 'sys.menu.parentMenu', 'fabee0495e6942359b2e40155654f935', '上级菜单', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4eabcc9b71454fb4bc99984ddcfb2fd9', 'sys.task.jobClass.error', 'fabee0495e6942359b2e40155654f935', '执行类不能为空', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4f63a70608a240d196739655266e5bed', 'system.ftp.name.exists', 'fabee0495e6942359b2e40155654f935', '唯一名称【{0}】已存在', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4f8a2c379848428f86da0762bd186e90', 'globals.button.cancel.tip', '151a2daa734f4f3baf8f7d829fb24fa0', 'Canceling...', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('4f9024e52a8d4598a143b89e710206b9', 'sys.role.error', 'fabee0495e6942359b2e40155654f935', '请选择上级上级角色', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('503b239867c745d2b2f66c1c253076c9', 'login.captcha', 'fabee0495e6942359b2e40155654f935', '验证码', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('505e116d4c0546a18c3cc087aa8b5429', 'sys.email.cc', 'fabee0495e6942359b2e40155654f935', '抄送地址', '', '2020-08-25 16:24:33', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('51f4957c57884280aed982fa2f8a7b3e', 'sys.database.note', 'fabee0495e6942359b2e40155654f935', '备注', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('521abc3e1a0b4d19afb14acdb195433a', 'system.endTime', 'fabee0495e6942359b2e40155654f935', '结束时间', '', '2020-08-25 11:40:23', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5255db41276949b0b6a17d7157312300', 'system.ftp.name.notEmpty', 'fabee0495e6942359b2e40155654f935', '唯一名称不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('53b673450cd6453086f812f3d3681c4b', 'index.user.exit', 'fabee0495e6942359b2e40155654f935', '退出登录', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('54bbe7eccaf64874adfa208b69010841', 'index.mode.pajax.hint', 'fabee0495e6942359b2e40155654f935', '优点：占用带宽少，加载速度快；缺点：不能使用前进、后退功能。', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('54f8d84d9c4f47f1a43f13986c0648de', 'sys.role.allClearAuthor', 'fabee0495e6942359b2e40155654f935', '全部清空授权', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('551a3391b4d241f194b6a9d7472edaa8', 'sys.lang.choose', 'fabee0495e6942359b2e40155654f935', '请选择语言', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('55707970884f416cb982442a439faecf', 'sys.unit.parentUnit', '151a2daa734f4f3baf8f7d829fb24fa0', 'Parent Unit', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('55ae43761a4645d18f7a46c8433651d0', 'sys.task.updateArgs', 'fabee0495e6942359b2e40155654f935', '修改成功，请停止任务，重启任务生效!', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('55e2c687cce748ae92a7bbf34a1cea1c', 'system.systemConfig', 'fabee0495e6942359b2e40155654f935', '系统专用', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5647dbc993d34a29a0e5882ecf853a5c', 'sys.field.physicalName', 'fabee0495e6942359b2e40155654f935', '物理名称', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('564983e83560438e903d1cfe689d3acb', 'sys.dict.defaultTopMenu', 'fabee0495e6942359b2e40155654f935', '不选择默认为顶级单位', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('566d3c1ead414c96bbd78a98889a0dc5', 'system.confirm', '151a2daa734f4f3baf8f7d829fb24fa0', 'Confirm', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('568d51e9a2d64a30847832f75231ee59', 'sys.attachment', 'fabee0495e6942359b2e40155654f935', '系统附件管理', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5739e31dbab144f1acdbbb69c16a554a', 'sys.dbBackup.fileSize', 'fabee0495e6942359b2e40155654f935', '文件大小', '', '2020-08-25 11:34:00', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('57c28f4d591a4d7fb2159d3a539e1725', 'sys.attachment.type', 'fabee0495e6942359b2e40155654f935', '附件类型', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('57f4ff938f844ae09289c8d0e1d8a77e', 'system.ftp.post.notEmpty', 'fabee0495e6942359b2e40155654f935', '端口号不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5832fb35002a4fbc94a531055fc85df4', 'sys.database.physicalName', 'fabee0495e6942359b2e40155654f935', '数据库简称', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5874e00fa5034202942b94e542fa74c3', 'system.startMonth', 'fabee0495e6942359b2e40155654f935', '开始月份', '', '2020-08-25 11:41:38', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('597704bb7dbc43c79ccfd4a60e3980a4', 'index.user.rightPass.error', 'fabee0495e6942359b2e40155654f935', '确认密码不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5b00a0f6aefc4abaad12a8ec61d66113', 'system.sms.form', 'fabee0495e6942359b2e40155654f935', '发件人邮箱', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5b1ab30fefdb4668bca862824f75edf8', 'sys.unit.setTopUnit', '151a2daa734f4f3baf8f7d829fb24fa0', 'Set Top Unit', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5b3ad8aec9f04ac58ffc3ab727dae6fa', 'index.user.oldPass.error', 'fabee0495e6942359b2e40155654f935', '原密码不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5b97d07cce354898bd30e0d99db68461', 'index.home', 'fabee0495e6942359b2e40155654f935', '我的首页', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5bf4708e59d041a49ec1420e5c954ac8', 'system.moveDown', 'fabee0495e6942359b2e40155654f935', '下移', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5c149c2e7f5c4c59989eb1dafbae93f2', 'sys.role.code', '151a2daa734f4f3baf8f7d829fb24fa0', 'Permission already exists', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5c58a894e01e43c39ba37d5971d2b030', 'sys.ip', 'fabee0495e6942359b2e40155654f935', 'IP过滤管理', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5cf418e308ad4c6185a8b71fd1faae27', 'sys.phone.code', 'fabee0495e6942359b2e40155654f935', '手机验证码管理', '', '2020-08-25 17:03:16', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5d190d9ef9654ddbb9ca8dbb38526273', 'system.disable', 'fabee0495e6942359b2e40155654f935', '禁用', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5d34b9cc5bb043079b7983f8799c9148', 'system.timeSeparate', 'fabee0495e6942359b2e40155654f935', '至', '', '2020-08-25 11:40:23', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5da66b7700384b22bc1f4778bf51894b', 'sys.field.identifying', 'fabee0495e6942359b2e40155654f935', '标识规范', '', '2020-08-28 11:58:11', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5db9b8f92aa5402fa3d68f9fd45cc6aa', 'sys.field.enumType', 'fabee0495e6942359b2e40155654f935', '枚举类型', '', '2020-08-29 15:46:59', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5e8c761b061e4ef4add97ff87295c4aa', 'sys.role.note', 'fabee0495e6942359b2e40155654f935', '角色简介', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5e9ae3b4abab44a4aa357626884d380b', 'sys.unit.topUnit', 'fabee0495e6942359b2e40155654f935', '顶级单位', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5eeec2de39eb4f0a8a6d066fa04ababa', 'system.sms', 'fabee0495e6942359b2e40155654f935', '短信配置', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5f25c7c77b5441e3a06fd1f90aec1b27', 'sys.log.param', 'fabee0495e6942359b2e40155654f935', '请求参数', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5f5b9b686b9f40409611100411904359', 'index.custommenu', 'fabee0495e6942359b2e40155654f935', '常用菜单', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('5fdd39df60444bfeb03e9438e70b883e', 'sys.phone.state.fail', 'fabee0495e6942359b2e40155654f935', '失败', '', '2020-08-25 17:03:18', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6022cf48e28a473dbe17c1ab51b506ff', 'sys.task.note', 'fabee0495e6942359b2e40155654f935', '任务说明', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6052ba7834164597833fd73e32a67923', 'sys.phone.lastSendTime', 'fabee0495e6942359b2e40155654f935', '最后发送时间', '', '2020-08-25 17:03:19', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6058f5374ca149fabd10bfcf451c7296', 'system.web.loginErrorCount', 'fabee0495e6942359b2e40155654f935', '登录错误次数限制', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('606bd73e052748e987b77fec29a37cb1', 'sys.fieldProperty.conciseDataFieldType.error', 'fabee0495e6942359b2e40155654f935', '数据类型不能为空', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6212fc843c8646bcaeb927ed6c20968a', 'system.export', 'fabee0495e6942359b2e40155654f935', '导出', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('622297b6dfa7490ca2734096063164fd', 'globals.button.ok', '151a2daa734f4f3baf8f7d829fb24fa0', 'Ok', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('622fc8ea4daf424d820b153f4e2149b8', 'sys.route.toUrl.error', 'fabee0495e6942359b2e40155654f935', '跳转路径不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6302bdf22a634a008a903b3f95145bfb', 'globals.file.uploadTip', 'fabee0495e6942359b2e40155654f935', '将文件拖到此处，或<em>点击上传</em>', '', '2020-08-25 19:48:18', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('63488488d61d426b801eb9da5ab634cf', 'system.web.copyright', 'fabee0495e6942359b2e40155654f935', '版权信息', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('63ccea54b68c488ab8ad9cd04f8692a0', 'system.web.pwdChange', 'fabee0495e6942359b2e40155654f935', '密码定时过期(月)', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6486201dd75e4a429c21b7fee3210f12', 'sys.log.src', 'fabee0495e6942359b2e40155654f935', '执行类', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('64b6a3a335a24fdc8ed6fd5efe34275e', 'sys.dict.name.notEmpty', 'fabee0495e6942359b2e40155654f935', '权限标识已存在', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('64be72fb838f43d99f17024d97cb56d6', 'login.password', '151a2daa734f4f3baf8f7d829fb24fa0', 'Password', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('64bea37420bf4897926a7de6dffe11db', 'system.top', 'fabee0495e6942359b2e40155654f935', '置顶', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('64eac51808144dc1a9e658178bbe5f30', 'sys.field.regexExpression', 'fabee0495e6942359b2e40155654f935', '正则表达式', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('651072e978ac44969d5448e05fdd3415', 'sys.dict.sysCode.exists', 'fabee0495e6942359b2e40155654f935', '系统编码已存在', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('65142884cee745ea80bc4b850d8382bb', 'system.delete', 'fabee0495e6942359b2e40155654f935', '删除', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('66ff00f27074457eb9360546bc4ffd99', 'sys.log.type.info', 'fabee0495e6942359b2e40155654f935', '用户日志', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('671c5f4cdb6a48059233a40781e62acd', 'index.mode.pajax', 'fabee0495e6942359b2e40155654f935', 'PJAX加载方式', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('671eddbef49e45baa9262f06dc7d7083', 'system.web.blockKeywords', 'fabee0495e6942359b2e40155654f935', '屏蔽关键词', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('679ce103465a4b91a2e9025cb238f91e', 'sys.unit.m.address', '151a2daa734f4f3baf8f7d829fb24fa0', 'Address', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('67d15af520534a66a3f26f67e03f89cb', 'sys.role.lookPermissions', 'fabee0495e6942359b2e40155654f935', '查看权限', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('69352623ec9547619e2740e7308361ba', 'sys.config.note', 'fabee0495e6942359b2e40155654f935', '备注', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('693943f8bf8740a69bf3f1892011bbf0', 'sys.email.taskTime', 'fabee0495e6942359b2e40155654f935', '定时发送时间', '', '2020-08-25 16:47:49', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('693f5125887a4f54b8f0efc4d5b0e712', 'sys.menu.type.menu', 'fabee0495e6942359b2e40155654f935', '菜单', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('69c4c2cdf35b4aa39c59fa558880fe81', 'system.submit', 'fabee0495e6942359b2e40155654f935', '提交中...', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('69f562be8e0c425ab527eb5cb95797a2', 'globals.button.submit', '151a2daa734f4f3baf8f7d829fb24fa0', 'Submit', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6a524afef7c64750b12c65362209bc3e', 'sys.phone.phoneName', 'fabee0495e6942359b2e40155654f935', '发送号码', '', '2020-08-25 17:08:00', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6ae64253803541df9c7aa12a4f728fe5', 'system.email.name', 'fabee0495e6942359b2e40155654f935', '唯一KEY', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6c7233627cb14a0f8d5bcda393e175e3', 'sys.database.databaseCode.error', 'fabee0495e6942359b2e40155654f935', '数据库编码不能为空', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6cb688877edd433bbbca4518e29ed5d9', 'sys.log.browser', 'fabee0495e6942359b2e40155654f935', '浏览器标识', '', '2020-08-25 17:41:47', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6cc24946ac8f412db5872a562578b4f7', 'sys.task.exeState', 'fabee0495e6942359b2e40155654f935', '执行状态', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6d7ac57da64443308426444a3f7ec40c', 'sys.fieldProperty.name.error', 'fabee0495e6942359b2e40155654f935', '属性名称不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6ee46554e8ab47f182e3d67670d19169', 'sys.table.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6f23947bdd8a4872a9f42f152bf56396', 'sys.dict.code.notEmpty', 'fabee0495e6942359b2e40155654f935', '字典编码不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6f56e985a872470ab5a4c6f5a8ff4ea1', 'index.home', '151a2daa734f4f3baf8f7d829fb24fa0', 'Dashboard', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6f8d3d8eb9b542108f93787bfe40afe1', 'sys.verify.email.phoneName', 'fabee0495e6942359b2e40155654f935', '发送电话', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('6fa1adc7b0df4434a01bdf3b574fe04f', 'system.ftp.password', 'fabee0495e6942359b2e40155654f935', '登录密码', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('703ab54e2a5f4b8cabb71d4034455943', 'sys.role.code', 'fabee0495e6942359b2e40155654f935', '角色编码', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('70510b21fad44ac28f02328c7bb4941e', 'system.email.password', 'fabee0495e6942359b2e40155654f935', '登录密码', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('70a6f67ae6bf4c6a9dc00493a55ed159', 'login.submit', '151a2daa734f4f3baf8f7d829fb24fa0', 'Submit', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('71297e16cd7840988f9887341eba8735', 'sys.fieldProperty.sysCode.error', 'fabee0495e6942359b2e40155654f935', '系统编码已存在', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7177f7a194424457ba916ab2a06e009e', 'system.history', 'fabee0495e6942359b2e40155654f935', '历史', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('71add4e957f14331b186b6b2597aaeb6', 'sys.verify.state', 'fabee0495e6942359b2e40155654f935', '发送状态', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7230992faabf4738a5b7415e044c1d57', 'globals.button.cancel', 'fabee0495e6942359b2e40155654f935', '取 消', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7285dcf8abb04ac0a29ae93e65538b75', 'sys.table.name', 'fabee0495e6942359b2e40155654f935', '表名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('73106c8930e046b5aefd31f2f42039bf', 'globals.button.delete', '151a2daa734f4f3baf8f7d829fb24fa0', 'Delete', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('740d9af88673448f9a62716351e873e2', 'globals.button.confirm.tip', 'fabee0495e6942359b2e40155654f935', '正在保存...', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('748eb3a965e34a7a9bf0c24793f83f73', 'sys.field.requiredDataField', 'fabee0495e6942359b2e40155654f935', '是否必填', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('749851b1a6be410a9f04c860b90e5c42', 'sys.unit.parentUnit', 'fabee0495e6942359b2e40155654f935', '上级单位', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('762a4f1c12574112ac2c8a592423760a', 'sys.ip.notEmpty', 'fabee0495e6942359b2e40155654f935', ' IP不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('76827003840e47aea29f8bea2698220c', 'sys.field.enumRely', 'fabee0495e6942359b2e40155654f935', '枚举依赖', '', '2020-08-29 15:46:58', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('76c560ee339147b2a251d5610cd01125', 'sys.role.parentRole', 'fabee0495e6942359b2e40155654f935', '上级菜单', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7777141ed89546c08ecd9fb2b587af75', 'globals.button.ok', 'fabee0495e6942359b2e40155654f935', '知道了', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7804bf2b36d04288892cef5b8f136e0b', 'login.register', '151a2daa734f4f3baf8f7d829fb24fa0', 'Register', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7828215d240b4a3da6af7dbf99331a86', 'sys.menu.topmenu', 'fabee0495e6942359b2e40155654f935', '顶级单位', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('788b98629aff4a948fdd7184b07da89a', 'system.copy', 'fabee0495e6942359b2e40155654f935', '复制', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('78917ddf39a84020a3ccbfb8542d23f4', 'login.error.captcha', '151a2daa734f4f3baf8f7d829fb24fa0', 'Captcha Error', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('78964faa7a794e70818848852304f8e7', 'index.mode.page.hint', 'fabee0495e6942359b2e40155654f935', '优点：可以使用前进、后退功能；缺点：页面会重载、刷新，占用带宽大。', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('79cc1339bdb844f591b360bed9c5e8e5', 'sys.user.lookPermissions', 'fabee0495e6942359b2e40155654f935', '权限', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7b2bca42759647a9856b97c805ac6722', 'sys.lang.value.notEmpty', 'fabee0495e6942359b2e40155654f935', '语言标识符不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7b83b72853d4451d83dcccb685b68b25', 'sys.field.tooltip', 'fabee0495e6942359b2e40155654f935', '提示信息', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7bea9d82d0154a3e9efd1646e5de3046', 'sys.log.userName', 'fabee0495e6942359b2e40155654f935', '操作人姓名', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7c290accebcc475ea0a425e3db00aa40', 'system.enable', 'fabee0495e6942359b2e40155654f935', '启用', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7cd477098bfc489791c10b893b89d0a5', 'sys.email.sendNum', 'fabee0495e6942359b2e40155654f935', '已发送次数', '', '2020-08-25 16:24:32', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7cf58a49d820438e9ebcdc497f7b335c', 'sys.table.tableType', 'fabee0495e6942359b2e40155654f935', '表类型', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7d0fd96387494d68a6f45866bff4c94e', 'sys.task.oneExec', 'fabee0495e6942359b2e40155654f935', '立即执行一次', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7d33eb2873204a29ae79c2738f795810', 'globals.button.delete.more', '151a2daa734f4f3baf8f7d829fb24fa0', 'Delete selected', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7e85f1084914428fbb5948f2956bea4f', 'system.startTime', 'fabee0495e6942359b2e40155654f935', '开始时间', '', '2020-08-25 11:40:23', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7fec2a3d483445a39c427411c567bd78', 'globals.button.confirm', '151a2daa734f4f3baf8f7d829fb24fa0', 'Confirm', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7ff4cc2366c14382ba5c0946acab015f', 'sys.log.type.login', 'fabee0495e6942359b2e40155654f935', '登录日志', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('7ff80973c99d4f5ea85c5c2c980bad99', 'sys.email.errorMsg', 'fabee0495e6942359b2e40155654f935', '错误信息', '', '2020-08-25 16:02:14', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('80493a8574684a7e890908336a86d4f1', 'sys.menu.error', 'fabee0495e6942359b2e40155654f935', '请选择要添加的节点', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('804f3de4d3a64cd69d2557f3e69b3817', 'system.web', 'fabee0495e6942359b2e40155654f935', '网站配置', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('805e184ac0a84898b33d97f52ff409e1', 'globals.file.startUpload', 'fabee0495e6942359b2e40155654f935', '开始上传', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('80fa3a106d33486bb69850ec9b710059', 'sys.ip.name', 'fabee0495e6942359b2e40155654f935', 'IP地址', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8129dc60a48d4e2183be884339f393ab', 'sys.lang.value', 'fabee0495e6942359b2e40155654f935', 'VALUE', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8197917c17494714a5c0cdc1522325d6', 'index.user.setting', 'fabee0495e6942359b2e40155654f935', '个人设置', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('81dcfc7d58124d14aaeb76ead92fe6e4', 'globals.button.delete.select', 'fabee0495e6942359b2e40155654f935', '请先选择要删除的项！', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('82acbded9bea448a8b664acd5bb884ac', 'sys.role.batchClearAuthor', 'fabee0495e6942359b2e40155654f935', '批量取消授权', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('82ee0191c76140b085d0209d4ac33f79', 'sys.fieldProperty.conciseDataFieldType.notEmpty', 'fabee0495e6942359b2e40155654f935', '数据类型不能为空', '', '2020-08-19 09:37:56', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('834b0c6dca584472bbe42dbafddb2877', 'sys.task.cron.btn', 'fabee0495e6942359b2e40155654f935', '表达式生成器', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('83dba950209e4d818e74a449d32ec547', 'sys.role.clearAuthor', 'fabee0495e6942359b2e40155654f935', '取消授权', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('848b0defe5954fba837b8ac151752fb0', 'globals.button.delete.select', '151a2daa734f4f3baf8f7d829fb24fa0', 'Please select items to delete first!', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('84c2c8d2469a42d9928e5242cc8a30da', 'sys.field.enumId', 'fabee0495e6942359b2e40155654f935', '枚举', '', '2020-08-28 11:58:08', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('85ef38b2afe1497bb89637a63df93c93', 'sys.log', 'fabee0495e6942359b2e40155654f935', '日志管理', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('86a917620e6442bc94d27f6c4d415641', 'wf.category.name', 'fabee0495e6942359b2e40155654f935', '分类名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('86b8c1ddd89f48deb890702247f81942', 'sys.menu.target.notEmpty', 'fabee0495e6942359b2e40155654f935', '打开方式不能为空', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('87142f1dacba4558920015637194ee2e', 'system.web.metaKeyWords', 'fabee0495e6942359b2e40155654f935', 'META关键词', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('87e6278c4dc84d969bb8df7f4fc0a33b', 'sys.route', 'fabee0495e6942359b2e40155654f935', '路由配置', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8a94aef21ce14630881b304ca547e03f', 'sys.user.email', 'fabee0495e6942359b2e40155654f935', '电子邮箱', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8ac68483e87640d49c40f1d3cbd5b607', 'sys.field.dataFieldLength', 'fabee0495e6942359b2e40155654f935', '字段长度', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8b3f444c88fd45cabef138f64bbf6734', 'globals.button.cancel.tip', 'fabee0495e6942359b2e40155654f935', '正在取消...', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8bbfb956164546e196d5249aeec5e598', 'sys.ip.name.notEmpty', 'fabee0495e6942359b2e40155654f935', ' IP不能为空', '', '2020-08-24 15:09:52', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8be1d1ca2fd74a2ebed9a8c2c0c4936b', 'system.email.post', 'fabee0495e6942359b2e40155654f935', '端口号', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8cd489cbe9844137a3cc16ca9fc23075', 'system.disabled.yes', 'fabee0495e6942359b2e40155654f935', '是', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8d1c8749adeb4ef89c01648a9b833d1c', 'sys.role.aliasName', 'fabee0495e6942359b2e40155654f935', '角色别名', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8d567ca0c41b4097bb3a48f89df08f7e', 'system.optTime', 'fabee0495e6942359b2e40155654f935', '操作时间', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8db760f0bc074a13a8ad1db58253f7f1', 'system.sending', 'fabee0495e6942359b2e40155654f935', '正在提交...', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('8f22105ef855403cb9c1a00063c2c587', 'login.username', 'fabee0495e6942359b2e40155654f935', '用户名', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('900384241cb0423b986bfc90186eaed1', 'system.web.cache.time', 'fabee0495e6942359b2e40155654f935', '缓存时间', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('90262e8874014dfba0e7e483726c4cfd', 'sys.unit.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('902929da09d240b1a3067b0d5b6829a2', 'system.import', 'fabee0495e6942359b2e40155654f935', '导入', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('90c313106b5c4a4d9c54d2a4d60bc51d', 'system.cancel', '151a2daa734f4f3baf8f7d829fb24fa0', 'Cancel', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('90dbbe3ced3442f3913a875f472e143b', 'login.captcha', '151a2daa734f4f3baf8f7d829fb24fa0', 'Captcha', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('90ea4585de674d149c229038e7442517', 'sys.dict.note', 'fabee0495e6942359b2e40155654f935', '字典简介', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('90fc843428224aab9e64a3a5c663717a', 'globals.button.confirm.tip', '151a2daa734f4f3baf8f7d829fb24fa0', 'Saving...', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('915913eceb324f37b0f7a0005bcc7048', 'globals.button.submit.tip', 'fabee0495e6942359b2e40155654f935', '正在提交...', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('91a33630e6044d00a78553bf3befcdfa', 'globals.table.column.true', 'fabee0495e6942359b2e40155654f935', '是', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('91e82d824eeb49afa675da38da3975ad', 'login.password', 'fabee0495e6942359b2e40155654f935', '密码', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('935a447aa1ab4be29a286ada4d7d088a', 'system.reSend', 'fabee0495e6942359b2e40155654f935', '重新发送', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('935fa14178874ca0bbf82fcafe510cb3', 'sys.email.state.success', 'fabee0495e6942359b2e40155654f935', '成功', '', '2020-08-25 16:02:14', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('93d41f21f6cc4124b65733b865d6a875', 'login.error.system', '151a2daa734f4f3baf8f7d829fb24fa0', 'System Error', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('943fca7c6ccd476ca39ce432cc467b55', 'globals.button.back', '151a2daa734f4f3baf8f7d829fb24fa0', 'Back', '', '2020-05-11 14:02:42', null, '0', '2020-05-11 16:19:42');
INSERT INTO `sys_lang_msg` VALUES ('94adaf08fcf04af6b086d30b2314d860', 'sys.user.createTime', 'fabee0495e6942359b2e40155654f935', '创建时间', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9579e4722408426d81258248727ed2a5', 'globals.file.stopUpload', 'fabee0495e6942359b2e40155654f935', '暂停上传', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('958e354cb39240eab5a9ecdbb01d2805', 'sys.email.maxSendNum', 'fabee0495e6942359b2e40155654f935', '重新发送次数限制', '', '2020-08-25 16:24:33', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('95af87785c4a4c84adb34c1cd7febb41', 'globals.button.delete.tip', 'fabee0495e6942359b2e40155654f935', '正在删除..', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('95bf7f7255ac40af8414c2fedf868438', 'sys.unit.m.note', '151a2daa734f4f3baf8f7d829fb24fa0', 'Note', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('95ca4e80006c4fe3a1712b95e702e051', 'sys.database.name', 'fabee0495e6942359b2e40155654f935', '数据库名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('96ba4866250b44059dde37b741c8051e', 'login.success', '151a2daa734f4f3baf8f7d829fb24fa0', 'Success...', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9792af8ffe0c4f5f8114d30079ff7099', 'sys.task.jobClass', 'fabee0495e6942359b2e40155654f935', '执行类', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('98531fb434d04bd29d6917eafd914eec', 'system.bottom', 'fabee0495e6942359b2e40155654f935', '置底', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('98952dff8aae4043b0c61b7cb8438a25', 'sys.field.indexAble', 'fabee0495e6942359b2e40155654f935', '建立索引', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('98dfb65bae804e569cc8870807bfd791', 'system.sms.password', 'fabee0495e6942359b2e40155654f935', '邮箱登入密码', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9933ed5a11ff4336a6a6c5270b4e5948', 'sys.unit.field3', 'fabee0495e6942359b2e40155654f935', '附加值三', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('99c249f82d564be0bd685612ff40f57b', 'sys.user.unitName.notEmpty', 'fabee0495e6942359b2e40155654f935', '用户单位不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('99f6efaec16245d295c9167cccf25984', 'index.user.mode', 'fabee0495e6942359b2e40155654f935', '加载方式', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9a5c75bef6da44cba07a2e90a16c3d02', 'sys.log.result', 'fabee0495e6942359b2e40155654f935', '执行结果', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9a8774077d224a05893e418d22503349', 'login.error.user', '151a2daa734f4f3baf8f7d829fb24fa0', 'Username Or Password Error', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9ab82c6580dc40409ef5d46d2640bc77', 'login.username', '151a2daa734f4f3baf8f7d829fb24fa0', 'Username', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9ae021ba5e164f8eaca92e0670562467', 'system.sms.name', 'fabee0495e6942359b2e40155654f935', '唯一KEY', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9b3811fdf01047c6a2ac55d306c66c20', 'sys.table.tooltip', 'fabee0495e6942359b2e40155654f935', '提示信息', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9c2738ccdfc54dc19e0d971b39895b09', 'sys.user.doPermissionsUser', 'fabee0495e6942359b2e40155654f935', '分配用户', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9c978ea233e14ab9830daab018a0e887', 'sys.menu.name', 'fabee0495e6942359b2e40155654f935', '菜单名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9d1e9203034f4132b7cbcbe3b8614b2f', 'sys.config.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9d25b5641a7546dd8a6496d47f764b0a', 'sys.unit.name.notEmpty', 'fabee0495e6942359b2e40155654f935', '单位名称不能为空', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9d5f4a654dff44be955ddbb135040cfc', 'sys.user.doPermissions', 'fabee0495e6942359b2e40155654f935', '分配权限', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9d6bd43cdeec452a996b7653aba6cc95', 'sys.task.cron.error', 'fabee0495e6942359b2e40155654f935', '定时规则不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9d8484a4d49f43f481dd5ac574f7dca1', 'index.user.oldPass', 'fabee0495e6942359b2e40155654f935', '原密码', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9dab9e4753b74ac68df1ab433e5a1d28', 'wf.category.name.notEmpty', 'fabee0495e6942359b2e40155654f935', '分类名称不能为空', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9ec5967a17b947dc9101c94e1686e920', 'system.web.loginValidationCode', 'fabee0495e6942359b2e40155654f935', '登录验证码显示', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9f25da020684483da500512f08d249c4', 'index.logout.title', '151a2daa734f4f3baf8f7d829fb24fa0', 'Quit System?', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9f4fe70b18354a96b71c198bf19ec5ec', 'system.ftp.password.notEmpty', 'fabee0495e6942359b2e40155654f935', '登录密码不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('9fbb600754494fc0b1cb786b606bf863', 'globals.button.detail', '151a2daa734f4f3baf8f7d829fb24fa0', 'Detail', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a1bdaf743be940d1803311c729327dd5', 'system.not.allow', '151a2daa734f4f3baf8f7d829fb24fa0', 'Do not allow', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a1caab0434db4158bc329fcb0134648c', 'globals.table.column.false', 'fabee0495e6942359b2e40155654f935', '否', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a20055f71b8548baae920882bfecc817', 'globals.button.enable', 'fabee0495e6942359b2e40155654f935', '启 用', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a273e6d85ef34c2d97838f2dbbe4d68a', 'index.user.password', '151a2daa734f4f3baf8f7d829fb24fa0', 'Password', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a2ab9ba96a34434ab3f2bbd11503fd3a', 'globals.button.back', 'fabee0495e6942359b2e40155654f935', '返 回', '', '2020-05-11 14:02:44', null, '0', '2020-05-11 16:19:42');
INSERT INTO `sys_lang_msg` VALUES ('a324413a0a5b41a9ba0e46f3cac1a722', 'sys.log.start.time', 'fabee0495e6942359b2e40155654f935', '开始时间', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a38de1b8b5ee4ece856ef11e202882d9', 'system.goback', 'fabee0495e6942359b2e40155654f935', '返回', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a3e9681fbf4c43659bc2cd5998d494a5', 'sys.dict.field3', 'fabee0495e6942359b2e40155654f935', '附加值三', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a48e79093c054ba9acd9dacd90b5aa4c', 'sys.verify.state.success', 'fabee0495e6942359b2e40155654f935', '发送成功', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a4d103f482f24887bfeafa6c609a52a7', 'index.mode.page', 'fabee0495e6942359b2e40155654f935', '传统加载方式', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a4e3ea856a164da2a508831c97b8239f', 'sys.api.appId', 'fabee0495e6942359b2e40155654f935', 'APP ID', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a5067edbfeaf4070b3983dcbc4d775c2', 'sys.route.toUrl', 'fabee0495e6942359b2e40155654f935', '跳转路径', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a59ee0faf28543aeb6f2d9157c9ec137', 'system.resetPassword', 'fabee0495e6942359b2e40155654f935', '重置密码', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a68bc6e09f6847c7b5cbeb1552e0ee25', 'sys.phone.emailName', 'fabee0495e6942359b2e40155654f935', '发送号码', '', '2020-08-25 17:03:16', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a68caa1ded3e40439548400696153080', 'sys.table.name.error', 'fabee0495e6942359b2e40155654f935', '表名称不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a70bfad8f8094a8e8c4a0a4bf647defc', 'system.ftp.timeout', 'fabee0495e6942359b2e40155654f935', '登录超时时间', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a72e3229bb894cf392a0f0127a28ac02', 'sys.menu.aliasName', 'fabee0495e6942359b2e40155654f935', '菜单别名', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a75b01c2968c4084bd4d67a89183a101', 'sys.menu.target.link', 'fabee0495e6942359b2e40155654f935', '普通链接', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a7ce91362f2f4090afb6ff21ea1d19eb', 'sys.dict.parentDict', 'fabee0495e6942359b2e40155654f935', '上级菜单', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a825e12b85584b1a8d576aa7801ec289', 'system.download', 'fabee0495e6942359b2e40155654f935', '下载', '', '2020-08-25 11:33:59', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a92c8f1247cb42238c9834d5fd04aeb0', 'sys.config', 'fabee0495e6942359b2e40155654f935', '系统参数配置', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('a98290850639448d8791c6cb627ff668', 'login.error.verifycode', '151a2daa734f4f3baf8f7d829fb24fa0', 'Verification code', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ab1f935b13b2484591229eebe5743008', 'sys.user.loginTime', 'fabee0495e6942359b2e40155654f935', '登陆时间', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('aba8c7daa6c64e3b9741aea10307acff', 'sys.attachment.fileSize', 'fabee0495e6942359b2e40155654f935', '文件大小', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('abd0b8abd2134d33adb95c6ef49c7385', 'sys.log.type.api', 'fabee0495e6942359b2e40155654f935', '接口日志', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ac3a080a5ee64c5e95dee529253c0ab2', 'system.add', 'fabee0495e6942359b2e40155654f935', '添加', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ad4b02859b914137a6350293cbaa61de', 'login.load', '151a2daa734f4f3baf8f7d829fb24fa0', 'Loading...', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ad634fe10abc48258cc8fc35dd42fecd', 'sys.unit.defaultTopUnit', 'fabee0495e6942359b2e40155654f935', '不选择默认为顶级单位', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('adff0eab460c476f9de663a374ec56a5', 'sys.unit.note', 'fabee0495e6942359b2e40155654f935', '单位介绍', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('af2bce040e5b4138a1cd788e81990d7f', 'sys.email.code', 'fabee0495e6942359b2e40155654f935', '邮件验证码管理', '', '2020-08-25 16:02:13', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('af366ba8156246e5b35e8f9e48673902', 'sys.role.doPermissionsUser', 'fabee0495e6942359b2e40155654f935', '分配用户', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('aff038da2d1f416491653478382801e0', 'sys.role.code.notEmpty', 'fabee0495e6942359b2e40155654f935', '角色编码不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b02c8e1db58e468f9a56089bf3329475', 'system.web.pwdValidation', 'fabee0495e6942359b2e40155654f935', '密码强度限制', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b02d0389873c40339cebf3f5247126bc', 'sys.dict.code', 'fabee0495e6942359b2e40155654f935', '字典编码', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b0f0099a5b104eed842a9834cc5574fa', 'sys.dict.code.exists', 'fabee0495e6942359b2e40155654f935', '字典编码已存在', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b127138e51064c00953a6032cfefc544', 'login.error.system', 'fabee0495e6942359b2e40155654f935', '系统错误', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b1650e03fe1e4afa8ef55f9caef889ab', 'globals.button.submit', 'fabee0495e6942359b2e40155654f935', '提 交', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b1b2f0923272455fad0aa281efe6d32f', 'system.endYear', 'fabee0495e6942359b2e40155654f935', '结束年', '', '2020-08-25 11:41:37', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b1d0b4091b604e4db2bdb942bf73774e', 'globals.button.cancel', '151a2daa734f4f3baf8f7d829fb24fa0', 'Cancel', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b2015dc2bf2f44ac9bdab98fd7d95c0a', 'sys.dict.sysCode', 'fabee0495e6942359b2e40155654f935', '系统编码', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b242247bd95140ce970c2175febcb250', 'login.error.captcha', 'fabee0495e6942359b2e40155654f935', '验证码错误', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b2d0feb2233f4434896349e125df0555', 'sys.unit.unitCode', 'fabee0495e6942359b2e40155654f935', '机构代码', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b4262820c0ec461f9093561a4556725f', 'sys.role.name.notEmpty', 'fabee0495e6942359b2e40155654f935', '角色名称不能为空', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b49603b57fcc4ba99f0382eb54ac01e2', 'sys.user.doBatchPermissions', 'fabee0495e6942359b2e40155654f935', '批量分配权限', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b54dfe3d1a2e4944b01c9f4b3c96e054', 'system.edit.category', 'fabee0495e6942359b2e40155654f935', '修改分类', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b577d95376e54c5a86fbdf18665909a4', 'index.custommenu', '151a2daa734f4f3baf8f7d829fb24fa0', 'Menu', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b5c9dbc578d84f3eac1b83d9c4edb6b3', 'sys.task.name', 'fabee0495e6942359b2e40155654f935', '任务名', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b74ecb6139084015b7e493179c8b29e7', 'system.sms.post', 'fabee0495e6942359b2e40155654f935', 'SMTP端口号', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b76f219e0ef04b3c8de22e2a0888f80f', 'system.table.select.error', 'fabee0495e6942359b2e40155654f935', '请选择要操作的数据', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b793fc6b1a1545c796f827056c51bc82', 'sys.log.tag', 'fabee0495e6942359b2e40155654f935', '日志标识', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b7a732f3646e497085549242448ff68e', 'sys.attachment.other', 'fabee0495e6942359b2e40155654f935', ' 其他', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b8758aa92d764e0490e7855b18010536', 'sys.email', 'fabee0495e6942359b2e40155654f935', '邮件消息管理', '', '2020-08-25 16:24:34', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b986263ef9964f0dac94da82cdfdafe1', 'system.web.unitName', 'fabee0495e6942359b2e40155654f935', '单位名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('b9f7af41d0da41de910a1ba2ae468f9d', 'system.ftp.username', 'fabee0495e6942359b2e40155654f935', '登录名', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bb3dee5ceda34387a21897ac8f9c4996', 'sys.route.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bba4cb7d391740128569b1d7e5372d5a', 'index.themes', '151a2daa734f4f3baf8f7d829fb24fa0', 'Themes', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bbb535587775483989ef68da3e1ca473', 'system.operation', 'fabee0495e6942359b2e40155654f935', '操作', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bbe91cdfbf2a43aaa82ef6bb5bf677dc', 'system.upTime', 'fabee0495e6942359b2e40155654f935', '更新时间', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bbf3117427c14b65bdbf5c0c0c78f56d', 'sys.attachment.image', 'fabee0495e6942359b2e40155654f935', ' 图片', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bc36609a187644ae8ada94dbabbf8203', 'system.cancel', 'fabee0495e6942359b2e40155654f935', '取 消', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bc3e22dcb88841e8901f9186bc5cc3dd', 'system.endMonth', 'fabee0495e6942359b2e40155654f935', '结束月份', '', '2020-08-25 11:41:39', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bc8cbdb72bc14c45b90ea949150e2786', 'sys.task.pause', 'fabee0495e6942359b2e40155654f935', '暂停', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bd503a7df6504382a619bfa9355d4b6f', 'sys.fieldProperty.name.notEmpty', 'fabee0495e6942359b2e40155654f935', '属性名称不能为空', '', '2020-08-19 09:37:56', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bd920ea5414d417ebfe7945aa2382081', 'sys.user.loginName.error', 'fabee0495e6942359b2e40155654f935', '用户名以字母开头6-20字,允许使用字母/数字/下划线', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('bfd9034448df474dbff1b24974ee0711', 'sys.user.loginSessionId', 'fabee0495e6942359b2e40155654f935', '登陆SessionId', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c00f726647094132afd3a0c16c354a38', 'sys.user.loginCount', 'fabee0495e6942359b2e40155654f935', '登陆次数', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c0428c0074eb4317aab3514cf32651da', 'sys.menu.href', 'fabee0495e6942359b2e40155654f935', 'URL地址', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c06f1293813d4271b40f8a53976adda5', 'system.note', 'fabee0495e6942359b2e40155654f935', '备注', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c0e865e291e34911b930b798871cb0d6', 'sys.email.state.fail', 'fabee0495e6942359b2e40155654f935', '失败', '', '2020-08-25 16:02:11', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c1239cb963824053823ac77d71215eb4', 'sys.lang', 'fabee0495e6942359b2e40155654f935', '多语言管理', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c13fe9ed73194f60a199d9ced467dc42', 'system.suspend', 'fabee0495e6942359b2e40155654f935', '挂起', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c190f78f65f44aed801e55a6a290803d', 'system.params.error', '151a2daa734f4f3baf8f7d829fb24fa0', 'Params Error', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c2a6c7f30a564e55974bafcd3fa5c2c5', 'sys.dbBackup.fileName', 'fabee0495e6942359b2e40155654f935', '文件名称', '', '2020-08-25 11:33:58', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c2c588f7dd2c4eee8c9e641430125d39', 'globals.file.choose', 'fabee0495e6942359b2e40155654f935', '选择文件', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c369e155241040bf822158c1871c461b', 'sys.email.subject', 'fabee0495e6942359b2e40155654f935', '邮件主题', '', '2020-08-25 16:24:33', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c538b2e87e5c4009a1a2d7213f6747cf', 'sys.menu.icon', 'fabee0495e6942359b2e40155654f935', '菜单图标', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c565759a9de7434eb78c8ffbde5a1609', 'sys.task.exeAt', 'fabee0495e6942359b2e40155654f935', '执行时间', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c5b4dd5a708c477b81fc9d9940872bb6', 'sys.email.content', 'fabee0495e6942359b2e40155654f935', '发送内容', '', '2020-08-25 16:02:11', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c631f81b81c6491bb005ad4874cb89c7', 'index.user.newPass', 'fabee0495e6942359b2e40155654f935', '新密码', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c688238dc8d54548b8d707f1ea342483', 'system.changePass.oldPass.noEq', 'fabee0495e6942359b2e40155654f935', '原密码输入错误', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c6eab691578f4a96997b065e40a7b58c', 'sys.log.type', 'fabee0495e6942359b2e40155654f935', '日志类型', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c7299b294ffe48b2ac25f0fe07f7eb1e', 'sys.dict.setTopmenu', 'fabee0495e6942359b2e40155654f935', '设为顶级单位', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c81c12c769c14ee2b3c5ecf5695e1e89', 'sys.attachment.video', 'fabee0495e6942359b2e40155654f935', ' 视屏', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c82cb3fffc9142dbaf74d12a96a5d230', 'sys.menu.type.source', 'fabee0495e6942359b2e40155654f935', '数据', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c851d72d04c3419280c082657133fc32', 'globals.file.not.exists', 'fabee0495e6942359b2e40155654f935', '文件不存在', '', '2020-08-26 17:47:24', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c87cd262c05247729b0ddc4a74465b2f', 'sys.email.htmlMsg', 'fabee0495e6942359b2e40155654f935', '消息内容', '', '2020-08-25 16:24:33', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c8b1bc150bc94f7d9db8fd689a282794', 'system.ftp.post', 'fabee0495e6942359b2e40155654f935', '端口号', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c92945a43d794a40b79f9c2389cf1fd0', 'system.web.theme', 'fabee0495e6942359b2e40155654f935', '系统默认主题', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('c98a2d8fc55a4ad7af6998dc0ad858b2', 'system.web.systemVersion', 'fabee0495e6942359b2e40155654f935', '系统版本号', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('caa067794be84237aa653be2ed474855', 'system.startYear', 'fabee0495e6942359b2e40155654f935', '开始年', '', '2020-08-25 11:41:37', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cabfc173a3714ec9b32fb1548d8179ac', 'login.success', 'fabee0495e6942359b2e40155654f935', '登录成功，正在跳转首页...', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cb0b516860354feb8e447f6f59a03a14', 'system.active', 'fabee0495e6942359b2e40155654f935', '激活', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cb367b5ed37640b7a58e76f691423def', 'sys.menu.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cb3b61c775cb48f9a738b06372cbd8a7', 'index.user.newPass.error', 'fabee0495e6942359b2e40155654f935', '新密码不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cb3c25471bb6415199d27457e7a41087', 'sys.dict.field2', 'fabee0495e6942359b2e40155654f935', '附加值二', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cb82893e40534113afb5321bb2d04426', 'sys.user.unitName.choose', 'fabee0495e6942359b2e40155654f935', '请选择用户所在单位', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cc7109bdf84c495f8857fba29aaae975', 'wf.category.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cc76fbe59c5c455fb783957f10510eb0', 'login.title', '151a2daa734f4f3baf8f7d829fb24fa0', 'System Login', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cd6617b9b69443db9e410aff2e3854f1', 'system.hint', 'fabee0495e6942359b2e40155654f935', '请输入内容', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cd9f78a1ca7d4d9e82c53a2d8c8de561', 'sys.menu.setTopmenu', 'fabee0495e6942359b2e40155654f935', '设为顶级单位', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cdd52ba7c50842b2b601ac9426fc2861', 'sys.role.name', 'fabee0495e6942359b2e40155654f935', '角色名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cdd8254a6aee42c78534d7316fadbc8e', 'system.error', 'fabee0495e6942359b2e40155654f935', '操作失败', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ce28775f6b534c1b8fc4ee356e69fd47', 'system.web.logo', 'fabee0495e6942359b2e40155654f935', '系统logo图片', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ce384f4f954345428af154e95ad4d7b9', 'sys.field.dataFieldDecimalLength', 'fabee0495e6942359b2e40155654f935', '小数位数', '', '2020-08-29 14:44:11', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ce82650ebeae4fc6b075bf79fac727f1', 'sys.role.doBatchPermissions', 'fabee0495e6942359b2e40155654f935', '批量分配权限', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ce97265f548b4d3ab79d37f102c80afb', 'sys.phone.errorMsg', 'fabee0495e6942359b2e40155654f935', '错误信息', '', '2020-08-25 17:03:16', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cea1043419d94af78335272c791a62b9', 'system.web.upload.fileSize', 'fabee0495e6942359b2e40155654f935', '最大文件上传', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cec42cab43a6464d8dedb19b4ffd0c21', 'sys.user.unitName', 'fabee0495e6942359b2e40155654f935', '用户单位', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cef66a5eabc244a684b2813f3abd61c3', 'login.error.user', 'fabee0495e6942359b2e40155654f935', '用户名或密码错误', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('cf385573116a4ef2ba7d2097d331f398', 'globals.button.add', '151a2daa734f4f3baf8f7d829fb24fa0', 'Add', '', '2020-05-11 14:02:42', null, '0', '2020-05-11 17:01:57');
INSERT INTO `sys_lang_msg` VALUES ('cfb212d97bb04b66956212b08f5140a9', 'login.error.locked', 'fabee0495e6942359b2e40155654f935', '帐号被锁定', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d0ec0b168eac47f486f9df59e791930a', 'sys.dict.sysDict', 'fabee0495e6942359b2e40155654f935', '系统字典', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d133ea93cbc1401a95bd9b850e4b9b50', 'login.foget', 'fabee0495e6942359b2e40155654f935', '忘记密码', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d1c70e7c1f1741c08a75e4f3fd5882c0', 'system.disabledState', 'fabee0495e6942359b2e40155654f935', '状态', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d1cbc97c836846e7980a2a68d9dd403c', 'sys.lang.key', 'fabee0495e6942359b2e40155654f935', 'KEY', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d1eb98b2da6c44f8acad794298b3018d', 'index.user.layout', 'fabee0495e6942359b2e40155654f935', '页面布局', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d22096f4b8b4474eb8823890140cb61e', 'wf.category.note', 'fabee0495e6942359b2e40155654f935', '备注', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d33b1357bc3c4e8989f995b336cf4b3c', 'system.select', 'fabee0495e6942359b2e40155654f935', '选 择', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d3ccadfa630b47d7959995a8b08816b2', 'sys.api.name', 'fabee0495e6942359b2e40155654f935', '应用名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d4c8f2189dc54c3e9658921c797e8f03', 'sys.user.doBatchPermissionsUser', 'fabee0495e6942359b2e40155654f935', '批量分配用户', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d623e1b8de334273ab5766427d32fd5e', 'index.layout', 'fabee0495e6942359b2e40155654f935', '布局', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d643908a521945c39f90c725aac3de6b', 'index.links', 'fabee0495e6942359b2e40155654f935', '友情链接', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d6c55cf0e125439e9c53dc12d5be6df7', 'sys.dbBackup.backupTime', 'fabee0495e6942359b2e40155654f935', '备份时间', '', '2020-08-25 11:33:58', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d7015de67a454d43808321ea56ccafbe', 'sys.email.state', 'fabee0495e6942359b2e40155654f935', '发送状态', '', '2020-08-25 16:02:12', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d762388e328c4b7e912c6c883e6c7de0', 'globals.table.column.operation', 'fabee0495e6942359b2e40155654f935', '操作', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d7f40700f2734e3f8c310f53a9728e0c', 'system.sms.host', 'fabee0495e6942359b2e40155654f935', 'SMTP服务器', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d86ce6b0d94a46deb452b68354e15b4a', 'globals.button.delete.notice', '151a2daa734f4f3baf8f7d829fb24fa0', 'Delete can not be restored, to determine delete?', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d8961d00fa9b4ac393ca63a0ef0bd7e4', 'sys.attachment.file', 'fabee0495e6942359b2e40155654f935', ' 文件', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('d8e95fc6e6c34f11a7f9446c60c4817d', 'system.location', 'fabee0495e6942359b2e40155654f935', '定 位', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('da7cc9991dff4259a3c7b88cc3af2b46', 'sys.unit.name', 'fabee0495e6942359b2e40155654f935', '单位名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('dab29bbb556441e08a4336bbdb05bf35', 'sys.verify.content', 'fabee0495e6942359b2e40155654f935', '发送内容', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('dae1e79790054ce98a05d000e388fcc7', 'sys.dict.error', 'fabee0495e6942359b2e40155654f935', '请选择要添加的节点', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('db09c49e097248d4825866cc74745d2a', 'index.themes', 'fabee0495e6942359b2e40155654f935', '皮肤', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('db7d7288ebc54bc2b87b5212d1dc8ddd', 'sys.log.start.end', 'fabee0495e6942359b2e40155654f935', '结束时间', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('dc209d42afa74b83aa73793e5a94afc7', 'globals.button.disable', 'fabee0495e6942359b2e40155654f935', '禁 用', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('dc74a77f625447bc9213337411a95112', 'sys.user.loginName.notEmpty', 'fabee0495e6942359b2e40155654f935', '用户名不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('dc7821f48363444fb867b7bd10df9ce9', 'system.web.initPwd', 'fabee0495e6942359b2e40155654f935', '初始登录强制修改密码', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('dd5fbc6e89a54f9daf37c441f8c54699', 'globals.button.detail', 'fabee0495e6942359b2e40155654f935', '查 看', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('de5e0cbf1d134f3b8c89fac000d5a271', 'sys.user.username.notEmpty', 'fabee0495e6942359b2e40155654f935', '姓名不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('dea5444c0c8a4e429534f2f66b63fc53', 'sys.fieldProperty.sysCode', 'fabee0495e6942359b2e40155654f935', '系统编码', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('df3eb88f44e44919b5a2717dd64ee520', 'sys.log.spendTime', 'fabee0495e6942359b2e40155654f935', '花费时间', '', '2020-08-25 17:41:46', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('df8835569f6641c588deeb305baecb8f', 'system.sys', 'fabee0495e6942359b2e40155654f935', '是否系统默认', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('df92d7706bbd4a6d84e5a575f924c80e', 'sys.user.username', 'fabee0495e6942359b2e40155654f935', '姓名', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e04fb7b28b5a40f69f14a71202b7c3e1', 'sys.config.configKey.notEmpty', 'fabee0495e6942359b2e40155654f935', '唯一KEY名称不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e0ba0e85bb724b78ab3ff33f7e5afc49', 'sys.database.databaseCode', 'fabee0495e6942359b2e40155654f935', '数据库编码', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e1604f860e4041858ebd80748376faa4', 'sys.verify.state.fail', 'fabee0495e6942359b2e40155654f935', '发送失败', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e1964772ef884ba89c0861d07a99758b', 'sys.menu.defaultTopRole', 'fabee0495e6942359b2e40155654f935', '不选择默认为顶级单位', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e1ae349b564840ce85e9d0d420c9471f', 'sys.menu.permission', 'fabee0495e6942359b2e40155654f935', '权限标识', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e2579a9826554f1fac8086361625d3d8', 'sys.verify.name', 'fabee0495e6942359b2e40155654f935', '文件名称', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e36ba30ab8a94783b9546cf61e36b2bd', 'sys.field.name.error', 'fabee0495e6942359b2e40155654f935', '字段名称不能为空', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e513542a516841918e9e23e623a88eb8', 'sys.table.physicalName', 'fabee0495e6942359b2e40155654f935', '表物理名称', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e58bfa3186ab4a7d919e4a803b690ce0', 'sys.log.type.platform', 'fabee0495e6942359b2e40155654f935', '平台日志', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e5b4c6528b12446797ced1b3d64782a4', 'index.user.oldPasnoEq', 'fabee0495e6942359b2e40155654f935', '原密码输入错误', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e622efbd9b3748298540bc98c56a5ba0', 'sys.role.doPermissions', 'fabee0495e6942359b2e40155654f935', '分配权限', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e6b43e141d6b4104a08dfdd442276580', 'login.rememberme', 'fabee0495e6942359b2e40155654f935', '记住', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e6cd181df190498bb57cae0db115d6ab', 'sys.phone.state', 'fabee0495e6942359b2e40155654f935', '发送状态', '', '2020-08-25 17:03:18', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e73998d505e64b9e92e1c1c9fb4caaf9', 'sys.unit.aliasName', 'fabee0495e6942359b2e40155654f935', '单位别名', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e75d3dd005b5491ba89b426cc3a1ac76', 'index.setting', '151a2daa734f4f3baf8f7d829fb24fa0', 'Settings', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e762475ac6a74e36ba57106a9c8f48e5', 'system.web.systemName', 'fabee0495e6942359b2e40155654f935', '首页标题', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e763f4caae454de6b1e8d80e589ecf25', 'sys.user.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e8867d451adb4a1591380e94a6b59a1f', 'index.notifications.title', 'fabee0495e6942359b2e40155654f935', '站内消息通知', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e91ba48b6ebd4c00bde8ce4bb7433c83', 'system.disabled.no', 'fabee0495e6942359b2e40155654f935', '否', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('e9484dd6fe09435eb5ee76abc6f0f456', 'sys.database.physicalName.error', 'fabee0495e6942359b2e40155654f935', '数据库简称不能为空', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ea4c3ca1513f4268a8c3706710de961e', 'system.param.empty', 'fabee0495e6942359b2e40155654f935', '参数为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ebe4555f7f0f49a6884804418fe87e18', 'sys.role.author', 'fabee0495e6942359b2e40155654f935', '授权', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ec3c95773cb54bb285b5a4c08e291b27', 'sys.role.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ec56eb4323544f358410daf289c2f151', 'sys.route.note', 'fabee0495e6942359b2e40155654f935', '备注', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ecef912a089541eb861c32779f769e18', 'sys.user.avatar', 'fabee0495e6942359b2e40155654f935', '头像', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ed6d78052ba34645a895e6e760de85ce', 'sys.dict.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('eda72ef84ca744989d3232f78d65be3d', 'sys.menu', 'fabee0495e6942359b2e40155654f935', '菜单管理', '', '2020-08-19 09:37:55', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('edfc010e6e1a4e0c82957b25de4fc0a6', 'index.user.newPass.error.length', 'fabee0495e6942359b2e40155654f935', '密码长度应为6~20位字符，必须以字母开头', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ee8044a2061a4686b8336a099bb07033', 'sys.field.name', 'fabee0495e6942359b2e40155654f935', '字段名称', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ef1fda1a973342f1840f1a5ae6781eef', 'sys.config.configValue', 'fabee0495e6942359b2e40155654f935', '值', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ef63c8ecbaf44d8694d4f40e09947e9d', 'sys.unit.add', '151a2daa734f4f3baf8f7d829fb24fa0', 'Add Unit', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f02501d9d26d4bb88d9abbda4e755bfc', 'sys.unit.field1', 'fabee0495e6942359b2e40155654f935', '附加值一', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f03523a9a5724fd981d33d69421997b0', 'sys.field.dataFieldProperty.error', 'fabee0495e6942359b2e40155654f935', '字段属性不能为空', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f087590f123644c388397d4107aba3fe', 'globals.button.edit', '151a2daa734f4f3baf8f7d829fb24fa0', 'Edit', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f1348cef215a41a59d563833cd4e8f5f', 'sys.user.userOnline', 'fabee0495e6942359b2e40155654f935', '是否在线', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f1b75b409b5842c28cccc05322fe5642', 'sys.route.type.show', 'fabee0495e6942359b2e40155654f935', '显性转发', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f1f42fed15384af18113473fd9e75e38', 'system.XML', 'fabee0495e6942359b2e40155654f935', 'XML', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f27dd1e357a04da1b7934091cc56d4c4', 'globals.button.edit', 'fabee0495e6942359b2e40155654f935', '编 辑', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f2efd4ab9fda4420b8fa06f28ca62468', 'sys.email.reSend', 'fabee0495e6942359b2e40155654f935', '是否重发', '', '2020-08-25 16:24:33', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f36076c886ef4fe68e01a349020b470c', 'sys.phone.content', 'fabee0495e6942359b2e40155654f935', '发送内容', '', '2020-08-25 17:03:18', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f37aeab6cfc9411da5a3a4a706b40eca', 'index.logout.title', 'fabee0495e6942359b2e40155654f935', '确定退出？', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f4747a48bff740cfa9533fde90438c91', 'system.web.upload.fileType', 'fabee0495e6942359b2e40155654f935', '上传文件类型', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f57a11021129478cb2e1cf471ba16c63', 'index.notifications.see', '151a2daa734f4f3baf8f7d829fb24fa0', 'See all notifications', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f5c4fe813e7e4c34a9bc55059ba51bae', 'sys.task.start', 'fabee0495e6942359b2e40155654f935', '启动', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f6b6ff378b72457cadf8ab3313cd3147', 'sys.table.note', 'fabee0495e6942359b2e40155654f935', '备注', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f735e8a0cdb840b68cf9793e199f71fe', 'sys.dict.topmenu', 'fabee0495e6942359b2e40155654f935', '顶级单位', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f80d71cbe1d64b968aa2e674f99f87f3', 'sys.menu.selectParentmenu', 'fabee0495e6942359b2e40155654f935', '选择上级单位', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f83f6e34a2214631864e54fc5e3b94e3', 'system.ok', 'fabee0495e6942359b2e40155654f935', '确 定', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f87288d974e04afdb16d222ed11b2be6', 'sys.task.disabled', 'fabee0495e6942359b2e40155654f935', '启用状态', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('f96ec3c631854bac88da1f6cd1db60bd', 'sys.task.exeResult', 'fabee0495e6942359b2e40155654f935', '执行结果', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('fa22c6c906a84b35aa21a556a3c49374', 'sys.user.password.notEmpty', 'fabee0495e6942359b2e40155654f935', '登陆密码不能为空', '', '2020-05-11 14:02:45', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('fae5cadb9a7440d887b1333b1869ed4c', 'sys.route.type.hide', 'fabee0495e6942359b2e40155654f935', '隐性转发', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('fb6c9bb2a49646489ac143357b179fc4', 'sys.dict.name', 'fabee0495e6942359b2e40155654f935', '字典名称', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('fc529836c313463b8582f40bfec9b5fe', 'system.error', '151a2daa734f4f3baf8f7d829fb24fa0', 'Fail', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('fc61791cac3a430b90bd028fb5823ec0', 'sys.user.doClearBatchPermissions', 'fabee0495e6942359b2e40155654f935', '批量清空权限', '', '2020-05-11 14:02:42', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('fd3ef54bd04f401985df658298d3ee2b', 'system.data.noExists', 'fabee0495e6942359b2e40155654f935', '数据不存在', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('fdb2ac9b665e4eb994c31749f101b500', 'system.view', 'fabee0495e6942359b2e40155654f935', '查看', '', '2020-05-11 14:02:44', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('fdf2fdcfbc284899ba9708062052d619', 'system.moveUp', 'fabee0495e6942359b2e40155654f935', '上移', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('fe2a523ee9cd44a381c6c399f816d143', 'sys.role.save.error', 'fabee0495e6942359b2e40155654f935', '角色名称和角色编码已存在', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('feaaff062f6a41e68b917d64e62980d9', 'sys.log.ip', 'fabee0495e6942359b2e40155654f935', '来源IP', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ff91ad3d7fed4a5181f9b3ef54b851a4', 'index.setting', 'fabee0495e6942359b2e40155654f935', '设置', '', '2020-05-11 14:02:43', null, '0', null);
INSERT INTO `sys_lang_msg` VALUES ('ffa5d19033e74d1f8e528022b4362cb0', 'index.user.layout', '151a2daa734f4f3baf8f7d829fb24fa0', 'Layout', '', '2020-05-11 14:02:42', null, '0', null);

-- ----------------------------
-- Table structure for sys_mail_body
-- ----------------------------
DROP TABLE IF EXISTS `sys_mail_body`;
CREATE TABLE `sys_mail_body` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `bizType` varchar(128) DEFAULT NULL COMMENT '业务类型-在业务中回查邮件信息',
  `bizuuid` varchar(128) DEFAULT NULL COMMENT '业务编号-在业务中回查邮件信息',
  `subject` varchar(128) NOT NULL COMMENT '主题',
  `htmlMsg` text NOT NULL COMMENT '消息内容',
  `toSend` varchar(2000) NOT NULL COMMENT '主送',
  `cc` varchar(2000) DEFAULT NULL COMMENT '抄送',
  `bcc` varchar(2000) DEFAULT NULL COMMENT '密送',
  `taskTime` timestamp NULL DEFAULT NULL COMMENT '定时发送时间-为null立即发送',
  `status` int(32) DEFAULT NULL COMMENT '发送状态0待发 1已发 -1失败',
  `reSend` tinyint(1) DEFAULT '1' COMMENT '是否可以重发',
  `maxSendNum` tinyint(4) DEFAULT NULL COMMENT '重新发送次数限制-最大不超过5次',
  `sendNum` int(32) DEFAULT '0' COMMENT '已发送次数',
  `errorMsg` text COMMENT '错误信息内容',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `lastSendTime` timestamp NULL DEFAULT NULL COMMENT '最后发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件信息表';

-- ----------------------------
-- Records of sys_mail_body
-- ----------------------------
INSERT INTO `sys_mail_body` VALUES ('1', '1', '1', '测试消息', '使用format指定输入框的格式；使用value-format指定绑定值的格式。\r\n\r\n默认情况下，组件接受并返回Date对象。以下为可用的格式化字串，以 UTC 2017年1月2日 03:04:05 为例：', '956607644@qq.com', '956607644@qq.com', '956607644@qq.com', '2020-08-27 16:35:28', '1', '0', '3', '1', null, '1', '2020-08-25 16:48:47', null, '0', null, null);
INSERT INTO `sys_mail_body` VALUES ('1370c4cdd31849be9fd8fcd13c47239f', null, null, '测试消息', '使用format指定输入框的格式；使用value-format指定绑定值的格式。\r\n\r\n默认情况下，组件接受并返回Date对象。以下为可用的格式化字串，以 UTC 2017年1月2日 03:04:05 为例：', '956607644@qq.com', '956607644@qq.com', '956607644@qq.com', '2020-08-27 16:35:28', '0', '1', '1', '0', null, '', '2020-08-25 16:50:43', null, '0', null, null);
INSERT INTO `sys_mail_body` VALUES ('cc389a9ea4cd43748290bdfbc835e65d', null, null, '测试消息', '使用format指定输入框的格式；使用value-format指定绑定值的格式。\r\n\r\n默认情况下，组件接受并返回Date对象。以下为可用的格式化字串，以 UTC 2017年1月2日 03:04:05 为例：', '956607644@qq.com', '956607644@qq.com', '956607644@qq.com', '2020-08-27 16:35:28', '0', '1', '1', '0', null, '', '2020-08-25 16:50:27', null, '0', null, null);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `aliasName` varchar(100) DEFAULT NULL COMMENT '菜单别名',
  `type` varchar(30) DEFAULT NULL COMMENT '资源类型',
  `href` varchar(255) DEFAULT NULL COMMENT '菜单链接',
  `target` varchar(50) DEFAULT NULL COMMENT '打开方式',
  `menuIcon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `note` varchar(255) DEFAULT NULL COMMENT '菜单介绍',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `sysState` tinyint(1) DEFAULT NULL COMMENT '是否是系统菜单节点',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_MENU_PATH` (`path`),
  UNIQUE KEY `INDEX_SYS_MENU_PERMISSION` (`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('0057deaf353640e8a64edbe973270c95', 'e69e348559764b6caf27a4ad4caeb424', '000200010001', '分类管理', 'Category', 'MENU', '/platform/wf/cfg/category', null, null, '0', 'wf.cfg.category', '分类管理', '0', '0', '150', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('005df79224f4454b93551cb10d034b00', '4d4a7a2a7012496cacf1cc5c79d47c16', '0001000400030001', '日志级别', 'App', 'MENU', '/platform/sys/apploglevel', null, 'fa-th-list', '0', 'sys.server.app.loglevel', '日志级别', '0', '0', '193', '', '2020-05-13 11:45:17', null, '0', null);
INSERT INTO `sys_menu` VALUES ('042cc4b4a3954213900eb99b6ed02634', '231847d15b1d436792d8afc294970ce3', '0001000200020002', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.msg.phoneCode.delete', '删除', '0', null, '227', '', '2020-08-25 17:03:23', null, '0', null);
INSERT INTO `sys_menu` VALUES ('0456ccd896f24968a68d0e77d99a0a5c', '88f9db53ac2c475d98e5e4e3abb30e85', '0001000100010001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.menu.update', '编辑', '0', '0', '18', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 16:20:46', null, '0', null);
INSERT INTO `sys_menu` VALUES ('046b3abfd8d942d89136a91e01a92bc4', '70d1f72f62ed49fab275ed0afcc9fac5', '0002000100050004', '删除', 'Delete', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.flow.delete', '删除', '0', '0', '179', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('066cd3d5e8954333b4a3de7a078326f6', 'bf2e7dbf35f24edc9a8b2323fd88c9e2', '0001000100040007', '置顶', 'Top', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.role.top', '置顶', '0', '0', '47', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('0a054c10158d461fbf8109e99e4ffee6', 'ca056c8bb33540daa4ec8ef6f280e015', '0001000200040002', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.msg.emailCode.delete', '删除', '0', null, '221', '', '2020-08-25 16:02:16', null, '0', null);
INSERT INTO `sys_menu` VALUES ('0aa42c8035234d95a9b47db94aa489ce', 'f3c98edcb94d4546801a1bd877fadee2', '0001000100100005', '清空权限', 'ClearMenu', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.user.clearMenu', '清空权限', '0', '0', '84', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('0b81f8440f824388baa6e36dcb5a7e8b', '4d4a7a2a7012496cacf1cc5c79d47c16', '0001000400030009', '添加配置文件', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.operation.app.save', '添加配置文件', '0', '0', '201', '', '2020-05-13 16:58:30', null, '0', null);
INSERT INTO `sys_menu` VALUES ('0ca58d4c150c4d2fa1b6412f381fc283', '4724934a62c944c797a913acef2a38a2', '000100050004', '用户管理', 'Log', 'MENU', '/platform/sys/log/info', null, null, '0', 'sys.log.info', '用户管理', '0', '0', '108', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('0d9962cce95c4cc5a1fca1407fe72789', '3ab2ecce4dfc492b9574fc9a51180e12', '000100020001', '短信消息', 'Sms', 'MENU', '/platform/sys/msg/sms/sms', null, null, '0', 'sys.msg.smsMsg', '短信消息', '0', '0', '11', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('0e956371e95b4544852f054a0548bb68', '4d4a7a2a7012496cacf1cc5c79d47c16', '0001000400030010', '修改配置文件', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.operation.app.edit', '修改配置文件', '0', '0', '202', '', '2020-05-13 16:58:30', null, '0', null);
INSERT INTO `sys_menu` VALUES ('0ea93f5ac5a94d88890a0dbddc3cb73d', '7e77f0da320542e09b4483ec339c5fee', '0001000100080012', '添加系统字段', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.systemField.save', '添加系统字段', '0', null, '234', '', '2020-08-28 11:59:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('10c5b5dba7ce40caa03d412ace4da3cf', '4d4a7a2a7012496cacf1cc5c79d47c16', '0001000400030004', '删除Jar', 'Delete', 'SOURCE', null, 'data-pjax', null, '0', 'sys.server.app.delete', '删除Jar', '0', '0', '196', '', '2020-05-13 15:10:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('1102c9a3d02d4527b81b19909a909fc1', 'a88a746f5b344def8d753c46862f9260', '000100030006', '接口密钥管理', 'Api', 'MENU', '/platform/sys/api', null, null, '0', 'sys.config.api', '接口密钥管理', '0', '0', '6', '', '2020-05-09 09:56:25', null, '0', null);
INSERT INTO `sys_menu` VALUES ('146662c8d4a74e6595081fa883640e6e', '17479fd332f04f9c843dfb1cfda1d03c', '0002000100020006', '删除', 'Delete', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.deploy.delete', '删除', '0', '0', '166', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('14def180a8bd45199f2d66abc51c1815', '44dcd59ad9454a529e2581a814f75e93', '000100010009', '系统参数', 'Config', 'MENU', '/platform/sys/config', null, null, '0', 'sys.manage.config', '系统参数', '0', '0', '73', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('1502883f1c16480781ba9b9de85d2139', 'bf2e7dbf35f24edc9a8b2323fd88c9e2', '0001000100040001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.role.update', '编辑', '0', '0', '41', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('151391c83f834f45baad35431237b0b0', 'f3c98edcb94d4546801a1bd877fadee2', '0001000100100003', '禁用', 'Disabled', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.user.disabled', '禁用', '0', '0', '82', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('158eef107c144a03a5d6f462b3e478b5', '79606e9ed3a64995b543432aecd186a7', '0002000300010004', '委托', 'Delegate', 'SOURCE', null, 'data-pjax', null, '0', 'wf.my.todo.delegate', '委托', '0', '0', '146', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('17479fd332f04f9c843dfb1cfda1d03c', 'e69e348559764b6caf27a4ad4caeb424', '000200010002', '流程部署', 'Deploy', 'MENU', '/platform/wf/cfg/deploy', null, null, '0', 'wf.cfg.deploy', '流程部署', '0', '0', '160', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('1933b53ebcbc4063a78e970836156ec5', 'cb1e6ad5333b48e49f69c0b0c1106c1c', '0001000300050001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.email.update', '编辑', '0', '0', '134', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('1972a977502744d886dfbe17f85b653d', '7e77f0da320542e09b4483ec339c5fee', '0001000100080014', '启用系统字段', 'Enable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.systemField.enable', '启用系统字段', '0', null, '236', '', '2020-08-28 14:48:00', null, '0', null);
INSERT INTO `sys_menu` VALUES ('1b4b3714c64d425cafd63f4194f7093c', '1102c9a3d02d4527b81b19909a909fc1', '0001000300060004', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.api.save', '新建', '0', '0', '184', '', '2020-05-09 09:56:25', null, '0', null);
INSERT INTO `sys_menu` VALUES ('1efb2c932fd0498aa77c3c9ab0c2ee39', '1102c9a3d02d4527b81b19909a909fc1', '0001000300060002', '启用', 'Enable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.api.enable', '启用', '0', '0', '182', '', '2020-05-09 09:56:25', null, '0', null);
INSERT INTO `sys_menu` VALUES ('22159cbc1c4a4b57a20001a96bf62bb9', '9e4d0aa085a54afbb53ee677c1dd2acf', '0001000100020007', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.unit.save', '新建', '0', '0', '34', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('2296dc3fd73e40e69184c68099a75885', '849c319e9d5b4e65b44c06e97bf288b1', '0001000100050001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.route.update', '编辑', '0', '0', '49', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('22d27e50ce0245ee997ae031477ff836', '0057deaf353640e8a64edbe973270c95', '0002000100010004', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.category.delete', '删除', '0', '0', '154', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('231847d15b1d436792d8afc294970ce3', '3ab2ecce4dfc492b9574fc9a51180e12', '000100020002', '手机验证码', 'Phone', 'MENU', '/platform/sys/msg/code/phone', null, null, '0', 'sys.msg.phoneCode', '手机验证码', '0', '0', '12', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('233b47077af742e5b32c6f9f19d4ac22', '4724934a62c944c797a913acef2a38a2', '000100050003', '平台日志', 'Log', 'MENU', '/platform/sys/log', null, null, '0', 'sys.log.platform', '平台日志', '0', '0', '107', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('23581a080dff43edb76f1caede3826e4', 'b358370791bc45e4b6ef08bbd10d7ff2', '000100040001', 'Redis缓存管理', 'Server', 'MENU', '/platform/sys/server/redis', null, null, '0', 'sys.server.redis', 'Redis缓存管理', '0', '0', '1', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('25018f04ba0f4d70b4f7fff561469889', 'e69e348559764b6caf27a4ad4caeb424', '000200010003', '流程定义', 'Model', 'MENU', '/platform/wf/cfg/model', null, null, '0', 'wf.cfg.model', '流程定义', '0', '0', '167', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('274d99fa35e24da584062dce74d6c8db', 'f3c98edcb94d4546801a1bd877fadee2', '0001000100100006', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.user.delete', '删除', '0', '0', '85', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('28e22d5b622145478794e287fd1bab07', 'aa53be39b73e45a9b76347aa766f40fa', '0001000100120003', '添加', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.fieldProperty.save', '添加', '0', '0', '104', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('2b6644b9e358480c92c4dca121b89488', '7e77f0da320542e09b4483ec339c5fee', '0001000100080005', '导入', 'Import', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.import', '导入', '0', '0', '204', '', '2020-08-20 16:49:51', null, '0', null);
INSERT INTO `sys_menu` VALUES ('2b75953e5a7f482daa6edaf3297c64c1', '14def180a8bd45199f2d66abc51c1815', '0001000100090005', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.config.save', '新建', '0', '0', '78', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('2c63d477dab749b498b82d4d549d6fc4', 'b358370791bc45e4b6ef08bbd10d7ff2', '000100040005', '数据库备份管理', 'Backup', 'MENU', '/platform/sys/server/backup', null, '', '0', 'sys.server.dbBackup', '数据库备份管理', '0', null, '0', '', '2020-08-25 11:34:02', null, '0', null);
INSERT INTO `sys_menu` VALUES ('2c946fed329340f199c374bae11cf3eb', 'aa53be39b73e45a9b76347aa766f40fa', '0001000100120001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.fieldProperty.update', '编辑', '0', '0', '102', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('2f2d0cb820a14f8db6c69f1f476d78dc', '7e77f0da320542e09b4483ec339c5fee', '0001000100080013', '禁用系统字段', 'Disabled', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.systemField.disabled', '禁用系统字段', '0', null, '235', '', '2020-08-28 14:48:00', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3037203ba5204bcd92378df45c3f70ac', '1102c9a3d02d4527b81b19909a909fc1', '0001000300060003', '删除', 'Delete', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.api.delete', '删除', '0', '0', '183', '', '2020-05-09 09:56:25', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3128671accaf49fda54aa376256e2b8d', 'a71020fa1cba49a3b5d11600dfdf2782', '0001000300070004', '新建', 'UpdateLangMsg', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.lang.updateLangMsg', '新建', '0', '0', '189', '', '2020-05-09 19:04:15', null, '0', null);
INSERT INTO `sys_menu` VALUES ('31794822421a4450a448facbf62b59c2', '44dcd59ad9454a529e2581a814f75e93', '000100010011', '字典管理', 'Dict', 'MENU', '/platform/sys/dict', null, null, '0', 'sys.manage.dict', '字典管理', '0', '0', '89', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3194477094a14a1b920a96b02123544b', '14def180a8bd45199f2d66abc51c1815', '0001000100090001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.config.update', '编辑', '0', '0', '74', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('33f2f8be9b774dd88d477833b04f3a0f', '939154087dfd4a618a1c0dff938fa8b7', '000200020001', '历史节点', 'History', 'MENU', '/platform/wf/history/node', null, null, '0', 'wf.history.node', '历史节点', '0', '0', '109', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('349e817322174010a022622f662e2170', '363f4923386c483f8c768e34be546af9', '0001000200050002', '重新发送', 'Send', 'SOURCE', null, 'data-pjax', null, '0', 'sys.msg.email.send', '重新发送', '0', null, '224', '', '2020-08-25 16:24:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('363f4923386c483f8c768e34be546af9', '3ab2ecce4dfc492b9574fc9a51180e12', '000100020005', '邮件消息', 'Email', 'MENU', '/platform/sys/msg/email', null, '', '0', 'sys.msg.email', '邮件消息', '0', null, '222', '', '2020-08-25 16:24:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('369684be4fd94d90bbe1d07486840052', '88f9db53ac2c475d98e5e4e3abb30e85', '0001000100010009', '置顶', 'Top', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.menu.top', '置顶', '0', '0', '26', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3701c7f0dbd94ff4a39ae5b52a253537', '363f4923386c483f8c768e34be546af9', '0001000200050003', '不重试', 'NoReSend', 'SOURCE', null, 'data-pjax', null, '0', 'sys.msg.email.noReSend', '不重试', '0', null, '225', '', '2020-08-25 16:32:57', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3ab2ecce4dfc492b9574fc9a51180e12', 'e731d143772143a0a21c2c18b8f228bf', '00010002', '消息中心', 'Message Center', 'MENU', null, null, 'fa-bell-o', '0', 'sys.msg', '消息中心', '1', '1', '3', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3aef682c5cad4122a2b83dd08063b991', '7e77f0da320542e09b4483ec339c5fee', '0001000100080001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.update', '编辑', '0', '0', '70', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3b40c12d07224a55b0a6ce2e0fe81d63', 'a71020fa1cba49a3b5d11600dfdf2782', '0001000300070006', '编辑语言', 'UpdateLang', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.lang.updateLang', '编辑语言', '0', '0', '191', '', '2020-05-11 11:29:29', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3e42886712df42e38ab03fd0cd75b0bc', 'e69e348559764b6caf27a4ad4caeb424', '000200010004', '流程任务', 'Task', 'MENU', '/platform/wf/cfg/task', null, null, '0', 'wf.cfg.task', '流程任务', '0', '0', '174', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3e732e8ea82c4f178a9f0e71d7da3d3c', 'a88a746f5b344def8d753c46862f9260', '000100030003', '短信配置', 'Sms', 'MENU', '/platform/sys/web/sms/', null, null, '0', 'sys.config.sms', '短信配置', '0', '0', '1', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3f22e0422c20484f9e9a8ce421a2a600', 'a88a746f5b344def8d753c46862f9260', '000100030008', 'IP地址过滤', 'Ip', 'MENU', '/platform/sys/web/ip', null, null, '0', 'sys.config.ip', 'IP地址过滤', '0', '0', '2', '', '2020-08-24 10:40:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('3fafde151fc146dea04d843b71353ae7', '9e4d0aa085a54afbb53ee677c1dd2acf', '0001000100020005', '上移', 'Up', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.unit.moveUp', '上移', '0', '0', '32', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('403a1586a7ca405e8d4ee652abd30c86', '25018f04ba0f4d70b4f7fff561469889', '0002000100030005', '删除', 'Delete', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.model.delete', '删除', '0', '0', '172', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('421b421d60994404936a44d2dafd577c', 'f3c98edcb94d4546801a1bd877fadee2', '0001000100100004', '启用', 'Enable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.user.enable', '启用', '0', '0', '83', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('43749a637ca6403093df0c5e7299c933', '0057deaf353640e8a64edbe973270c95', '0002000100010001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.category.update', '编辑', '0', '0', '151', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('43e3ff8f5b0e4d07b780aa4c508c5b56', '14def180a8bd45199f2d66abc51c1815', '0001000100090002', '编辑', 'Edit', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.config.edit', '编辑', '0', '0', '75', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4478ca36356846d6b822d5f961650b12', '231847d15b1d436792d8afc294970ce3', '0001000200020001', '重新发送', 'Send', 'SOURCE', null, 'data-pjax', null, '0', 'sys.msg.phoneCode.send', '重新发送', '0', '0', '13', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('448a7b3fd0984e7ab346cd92a98a50c3', 'bf2e7dbf35f24edc9a8b2323fd88c9e2', '0001000100040005', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.role.save', '新建', '0', '0', '45', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('44dcd59ad9454a529e2581a814f75e93', 'e731d143772143a0a21c2c18b8f228bf', '00010001', '系统管理', 'System', 'MENU', null, null, 'fa-sitemap', '0', 'sys.manage', '系统管理', '1', '1', '2', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4582b6c011fb47b3a9bb0c2f6496d1a9', '3e732e8ea82c4f178a9f0e71d7da3d3c', '0001000300030002', '禁用', 'Disabled', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.sms.disabled', '禁用', '0', '0', '127', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('460290f637844b9e983cf7eee39ff0a2', 'd4912bb4ddfe47458a081dbfb13c5485', '0001000100030001', '查看', 'View', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.attachment.view', '查看', '0', '0', '38', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('46d0f13a2fe446079ffc16923bcf4721', 'bf340d1919f74629a7f6eab6168339c5', '0001000300010005', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ftp.delete', '删除', '0', '0', '117', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4724934a62c944c797a913acef2a38a2', 'e731d143772143a0a21c2c18b8f228bf', '00010005', '日志管理', 'Log', 'MENU', null, null, 'fa-bookmark-o', '0', 'sys.log', '日志管理', '1', '1', '6', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4753d49d098a4eb18e445eb67d3402b8', '9e4d0aa085a54afbb53ee677c1dd2acf', '0001000100020004', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.unit.delete', '删除', '0', '0', '31', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4835150bf8d24647992441cce92ecef8', 'b911f6b48ef54fd6a20cebfd31a55e47', '000200030003', '已办任务', 'My', 'MENU', '/platform/wf/my/has', null, null, '0', 'wf.my.has', '已办任务', '0', '0', '149', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4853ff2f63684783825b4eea79997d6b', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070009', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.task.delete', '删除', '0', '0', '66', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('494f11f0c007437c9ec127722465ce3d', '88f9db53ac2c475d98e5e4e3abb30e85', '0001000100010003', '导入', 'Import', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.menu.import', '导入', '0', '0', '20', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('49bb75a05e614ff39dabf75536f2d8af', '698156adf4604e5da430003eaf0d65ef', '000100060001', '用户导入', 'User Import', 'MENU', '/platform/sys/data/user', 'data-pjax', null, '0', 'sys.data.maintenance.user', '用户导入', '0', null, '229', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-25 18:42:41', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4c68ac7e1b8b4f6399da835ad86ecae7', 'b358370791bc45e4b6ef08bbd10d7ff2', '000100040004', '服务监控', 'Monitor', 'MENU', '/platform/sys/server/monitor', '', '', '0', 'sys.server.monitor', '服务监控', '0', null, '2', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-25 15:01:57', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4d27379f6e024cb5a848c90185abcf8c', '4d4a7a2a7012496cacf1cc5c79d47c16', '0001000400030002', 'Jar包管理', 'Jar', 'SOURCE', null, 'data-pjax', null, '0', 'sys.server.app.jar', 'Jar包管理', '0', '0', '194', '', '2020-05-13 12:05:18', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4d4a7a2a7012496cacf1cc5c79d47c16', 'b358370791bc45e4b6ef08bbd10d7ff2', '000100040003', '应用管理', 'App', 'MENU', '/platform/sys/app', null, null, '0', 'sys.server.app', '应用管理', '1', '0', '3', '', '2020-05-13 09:39:16', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4d92a019044d4750ae4410507cbe8875', '31794822421a4450a448facbf62b59c2', '0001000100110011', '置顶', 'Top', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dict.top', '置顶', '0', '0', '100', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('4da54c667694427bad894c4f3e12a094', '0057deaf353640e8a64edbe973270c95', '0002000100010006', '添加', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.category.save', '添加', '0', '0', '156', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('504d49b2e9c347e0899fab09c946a067', '3f22e0422c20484f9e9a8ce421a2a600', '0001000300080004', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ip.delete', '删除', '0', '0', '214', '', '2020-08-24 10:40:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('5057cd56f7214bdb8c33d41635b370d0', '1102c9a3d02d4527b81b19909a909fc1', '0001000300060001', '禁用', 'Disable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.api.disable', '禁用', '0', '0', '181', '', '2020-05-09 09:56:25', null, '0', null);
INSERT INTO `sys_menu` VALUES ('508020af0d744092b798868f4a3b3c7f', '7e77f0da320542e09b4483ec339c5fee', '0001000100080009', '置顶', 'Top', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.top', '置顶', '0', '0', '208', '', '2020-08-20 16:49:51', null, '0', null);
INSERT INTO `sys_menu` VALUES ('50b2d1ac3ed2421f931c93766f16b7f0', 'f12c1661675b43bf97a154c70a845e8e', '0001000100060001', '保存', 'SaveRoleMenu', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.permission.roleMenu.save', '保存', '0', '0', '55', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('52f1bc1aba624d9dbe79d70d1985ea08', '88f9db53ac2c475d98e5e4e3abb30e85', '0001000100010004', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.menu.delete', '删除', '0', '0', '21', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('550afed43ef3402680181e33db2b2ead', 'a71020fa1cba49a3b5d11600dfdf2782', '0001000300070003', '新建', 'SaveLangMsg', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.lang.saveLangMsg', '新建', '0', '0', '188', '', '2020-05-09 19:04:15', null, '0', null);
INSERT INTO `sys_menu` VALUES ('5662abc556a14c84a0566aa3e224362e', '31794822421a4450a448facbf62b59c2', '0001000100110008', '下移', 'Down', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dict.moveDown', '下移', '0', '0', '97', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('57b001f272534c15adae567270393b94', '939154087dfd4a618a1c0dff938fa8b7', '000200020003', '历史实例', 'History', 'MENU', '/platform/wf/history/flow', null, null, '0', 'wf.history.flow', '历史实例', '0', '0', '111', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('5816efb0699045d687255902f28a132d', 'b911f6b48ef54fd6a20cebfd31a55e47', '000200030002', '发起任务', 'My', 'MENU', '/platform/wf/my/start', null, null, '0', 'wf.my.start', '发起任务', '0', '0', '148', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('59aa3b337b7a48e78af5903f2d87eb3d', '25018f04ba0f4d70b4f7fff561469889', '0002000100030004', '批量删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.model.deletes', '批量删除', '0', '0', '171', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('5b46c17bfade44f887c8389a81aca3ee', '70d1f72f62ed49fab275ed0afcc9fac5', '0002000100050002', '激活', 'Active', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.flow.active', '激活', '0', '0', '177', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('5e11a349eee14a8a8d157d1a0b76df2e', 'f3c98edcb94d4546801a1bd877fadee2', '0001000100100002', '分配权限', 'SaveMenu', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.user.saveMenu', '分配权限', '0', '0', '81', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('6202dc1d57ad4e8b8c135765832b94ce', '17479fd332f04f9c843dfb1cfda1d03c', '0002000100020005', '批量删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.deploy.batchDelete', '批量删除', '0', '0', '165', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('63b839ba24ac4d2893b790b4ab33c16a', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070008', '启用', 'Enable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.task.enable', '启用', '0', '0', '65', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('644ae8cc393946e4a69b8cde1cd333cc', '698156adf4604e5da430003eaf0d65ef', '000100060003', '数据查询', 'Data Query', 'MENU', '/platform/sys/data/query', 'data-pjax', null, '0', 'sys.data.maintenance.query', '数据查询', '0', null, '231', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-25 18:43:04', null, '0', null);
INSERT INTO `sys_menu` VALUES ('6551fe5a790d4da1a999082e75c95f2b', 'f3c98edcb94d4546801a1bd877fadee2', '0001000100100001', '编辑', 'Edit', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.user.update', '编辑', '0', '0', '80', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('66017eb110f94f7e9ec3070980601fe7', '3f22e0422c20484f9e9a8ce421a2a600', '0001000300080005', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ip.save', '新建', '0', '0', '215', '', '2020-08-24 10:40:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('68cc7c70e1be4fb7b31cc56e60dad8a9', '79606e9ed3a64995b543432aecd186a7', '0002000300010002', '签收', 'Claim', 'SOURCE', null, 'data-pjax', null, '0', 'wf.my.todo.claim', '签收', '0', '0', '144', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('68e99130f2a444a685de90ea73a7139e', '17479fd332f04f9c843dfb1cfda1d03c', '0002000100020002', '挂起', 'Suspend', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.deploy.suspend', '挂起', '0', '0', '162', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('698156adf4604e5da430003eaf0d65ef', 'e731d143772143a0a21c2c18b8f228bf', '00010006', '数据维护', 'Data Maintenance', 'MENU', null, 'data-pjax', 'fa-database', '0', 'sys.data.maintenance', '数据维护', '0', null, '228', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-25 18:20:09', null, '0', null);
INSERT INTO `sys_menu` VALUES ('6cddf710a69f4d33b5116a8ca5fb9b3e', '849c319e9d5b4e65b44c06e97bf288b1', '0001000100050002', '禁用', 'Disabled', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.route.disabled', '禁用', '0', '0', '50', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('6dc6fecfccd14380b9a40f8c0c63e880', '7e77f0da320542e09b4483ec339c5fee', '0001000100080003', '添加', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.save', '添加', '0', '0', '72', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('6e8cf4d472d34640b48ffa558d980454', '14def180a8bd45199f2d66abc51c1815', '0001000100090003', '删除', 'Delete', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.config.delete', '删除', '0', '0', '76', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('6eb2cc7962bf47e5b5af1fbc5b77e8ad', 'bf340d1919f74629a7f6eab6168339c5', '0001000300010003', '默认设置', 'System', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ftp.system', '默认设置', '0', '0', '115', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('6ef08abe45354a2389680689a415192e', '3e732e8ea82c4f178a9f0e71d7da3d3c', '0001000300030001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.sms.update', '编辑', '0', '0', '126', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('6fca154318e942219898369a0892a71e', 'a71020fa1cba49a3b5d11600dfdf2782', '0001000300070001', '删除', 'DeleteLang', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.lang.deleteLang', '删除', '0', '0', '186', '', '2020-05-09 19:04:15', null, '0', null);
INSERT INTO `sys_menu` VALUES ('7090475ade374500986ee365c4d20ddb', '7e77f0da320542e09b4483ec339c5fee', '0001000100080007', '下移', 'Down', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.moveDown', '下移', '0', '0', '206', '', '2020-08-20 16:49:51', null, '0', null);
INSERT INTO `sys_menu` VALUES ('70d190e8f07b493aaac5ab8a3ff50586', '88f9db53ac2c475d98e5e4e3abb30e85', '0001000100010006', '下移', 'Down', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.menu.moveDown', '下移', '0', '0', '23', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('70d1f72f62ed49fab275ed0afcc9fac5', 'e69e348559764b6caf27a4ad4caeb424', '000200010005', '流程实例', 'Flow', 'MENU', '/platform/wf/cfg/flow', null, null, '0', 'wf.cfg.flow', '流程实例', '0', '0', '175', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('73e545d8c6ab401c9a4666370082e101', '7e77f0da320542e09b4483ec339c5fee', '0001000100080010', '编辑系统字段', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.systemField.update', '编辑系统字段', '0', null, '232', '', '2020-08-28 11:59:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('7511dbea9ef74eee969a7c2e62e41484', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070004', '禁用', 'Disable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.task.disable', '禁用', '0', '0', '61', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('77a311c5ce8e48d1b1212be7274be5b7', '31794822421a4450a448facbf62b59c2', '0001000100110003', '导出', 'Export', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.role.export', '导出', '0', '0', '92', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('79374db6604d4c60ad10536b1129c657', '31794822421a4450a448facbf62b59c2', '0001000100110010', '置底', 'Bottom', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dict.bottom', '置底', '0', '0', '99', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('794277ccab30486e93c546c18f2a5d41', '31794822421a4450a448facbf62b59c2', '0001000100110007', '上移', 'Up', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dict.moveUp', '上移', '0', '0', '96', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('79606e9ed3a64995b543432aecd186a7', 'b911f6b48ef54fd6a20cebfd31a55e47', '000200030001', '待办任务', 'My', 'MENU', '/platform/wf/my/todo', null, null, '0', 'wf.my.todo', '待办任务', '0', '0', '142', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('79730bccc31549298e29afb5a8db1901', '0057deaf353640e8a64edbe973270c95', '0002000100010008', '置底', 'Bottom', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.category.bottom', '置底', '0', '0', '158', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('7e77f0da320542e09b4483ec339c5fee', '44dcd59ad9454a529e2581a814f75e93', '000100010008', '数据表管理', 'Table', 'MENU', '/platform/sys/table', null, null, '0', 'sys.manage.dataTable', '数据表管理', '0', '0', '69', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('7e9c00e63eb744b88492403aeb54cf7a', 'd4912bb4ddfe47458a081dbfb13c5485', '0001000100030002', '导出', 'Export', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.attachment.export', '导出', '0', '0', '39', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('7ebb8da5df694f1980ec8dbe17a219dd', '31794822421a4450a448facbf62b59c2', '0001000100110004', '导入', 'Import', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dict.import', '导入', '0', '0', '93', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('7f1ebe385e57444ab8f57af1d07ec2d1', '0057deaf353640e8a64edbe973270c95', '0002000100010003', '导入', 'Import', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.category.import', '导入', '0', '0', '153', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('7fc7189d29ed4fe0b8642be6929dda5b', '4d4a7a2a7012496cacf1cc5c79d47c16', '0001000400030003', '配置文件管理', 'Config', 'SOURCE', null, 'data-pjax', null, '0', 'sys.server.app.config', '配置文件管理', '0', '0', '195', '', '2020-05-13 12:05:18', null, '0', null);
INSERT INTO `sys_menu` VALUES ('8221fd487a90477a8d03f2cd4a099a74', '698156adf4604e5da430003eaf0d65ef', '000100060002', '数据导入', 'Data Import', 'MENU', '/platform/sys/data/data', 'data-pjax', null, '0', 'sys.data.maintenance.data', null, '0', null, '230', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-25 18:42:55', null, '0', null);
INSERT INTO `sys_menu` VALUES ('83e8be900f914713abcb9d3b7fb3a034', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070011', '暂停', 'PauseJob', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.task.pause', '暂停', '0', '0', '68', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('8404d9cf01d5421f85c18f7be48b000d', '7e77f0da320542e09b4483ec339c5fee', '0001000100080008', '置低', 'Bottom', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.bottom', '置低', '0', '0', '207', '', '2020-08-20 16:49:51', null, '0', null);
INSERT INTO `sys_menu` VALUES ('849c319e9d5b4e65b44c06e97bf288b1', '44dcd59ad9454a529e2581a814f75e93', '000100010005', '路由管理', 'Route', 'MENU', '/platform/sys/route', '', null, '0', 'sys.manage.route', '路由管理', '0', '0', '48', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 16:18:09', null, '0', null);
INSERT INTO `sys_menu` VALUES ('863d60f280eb4514a3bf693846fc1bd7', '7e77f0da320542e09b4483ec339c5fee', '0001000100080011', '删除系统字段', 'Delete', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.systemField.delete', '删除系统字段', '0', null, '233', '', '2020-08-28 11:59:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('868c9035420b4454b044e5252f19a5a2', '939154087dfd4a618a1c0dff938fa8b7', '000200020002', '历史任务', 'History', 'MENU', '/platform/wf/history/task', null, null, '0', 'wf.history.task', '历史任务', '0', '0', '110', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('86a2a66aa65649c596bc44b3889b6f76', 'f3c98edcb94d4546801a1bd877fadee2', '0001000100100008', '修改密码', 'UserdoChangePassword', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.user.changePassword', '修改密码', '0', '0', '87', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('873f201756a64850a691102e62e5e99c', 'f12c1661675b43bf97a154c70a845e8e', '0001000100060002', '删除', 'ClearRoleMenu', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.permission.roleMenu.delete', '删除', '0', '0', '56', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('88f9db53ac2c475d98e5e4e3abb30e85', '44dcd59ad9454a529e2581a814f75e93', '000100010001', '菜单管理', 'Menu', 'MENU', '/platform/sys/menu', 'data-pjax', null, '0', 'sys.manage.menu', '菜单管理', '0', '0', '17', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 16:15:51', null, '0', null);
INSERT INTO `sys_menu` VALUES ('8a06311753a1466bab1ddc9aeb2214ce', 'a71020fa1cba49a3b5d11600dfdf2782', '0001000300070002', '删除', 'DeleteLangMsg', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.lang.deleteLangMsg', '删除', '0', '0', '187', '', '2020-05-09 19:04:15', null, '0', null);
INSERT INTO `sys_menu` VALUES ('8b4b45eeb0ab474eb4d9e027122ce525', '9e4d0aa085a54afbb53ee677c1dd2acf', '0001000100020008', '置底', 'Bottom', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.unit.bottom', '置底', '0', '0', '35', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('8c0e6185f08b436ca61957885e501db8', '9e4d0aa085a54afbb53ee677c1dd2acf', '0001000100020009', '置顶', 'Top', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.unit.top', '置顶', '0', '0', '36', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 16:27:41', null, '0', null);
INSERT INTO `sys_menu` VALUES ('8cef8e8eb5f7404ba34657a4a44c1fa4', '3e732e8ea82c4f178a9f0e71d7da3d3c', '0001000300030006', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.sms.save', '新建', '0', '0', '131', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('8f75b7dfcaa34e96851090e2f2bfa4ab', '1102c9a3d02d4527b81b19909a909fc1', '0001000300060005', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.api.update', '编辑', '0', '0', '209', '', '2020-08-21 20:04:38', null, '0', null);
INSERT INTO `sys_menu` VALUES ('8f9d714aba29458caa4ef206abb3622d', '849c319e9d5b4e65b44c06e97bf288b1', '0001000100050005', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.route.save', '新建', '0', '0', '53', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('902c07dfbb42405e9a69b64e0c664ca2', '4d4a7a2a7012496cacf1cc5c79d47c16', '0001000400030008', '禁用配置文件', 'Disable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.operation.app.conf', '禁用配置文件', '0', '0', '200', '', '2020-05-13 16:58:30', null, '0', null);
INSERT INTO `sys_menu` VALUES ('939154087dfd4a618a1c0dff938fa8b7', 'af2f3e7ba33f4f7d84d640c0e90aae3d', '00020002', '流程历史', 'workFlow history', 'MENU', null, null, 'fa ti-settings', '0', 'wf.history', '流程历史', '1', '1', '9', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_menu` VALUES ('954ef36970584699b6913906db2f30cc', '849c319e9d5b4e65b44c06e97bf288b1', '0001000100050003', '启用', 'Enable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.route.enable', '启用', '0', '0', '51', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('980366e6695941e7bb44e560db65ac71', '9e4d0aa085a54afbb53ee677c1dd2acf', '0001000100020002', '导出', 'Export', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.unit.export', '导出', '0', '0', '29', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('98490a51f19344ffb6cac028771ab95e', 'bf2e7dbf35f24edc9a8b2323fd88c9e2', '0001000100040002', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.role.delete', '删除', '0', '0', '42', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('9870ebf2471a4722b746732519099510', '17479fd332f04f9c843dfb1cfda1d03c', '0002000100020003', '激活', 'Active', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.deploy.active', '激活', '0', '0', '163', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('999bf8061c6147e3af921928a6b7e255', '7e77f0da320542e09b4483ec339c5fee', '0001000100080004', '导出', 'Export', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.export', '导出', '0', '0', '203', '', '2020-08-20 16:49:51', null, '0', null);
INSERT INTO `sys_menu` VALUES ('9a4f456401c44318b9ced6655371f8fa', '88f9db53ac2c475d98e5e4e3abb30e85', '0001000100010005', '上移', 'Up', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.menu.moveUp', '上移', '0', '0', '22', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('9c4a4b9e0d224580925b639a80852f8f', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070007', '启动', 'StartJob', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.task.start', '启动', '0', '0', '64', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('9cb881645c64458085d5875cd9240506', 'cb1e6ad5333b48e49f69c0b0c1106c1c', '0001000300050004', '启用', 'Enable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.email.enable', '启用', '0', '0', '137', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('9ccdfa1649fc48a7aed5ecc1c7feabb4', '88f9db53ac2c475d98e5e4e3abb30e85', '0001000100010007', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.menu.save', '新建', '0', '0', '24', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('9e4d0aa085a54afbb53ee677c1dd2acf', '44dcd59ad9454a529e2581a814f75e93', '000100010002', '单位管理', 'Unit', 'MENU', '/platform/sys/unit', null, null, '0', 'sys.manage.unit', '单位管理', '0', '0', '27', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('9e7f91203e014818843d5e73b59fa25a', '4724934a62c944c797a913acef2a38a2', '000100050002', '接口日志', 'Log', 'MENU', '/platform/sys/log/api', null, null, '0', 'sys.log.api', '接口日志', '0', '0', '106', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('a1d7f22d9e19407498116db4b88df577', '25018f04ba0f4d70b4f7fff561469889', '0002000100030002', '导出', 'Export', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.model.export', '导出', '0', '0', '169', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('a2d8a292331143b6ac8301a1f938d6db', '79606e9ed3a64995b543432aecd186a7', '0002000300010001', '办理', 'Handle', 'SOURCE', null, 'data-pjax', null, '0', 'wf.my.todo.handle', '办理', '0', '0', '143', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('a494b251093e45d4b77ff42d2b9020f8', '2c63d477dab749b498b82d4d549d6fc4', '0001000400050003', '下载', 'Export', 'SOURCE', null, 'data-pjax', null, '0', 'sys.server.dbBackup.export', '下载', '0', null, '220', '', '2020-08-25 11:34:02', null, '0', null);
INSERT INTO `sys_menu` VALUES ('a5daa81dba1445459eeac3bde61a4c79', '7e77f0da320542e09b4483ec339c5fee', '0001000100080002', '删除', 'Delete', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.delete', '删除', '0', '0', '71', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('a60408336cb64ea6a0b05b328713bcb4', '363f4923386c483f8c768e34be546af9', '0001000200050001', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.msg.email.delete', '删除', '0', null, '223', '', '2020-08-25 16:24:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('a71020fa1cba49a3b5d11600dfdf2782', 'a88a746f5b344def8d753c46862f9260', '000100030007', '多语言配置', 'Lang', 'MENU', '/platform/sys/lang', null, null, '0', 'sys.config.lang', '多语言配置', '0', '0', '5', '', '2020-05-09 19:04:15', null, '0', null);
INSERT INTO `sys_menu` VALUES ('a7c78516ed094f3984597de61d7160e0', '2c63d477dab749b498b82d4d549d6fc4', '0001000400050002', '删除', 'Delete', 'SOURCE', null, 'data-pjax', null, '0', 'sys.server.dbBackup.delete', '删除', '0', null, '219', '', '2020-08-25 11:34:02', null, '0', null);
INSERT INTO `sys_menu` VALUES ('a88a746f5b344def8d753c46862f9260', 'e731d143772143a0a21c2c18b8f228bf', '00010003', '系统配置', 'System Config', 'MENU', null, null, 'fa-pencil-square-o', '0', 'sys.config', '系统配置', '1', '1', '4', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_menu` VALUES ('a9164ae862d8483a9f5ed1028471cbd1', 'bf340d1919f74629a7f6eab6168339c5', '0001000300010002', '禁用', 'Disabled', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ftp.disabled', '禁用', '0', '0', '114', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('aa53be39b73e45a9b76347aa766f40fa', '44dcd59ad9454a529e2581a814f75e93', '000100010012', '字段类型管理', 'FieldProperty', 'MENU', '/platform/sys/fieldProperty', null, null, '0', 'sys.manage.fieldProperty', '字段类型管理', '0', '0', '101', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('ab4f18601a93406e856afd85f9f94726', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070001', '编辑', 'Edit', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.task.edit', '编辑', '0', '0', '58', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('ac757f63bbbc4d949e823d77cb171915', '25018f04ba0f4d70b4f7fff561469889', '0002000100030001', '部署', 'Deploy', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.model.deploy', '部署', '0', '0', '168', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('af20cedca68741ce9a10042b76ed0307', '31794822421a4450a448facbf62b59c2', '0001000100110001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dict.update', '编辑', '0', '0', '90', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('af2f3e7ba33f4f7d84d640c0e90aae3d', null, '0002', '工作流', 'workFlow', 'MENU', null, null, 'el-icon-files', '0', 'wf', '工作流', '1', '1', '7', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_menu` VALUES ('b240ce31e9ad45648f6cc86585c7d01e', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070005', '历史记录', 'History', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.history', '历史记录', '0', '0', '62', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('b358370791bc45e4b6ef08bbd10d7ff2', 'e731d143772143a0a21c2c18b8f228bf', '00010004', '运维中心', 'Server Center', 'MENU', null, null, 'fa-shield', '0', 'sys.server', '运维中心', '1', '1', '5', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_menu` VALUES ('b63fc3bd347f4473bbd5906efc82a093', 'a71020fa1cba49a3b5d11600dfdf2782', '0001000300070005', '新建语言', 'SaveLang', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.lang.saveLang', '新建语言', '0', '0', '190', '', '2020-05-09 19:04:15', null, '0', null);
INSERT INTO `sys_menu` VALUES ('b79d814a0f2f468186e4f239cfa889e9', '31794822421a4450a448facbf62b59c2', '0001000100110005', '导入', 'Import', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.role.import', '导入', '0', '0', '94', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('b8882d66bd3749d49065202302218aaf', '9e4d0aa085a54afbb53ee677c1dd2acf', '0001000100020003', '导入', 'Import', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.unit.import', '导入', '0', '0', '30', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('b8c7816fb92d4806a4d4948fe7bdd855', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070003', '恢复', 'ResumJob', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.task.regain', '恢复', '0', '0', '60', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('b911f6b48ef54fd6a20cebfd31a55e47', 'af2f3e7ba33f4f7d84d640c0e90aae3d', '00020003', '我的流程', 'My workFlow', 'MENU', null, null, 'ti-settings', '0', 'wf.my', '我的流程', '1', '1', '10', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_menu` VALUES ('b98c4d23ba2440dbbca80ae5405095a9', '3f22e0422c20484f9e9a8ce421a2a600', '0001000300080003', '启用', 'Enable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ip.enable', '启用', '0', '0', '213', '', '2020-08-24 10:40:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('bb131dd364a046a4b98fa70e2d871df8', '31794822421a4450a448facbf62b59c2', '0001000100110006', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dict.delete', '删除', '0', '0', '95', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('bc3c4c0bebc2473fb0c8ceb1bc95579b', '44dcd59ad9454a529e2581a814f75e93', '000100010007', '任务管理', 'Task', 'MENU', '/platform/sys/task', null, null, '0', 'sys.manage.task', '任务管理', '0', '0', '57', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('bc5591cd266d4152841d7fe15cdba342', '70d1f72f62ed49fab275ed0afcc9fac5', '0002000100050001', '挂起', 'Suspend', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.flow.suspend', '挂起', '0', '0', '176', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('bc9cb17a4a4748b296be5b701ab64cb8', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070006', '立即执行', 'AtOnceJob', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.task.atOnceJob', '立即执行', '0', '0', '63', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('bea39b7291de46b78ce489149ce9c5af', 'ca056c8bb33540daa4ec8ef6f280e015', '0001000200040001', '重新发送', 'Send', 'SOURCE', null, 'data-pjax', null, '0', 'sys.msg.emailCode.send', '重新发送', '0', '0', '16', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('bf2e7dbf35f24edc9a8b2323fd88c9e2', '44dcd59ad9454a529e2581a814f75e93', '000100010004', '角色管理', 'Role', 'MENU', '/platform/sys/role', null, null, '0', 'sys.manage.role', '角色管理', '0', '0', '40', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('bf340d1919f74629a7f6eab6168339c5', 'a88a746f5b344def8d753c46862f9260', '000100030001', 'FTP服务器配置', 'Ftp', 'MENU', '/platform/sys/web/ftp/', null, null, '0', 'sys.config.ftp', 'FTP服务器配置', '0', '0', '0', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('bf52df9ab0ee4120a34122e4b33a2fa0', '17479fd332f04f9c843dfb1cfda1d03c', '0002000100020004', '流程图', 'Graph', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.deploy.graph', '流程图', '0', '0', '164', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('bfe2f5451fa545c98ea79a227c269097', '3e732e8ea82c4f178a9f0e71d7da3d3c', '0001000300030005', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.sms.delete', '删除', '0', '0', '130', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('c024a269b5b446bcab2431bc6a1208e1', '3e732e8ea82c4f178a9f0e71d7da3d3c', '0001000300030003', '默认设置', 'System', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.sms.system', '默认设置', '0', '0', '128', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('c030d83e7c094257a67624af0e910843', '363f4923386c483f8c768e34be546af9', '0001000200050004', '重试', 'ReSend', 'SOURCE', null, 'data-pjax', null, '0', 'sys.msg.email.reSend', '重试', '0', null, '226', '', '2020-08-25 16:32:57', null, '0', null);
INSERT INTO `sys_menu` VALUES ('c0f420d80f10403eb765f47b2202506e', 'bf2e7dbf35f24edc9a8b2323fd88c9e2', '0001000100040004', '下移', 'Down', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.role.moveDown', '下移', '0', '0', '44', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('c10d08dacd444cb3a467b4ce40535f78', '3f22e0422c20484f9e9a8ce421a2a600', '0001000300080001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ip.update', '编辑', '0', '0', '211', '', '2020-08-24 10:40:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('c7ee1c424472413997f51242e4eaa057', 'bf340d1919f74629a7f6eab6168339c5', '0001000300010004', '启用', 'Enable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ftp.enable', '启用', '0', '0', '116', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('c937fa8473b448b1b3f4695dab1909a4', 'aa53be39b73e45a9b76347aa766f40fa', '0001000100120002', '删除', 'Delete', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.fieldProperty.delete', '删除', '0', '0', '103', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('c9d0137b38864835a36cae2719cadf30', 'cb1e6ad5333b48e49f69c0b0c1106c1c', '0001000300050002', '禁用', 'Disabled', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.email.disabled', '禁用', '0', '0', '135', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('ca056c8bb33540daa4ec8ef6f280e015', '3ab2ecce4dfc492b9574fc9a51180e12', '000100020004', '邮件验证码', 'Email', 'MENU', '/platform/sys/msg/code/email', null, null, '0', 'sys.msg.emailCode', '邮件验证码', '0', '0', '15', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('cb1e6ad5333b48e49f69c0b0c1106c1c', 'a88a746f5b344def8d753c46862f9260', '000100030005', '邮件配置', 'Email', 'MENU', '/platform/sys/web/email/', null, null, '0', 'sys.config.email', '邮件配置', '0', '0', '4', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('cb64a51a20c0450980295677b41b2739', '4724934a62c944c797a913acef2a38a2', '000100050001', '登录日志', 'Log', 'MENU', '/platform/sys/log/login', null, null, '0', 'sys.log.login', '登录日志', '0', '0', '105', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('cc45febff0a042cabeedba06d0be01c3', '25018f04ba0f4d70b4f7fff561469889', '0002000100030003', '复制', 'DoCopy', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.model.copy', '复制', '0', '0', '170', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('d04bf067e0bd471f8cac7651794b2054', '9e4d0aa085a54afbb53ee677c1dd2acf', '0001000100020001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.unit.update', '编辑', '0', '0', '28', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('d09199b8ec8b4c5d8c2ae5ddad57cf3e', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070010', '添加', 'Add', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.task.save', '添加', '0', '0', '67', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('d10d1f1c1c504576bb5ba22b08213552', '31794822421a4450a448facbf62b59c2', '0001000100110002', '导出', 'Export', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dict.export', '导出', '0', '0', '91', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('d2c87373fcd344dcb8efbf2d7ea2bc2f', '849c319e9d5b4e65b44c06e97bf288b1', '0001000100050004', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.route.delete', '删除', '0', '0', '52', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('d3ba790c2dc54ea2905bee4b7ce4f04d', '25018f04ba0f4d70b4f7fff561469889', '0002000100030006', '添加', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.model.save', '添加', '0', '0', '173', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('d4912bb4ddfe47458a081dbfb13c5485', '44dcd59ad9454a529e2581a814f75e93', '000100010003', '附件管理', 'Attachment', 'MENU', '/platform/sys/attachment', null, null, '0', 'sys.manage.attachment', '附件管理', '0', '0', '37', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('d5bf8f27612242e0b6c4f2c037f4993e', '4d4a7a2a7012496cacf1cc5c79d47c16', '0001000400030006', '禁用Jar包', 'Disable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.server.app.disable', '禁用Jar包', '0', '0', '198', '', '2020-05-13 15:30:52', null, '0', null);
INSERT INTO `sys_menu` VALUES ('d5e546f8bc4a47f28dea8f8183dc94f0', '7e77f0da320542e09b4483ec339c5fee', '0001000100080006', '上移', 'Up', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dataTable.moveUp', '上移', '0', '0', '205', '', '2020-08-20 16:49:51', null, '0', null);
INSERT INTO `sys_menu` VALUES ('d92485cb13bf4427b5f7e4fbd49f175f', '9e4d0aa085a54afbb53ee677c1dd2acf', '0001000100020006', '下移', 'Down', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.unit.moveDown', '下移', '0', '0', '33', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('dcdae74ff20a42fe9223e08fe12d7029', '3e732e8ea82c4f178a9f0e71d7da3d3c', '0001000300030004', '启用', 'Enable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.sms.enable', '启用', '0', '0', '129', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('de4243fca91443efa2107e69a97491c6', '4d4a7a2a7012496cacf1cc5c79d47c16', '0001000400030007', '启用Jar包', 'Enable', 'SOURCE', null, 'data-pjax', null, '0', 'sys.server.app.enable', '启用Jar包', '0', '0', '199', '', '2020-05-13 15:30:52', null, '0', null);
INSERT INTO `sys_menu` VALUES ('df83ce5b4b5846a39aeeeb94137c265e', '14def180a8bd45199f2d66abc51c1815', '0001000100090004', '添加', 'Add', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.config.add', '添加', '0', '0', '77', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e13792162b704c8d98ad48e74ad13fc1', 'bf340d1919f74629a7f6eab6168339c5', '0001000300010001', '编辑', 'Update', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ftp.update', '编辑', '0', '0', '113', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e15621a8d6224e6488d750ba4046b0cb', '88f9db53ac2c475d98e5e4e3abb30e85', '0001000100010002', '导出', 'Export', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.menu.export', '导出', '0', '0', '19', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e3bdd53365ec4d088158145ef93e6d16', '2c63d477dab749b498b82d4d549d6fc4', '0001000400050001', '立即备份', 'Now', 'SOURCE', null, 'data-pjax', null, '0', 'sys.server.dbBackup.now', '立即备份', '0', null, '218', '', '2020-08-25 11:34:02', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e3f8728618864e3f9d6233a9b72e7de4', 'cb1e6ad5333b48e49f69c0b0c1106c1c', '0001000300050003', '默认设置', 'System', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.email.system', '默认设置', '0', '0', '136', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e3ff360840c4430ab3e52cb8c2c473cc', 'cb1e6ad5333b48e49f69c0b0c1106c1c', '0001000300050006', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.email.save', '新建', '0', '0', '139', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e43e09fd998f43849ad62fa44725e30e', '0057deaf353640e8a64edbe973270c95', '0002000100010009', '置顶', 'Top', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.category.top', '置顶', '0', '0', '159', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e4a453d18c08401b89499a611b700f22', 'bf340d1919f74629a7f6eab6168339c5', '0001000300010006', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ftp.save', '新建', '0', '0', '118', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e4e0185a688c4cd68da76ef9c8c75b6e', 'cb1e6ad5333b48e49f69c0b0c1106c1c', '0001000300050005', '删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.email.delete', '删除', '0', '0', '138', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e568b383231f4dafb0cc153329feb667', '0057deaf353640e8a64edbe973270c95', '0002000100010002', '导出', 'Export', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.category.export', '导出', '0', '0', '152', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e69e348559764b6caf27a4ad4caeb424', 'af2f3e7ba33f4f7d84d640c0e90aae3d', '00020001', '流程配置', 'workFlow Config', 'MENU', null, null, 'ti-settings', '0', 'wf.cfg', '流程配置', '1', '1', '8', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e731d143772143a0a21c2c18b8f228bf', null, '0001', '系统', 'System', 'MENU', null, null, 'el-icon-setting', '0', 'sys', '系统', '1', '1', '1', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e915607d2ccd45e4acb2a2633c24e25b', 'f3c98edcb94d4546801a1bd877fadee2', '0001000100100007', '添加', 'Add', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.user.save', '添加', '0', '0', '86', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e96c2cef97894cbdaad1933d9f1bfce8', '0057deaf353640e8a64edbe973270c95', '0002000100010005', '上移', 'Up', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.category.moveUp', '上移', '0', '0', '155', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('e9b2ee7fc113467e98783f3d49815546', 'f3c98edcb94d4546801a1bd877fadee2', '0001000100100009', '重置密码', 'ResetPassword', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.user.resetPassword', '重置密码', '0', '0', '88', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('eaab4b9a055743c1883ad284e1779ca9', 'bf2e7dbf35f24edc9a8b2323fd88c9e2', '0001000100040006', '置底', 'Bottom', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.role.bottom', '置底', '0', '0', '46', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('eb8687d38b2c4bd681f78e51dc276366', 'bf2e7dbf35f24edc9a8b2323fd88c9e2', '0001000100040003', '上移', 'Up', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.role.moveUp', '上移', '0', '0', '43', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('ed58b98cc0e449839001e709c10a4465', '79606e9ed3a64995b543432aecd186a7', '0002000300010005', '转派', 'Transfer', 'SOURCE', null, 'data-pjax', null, '0', 'wf.my.todo.transfer', '转派', '0', '0', '147', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('ed7cf05b8bae4abdb8500c9e8d2ae26b', '0057deaf353640e8a64edbe973270c95', '0002000100010007', '下移', 'Down', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.category.moveDown', '下移', '0', '0', '157', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('ee3a1eafdf0d4df69d2df27c92314150', '3f22e0422c20484f9e9a8ce421a2a600', '0001000300080002', '禁用', 'Disabled', 'SOURCE', null, 'data-pjax', null, '0', 'sys.config.ip.disabled', '禁用', '0', '0', '212', '', '2020-08-24 10:40:36', null, '0', null);
INSERT INTO `sys_menu` VALUES ('ee7fd2d533194b3688204780fea6bcb8', '88f9db53ac2c475d98e5e4e3abb30e85', '0001000100010008', '置底', 'Bottom', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.menu.bottom', '置底', '0', '0', '25', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('f12c1661675b43bf97a154c70a845e8e', '44dcd59ad9454a529e2581a814f75e93', '000100010006', '权限管理', 'Permission', 'MENU', '/platform/sys/permission', null, null, '0', 'sys.manage.permission', '权限管理', '0', '0', '54', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('f2edc2f8907241738b34671a95a01c8d', '70d1f72f62ed49fab275ed0afcc9fac5', '0002000100050003', '批量删除', 'Deletes', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.flow.batchDelete', '批量删除', '0', '0', '178', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('f34b734500c543c4a46ce701aa5de28f', 'bc3c4c0bebc2473fb0c8ceb1bc95579b', '0001000100070002', '表达式设置', 'Cron', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.task.cron', '表达式设置', '0', '0', '59', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('f3c98edcb94d4546801a1bd877fadee2', '44dcd59ad9454a529e2581a814f75e93', '000100010010', '用户管理', 'User', 'MENU', '/platform/sys/user', null, null, '0', 'sys.manage.user', '用户管理', '0', '0', '79', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('f56e135e5529468d96c3670dc52e25ca', '31794822421a4450a448facbf62b59c2', '0001000100110009', '新建', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.manage.dict.save', '新建', '0', '0', '98', '', '2020-05-08 19:03:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('f6d736a8430a45cb9d9f68be5cf01bc3', '4d4a7a2a7012496cacf1cc5c79d47c16', '0001000400030005', '添加Jar', 'Save', 'SOURCE', null, 'data-pjax', null, '0', 'sys.server.app.save', '添加Jar', '0', '0', '197', '', '2020-05-13 15:10:05', null, '0', null);
INSERT INTO `sys_menu` VALUES ('fa27892400124f3fbba46ad5e694bc70', '17479fd332f04f9c843dfb1cfda1d03c', '0002000100020001', 'XML下载', 'Xml', 'SOURCE', null, 'data-pjax', null, '0', 'wf.cfg.deploy.xml', 'XML下载', '0', '0', '161', '', '2020-05-08 19:03:06', null, '0', null);
INSERT INTO `sys_menu` VALUES ('fbddd2b70b6540f89359ceb78eec6570', '79606e9ed3a64995b543432aecd186a7', '0002000300010003', '取消签收', 'UnClaim', 'SOURCE', null, 'data-pjax', null, '0', 'wf.my.todo.unClaim', '取消签收', '0', '0', '145', '', '2020-05-08 19:03:06', null, '0', null);

-- ----------------------------
-- Table structure for sys_phone_verify_code
-- ----------------------------
DROP TABLE IF EXISTS `sys_phone_verify_code`;
CREATE TABLE `sys_phone_verify_code` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `code` varchar(128) DEFAULT NULL COMMENT '验证码',
  `content` varchar(512) DEFAULT NULL COMMENT '内容',
  `phoneName` varchar(128) DEFAULT NULL COMMENT '号码',
  `state` int(32) DEFAULT NULL COMMENT '状态',
  `errorMsg` varchar(128) DEFAULT NULL COMMENT '错误信息',
  `lastSendTime` timestamp NULL DEFAULT NULL COMMENT '最后发送时间',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统手机验证码';

-- ----------------------------
-- Records of sys_phone_verify_code
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `parentId` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `aliasName` varchar(50) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT NULL,
  `path` varchar(50) DEFAULT NULL,
  `unitId` varchar(32) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_ROLE_CODE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('0de9ede8d270430ab89c91e74354d365', null, '系统管理员', 'systemAdmin', 'system Admin', '0', '0002', null, 'System Admin', null, '0', '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_role` VALUES ('2b239a8946ab475f8bc02bc962c953f2', 'ab7336923ff44b25ac53c1361216ef2a', '测试角色', 'test role1', null, '0', '00010001', null, null, '1', '0', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 17:18:57', null, '0', null);
INSERT INTO `sys_role` VALUES ('ab7336923ff44b25ac53c1361216ef2a', null, '公共角色', 'public', 'Public Role', '0', '0001', null, 'All user has role', null, '1', '', '2020-05-08 18:58:54', null, '0', null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `menuId` varchar(32) DEFAULT NULL,
  `roleId` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('3ab2ecce4dfc492b9574fc9a51180e12', '0de9ede8d270430ab89c91e74354d365');
INSERT INTO `sys_role_menu` VALUES ('3ab2ecce4dfc492b9574fc9a51180e12', 'ab7336923ff44b25ac53c1361216ef2a');
INSERT INTO `sys_role_menu` VALUES ('44dcd59ad9454a529e2581a814f75e93', '0de9ede8d270430ab89c91e74354d365');
INSERT INTO `sys_role_menu` VALUES ('44dcd59ad9454a529e2581a814f75e93', 'ab7336923ff44b25ac53c1361216ef2a');
INSERT INTO `sys_role_menu` VALUES ('4724934a62c944c797a913acef2a38a2', '0de9ede8d270430ab89c91e74354d365');
INSERT INTO `sys_role_menu` VALUES ('4724934a62c944c797a913acef2a38a2', 'ab7336923ff44b25ac53c1361216ef2a');
INSERT INTO `sys_role_menu` VALUES ('939154087dfd4a618a1c0dff938fa8b7', '0de9ede8d270430ab89c91e74354d365');
INSERT INTO `sys_role_menu` VALUES ('939154087dfd4a618a1c0dff938fa8b7', 'ab7336923ff44b25ac53c1361216ef2a');
INSERT INTO `sys_role_menu` VALUES ('a88a746f5b344def8d753c46862f9260', '0de9ede8d270430ab89c91e74354d365');
INSERT INTO `sys_role_menu` VALUES ('a88a746f5b344def8d753c46862f9260', 'ab7336923ff44b25ac53c1361216ef2a');
INSERT INTO `sys_role_menu` VALUES ('af2f3e7ba33f4f7d84d640c0e90aae3d', '0de9ede8d270430ab89c91e74354d365');
INSERT INTO `sys_role_menu` VALUES ('af2f3e7ba33f4f7d84d640c0e90aae3d', 'ab7336923ff44b25ac53c1361216ef2a');
INSERT INTO `sys_role_menu` VALUES ('b358370791bc45e4b6ef08bbd10d7ff2', '0de9ede8d270430ab89c91e74354d365');
INSERT INTO `sys_role_menu` VALUES ('b358370791bc45e4b6ef08bbd10d7ff2', 'ab7336923ff44b25ac53c1361216ef2a');
INSERT INTO `sys_role_menu` VALUES ('b911f6b48ef54fd6a20cebfd31a55e47', '0de9ede8d270430ab89c91e74354d365');
INSERT INTO `sys_role_menu` VALUES ('b911f6b48ef54fd6a20cebfd31a55e47', 'ab7336923ff44b25ac53c1361216ef2a');
INSERT INTO `sys_role_menu` VALUES ('e69e348559764b6caf27a4ad4caeb424', '0de9ede8d270430ab89c91e74354d365');
INSERT INTO `sys_role_menu` VALUES ('e69e348559764b6caf27a4ad4caeb424', 'ab7336923ff44b25ac53c1361216ef2a');
INSERT INTO `sys_role_menu` VALUES ('e731d143772143a0a21c2c18b8f228bf', '0de9ede8d270430ab89c91e74354d365');
INSERT INTO `sys_role_menu` VALUES ('e731d143772143a0a21c2c18b8f228bf', 'ab7336923ff44b25ac53c1361216ef2a');

-- ----------------------------
-- Table structure for sys_route
-- ----------------------------
DROP TABLE IF EXISTS `sys_route`;
CREATE TABLE `sys_route` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `url` varchar(255) DEFAULT NULL COMMENT '原始路径',
  `toUrl` varchar(255) DEFAULT NULL COMMENT '跳转路径',
  `type` varchar(10) DEFAULT NULL COMMENT '转发类型',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统路由跳转表';

-- ----------------------------
-- Records of sys_route
-- ----------------------------
INSERT INTO `sys_route` VALUES ('624f113b076e4462af89eba0bfe53581', '55', '55', 'show', '3', '55879497445', '0', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-10 19:02:32', null, '0', '2020-08-10 19:17:32');
INSERT INTO `sys_route` VALUES ('71a23d2fdce449019ecf88d79ac54e01', '4567', '546747', 'hide', '2', '767', '0', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-10 18:56:41', '2020-08-10 18:56:49', '1', null);
INSERT INTO `sys_route` VALUES ('bba2ad6bc3c047dc8708d4e207c4ec7f', '/sysadmin', '/platform/login', 'hide', '1', '', '0', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-05-08 18:58:54', null, '0', '2020-08-10 19:17:35');

-- ----------------------------
-- Table structure for sys_sms_body
-- ----------------------------
DROP TABLE IF EXISTS `sys_sms_body`;
CREATE TABLE `sys_sms_body` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `status` int(32) DEFAULT '0' COMMENT '是否已经清理好数据 0没有 1已经清理好',
  `type` int(32) DEFAULT '0' COMMENT '是否已经清理好数据 0人工 1系统自动',
  `reSend` tinyint(1) DEFAULT NULL COMMENT '是否重发',
  `maxSendNum` int(32) DEFAULT NULL COMMENT '重新发送次数限制',
  `orderId` int(32) DEFAULT NULL COMMENT '订单号',
  `userIds` text COMMENT '接收者ID',
  `usersDesc` text COMMENT '接收者',
  `otherUsersDesc` text COMMENT '其他接收者',
  `otherUsersUnit` text COMMENT '其他接收者单位名称',
  `userId` varchar(128) DEFAULT NULL COMMENT '发送者',
  `userDesc` varchar(50) DEFAULT NULL COMMENT '发送者',
  `phones` text COMMENT '接收手机号',
  `otherPhones` text COMMENT '其他接收者接收手机号',
  `content` text COMMENT '短信内容',
  `sortUrl` varchar(50) DEFAULT NULL COMMENT '短地址',
  `taskTime` timestamp NULL DEFAULT NULL COMMENT '定时发送时间-为null立即发送',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信信息表';

-- ----------------------------
-- Records of sys_sms_body
-- ----------------------------

-- ----------------------------
-- Table structure for sys_sms_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_sms_config`;
CREATE TABLE `sys_sms_config` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `name` varchar(255) DEFAULT NULL COMMENT '唯一说明',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `systemState` tinyint(1) DEFAULT '0' COMMENT '是否是系统用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统短信配置表';

-- ----------------------------
-- Records of sys_sms_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_sms_msg_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_sms_msg_user`;
CREATE TABLE `sys_sms_msg_user` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `smsMsgId` varchar(32) DEFAULT NULL COMMENT '消息bodyID',
  `status` int(32) DEFAULT NULL COMMENT '是否发送成功 0待发送 1入对方库成功 2入对方库失败  3发送成功 4发送失败',
  `maxSendNum` int(32) DEFAULT NULL COMMENT '最大发送次数',
  `sendNum` int(32) DEFAULT NULL COMMENT '已发送次数',
  `orderId` bigint(64) DEFAULT NULL COMMENT '订单号',
  `userId` varchar(128) DEFAULT NULL COMMENT '内部接收人员',
  `userDesc` varchar(20) DEFAULT NULL COMMENT '接收人员',
  `phone` varchar(20) DEFAULT NULL COMMENT '接收手机号',
  `userUnit` varchar(100) DEFAULT NULL COMMENT '单位名称',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `content` text COMMENT '消息内容',
  `errorMsg` varchar(500) DEFAULT NULL COMMENT '错误消息',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统短信到人员';

-- ----------------------------
-- Records of sys_sms_msg_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_system_data_field
-- ----------------------------
DROP TABLE IF EXISTS `sys_system_data_field`;
CREATE TABLE `sys_system_data_field` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `physicalName` varchar(50) DEFAULT NULL COMMENT '物理名称',
  `enumId` varchar(32) DEFAULT NULL COMMENT '枚举值id',
  `dataFieldProperty` int(32) DEFAULT NULL COMMENT '字段属性：1=逻辑字段，2=物理字段',
  `identifying` tinyint(1) DEFAULT NULL COMMENT '标识规范',
  `useForCopy` tinyint(1) DEFAULT NULL COMMENT '是否用于复制',
  `dataFieldLength` int(32) DEFAULT NULL COMMENT '字段长度',
  `requiredDataField` tinyint(1) DEFAULT NULL COMMENT '字段是否必填',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '字段是否冻结',
  `tooltip` varchar(200) DEFAULT NULL COMMENT '提示信息',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `indexAble` tinyint(1) DEFAULT '0' COMMENT '是否建立索引',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `dataFieldTypeId` varchar(128) DEFAULT NULL COMMENT '字段类型ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统系统字段表';

-- ----------------------------
-- Records of sys_system_data_field
-- ----------------------------
INSERT INTO `sys_system_data_field` VALUES ('179c7c339afe4381b4cd30beed9d3789', '更新时间', 'ModificationTime', null, '2', '0', '0', '0', '0', '0', '更新时间', '更新时间', '0', '4', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-28 19:23:47', null, '0', null, 'bd463b3275c244ba8247d5bb8bd5e215');
INSERT INTO `sys_system_data_field` VALUES ('1d970b03fc4a4936a1f0e0b3e29b5f1e', '创建时间', 'CreationTime', null, '2', '0', '0', '0', '0', '0', '创建时间', '创建时间', '0', '3', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-28 19:23:21', null, '0', null, 'bd463b3275c244ba8247d5bb8bd5e215');
INSERT INTO `sys_system_data_field` VALUES ('68fbcc74627e4060a36bd5d9e72b13b9', '用户编号', 'UserId', null, '2', '0', '0', '32', '0', '0', '用户编号测试', '用户编号测试', '0', '0', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-28 20:13:48', null, '0', null, 'c5ec4be7e9d5477aa4c14f408259cd03');
INSERT INTO `sys_system_data_field` VALUES ('78595ae87e1849fcbe4c9f9835504c6e', '审核状态', 'Auditing', null, '2', '0', '0', '10', '0', '0', '审核状态', '审核状态', '0', '5', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-28 19:24:50', null, '0', null, '55c95954789a4f20ac3bb6663e22e110');
INSERT INTO `sys_system_data_field` VALUES ('79158a1ee76c4ae68e663b6b2b89ddb3', '单位编号', 'UnitId', null, '2', '0', '0', '32', '0', '0', '单位编号', '单位编号', '0', '1', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-28 19:22:13', null, '0', null, 'c5ec4be7e9d5477aa4c14f408259cd03');
INSERT INTO `sys_system_data_field` VALUES ('d0296626277f4f7198b393afb2244c4d', '记录排序', 'Sorting', null, '2', '0', '0', '11', '0', '0', '记录排序', '记录排序', '0', '2', '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-28 19:22:57', null, '0', null, 'e855653ca77644a585002821a1a1f7a1');

-- ----------------------------
-- Table structure for sys_task
-- ----------------------------
DROP TABLE IF EXISTS `sys_task`;
CREATE TABLE `sys_task` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `name` varchar(100) DEFAULT NULL COMMENT '任务名',
  `jobClass` varchar(255) DEFAULT NULL COMMENT '执行类',
  `note` varchar(255) DEFAULT NULL COMMENT '任务说明',
  `cron` varchar(50) DEFAULT NULL COMMENT '定时规则',
  `data` text COMMENT '执行参数',
  `exeAt` bigint(64) DEFAULT NULL COMMENT '执行时间',
  `exeResult` text COMMENT '执行结果',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `jobStatus` varchar(50) DEFAULT NULL COMMENT '任务状态',
  `jobType` int(32) DEFAULT NULL COMMENT '任务类型 （0随服务启动|1手动启动）',
  `jobGroup` varchar(128) DEFAULT NULL COMMENT '任务组',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统任务表';

-- ----------------------------
-- Records of sys_task
-- ----------------------------

-- ----------------------------
-- Table structure for sys_task_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_task_log`;
CREATE TABLE `sys_task_log` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `taskId` varchar(32) DEFAULT NULL COMMENT '任务ID',
  `exeAt` bigint(64) DEFAULT NULL COMMENT '执行时间',
  `exeState` varchar(30) DEFAULT NULL COMMENT '执行结果',
  `exeResult` text COMMENT '执行结果',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `consuming` varchar(128) DEFAULT NULL COMMENT '花费时长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统任务执行过程表';

-- ----------------------------
-- Records of sys_task_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_unit
-- ----------------------------
DROP TABLE IF EXISTS `sys_unit`;
CREATE TABLE `sys_unit` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `name` varchar(100) DEFAULT NULL COMMENT '单位名称',
  `aliasName` varchar(100) DEFAULT NULL COMMENT '单位别名',
  `unitCode` varchar(32) DEFAULT NULL COMMENT '机构编码',
  `note` varchar(255) DEFAULT NULL COMMENT '单位介绍',
  `field1` varchar(200) DEFAULT NULL COMMENT '附加值一',
  `field2` varchar(200) DEFAULT NULL COMMENT '附加值二',
  `field3` varchar(200) DEFAULT NULL COMMENT '附加值三',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '是否有子节点',
  `logo` varchar(255) DEFAULT NULL COMMENT '单位logo',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_UNIT_UNITCODE` (`unitCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统单位表';

-- ----------------------------
-- Records of sys_unit
-- ----------------------------
INSERT INTO `sys_unit` VALUES ('4b59ea0ec6004c8c8430b88a54a966b1', null, '系统单位', 'System Unit', '0000', null, null, null, null, '1', '0', '1', null, '', '2020-05-08 18:58:54', null, '0', null);
INSERT INTO `sys_unit` VALUES ('52a49a2373f844ad93c0b5d673c5c505', '4b59ea0ec6004c8c8430b88a54a966b1', '人事科', 'unit_1', '00000003', '人事科', null, null, null, '4', '0', '1', null, '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-21 14:58:43', null, '0', null);
INSERT INTO `sys_unit` VALUES ('b2c40f3479ff48889e01bfdaac5b72c9', '4b59ea0ec6004c8c8430b88a54a966b1', '测试1', 'test1', '00000001', null, null, null, null, '2', '0', '0', null, '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 16:59:08', null, '0', null);
INSERT INTO `sys_unit` VALUES ('e3be8d45ec8c4cd9b3b2426b1dae0fa6', '52a49a2373f844ad93c0b5d673c5c505', '科1', 'unit-1-1', '000000030001', '科1', null, null, null, '5', '0', '0', null, '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-21 14:59:01', null, '0', null);
INSERT INTO `sys_unit` VALUES ('fbe846a4b2cd480facf7305c63e0e5ae', '4b59ea0ec6004c8c8430b88a54a966b1', '测试2', 'test2', '00000002', null, null, null, null, '3', '0', '0', null, '1ba29d5c09d94dc9b81b674dcc3aa779', '2020-08-18 16:59:33', null, '0', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `loginName` varchar(120) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '密码盐',
  `username` varchar(100) DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `userOnline` tinyint(1) DEFAULT NULL COMMENT '是否在线',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(128) DEFAULT NULL COMMENT '手机号码',
  `note` varchar(500) DEFAULT NULL COMMENT '用户简介',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `loginTime` timestamp NULL DEFAULT NULL COMMENT '登陆时间',
  `loginIp` varchar(255) DEFAULT NULL COMMENT '登陆IP',
  `loginCount` int(32) DEFAULT NULL COMMENT '登陆次数',
  `loginSessionId` varchar(50) DEFAULT NULL COMMENT '登陆SessionId',
  `customMenu` varchar(255) DEFAULT NULL COMMENT '常用菜单',
  `loginTheme` varchar(100) DEFAULT NULL COMMENT '皮肤样式',
  `menuTheme` varchar(100) DEFAULT NULL COMMENT '菜单样式',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `loginSidebar` tinyint(1) DEFAULT NULL,
  `loginBoxed` tinyint(1) DEFAULT NULL,
  `loginScroll` tinyint(1) DEFAULT NULL,
  `loginPjax` tinyint(1) DEFAULT NULL,
  `unitId` varchar(32) DEFAULT NULL,
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_USER_LOGINNAMAE` (`loginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('099206e0853a4dd89427d210c94a85c4', 'test', '1bba9287ebc50b766bff84273d11ccefaa7a8da95d078960f05f116e9d970fb0', 'r5tdr01s7uglfokpsdmtu15602', '超级管理员', null, '0', '0', '956607644@qq.com', null, null, '2020-05-08 18:58:54', '2020-05-08 18:58:54', '127.0.0.1', '0', null, null, '956607644.3.css', null, null, '0', '0', '1', '1', '4b59ea0ec6004c8c8430b88a54a966b1', '', '2020-05-08 18:58:54', null, '0', '2020-08-24 18:18:33');
INSERT INTO `sys_user` VALUES ('1ba29d5c09d94dc9b81b674dcc3aa779', 'superadmin', '1bba9287ebc50b766bff84273d11ccefaa7a8da95d078960f05f116e9d970fb0', 'r5tdr01s7uglfokpsdmtu15602', '超级管理员', null, '1', '0', '956607644@qq.com', null, null, '2020-05-08 18:58:54', '2020-09-02 14:55:13', '127.0.0.1', '111', 'ps6o8lbg3qhvmo5r9m096rvmef', null, '956607644.3.css', null, null, '0', '0', '1', '1', '4b59ea0ec6004c8c8430b88a54a966b1', '', '2020-05-08 18:58:54', null, '0', '2020-08-24 18:18:31');

-- ----------------------------
-- Table structure for sys_user_import
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_import`;
CREATE TABLE `sys_user_import` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `name` varchar(128) DEFAULT NULL COMMENT '模板名称',
  `success` tinyint(1) DEFAULT '0' COMMENT '是否成功导入数据库',
  `step` int(32) DEFAULT '0' COMMENT '步骤数  0 -- 检查中 1 -- 检查通过  2 -- 导入中  3 -- 导入成功',
  `checkSuccess` tinyint(1) DEFAULT '0' COMMENT '数据检查能否通过',
  `state` varchar(128) DEFAULT NULL COMMENT '检查状态',
  `startTime` timestamp NULL DEFAULT NULL COMMENT '检查开始时间',
  `endTime` timestamp NULL DEFAULT NULL COMMENT '检查结束时间',
  `consume` int(32) DEFAULT NULL COMMENT '花费时间',
  `attachIDs` varchar(128) DEFAULT NULL COMMENT '检查数据的文件id',
  `errorMsg` text COMMENT '错误信息',
  `number` int(32) DEFAULT NULL COMMENT '数据条数',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `userId` varchar(128) DEFAULT NULL COMMENT '操作人员',
  `attachId` varchar(128) DEFAULT NULL COMMENT '检查数据的文件id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户导入表';

-- ----------------------------
-- Records of sys_user_import
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_import_error_msg
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_import_error_msg`;
CREATE TABLE `sys_user_import_error_msg` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `templateId` varchar(128) DEFAULT NULL COMMENT '模板Id',
  `rowNumber` int(32) DEFAULT NULL COMMENT '行号',
  `colNumber` int(32) DEFAULT NULL COMMENT '列号',
  `sheetName` varchar(128) DEFAULT NULL COMMENT '工作表名称',
  `errorMsg` varchar(500) DEFAULT NULL COMMENT '错误的消息',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户导入错误消息表';

-- ----------------------------
-- Records of sys_user_import_error_msg
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
  `menuId` varchar(32) DEFAULT NULL,
  `userId` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `roleId` varchar(32) DEFAULT NULL,
  `userId` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('0de9ede8d270430ab89c91e74354d365', '1ba29d5c09d94dc9b81b674dcc3aa779');
INSERT INTO `sys_user_role` VALUES ('0de9ede8d270430ab89c91e74354d365', '099206e0853a4dd89427d210c94a85c4');
INSERT INTO `sys_user_role` VALUES ('ab7336923ff44b25ac53c1361216ef2a', '1ba29d5c09d94dc9b81b674dcc3aa779');
INSERT INTO `sys_user_role` VALUES ('ab7336923ff44b25ac53c1361216ef2a', '099206e0853a4dd89427d210c94a85c4');

-- ----------------------------
-- Table structure for sys_user_unit
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_unit`;
CREATE TABLE `sys_user_unit` (
  `userId` varchar(32) DEFAULT NULL,
  `unitId` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_unit
-- ----------------------------

-- ----------------------------
-- Table structure for wf_category
-- ----------------------------
DROP TABLE IF EXISTS `wf_category`;
CREATE TABLE `wf_category` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `name` varchar(120) DEFAULT NULL COMMENT '分类名称',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `path` varchar(100) DEFAULT NULL COMMENT '路径',
  `disabled` tinyint(1) DEFAULT '0' COMMENT '是否禁用',
  `note` varchar(255) DEFAULT NULL COMMENT '分类介绍',
  `hasChildren` tinyint(1) DEFAULT '0' COMMENT '是否有子节点',
  `sort` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opTime` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `delTime` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `upTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_WF_CATEGORY_PATH` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程分类表';

-- ----------------------------
-- Records of wf_category
-- ----------------------------
