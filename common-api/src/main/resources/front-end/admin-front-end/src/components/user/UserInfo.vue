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
      <!--      <van-field name="uploader" label="头像">-->
      <!--        <template #input>-->
      <!--          <van-uploader v-model="ress"/>-->
      <!--        </template>-->
      <!--      </van-field>-->
      <van-field
          v-model="userName"
          name="userName"
          label="用户姓名"
          placeholder="用户姓名"
          :rules="[{ required: true, message: '请填写用户姓名' }]"
      />
      <van-field
          v-model="email"
          name="email"
          label="用户邮箱"
          placeholder="用户邮箱"
          :rules="[{ required: true, message: '请填写用户邮箱' }]"
      />
      <van-field
          v-model="phone"
          name="phone"
          label="手机号"
          placeholder="手机号"
          :rules="[{ required: true, message: '请填写手机号' }]"
      />

      <van-field
          v-model="profession"
          name="profession"
          label="专业"
          placeholder="专业"
          :rules="[{ required: false, message: '请填写专业' }]"
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
    </van-cell-group>
  </van-form>
</template>

<script>
import {showNotify, showToast} from "vant";

import {ref} from "vue";
import axios from "axios";
import router from "../../router/index.js";

export default {
  name: "UserInfo",
  setup() {
    const onClickLeft = () => history.back();
    const onClickRight = () => showToast({type: "success", message: "保存了吼"});
    // 控制骨架屏显示时机，数据加载成功后，不让其显示
    const init_skeleton = ref(1);

    const userInfo = ref('');
    const userName = ref('1');
    const uid = ref('1');
    const password = ref('')
    const email = ref('1');
    const profession = ref('1');
    const userId = ref('1')
    const ress = ref([
      {url: 'https://fastly.jsdelivr.net/npm/@vant/assets/leaf.jpeg'},
    ]);

    const phone = ref()

    // 获取用户信息 router.currentRoute.value.params.id
    axios.get('/user-service/system/user/getUserInfo/' + router.currentRoute.value.params.userId)
        .then(res => {
          if (res.data.code === 200) {
            userInfo.value = res.data.data;
            console.log('line 102===='+userInfo.value)
            email.value = res.data.data.email;
            uid.value = res.data.data.id;
            profession.value = res.data.data.profession;
            userName.value = res.data.data.userName;
            userId.value = res.data.data.userId;
            phone.value = res.data.data.phoneNumber;
            showNotify({type: "success", message: res.data.msg})
            // init_skeleton.value = 0;
          } else if (res.data.code === 403) {
            console.log('没有权限')
            showNotify({type: "fail", message: res.data.msg})
          } else if (res.data.code === 500) {
            console.log('服务器异常，请联系管理员')
            showNotify({type: "fail", message: res.data.msg})
          }
        })


    const onSubmit = () => {
      axios({
        method: "put",
        url: '/user-service/system/user/admin/updateUserInfo',
        data: {
          id: uid.value,
          // password: password.value,
          phoneNumber:phone.value,
          profession:profession.value,
          email: email.value,
          userName:userName.value,
          password:password.value,
        }
      }).then(res => {
        if (res.data.code === 200) {
          showNotify({type: "success", message: res.data.message})
          setTimeout(() => router.go(-1), 2000);
          // location.reload();
        } else if (res.data.code === 501) {
          showNotify({type: "fail", message: res.data.message})
        } else if (res.data.code === 403) {
          showNotify({type: "fail", message: res.data.message})
        } else {
          showNotify({type: "fail", message: res.data.message})
        }
      })
    }

    return {
      uid,
      userId,
      userName,
      profession,
      password,
      email,
      ress,
      phone,
      userInfo,
      init_skeleton,
      onSubmit,
      onClickLeft,
      onClickRight,
    };
  },
}
</script>

<style scoped>

</style>