<template>
  <van-nav-bar
      title="动态详情"
      left-text="返回"
      right-text="修改"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
  />
  <van-form @failed="onFailed">
    <van-cell-group inset>
      <!-- 通过 pattern 进行正则校验 -->
      <van-field
          class="preview-title"
          v-model="title"
          name="title"
          placeholder="文章标题"
          disabled
      />
      <van-field
          class="preview-auth"
          v-model="authInfo"
          name="title"
          placeholder="auth"
          disabled
      />

      <van-text-ellipsis
          rows="2"
          :content="context"
          expand-text="展开"
          collapse-text="收起"
      />

      <!-- 通过 validator 返回错误提示 -->
      <!-- 通过 validator 进行异步函数校验 -->
<!--      <van-field-->
<!--          v-model="value4"-->
<!--          name="asyncValidator"-->
<!--          placeholder="异步函数校验"-->
<!--          :rules="[{ validator: asyncValidator, message: '请输入正确内容' }]"-->
<!--      />-->
    </van-cell-group>
  </van-form>
</template>

<script>
import {closeToast, showDialog, showLoadingToast, showToast, Toast} from "vant";
import {ref} from "vue";
import {useUserStore} from "../../store/user.ts";
import router from "../../router/index.js";
import axios from "axios";

export default {
  name: "Detail",
  setup() {
    const store = useUserStore();

    // const
    const onClickLeft = () => history.back();
    const onClickRight = () => {
      console.log(sponsorBy.value,JSON.parse(store.getUser)[0].userId)
      if (JSON.parse(store.getUser)[0].userId===sponsorBy.value){
      // 路由传参

      router.push({name: 'edit', params: {id: id}})
      }else {
        showDialog({type:"danger",message:"没有权限"})
      }
    };
    const sponsorBy = ref(0);
    const title = ref('');
    const description = ref('');
    const context = ref('动态主题内容，你看到我了吗？');
    const value4 = ref('');
    const pattern = /\d{6}/;
    const createTime = ref('2023/04/18');
    const auth = ref('作者:admin');
    const authInfo = ref('')
    console.log('this.$route.params.id====' + router.currentRoute.value.params.id);
    // tid.value =
    const id = router.currentRoute.value.params.id;
    // 校验函数返回 true 表示校验通过，false 表示不通过
    const validator = (val) => /1\d{10}/.test(val);
    // 校验函数可以直接返回一段错误提示
    const validatorMessage = (val) => `${val} 不合法，请重新输入`;

    const jsonParse = (obj) => {
      return JSON.parse(JSON.stringify(obj));
    };


    axios.get('/system/zone/getDetail/' + id).then(res => {
      console.log(id)
      if (res.data.code === 200) {
        // const details =  jsonParse()
        title.value = res.data.data.title
        auth.value = res.data.data.sponsor
        createTime.value = res.data.data.createTime
        authInfo.value = '发布人: ' + auth.value + '      ' + '创建时间:' + createTime.value + '    ';
        context.value = res.data.data.content
        sponsorBy.value = res.data.data.createBy
        showToast({type: "success", message: '获取成功'})

      } else {
        showToast({type: "danger", message: res.data.message})
      }
    }).catch((error) => {
      showDialog({type: "danger", message: "其他错误：" + error});
    });

    // 校验函数可以返回 Promise，实现异步校验
    const asyncValidator = (val) =>
        new Promise((resolve) => {

          showLoadingToast('验证中...');
          setTimeout(() => {
            closeToast();
            resolve(val === '1234');
          }, 1000);
        });

    const onFailed = (errorInfo) => {
      console.log('failed', errorInfo);
    };

    // const onLoad =

    return {
      id,
      title,
      value4,
      context,
      pattern,
      authInfo,
      sponsorBy,
      description,
      onFailed,
      jsonParse,
      validator,
      onClickLeft,
      useUserStore,
      onClickRight,
      asyncValidator,
    };
  },
  methods() {
    // this.onClickRight(this.$route.params.id);

  },
}
</script>

<style scoped>
.preview-title {
  text-align: center;
}

van-text-ellipsis{
  padding-left: 10px;
}

</style>