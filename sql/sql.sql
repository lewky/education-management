-- 创建数据库
CREATE DATABASE `course_selection`;

-- 使用数据库
USE `course_selection`;

-- 创建表
-- 权限表
DROP TABLE IF EXISTS `cs_authority`;

CREATE TABLE `cs_authority`(
  `id` bigint unsigned NOT NULL auto_increment COMMENT '权限ID',
  `name` varchar(30) NOT NULL COMMENT '权限名称',
  primary key (`id`)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 角色表/用户类型表
DROP TABLE IF EXISTS `cs_role`;

CREATE TABLE `cs_role`(
  `id` bigint unsigned NOT NULL auto_increment COMMENT '角色ID',
  `name` varchar(30) NOT NULL COMMENT '角色名称',
//  `state` tinyint DEFAULT '0' COMMENT '角色状态, 0:在读 1:退学' 2:休学 3:毕业 4:结业,
  primary key (`id`)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 角色权限表
DROP TABLE IF EXISTS `cs_role_authority`;

CREATE TABLE `cs_role_authority`(
  `id` bigint unsigned NOT NULL auto_increment COMMENT '用户权限ID',
  `role_id` varchar(30) NOT NULL COMMENT '角色/用户类型ID',
  `authority_id` varchar(30) NOT NULL COMMENT '权限ID',
  `state` tinyint DEFAULT '0' COMMENT '状态标识, 0:无权限 1:有权限',
  primary key (`id`),
  key `idx_role_id` (`role_id`),
  key `idx_authority_id` (`authority_id`),
  CONSTRAINT `fk_roleAuthority_role` FOREIGN KEY (`role_id`) REFERENCES `cs_role` (`id`),
  CONSTRAINT `fk_roleAuthority_authority` FOREIGN KEY (`authority_id`) REFERENCES `cs_authority` (`id`)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- 用户表
DROP TABLE IF EXISTS `cs_user`;

CREATE TABLE `cs_user` (
  `id` bigint unsigned NOT NULL auto_increment COMMENT '用户ID',
  `seq_id` bigint unsigned NOT NULL COMMENT '序号ID/学号/工号',
  `password` varchar(30) NOT NULL COMMENT '密码',
  `role_id` varchar(30) NOT NULL COMMENT '角色/用户类型ID',
  `state` tinyint DEFAULT '0' COMMENT '用户状态, 0:无效 1:正常',
  `role_state` tinyint DEFAULT '0' COMMENT '用户状态, 0:无效 1:正常',
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `icon` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `gender` tinyint NOT NULL COMMENT '性别, 1:男，2:女',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱地址',
  `telephone` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `in_date` date DEFAULT NULL COMMENT '入学时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` datetime DEFAULT NULL COMMENT '更新时间',
  `last_login` datetime DEFAULT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`id`),
  key `idx_seq_id` (`seq_id`),
  key `idx_role_id` (`role_id`),
  key `state` (`state`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `cs_role` (`id`),
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 学校表
DROP TABLE IF EXISTS `cs_school`;

CREATE TABLE `cs_school`(
  `id` bigint unsigned NOT NULL auto_increment COMMENT '学校ID',
  `name` varchar(30) NOT NULL COMMENT '学校名称',
  `president` varchar(30) DEFAULT NULL COMMENT '校长',
  `description` text DEFAULT NULL COMMENT '学校描述',
  primary key(`id`)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='学校表';

-- 院系表
DROP TABLE IF EXISTS `cs_dept`;

CREATE TABLE `cs_dept`(
  `id` bigint unsigned NOT NULL auto_increment COMMENT '院系ID',
  `name` varchar(30) NOT NULL COMMENT '院系名称',
  `school_id` bigint unsigned NOT NULL COMMENT '学校ID',
  `dean` varchar(30) DEFAULT NULL COMMENT '院长/系主任',
  `description` text DEFAULT NULL COMMENT '院系描述',
  `telephone` varchar(15) DEFAULT NULL COMMENT '联系方式',
  primary key(`id`),
  key `idx_schoolId` (`school_id`),
  CONSTRAINT `fk_dept_school` FOREIGN KEY (`school_id`) REFERENCES `cs_school` (`id`)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='院系表';

-- 专业表
DROP TABLE IF EXISTS `cs_major`;

CREATE TABLE `cs_major` (
  `id` bigint unsigned NOT NULL auto_increment '专业ID',
  `name` varchar(30) NOT NULL COMMENT '专业名称',
  `dept_id` bigint unsigned NOT NULL COMMENT '院系ID',
  `assistant` varchar(30) DEFAULT NULL COMMENT '辅导员',
  `telephone` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `description` text DEFAULT NULL COMMENT '专业介绍',
  PRIMARY KEY  (`id`),
  KEY `idx_major_dept` (`dept_id`),
  CONSTRAINT `idx_major_dept` FOREIGN KEY (`dept_id`) REFERENCES `cs_dept` (`id`)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='专业表';

