<template>
  <van-form @submit="onSubmit">
    <van-nav-bar
        title="用户中心"
        left-text="返回"
        right-text="保存"
        left-arrow
        @click-left="onClickLeft"
        @click-right="onSubmit"
    />
    <van-cell-group inset>
      <van-field name="uploader" label="头像">
        <template #input>
          <van-uploader v-model="ress"/>
        </template>
      </van-field>

      <van-field
          v-model="userName"
          name="userName"
          label="用户姓名"
          placeholder="用户姓名"
          :rules="[{ required: true, message: '请填写用户姓名' }]"
          readonly
          disabled
      />
      <van-field
          v-model="email"
          name="email"
          label="用户邮箱"
          placeholder="用户邮箱"
          :rules="[{ required: true, message: '请填写用户邮箱' }]"
      />


      <van-field
          v-model="profession"
          name="profession"
          label="专业"
          placeholder="专业"
          :rules="[{ required: false, message: '请填写专业' }]"
          readonly
          disabled
      />

      <van-field
          v-model="password"
          type="password"
          name="password"
          label="密码"
          placeholder="密码"
          :rules="[{ required: true, message: '请填写密码以便验证身份' }]"
      />

      <van-field
          v-model="password"
          value="password"
          type="password"
          name="password"
          label="要修改的密码"
          placeholder="要修改的密码，如不修改可不填写"
      />

      <!--  输入框-->
      <!--      <div class="bottom">-->
      <!--        <van-cell-group inset class="insert-text">-->
      <!--          <van-field-->
      <!--              v-model="verifyCode"-->
      <!--              :autosize="{ maxHeight: 100, minHeight: 25 }"-->
      <!--              label="验证码"-->
      <!--              type="textarea"-->
      <!--              placeholder="请在此输入验证码"-->
      <!--              show-word-limit-->
      <!--              :rules="[{ required: true, message: '验证码以下发，请注意查收' }]"-->
      <!--          >-->
      <!--            <template #button>-->
      <!--              <van-button size="small" type="primary" @click="start">获取验证码-->
      <!--              </van-button>-->
      <!--            </template>-->
      <!--          </van-field>-->
      <!--        </van-cell-group>-->
      <!--      </div>-->

    </van-cell-group>
  </van-form>
  <!--  <van-count-down-->
  <!--      ref="countDown"-->
  <!--      millisecond-->
  <!--      :time="isDisable"-->
  <!--      :auto-start="false"-->
  <!--      format="ss"-->
  <!--      @finish="onFinish"-->
  <!--  />-->
</template>

<script>
import {showNotify, showToast} from "vant";
import {ref} from "vue";
import axios from "axios";
import router from "../../router/index.js";
import {useUserStore} from "../../store/user.ts";

export default {
  name: "FormTable",
  setup() {
    const onClickLeft = () => history.back();
    const onClickRight = () => showToast({type: "success", message: "保存了吼"});
    // 控制骨架屏显示时机，数据加载成功后，不让其显示
    const init_skeleton = ref(1);
    const userInfo = ref(JSON.parse(useUserStore().getUser)[0]);
    const userName = ref(JSON.parse(useUserStore().getUser)[0].userName);
    const uid = ref(JSON.parse(useUserStore().getUser)[0].id)
    const password = ref('')
    const email = ref(JSON.parse(useUserStore().getUser)[0].email)
    const profession = ref(JSON.parse(useUserStore().getUser)[0].profession)
    const ress = ref([
      {url: 'https://fastly.jsdelivr.net/npm/@vant/assets/leaf.jpeg'},
    ]);

    // 获取用户信息 router.currentRoute.value.params.id
    axios.get('/system/user/getUserInfo/' + router.currentRoute.value.params.userId)
        .then(res => {
          if (res.data.code === 200) {
            showNotify({type: "success", message: res.data.msg})
            userInfo.value = res.data.data;
            email.value = JSON.parse(useUserStore().getUser)[0].email;
            uid.value = JSON.parse(useUserStore().getUser)[0].id;
            profession.value = JSON.parse(useUserStore().getUser)[0].profession;
            userName.value = JSON.parse(useUserStore().getUser)[0].userName;
            // init_skeleton.value = 0;
          } else if (res.data.code === 403) {
            console.log('没有权限')
            showNotify({type: "fail", message: res.data.msg})
          } else if (res.data.code === 500) {
            console.log('服务器异常，请联系管理员')
            showNotify({type: "fail", message: res.data.msg})
          }
        })

    // 从后端请求生成二维码
    const verifyCode = ref();

    const isDisable = 60000

    // const countDown = ref(null);


    // const start = () => {
    //   countDown.value.start();
    //   // 向后台发送获取验证码请求
    //   if (this.isDisable < 59998   ) {
    //     showToast({type: "fail", message: "请求过于频繁"})
    //   } else {
    //     console.log(isDisable)
    //   }
    // };
    // const onFinish = () => {
    //   countDown.value.reset();
    //   this.isDisable = 60000;
    //   showToast({type: "success", message: "可以再次获取验证码了"})
    // }

    const onSubmit = () => {
      axios({
        method: "put",
        url: '/system/user/putUserInfo',
        data: {
          id: uid.value,
          password: password.value,
          email: email.value,
        }
      }).then(res => {
        if (res.data.code === 200) {
          localStorage.removeItem('USER_TOKEN')
          localStorage.removeItem('USER_INFO')
          localStorage.removeItem('USER_LOGIN')
          showNotify({type: "success", message: res.data.msg})
          setTimeout(() => router.go(-1), 2000);
          // location.reload();
        } else if (res.data.code === 500) {
          showNotify({type: "fail", message: res.data.msg})
        } else if (res.data.code === 403) {
          showNotify({type: "fail", message: res.data.msg})
        } else {
          showNotify({type: "fail", message: res.data.msg})
        }
      })
    }

    return {
      uid,
      userName,
      profession,
      password,
      email,
      ress,
      userInfo,
      isDisable,
      // countDown,
      verifyCode,
      init_skeleton,
      // start,
      // onFinish,
      onSubmit,
      onClickLeft,
      onClickRight,
    };
  },
}
</script>

<style scoped>

</style>