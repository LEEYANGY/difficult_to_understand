-- class_info,course_table,course_score,course_class,event,sys_menu,sys_role,sys_role_menu,sys_user_role ,teacher_class,user,user_class,zone
# sys_zone,sys_user,sys_notice,sys_event,sys_health_report,sys_chats_content,sys_chats
-- ----------------------------
-- 1、部门表
-- ----------------------------
drop table if exists sys_dept;
create table sys_dept
(
    dept_id     bigint(20) not null auto_increment comment '部门id',
    parent_id   bigint(20)  default 0 comment '父部门id',
    ancestors   varchar(50) default '' comment '祖级列表',
    dept_name   varchar(30) default '' comment '部门名称',
    order_num   int(4)      default 0 comment '显示顺序',
    leader      varchar(20) default null comment '负责人',
    phone       varchar(11) default null comment '联系电话',
    email       varchar(50) default null comment '邮箱',
    status      char(1)     default '0' comment '部门状态（0正常 1停用）',
    del_flag    char(1)     default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by   varchar(64) default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64) default '' comment '更新者',
    update_time datetime comment '更新时间',
    primary key (dept_id)
) engine = innodb
  auto_increment = 200 comment = '部门表';

-- ----------------------------
-- 初始化-部门表数据
-- ----------------------------
insert into sys_dept values(100,  0,   '0',          '若依科技',   0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(101,  100, '0,100',      '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(102,  100, '0,100',      '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(103,  101, '0,100,101',  '研发部门',   1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(104,  101, '0,100,101',  '市场部门',   2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(105,  101, '0,100,101',  '测试部门',   3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(106,  101, '0,100,101',  '财务部门',   4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(107,  101, '0,100,101',  '运维部门',   5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(108,  102, '0,100,102',  '市场部门',   1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(109,  102, '0,100,102',  '财务部门',   2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);

-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user
(
    user_id      bigint(20)  not null auto_increment comment '用户ID',
    dept_id      bigint(20)   default null comment '部门ID',
    user_name    varchar(30) not null comment '用户账号',
    nick_name    varchar(30) not null comment '用户昵称',
    user_type    varchar(2)   default '00' comment '用户类型（00系统用户）',
    email        varchar(50)  default '' comment '用户邮箱',
    phonenumber  varchar(11)  default '' comment '手机号码',
    `profession` VARCHAR(200) DEFAULT 'null' COMMENT '专业名,如计算机科学与技术...',
    sex          char(1)      default '0' comment '用户性别（0男 1女 2未知）',
    avatar       varchar(100) default '' comment '头像地址',
    password     varchar(100) default '' comment '密码',
    status       char(1)      default '0' comment '帐号状态（0正常 1停用）',
    del_flag     char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    login_ip     varchar(128) default '' comment '最后登录IP',
    login_date   datetime comment '最后登录时间',
    create_by    varchar(64)  default '' comment '创建者',
    create_time  datetime comment '创建时间',
    update_by    varchar(64)  default '' comment '更新者',
    update_time  datetime comment '更新时间',
    remark       varchar(500) default null comment '备注',
    primary key (user_id)
) engine = innodb
  auto_increment = 100 comment = '用户信息表';

-- ----------------------------
-- 3、岗位信息表
-- ----------------------------
drop table if exists sys_post;
create table sys_post
(
    post_id       bigint(20)      not null auto_increment    comment '岗位ID',
    post_code     varchar(64)     not null                   comment '岗位编码',
    post_name     varchar(50)     not null                   comment '岗位名称',
    post_sort     int(4)          not null                   comment '显示顺序',
    status        char(1)         not null                   comment '状态（0正常 1停用）',
    create_by     varchar(64)     default ''                 comment '创建者',
    create_time   datetime                                   comment '创建时间',
    update_by     varchar(64)     default ''			       comment '更新者',
    update_time   datetime                                   comment '更新时间',
    remark        varchar(500)    default null               comment '备注',
    primary key (post_id)
) engine=innodb comment = '岗位信息表';

-- ----------------------------
-- 初始化-岗位信息表数据
-- ----------------------------
insert into sys_post values(1, 'ceo',  '董事长',    1, '0', 'admin', sysdate(), '', null, '');
insert into sys_post values(2, 'se',   '项目经理',  2, '0', 'admin', sysdate(), '', null, '');
insert into sys_post values(3, 'hr',   '人力资源',  3, '0', 'admin', sysdate(), '', null, '');
insert into sys_post values(4, 'user', '普通员工',  4, '0', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 初始化-用户信息表数据   $2a$10$AqTL1TPmkjh5mBprcQdofOw8Wc0L3IMK1nmWZrbnS4nm0AfVjIZPW
-- ----------------------------

# 用户
INSERT INTO classdesign.sys_user (user_id, dept_id, user_name, nick_name, user_type, email, phonenumber, profession,
                                  sex, avatar, password, status, del_flag, login_ip, login_date, create_by, create_time,
                                  update_by, update_time, remark)
VALUES (20223035102, 103, '20223035102', '冯思琳', '00', '1787294587@qq.com', '10010', '计算机科学与技术', '1', DEFAULT,
        '$2a$10$AqTL1TPmkjh5mBprcQdofOw8Wc0L3IMK1nmWZrbnS4nm0AfVjIZPW', '0', '0', '127.0.0.1', '2023-05-07 15:15:44',
        'admin', '2023-05-07 15:15:53', DEFAULT, null, '学生'),
       (20223035103, 103, '20223035103', '杨逵', '00', '1787294587@qq.com', '10010', '计算机科学与技术', '1', DEFAULT,
        '$2a$10$AqTL1TPmkjh5mBprcQdofOw8Wc0L3IMK1nmWZrbnS4nm0AfVjIZPW', '0', '0', '127.0.0.1', '2023-05-07 15:15:44',
        'admin', '2023-05-07 15:15:53', DEFAULT, null, '学生'),
       (20223035104, 103, '20223035104', '李洋洋', '00', '1787294587@qq.com', '10010', '计算机科学与技术', '1', DEFAULT,
        '$2a$10$AqTL1TPmkjh5mBprcQdofOw8Wc0L3IMK1nmWZrbnS4nm0AfVjIZPW', '0', '0', '127.0.0.1', '2023-05-07 15:15:44',
        'admin', '2023-05-07 15:15:53', DEFAULT, null, '学生'),
       (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '', '1', '',
        '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', sysdate(), 'admin',
        sysdate(), '', null, '管理员'),
       (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '', '1', '',
        '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', sysdate(), 'admin',
        sysdate(), '', null, '测试员');

-- ----------------------------
-- 4、角色信息表
-- ----------------------------
drop table if exists sys_role;
create table sys_role
(
    role_id             bigint(20)   not null auto_increment comment '角色ID',
    role_name           varchar(30)  not null comment '角色名称',
    role_key            varchar(100) not null comment '角色权限字符串',
    role_sort           int(4)       not null comment '显示顺序',
    data_scope          char(1)      default '1' comment '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
    menu_check_strictly tinyint(1)   default 1 comment '菜单树选择项是否关联显示',
    dept_check_strictly tinyint(1)   default 1 comment '部门树选择项是否关联显示',
    status              char(1)      not null comment '角色状态（0正常 1停用）',
    del_flag            char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by           varchar(64)  default '' comment '创建者',
    create_time         datetime comment '创建时间',
    update_by           varchar(64)  default '' comment '更新者',
    update_time         datetime comment '更新时间',
    remark              varchar(500) default null comment '备注',
    primary key (role_id)
) engine = innodb
  auto_increment = 100 comment = '角色信息表';

-- ----------------------------
-- 初始化-角色信息表数据
-- ----------------------------
insert into sys_role
values ('1', '超级管理员', 'admin', 1, 1, 1, 1, '0', '0', 'admin', sysdate(), '', null, '超级管理员');
insert into sys_role
values ('2', '普通角色', 'common', 2, 2, 1, 1, '0', '0', 'admin', sysdate(), '', null, '普通角色');


-- ----------------------------
-- 5、菜单权限表
-- ----------------------------
drop table if exists sys_menu;
create table sys_menu
(
    menu_id     bigint(20)  not null auto_increment comment '菜单ID',
    menu_name   varchar(50) not null comment '菜单名称',
    parent_id   bigint(20)   default 0 comment '父菜单ID',
    order_num   int(4)       default 0 comment '显示顺序',
    path        varchar(200) default '' comment '路由地址',
    component   varchar(255) default null comment '组件路径',
    query       varchar(255) default null comment '路由参数',
    is_frame    int(1)       default 1 comment '是否为外链（0是 1否）',
    is_cache    int(1)       default 0 comment '是否缓存（0缓存 1不缓存）',
    menu_type   char(1)      default '' comment '菜单类型（M目录 C菜单 F按钮）',
    visible     char(1)      default 0 comment '菜单状态（0显示 1隐藏）',
    status      char(1)      default 0 comment '菜单状态（0正常 1停用）',
    perms       varchar(100) default null comment '权限标识',
    icon        varchar(100) default '#' comment '菜单图标',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default '' comment '备注',
    primary key (menu_id)
) engine = innodb
  auto_increment = 2000 comment = '菜单权限表';

-- ----------------------------
-- 初始化-菜单信息表数据
-- ----------------------------
-- 一级菜单
insert into sys_menu
values ('1', '系统管理', '0', '1', 'system', null, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', sysdate(), '', null,
        '系统管理目录');
insert into sys_menu
values ('2', '系统监控', '0', '2', 'monitor', null, '', 1, 0, 'M', '0', '0', '', 'monitor', 'admin', sysdate(), '',
        null, '系统监控目录');
insert into sys_menu
values ('3', '系统工具', '0', '3', 'tool', null, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', sysdate(), '', null,
        '系统工具目录');
insert into sys_menu
values ('4', '若依官网', '0', '4', 'http://ruoyi.vip', null, '', 0, 0, 'M', '0', '0', '', 'guide', 'admin', sysdate(),
        '', null, '若依官网地址');
-- 二级菜单
insert into sys_menu
values ('100', '用户管理', '1', '1', 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user',
        'admin', sysdate(), '', null, '用户管理菜单');
insert into sys_menu
values ('101', '角色管理', '1', '2', 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list',
        'peoples', 'admin', sysdate(), '', null, '角色管理菜单');
insert into sys_menu
values ('102', '菜单管理', '1', '3', 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list',
        'tree-table', 'admin', sysdate(), '', null, '菜单管理菜单');
insert into sys_menu
values ('103', '部门管理', '1', '4', 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree',
        'admin', sysdate(), '', null, '部门管理菜单');
insert into sys_menu
values ('104', '岗位管理', '1', '5', 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post',
        'admin', sysdate(), '', null, '岗位管理菜单');
insert into sys_menu
values ('105', '字典管理', '1', '6', 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict',
        'admin', sysdate(), '', null, '字典管理菜单');
insert into sys_menu
values ('106', '参数设置', '1', '7', 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list',
        'edit', 'admin', sysdate(), '', null, '参数设置菜单');
insert into sys_menu
values ('107', '通知公告', '1', '8', 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list',
        'message', 'admin', sysdate(), '', null, '通知公告菜单');
insert into sys_menu
values ('108', '日志管理', '1', '9', 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', sysdate(), '', null,
        '日志管理菜单');
insert into sys_menu
values ('109', '在线用户', '2', '1', 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list',
        'online', 'admin', sysdate(), '', null, '在线用户菜单');
insert into sys_menu
values ('110', '定时任务', '2', '2', 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job',
        'admin', sysdate(), '', null, '定时任务菜单');
insert into sys_menu
values ('111', '数据监控', '2', '3', 'druid', 'monitor/druid/index', '', 1, 0, 'C', '0', '0', 'monitor:druid:list',
        'druid', 'admin', sysdate(), '', null, '数据监控菜单');
insert into sys_menu
values ('112', '服务监控', '2', '4', 'server', 'monitor/server/index', '', 1, 0, 'C', '0', '0', 'monitor:server:list',
        'server', 'admin', sysdate(), '', null, '服务监控菜单');
insert into sys_menu
values ('113', '缓存监控', '2', '5', 'cache', 'monitor/cache/index', '', 1, 0, 'C', '0', '0', 'monitor:cache:list',
        'redis', 'admin', sysdate(), '', null, '缓存监控菜单');
insert into sys_menu
values ('114', '缓存列表', '2', '6', 'cacheList', 'monitor/cache/list', '', 1, 0, 'C', '0', '0', 'monitor:cache:list',
        'redis-list', 'admin', sysdate(), '', null, '缓存列表菜单');
insert into sys_menu
values ('115', '表单构建', '3', '1', 'build', 'tool/build/index', '', 1, 0, 'C', '0', '0', 'tool:build:list', 'build',
        'admin', sysdate(), '', null, '表单构建菜单');
insert into sys_menu
values ('116', '代码生成', '3', '2', 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin',
        sysdate(), '', null, '代码生成菜单');
insert into sys_menu
values ('117', '系统接口', '3', '3', 'swagger', 'tool/swagger/index', '', 1, 0, 'C', '0', '0', 'tool:swagger:list',
        'swagger', 'admin', sysdate(), '', null, '系统接口菜单');
-- 三级菜单
insert into sys_menu
values ('500', '操作日志', '108', '1', 'operlog', 'monitor/operlog/index', '', 1, 0, 'C', '0', '0',
        'monitor:operlog:list', 'form', 'admin', sysdate(), '', null, '操作日志菜单');
insert into sys_menu
values ('501', '登录日志', '108', '2', 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0',
        'monitor:logininfor:list', 'logininfor', 'admin', sysdate(), '', null, '登录日志菜单');
-- 用户管理按钮
insert into sys_menu
values ('1000', '用户查询', '100', '1', '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1001', '用户新增', '100', '2', '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', sysdate(), '',
        null, '');
insert into sys_menu
values ('1002', '用户修改', '100', '3', '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1003', '用户删除', '100', '4', '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1004', '用户导出', '100', '5', '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1005', '用户导入', '100', '6', '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1006', '重置密码', '100', '7', '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin',
        sysdate(), '', null, '');
-- 角色管理按钮
insert into sys_menu
values ('1007', '角色查询', '101', '1', '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1008', '角色新增', '101', '2', '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', sysdate(), '',
        null, '');
insert into sys_menu
values ('1009', '角色修改', '101', '3', '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1010', '角色删除', '101', '4', '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1011', '角色导出', '101', '5', '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', sysdate(),
        '', null, '');
-- 菜单管理按钮
insert into sys_menu
values ('1012', '菜单查询', '102', '1', '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1013', '菜单新增', '102', '2', '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', sysdate(), '',
        null, '');
insert into sys_menu
values ('1014', '菜单修改', '102', '3', '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1015', '菜单删除', '102', '4', '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', sysdate(),
        '', null, '');
-- 部门管理按钮
insert into sys_menu
values ('1016', '部门查询', '103', '1', '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1017', '部门新增', '103', '2', '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', sysdate(), '',
        null, '');
insert into sys_menu
values ('1018', '部门修改', '103', '3', '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1019', '部门删除', '103', '4', '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', sysdate(),
        '', null, '');
-- 岗位管理按钮
insert into sys_menu
values ('1020', '岗位查询', '104', '1', '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1021', '岗位新增', '104', '2', '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', sysdate(), '',
        null, '');
insert into sys_menu
values ('1022', '岗位修改', '104', '3', '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1023', '岗位删除', '104', '4', '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1024', '岗位导出', '104', '5', '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', sysdate(),
        '', null, '');
-- 字典管理按钮
insert into sys_menu
values ('1025', '字典查询', '105', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1026', '字典新增', '105', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1027', '字典修改', '105', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1028', '字典删除', '105', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1029', '字典导出', '105', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', sysdate(),
        '', null, '');
-- 参数设置按钮
insert into sys_menu
values ('1030', '参数查询', '106', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1031', '参数新增', '106', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1032', '参数修改', '106', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1033', '参数删除', '106', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1034', '参数导出', '106', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin',
        sysdate(), '', null, '');
-- 通知公告按钮
insert into sys_menu
values ('1035', '公告查询', '107', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1036', '公告新增', '107', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1037', '公告修改', '107', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1038', '公告删除', '107', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin',
        sysdate(), '', null, '');
-- 操作日志按钮
insert into sys_menu
values ('1039', '操作查询', '500', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1040', '操作删除', '500', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1041', '日志导出', '500', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export', '#', 'admin',
        sysdate(), '', null, '');
-- 登录日志按钮
insert into sys_menu
values ('1042', '登录查询', '501', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1043', '登录删除', '501', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1044', '日志导出', '501', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1045', '账户解锁', '501', '4', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:unlock', '#', 'admin',
        sysdate(), '', null, '');
-- 在线用户按钮
insert into sys_menu
values ('1046', '在线查询', '109', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1047', '批量强退', '109', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1048', '单条强退', '109', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin',
        sysdate(), '', null, '');
-- 定时任务按钮
insert into sys_menu
values ('1049', '任务查询', '110', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1050', '任务新增', '110', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1051', '任务修改', '110', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1052', '任务删除', '110', '4', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1053', '状态修改', '110', '5', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin',
        sysdate(), '', null, '');
insert into sys_menu
values ('1054', '任务导出', '110', '6', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', sysdate(),
        '', null, '');
-- 代码生成按钮
insert into sys_menu
values ('1055', '生成查询', '116', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', sysdate(), '',
        null, '');
insert into sys_menu
values ('1056', '生成修改', '116', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', sysdate(), '',
        null, '');
insert into sys_menu
values ('1057', '生成删除', '116', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1058', '导入代码', '116', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1059', '预览代码', '116', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', sysdate(),
        '', null, '');
insert into sys_menu
values ('1060', '生成代码', '116', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', sysdate(), '',
        null, '');


-- ----------------------------
-- 6、用户和角色关联表  用户N-1角色
-- ----------------------------
drop table if exists sys_user_role;
create table sys_user_role
(
    user_id bigint(20) not null comment '用户ID',
    role_id bigint(20) not null comment '角色ID',
    primary key (user_id, role_id)
) engine = innodb comment = '用户和角色关联表';

-- ----------------------------
-- 初始化-用户和角色关联表数据
-- ----------------------------
insert into sys_user_role
values ('1', '1');
insert into sys_user_role
values ('2', '2');


-- ----------------------------
-- 7、角色和菜单关联表  角色1-N菜单
-- ----------------------------
drop table if exists sys_role_menu;
create table sys_role_menu
(
    role_id bigint(20) not null comment '角色ID',
    menu_id bigint(20) not null comment '菜单ID',
    primary key (role_id, menu_id)
) engine = innodb comment = '角色和菜单关联表';

-- ----------------------------
-- 初始化-角色和菜单关联表数据
-- ----------------------------
insert into sys_role_menu
values ('2', '1');
insert into sys_role_menu
values ('2', '2');
insert into sys_role_menu
values ('2', '3');
insert into sys_role_menu
values ('2', '4');
insert into sys_role_menu
values ('2', '100');
insert into sys_role_menu
values ('2', '101');
insert into sys_role_menu
values ('2', '102');
insert into sys_role_menu
values ('2', '103');
insert into sys_role_menu
values ('2', '104');
insert into sys_role_menu
values ('2', '105');
insert into sys_role_menu
values ('2', '106');
insert into sys_role_menu
values ('2', '107');
insert into sys_role_menu
values ('2', '108');
insert into sys_role_menu
values ('2', '109');
insert into sys_role_menu
values ('2', '110');
insert into sys_role_menu
values ('2', '111');
insert into sys_role_menu
values ('2', '112');
insert into sys_role_menu
values ('2', '113');
insert into sys_role_menu
values ('2', '114');
insert into sys_role_menu
values ('2', '115');
insert into sys_role_menu
values ('2', '116');
insert into sys_role_menu
values ('2', '117');
insert into sys_role_menu
values ('2', '500');
insert into sys_role_menu
values ('2', '501');
insert into sys_role_menu
values ('2', '1000');
insert into sys_role_menu
values ('2', '1001');
insert into sys_role_menu
values ('2', '1002');
insert into sys_role_menu
values ('2', '1003');
insert into sys_role_menu
values ('2', '1004');
insert into sys_role_menu
values ('2', '1005');
insert into sys_role_menu
values ('2', '1006');
insert into sys_role_menu
values ('2', '1007');
insert into sys_role_menu
values ('2', '1008');
insert into sys_role_menu
values ('2', '1009');
insert into sys_role_menu
values ('2', '1010');
insert into sys_role_menu
values ('2', '1011');
insert into sys_role_menu
values ('2', '1012');
insert into sys_role_menu
values ('2', '1013');
insert into sys_role_menu
values ('2', '1014');
insert into sys_role_menu
values ('2', '1015');
insert into sys_role_menu
values ('2', '1016');
insert into sys_role_menu
values ('2', '1017');
insert into sys_role_menu
values ('2', '1018');
insert into sys_role_menu
values ('2', '1019');
insert into sys_role_menu
values ('2', '1020');
insert into sys_role_menu
values ('2', '1021');
insert into sys_role_menu
values ('2', '1022');
insert into sys_role_menu
values ('2', '1023');
insert into sys_role_menu
values ('2', '1024');
insert into sys_role_menu
values ('2', '1025');
insert into sys_role_menu
values ('2', '1026');
insert into sys_role_menu
values ('2', '1027');
insert into sys_role_menu
values ('2', '1028');
insert into sys_role_menu
values ('2', '1029');
insert into sys_role_menu
values ('2', '1030');
insert into sys_role_menu
values ('2', '1031');
insert into sys_role_menu
values ('2', '1032');
insert into sys_role_menu
values ('2', '1033');
insert into sys_role_menu
values ('2', '1034');
insert into sys_role_menu
values ('2', '1035');
insert into sys_role_menu
values ('2', '1036');
insert into sys_role_menu
values ('2', '1037');
insert into sys_role_menu
values ('2', '1038');
insert into sys_role_menu
values ('2', '1039');
insert into sys_role_menu
values ('2', '1040');
insert into sys_role_menu
values ('2', '1041');
insert into sys_role_menu
values ('2', '1042');
insert into sys_role_menu
values ('2', '1043');
insert into sys_role_menu
values ('2', '1044');
insert into sys_role_menu
values ('2', '1045');
insert into sys_role_menu
values ('2', '1046');
insert into sys_role_menu
values ('2', '1047');
insert into sys_role_menu
values ('2', '1048');
insert into sys_role_menu
values ('2', '1049');
insert into sys_role_menu
values ('2', '1050');
insert into sys_role_menu
values ('2', '1051');
insert into sys_role_menu
values ('2', '1052');
insert into sys_role_menu
values ('2', '1053');
insert into sys_role_menu
values ('2', '1054');
insert into sys_role_menu
values ('2', '1055');
insert into sys_role_menu
values ('2', '1056');
insert into sys_role_menu
values ('2', '1057');
insert into sys_role_menu
values ('2', '1058');
insert into sys_role_menu
values ('2', '1059');
insert into sys_role_menu
values ('2', '1060');

-- ----------------------------
-- 8、角色和部门关联表  角色1-N部门
-- ----------------------------
drop table if exists sys_role_dept;
create table sys_role_dept
(
    role_id bigint(20) not null comment '角色ID',
    dept_id bigint(20) not null comment '部门ID',
    primary key (role_id, dept_id)
) engine = innodb comment = '角色和部门关联表';

-- ----------------------------
-- 初始化-角色和部门关联表数据
-- ----------------------------
insert into sys_role_dept
values ('2', '100');
insert into sys_role_dept
values ('2', '101');
insert into sys_role_dept
values ('2', '105');


-- ----------------------------
-- 9、用户与岗位关联表  用户1-N岗位
-- ----------------------------
drop table if exists sys_user_post;
create table sys_user_post
(
    user_id bigint(20) not null comment '用户ID',
    post_id bigint(20) not null comment '岗位ID',
    primary key (user_id, post_id)
) engine = innodb comment = '用户与岗位关联表';

-- ----------------------------
-- 初始化-用户与岗位关联表数据
-- ----------------------------
insert into sys_user_post
values ('1', '1');
insert into sys_user_post
values ('2', '2');


-- ----------------------------
-- 10、操作日志记录
-- ----------------------------
drop table if exists sys_oper_log;
create table sys_oper_log
(
    oper_id        bigint(20) not null auto_increment comment '日志主键',
    title          varchar(50)   default '' comment '模块标题',
    business_type  int(2)        default 0 comment '业务类型（0其它 1新增 2修改 3删除）',
    method         varchar(100)  default '' comment '方法名称',
    request_method varchar(10)   default '' comment '请求方式',
    operator_type  int(1)        default 0 comment '操作类别（0其它 1后台用户 2手机端用户）',
    oper_name      varchar(50)   default '' comment '操作人员',
    dept_name      varchar(50)   default '' comment '部门名称',
    oper_url       varchar(255)  default '' comment '请求URL',
    oper_ip        varchar(128)  default '' comment '主机地址',
    oper_location  varchar(255)  default '' comment '操作地点',
    oper_param     varchar(2000) default '' comment '请求参数',
    json_result    varchar(2000) default '' comment '返回参数',
    status         int(1)        default 0 comment '操作状态（0正常 1异常）',
    error_msg      varchar(2000) default '' comment '错误消息',
    oper_time      datetime comment '操作时间',
    cost_time      bigint(20)    default 0 comment '消耗时间',
    primary key (oper_id),
    key idx_sys_oper_log_bt (business_type),
    key idx_sys_oper_log_s (status),
    key idx_sys_oper_log_ot (oper_time)
) engine = innodb
  auto_increment = 100 comment = '操作日志记录';


-- ----------------------------
-- 11、字典类型表
-- ----------------------------
drop table if exists sys_dict_type;
create table sys_dict_type
(
    dict_id     bigint(20) not null auto_increment comment '字典主键',
    dict_name   varchar(100) default '' comment '字典名称',
    dict_type   varchar(100) default '' comment '字典类型',
    status      char(1)      default '0' comment '状态（0正常 1停用）',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (dict_id),
    unique (dict_type)
) engine = innodb
  auto_increment = 100 comment = '字典类型表';

insert into sys_dict_type
values (1, '用户性别', 'sys_user_sex', '0', 'admin', sysdate(), '', null, '用户性别列表');
insert into sys_dict_type
values (2, '菜单状态', 'sys_show_hide', '0', 'admin', sysdate(), '', null, '菜单状态列表');
insert into sys_dict_type
values (3, '系统开关', 'sys_normal_disable', '0', 'admin', sysdate(), '', null, '系统开关列表');
insert into sys_dict_type
values (4, '任务状态', 'sys_job_status', '0', 'admin', sysdate(), '', null, '任务状态列表');
insert into sys_dict_type
values (5, '任务分组', 'sys_job_group', '0', 'admin', sysdate(), '', null, '任务分组列表');
insert into sys_dict_type
values (6, '系统是否', 'sys_yes_no', '0', 'admin', sysdate(), '', null, '系统是否列表');
insert into sys_dict_type
values (7, '通知类型', 'sys_notice_type', '0', 'admin', sysdate(), '', null, '通知类型列表');
insert into sys_dict_type
values (8, '通知状态', 'sys_notice_status', '0', 'admin', sysdate(), '', null, '通知状态列表');
insert into sys_dict_type
values (9, '操作类型', 'sys_oper_type', '0', 'admin', sysdate(), '', null, '操作类型列表');
insert into sys_dict_type
values (10, '系统状态', 'sys_common_status', '0', 'admin', sysdate(), '', null, '登录状态列表');


-- ----------------------------
-- 12、字典数据表
-- ----------------------------
drop table if exists sys_dict_data;
create table sys_dict_data
(
    dict_code   bigint(20) not null auto_increment comment '字典编码',
    dict_sort   int(4)       default 0 comment '字典排序',
    dict_label  varchar(100) default '' comment '字典标签',
    dict_value  varchar(100) default '' comment '字典键值',
    dict_type   varchar(100) default '' comment '字典类型',
    css_class   varchar(100) default null comment '样式属性（其他样式扩展）',
    list_class  varchar(100) default null comment '表格回显样式',
    is_default  char(1)      default 'N' comment '是否默认（Y是 N否）',
    status      char(1)      default '0' comment '状态（0正常 1停用）',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (dict_code)
) engine = innodb
  auto_increment = 100 comment = '字典数据表';

insert into sys_dict_data
values (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', sysdate(), '', null, '性别男');
insert into sys_dict_data
values (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', sysdate(), '', null, '性别女');
insert into sys_dict_data
values (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', sysdate(), '', null, '性别未知');
insert into sys_dict_data
values (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '显示菜单');
insert into sys_dict_data
values (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '隐藏菜单');
insert into sys_dict_data
values (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data
values (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '停用状态');
insert into sys_dict_data
values (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data
values (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '停用状态');
insert into sys_dict_data
values (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', sysdate(), '', null, '默认分组');
insert into sys_dict_data
values (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', sysdate(), '', null, '系统分组');
insert into sys_dict_data
values (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '系统默认是');
insert into sys_dict_data
values (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '系统默认否');
insert into sys_dict_data
values (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', sysdate(), '', null, '通知');
insert into sys_dict_data
values (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', sysdate(), '', null, '公告');
insert into sys_dict_data
values (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data
values (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '关闭状态');
insert into sys_dict_data
values (18, 99, '其他', '0', 'sys_oper_type', '', 'info', 'N', '0', 'admin', sysdate(), '', null, '其他操作');
insert into sys_dict_data
values (19, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', sysdate(), '', null, '新增操作');
insert into sys_dict_data
values (20, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', sysdate(), '', null, '修改操作');
insert into sys_dict_data
values (21, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '删除操作');
insert into sys_dict_data
values (22, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', sysdate(), '', null, '授权操作');
insert into sys_dict_data
values (23, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', sysdate(), '', null, '导出操作');
insert into sys_dict_data
values (24, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', sysdate(), '', null, '导入操作');
insert into sys_dict_data
values (25, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '强退操作');
insert into sys_dict_data
values (26, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', sysdate(), '', null, '生成操作');
insert into sys_dict_data
values (27, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '清空操作');
insert into sys_dict_data
values (28, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data
values (29, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '停用状态');


-- ----------------------------
-- 13、参数配置表
-- ----------------------------
drop table if exists sys_config;
create table sys_config
(
    config_id    int(5) not null auto_increment comment '参数主键',
    config_name  varchar(100) default '' comment '参数名称',
    config_key   varchar(100) default '' comment '参数键名',
    config_value varchar(500) default '' comment '参数键值',
    config_type  char(1)      default 'N' comment '系统内置（Y是 N否）',
    create_by    varchar(64)  default '' comment '创建者',
    create_time  datetime comment '创建时间',
    update_by    varchar(64)  default '' comment '更新者',
    update_time  datetime comment '更新时间',
    remark       varchar(500) default null comment '备注',
    primary key (config_id)
) engine = innodb
  auto_increment = 100 comment = '参数配置表';

insert into sys_config
values (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', sysdate(), '', null,
        '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
insert into sys_config
values (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', sysdate(), '', null,
        '初始化密码 123456');
insert into sys_config
values (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', sysdate(), '', null,
        '深色主题theme-dark，浅色主题theme-light');
insert into sys_config
values (4, '账号自助-验证码开关', 'sys.account.captchaEnabled', 'true', 'Y', 'admin', sysdate(), '', null,
        '是否开启验证码功能（true开启，false关闭）');
insert into sys_config
values (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', sysdate(), '', null,
        '是否开启注册用户功能（true开启，false关闭）');
insert into sys_config
values (6, '用户登录-黑名单列表', 'sys.login.blackIPList', '', 'Y', 'admin', sysdate(), '', null,
        '设置登录IP黑名单限制，多个匹配项以;分隔，支持匹配（*通配、网段）');


-- ----------------------------
-- 14、系统访问记录
-- ----------------------------
drop table if exists sys_logininfor;
create table sys_logininfor
(
    info_id        bigint(20) not null auto_increment comment '访问ID',
    user_name      varchar(50)  default '' comment '用户账号',
    ipaddr         varchar(128) default '' comment '登录IP地址',
    login_location varchar(255) default '' comment '登录地点',
    browser        varchar(50)  default '' comment '浏览器类型',
    os             varchar(50)  default '' comment '操作系统',
    status         char(1)      default '0' comment '登录状态（0成功 1失败）',
    msg            varchar(255) default '' comment '提示消息',
    login_time     datetime comment '访问时间',
    primary key (info_id),
    key idx_sys_logininfor_s (status),
    key idx_sys_logininfor_lt (login_time)
) engine = innodb
  auto_increment = 100 comment = '系统访问记录';


-- ----------------------------
-- 15、定时任务调度表
-- ----------------------------
drop table if exists sys_job;
create table sys_job
(
    job_id          bigint(20)   not null auto_increment comment '任务ID',
    job_name        varchar(64)  default '' comment '任务名称',
    job_group       varchar(64)  default 'DEFAULT' comment '任务组名',
    invoke_target   varchar(500) not null comment '调用目标字符串',
    cron_expression varchar(255) default '' comment 'cron执行表达式',
    misfire_policy  varchar(20)  default '3' comment '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
    concurrent      char(1)      default '1' comment '是否并发执行（0允许 1禁止）',
    status          char(1)      default '0' comment '状态（0正常 1暂停）',
    create_by       varchar(64)  default '' comment '创建者',
    create_time     datetime comment '创建时间',
    update_by       varchar(64)  default '' comment '更新者',
    update_time     datetime comment '更新时间',
    remark          varchar(500) default '' comment '备注信息',
    primary key (job_id, job_name, job_group)
) engine = innodb
  auto_increment = 100 comment = '定时任务调度表';

insert into sys_job
values (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', sysdate(), '',
        null, '');
insert into sys_job
values (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', sysdate(),
        '', null, '');
insert into sys_job
values (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?',
        '3', '1', '1', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 16、定时任务调度日志表
-- ----------------------------
drop table if exists sys_job_log;
create table sys_job_log
(
    job_log_id     bigint(20)   not null auto_increment comment '任务日志ID',
    job_name       varchar(64)  not null comment '任务名称',
    job_group      varchar(64)  not null comment '任务组名',
    invoke_target  varchar(500) not null comment '调用目标字符串',
    job_message    varchar(500) comment '日志信息',
    status         char(1)       default '0' comment '执行状态（0正常 1失败）',
    exception_info varchar(2000) default '' comment '异常信息',
    create_time    datetime comment '创建时间',
    primary key (job_log_id)
) engine = innodb comment = '定时任务调度日志表';


-- ----------------------------
-- 17、通知公告表
-- ----------------------------
drop table if exists sys_notice;
create table sys_notice
(
    notice_id      int(4)      not null auto_increment comment '公告ID',
    notice_title   varchar(50) not null comment '公告标题',
    notice_type    char(1)     not null comment '公告类型（1通知 2公告）',
    notice_content longblob     default null comment '公告内容',
    status         char(1)      default '0' comment '公告状态（0正常 1关闭）',
    create_by      varchar(64)  default '' comment '创建者',
    create_time    datetime comment '创建时间',
    update_by      varchar(64)  default '' comment '更新者',
    update_time    datetime comment '更新时间',
    remark         varchar(255) default null comment '备注',
    primary key (notice_id)
) engine = innodb
  auto_increment = 10 comment = '通知公告表';

-- ----------------------------
-- 初始化-公告信息表数据
-- ----------------------------
insert into sys_notice
values ('1', '温馨提醒：2018-07-01 若依新版本发布啦', '2', '新版本内容', '0', 'admin', sysdate(), '', null, '管理员');
insert into sys_notice
values ('2', '维护通知：2018-07-01 若依系统凌晨维护', '1', '维护内容', '0', 'admin', sysdate(), '', null, '管理员');


-- ----------------------------
-- 18、代码生成业务表
-- ----------------------------
drop table if exists gen_table;
create table gen_table
(
    table_id          bigint(20) not null auto_increment comment '编号',
    table_name        varchar(200) default '' comment '表名称',
    table_comment     varchar(500) default '' comment '表描述',
    sub_table_name    varchar(64)  default null comment '关联子表的表名',
    sub_table_fk_name varchar(64)  default null comment '子表关联的外键名',
    class_name        varchar(100) default '' comment '实体类名称',
    tpl_category      varchar(200) default 'crud' comment '使用的模板（crud单表操作 tree树表操作）',
    package_name      varchar(100) comment '生成包路径',
    module_name       varchar(30) comment '生成模块名',
    business_name     varchar(30) comment '生成业务名',
    function_name     varchar(50) comment '生成功能名',
    function_author   varchar(50) comment '生成功能作者',
    gen_type          char(1)      default '0' comment '生成代码方式（0zip压缩包 1自定义路径）',
    gen_path          varchar(200) default '/' comment '生成路径（不填默认项目路径）',
    options           varchar(1000) comment '其它生成选项',
    create_by         varchar(64)  default '' comment '创建者',
    create_time       datetime comment '创建时间',
    update_by         varchar(64)  default '' comment '更新者',
    update_time       datetime comment '更新时间',
    remark            varchar(500) default null comment '备注',
    primary key (table_id)
) engine = innodb
  auto_increment = 1 comment = '代码生成业务表';


-- ----------------------------
-- 19、代码生成业务表字段
-- ----------------------------
drop table if exists gen_table_column;
create table gen_table_column
(
    column_id      bigint(20) not null auto_increment comment '编号',
    table_id       varchar(64) comment '归属表编号',
    column_name    varchar(200) comment '列名称',
    column_comment varchar(500) comment '列描述',
    column_type    varchar(100) comment '列类型',
    java_type      varchar(500) comment 'JAVA类型',
    java_field     varchar(200) comment 'JAVA字段名',
    is_pk          char(1) comment '是否主键（1是）',
    is_increment   char(1) comment '是否自增（1是）',
    is_required    char(1) comment '是否必填（1是）',
    is_insert      char(1) comment '是否为插入字段（1是）',
    is_edit        char(1) comment '是否编辑字段（1是）',
    is_list        char(1) comment '是否列表字段（1是）',
    is_query       char(1) comment '是否查询字段（1是）',
    query_type     varchar(200) default 'EQ' comment '查询方式（等于、不等于、大于、小于、范围）',
    html_type      varchar(200) comment '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
    dict_type      varchar(200) default '' comment '字典类型',
    sort           int comment '排序',
    create_by      varchar(64)  default '' comment '创建者',
    create_time    datetime comment '创建时间',
    update_by      varchar(64)  default '' comment '更新者',
    update_time    datetime comment '更新时间',
    primary key (column_id)
) engine = innodb
  auto_increment = 1 comment = '代码生成业务表字段';


# ---------------------------------------

#  业务功能

# 业务表 TODO
-- 成绩
# DROP TABLE IF EXISTS `course_score`;
# CREATE TABLE `course_score`
# (
#     `id`          BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
#     `user_id`     varchar(255)        NOT NULL COMMENT '关联学生id',
#     `course_name` varchar(255)        NOT NULL COMMENT '课程名称',
#     ·degree·      DECIMAL             NOT NULL COMMENT '课程成绩',
#     `status`      CHAR(1)    DEFAULT '0' COMMENT '成绩状态状态 (0正常，1毕业)',
#     `create_by`   BIGINT(20) DEFAULT NULL COMMENT '创建者',
#     `create_time` DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#     `update_by`   BIGINT(20) DEFAULT NULL COMMENT '更新者',
#     `update_time` DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
#     PRIMARY KEY (`id`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8mb4 COMMENT ='成绩表';

-- 自助审批事件(离校申请)
DROP TABLE IF EXISTS `sys_event`;
CREATE TABLE `sys_event`
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
DROP TABLE IF EXISTS `sys_zone`;
CREATE TABLE `sys_zone`
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

# 圈子
INSERT INTO classdesign.sys_zone (title, content, sponsor_id, sponsor, status, del_flag, create_by, create_time, update_by,
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
# 广播消息 message TODO
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message`
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

#  数据
INSERT
INTO classdesign.sys_message (author, title, subject, status, del_flag, create_by, create_time, update_by,
                              update_time, remark)
VALUES (20223035104, '测试', '51放假通知', DEFAULT, DEFAULT, 20223035104, DEFAULT, 20223035104, DEFAULT, null);




DROP TABLE IF EXISTS `sys_chats`;
CREATE TABLE `sys_chats`
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

# 添加一个群聊
INSERT INTO classdesign.sys_chats (gid, room_name, room_description, subject, status, del_flag, create_by, create_time,
                               update_by, update_time, remark)
VALUES (10000000, '测试群聊', '正在开发一个群聊功能', null, DEFAULT, DEFAULT, 0, DEFAULT, 0, DEFAULT, '测试中');

# 关联聊天室的聊天内容
DROP TABLE IF EXISTS `sys_chats_content`;
CREATE TABLE `sys_chats_content`
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

# 聊天记录
INSERT INTO classdesign.sys_chats_content (cid, from_user_id, subject, status, del_flag, create_by, create_time, update_by,
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

# 健康消息上报
DROP TABLE IF EXISTS `sys_health_report`;
CREATE TABLE `sys_health_report`
(
    `id`          BIGINT(20)                                              NOT NULL AUTO_INCREMENT COMMENT '广播ID',
    `sponsor_id`  BIGINT(200)                                             NOT NULL DEFAULT '0' COMMENT '申报用户ID',
    `sponsor`     varchar(255)                                            NOT NULL COMMENT '发布人姓名',
    `title`       varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '申报主题',
    `subject`     varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '申报内容',
    `status`      CHAR(1)                                                          DEFAULT '0' COMMENT '申报状态（0正常 1停用）',
    `del_flag`    CHAR(1)                                                          DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `health_type` CHAR(1)                                                          DEFAULT '0' COMMENT '健康状态（0健康 1生病 2新冠 3流感 4其它）',
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

#  每日健康消息上报
INSERT INTO classdesign.sys_health_report (sponsor_id, sponsor, title, subject, status, del_flag, create_by, create_time,
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
        '2023-05-31 00:16:28', 20223035104, '2023-05-31 00:16:28', '每日健康信息上报');



# ruoyi QRTZ

DROP TABLE IF EXISTS QRTZ_FIRED_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_PAUSED_TRIGGER_GRPS;
DROP TABLE IF EXISTS QRTZ_SCHEDULER_STATE;
DROP TABLE IF EXISTS QRTZ_LOCKS;
DROP TABLE IF EXISTS QRTZ_SIMPLE_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_SIMPROP_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_CRON_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_BLOB_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_JOB_DETAILS;
DROP TABLE IF EXISTS QRTZ_CALENDARS;

-- ----------------------------
-- 1、存储每一个已配置的 jobDetail 的详细信息
-- ----------------------------
create table QRTZ_JOB_DETAILS
(
    sched_name        varchar(120) not null comment '调度名称',
    job_name          varchar(200) not null comment '任务名称',
    job_group         varchar(200) not null comment '任务组名',
    description       varchar(250) null comment '相关介绍',
    job_class_name    varchar(250) not null comment '执行任务类名称',
    is_durable        varchar(1)   not null comment '是否持久化',
    is_nonconcurrent  varchar(1)   not null comment '是否并发',
    is_update_data    varchar(1)   not null comment '是否更新数据',
    requests_recovery varchar(1)   not null comment '是否接受恢复执行',
    job_data          blob         null comment '存放持久化job对象',
    primary key (sched_name, job_name, job_group)
) engine = innodb comment = '任务详细信息表';

-- ----------------------------
-- 2、 存储已配置的 Trigger 的信息
-- ----------------------------
create table QRTZ_TRIGGERS
(
    sched_name     varchar(120) not null comment '调度名称',
    trigger_name   varchar(200) not null comment '触发器的名字',
    trigger_group  varchar(200) not null comment '触发器所属组的名字',
    job_name       varchar(200) not null comment 'qrtz_job_details表job_name的外键',
    job_group      varchar(200) not null comment 'qrtz_job_details表job_group的外键',
    description    varchar(250) null comment '相关介绍',
    next_fire_time bigint(13)   null comment '上一次触发时间（毫秒）',
    prev_fire_time bigint(13)   null comment '下一次触发时间（默认为-1表示不触发）',
    priority       integer      null comment '优先级',
    trigger_state  varchar(16)  not null comment '触发器状态',
    trigger_type   varchar(8)   not null comment '触发器的类型',
    start_time     bigint(13)   not null comment '开始时间',
    end_time       bigint(13)   null comment '结束时间',
    calendar_name  varchar(200) null comment '日程表名称',
    misfire_instr  smallint(2)  null comment '补偿执行的策略',
    job_data       blob         null comment '存放持久化job对象',
    primary key (sched_name, trigger_name, trigger_group),
    foreign key (sched_name, job_name, job_group) references QRTZ_JOB_DETAILS (sched_name, job_name, job_group)
) engine = innodb comment = '触发器详细信息表';

-- ----------------------------
-- 3、 存储简单的 Trigger，包括重复次数，间隔，以及已触发的次数
-- ----------------------------
create table QRTZ_SIMPLE_TRIGGERS
(
    sched_name      varchar(120) not null comment '调度名称',
    trigger_name    varchar(200) not null comment 'qrtz_triggers表trigger_name的外键',
    trigger_group   varchar(200) not null comment 'qrtz_triggers表trigger_group的外键',
    repeat_count    bigint(7)    not null comment '重复的次数统计',
    repeat_interval bigint(12)   not null comment '重复的间隔时间',
    times_triggered bigint(10)   not null comment '已经触发的次数',
    primary key (sched_name, trigger_name, trigger_group),
    foreign key (sched_name, trigger_name, trigger_group) references QRTZ_TRIGGERS (sched_name, trigger_name, trigger_group)
) engine = innodb comment = '简单触发器的信息表';

-- ----------------------------
-- 4、 存储 Cron Trigger，包括 Cron 表达式和时区信息
-- ----------------------------
create table QRTZ_CRON_TRIGGERS
(
    sched_name      varchar(120) not null comment '调度名称',
    trigger_name    varchar(200) not null comment 'qrtz_triggers表trigger_name的外键',
    trigger_group   varchar(200) not null comment 'qrtz_triggers表trigger_group的外键',
    cron_expression varchar(200) not null comment 'cron表达式',
    time_zone_id    varchar(80) comment '时区',
    primary key (sched_name, trigger_name, trigger_group),
    foreign key (sched_name, trigger_name, trigger_group) references QRTZ_TRIGGERS (sched_name, trigger_name, trigger_group)
) engine = innodb comment = 'Cron类型的触发器表';

-- ----------------------------
-- 5、 Trigger 作为 Blob 类型存储(用于 Quartz 用户用 JDBC 创建他们自己定制的 Trigger 类型，JobStore 并不知道如何存储实例的时候)
-- ----------------------------
create table QRTZ_BLOB_TRIGGERS
(
    sched_name    varchar(120) not null comment '调度名称',
    trigger_name  varchar(200) not null comment 'qrtz_triggers表trigger_name的外键',
    trigger_group varchar(200) not null comment 'qrtz_triggers表trigger_group的外键',
    blob_data     blob         null comment '存放持久化Trigger对象',
    primary key (sched_name, trigger_name, trigger_group),
    foreign key (sched_name, trigger_name, trigger_group) references QRTZ_TRIGGERS (sched_name, trigger_name, trigger_group)
) engine = innodb comment = 'Blob类型的触发器表';

-- ----------------------------
-- 6、 以 Blob 类型存储存放日历信息， quartz可配置一个日历来指定一个时间范围
-- ----------------------------
create table QRTZ_CALENDARS
(
    sched_name    varchar(120) not null comment '调度名称',
    calendar_name varchar(200) not null comment '日历名称',
    calendar      blob         not null comment '存放持久化calendar对象',
    primary key (sched_name, calendar_name)
) engine = innodb comment = '日历信息表';

-- ----------------------------
-- 7、 存储已暂停的 Trigger 组的信息
-- ----------------------------
create table QRTZ_PAUSED_TRIGGER_GRPS
(
    sched_name    varchar(120) not null comment '调度名称',
    trigger_group varchar(200) not null comment 'qrtz_triggers表trigger_group的外键',
    primary key (sched_name, trigger_group)
) engine = innodb comment = '暂停的触发器表';

-- ----------------------------
-- 8、 存储与已触发的 Trigger 相关的状态信息，以及相联 Job 的执行信息
-- ----------------------------
create table QRTZ_FIRED_TRIGGERS
(
    sched_name        varchar(120) not null comment '调度名称',
    entry_id          varchar(95)  not null comment '调度器实例id',
    trigger_name      varchar(200) not null comment 'qrtz_triggers表trigger_name的外键',
    trigger_group     varchar(200) not null comment 'qrtz_triggers表trigger_group的外键',
    instance_name     varchar(200) not null comment '调度器实例名',
    fired_time        bigint(13)   not null comment '触发的时间',
    sched_time        bigint(13)   not null comment '定时器制定的时间',
    priority          integer      not null comment '优先级',
    state             varchar(16)  not null comment '状态',
    job_name          varchar(200) null comment '任务名称',
    job_group         varchar(200) null comment '任务组名',
    is_nonconcurrent  varchar(1)   null comment '是否并发',
    requests_recovery varchar(1)   null comment '是否接受恢复执行',
    primary key (sched_name, entry_id)
) engine = innodb comment = '已触发的触发器表';

-- ----------------------------
-- 9、 存储少量的有关 Scheduler 的状态信息，假如是用于集群中，可以看到其他的 Scheduler 实例
-- ----------------------------
create table QRTZ_SCHEDULER_STATE
(
    sched_name        varchar(120) not null comment '调度名称',
    instance_name     varchar(200) not null comment '实例名称',
    last_checkin_time bigint(13)   not null comment '上次检查时间',
    checkin_interval  bigint(13)   not null comment '检查间隔时间',
    primary key (sched_name, instance_name)
) engine = innodb comment = '调度器状态表';

-- ----------------------------
-- 10、 存储程序的悲观锁的信息(假如使用了悲观锁)
-- ----------------------------
create table QRTZ_LOCKS
(
    sched_name varchar(120) not null comment '调度名称',
    lock_name  varchar(40)  not null comment '悲观锁名称',
    primary key (sched_name, lock_name)
) engine = innodb comment = '存储的悲观锁信息表';

-- ----------------------------
-- 11、 Quartz集群实现同步机制的行锁表
-- ----------------------------
create table QRTZ_SIMPROP_TRIGGERS
(
    sched_name    varchar(120)   not null comment '调度名称',
    trigger_name  varchar(200)   not null comment 'qrtz_triggers表trigger_name的外键',
    trigger_group varchar(200)   not null comment 'qrtz_triggers表trigger_group的外键',
    str_prop_1    varchar(512)   null comment 'String类型的trigger的第一个参数',
    str_prop_2    varchar(512)   null comment 'String类型的trigger的第二个参数',
    str_prop_3    varchar(512)   null comment 'String类型的trigger的第三个参数',
    int_prop_1    int            null comment 'int类型的trigger的第一个参数',
    int_prop_2    int            null comment 'int类型的trigger的第二个参数',
    long_prop_1   bigint         null comment 'long类型的trigger的第一个参数',
    long_prop_2   bigint         null comment 'long类型的trigger的第二个参数',
    dec_prop_1    numeric(13, 4) null comment 'decimal类型的trigger的第一个参数',
    dec_prop_2    numeric(13, 4) null comment 'decimal类型的trigger的第二个参数',
    bool_prop_1   varchar(1)     null comment 'Boolean类型的trigger的第一个参数',
    bool_prop_2   varchar(1)     null comment 'Boolean类型的trigger的第二个参数',
    primary key (sched_name, trigger_name, trigger_group),
    foreign key (sched_name, trigger_name, trigger_group) references QRTZ_TRIGGERS (sched_name, trigger_name, trigger_group)
) engine = innodb comment = '同步机制的行锁表';

commit;

