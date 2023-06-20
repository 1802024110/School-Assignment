import { createSSRApp } from "vue";
import * as Pinia from 'pinia';
import tmui from "./tmui"
import App from "./App.vue";
// 导入拦截器
import "@/common/interceptor"

export function createApp() {
  const app = createSSRApp(App);
  app.use(tmui,{} as Tmui.tmuiConfig)
  return {
    app,
    Pinia
  };
}