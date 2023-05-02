<template>
  <!-- 用户未登录 -->
  <CheckLogin v-if="!isShow"/>

  <!--    用户登录之后-->
  <UserCenter v-if="isShow"/>
</template>

<script>


import {ref} from "vue";
import {useUserStore} from "../../store/user.ts";
import {useRouter} from "vue-router";
import {showNotify} from "vant";
import router from "../../router/index.js";
import Support from "../../components/BeiAn/Support.vue";
import CheckLogin from "../../components/manager/CheckLogin.vue";
import UserCenter from "../../components/manager/UserCenter.vue";

export default {
  name: "User",
  components: {UserCenter, CheckLogin, Support},
  setup() {
    // 是否展示组件
    const isShow = ref((localStorage.getItem("USER_LOGIN")));
    return {
      isShow,
    };
  },
  // ide自动添加属性
  computed: {
    moment() {
      return this.moment
    }
  },

  methods: {
    // logout() {
    //   localStorage.removeItem('USER_TOKEN')
    //   localStorage.removeItem('USER_INFO')
    //   localStorage.removeItem('USER_LOGIN')
    //   this.router.push('/')
    //   // this.reload();
    // },
  },
  mounted() {

  },
}
</script>

<style scoped>

.user-login {
  text-align: center;
  position: absolute;
  width: 100%;
  top: 50%;
  left: 50%;
  transform: translateX(-50%) translateY(-50%);
}

.user-login-action {
  margin-top: 15px;
}

.user-login-btn {
  /*width: 80%;*/
  font-size: 18px;
}

.user-login-tip {
  font-size: 18px;
  line-height: 26px;
}

/*.user-logout {*/
/*  !*text-align: center;*!*/
/*  position: absolute;*/
/*  width: 80%;*/
/*  top: 50%;*/
/*  left: 50%;*/
/*  transform: translateX(-50%) translateY(-50%);*/
/*}*/

/*.avatar-style {*/

/*}*/

.user-logout-btn {
  position: fixed;
  /*bottom: 60px;*/
  left: 50%;
  transform: translateX(-50%);
}

/*.user-info-box {*/
/*  position: relative;*/
/*  margin: 10px;*/
/*  padding: 10px 20px 10px 10px;*/
/*  background: #fff;*/
/*  border-radius: 6px;*/
/*  font-size: 14px;*/
/*  color: #aaa;*/
/*}*/

/*.right-box {*/
/*  display: flex;*/
/*  flex-direction: column;*/
/*  height: 100%;*/
/*}*/

/*.name-text {*/
/*  margin: auto auto auto 10px;*/
/*}*/

/*.sign-text {*/
/*  margin: auto auto auto 10px;*/
/*}*/


/*.mgt-icon {*/
/*  position: absolute;*/
/*  right: 10px;*/
/*}*/


</style>