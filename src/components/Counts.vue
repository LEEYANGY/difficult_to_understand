<template>
  {{ arr }} <br>
    <span v-for="(a,index) in arr" :key="index">
      <input type="checkbox" v-model="checkedValues" :value="a">{{ a }}
  </span>
  你选中的元素，累加的值和为：{{ selectVal }}
</template>

<script setup>
import {computed, ref, watch} from "vue";

const arr = ref([9, 15, 19, 25, 29, 31, 48, 57, 62, 79, 87])

const checkedValues = ref(JSON.parse(localStorage.getItem("checkedValues")) || [])

const selectVal = computed(() => {
    return checkedValues.value.reduce((sum, value) => sum + value, 0)
})
watch(
    checkedValues, () => {
        localStorage.setItem("checkedValues", JSON.stringify(checkedValues.value))
    },
    arr, () => {
        localStorage.setItem('arr',JSON.stringify(arr.value))
    }
);
</script>

<style scoped>

</style>