<template>
  <div class="catalog">
    <van-row gutter="20">
      <van-col span="8">
        <van-button
            round
            color="linear-gradient(to bottom right,rgb(18, 107, 175),rgb(130, 181, 102))"
            icon="add-o"
            :to="'post/approval/'+uid"
        >添加申请
        </van-button
        >
      </van-col>

      <van-col span="8">
        <van-button
            round
            color="linear-gradient(to bottom right,rgb(18, 107, 175),rgb(130, 181, 102))"
            icon="add-o"
            :to="'post/health/'+uid"
        >健康信息申报
        </van-button
        >
      </van-col>

      <van-col span="8">
        <van-button
            round
            color="linear-gradient(to bottom right,rgb(18, 107, 175),rgb(130, 181, 102))"
            icon="chat-o"
            :to="'im/'+uid"
        >进入聊天
        </van-button
        >
      </van-col>

      <van-col span="8">
        <van-button
            round
            color="linear-gradient(to bottom right,rgb(18, 107, 175),rgb(130, 181, 102))"
            icon="comment-o"
            :to="'im/'+uid"
        >查看消息
        </van-button
        >
      </van-col>

      <van-col span="8">
        <van-button
            round
            color="linear-gradient(to bottom right,rgb(18, 107, 175),rgb(130, 181, 102))"
            icon="location-o"
            :to="'im/'+uid"
        >签到
        </van-button
        >
      </van-col>

      <van-col span="8">
        <van-button
            round
            color="linear-gradient(to bottom right,rgb(18, 107, 175),rgb(130, 181, 102))"
            icon="apps-o"
            :to="'im/'+uid"
        >查看课表
        </van-button
        >
      </van-col>

      <van-col span="8">
        <van-button
            round
            color="linear-gradient(to bottom right,rgb(18, 107, 175),rgb(130, 181, 102))"
            icon="share-o"
            :to="'edit/'+0"
        >发布校园动态
        </van-button
        >
      </van-col>

      <van-col span="8">
        <van-button
            round
            color="linear-gradient(to bottom right,rgb(18, 107, 175),rgb(130, 181, 102))"
            icon="hot-o"
            :to="'im/'+uid"
        >我参加的活动
        </van-button
        >
      </van-col>

      <van-col span="8">
        <van-button
            round
            color="linear-gradient(to bottom right,rgb(18, 107, 175),rgb(130, 181, 102))"
            icon="more-o"
        >更多功能敬请期待....
        </van-button
        >
      </van-col>

    </van-row>
  </div>
</template>

<script>
import {useUserStore} from "../../store/user.ts";
import {ref} from "vue";

export default {
  name: "CatalogList",
  setup() {
    const store = useUserStore();
    const uid = ref(0)
    if (JSON.parse(store.getUser)[0].userId!==0){
      uid.value = JSON.parse(store.getUser)[0].userId
    }

    return {
      store,
      uid,
    }
  },
}
</script>

<style scoped>
.catalog {
  padding-top: 46px;
}

.catalog-login {
  text-align: center;
  position: absolute;
  width: 100%;
  top: 50%;
  left: 50%;
  transform: translateX(-50%) translateY(-50%);
}

.catalog-login-action {
  margin-top: 15px;
}

.catalog-login-btn {
  /*width: 80%;*/
  /*font-size: 18px;*/
}

.catalog-login-tip {
  font-size: 18px;
  line-height: 26px;
}

.catalog-fixed-btn {
  position: fixed;
  bottom: 60px;
  left: 50%;
  transform: translateX(-50%);
}
</style>