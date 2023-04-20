import axios from 'axios'
import router from '../router'
import store from '../store'
import nprogress from "nprogress";
import {Dialog} from "vant";


axios.defaults.baseURL = "/api"

// 设置请求头
let reqInstance = axios.create({
    headers: {
        Authorization: 'Bearer ${localStorage.getItem("access_token")'
    }
})


// 前置拦截
axios.interceptors.request.use(config => {
    nprogress.start();
    return config
})

axios.interceptors.response.use(response => {
        let res = response.data;

        console.log("=================")
        console.log(res)
        console.log("=================")

        if (res.code === 200) {
            nprogress.done();
            // Element.Message.success(res.message, {duration: 3 * 1000})
            return response
        } else {
            // Element.Message.error(res.message, {duration: 3 * 1000})
            return Promise.reject(response.data.msg)
        }
    },
    error => {
        // console.log(error)
        if (error.response.data) {
            error.message = error.response.data.msg
        }

        if (error.response.status === 401) {
            store.commit("REMOVE_INFO")
            router.push("/user/login")
        }

        Element.Message.error(error.message, {duration: 3 * 1000})
        return Promise.reject(error)
    }
)