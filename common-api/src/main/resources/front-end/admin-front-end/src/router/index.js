// 引入路由组件
import {createRouter, createWebHashHistory} from "vue-router";

// 创建规则
const routes = [
    {
        path: "/",
        name: "home",
        // redirect: "/",
        component: () => import("../views/Home/Home.vue"),
        title: '主页',
        meta: {},
        children: [
            // 子路由1 获取动态详细内容
            {
                path: '/detail/:id',
                name: 'detail',
                component: () => import("../components/Zone/Detail.vue"),
                meta: {
                    title: '动态详情'
                },

            },
            // 子路由2 修改动态内容
            {
                path: '/edit/:id',
                name: 'edit',
                component: () => import("../components/Zone/Edit.vue"),
                meta: {
                    title: '修改动态内容'
                }
            },
        ],
    },
    // 校园专区
    {
        path: "/hm",
        name: "hm",
        component: () => import("../views/Catalog/HealthManage.vue"),
        title: '学校专栏',
        meta: {},
        children: [
            // 编辑功能
            {
                path: '/health/:id',
                name: 'health',
                component: () => import("../components/health/Health.vue"),
                meta: {
                    title: '动态详情'
                },
            },
        ],
    },
    {
        path: "/am",
        name: "am",
        component: () => import("../views/Catalog/ApplyManage.vue"),
        title: '学校专栏',
        meta: {},
        children: [
            // 子路由1 获取动态详细内容
            {
                path: '/recordDetail/:id',
                name: 'recordDetail',
                component: () => import("../components/manager/RecordDetail.vue"),
                meta: {
                    title: '动态详情'
                },

            },
            // 子路由2 修改动态内容
            // {
            //     path: '/healthEdit/:id',
            //     name: 'healthEdit',
            //     component: () => import("../components/manager/Approval.vue"),
            //     meta: {
            //         title: '修改动态内容'
            //     }
            // },
        ],
    },
    // 用户专区
    {
        path: '/user',
        name: "user",
        component: () => import("../views/User/User.vue"),
        title: '用户管理',
        meta: {},
        children: [
            {
                path: '/user/login',
                name: "login",
                component: () => import("../components/manager/Login.vue"),
                title: '登录',
                meta: {},

            },
            {
                path: '/nm',
                name: 'nm',
                component:()=>import('../views/Catalog/NoticeManage.vue'),
                children: [
                    {
                        path: '/noticeDetail/:id',
                        name: 'noticeDetail',
                        component:()=>import('../components/notice/Detail.vue')
                    }
                ]
            }
        ],
    },
    {
        path: '/um',
        name: "um",
        component: () => import("../views/User/UserManage.vue"),
        title: '用户管理',
        meta: {},
        children: [
            {
                path: '/um/:userId',
                name: 'userprofile',
                component: () => import('../components/user/UserInfo.vue')
            },
        ]
    },
];

// 创建路由实例
const router = createRouter({
    // 创建createWebHistory
    history: createWebHashHistory(),
    // 使用路由规则
    routes,
});

// 全局前置守卫，这里可以加入用户登录判断
// router.beforeEach((to, from, next) => {
//     // 继续前进 next()
//     // 返回 false 以取消导航
//     next()
// });

// 全局后置钩子，这里可以加入改变页面标题等操作
// router.afterEach((to, from) => {
//     const _title = to.meta.title
//     if (_title) {
//         window.document.title = _title
//     }
// });

export default router;
// 创建登录组件

// 指定出口
