<template>
    <div>
        <p>请选择你要购买的书籍</p>
        <ul v-for="(b,index) in books" :key="index">
            {{ b.name }}
            <button type="button" class="btn btn-primary" @click="b.count++">购买</button>
        </ul>
        <table border="1" width="500" cellspacing="0">
            <tr>
                <th>序号</th>
                <th>书名</th>
                <th>单价</th>
                <th>数量</th>
                <th>合计</th>
            </tr>
            <tr v-for="(b,index) in books" :key="index">
                <th>{{ index + 1 }}</th>
                <th>{{ b.name }}</th>
                <th>{{ b.price }}</th>
                <th>{{ b.count }}</th>
                <th>{{ b.count * b.price }}</th>
            </tr>
        </table>
        <p>总价格为:{{ allPrice }} </p>
    </div>
</template>

<script setup>
import {computed, ref, watch} from "vue";

const books = ref(JSON.parse(localStorage.getItem('books')) || [
    {
        name: "水浒传",
        price: 107,
        count: 0,
    },
    {
        name: "西游记",
        price: 192,
        count: 0,
    },
    {
        name: "三国演义",
        price: 219,
        count: 0,
    },
    {
        name: "红楼梦",
        price: 178,
        count: 0,
    },
])

let allPrice = computed(() => {
    return books.value.reduce((sum, obj) => sum += obj.price * obj.count, 0)
})

watch(allPrice, () => {
    console.log(allPrice.value)
    localStorage.setItem('books', JSON.stringify(books.value))
})

</script>

<style scoped>

</style>