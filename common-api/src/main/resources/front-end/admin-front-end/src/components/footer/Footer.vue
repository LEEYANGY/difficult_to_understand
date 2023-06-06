<template>
    <van-tabbar route>
      <van-tabbar-item replace to="/" icon="guide-o">动态管理</van-tabbar-item>
      <van-tabbar-item replace to="/am" icon="todo-list">学生申请管理</van-tabbar-item>
      <van-tabbar-item replace to="/hm" icon="todo-list">学生健康管理</van-tabbar-item>
      <van-tabbar-item replace to="/um" icon="friends">用户管理</van-tabbar-item>
      <van-tabbar-item replace to="/user" icon="friends">用户中心</van-tabbar-item>

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