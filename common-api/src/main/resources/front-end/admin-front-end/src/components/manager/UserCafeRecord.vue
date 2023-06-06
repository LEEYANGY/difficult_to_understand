<template>
  <Header msg="我的申请记录"/>

  <RecordList/>
<!--  <RecordList v-if="isShow && $route.matched.length === 1"/>-->
  <!--    回到顶部-->
<!--  <van-back-top right="15vw" bottom="10vh"/>-->
</template>

<script>
import Header from "../../../../components/header/Header/Header.vue";
import {ref} from "vue";
import axios from "axios";
import {showDialog} from "vant";
import {useUserStore} from "../../../../store/user.ts";
import index from "vuex";
import RecordList from "../../../../components/manager/RecordList.vue";

export default {
  name: "UserCafeRecord",
  components: {RecordList, Header},
  setup() {
    const isShow =ref(localStorage.getItem("USER_LOGIN"));
    return {
      isShow,
    }
  },
  methods(){

  },
}
</script>

<style scoped>

</style>