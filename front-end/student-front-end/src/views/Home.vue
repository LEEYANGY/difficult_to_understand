<template xmlns:bind="https://jakarta.ee/xml/ns/jakartaee">
  <div>
<!--    <van-search-->
<!--        value="{{ value }}"-->
<!--        label="查找动态"-->
<!--        placeholder="请输入搜索关键词"-->
<!--        use-action-slot-->
<!--        bind:change="onChange"-->
<!--        bind:search="onSearch"-->
<!--    >-->
<!--      <view slot="action" bind:tap="onClick">搜索</view>-->
<!--    </van-search>-->
    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list
          v-model:loading="loading"
          :finished="finished"
          finished-text="没有更多了"
          @load="onLoad"
      >
<!--        路由-->
<!--        <router-link-->
<!--            :to="'/detail/' + item.id"-->
<!--            v-for="item in list"-->
<!--            :key="item.id"-->
<!--        >-->
        <van-cell v-for="item in list" :key="item" :title="item" />
      </van-list>
    </van-pull-refresh>
<!--    回到顶部-->
    <van-back-top right="15vw" bottom="10vh" />
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from "axios";
export default {
  name: "Home",
  setup() {
    const list = ref([]);
    const loading = ref(false);
    const finished = ref(false);
    const refreshing = ref(false);

    const onLoad = () => {
      axios.get('system/zone/getAllArticle').then(res=>{
        console.log('line 41. ==== '+res.data)

      })



    };

    const onRefresh = () => {
      // 清空列表数据
      finished.value = false;

      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      loading.value = true;
      onLoad();
    };

    return {
      list,
      onLoad,
      loading,
      finished,
      onRefresh,
      refreshing,
    };
  },
};
</script>

<style scoped>

</style>