<template>
  <van-search
      value="{{ value }}"
      label="查找动态"
      placeholder="请输入搜索关键词"
      use-action-slot
      bind:change="onChange"
      bind:search="onSearch"
  >
    <view slot="action" bind:tap="onClick">搜索</view>
  </van-search>
</template>

<script>
export default {
  name: "Search"
}
</script>

<style scoped>

</style>