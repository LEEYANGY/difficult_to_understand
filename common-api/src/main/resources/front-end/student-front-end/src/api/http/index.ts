import {AxiosPromise, AxiosResponse, InternalAxiosRequestConfig} from "axios";
import { Interceptors } from "./request";

// 请求配置
export class HttpServer {
    axios: any;
    // 初始化对象 获取axios实例
    constructor() {
        this.axios = new Interceptors().getInterceptors();
    }
    // 简单封装一下方法
    request(config:InternalAxiosRequestConfig): AxiosPromise {
        return new Promise((resolve, reject) => {
            this.axios(config).then((res: AxiosResponse) => {
                resolve(res);
            }).catch((err: any) => {
                reject(err)
            });
        });
    }

    post(config:InternalAxiosRequestConfig): AxiosPromise {
        return new Promise((resolve, reject) => {
            this.axios.post(config.url, config.data, config).then((res: AxiosResponse) => {
                resolve(res);
            }).catch((err: any) => {
                reject(err)
            });
        });
    }

    get(config:InternalAxiosRequestConfig): AxiosPromise {
        return new Promise((resolve, reject) => {
            this.axios.get(config.url, config).then((res: AxiosResponse) => {
                resolve(res);
            }).catch((err: any) => {
                reject(err)
            });
        });
    }

    delete(config:InternalAxiosRequestConfig): AxiosPromise {
        return new Promise((resolve, reject) => {
            this.axios.delete(config.url, config).then((res: AxiosResponse) => {
                resolve(res);
            }).catch((err: any) => {
                reject(err)
            });
        });
    }

    put(config:InternalAxiosRequestConfig): AxiosPromise {
        return new Promise((resolve, reject) => {
            this.axios.put(config.url, config.data, config).then((res: AxiosResponse) => {
                resolve(res);
            }).catch((err: any) => {
                reject(err)
            });
        });
    }

    patch(config:InternalAxiosRequestConfig): AxiosPromise {
        return new Promise((resolve, reject) => {
            this.axios.patch(config.url, config.data, config).then((res: AxiosResponse) => {
                resolve(res);
            }).catch((err: any) => {
                reject(err)
            });
        });
    }
}

const http = new HttpServer()

export default http