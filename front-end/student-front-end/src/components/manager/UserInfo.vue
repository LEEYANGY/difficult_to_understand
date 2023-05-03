<template>


<!--  <van-skeleton title avatar :row="3" v-if="init_skeleton">111111111111111111</van-skeleton>-->
  <FormTable/>



</template>

<script>
import {showToast} from "vant";

import {ref} from "vue";
import FormTable from "../event/FormTable.vue";

export default {
  name: "UserInfo",
  components: {FormTable},
  setup() {
    const onClickLeft = () => history.back();
    const onClickRight = () => showToast({type: "success", message: "保存了吼"});
    // 控制骨架屏显示时机，数据加载成功后，不让其显示
    const init_skeleton = ref(1);

    return {
      init_skeleton,
      onClickLeft,
      onClickRight,
    };
  },
}
</script>

<style scoped>

</style>