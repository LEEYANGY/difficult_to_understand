# 建库
create database security_skill;

# 使用库
use security_skill;

# 创建语句

/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : security_skill

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2021-05-25 04:17:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
                                  `id` int(10) NOT NULL,
                                  `permName` varchar(50) DEFAULT NULL,
                                  `permTag` varchar(50) DEFAULT NULL,
                                  `url` varchar(255) DEFAULT NULL COMMENT '请求url',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '查询用户', 'get', '/**/getInfo');
INSERT INTO `sys_permission` VALUES ('2', '添加用户', 'adds', '/**/addInfo');
INSERT INTO `sys_permission` VALUES ('3', '修改用户', 'update', '/**/updateInfo');
INSERT INTO `sys_permission` VALUES ('4', '删除用户', 'dels', '/**/delInfo');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
                            `id` int(10) NOT NULL,
                            `roleName` varchar(50) DEFAULT NULL,
                            `roleDesc` varchar(50) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `sys_role` VALUES ('2', 'add_user', '添加管理员');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
                                       `role_id` int(10) DEFAULT NULL,
                                       `perm_id` int(10) DEFAULT NULL,
                                       KEY `FK_Reference_3` (`role_id`),
                                       KEY `FK_Reference_4` (`perm_id`),
                                       CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
                                       CONSTRAINT `FK_Reference_4` FOREIGN KEY (`perm_id`) REFERENCES `sys_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('1', '4');
INSERT INTO `sys_role_permission` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
                            `id` int(10) NOT NULL,
                            `username` varchar(50) DEFAULT NULL,
                            `realname` varchar(50) DEFAULT NULL,
                            `password` varchar(50) DEFAULT NULL,
                            `createDate` date DEFAULT NULL,
                            `lastLoginTime` date DEFAULT NULL,
                            `enabled` int(5) DEFAULT NULL,
                            `accountNonExpired` int(5) DEFAULT NULL,
                            `accountNonLocked` int(5) DEFAULT NULL,
                            `credentialsNonExpired` int(5) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'leeyangy', '1cd9f3622175f2456471f80aa2df7105', '2018-11-13', '2018-11-13', '1', '1', '1', '1');
INSERT INTO `sys_user` VALUES ('2', 'commons', 'fuck_java', '1cd9f3622175f2456471f80aa2df7105', '2018-11-13', '2018-11-13', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
                                 `user_id` int(10) DEFAULT NULL,
                                 `role_id` int(10) DEFAULT NULL,
                                 KEY `FK_Reference_1` (`user_id`),
                                 KEY `FK_Reference_2` (`role_id`),
                                 CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
                                 CONSTRAINT `FK_Reference_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');



-- create database shiro default character set utf8;

drop table if exists sys_users;
drop table if exists sys_roles;
drop table if exists sys_permissions;
drop table if exists sys_users_roles;
drop table if exists sys_roles_permissions;

create table sys_users (
                           id bigint auto_increment comment '编号',
                           username varchar(100) comment '用户名',
                           password varchar(100) comment '密码',
                           salt varchar(100) comment '盐值',
                           role_id varchar(50) comment '角色列表',
                           locked bool default false comment '是否锁定',
                           constraint pk_sys_users primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_users_username on sys_users(username);

create table sys_roles (
                           id bigint auto_increment comment '角色编号',
                           role varchar(100) comment '角色名称',
                           description varchar(100) comment '角色描述',
                           pid bigint comment '父节点',
                           available bool default false comment '是否锁定',
                           constraint pk_sys_roles primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_roles_role on sys_roles(role);

create table sys_permissions (
                                 id bigint auto_increment comment '编号',
                                 permission varchar(100) comment '权限编号',
                                 description varchar(100) comment '权限描述',
                                 rid bigint comment '此权限关联角色的id',
                                 available bool default false comment '是否锁定',
                                 constraint pk_sys_permissions primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_permissions_permission on sys_permissions(permission);

create table sys_users_roles (
                                 id  bigint auto_increment comment '编号',
                                 user_id bigint comment '用户编号',
                                 role_id bigint comment '角色编号',
                                 constraint pk_sys_users_roles primary key(id)
) charset=utf8 ENGINE=InnoDB;

create table sys_roles_permissions (
                                       id bigint auto_increment comment '编号',
                                       role_id bigint comment '角色编号',
                                       permission_id bigint comment '权限编号',
                                       constraint pk_sys_roles_permissions primary key(id)
) charset=utf8 ENGINE=InnoDB;
