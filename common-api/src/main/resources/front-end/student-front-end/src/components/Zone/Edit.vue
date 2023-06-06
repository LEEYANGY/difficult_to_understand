<template>
  <van-nav-bar
      title="编辑"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
  />
  <van-form @failed="onFailed" @submit="onSubmit">
    <van-cell-group inset>
      <!-- 通过 pattern 进行正则校验 -->
      <van-field
          v-model="title"
          name="title"
          label="文章标题"
          placeholder="文章标题"
          :rules="[{ required: true, message: validatorMessage }]"
      />
      <!-- 通过 validator 进行函数校验 -->
      <van-field
          v-model="content"
          rows="20"
          :autosize="{ maxHeight: 100, minHeight: 25 }"
          label="内容"
          type="textarea"
          maxlength="99999"
          placeholder="请在此输入文字"
          show-word-limit
          :rules="[{ required: true, message: validatorMessage }]"
      />
      <!-- 通过 validator 返回错误提示 -->
      <van-field
          v-model="remark"
          name="remark"
          label="备注"
          placeholder="备注类型"
          :rules="[{ required: false, message: validatorMessage }]"
      />
    </van-cell-group>
    <div style="margin: 16px;">
      <van-button round block type="primary" native-type="submit">
        发布
      </van-button>

      <div v-if="this.$route.params.id!==0">
        <van-button round block type="primary" @click="delZone">
          删除
        </van-button>
      </div>


    </div>
  </van-form>
</template>

<script>
import {ref} from 'vue';
import {closeToast, showDialog, showLoadingToast, showNotify, showToast} from 'vant';
import axios from "axios";
import router from "../../router/index.js";
import {useUserStore} from "../../store/user.ts";

export default {
  name: "Detail",
  setup() {
    const onClickLeft = () => history.back();
    const id = ref(0);
    const title = ref('');
    const content = ref('');
    const remark = ref('');

    // 校验函数返回 true 表示校验通过，false 表示不通过
    const validator = (val) => /1\d{10}/.test(val);

    // 校验函数可以直接返回一段错误提示
    const validatorMessage = (val) => `${val} 不合法，请重新输入`;

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

    if (router.currentRoute.value.params.id) {
      axios.get('/zone-service/system/zone/getDetail/' + router.currentRoute.value.params.id).then(res => {
        if (res.data.code === 200) {
          id.value = res.data.data.id
          title.value = res.data.data.title
          content.value = res.data.data.content
          showToast({type: "success", message: '获取成功'})
        } else {
          showToast({type: "danger", message: res.data.message})
        }
      }).catch((error) => {
        // showDialog({type: "danger", message: "其他错误：" + error});
      });
    } else {
      content.value = ''
    }

    const onSubmit = (values) => {
      console.log('submit', values)
      axios({
        method: 'post',
        url: '/zone-service/system/zone/editZone',
        data: {
          sponsorId: JSON.parse(useUserStore().getUser).userId,
          sponsor: JSON.parse(useUserStore().getUser).userName,
          id: id.value,
          title: title.value,
          content: content.value,
          remark: remark.value,
          createBy: JSON.parse(useUserStore().getUser).userId,
          updateBy: JSON.parse(useUserStore().getUser).userId,
        }
      }).then(res => {
        if (res.data.code === 200) {
          showNotify({type: "success", message: res.data.message});
          router.replace('/catalog');
        } else if (res.data.code === 500) {
          showNotify({type: "danger", message: "服务器内部异常，请联系管理员！"});
        } else {
          showNotify({type: "danger", message: res.data.message});
        }
      })
          .catch((error) => {
            showNotify({type: "danger", message: "其他错误：" + error});
          });
    };

    const delZone = () => {
      axios.delete('/zone-service/system/zone/delZone/' + router.currentRoute.value.params.id).then(res => {
        if (res.data.code === 200) {
          showToast({type: "success", message: "删除成功"})
          router.replace('/catalog')
        } else if(res.data.code === 500){
          showToast({type: "danger", message: "删除失败"})
          router.replace('/catalog')
        }
      })
    }

    return {
      title,
      remark,
      content,
      delZone,
      onSubmit,
      onFailed,
      validator,
      onClickLeft,
      asyncValidator,
      validatorMessage,
    };
  },
}
</script>

<style scoped>

</style>