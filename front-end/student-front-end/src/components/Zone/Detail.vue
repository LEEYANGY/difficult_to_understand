<template>
  <van-nav-bar
      title="动态详情"
      left-text="返回"
      right-text="修改"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
  />
  <router-view/>
  <van-form>
    <van-cell-group inset>
      <!-- 通过 pattern 进行正则校验 -->
      <p>{{ title }}</p>
      <van-field
          class="preview-auth"
          v-model="authInfo"
          name="title"
          placeholder="auth"
          disabled
      />
      <p v-if="remark">备注:{{remark}}</p>
      <van-field
          v-model="context"
          rows="20"
          :autosize="{ maxHeight: 100, minHeight: 25 }"
          label=""
          type="textarea"
          maxlength="99999"
          placeholder="请在此输入文字"
          show-word-limit
          label-align="center"
          readonly
          disabled
      />
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
      console.log(sponsorBy.value, JSON.parse(store.getUser)[0].userId)
      if (JSON.parse(store.getUser)[0].userId === sponsorBy.value) {
        // 路由传参
        router.push({name: 'edit', params: {id: router.currentRoute.value.params.id}})
      } else {
        showDialog({type: "danger", message: "没有权限"})
      }
    };
    // 作者
    const sponsorBy = ref(0);
    // title
    const title = ref('');
    // 描述
    const remark = ref('');
    const context = ref('动态主题内容，你看到我了吗？');
    const createTime = ref('2023/04/18');
    const auth = ref('作者:admin');
    const authInfo = ref('')

    axios.get('/system/zone/getDetail/' + router.currentRoute.value.params.id).then(res => {
      if (res.data.code === 200) {
        title.value = res.data.data.title
        auth.value = res.data.data.sponsor
        remark.value =  res.data.data.remark
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

    return {
      title,
      remark,
      context,
      authInfo,
      sponsorBy,
      useUserStore,
      onClickLeft,
      onClickRight,
    };
  },
  methods() {
    // this.onClickRight(this.$route.params.id);

  },
}
</script>

<style scoped>
p {
  text-align: center;
}

van-text-ellipsis {
  padding-left: 10px;
}

</style>