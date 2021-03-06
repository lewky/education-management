-- 创建数据库
CREATE DATABASE `educational_administration`;

-- 使用数据库
USE `educational_administration`;

-- 创建表(每个表都有一个不包含业务逻辑的主键ID)
-- 权限表
DROP TABLE IF EXISTS `ea_authority`;

CREATE TABLE `ea_authority`(
  `id` bigint unsigned NOT NULL COMMENT '主键ID',
  `name` varchar(30) NOT NULL COMMENT '权限名称',
  `code` varchar(100) NOT NULL COMMENT '权限编码:ea.{entity}.{action}',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 角色表/用户类型表
DROP TABLE IF EXISTS `ea_role`;

CREATE TABLE `ea_role`(
  `id` bigint unsigned NOT NULL COMMENT '主键ID',
  `name` varchar(30) NOT NULL COMMENT '角色名称',
  `is_valid` tinyint DEFAULT '0' COMMENT '角色是否有效, 0:无效 1:有效',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 角色权限表
DROP TABLE IF EXISTS `ea_role_authority`;

CREATE TABLE `ea_role_authority`(
  `id` bigint unsigned NOT NULL COMMENT '主键ID',
  `role_id` varchar(30) NOT NULL COMMENT '角色/用户类型ID',
  `authority_id` varchar(30) NOT NULL COMMENT '权限ID',
  `is_valid` tinyint DEFAULT '0' COMMENT '状态标识, 0:无权限 1:有权限',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  primary key (`id`),
  CONSTRAINT `fk_roleAuthority_role` FOREIGN KEY (`role_id`) REFERENCES `ea_role` (`id`),
  CONSTRAINT `fk_roleAuthority_authority` FOREIGN KEY (`authority_id`) REFERENCES `ea_authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- 用户表
DROP TABLE IF EXISTS `ea_user`;

CREATE TABLE `ea_user` (
  `id` bigint unsigned NOT NULL COMMENT '主键ID',
  `login_id` bigint unsigned NOT NULL COMMENT '登陆ID/学生学号/教师工号/管理员工号--(由代码逻辑生成:角色类型+入学/职时间)',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `password_salt` varchar(100) NOT NULL COMMENT '密码盐值',
  `role_id` varchar(30) NOT NULL COMMENT '角色/用户类型ID',
  `is_valid` tinyint DEFAULT '0' COMMENT '用户状态, 0:无效 1:正常',
  `state` tinyint DEFAULT '0' COMMENT '角色状态,不同角色的状态不同;学生-0:在读 1:退学 2:休学 3:毕业 4:结业 5:读研 6:留学;教师-0:在职 1:离职 2:休假 3:研修;管理员-0:在职 1:辞职 2:休假',
  `first_name` varchar(30) NOT NULL COMMENT '名字',
  `last_name` varchar(30) NOT NULL COMMENT '姓氏',
  `avator` varchar(100) DEFAULT NULL COMMENT '用户头像',
  `gender` tinyint NOT NULL COMMENT '性别, 1:男，2:女',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱地址',
  `telephone` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `teacher_title` varchar(30) DEFAULT NULL COMMENT '教师职称:教师才有职称，其他角色为NULL',
  `in_date` date NOT NULL COMMENT '入学时间/入职时间',
  `in_grade` varchar(30) DEFAULT NULL COMMENT '入学年级：大一/大二/研一等，用户为学生时不应为null',
  `out_date` date DEFAULT NULL COMMENT '毕业时间/离职时间',
  `last_login` TIMESTAMP DEFAULT NULL COMMENT '上次登录时间',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  PRIMARY KEY (`id`),
  key `idx_login_id` (`login_id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `ea_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 学校表
DROP TABLE IF EXISTS `ea_school`;

CREATE TABLE `ea_school`(
  `id` bigint unsigned NOT NULL COMMENT '主键ID',
  `school_no` bigint unsigned NOT NULL auto_increment COMMENT'学校编号',
  `name` varchar(30) NOT NULL COMMENT '学校名称',
  `president_name` varchar(30) DEFAULT NULL COMMENT '校长',
  `president_id` bigint unsigned DEFAULT NULL COMMENT '校长ID',
  `description` text DEFAULT NULL COMMENT '学校描述',
  `place` varchar(120) DEFAULT NULL COMMENT '学校地址',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  primary key(`id`),
  key `idx_school_no` (`school_no`),
  CONSTRAINT `fk_school_user` FOREIGN KEY (`president_id`) REFERENCES `ea_user` (`login_id`)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='学校表';

-- 院系表
DROP TABLE IF EXISTS `ea_dept`;

CREATE TABLE `ea_dept`(
  `id` bigint unsigned NOT NULL COMMENT '主键ID',
  `dept_no` bigint unsigned NOT NULL auto_increment COMMENT'院系编号',
  `name` varchar(30) NOT NULL COMMENT '院系名称',
  `school_name` varchar(30) NOT NULL COMMENT '学校名称',
  `school_id` bigint unsigned NOT NULL COMMENT '学校ID',
  `dean` varchar(30) DEFAULT NULL COMMENT '院长/系主任',
  `dean_id` bigint unsigned DEFAULT NULL COMMENT '院长/系主任ID',
  `description` text DEFAULT NULL COMMENT '院系描述',
  `place` varchar(120) DEFAULT NULL COMMENT '院系办公室地址',
  `telephone` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  primary key(`id`),
  key `idx_dept_no` (`dept_no`),
  CONSTRAINT `fk_dept_school` FOREIGN KEY (`school_id`) REFERENCES `ea_school` (`id`),
  CONSTRAINT `fk_dept_user` FOREIGN KEY (`dean_id`) REFERENCES `ea_user` (`login_id`)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='院系表';

-- 专业表
DROP TABLE IF EXISTS `ea_major`;

CREATE TABLE `ea_major` (
  `id` bigint unsigned NOT NULL COMMENT '主键ID',
  `major_no` bigint unsigned NOT NULL auto_increment COMMENT'专业编号',
  `name` varchar(30) NOT NULL COMMENT '专业名称',
  `dept_name` varchar(30) NOT NULL COMMENT '院系名称',
  `dept_id` bigint unsigned NOT NULL COMMENT '院系ID',
  `assistant` varchar(30) DEFAULT NULL COMMENT '辅导员',
  `assistant_id` bigint unsigned DEFAULT NULL COMMENT '辅导员ID',
  `telephone` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `description` text DEFAULT NULL COMMENT '专业介绍',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  PRIMARY KEY  (`id`),
  key `idx_major_no` (`major_no`),
  CONSTRAINT `idx_major_dept` FOREIGN KEY (`dept_id`) REFERENCES `ea_dept` (`id`),
  CONSTRAINT `fk_major_user` FOREIGN KEY (`assistant_id`) REFERENCES `ea_user` (`login_id`)
) ENGINE=InnoDB auto_increment=1000 DEFAULT CHARSET=utf8 COMMENT='专业表';

-- 班级表
DROP TABLE IF EXISTS `ea_class`;

CREATE TABLE `ea_class` (
  `id` bigint unsigned NOT NULL COMMENT '主键ID',
  `num` int unsigned NOT NULL COMMENT '班号',
  `class_no` bigint unsigned NOT NULL UNIQUE COMMENT '班级编号--(由代码逻辑生成:专业编号+年级编号+班号)',
  `grade` int unsigned NOT NULL COMMENT '年级:YYYY',
  `major_name` varchar(30) NOT NULL COMMENT '专业名称',
  `major_id` bigint unsigned NOT NULL COMMENT '专业ID',
  `class_adviser` varchar(30) NOT NULL COMMENT '班主任',
  `adviser_id` bigint unsigned NOT NULL COMMENT '班主任ID',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  PRIMARY KEY  (`id`),
  key `idx_class_no` (`class_no`),
  CONSTRAINT `idx_class_major` FOREIGN KEY (`major_id`) REFERENCES `ea_major` (`id`),
  CONSTRAINT `idx_class_user` FOREIGN KEY (`adviser_id`) REFERENCES `ea_user` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级表';

-- 班级学生表
DROP TABLE IF EXISTS `ea_class_student`;

CREATE TABLE `ea_class_student` (
  `id` bigint unsigned NOT NULL COMMEMT '主键ID',
  `class_id` bigint unsigned NOT NULL COMMENT '班级ID',
  `student_id` bigint unsigned NOT NULL COMMENT '学生ID',
  `student_name` varchar(30) NOT NULL COMMENT '学生姓名',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  PRIMARY KEY  (`id`),
  CONSTRAINT `idx_class_student_class` FOREIGN KEY (`class_id`) REFERENCES `ea_class` (`id`),
  CONSTRAINT `idx_class_student_user` FOREIGN KEY (`student_id`) REFERENCES `ea_user` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级学生表';

-- 课程表
DROP TABLE IF EXISTS `ea_course`;

CREATE TABLE `ea_course` (
  `id` bigint unsigned NOT NULL COMMEMT '主键ID',
  `name` varchar(30) NOT NULL COMMENT '课程名称',
  `teacher_name` varchar(30) NOT NULL COMMENT '教师名称',
  `teacher_id` bigint unsigned NOT NULL COMMENT '教师ID',
  `school_year` smallint unsigned NOT NULL COMMENT '学年:YYYY',
  `semester` tinyint NOT NULL COMMENT '学期:1,2,3',
  `period` float unsigned NOT NULL COMMENT '学时',
  `credit` float unsigned NOT NULL COMMENT '学分',
  `major_name` varchar(30) NOT NULL COMMENT '专业名称',
  `major_id` bigint unsigned NOT NULL COMMENT '专业ID',
  `time` varchar(150) DEFAULT NULL COMMENT '上课时间:{第XX周周XX第XX节,第XX周周XX第XX节,...}',
  `place` varchar(30) DEFAULT NULL COMMENT '上课地点',
  `description` text DEFAULT NULL COMMENT '课程介绍',
  `codelist_book_code` varchar(30) NOT NULL COMMENT 'codelist代码',
  `codelist_book_name` varchar(30) NOT NULL COMMENT 'codelist名字(COURSE_TYPE)',
  `course_type_code` varchar(30) NOT NULL COMMENT '课程类型代码',
  `course_type_name` varchar(30) NOT NULL COMMENT '课程类型名字:社会科学...',
  `is_minor` tinyint DEFAULT '0' COMMENT '是否是选修课, 0:必修课 1:选修课',
  `is_validated` tinyint DEFAULT '0' COMMENT '是否已经审核, 0:未审核 1:已审核',
  `is_arranged` tinyint DEFAULT '0' COMMENT '是否已经排课, 0:未排课 1:已排课',
  `selected_num` smallint unsigned DEFAULT '0' COMMENT '选课人数',
  `max_num` smallint unsigned DEFAULT '200' COMMENT '选课人数上限',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  PRIMARY KEY  (`id`),
  CONSTRAINT `idx_course_major` FOREIGN KEY (`major_id`) REFERENCES `ea_major` (`id`),
  CONSTRAINT `idx_course_user` FOREIGN KEY (`teacher_id`) REFERENCES `ea_user` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

-- 学生选课表
DROP TABLE IF EXISTS `ea_student_course`;

CREATE TABLE `ea_student_course` (
  `id` bigint unsigned NOT NULL COMMEMT '主键ID',
  `course_id` bigint unsigned NOT NULL COMMENT '课程ID',
  `course_name` varchar(30) NOT NULL COMMENT '课程名称',
  `student_id` bigint unsigned NOT NULL COMMENT '学生ID',
  `student_name` varchar(30) NOT NULL COMMENT '学生姓名',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  PRIMARY KEY  (`id`),
  CONSTRAINT `idx_student_course_course` FOREIGN KEY (`course_id`) REFERENCES `ea_course` (`id`),
  CONSTRAINT `idx_student_course_user` FOREIGN KEY (`student_id`) REFERENCES `ea_user` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生选课表';

-- 成绩表
DROP TABLE IF EXISTS `ea_score`;

CREATE TABLE `ea_score` (
  `id` bigint unsigned NOT NULL COMMEMT '主键ID',
  `parent_id` bigint unsigned NOT NULL COMMEMT '学生选课ID',
  `regular_score` float unsigned DEFAULT NULL COMMENT '平时成绩',
  `midterm_score` float unsigned DEFAULT NULL COMMENT '期中成绩',
  `terminal_score` float unsigned DEFAULT NULL COMMENT '期末成绩',
  `score` float unsigned DEFAULT NULL COMMENT '综合成绩',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  PRIMARY KEY  (`id`),
  CONSTRAINT `idx_score_student_course` FOREIGN KEY (`parent_id`) REFERENCES `ea_student_course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成绩表';

-- Codelist Book表(下拉菜单等的种类)
DROP TABLE IF EXISTS `ea_codelist_book`;

CREATE TABLE `ea_codelist_book` (
  `id` bigint unsigned NOT NULL COMMEMT '主键ID',
  `code` int unsigned NOT NULL auto_increment COMMENT 'codelist book code: 1,2,3,...',
  `name` varchar(30) NOT NULL COMMENT 'codelist book name',
  `description` text DEFAULT NULL COMMENT '介绍',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB auto_increment=1 DEFAULT CHARSET=utf8 COMMENT='Codelist Book表';

-- Codelist表(下拉菜单等对应的选项数据)
DROP TABLE IF EXISTS `ea_codelist`;

CREATE TABLE `ea_codelist` (
  `id` bigint unsigned NOT NULL COMMEMT '主键ID',
  `parent_id` bigint unsigned NOT NULL COMMEMT 'Codelist Book ID',
  `code` int unsigned NOT NULL COMMENT 'codelist code: 1,2,3,...',
  `name` varchar(30) NOT NULL COMMENT 'codelist name',
  `description` text DEFAULT NULL COMMENT '介绍',
  `created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_on` TIMESTAMP DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(30) DEFAULT NULL COMMENT '被谁更新',
  PRIMARY KEY  (`id`),
  CONSTRAINT `idx_codelist_codelist_book` FOREIGN KEY (`parent_id`) REFERENCES `ea_codelist_book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Codelist表';