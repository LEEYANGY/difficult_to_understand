<template>
  <van-button @click="login" class="login">模拟登录</van-button>
  <van-button @click="logout">注销登录</van-button>
  <hr>
  登录状态:{{ store.isLogin }}
  <br>
  用户token:{{ store.Authorization }}
  <hr>
  用户基础信息:{{ store.user }}
  <hr>
  当前设备的ip地址{{}}
  <hr>
  目标服务器IP地址{{ serverIp }}
  <hr>

</template>

<script>

import {useUserStore} from '../store/user';

/**
 * @Param:
 * @return:
 * @Author: liyangyang
 * @Date: 2023/4/13 11:18
 * @Description:
 *
 * 修改state几种方法
 *  1.
 *    store.age++
 *
 *  2.
 *          store.$patch({
 *          age: 55
 *        })
 *
 *  3.
 *        store.$path( (state) =>{state.age =100 } )
 *
 *  4.
 *      store.$state = {age:200}
 *
 *  5.使用action
 */

export default {
  name: "Other",
  setup() {
    const store = useUserStore();
    const serverIp = window.location;
    // const changeAge = () => {
      // store.$patch({
      //   age: 55
      // })
      // store.age++
      // store.$state = {age:200};
      // store.setAge(1);
    // };

    const logout = () => {
      // 清空用户状态
      useUserStore().setIsLogin(0);
      useUserStore().setUser();
      useUserStore().setAuthorization();
    };

    // 模拟用户登录了
    const login = () => {
      // 清空用户状态
      useUserStore().isLogin = localStorage.getItem('USER_LOGIN');
      useUserStore().user = localStorage.getItem('USER_INFO');
      useUserStore().Authorization = localStorage.getItem('USER_TOKEN');
    };
    return {store, serverIp, logout, login};
  },
  computed: {},
  methods: {}
}
</script>

<style scoped>
.login {
  word-wrap: break-word;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>