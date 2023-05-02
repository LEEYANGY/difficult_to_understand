-- class_info,course_table,course_score,course_class,event,sys_menu,sys_role,sys_role_menu,sys_user_role ,teacher_class,user,user_class,zone
-- 用户权限表
DROP TABLE IF EXISTS `user`;
create table `user`
(
    `id`           BIGINT(20)   NOT NULL auto_increment primary key COMMENT '主键',
    `user_id`      BIGINT(20)   NOT NULL COMMENT '用户id',
    `user_name`    VARCHAR(200) NOT NULL DEFAULT 'null' COMMENT '用户名',
    `profession`   VARCHAR(200) NOT NULL DEFAULT 'null' COMMENT '专业名,如计算机科学与技术...',
    `nick_name`    VARCHAR(200) NOT NULL DEFAULT 'null' COMMENT '呢称',
    `email`        VARCHAR(64)           DEFAULT NULL COMMENT '邮箱',
    `password`     VARCHAR(200) NOT NULL COMMENT '密码',
    `status`       CHAR(1)               DEFAULT '0' COMMENT '账号状态 (0正常，1停用)',
    `phone_number` VARCHAR(32)           DEFAULT null COMMENT '手机号',
    `sex`          CHAR(1)               DEFAULT '2' COMMENT '用户性别(0男，1女，2未知)',
    `avatar`       VARCHAR(128)          DEFAULT null COMMENT '用户头像',
    `user_type`    CHAR(1)               DEFAULT '1' COMMENT '用户类型(0管理员，1普通用户)',
    `create_by`    BIGINT(20)            DEFAULT null COMMENT '创建人用户id',
    `create_time`  DATETIME              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`    BIGINT(20)            DEFAULT null COMMENT '变更人',
    `update_time`  DATETIME              DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
    `del_flag`     INT(11)               DEFAULT '0' COMMENT '删除标志(0代表未删除，1代表逻辑删除)'
) ENGINE = innodb
  default charset = utf8mb4 COMMENT '用户表';

-- 班级表
DROP TABLE IF EXISTS `class_info`;
create table `class_info`
(
    `id`          BIGINT(20)   NOT NULL auto_increment primary key COMMENT '主键',
    `class_id`    BIGINT(20)   NOT NULL COMMENT '班级id',
    `class_name`  VARCHAR(200) NOT NULL UNIQUE DEFAULT 'null' COMMENT '班级名',
    `status`      CHAR(1)                      DEFAULT '0' COMMENT '班级状态 (0正常，1停用)',
    `create_by`   BIGINT(20)                   DEFAULT null COMMENT '创建人用户id',
    `create_time` DATETIME                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   BIGINT(20)                   DEFAULT null COMMENT '变更人',
    `update_time` DATETIME                     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
    `del_flag`    INT(11)                      DEFAULT '0' COMMENT '删除标志(0代表未删除，1代表逻辑删除)',
    `remark`      VARCHAR(500)                 DEFAULT NULL COMMENT '备注'
) ENGINE = innodb
  default charset = utf8mb4 COMMENT '班级表';

-- 学生关联班级表
DROP TABLE IF EXISTS `user_class`;
CREATE TABLE `user_class`
(
    `user_id`  BIGINT(200) NOT NULL DEFAULT '0' COMMENT '用户ID',
    `class_id` BIGINT(200) NOT NULL DEFAULT '0' COMMENT '班级ID'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='学生关联班级表';

-- 班级关联老师表
DROP TABLE IF EXISTS `teacher_class`;
CREATE TABLE `teacher_class`
(
    `user_id`  BIGINT(200) NOT NULL DEFAULT '0' COMMENT '用户ID',
    `class_id` BIGINT(200) NOT NULL DEFAULT '0' COMMENT '班级ID'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='班级关联老师表';

-- 课表
DROP TABLE IF EXISTS `course_table`;
CREATE TABLE `course_table`
(
    `id`           BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
    `course_name`  varchar(255) unique NOT NULL COMMENT '课表名称',
    `teacher_name` varchar(255)        NOT NULL COMMENT '教师名字',
    `status`       CHAR(1)    DEFAULT '0' COMMENT '班级状态状态 (0正常，1毕业)',
    `create_by`    BIGINT(20) DEFAULT NULL COMMENT '创建者',
    `create_time`  DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`    BIGINT(20) DEFAULT NULL COMMENT '更新者',
    `update_time`  DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='课表';

DROP TABLE IF EXISTS `course_class`;
CREATE TABLE `course_class`
(
    `class_id`  BIGINT(200) NOT NULL DEFAULT '0' COMMENT '班级关联ID',
    `course_id` BIGINT(200) NOT NULL DEFAULT '0' COMMENT '课程关联ID'
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色和菜单关联表';

-- 成绩
DROP TABLE IF EXISTS `course_score`;
CREATE TABLE `course_score`
(
    `id`          BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`     varchar(255)        NOT NULL COMMENT '关联学生id',
    `course_name` varchar(255)        NOT NULL COMMENT '课程名称',
    ·degree·      DECIMAL             NOT NULL COMMENT '课程成绩',
    `status`      CHAR(1)    DEFAULT '0' COMMENT '成绩状态状态 (0正常，1毕业)',
    `create_by`   BIGINT(20) DEFAULT NULL COMMENT '创建者',
    `create_time` DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   BIGINT(20) DEFAULT NULL COMMENT '更新者',
    `update_time` DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='成绩表';

-- 自助审批事件(离校申请)
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event`
(
    `id`          BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
    `title`       varchar(255)        NOT NULL COMMENT '事件主题',
    `sponsor_id`  varchar(255)        NOT NULL COMMENT '发起人工号',
    `sponsor`     varchar(255)        NOT NULL COMMENT '发起人姓名',
    `event_type`  CHAR(1)    DEFAULT '1' COMMENT '事件类型(0实习，1看病，2.探亲，3.培训，4.请假，5.其它)',
    `status`      CHAR(1)    DEFAULT '0' COMMENT '事件状态 (0正常，1停用)',
    `back_time`   DATETIME            NOT NULL COMMENT '返校时间',
    `area`        varchar(255)        NOT NULL COMMENT '去哪呢',
    `create_by`   BIGINT(20) DEFAULT null COMMENT '创建人用户id',
    `create_time` DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   BIGINT(20) DEFAULT null COMMENT '变更人',
    `update_time` DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
    `del_flag`    INT(11)    DEFAULT '0' COMMENT '删除标志(0代表未删除，1代表逻辑删除)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='自助审批事件表';

-- 校园动态
DROP TABLE IF EXISTS `zone`;
CREATE TABLE `zone`
(
    `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '圈子ID',
    `title`       VARCHAR(128) DEFAULT NULL COMMENT '事件名称',
    `content`     LONGTEXT     DEFAULT NULL COMMENT '动态内容',
    `sponsor_id`  VARCHAR(100) DEFAULT NULL COMMENT '发布人id',
    `sponsor`     varchar(255) NOT NULL COMMENT '发布人姓名',
    `status`      CHAR(1)      DEFAULT '0' COMMENT '事件状态（0正常 1停用）',
    `del_flag`    INT(1)       DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_by`   BIGINT(20)   DEFAULT NULL COMMENT '创建者',
    `create_time` DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   BIGINT(20)   DEFAULT NULL COMMENT '更新者',
    `update_time` DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark`      VARCHAR(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='校园动态表';

# rbac权限模型
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`          BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
    `menu_name`   VARCHAR(50) NOT NULL COMMENT '菜单名称',
    `path`        VARCHAR(200) DEFAULT '' COMMENT '路由地址',
    `component`   VARCHAR(255) DEFAULT NULL COMMENT '组件路径',
    `visible`     CHAR(1)      DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
    `status`      CHAR(1)      DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
    `perms`       VARCHAR(100) DEFAULT NULL COMMENT '权限标识',
    `icon`        VARCHAR(100) DEFAULT '#' COMMENT '菜单图标',
    `create_by`   BIGINT(20)   DEFAULT NULL COMMENT '创建者',
    `create_time` DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   BIGINT(20)   DEFAULT NULL COMMENT '更新者',
    `update_time` DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark`      VARCHAR(500) DEFAULT '' COMMENT '备注',
    `del_flag`    int(11)      DEFAULT '0' COMMENT '删除标志(0代表未删除，1代表逻辑删除)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2029
  DEFAULT CHARSET = utf8mb4 COMMENT ='菜单权限表';


DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `name`        VARCHAR(128) DEFAULT NULL COMMENT '角色名称',
    `role_key`    VARCHAR(200) DEFAULT NULL COMMENT '角色权限字符串',
    `status`      CHAR(1)      DEFAULT '0' COMMENT '角色状态（0正常 1停用）',
    `del_flag`    INT(1)       DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_by`   BIGINT(20)   DEFAULT NULL COMMENT '创建者',
    `create_time` DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   BIGINT(20)   DEFAULT NULL COMMENT '更新者',
    `update_time` DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark`      VARCHAR(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色信息表';


DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `role_id` BIGINT(200) NOT NULL DEFAULT '0' COMMENT '角色ID',
    `menu_id` BIGINT(200) NOT NULL DEFAULT '0' COMMENT '菜单ID'
    #     PRIMARY KEY (`role_id`, `menu_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色和菜单关联表';


DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `user_id` BIGINT(200) NOT NULL DEFAULT '0' COMMENT '用户ID',
    `role_id` BIGINT(200) NOT NULL DEFAULT '0' COMMENT '角色ID'
    #     PRIMARY KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户和角色关联表';

DROP TABLE IF EXISTS `chats`;
CREATE TABLE `chats`
(
    `id`               BIGINT(20)                                              NOT NULL AUTO_INCREMENT COMMENT '聊天室ID',
    `gid`              BIGINT(20)                                              NOT NULL COMMENT '查找聊天室的UID',
    `room_name`        varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '聊天室名称',
    `room_description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '聊天室简介',
#     `from_user_id`     BIGINT(200)                                             NOT NULL COMMENT '发送人',
    `subject`          varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息',
#     `to_user_id`       BIGINT(200)                                             NOT NULL COMMENT '接收人',
    `status`           CHAR(1)                                                      DEFAULT '0' COMMENT '角色状态（0正常 1停用）',
    `del_flag`         CHAR(1)                                                      DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_by`        BIGINT(20)                                                   DEFAULT NULL COMMENT '创建者',
    `create_time`      DATETIME                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`        BIGINT(20)                                                   DEFAULT NULL COMMENT '更新者',
    `update_time`      DATETIME                                                     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark`           VARCHAR(500)                                                 DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic
    COMMENT ='聊天室信息';


# 关联聊天室的聊天内容
DROP TABLE IF EXISTS `chats_content`;
CREATE TABLE `chats_content`
(
    `id`           BIGINT(20)                                              NOT NULL AUTO_INCREMENT COMMENT '聊天记录ID',
    `cid`          BIGINT(20)                                              NOT NULL COMMENT '关联聊天室ID',
    `from_user_id` BIGINT(200)                                             NOT NULL COMMENT '发送人',
    `subject`      varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息',
    `status`       CHAR(1)                                                      DEFAULT '0' COMMENT '角色状态（0正常 1停用）',
    `del_flag`     CHAR(1)                                                      DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_by`    BIGINT(20)                                                   DEFAULT NULL COMMENT '创建者',
    `create_time`  DATETIME                                                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`    BIGINT(20)                                                   DEFAULT NULL COMMENT '更新者',
    `update_time`  DATETIME                                                     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark`       VARCHAR(500)                                                 DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic
    COMMENT ='聊天室信息';


# 广播消息 message
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`
(
    `id`          BIGINT(20)                                              NOT NULL AUTO_INCREMENT COMMENT '广播ID',
    `author`      BIGINT(200)                                             NOT NULL DEFAULT '0' COMMENT '发送用户ID',
    `title`       varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '消息主题',
    `subject`     varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '消息内容',
    `status`      CHAR(1)                                                          DEFAULT '0' COMMENT '角色状态（0正常 1停用）',
    `del_flag`    CHAR(1)                                                          DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_by`   BIGINT(20)                                                       DEFAULT NULL COMMENT '创建者',
    `create_time` DATETIME                                                         DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   BIGINT(20)                                                       DEFAULT NULL COMMENT '更新者',
    `update_time` DATETIME                                                         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark`      VARCHAR(500)                                                     DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic
    COMMENT ='广播消息message';

# 健康消息上报
DROP TABLE IF EXISTS `health_report`;
CREATE TABLE `health_report`
(
    `id`          BIGINT(20)                                              NOT NULL AUTO_INCREMENT COMMENT '广播ID',
    `sponsor_id`  BIGINT(200)                                             NOT NULL DEFAULT '0' COMMENT '申报用户ID',
    `sponsor`     varchar(255)                                            NOT NULL COMMENT '发布人姓名',
    `title`       varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '申报主题',
    `subject`     varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '申报内容',
    `status`      CHAR(1)                                                          DEFAULT '0' COMMENT '申报状态（0正常 1停用）',
    `del_flag`    CHAR(1)                                                          DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_by`   BIGINT(20)                                                       DEFAULT NULL COMMENT '创建者',
    `create_time` DATETIME                                                         DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   BIGINT(20)                                                       DEFAULT NULL COMMENT '更新者',
    `update_time` DATETIME                                                         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark`      VARCHAR(500)                                                     DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic
    COMMENT ='健康信息上报';


-- user,class_info,user_class,teacher_class,schedule_table,course_score,event,zone,sys_menu,sys_role,sys_role_menu,sys_user_role,message,chats,chats_content,health_report

-- 日志记录

-- 插入数据
# 班级
INSERT INTO classdesign.class_info (class_id, class_name, status, create_by, create_time, update_by, update_time,
                                    del_flag, remark)
VALUES (202001, '22gbs计算1', DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT, null),
       (202002, '22gbs计算2', DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT, null),
       (202003, '22gbs计算3', DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT, null),
       (202004, '22gbs计算4', DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT, null),
       (202005, '22gb计算1', DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT, null),
       (202006, '22gb计算2', DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT, null),
       (202007, '22gb计算3', DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT, null),
       (202008, '22gb计算4', DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT, null);

# 课表
INSERT INTO classdesign.course_table (course_name, teacher_name, status, create_by, create_time, update_by,
                                      update_time)
VALUES ('VUE开发技术', '王欣', DEFAULT, null, DEFAULT, null, DEFAULT),
       ('SpringCloud开发技术', '杨红祥', DEFAULT, null, DEFAULT, null, DEFAULT),
       ('H5开发技术', '李翔', DEFAULT, null, DEFAULT, null, DEFAULT),
       ('Spark实时计算与内存', '汤磊', DEFAULT, null, DEFAULT, null, DEFAULT),
       ('单片机开发技术', '李光明', DEFAULT, null, DEFAULT, null, DEFAULT),
       ('MapReduce开发技术', '程汇利', DEFAULT, null, DEFAULT, null, DEFAULT),
       ('操作系统', '贺红艳', DEFAULT, null, DEFAULT, null, DEFAULT);

# 角色
INSERT INTO classdesign.sys_role (name, role_key, status, del_flag, create_by, create_time, update_by, update_time,
                                  remark)
VALUES ('teacher', 'teacher', '0', DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('student', 'student', '0', DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('test', 'test', '0', DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('guest', 'guest', '0', DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('admin', 'admin', '0', DEFAULT, null, DEFAULT, null, DEFAULT, null);

# 用户
INSERT INTO classdesign.user (user_id, user_name, profession, nick_name, email, password, status, phone_number, sex,
                              avatar, user_type, create_by, create_time, update_by, update_time, del_flag)
VALUES (20223035102, '冯思琳', '计算机科学与技术', 'fsl', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (20223035103, '杨逵', '计算机科学与技术', 'kk', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (20223035104, '李洋洋', '计算机科学与技术', 'lyy', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (20223035134, '唐寒莉', '计算机科学与技术', 'thl', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (20223035201, '光头强', '计算机科学与技术', 'gtq', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (20223035202, '熊二', '计算机科学与技术', 'xe', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (20223035203, '熊大', '计算机科学与技术', 'xd', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (20223035301, '急急国王', '计算机科学与技术', 'jjgw', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (20223035302, '喜羊羊', '计算机科学与技术', 'xyy', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (20223035401, '灰太阳', '计算机科学与技术', 'hty', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (20223035404, '红太阳', '计算机科学与技术', 'hty', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (10000000001, 'cc', '计算机科学与技术', 'cc', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (10000000002, 'tl', '计算机科学与技术', 'tl', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT),
       (10000000003, 'yy', '计算机科学与技术', 'yy', 'lyy@qq.com', '123321456', DEFAULT, '10010', DEFAULT, null,
        DEFAULT, null, DEFAULT, null, DEFAULT, DEFAULT);

# 用户关联角色
INSERT INTO classdesign.sys_user_role (user_id, role_id)
VALUES (20223035102, 4),
       (20223035103, 4),
       (20223035103, 4),
       (20223035134, 4),
       (20223035201, 4),
       (20223035202, 4),
       (20223035203, 4),
       (20223035301, 4),
       (20223035302, 4),
       (20223035401, 4),
       (20223035404, 4),
       (10000000001, 3),
       (10000000001, 5),
       (10000000001, 6),
       (10000000001, 7),
       (10000000002, 3),
       (10000000002, 5),
       (10000000002, 6),
       (10000000002, 7),
       (10000000003, 3),
       (10000000003, 5),
       (10000000003, 6),
       (10000000003, 7);

# 学生班级关联
INSERT INTO classdesign.user_class (user_id, class_id)
VALUES (20223035102, 202001),
       (20223035103, 202001),
       (20223035104, 202001),
       (20223035134, 202001),
       (20223035201, 202002),
       (20223035202, 202002),
       (20223035203, 202002),
       (20223035301, 202003),
       (20223035302, 202003),
       (20223035401, 202004),
       (20223035404, 202004);

# 教师关联班级
INSERT INTO classdesign.teacher_class (user_id, class_id)
VALUES (10000000001, 202001),
       (10000000001, 202002),
       (10000000002, 202003),
       (10000000003, 202004);

# 课程关联班级
INSERT INTO classdesign.course_class (class_id, course_id)
VALUES (202001, 1),
       (202001, 2),
       (202001, 3),
       (202001, 4),
       (202001, 5),
       (202001, 6),
       (202001, 7),
       (202002, 1),
       (202002, 2),
       (202002, 3),
       (202002, 4),
       (202002, 5),
       (202002, 6),
       (202002, 7),
       (202003, 1),
       (202003, 2),
       (202003, 3),
       (202003, 4),
       (202003, 5),
       (202003, 6),
       (202003, 7),
       (202004, 1),
       (202004, 2),
       (202004, 3),
       (202004, 4),
       (202004, 5),
       (202004, 6),
       (202004, 7),
       (202005, 1),
       (202005, 2),
       (202005, 3),
       (202005, 4),
       (202005, 5),
       (202005, 6),
       (202005, 7);

# 圈子
INSERT INTO classdesign.zone (title, content, sponsor_id, sponsor, status, del_flag, create_by, create_time, update_by,
                              update_time, remark)
VALUES ('测试1', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试2', '测试内容', '20223035102', 'fsl', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试3', '测试内容', '20223035102', 'fsl', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试4', '测试内容', '20223035103', 'kk', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试5', '测试内容', '20223035103', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试6', '测试内容', '20223035134', 'thl', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试7', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试8', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试9', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试10', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试11', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试12', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试13', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试14', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试15', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试16', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试17', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试18', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试19', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试20', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试21', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试22', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试23', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试24', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试25', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试26', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试27', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试28', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试29', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试30', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试31', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试32', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试33', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试34', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试35', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试36', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试37', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试38', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试39', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试40', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试41', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试42', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试43', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试44', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试45', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试46', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试47', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试48', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试49', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试50', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null),
       ('测试51', '测试内容', '20223035104', 'lyy', DEFAULT, DEFAULT, null, DEFAULT, null, DEFAULT, null);

# 通知
INSERT
INTO classdesign.message (author, title, subject, status, del_flag, create_by, create_time, update_by,
                          update_time, remark)
VALUES (20223035104, '测试', '51放假通知', DEFAULT, DEFAULT, 20223035104, DEFAULT, 20223035104, DEFAULT, null)

# 添加一个群聊
INSERT INTO classdesign.chats (gid, room_name, room_description, subject, status, del_flag, create_by, create_time,
                               update_by, update_time, remark)
VALUES (10000000, '测试群聊', '正在开发一个群聊功能', null, DEFAULT, DEFAULT, 0, DEFAULT, 0, DEFAULT, '测试中');

# 聊天记录
INSERT INTO classdesign.chats_content (cid, from_user_id, subject, status, del_flag, create_by, create_time, update_by,
                                       update_time, remark)
VALUES (1, 20223035104, '模拟数据12', DEFAULT, DEFAULT, 20223035104, DEFAULT, 20223035104, DEFAULT, null),
       (1, 20223035103, '模拟数据asd', DEFAULT, DEFAULT, 20223035103, DEFAULT, 20223035103, DEFAULT, null),
       (1, 20223035102, '模拟数据asaxc', DEFAULT, DEFAULT, 20223035102, DEFAULT, 20223035102, DEFAULT, null),
       (1, 20223035104, '模拟数据asdazxc', DEFAULT, DEFAULT, 20223035104, DEFAULT, 20223035104, DEFAULT, null),
       (1, 20223035102, '模拟数据asdasd', DEFAULT, DEFAULT, 20223035102, DEFAULT, 20223035102, DEFAULT, null),
       (1, 20223035102, '模拟数据zcx234vzc', DEFAULT, DEFAULT, 20223035104, DEFAULT, 20223035104, DEFAULT, null),
       (1, 20223035103, '模拟数据asdfew', DEFAULT, DEFAULT, 20223035103, DEFAULT, 20223035103, DEFAULT, null),
       (1, 20223035104, '模拟数据czxv', DEFAULT, DEFAULT, 20223035104, DEFAULT, 20223035104, DEFAULT, null),
       (1, 20223035102, '模拟数据zcxv', DEFAULT, DEFAULT, 20223035102, DEFAULT, 20223035102, DEFAULT, null),
       (1, 20223035102, '模拟数据zxcqw2131!@#v', DEFAULT, DEFAULT, 20223035102, DEFAULT, 20223035102, DEFAULT, null),
       (1, 20223035104, '模拟数据zxcvae)(*&', DEFAULT, DEFAULT, 20223035104, DEFAULT, 20223035104, DEFAULT, null),
       (1, 20223035104, '模拟数据..,.;[]', DEFAULT, DEFAULT, 20223035104, DEFAULT, 20223035104, DEFAULT, null);

// 每日健康消息上报
INSERT INTO classdesign.health_report (sponsor_id, sponsor, title, subject, status, del_flag, create_by, create_time,
                                       update_by, update_time, remark)
VALUES (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-01 01:16:28', 20223035104, '2023-05-01 01:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-02 02:16:28', 20223035104, '2023-05-02 02:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-03 03:16:28', 20223035104, '2023-05-03 03:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-04 04:16:28', 20223035104, '2023-05-04 04:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-05 05:16:28', 20223035104, '2023-05-05 05:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-06 06:16:28', 20223035104, '2023-05-06 06:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-07 07:16:28', 20223035104, '2023-05-07 07:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-08 08:16:28', 20223035104, '2023-05-08 08:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-09 09:16:28', 20223035104, '2023-05-09 09:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-10 10:16:28', 20223035104, '2023-05-10 10:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-11 11:16:28', 20223035104, '2023-05-11 11:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-12 12:16:28', 20223035104, '2023-05-12 12:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-13 13:16:28', 20223035104, '2023-05-13 13:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-14 14:16:28', 20223035104, '2023-05-14 14:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-15 15:16:28', 20223035104, '2023-05-15 15:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-16 16:16:28', 20223035104, '2023-05-16 16:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-17 17:16:28', 20223035104, '2023-05-17 17:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-18 18:16:28', 20223035104, '2023-05-18 18:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-19 19:16:28', 20223035104, '2023-05-19 19:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-20 20:16:28', 20223035104, '2023-05-20 20:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-21 21:16:28', 20223035104, '2023-05-21 21:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-22 22:16:28', 20223035104, '2023-05-22 22:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-23 23:16:28', 20223035104, '2023-05-23 23:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-24 18:16:28', 20223035104, '2023-05-24 18:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-25 09:16:28', 20223035104, '2023-05-25 09:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-26 02:16:28', 20223035104, '2023-05-26 02:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-27 06:16:28', 20223035104, '2023-05-27 06:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-28 07:16:28', 20223035104, '2023-05-28 07:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-29 01:16:28', 20223035104, '2023-05-29 01:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-30 02:16:28', 20223035104, '2023-05-30 02:16:28', '每日健康信息上报'),
       (20223035104, 'lyy', '每日健康信息上报', '每日健康信息上报', DEFAULT, DEFAULT, 20223035104,
        '2023-05-31 00:16:28', 20223035104, '2023-05-31 00:16:28', '每日健康信息上报')
