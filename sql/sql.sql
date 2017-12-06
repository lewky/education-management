-- 创建数据库
CREATE DATABASE `course_selection`;

-- 使用数据库
USE `course_selection`;

-- 创建表
-- 权限表
DROP TABLE IF EXISTS `cs_authority`;

CREATE TABLE `cs_authority`(
  `id` bigint NOT NULL auto_increment COMMENT '权限ID',
  `name` varchar(50) NOT NULL COMMENT '权限名称',
  primary key (`id`)
)ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 角色表/用户类型表
DROP TABLE IF EXISTS `cs_role`;

CREATE TABLE `cs_role`(
  `id` bigint NOT NULL auto_increment COMMENT '角色ID',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  primary key (`id`)
)ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 角色权限表
DROP TABLE IF EXISTS `cs_role_authority`;

CREATE TABLE `cs_role_authority`(
  `id` bigint NOT NULL auto_increment COMMENT '用户权限ID',
  `role` varchar(50) NOT NULL COMMENT '角色/用户类型',
  `authority` varchar(50) NOT NULL COMMENT '权限名称',
  primary key (`id`),
  key `idx_role` (`role`),
  key `idx_authority` (`authority`),
  CONSTRAINT `fk_roleAuthority_role` FOREIGN KEY (`role`) REFERENCES `cs_role` (`name`),
  CONSTRAINT `fk_roleAuthority_authority` FOREIGN KEY (`authority`) REFERENCES `cs_authority` (`name`)
)ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- 学校表
DROP TABLE IF EXISTS `cs_school`;

CREATE TABLE `cs_school`(
  `id` bigint NOT NULL auto_increment COMMENT '学校ID',
  `name` varchar(50) NOT NULL COMMENT '学校名称',
  `description` text COMMENT '学校描述',
  primary key(`id`)
)ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='学校表';

-- 院系表
DROP TABLE IF EXISTS `cs_dept`;

CREATE TABLE `cs_dept`(
  `id` bigint NOT NULL auto_increment COMMENT '院系ID',
  `name` varchar(50) NOT NULL COMMENT '院系名称',
  `school_id` bigint NOT NULL COMMENT '学校ID',
  `description` text COMMENT '院系描述',
  primary key(`id`),
  key `idx_schoolId`
  CONSTRAINT `fk_dept_school` FOREIGN KEY (`school_id`) REFERENCES `cs_school` (`id`)
)ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='院系表';