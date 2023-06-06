<template>
  <div v-if="this.$route.params.id!==0">
    <van-button round block type="primary" @click="delNotice">
      发布
    </van-button>
  </div>
</template>

<script>
export default {
  name: "Edit"
}
</script>

<style scoped>

</style>