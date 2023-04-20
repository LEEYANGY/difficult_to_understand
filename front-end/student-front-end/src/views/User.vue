<template>
  <div class="user">
    <!-- 用户未登录 -->
    <div class="user-login" v-if="store.getIsLogin === 0">
      <div class="user-login-tip">
        您还暂未登录<br/>登录账号后方可查看
      </div>
      <div class="user-login-action">
        <div style="margin: 16px;">
          <van-button round block type="primary" class="user-login-btn"
                      to="/login">
            登录
          </van-button>
        </div>
      </div>
    </div>

    <!--    用户登录之后-->
    <div v-if="store.getIsLogin===1">
      <van-nav-bar
          title="用户中心"
      />
      <van-skeleton>
        <template #template>
          <div :style="{ display: 'flex', width: '100%' }">
            <van-image

                width="60"
                height="60"
                src="https://ts1.cn.mm.bing.net/th/id/R-C.729885902b9a3385a2babc27165a01d7?rik=Xko2QkNR6HcV5w&riu=http%3a%2f%2fpic.22520.cn%2fup%2f200810%2f1597052667744492.jpg&ehk=6vNPGmsces4Wh5RLj%2fUPL%2bPzJGEk3xpdaEX5QqKICr0%3d&risl=&pid=ImgRaw&r=0"
            />
            <!--              <van-skeleton-image/>-->
            <div :style="{ flex: 1, marginLeft: '16px' }">
              <van-cell v-for="item in user" :key="item" :title="item.title" :to="'/userprofile/' + item.id">
                用户姓名:{{ item.userName }}
                <br>
                用户id:{{ item.userId }}
              </van-cell>
            </div>
          </div>
        </template>
      </van-skeleton>

      <van-grid direction="horizontal" :column-num="3">
        <van-grid-item icon="photo-o" text="自助审批"/>
        <van-grid-item icon="photo-o" text="我的动态"/>
        <van-grid-item icon="photo-o" text="校园服务"/>
      </van-grid>

      <div class="user-login-action">
        <div style="margin: 16px;">
          <van-button round block type="primary" class="user-login-btn"
                      to="/user" @click="logout">
            退出登录
          </van-button>
        </div>
        <p class="info">技术支持:李洋洋</p>
        <p class="info">Copyright 2023-2023 leeyangy.xyz All Rights Reserved</p>
        <p class="info">备案号：<a href="https://beian.miit.gov.cn/">桂ICP备2021009674号-1</a></p>
      </div>
    </div>
  </div>
</template>

<script>


import {ref} from "vue";
import {useUserStore} from "../store/user.ts";
import {useRouter} from "vue-router";
import {showNotify} from "vant";
import router from "../router/index.js";

export default {
  name: "User",
  setup() {
    const router = useRouter();
    const store = useUserStore();
    const isLogin = ref(store.getIsLogin)
    const user = ref({})
    user.value = JSON.parse(store.getUser)

    // 判断是否登录了
    // const checkLogin = () => {
    //   if (localStorage.getItem('USER_TOKEN') != null && localStorage.getItem('USER_TOKEN') !== '') {
    //     // store.setIsLogin(1)
    //     // isLogin.value = 1
    //   } else {
    //     // store.setIsLogin(0)
    //     // isLogin.value = 0
    //   }
    // }

    // 注销登录事件
    const logout = () => {
      localStorage.removeItem('USER_TOKEN')
      localStorage.removeItem('USER_INFO')
      localStorage.removeItem('USER_LOGIN')
      showNotify({type: "success", message: "注销登录成功！"});
      location.reload()
      router.replace('/user')
    };

    const setting = () => {
      // router.push('/login');

    };

    return {
      user,
      store,
      isLogin,
      logout,
      setting,
      // checkLogin,
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
.user {
  padding-top: 46px;
}

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

.info {
  text-align: center;
  font-size: 1px;
}
</style>