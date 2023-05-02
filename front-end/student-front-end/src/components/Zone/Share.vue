<template>
  <van-nav-bar
      title="编辑"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
  />
  <van-form @failed="onFailed">
    <van-cell-group inset>
      <!-- 通过 pattern 进行正则校验 -->
      <van-field
          v-model="value1"
          name="title"
          label="文章标题"
          placeholder="文章标题"
          :rules="[{ pattern, message: '请输入正确内容' }]"
      />
      <!-- 通过 validator 进行函数校验 -->
      <van-field
          v-model="value2"
          name="context"
          label="文章内容"
          placeholder="文章内容"
          :rules="[{ validator, message: '请输入正确内容' }]"
      />
      <!-- 通过 validator 返回错误提示 -->
      <van-field
          v-model="value3"
          name="remark"
          label="备注"
          placeholder="备注类型"
          :rules="[{ validator: validatorMessage }]"
      />
      <!-- 通过 validator 进行异步函数校验 -->
      <van-field
          v-model="value4"
          name="asyncValidator"
          placeholder="异步函数校验"
          :rules="[{ validator: asyncValidator, message: '请输入正确内容' }]"
      />
    </van-cell-group>
    <div style="margin: 16px;">
      <van-button round block type="primary" native-type="submit">
        提交
      </van-button>
    </div>
  </van-form>


</template>

<script>
import {ref} from 'vue';
import {closeToast, showLoadingToast, showToast} from 'vant';

export default {
  name: "Detail",
  setup() {
    const onClickLeft = () => history.back();
    const value1 = ref('');
    const value2 = ref('');
    const value3 = ref('abc');
    const value4 = ref('');
    const pattern = /\d{6}/;

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

    return {
      onClickLeft,
      value1,
      value2,
      value3,
      value4,
      pattern,
      onFailed,
      validator,
      asyncValidator,
    };
  },
}
</script>

<style scoped>

</style>