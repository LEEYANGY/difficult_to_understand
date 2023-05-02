import {createApp} from 'vue'
import App from './App.vue'
import router from "./router";

// 1. 引入你需要的组件
import Vant from 'vant'
// 底部导航栏
import {NavBar, Tabbar, TabbarItem, List, PullRefresh, Notify, showNotify, BackTop} from 'vant';
// 2. 引入组件样式
import 'vant/lib/index.css';
import './api/axios'

// pinia
import {createPinia} from "pinia";

const store = createPinia();

createApp(App)
    .use(Vant, NavBar, Tabbar, TabbarItem, List, PullRefresh, Notify, showNotify, BackTop)
    .use(router).use(store)
    .mount('#app')
