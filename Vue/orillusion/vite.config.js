import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import sass from 'sass';
import path from 'path';
// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  css: {
    preprocessorOptions: {
      scss: {
        implementation: sass
      }
    }
  }
})
