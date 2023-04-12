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

// 创建规则
const routes = [
    {
        path: "/",
        name: "home",
        // redirect: "/",
        component: () => import("../views/Home.vue"),
        title: '主页',
        meta: {},
        // children: [
        //     {
        //         path: 'detail/:id',
        //         name: 'detail',
        //         component: () => import("../components/zone/Detail.vue"),
        //         meta: {},
        //     }
        // ],
    },
    {
        path: '/user',
        name: "user",
        component: () => import("../views/User.vue"),
        title: '用户管理',
        meta: {},
        // children: [
        //     // {
        //     //     // 当 /user/:id/profile 匹配成功
        //     //     // UserProfile 将被渲染到 User 的 <router-view> 内部
        //     //     path: '/login',
        //     //     name: 'login',
        //     //     component: () => import("../components/manager/Login.vue"),
        //     // },
        //     {
        //         // 当 /user/:id/posts 匹配成功
        //         // UserPosts 将被渲染到 User 的 <router-view> 内部
        //         path: 'login',
        //         component: () => import("../views/Login.vue"),
        //     },
        // ],
    },
    {
        path: '/login',
        name: "login",
        component: () => import("../views/Login.vue"),
        title: '登录',
        meta: {},
    },
    {
        path: "/catalog",
        name: "catalog",
        component: () => import("../views/Catalog.vue"),
        title: '学校专栏',
        meta: {},
    },
    {
        path: '/other',
        name: 'other',
        component: () => import("../views/Other.vue"),
    }
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
