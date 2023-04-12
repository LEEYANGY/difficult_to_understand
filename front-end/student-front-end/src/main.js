import {createApp} from 'vue'
// 原装css害人不浅啊
// import './style.css'
import App from './App.vue'
import router from "./router";
import store from "./store/index.js";

// import 'amfe-flexible'
// import 'postcss'

// 1. 引入你需要的组件
import Vant from 'vant'
// 底部导航栏
import {NavBar, Tabbar, TabbarItem, List, PullRefresh, Notify, showNotify, BackTop} from 'vant';
// 2. 引入组件样式
import 'vant/lib/index.css';
import './api/axios'

import {createPinia} from "pinia";

createApp(App)
    .use(Vant, NavBar, Tabbar, TabbarItem, List, PullRefresh, Notify, showNotify, BackTop)
    .use(router).use(createPinia())
    .mount('#app')
