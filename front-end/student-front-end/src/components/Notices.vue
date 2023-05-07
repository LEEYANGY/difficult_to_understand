<template>
  <!--    notify-->
  <van-notice-bar left-icon="volume-o" :scrollable="false" v-if="notifies!==undefined">
    <van-swipe
        vertical
        class="notice-swipe"
        :autoplay="3000"
        :touchable="false"
        :show-indicators="false"
    >
      <van-list v-for="(item,index) in notifies">
        <van-swipe-item>{{ item.subject }}</van-swipe-item>
      </van-list>
    </van-swipe>
  </van-notice-bar>
</template>

<script>
import {ref} from "vue";
import axios from "axios";

export default {
  name: "Notices",
  setup() {
    // 请求获取消息队列  模拟数据
    const notifies = ref();
    axios.get('/system/message').then(res => {
      if (res.data.code===200){
        notifies.value = res.data.data
      }else {
        // notifies.value = ''
      }
    })
    return {
      notifies,
    }
  },
  data() {
    return {}
  },
  // methods
}
</script>

<style scoped>
.notice-swipe {
  height: 40px;
  line-height: 40px;
}
</style>