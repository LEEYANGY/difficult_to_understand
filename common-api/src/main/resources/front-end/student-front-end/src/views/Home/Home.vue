<template>
  <router-view/>
  <!--  路由嵌套 使用 v-if="$route.matched.length === 1" 判断是不是父路由，如果是显示，反之...-->
  <Search v-if="$route.matched.length === 1"/>
  <Notices v-show="isShow" v-if="$route.matched.length === 1"/>
  <Zone v-if="$route.matched.length === 1"/>
</template>

<script>
import {ref} from 'vue';
import Notices from "../../components/Notices.vue";
import Zone from "../../components/Zone/Zone.vue";
import Search from "../../components/Zone/Search.vue";

export default {
  name: "Home",
  components: {Search, Zone, Notices},
  computed: {},
  setup() {
    // 是否显示通知消息  TODO 需要修改成登录后，message中有内容可消费，否则 即使登录了也不展示通知
    const isShow = ref((localStorage.getItem("USER_LOGIN")));
    return {
      isShow,
    };
  },
  methods: {},
  mounted() {
  }
};
</script>

<style scoped>

</style>