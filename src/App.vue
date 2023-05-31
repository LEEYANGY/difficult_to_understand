<template>
    <div id="app">
<!--       <ClassContent/>-->
<!--        <Book/>-->
<!--        <Counts/>-->
        <MathResolve/>
    </div>
</template>

<script>
import {ref} from "vue";
import data from "bootstrap/js/src/dom/data.js";
import moment from "moment";
import ClassContent from "@/components/ClassContent.vue";
import Book from "@/components/Book.vue";
import Counts from "@/components/Counts.vue";
import MathResolve from "@/components/MathResolve.vue";

export default {
    components: {MathResolve, Counts, Book, ClassContent}

}
</script>

<style scoped>
#app {
    /*width: 600px;*/
    /*margin: 10px auto;*/
}

</style>
