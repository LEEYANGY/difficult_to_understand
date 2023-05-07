<template>
  <van-nav-bar
      title="健康上报"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
  />

  <!--  常规表单-->
  <van-form @submit="onSubmit">
    <van-cell-group inset>
      <!--      姓名-->
      <van-field
          v-model="username"
          name="sponsor"
          label="用户姓名"
          placeholder="用户姓名"
          :rules="[{ required: true, message: '请填写用户姓名' }]"
          readonly
      />

      <!--      工号-->
      <van-field
          v-model="uid"
          name="sponsorId"
          label="工号"
          placeholder="工号"
          :rules="[{ required: true, message: '请填写工号' }]"
          readonly
      />

      <!--      title-->
      <van-field
          v-model="cause"
          is-link
          readonly
          name="eventType"
          label="状态"
          placeholder="点击选择状态"
          @click="showPickerCause = true"
          :rules="[{ required: true, message: '请选择状态' }]"
      />
      <van-popup v-model:show="showPickerCause" position="bottom">
        <van-picker
            :columns="columns"
            @confirm="onConfirmCause"
            @cancel="showPickerCause = false"
        />
      </van-popup>

      <!--      subject-->
      <van-field
          v-model="content"
          name="subject"
          label="描述"
          placeholder="健康可不填写"
      />

    </van-cell-group>
    <div style="margin: 16px;">
      <p>湖北工业大学</p>
      <van-button round block type="primary" native-type="submit">
        提交
      </van-button>
    </div>
  </van-form>

</template>

<script>
import {ref} from "vue";
import {areaList} from '@vant/area-data';
import {useUserStore} from "../../../store/user.ts";
import axios from "axios";
import {showNotify} from "vant";
import router from "../../../router/index.js";

export default {
  name: "Approval",
  setup() {
    const onClickLeft = () => history.back();
    const username = ref(JSON.parse(useUserStore().getUser)[0].userName);
    const uid = ref(JSON.parse(useUserStore().getUser)[0].userId);
    const cause = ref('');
    const showPickerCause = ref(false);
    const content = ref('');
    // 转换申请事由
    const eventType = ref('');
    const columns = [
      {text: '健康', value: '0'},
      {text: '不舒服', value: '1'},
      {text: '感冒', value: '2'},
      {text: '流感', value: '3'},
      {text: '其它', value: '4'},
      // {text: '请假回家', value: '4'},
    ];

    const onConfirmCause = ({selectedOptions}) => {
      cause.value = selectedOptions[0]?.text;
      eventType.value = selectedOptions[0]?.value
      showPickerCause.value = false;
    };

    // 时间
    const timer = ref('');
    const showPickerTimer = ref(false);
    const onConfirmTimer = ({selectedValues}) => {
      timer.value = selectedValues.join('/');
      showPickerTimer.value = false;
    };

    // 区域选择
    const address = ref('');
    const showArea = ref(false);
    const onConfirmAddress = ({selectedOptions}) => {
      showArea.value = false;
      address.value = selectedOptions.map((item) => item.text).join('/');
    };

    // 表单提交
    const onSubmit = (values) => {
      axios({
        method: 'post',
        url: 'system/health/healthReport',
        data: {
          sponsorId: uid.value,
          sponsor: username.value,
          title: cause.value,
          subject: content.value,
          area: address.value,
          backTime: timer.value
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

    return {
      uid,
      timer,
      cause,
      content,
      columns,
      address,
      username,
      areaList,
      showArea,
      showPickerCause,
      showPickerTimer,
      onSubmit,
      onClickLeft,
      onConfirmCause,
      onConfirmTimer,
      onConfirmAddress,
    };
  },
}
</script>

<style scoped>
p {
  text-align: center;
  color: dodgerblue;
}
</style>