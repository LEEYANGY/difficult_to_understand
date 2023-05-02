<template>
  <router-view/>
  <CheckLogin v-if="!isShow && $route.matched.length === 1"/>
  <CatalogList v-if="isShow && $route.matched.length === 1"/>
</template>

<script>
import {ref} from "vue";
import Im from "./IM/Im.vue";
import CheckLogin from "../../components/manager/CheckLogin.vue";
import CatalogList from "../../components/manager/CatalogList.vue";

export default {
  name: "Catalog",
  components: {CatalogList, CheckLogin, Im},
  // ide自动添加属性
  computed: {
    moment() {
      return this.moment
    }
  },
  setup() {
    const isShow = ref(localStorage.getItem("USER_LOGIN"));
    return {
      isShow,
    }
  },
  methods: {},
  mounted() {
  },
  created() {
    //   this.$http({
    //     url:'http://localhost:8888',
    //     method: 'GET',
    //   }).then(data=>{
    //     console.log(data);
    //   })
  },
}
</script>

<style scoped>

</style>