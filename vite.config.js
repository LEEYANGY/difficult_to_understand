import { defineConfig } from 'vite'
import {fileURLToPath,URL} from 'url'
// import {resolve} from 'path'
import vue from '@vitejs/plugin-vue'

// const path = require('path')
// https://vitejs.dev/config/
export default defineConfig({
  // root: path.resolve(__dirname,'src'),
  resolve: {
    alias: {
      // '~bootstrap': path.resolve(__dirname, 'node_modules/bootstrap'),
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    }
  },
  plugins: [vue()],
  server: {
    port: 9999,
    hot: true
  }
})
