<template>
  <!-- 用户未登录 -->

  <div class="user-login">

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
</template>

<script>
export default {
  name: "CheckLogin"
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
</style>