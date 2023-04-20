<template xmlns:bind="https://jakarta.ee/xml/ns/jakartaee">
  <div>
    <van-search
        value="{{ value }}"
        label="查找动态"
        placeholder="请输入搜索关键词"
        use-action-slot
        bind:change="onChange"
        bind:search="onSearch"
    >
      <view slot="action" bind:tap="onClick">搜索</view>
    </van-search>
    <!--    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">-->
    <van-list
        v-model:loading="loading"
        :finished="finished"
        finished-text="没有更多的啦,我也是有底线的~~"
        @load="onLoad"
        offset="30"
        :immediate-check="true"
    >
      <van-cell v-for="item in list" :key="item" :title="item.title" :to="'/detail/' + item.id"/>
    </van-list>
    <!--    </van-pull-refresh>-->
    <!--    回到顶部-->
    <van-back-top right="15vw" bottom="10vh"/>
  </div>
</template>

<script>
import {onMounted, reactive, ref} from 'vue';
import axios from "axios";
import {showDialog, showToast} from "vant";
import index from "vuex";

export default {
  name: "Home",
  computed: {
    index() {
      return index
    }
  },
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
      axios.get('system/zone/getMaxTotal/').then(res => {
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
        axios.get('system/zone/getAllArticle/' + page.value + '/' + 10).then(res => {
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
      jsonParse,
      getTotalCount,
    };
  },
  methods: {},
  mounted() {
  }
};
</script>

<style scoped>

</style>