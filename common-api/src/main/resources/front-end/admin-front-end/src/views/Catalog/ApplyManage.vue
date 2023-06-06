<template>
  <router-view/>
  <van-nav-bar
      v-if="isShow && $route.matched.length === 1"
      title="校园出入审批"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
  />
  <CheckLogin v-if="!isShow && $route.matched.length === 1"/>
  <RecordList v-if="isShow && $route.matched.length === 1"/>
</template>

<script>
import {ref} from "vue";

import CheckLogin from "../../components/manager/CheckLogin.vue";
import CatalogList from "../../components/manager/CatalogList.vue";
import RecordList from "../../components/manager/RecordList.vue";


export default {
  components: {RecordList, CatalogList, CheckLogin},
  // ide自动添加属性
  computed: {
    moment() {
      return this.moment
    }
  },
  setup() {
    const isShow = ref(localStorage.getItem("USER_LOGIN"));
    const onClickLeft = () => history.back();
    return {
      isShow,
      onClickLeft,
    }
  },
  methods: {},
  mounted() {
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

</style>