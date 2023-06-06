// import axios from 'axios'
// import { Toast } from 'vant' // 引入vant组件，发送请求时出现提示信息
// // 定义baseURL
// const baseURL = 'http://localhost:3000'
// // 创建axios实例
// const services = axios.create({
//     baseURL:"/api",
//     timeout: 1000, // 1s后还没数据回来结束此次响应
// })
// // 拦截请求
// services.interceptors.request.use(config=>{
//     // 加载提示
//     Toast.loading({
//         message: '加载失败',
//         duration: 0,
//     })
//     return config
// })
// // 拦截响应
// services.interceptors.response.use(resDate=>{
//     // 关闭提示
//     Toast.clear()
//     // 响应数据处理：根据前后端接口规范来处理数据结构
//     if(resDate.status === 200){
//         return resDate.data
//     }
//
//     return Promise.reject(new Error('接口请求异常'))
// })
// export default services

//引入安装好的axios插件
import axios from "axios";
// 查询数据
const get = (url) => {
    return axios.get(url);
};
// 添加数据
const post = (url, data) => {
    return axios.post(url, data);
};
// 修改数据
const put = (url, data) => {
    return axios.put(url, data);
};

// 局部修改
const patch = (url, data) => {
    return axios.patch(url, data);
};

// 删除数据
const del = (url) => {
    return axios.delete(url);
};

//将二次封装好的axios导出
export { get, post, put, del, patch };
