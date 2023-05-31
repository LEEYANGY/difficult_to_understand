<template>
    <div class="container">
        <!-- 顶部框模块 -->
        <div class="form-group">
            <div class="input-group">
                <h4>品牌管理</h4>
            </div>
        </div>

        <!-- 数据表格 -->
        <table class="table table-bordered table-hover mt-2">
            <thead>
            <tr>
                <th>编号</th>
                <th>资产名称</th>
                <th>价格</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="obj in list" :key="obj.id">
                <td>{{ obj.id }}</td>
                <td>{{ obj.name }}</td>

                <!-- 如果价格超过100，就有red这个类 -->
                <td :class="{red: obj.price > 100}">{{ obj.price }}</td>
                <td>{{ obj.time }}</td>
                <button type="button" @click="delElement(obj.id)" class="btn  btn-outline-primary">删除</button>
            </tr>
            </tbody>

            <tfoot v-show="showNoMore">
            <tr>
                <td colspan="5" style="text-align: center">暂无数据</td>
            </tr>
            </tfoot>

            <tr style="background-color: #EEE">
                <td>统计:</td>
                <td colspan="2">总价钱为: {{ totalPrice }}</td>
                <td colspan="2">平均价: {{ avgPrice }}</td>
            </tr>

        </table>

        <!-- 添加资产 -->
        <form class="form-inline">
            <div class="form-group">
                <div class="input-group">
                    <input
                            v-model="pname"
                            type="text"
                            class="form-control"
                            placeholder="资产名称"
                    />
                </div>
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <div class="form-group">
                <div class="input-group">
                    <input
                            v-model.number="pprice"
                            type="text"
                            class="form-control"
                            placeholder="价格"
                    />
                </div>
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <!-- 阻止表单提交 -->
            <button type="button" class="btn btn-primary" @click="addElement(values)">添加资产</button>
        </form>
    </div>
</template>

<script>
import {ref} from "vue";
import moment from "moment/moment.js";

export default {
    name: "ClassContent",
    setup() {
        // 没得删了提示文字
        const showNoMore = ref(false)
        const list = ref(JSON.parse(localStorage.getItem('plist')) || [])
        const pname = ref('')
        const pprice = ref('')
        const pid = ref('')
        return {
            pname,
            pprice,
            pid,
            list,
            showNoMore,
        }
    },
    methods: {
        // 添加
        addElement() {
            if (this.pname.trim().length === 0 || this.pprice === 0) {
                alert("不能为空");
                return;
            } else {
                this.list.push({
                    id: this.list[this.list.length - 1].id + 1,
                    name: this.pname,
                    price: this.pprice,
                    time: new Date()
                })
                // localStorage.setItem('plist', JSON.stringify(this.list))
            }
        },
        // 删除
        delElement(value) {
            // 原先我的写法 list.pop(value)
            // console.log(this.list.pop(value))
            // let index = this.list.findIndex(obj => obj.id === value);
            // this.list.splice(this.list.findIndex(index, 1)
            // 删除
            this.list.splice(this.list.findIndex(obj => obj.id === value), 1);
            // localStorage.setItem('plist', JSON.stringify(this.list))
            if (this.list.length === 0) {
                this.showNoMore = true
            } else {
                this.showNoMore = false
            }
        },
    },
    filters: {
        formatDate(val) {
            return moment(val).format('YYYY-MM-DD')
        }
    },
    computed: {
        totalPrice() {
            // 3. 求总价
            return this.list.reduce((sum, obj) => sum += obj.price, 0)
        },
        avgPrice(){
            // 4. 求均价 - 保留2位小数
            console.log(this.totalPrice)
            console.log(this.list.length)
            return (this.totalPrice / this.list.length).toFixed(2)
        }
    },
    // watch: {
    //     "要侦听的属性名": {
    //         immediate: true, // 立即执行
    //         deep: true, // 深度侦听复杂类型内变化
    //         handler (newVal, oldVal) {
    //
    //         }
    //     }
    // }
    watch: {
        list: {
            handler(newVal, oldVal) {
                // user里的对象
                console.log(newVal, oldVal);
                localStorage.setItem('plist', JSON.stringify(this.list))
            },
            deep: true,
            // immediate: true
        }
    },
}
</script>

<style scoped>

.tb {
    border-collapse: collapse;
    width: 100%;
}

.tb th {
    background-color: #0094ff;
    color: white;
}

.tb td,
.tb th {
    padding: 5px;
    border: 1px solid black;
    text-align: center;
}

.add {
    padding: 5px;
    border: 1px solid black;
    margin-bottom: 10px;
}

.red {
    color: red;
}
</style>