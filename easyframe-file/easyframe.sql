/*
Navicat MySQL Data Transfer

Source Server         : zc
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : easyframe

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2017-05-28 12:12:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_file
-- ----------------------------
DROP TABLE IF EXISTS `app_file`;
CREATE TABLE `app_file` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `file_name` varchar(255) default NULL COMMENT '文件名称',
  `file_size` double default NULL COMMENT '文件大小',
  `business_type` varchar(255) default NULL COMMENT '业务类型',
  `business_id` bigint(20) default NULL COMMENT '业务ID',
  `file_path` varchar(4000) default NULL COMMENT '文件路径',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件表';

-- ----------------------------
-- Records of app_file
-- ----------------------------

-- ----------------------------
-- Table structure for app_job
-- ----------------------------
DROP TABLE IF EXISTS `app_job`;
CREATE TABLE `app_job` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `job_name` varchar(255) default NULL COMMENT '任务名称',
  `job_group` varchar(255) default NULL COMMENT '任务组',
  `job_status` varchar(30) default NULL COMMENT '任务状态',
  `cron_expression` varchar(255) default NULL COMMENT '表达式',
  `trigger_class` varchar(500) default NULL COMMENT '触发类',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务表';

-- ----------------------------
-- Records of app_job
-- ----------------------------

-- ----------------------------
-- Table structure for app_lock
-- ----------------------------
DROP TABLE IF EXISTS `app_lock`;
CREATE TABLE `app_lock` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `type` varchar(32) default NULL COMMENT '类型',
  `value` varchar(255) default NULL COMMENT '值',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='锁';

-- ----------------------------
-- Records of app_lock
-- ----------------------------

-- ----------------------------
-- Table structure for app_message
-- ----------------------------
DROP TABLE IF EXISTS `app_message`;
CREATE TABLE `app_message` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `message_type` varchar(255) default NULL COMMENT '消息类型',
  `title` varchar(255) default NULL COMMENT '消息标题',
  `template_name` varchar(255) default NULL COMMENT '模板名称',
  `status` varchar(255) default NULL COMMENT '消息状态',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='发送信息（邮件）';

-- ----------------------------
-- Records of app_message
-- ----------------------------

-- ----------------------------
-- Table structure for app_message_receiver
-- ----------------------------
DROP TABLE IF EXISTS `app_message_receiver`;
CREATE TABLE `app_message_receiver` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `receiver_type` varchar(255) default NULL COMMENT '接收类型',
  `message_id` bigint(20) default NULL COMMENT '消息ID',
  `receiver` varchar(255) default NULL COMMENT '接收者',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='发送信息（邮件）接收者';

-- ----------------------------
-- Records of app_message_receiver
-- ----------------------------

-- ----------------------------
-- Table structure for app_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `app_oper_log`;
CREATE TABLE `app_oper_log` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `business_id` bigint(20) default NULL COMMENT '业务ID',
  `oper_type` varchar(32) default NULL COMMENT '操作类型',
  `params` varchar(4000) default NULL COMMENT '参数',
  `status` varchar(255) default NULL COMMENT '状态',
  `error_msg` varchar(4000) default NULL COMMENT '错误信息',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of app_oper_log
-- ----------------------------
INSERT INTO `app_oper_log` VALUES ('39', 'n', 'system', 'system', '2017-05-21 13:15:30', '2017-05-21 13:15:30', 'UserBoImpl.addUser', null, 'ADD_USER', '{\"creator\":\"system\",\"gmtCreate\":1495343730862,\"gmtModified\":1495343730862,\"id\":5,\"modifier\":\"system\",\"password\":\"testTransaction\",\"username\":\"testTransaction\"}', 'FAILURE', '/ by zero');
INSERT INTO `app_oper_log` VALUES ('40', 'n', 'system', 'system', '2017-05-28 12:09:53', '2017-05-28 12:09:53', 'UserBoImpl.queryAll', null, 'QUERY_ALL_USER', '', 'SUCCESS', null);

-- ----------------------------
-- Table structure for app_sequence_val
-- ----------------------------
DROP TABLE IF EXISTS `app_sequence_val`;
CREATE TABLE `app_sequence_val` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `curr_val` bigint(20) default NULL COMMENT '当前值',
  `sequence_name` varchar(255) default NULL COMMENT '序列名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='序列';

-- ----------------------------
-- Records of app_sequence_val
-- ----------------------------

-- ----------------------------
-- Table structure for base_table
-- ----------------------------
DROP TABLE IF EXISTS `base_table`;
CREATE TABLE `base_table` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '创建时间',
  `description` varchar(255) default NULL COMMENT '描述信息',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础表';

-- ----------------------------
-- Records of base_table
-- ----------------------------

-- ----------------------------
-- Table structure for zk_custom_value
-- ----------------------------
DROP TABLE IF EXISTS `zk_custom_value`;
CREATE TABLE `zk_custom_value` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  `description` varchar(255) default NULL COMMENT '描述时间',
  `value_zh` varchar(255) default '' COMMENT '值中文',
  `value_en` varchar(255) default NULL COMMENT '值英文',
  `type` varchar(255) default NULL COMMENT '类型',
  `code` varchar(32) default NULL COMMENT 'Code',
  `parent_code` varchar(32) default NULL COMMENT '父Code',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='统一值维护';

-- ----------------------------
-- Records of zk_custom_value
-- ----------------------------

-- ----------------------------
-- Table structure for zk_job_status
-- ----------------------------
DROP TABLE IF EXISTS `zk_job_status`;
CREATE TABLE `zk_job_status` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '创建时间',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `category` varchar(255) default NULL COMMENT '分类',
  `current_stage` varchar(255) default NULL COMMENT '当前阶段',
  `current_stage_num` int(11) default NULL COMMENT '当前阶段数',
  `total_stage_num` int(11) default NULL COMMENT '总阶段数',
  `current_dealed_num` int(11) default NULL COMMENT '当前处理数',
  `current_total_num` int(11) default NULL COMMENT '当前总数',
  `has_error` varchar(1) default NULL COMMENT '是否有错',
  `return_value` varchar(4000) default NULL COMMENT '返回值',
  `exception_class` varchar(500) default NULL COMMENT '异常类',
  `error_message` varchar(4000) default NULL COMMENT '异常信息',
  `exception_properties` varchar(255) default NULL COMMENT '异常属性',
  `finsh_date` timestamp NULL default NULL COMMENT '完成时间',
  `start_date` timestamp NULL default NULL COMMENT '开始时间',
  `status` varchar(20) default NULL COMMENT '状态',
  `job_uuid` varchar(100) default NULL COMMENT 'UUID',
  `exception_code_class` varchar(500) default NULL COMMENT '异常枚举类',
  `exception_code_enum_name` varchar(40) default NULL COMMENT '异常枚举名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='任务执行状态';

-- ----------------------------
-- Records of zk_job_status
-- ----------------------------
INSERT INTO `zk_job_status` VALUES ('45', 'n', 'system', 'system', '2017-05-21 13:17:02', '2017-05-21 13:17:02', null, 'TEST_JOB_EXECUTE_NAME', null, null, null, null, null, null, null, null, null, null, null, null, 'NEW', null, null, null);
INSERT INTO `zk_job_status` VALUES ('46', 'n', 'system', 'system', '2017-05-21 13:19:42', '2017-05-21 13:19:42', null, 'TEST_JOB_EXECUTE_NAME', null, null, null, null, null, null, null, null, null, null, null, null, 'NEW', null, null, null);
INSERT INTO `zk_job_status` VALUES ('47', 'n', 'system', 'system', '2017-05-21 13:27:33', '2017-05-21 13:27:33', null, 'TEST_JOB_EXECUTE_NAME', null, null, null, null, null, null, null, null, null, null, null, null, 'NEW', null, null, null);
INSERT INTO `zk_job_status` VALUES ('48', 'n', 'system', 'system', '2017-05-21 13:28:26', '2017-05-21 13:28:26', null, 'TEST_JOB_EXECUTE_NAME', null, null, null, null, null, null, null, null, null, null, null, null, 'NEW', null, null, null);
INSERT INTO `zk_job_status` VALUES ('49', 'n', 'system', 'system', '2017-05-21 16:11:31', '2017-05-21 16:11:31', null, 'TEST_JOB_EXECUTE_NAME', null, null, null, null, null, null, null, null, null, null, null, null, 'NEW', null, null, null);
INSERT INTO `zk_job_status` VALUES ('50', 'n', 'system', 'system', '2017-05-21 16:11:45', '2017-05-21 16:11:45', null, 'TEST_JOB_EXECUTE_NAME', null, null, null, null, null, null, null, null, null, null, null, null, 'NEW', null, null, null);
INSERT INTO `zk_job_status` VALUES ('51', 'n', 'system', 'system', '2017-05-21 18:50:36', '2017-05-21 18:50:36', null, 'TEST_JOB_EXECUTE_NAME', null, null, null, null, null, null, null, null, null, null, null, null, 'NEW', null, null, null);

-- ----------------------------
-- Table structure for zk_user
-- ----------------------------
DROP TABLE IF EXISTS `zk_user`;
CREATE TABLE `zk_user` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '主键',
  `is_deleted` varchar(1) NOT NULL default '' COMMENT '是否删除',
  `creator` varchar(32) NOT NULL COMMENT '创建者',
  `modifier` varchar(32) NOT NULL COMMENT '修改者',
  `gmt_create` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改者',
  `description` varchar(255) default NULL COMMENT '描述信息',
  `username` varchar(50) default NULL COMMENT '用户名',
  `password` varchar(50) default NULL COMMENT '密码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of zk_user
-- ----------------------------
