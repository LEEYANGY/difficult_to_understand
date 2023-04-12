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
import router from "../router/index.js";
import Cookies from "js-cookie";
import {showNotify} from 'vant';

// const router = useRouter();

// 1构建登录请求
// 2.获取用户名和密码发送给服务器
export default {
  name: "Login",

  // 入口函数
  setup() {
    const username = ref('20223035104');
    const password = ref('20223035104');

    const onSubmit = (values) => {
      // console.log('submit', values);
      // console.log('values.username', values.username);
      // console.log('values.password', values.password);
    };
    // 返回上一页
    const onClickLeft = () => history.back();

    return {
      username,
      password,
      onSubmit,
      onClickLeft,
    };
  },

  methods: {
    // checkLogin: function () {
    //   if (this.uid && this.token) {
    //     showNotify({type: "danger", message: "您已经登录，无需重复登录！"});
    //     this.goBack();
    //   }
    // },
    goBack: function () {
      document.referrer === ""
          ? (this.$router.push = "/user")
          : window.history.go(-1);
    },
    onSubmit: function () {
      axios({
        method: "post",
        url: "/system/user/login",
        data: {
          userId: this.username,
          password: this.password,
        },
      })
          .then((res) => {
            // console.log(res)
            // console.log('line 103===='+res.data.code)
            if (res.data.code === 200) {
              showNotify({type: "success", message: "登录成功！"});
              router.push('/')
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
    // this.checkLogin();
  },
}
</script>

<style scoped>

</style>