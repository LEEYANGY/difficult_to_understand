<template>
  <!--    notify-->
  <van-notice-bar left-icon="volume-o" :scrollable="false">
    <van-swipe
        vertical
        class="notice-swipe"
        :autoplay="3000"
        :touchable="false"
        :show-indicators="false"
    >
      <van-list v-for="(item,index) in notifies">
        <van-swipe-item>{{ item.message }}</van-swipe-item>
      </van-list>
    </van-swipe>
  </van-notice-bar>
</template>

<script >
import {ref} from "vue";

export default {
  name: "Notices",
  setup() {
    // 请求获取消息队列  模拟数据
    const notifies = ref([{"message": "放假通知1"}, {"message": "放假通知2"}, {"message": "放假通知3"}])
    return{
      notifies,
    }
  },
  data(){
    return{

    }
  },
}
</script>

<style scoped>
.notice-swipe {
  height: 40px;
  line-height: 40px;
}
</style>