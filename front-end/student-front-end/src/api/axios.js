import axios from 'axios'
import router from '../router'
import {Dialog, showDialog} from "vant";

/***
* @Param:
* @return:
* @Author: liyangyang
* @Date: 2023/4/25 14:34
* @Description: 模糊匹配
 *
 * 实现过程：
 *  let pathname = "/index/api/dd123456/12345/test" // 这里是不确定的url路由链接
 * let condition = ['index', 'home', 'login'] // 这里是你想要匹配的多个条件
 * if (condition.find(item => pathname.includes(item))) { // 当匹配时,你想要进行的操作
 * 	console.log('匹配')
 * } else {
 * 	console.log('不匹配')
 * }
 *
*/

// 添加白名单
const whiteUrls = ['/login','/home','getDetail','getMaxTotal','getAllArticle','getChatContent','cafeAdd','getTotal','getMyCafeRecord','editZone','delZone','getMyCafeDetailRecord','updateRecord']

axios.defaults.baseURL = "/api"

// 前置拦截
axios.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8';
    console.log('header ==== '+localStorage.getItem('USER_TOKEN'))
    if (!whiteUrls.find(item=>config.url.includes(item))){
        config.headers['Authorization'] = localStorage.getItem('USER_TOKEN')
        // console.log('匹配')
    }else {
        // console.log('不匹配')
        // config.headers['Authorization'] = localStorage.getItem('USER_TOKEN')
    }
    console.log('url===='+config.url)
    return config
})

axios.interceptors.response.use(response => {
        let res = response.data;
        console.log("=================")
        console.log(res)
        console.log("=================")

        if (res.code === 200) {
            return response
        } else {
            return Promise.reject(response.data.msg)
        }
    },
    error => {
        console.log(error)
        if (error.response.data) {
            error.message = error.response.data.msg
        }
        if (error.response.status === 401) {
            router.push("/user/login")
        }
        showDialog({type:"danger",message:"捕获未知错误"})
        return Promise.reject(error)
    }
)