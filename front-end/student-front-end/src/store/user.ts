import {defineStore} from 'pinia'

// useStore 可以是 useUser、useCart 之类的任何东西
// 第一个参数是应用程序中 store 的唯一 id
export const useUserStore = defineStore('auth', {
    // other options...
    state: () => {
        return {
            isLogin: localStorage.getItem('USER_LOGIN')? 1:0,
            isAuthenticated: false,
            Authorization: localStorage.getItem('USER_TOKEN'),
            user: localStorage.getItem('USER_INFO'),
        }
    },
    // computed修饰一些值
    getters: {
        // 通过getter对state状态修改
        getIsLogin:state => state.isLogin,
        getAuthenticated: state => state.isAuthenticated,
        getUser: state => state.user,
        getAuthorization: state => state.Authorization,
    },
    // method 可以同步异步做提交state
    actions: {
        // 设置认证，登录状态
        setAuth(isAuth: boolean) {
            if (isAuth) {
                //在pinia中this指代state
                this.isAuthenticated = isAuth;
            } else {
                this.isAuthenticated = false;
            }

        },
        // 保存用户信息
        setUser(user: any) {
            if (user) {
                this.user = user;
            } else {
                this.user = {};
            }
        },
        // token
        setAuthorization(Authorization) {
            if (Authorization) {
                this.Authorization = Authorization;
            } else {
                this.Authorization = '';
            }
        },
        setIsLogin(login_statue) {
            if (login_statue) {
                this.isLogin = 1;
            } else {
                this.isLogin = 0;
            }
        }
    }
})