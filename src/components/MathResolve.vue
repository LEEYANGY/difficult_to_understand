<template>
    <div class="card">
        <h3>测试题</h3>
        <div v-for="(item,index) in d">
            {{ item.first }} + {{ item.second }} = <input type="text" style="width: 50px" v-model="d[index].sum">
              &nbsp; <button class="btn btn-primary" @click="submit(index)">提交
                </button>
        </div>
        <p>
      <span v-for="(i,index) in d">
        <span :style="{ color: i.color}">{{ index + 1 }}:{{ d[index].result }}&nbsp;&nbsp;</span>
      </span>
        </p>
    </div>
</template>

<script setup>
import {computed, reactive, ref} from "vue";

const gray = "#C0C0C0"
const red = "#FF0000"
const green = "#00FF00"
const getRandom = () => {
    return Math.floor(Math.random() * 10)
}

const d = reactive([
    {
        first: getRandom(),
        second: getRandom(),
        sum: null,
        result: "未完成",
        color: gray
    }, {
        first: getRandom(),
        second: getRandom(),
        sum: null,
        result: "未完成",
        color: gray

    }, {
        first: getRandom(),
        second: getRandom(),
        sum: null,
        result: "未完成",
        color: gray

    }, {
        first: getRandom(),
        second: getRandom(),
        sum: null,
        result: "未完成",
        color: gray

    }, {
        first: getRandom(),
        second: getRandom(),
        sum: null,
        result: "未完成",
        color: gray

    }
])


const submit = (index) => {
    if (d[index].sum === null) {
        return
    }
    const c = d[index]
    const s = c.first + c.second
    if (s === parseInt(d[index].sum)) {
        d[index].color = green
        d[index].result = "正确"

    } else {
        d[index].color = red
        d[index].result = "错误"

    }
}
</script>

<style scoped>

</style>