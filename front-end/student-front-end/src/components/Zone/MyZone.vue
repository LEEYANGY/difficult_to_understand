<template>
  <van-nav-bar
      title="我的动态"
      left-text="返回"
      right-text="发布"
      left-arrow
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
    <van-cell v-for="item in list" :key="item" :title="item.title" :to="'/detail/' + item.id"/>
  </van-list>
  <!--    </van-pull-refresh>-->
  <!--    回到顶部-->
  <van-back-top right="15vw" bottom="10vh"/>
</template>

<script>
import {onMounted, reactive, ref} from 'vue';
import axios from "axios";
import {showDialog, showToast} from "vant";
import {useUserStore} from "../../store/user.ts";
import router from "../../router/index.js";

export default {
  name: "Zone",
  setup() {
    // 是否显示通知消息  TODO 需要修改成登录后，message中有内容可消费，否则 即使登录了也不展示通知
    // 校园动态集合
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
      axios.get('system/zone/getUserMaxTotal/' + JSON.parse(useUserStore().getUser)[0].userId).then(res => {
        if (res.data.code && res.data.code === 200) {
          total.value = res.data.data
        }
      }).catch((error) => {
        showDialog({type: "danger", message: "其他错误：" + error});
      });
    };

    // 对象json转换
    const jsonParse = (obj) => {
      return JSON.parse(JSON.stringify(obj));
    }
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
        axios.get('system/zone/getMyArticle/' + +JSON.parse(useUserStore().getUser)[0].userId + '/' + page.value + '/' + 10).then(res => {
          if (res.data.code === 200) {
            total.value = res.data.data.total
            list.value = list.value.concat(res.data.data.records)
          } else {
            showDialog({type: 'danger', message: '网络异常，请重试!'})
          }
        }).catch((error) => {
          showDialog({type: "danger", message: "其他错误：" + error});
        });
        // TODO 分页
        loading.value = false;

        (list.value.length >= total.value) ? finished.value = true : page.value++
        // console.log('list.length===='+list.value.length)
        // console.log(' total.value===='+ total.value)
        // if (list.value.length >= total.value) {
        //   finished.value = true;
        // } else {
        //   page.value++
        // }
      }, 1000);
    };

    // const onRefresh = () => {
    //   // 清空列表数据
    //   finished.value = false;
    //   page.value = 1;
    //   limit.value = 10;
    //   // 重新加载数据
    //   // 将 loading 设置为 true，表示处于加载状态
    //   loading.value = true;
    //   onLoad();
    // };

    const onClickLeft = () => history.back();
    const onClickRight = () => router.push('/edit/'+0);

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