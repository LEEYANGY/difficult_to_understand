<template>

  <!--  返回上一级-->
  <van-nav-bar
      :title="roomName"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
  />
  <!--  分割线-->
  <van-divider
      :style="{ color: '#1989fa', borderColor: '#1989fa', padding: '0 16px' }"
  >聊天记录
  </van-divider>

  <div class="content_box" id="box" ref="scrollBox">
    <!--    显示聊天记录最新的日期-->
    <div class="timer">{{ new Date() }}</div>
    <div :class="item.createBy == uid ? 'userbox' : 'userbox2'"
         v-for="(item, index) in chatList"
         :key="index"
    >
      <div :class="item.createBy == uid ? 'nameInfo' : 'nameInfo2'">
        <div style="font-size: 14px">
          {{ item.createBy }}
        </div>
        <div :class="item.createBy == uid ? 'contentText' : 'contentText2'">
          {{ item.subject }}
        </div>
      </div>
      <div>
        <van-image round width="50px" height="50px"
                   src="https://ts1.cn.mm.bing.net/th/id/R-C.729885902b9a3…L%2bPzJGEk3xpdaEX5QqKICr0%3d&risl=&pid=ImgRaw&r=0"/>
      </div>
    </div>
  </div>
  <!--  分割线-->
  <van-divider
      :style="{ color: '#1989fa', borderColor: '#1989fa', padding: '0 16px' }"
  >
  </van-divider>

  <!--  输入框-->
  <div class="bottom">
    <van-cell-group inset class="insert-text">
      <van-field
          v-model="content"
          rows="5"
          :autosize="{ maxHeight: 100, minHeight: 25 }"
          label=""
          type="textarea"
          maxlength="200"
          placeholder="请在此输入文字"
          show-word-limit
          label-align="center"
      >
        <template #button>
          <van-button size="small" type="primary" @click="sendMessage">发送</van-button>
        </template>
      </van-field>
    </van-cell-group>
  </div>

</template>

<script>
import {onMounted, ref} from "vue";
import axios from "axios";
import {useUserStore} from "../../../store/user.ts";
import {showNotify} from "vant";

export default {
  name: "Im",
  setup() {
    const onClickLeft = () => history.back();
    // 需要发送的文本消息
    const content = ref('测试数据')
    // 聊天室名称
    const roomName = ref('')
    // userId
    const uid = ref(JSON.parse(useUserStore().getUser)[0].userId)
    // 聊天记录
    const chatList = ref([{}]);

    // 获取聊天记录
    axios.get('/system/zone/getChatContent/10000000').then(res => {
      chatList.value = res.data.data.chatsContentList
      roomName.value = res.data.data.roomName
    })

    const initChat = () => {
      setTimeout(() => {
        axios.get('/system/zone/getChatContent/10000000').then(res => {
          chatList.value = res.data.data.chatsContentList
        })
      }, 1000);
    }

    // ws  TODO  如何优雅的连接和断开？
    const ws = ref(null);
    const messages = ref([]);

    // 连接
    const connect = () => {
      // 拼接url
      ws.value = new WebSocket("ws://localhost:18888/imserver/" + JSON.parse(useUserStore().getUser)[0].userId);

      ws.value.onmessage = event => {
        console.log('后端发来的消息：' + event.data)
        messages.value.push(event.data);
        // JSON.parse(event.data).users[0].username
        console.log('line 112.====' + event.data)
        showNotify({type: "primary", message: '在线用户:' + JSON.parse(event.data).users[0].username})
      };
    };

    // 断开连接
    const disconnect = () => {
      ws.value.close();
    };


    // 组装消息
    messages.value = {from: uid.value, to: 'lee', text: content.value}

    // 发送聊天信息
    const sendMessage = messages => {
      console.log('line 126.====' + messages.value)

      console.log(JSON.stringify(messages))
      ws.value.send(JSON.stringify(messages));

      chatList.value = chatList.value.concat(
          [
            {
              "createBy": uid,
              "subject": content.value
            }
          ]
      )

    };

    onMounted(() => {
      connect();
    });

    return {
      uid,
      content,
      chatList,
      roomName,
      initChat,
      onClickLeft,
      // ws
      messages,
      sendMessage,
      disconnect
    };
  },

}
</script>

<style scoped>
.tip {
  color: white;
  text-align: center;
  border-radius: 10px;
  font-family: sans-serif;
  padding: 10px;
  width: auto;
  display: inline-block !important;
  display: inline;
}

.right {
  background-color: deepskyblue;
}

.left {
  background-color: forestgreen;
}

.wrap {
  height: 100%;
  width: 100%;
  position: relative;
}

.title {
  height: 40px;
  width: 100%;
  background-color: #eaeaea;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.content_box {
  /*
  中间栏计算高度，110是包含了上下固定的两个元素高度90
  这里padding：10px造成的上下够加了10，把盒子撑大了，所以一共是20要减掉
  然后不知道是边框还是组件的原因，导致多出了一些，这里再减去5px刚好。不然会出现滚动条到顶或者底部的时候再滚动的话就会报一个错，或者出现滚动条变长一下的bug
  */
  height: calc(100% - 115px);
  overflow: auto;
  padding: 10px;
}

.bottom {
  min-height: 50px;
  width: 100%;
  /*border-top: 1px solid #eaeaea;*/
  position: fixed;
  bottom: 50px;
  /*padding-bottom: 40px;*/
}

.timer {
  text-align: center;
  color: #c2c2c2;
}

.userbox {
  width: 100%;
  display: flex;
  margin-bottom: 10px;
}

.nameInfo {
  /* 用flex：1把盒子撑开 */
  flex: 1;
  margin-right: 10px;
  /* 用align-items把元素靠右对齐 */
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

.contentText {
  background-color: #9eea6a;
  /* 把内容部分改为行内块元素，因为盒子flex：1把盒子撑大了，所以用行内块元素让内容宽度不根据父盒子来 */
  display: inline-block;
  /* 这四句是圆角 */
  border-top-left-radius: 10px;
  border-top-right-radius: 0px;
  border-bottom-right-radius: 10px;
  border-bottom-left-radius: 10px;
  /* 最大宽度限定内容输入到百分61换行 */
  max-width: 61%;
  padding: 5px 10px;
  /* 忽略多余的空白，只保留一个空白 */
  white-space: normal;
  /* 换行显示全部字符 */
  word-break: break-all;
  margin-top: 3px;
  font-size: 14px;
}

/* 接收的信息样式 */
/*
左边消息思路解释：跟上面一样，就是换一下位置，首先通过把最外层大盒子的排列方式通过flex-direction: row-reverse;属性翻转，也就是头像和文字盒子换位置
然后删除掉尾部对齐方式，因为不写这个默认是左对齐的。我们写的左边就没必要再写了。
*/
.userbox2 {
  width: 100%;
  display: flex;
  flex-direction: row-reverse;
  margin-bottom: 10px;
}

.nameInfo2 {
  /* 用flex：1把盒子撑开 */
  flex: 1;
  margin-left: 10px;
}

.contentText2 {
  background-color: #9eea6a;
  /* 把内容部分改为行内块元素，因为盒子flex：1把盒子撑大了，所以用行内块元素让内容宽度不根据父盒子来 */
  display: inline-block;
  /* 这四句是圆角 */
  border-top-left-radius: 0px;
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
  border-bottom-left-radius: 10px;
  /* 最大宽度限定内容输入到百分61换行 */
  max-width: 61%;
  padding: 5px 10px;
  /* 忽略多余的空白，只保留一个空白 */
  white-space: normal;
  /* 换行显示全部字符 */
  word-break: break-all;
  margin-top: 3px;
  font-size: 14px;
}
</style>