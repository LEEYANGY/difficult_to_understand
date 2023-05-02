<template>
  <van-nav-bar
      title="用户中心"
      left-text="返回"
      right-text="保存"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
  />
</template>

<script>
export default {
  name: "Header",
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