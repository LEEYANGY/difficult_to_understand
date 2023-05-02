<template>
  <van-nav-bar
      title="用户中心"
      left-text="返回"
      right-text="保存"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
  />

  <van-skeleton title avatar :row="3" />

</template>

<script>
export default {
  name: "UserInfo",
  setup() {
    const onClickLeft = () => history.back();
    const onClickRight = () => showToast('保存了吼~');
    return {
      onClickLeft,
      onClickRight,
    };
  },
}
</script>

<style scoped>

</style>