<!--引入store，用于管理socket推送来的消息-->
import store from "../store/index.js";

const WS = {
    // websocket实例
    $ws: null,
    // websocket链接地址
    wsUrl: 'ws://localhost:18888',
    // 初始化websocket
    createWS: function () {
        if ('WebSocket' in window) {
            this.$ws = new WebSocket(this.wsURl)
            this.$ws.onopen = this.wsOpen
            this.$ws.onmessage = this.wsMessage
            this.$ws.onerror = this.wsError
            this.$ws.onclose = this.wsClose
        } else {
            alert('当前浏览器不支持webSocket')
        }

    },

    // webSocket 打开
    wsOpen: function () {
        this.$ws.send('连接成功')
        console.log('== websocket open ==')
        // <开始心跳
        heartBeat.start()
    },
    // websocket 接收到服务器消息
    wsMessage: function (msg) {
        console.log('== websocket message ==', msg)
        // 接受到消息，重置心跳
        heartBeat.reset()
        store.commit('SET_WS_MSG', msg.data)
    },
    //websocket 发生错误
    wsError: function (err) {
        console.log('== websocket error ==', err)
    },
    //websocket 关闭连接
    wsClose: function (event) {
        console.log('== websocket close ==', event)
    },


}

// webSocket 心跳
const heartBeat = {
    timeout: 30000, // 心跳重连时间
    timeoutObj: null, // 定时器
    reset: function () {
        clearInterVal(this.timeoutObj)
        console.log('websocket 心跳')
        WS.start()
    },
    start: function () {
        this.timeoutObj = setTimeout(function () {
            if (WS.$ws.readyState === 1) {
                WS.$ws.send('HeartBeat')
            }
        }, this.timeout)
    }
}
export default WS
