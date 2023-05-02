<template>
  <Header msg="我的申请记录"/>
  <div class="qr">

    <qrcode-vue :value="qrvalue" :size="qrsize" level="H"></qrcode-vue>
  </div>
  <van-form @submit="onSubmit">
    <van-cell-group inset>
      <!--      申请原因-->
      <van-field
          v-model="cause"
          name="title"
          label="申请原因"
          placeholder="请从下方事由中选择"
          :rules="[{ required: true, message: '请填写申请原因' }]"
          readonly
      />

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

      <!--      事由-->
      <van-field
          v-model="cause"
          is-link
          readonly
          name="eventType"
          label="事由"
          placeholder="点击选择事由"
          @click="showPickerCause = true"
          :rules="[{ required: true, message: '请选择事由' }]"
      />
      <van-popup v-model:show="showPickerCause" position="bottom">
        <van-picker
            :columns="columns"
            @confirm="onConfirmCause"
            @cancel="showPickerCause = false"
        />
      </van-popup>

      <!--      去哪？-->
      <van-field
          v-model="address"
          is-link
          readonly
          name="area"
          label="前往位置"
          placeholder="点击选择省市区"
          @click="showArea = true"
          :rules="[{ required: true, message: '请选择' }]"
      />
      <van-popup v-model:show="showArea" position="bottom">
        <van-area
            :area-list="areaList"
            @confirm="onConfirmAddress"
            @cancel="showArea = false"
        />
      </van-popup>

      <!--      时间选择-->
      <van-field
          v-model="timer"
          is-link
          name="backTime"
          label="返校时间选择"
          placeholder="点击选择时间"
          @click="showPickerTimer = true"
          :rules="[{ required: true, message: '请选择' }]"
      />
      <van-popup v-model:show="showPickerTimer" position="bottom">
        <van-date-picker @confirm="onConfirmTimer" @cancel="showPickerTimer = false"/>
      </van-popup>

    </van-cell-group>
    <div style="margin: 16px;">
      <p>湖北工业大学</p>
      <van-button round block type="primary" native-type="submit">
        发送修改申请
      </van-button>
    </div>
  </van-form>

</template>

<script>
import axios from "axios";
import QrcodeVue from 'qrcode.vue';
import router from "../../../../router/index.js";
import Header from "../../../../components/header/Header/Header.vue";
import {areaList} from "@vant/area-data";
import {showNotify, showToast} from "vant";
import {ref} from "vue";


export default {
  name: "RecordDetail",

  computed: {
    areaList() {
      return areaList
    }
  },
  components: {Header, QrcodeVue},
  setup() {
    const tid = ref(0)
    const username = ref('');
    const uid = ref('');
    // 初始化二维码信息
    const qrvalue = ref(JSON.stringify({qr_status: "error_init,please contact admin solver this problem!"}));
    //二维码大小
    const qrsize = 200;
    const cause = ref('');
    const showPickerCause = ref(false);
    const eventType = ref('');
    const columns = [
      {text: '实习', value: '0'},
      {text: '看病', value: '1'},
      {text: '探亲', value: '2'},
      {text: '培训', value: '3'},
      {text: '请假回家', value: '4'},
      {text: '其它', value: '5'},
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

    axios.get('/system/event/getMyCafeDetailRecord/' + router.currentRoute.value.params.id)
        .then(res => {
          if (res.data.code === 200) {
            tid.value = res.data.data.id
            cause.value = res.data.data.title
            username.value = res.data.data.sponsor
            uid.value = res.data.data.sponsorId
            timer.value = res.data.data.backTime
            address.value = res.data.data.area
            eventType.value = res.data.data.eventType
            showToast({type: "success", message: '获取成功'})
            //传入的值，要求是字符串,需要将对象进行转换
            qrvalue.value = JSON.stringify(res.data.data);
          } else if (res.data.code === 404) {
            showToast({type: "danger", message: res.data.message})
          }
        })


    const onSubmit = (values) => {
      axios({
        method: 'put',
        url: 'system/event/updateRecord',
        data: {
          id: tid.value,
          sponsorId: uid.value,
          sponsor: username.value,
          title: cause.value,
          eventType: eventType.value,
          area: address.value,
          backTime: timer.value,
          status: 1,
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

    const creatQrCode = () => {

    };

    return {
      uid,
      timer,
      cause,
      qrsize,
      qrvalue,
      address,
      columns,
      username,
      showArea,
      eventType,
      showPickerTimer,
      showPickerCause,
      onSubmit,
      creatQrCode,
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

.qr {
  text-align: center;
}
</style>