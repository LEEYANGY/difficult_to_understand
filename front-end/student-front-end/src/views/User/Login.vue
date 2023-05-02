<template>
  <div>
    <van-nav-bar
        title="登录"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
    />
    <van-form @submit="onSubmit">
      <van-cell-group inset>
        <van-field
            left-icon="manager"
            v-model="username"
            name="username"
            label="学号"
            placeholder="学号"
            :rules="[{ required: true, message: '请填写学号' }]"
        />
        <van-field
            left-icon="lock"
            v-model="password"
            type="password"
            name="password"
            label="密码"
            placeholder="密码"
            :rules="[{ required: true, message: '请填写密码' }]"
        />
        <!--        <van-field-->
        <!--            left-icon="lock"-->
        <!--            v-model="验证码"-->
        <!--            type="text"-->
        <!--            name="验证码"-->
        <!--            label="验证码"-->
        <!--            placeholder="验证码"-->
        <!--            :rules="[{ required: true, message: '请填写验证码' }]"-->
        <!--        />-->
      </van-cell-group>
      <div style="margin: 16px;">
        <van-button round block type="primary" native-type="submit">
          登录
        </van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
// 2. 引入组件样式
// import 'vant/lib/index.css';
import {reactive, ref, toRefs} from 'vue';
import axios from "axios";
import router from "../../router/index.js";
import Cookies from "js-cookie";
import {showNotify} from 'vant';

// const
import {useUserStore} from "../../store/user.ts";
import store from "../../store/index.js";
// 1构建登录请求
// 2.获取用户名和密码发送给服务器
export default {
  name: "Login",

  // 入口函数
  setup() {
    const username = ref('20223035104');
    const password = ref('20223035104');
    const store = useUserStore();
    const onSubmit = (values) => {
      // console.log('submit', values);
      // console.log('values.username', values.username);
      // console.log('values.password', values.password);
    };
    // 返回上一页
    const onClickLeft = () => history.back();

    const checkLogin = () => {
      if (store.getAuthorization != null && store.getAuthorization !== '') {
        store.setIsLogin(1)
        showNotify({type: "danger", message: "您已经登录，无需重复登录！"});
        // 返回上一级
        router.go(-1)
      } else {
        store.setIsLogin(0)
      }
      return store.isLogin
    };

    return {
      store,
      username,
      password,
      onSubmit,
      checkLogin,
      onClickLeft,
    };
  },

  methods: {
    onSubmit: function () {
      console.log('checkLogin====' + this.store.isLogin)
      // 执行登录检查
      this.checkLogin();
      axios({
        method: "post",
        url: "/system/user/login",
        data: {
          userId: this.username,
          password: this.password,
        },
      })
          .then((res) => {
            if (res.data.code === 200) {
              this.store.setIsLogin(1);
              this.store.setUser(JSON.stringify(res.data.data))
              this.store.setAuthorization(res.headers.authorization)
              localStorage.setItem("USER_TOKEN", this.store.getAuthorization)
              localStorage.setItem("USER_INFO", this.store.getUser)
              localStorage.setItem('USER_LOGIN', this.store.getIsLogin)
              // 持久化
              // this.store.$subscribe((mutation, state) => {
              //
              // });
              // window.localStorage.setItem("LOGIN_FLAG", this.store.isLogin)
              showNotify({type: "success", message: "登录成功！"});
              router.replace('/user')
            } else if (res.data.code === 500) {
              showNotify({type: "danger", message: "服务器内部异常，请联系管理员！"});
            } else {
              showNotify({type: "danger", message: res.data.message});
            }
          })
          .catch((error) => {
            showNotify({type: "danger", message: "其他错误：" + error});
          });
    },
  },
  mounted() {
    this.checkLogin();
    // this.list;
  },
  watch() {
    localStorage.setItem('USER_STATUE', store)
    if (localStorage.USER_TOKEN) {
      console.log('watch+++++' + localStorage.getItem('USER_TOKEN'))
    }
  }
}
</script>

<style scoped>

</style>