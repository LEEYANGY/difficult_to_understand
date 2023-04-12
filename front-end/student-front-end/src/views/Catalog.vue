<template>
  <div class="catalog">
    <!-- 用户未登录 -->
    <div class="catalog-login" v-if="isLogin === 0">
      <div class="catalog-login-tip">
        您还暂未登录<br/>登录账号后方可查看
      </div>
      <div class="catalog-login-action">
        <div style="margin: 16px;">
          <van-button round block type="primary" class="catalog-login-btn"
                      to="/login">
            登录
          </van-button>
        </div>
      </div>
    </div>

<!--    登录之后-->
    <!-- 用户已登录 -->
<!--    <List v-if="isLogin == 1" />-->
    <div class="order-fixed-btn" v-if="isLogin === 1">
      <van-button
          round
          color="linear-gradient(to bottom right,rgb(18, 107, 175),rgb(130, 181, 102))"
          icon="plus"
          to="/apply"
      >添加申请</van-button
      >
    </div>
  </div>
</template>

<script>
// import {Toast} from "vant";

export default {
  name: "Catalog",
  // ide自动添加属性
  computed: {
    moment() {
      return this.moment
    }
  },

  data: () => ({
    // 是否登录状态
    isLogin: 0,
  }),
  methods: {
    // todo
    checkLogin: function () {
      if (this.uid && this.token) {
        this.isLogin = 0;
      }
    },
  },
  mounted() {
    this.checkLogin();
  },
  created() {
    //   this.$http({
    //     url:'http://localhost:8888',
    //     method: 'GET',
    //   }).then(data=>{
    //     console.log(data);
    //   })

  },
}
</script>

<style scoped>
.catalog {
  padding-top: 46px;
}

.catalog-login {
  text-align: center;
  position: absolute;
  width: 100%;
  top: 50%;
  left: 50%;
  transform: translateX(-50%) translateY(-50%);
}

.catalog-login-action {
  margin-top: 15px;
}

.catalog-login-btn {
  /*width: 80%;*/
  /*font-size: 18px;*/
}

.catalog-login-tip {
  font-size: 18px;
  line-height: 26px;
}

.catalog-fixed-btn {
  position: fixed;
  bottom: 60px;
  left: 50%;
  transform: translateX(-50%);
}
</style>