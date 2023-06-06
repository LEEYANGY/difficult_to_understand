<template>
  <van-nav-bar
      title="通知详情"
      left-text="返回"
      :right-text="delContent"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
  />
  <van-form>
    <van-cell-group inset>
      <!-- 通过 pattern 进行正则校验 -->
      <van-field
          class="preview-auth"
          v-model="title"
          name="title"
          label="通知标题"
          placeholder="通知标题"
      />
      <van-field
          class="preview-auth"
          v-model="authInfo"
          name="title"
          placeholder="auth"
          disabled
      />
      <p v-if="remark">备注:{{ remark }}</p>
      <van-field
          v-model="context"
          rows="20"
          :autosize="{ maxHeight: 100, minHeight: 25 }"
          label="通知内容"
          type="textarea"
          maxlength="99999"
          placeholder="请在此输入文字"
          show-word-limit
          label-align="center"
      />
    </van-cell-group>

    <div v-if="this.$route.params.id!==0">
      <van-button round block type="primary" @click="onSubmit">
        {{ showContent }}
      </van-button>
    </div>
  </van-form>
</template>

<script>
import {useUserStore} from "../../store/user.ts";
import router from "../../router/index.js";
import {ref} from "vue";
import axios from "axios";
import {showDialog, showNotify, showToast} from "vant";
import List from "../../components/notice/List.vue";

export default {
  name: "Detail",
  components: {List},
  setup() {
    const store = useUserStore();
    // const
    const onClickLeft = () => history.back();
    const onClickRight = () => {
      // 路由传参
      // router.push({name: 'edit', params: {id: router.currentRoute.value.params.id}})
      // axios
      axios.delete('/message-service/system/message/admin/delMessage/'+router.currentRoute.value.params.id).then(res => {
        if (res.data.code === 200) {
          showToast({type: "success", message: "删除成功"})
          router.replace('/nm')
        } else if(res.data.code === 501){
          showToast({type: "danger", message: res.data.message})
          router.replace('/nm')
        }
      })
    };


    // 作者
    const sponsorBy = ref(0);
    // title
    const title = ref('');
    // 描述
    const remark = ref('');
    const context = ref('');
    const createTime = ref('2023/04/18');
    const auth = ref(JSON.parse(useUserStore().getUser).userId);
    const authInfo = ref(JSON.parse(useUserStore().getUser).userId)

    if (router.currentRoute.value.params.id === 0) {

    } else {
      axios.get('/message-service/system/message/admin/getDetail/' + router.currentRoute.value.params.id).then(res => {
        if (res.data.code === 200) {
          title.value = res.data.data.title
          auth.value = res.data.data.author
          remark.value = res.data.data.remark
          createTime.value = res.data.data.createTime
          authInfo.value = '发布人: ' + auth.value + '      ' + '创建时间:' + createTime.value + '    ';
          context.value = res.data.data.subject
          sponsorBy.value = res.data.data.createBy
          showToast({type: "success", message: '获取成功'})
        } else {
          showToast({type: "danger", message: res.data.message})
        }
      })
    }

    const showContent = ref('')
    const delContent = ref('')
    if (router.currentRoute.value.params.id === 0) {
      showContent.value = '修改'

    } else {
      showContent.value = '发布'
      delContent.value='删除'
    }

    const onSubmit = () => {
      axios({
        method: 'post',
        url: 'admin/editMessage',
        data: {
          author: JSON.parse(useUserStore().getUser).userId,
          sponsor: JSON.parse(useUserStore().getUser).userName,
          id: router.currentRoute.value.params.id,
          title: title.value,
          subject: context.value,
          remark: remark.value,
          createBy: JSON.parse(useUserStore().getUser).userId,
          updateBy: JSON.parse(useUserStore().getUser).userId,
        }
      }).then(res=>{
        if (res.data.code === 200) {
          showNotify({type: "success", message: res.data.message});
          router.replace('/nm');
        } else if (res.data.code === 500) {
          showNotify({type: "danger", message: "服务器内部异常，请联系管理员！"});
        } else {
          showNotify({type: "danger", message: res.data.message});
        }
      })
    }

    return {
      title,
      remark,
      context,
      authInfo,
      sponsorBy,
      delContent,
      showContent,
      useUserStore,
      onSubmit,
      onClickLeft,
      onClickRight,
    };
  },
}
</script>

<style scoped>

</style>