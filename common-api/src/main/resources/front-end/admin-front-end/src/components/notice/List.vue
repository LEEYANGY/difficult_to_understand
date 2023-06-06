<template>

  <van-nav-bar
      title="通知列表"
      left-text="返回"
      left-arrow
      right-text="发布"
      @click-left="onClickLeft"
      @click-right="onClickRight"
  />
  <van-list
      v-model:loading="loading"
      :finished="finished"
      finished-text="没有更多的啦,我也是有底线的~~"
      @load="onLoad"
      offset="10"
      :immediate-check="true"
  >
    <van-cell v-for="item in list" :key="item" :title="item.title" :to="'/noticeDetail/' + item.id"/>
    <van-back-top right="15vw" bottom="10vh"/>
  </van-list>

</template>

<script>
import {ref} from "vue";
import axios from "axios";
import {showDialog} from "vant";
import router from "../../router/index.js";

export default {
  name: "List",
  setup() {
    const onClickLeft = () => history.back();
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
      axios.get('/message-service/system/message/admin/getTotal').then(res => {
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
        axios.get('/message-service/system/message').then(res => {
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

    const onClickRight =()=>{
      // router.push({name: 'detail/', params: {id: router.currentRoute.value.params.id}})
      router.push('noticeDetail/'+0)
    }

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
      onClickLeft,
      onClickRight,
      getTotalCount,
    };
  },
}
</script>

<style scoped>

</style>