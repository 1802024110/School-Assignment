import { createApp } from 'vue'
import App from './App.vue'

import './assets/main.css'

const app = createApp(App)
app.config.errorHandler = (err) => {
  alert("出错了")
}
app.mount('#app')
