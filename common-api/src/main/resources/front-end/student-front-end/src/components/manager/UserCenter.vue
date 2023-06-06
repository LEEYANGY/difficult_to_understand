<template>
  <!--    <Header msg="用户中心"/>-->
  <van-nav-bar title="用户中心"/>


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
          用户姓名:{{ user.userName }}
          <br>
          用户id:{{ user.userId }}
        </div>
      </div>
      <van-icon name="setting" @click="router.push('/user'+'/'+user.userId)"/>
    </template>
  </van-skeleton>

  <van-grid direction="horizontal" :column-num="3">
    <van-grid-item icon="photo-o" text="自助审批记录" to="/catalog/myCafeRecord"/>
    <van-grid-item icon="photo-o" text="我的动态" to="/catalog/myzone/"/>
    <van-grid-item icon="photo-o" text="校园服务" to="/catalog"/>
  </van-grid>

  <div class="user-login-action">
    <div style="margin: 16px;">
      <van-button round block type="primary" class="user-login-btn"
                  to="/user" @click="logout">
        退出登录
      </van-button>
    </div>
    <Support/>
  </div>

</template>

<script setup>
import {useRouter} from "vue-router";
import {useUserStore} from "../../store/user.ts";
import {ref} from "vue";
import {showNotify} from "vant";
import Support from "../BeiAn/Support.vue";

const msg = ref('用户中心')
const router = useRouter();
const store = useUserStore();
const user = ref(JSON.parse(store.getUser))
const isShow = ref((localStorage.getItem("USER_LOGIN")));
// 注销登录事件
const logout = () => {
  localStorage.removeItem('USER_TOKEN')
  localStorage.removeItem('USER_INFO')
  localStorage.removeItem('USER_LOGIN')
  showNotify({type: "success", message: "注销登录成功！"});
  location.reload()
  router.replace('/user')
}

const toUser = (val)=>{

}

</script>

<style scoped>

</style>