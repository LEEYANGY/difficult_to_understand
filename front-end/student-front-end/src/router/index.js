// import {createRouter, createWebHashHistory} from 'vue-router'
//
// // const route = VueRouter.createRouter({
// //     // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
// //     history: VueRouter.createWebHashHistory(),
// //     routes, // `routes: routes` 的缩写
// // })
//
// // export default route
// // 1. 定义路由组件.
// // 也可以从其他文件导入
// const Home = { template: '<div>Home</div>' }
// const About = { template: '<div>About</div>' }
//
// // 2. 定义一些路由
// // 每个路由都需要映射到一个组件。
// // 我们后面再讨论嵌套路由。
// const routes = [
//     { path: '/', component: Home },
//     { path: '/about', component: About },
// ]
//
// // 3. 创建路由实例并传递 `routes` 配置
// // 你可以在这里输入更多的配置，但我们在这里
// // 暂时保持简单
// const router = VueRouter.createRouter({
//     // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
//     history: VueRouter.createWebHashHistory(),
//     routes, // `routes: routes` 的缩写
// })
//
// // 5. 创建并挂载根实例
// const app = Vue.createApp({})
// //确保 _use_ 路由实例使
// //整个应用支持路由。
// app.use(router)
//
// app.mount('#app')
//
// // 现在，应用已经启动了！

// 引入路由组件
import {createRouter, createWebHashHistory} from "vue-router";
import approval from "../views/Catalog/Cafe/Approval.vue";
import im from "../views/Catalog/IM/Im.vue";
import Health from "../views/Catalog/Cafe/Health.vue";

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
        path: "/catalog",
        name: "catalog",
        component: () => import("../views/Catalog/Catalog.vue"),
        title: '学校专栏',
        meta: {},
        children: [
            {
                path: 'myzone',
                name: 'myzone',
                component: () => import ('../components/Zone/MyZone.vue'),
            },
            // 子路1 聊天
            {
                path: '/im/:userId',
                name: 'im',
                component: () => import('../views/Catalog/IM/Im.vue')
            },
            // 子路由2 自助申请
            {
                path: '/post/approval/:userId',
                name: 'approval',
                component: approval,
            },
            // 申请记录查询
            {
                path: 'myCafeRecord',
                name: 'myCafeRecord',
                component: () => import('../views/Catalog/Cafe/Record/MyCafeRecord.vue'),
            },
            {
                path: '/recordDetail/:id',
                name: 'recordDetail',
                component: () => import('../views/Catalog/Cafe/Record/RecordDetail.vue'),
            },
            // 健康上报
            {
                path: '/post/health/:userId',
                name: 'health',
                component: Health,
            }
        ]
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
                path: '/user/:userId',
                name: 'userprofile',
                component: () => import('../components/manager/UserInfo.vue')
            }
        ],
    },

    // 调试页面
    {
        path: '/other',
        name: 'other',
        component: () => import("../views/Other.vue"),
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
