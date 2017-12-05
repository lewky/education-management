-- 创建数据库
CREATE DATABASE `course_selection`;

-- 使用数据库
USE `course_selection`;

-- 创建表
-- 权限表
DROP TABLE IF EXISTS `authority`;

CREATE TABLE `authority`(
  `id` bigint NOT NULL auto_increment COMMENT '权限ID',
  `name` varchar(50) NOT NULL COMMENT '权限名称',
  primary key (`id`)
)ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 用户类型表
DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type`(
  `id` bigint NOT NULL auto_increment COMMENT '用户类型ID',
  `name` varchar(50) NOT NULL COMMENT '用户类型名称',
  primary key (`id`)
)ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='用户类型表';

-- 用户权限表
DROP TABLE IF EXISTS `user_authority`;

CREATE TABLE `user_authority`(
  `id` bigint NOT NULL auto_increment COMMENT '用户权限ID',
  `name` varchar(50) NOT NULL COMMENT '用户权限名称',
  `user_type` varchar(50) NOT NULL COMMENT '用户类型',
  primary key (`id`),
  key `idx_user_type` (`user_type`),
  CONSTRAINT `fk_userAuthority_userType` FOREIGN KEY (`user_type`) REFERENCES `user_type` (`name`)
)ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='用户权限表';

-- 学校表
DROP TABLE IF EXISTS `school`;

CREATE TABLE `school`(
  `id` bigint NOT NULL auto_increment COMMENT '学校ID',
  `name` varchar(50) NOT NULL COMMENT '学校名称',
  primary key(`id`)
)ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='学校表';

-- 学校院系表
DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept`(
  `id` bigint NOT NULL auto_increment COMMENT '院系ID',
  `name` varchar(50) NOT NULL COMMENT '院系名称',
  `school_id` bigint NOT NULL COMMENT '学校ID',
  primary key(`id`),
  
)ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='学校院系表';