<template>
  <van-list
      v-model:loading="loading"
      :finished="finished"
      finished-text="没有更多的啦,我也是有底线的~~"
      @load="onLoad"
      offset="10"
      :immediate-check="true"
  >
    <van-cell v-for="item in list" :key="item" :title="item.title" :to="'/recordDetail/' + item.id"/>
    <van-back-top right="15vw" bottom="10vh"/>
  </van-list>
</template>

<script>
import {ref} from "vue";
import axios from "axios";
import {useUserStore} from "../../store/user.ts";
import {showDialog} from "vant";

export default {
  name: "RecordList",
  setup() {
    const list = ref([]);
    const loading = ref(false);
    const finished = ref(false);
    const refreshing = ref(false);
    // 内容记数器
    const countList = ref('0');
    // 后台查询到最大记录数
    const totalCount = ref(0);
    // 分页设置,保存到store中
    const page = ref(1);
    // 页面容量
    const limit = ref(10);
    const total = ref(0);
    const getTotalCount = () => {
      // 获取最大记录
      axios.get('/user-service/system/user/getMyEventTotal/' + JSON.parse(useUserStore().getUser).userId).then(res => {
        if (res.data.code && res.data.code === 200) {
          total.value = res.data.data
        }
      }).catch((error) => {
        showDialog({type: "danger", message: "其他错误：" + error});
      });
    };

    // 加载
    const onLoad = () => {
      getTotalCount();
      setTimeout(() => {
        // 刷新
        if (refreshing.value) {
          list.value = {};
          refreshing.value = false;
        }
        // 拼接url
        axios.get('/user-service/system/user/getMyEventRecord/' + JSON.parse(useUserStore().getUser).userId + '/' + page.value + ' / ' + 10).then(res => {
          if (res.data.code === 200) {
            total.value = res.data.data.length
            list.value = res.data.data
          } else {
            showDialog({type: 'danger', message: '网络异常，请重试!'})
          }
        }).catch((error) => {
          showDialog({type: "danger", message: "其他错误：" + error});
        });
        // TODO 分页
        loading.value = false;
        (list.value.length >= total.value) ? finished.value = true : page.value++
      }, 1000);
    };

    return {
      list,
      page,
      limit,
      total,
      loading,
      finished,
      countList,
      refreshing,
      totalCount,
      onLoad,
      getTotalCount,
    };
  },
}
</script>

<style scoped>

</style>