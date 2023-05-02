<template>
  <van-nav-bar
      :title="msg"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
  />
</template>

<script>
import {showToast} from "vant";
import {ref} from "vue";

export default {
  name: "Header",
  setup() {
    const onClickLeft = () => history.back();
    return {
      onClickLeft,
    };
  },
  props:{
    msg:{
      type: String,
      required: true
    },
  },
}
</script>

<style scoped>

</style>