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

  接口汇总
  <br>

  获取动态:<br>
  获取最大记录数:<br>
  method: GET<br>
  /system/zone/getMaxTotal<br><br>

  分页查询:<br>
  method: GET<br>
  params:<br>
  Integer page     页码<br>
  Integer limit    页面容量<br>
  /system/zone/getAllArticle/{page}/{limit}<br><br>

  动态详细:
  method: GET<br>
  params: Long id   动态的id<br>
  /system/zone/getDetail/{id}<br><br>

  通过动态id删除动态<br>
  method: DELETE<br>
  /system/zone/delZone/{id}<br>

  查询用户动态记录<br>
  method: GET<br>
  params: Long userId  用户id<br>
  /system/zone/getUserMaxTotal/{userId}<br><br>

  分页查询用户的动态记录<br>
  method: GET<br>
  params:<br>
  Long userId   用户id<br>
  Integer page  页码<br>
  Integer limit 页面容量<br>
  /system/zone/getMyArticle/{userId}/{page}/{limit}<br>

  这里服用了接口，在请求的时候进行id判断如果查不到数据，就做为添加<br>
  method: POST<br>
  params: Zone.class<br>
  /system/zone/editZone<br>

  请求表单:<br>
  自助申请<br>
  method: POST<br>
  params：Event.class<br>
  /system/event/cafeAdd<br>

  查询用户的申请记录数<br>
  method: GET<br>
  params: Long sponsor_id   发布人的id也就是用户id<br>
  /system/event/getTotal/{sponsor_id}<br><br>

  分页查询，查询指定用户的数据<br>
  method: GET<br>
  params:<br>
  Long sponsor_id   发布人的id通userId<br>
  Integer page      页码<br>
  Integer limit     页面容量<br>
  /system/event//getMyCafeRecord/{sponsor_id}/{page}/{limit}<br><br>

  更新用户的申请<br>
  method: PUT<br>
  params : Event.class<br>
  /system/event/updateRecord<br>

  获取用户的申请信息<br>
  method: GET<br>
  params: Long id   申请记录的id<br>
  /system/event/getMyCafeDetailRecord/{id}<br><br>

  校园专区:<br>
  获取所有聊天记录:<br>
  method: GET<br>
  params: Long gid    群组id<br>
  /system/zone/getChatContent/{gid}<br>

  ws连接:<br>
  params: String username 用户名<br>
  /imserver/{username}<br>

  查看在线人数:<br>
  params: String username 用户名<br>
  /imserver/{username}<br><br>

  消息:<br>
  获取所有消息<br>
  method: GET<br>
  /system/message/getAllMessage<br><br>

  用户信息维护<br>
  登录:<br>
  method: POST<br>
  /system/user/login<br><br>

  登出:<br>
  method: GET<br>
  /system/user/logout<br><br>

  用户信息修改:<br>
  method: PUT<br>
  params: User.class<br>
  /system/user/putUserInfo<br><br>

  获取指定用户信息<br>
  method: GET<br>
  params: Long userId  用户id<br>
  /system/user/getUserInfo/{userId}<br><br>

  权限测试接口:<br>
  /hello<br>
  /hello/vip1<br><br>

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