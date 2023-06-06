<template>
  <van-nav-bar
      title="健康上报管理"
      left-text="返回"
      left-arrow
      right-text="删除"
      @click-left="onClickLeft"
      @click-right="onClickRight"
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

      <!--      createTime-->
      <van-field
          v-model="reportTime"
          name="createTime"
          label="上报时间"
          placeholder="上报时间"
      />
    </van-cell-group>
    <div style="margin: 16px;">
      <p>湖北工业大学工程技术学院</p>
      <van-button round block type="primary" native-type="submit">
        提交
      </van-button>
    </div>
  </van-form>

</template>

<script>
import {ref} from "vue";
import {areaList} from '@vant/area-data';
import {useUserStore} from "../../store/user.ts";
import axios from "axios";
import {showNotify} from "vant";
import router from "../../router/index.js";

export default {
  name: "Approval",
  setup() {
    const onClickLeft = () => history.back();
    const username = ref('');
    const uid = ref();
    const cause = ref('');
    const showPickerCause = ref(false);
    const content = ref('');
    const reportTime = ref()
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

    // 区域选择
    const address = ref('');
    const showArea = ref(false);
    const onConfirmAddress = ({selectedOptions}) => {
      showArea.value = false;
      address.value = selectedOptions.map((item) => item.text).join('/');
    };

    axios.get('/health-service/system/health/admin/getUserHealthDetailById/' + router.currentRoute.value.params.id).then(res => {
      if (res.data.code === 200) {
        username.value = res.data.data.sponsor;
        uid.value = res.data.data.sponsorId;
        cause.value = res.data.data.title;
        content.value = res.data.data.subject;
        reportTime.value = res.data.data.createTime
        showNotify({type: "success", message: res.data.message});
      } else if (res.data.code === 500) {
        showNotify({type: "danger", message: "服务器内部异常，请联系管理员！"});
      } else if (res.data.code === 501) {
        showNotify({type: "danger", message: res.data.message});
      } else {
        showNotify({type: "danger", message: res.data.message});
      }
    })
        .catch((error) => {
          showNotify({type: "danger", message: "其他错误：" + error});
        });

    // 表单提交
    const onSubmit = (values) => {
      axios({
        method: 'post',
        url: '/health-service/system/health/healthReport',
        data: {
          id: router.currentRoute.value.params.id,
          title: cause.value,
          subject: content.value,
          eventType: eventType.value,
          sponsor: username.value,
          sponsorId: uid.value,
          area: address.value,
          updateBy: JSON.parse(useUserStore().getUser).userId
        }
      }).then(res => {
        if (res.data.code === 200) {
          showNotify({type: "success", message: res.data.message});
          router.replace('/hm');
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

    const onClickRight = () => {
      axios.delete('/health-service/system/health/admin/delUserHealthById/' + router.currentRoute.value.params.id).then(res => {
        if (res.data.code === 200) {
          showNotify({type: "success", message: res.data.message});
          router.replace('/hm');
        } else if (res.data.code === 500) {
          showNotify({type: "danger", message: "服务器内部异常，请联系管理员！"});
        } else {
          showNotify({type: "danger", message: res.data.message});
        }
      })
          .catch((error) => {
            showNotify({type: "danger", message: "其他错误：" + error});
          });
    }

    return {
      uid,
      cause,
      content,
      columns,
      address,
      username,
      areaList,
      showArea,
      reportTime,
      showPickerCause,
      onSubmit,
      onClickLeft,
      onClickRight,
      onConfirmCause,
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