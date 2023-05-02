<template>
  <router-view/>
  <!-- 用户未登录 -->
  <CheckLogin v-if="!isShow && $route.matched.length === 1"/>
  <!--    用户登录之后-->
  <UserCenter v-if="isShow && $route.matched.length === 1"/>
</template>

<script>


import {ref} from "vue";
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