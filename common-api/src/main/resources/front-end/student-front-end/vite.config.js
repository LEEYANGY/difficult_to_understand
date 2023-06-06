import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue()],
    // 代理配置
    server: {
        proxy:{
            // 指定代理所有/api请求
            '/api': {
                // 代理请求之后的请求地址
                target: 'http://localhost:60001/',
                // 允许跨域
                changeOrigin: true,
                //重写路径,替换/api
                // rewrite: (path) => path.replace(/^\/api/, ""),
                // 路径重写
                rewrite: (path) => path.replace(/^\/api/, ''),
            }
        },
    }
})
