<template>
    <van-tabbar route>
      <van-tabbar-item replace to="/" icon="guide-o">校园动态</van-tabbar-item>
      <van-tabbar-item replace to="/catalog" icon="todo-list">学校专区</van-tabbar-item>
      <van-tabbar-item replace to="/user" icon="friends">用户中心</van-tabbar-item>
      <van-tabbar-item replace to="/other" icon="setting">调试</van-tabbar-item>
    </van-tabbar>
</template>
<van-icon name="friends" />
<script>
export default {
  name: "Footer"
}
</script>

<style scoped>

</style>