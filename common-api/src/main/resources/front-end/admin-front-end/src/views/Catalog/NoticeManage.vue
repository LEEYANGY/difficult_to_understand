<template>
  <router-view/>
  <List v-if="$route.matched.length === 2"/>

</template>

<script>
import List from "../../components/notice/List.vue";
import Detail from "../../components/Notice/Detail.vue";

export default {
  name: "NoticeManage",
  components: {Detail, List}
}
</script>

<style scoped>

</style>