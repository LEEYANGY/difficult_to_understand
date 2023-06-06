<template>
  <router-view/>
  <van-nav-bar
      v-if="isShow && $route.matched.length === 1"
      title="健康上报"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
  />
  <CheckLogin v-if="!isShow && $route.matched.length === 1"/>
  <HealthList v-if="isShow && $route.matched.length === 1"/>
</template>

<script>
import {ref} from "vue";

import CheckLogin from "../../components/manager/CheckLogin.vue";
import HealthList from "../../components/health/HealthList.vue";


export default {
  components: {HealthList, CheckLogin},
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

  },
}
</script>

<style scoped>

</style>