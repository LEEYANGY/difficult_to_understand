<template>
  我的年龄{{store.age}}
</template>

<script>

import {useStore} from '../store/user';

export default {
  name: "Other",
  setup() {
    const store = useStore();
    return {store}
  },
  computed:{

  }
}
</script>

<style scoped>

</style>