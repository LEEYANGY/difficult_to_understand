<template xmlns:bind="https://jakarta.ee/xml/ns/jakartaee">
    <router-view/>
    <Search/>
    <Notices v-show="isShow"/>
    <Zone/>
</template>

<script>
import {ref} from 'vue';
// import index from "vuex";
import Notices from "../../components/Notices.vue";
import Zone from "../../components/Zone/Zone.vue";
import Search from "../../components/Zone/Search.vue";

export default {
  name: "Home",
  components: {Search, Zone, Notices},
  computed: {
    // index() {
      // return index
    // }
  },
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