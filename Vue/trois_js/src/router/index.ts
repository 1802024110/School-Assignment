import { createRouter, createWebHistory } from 'vue-router'
import hello_troisJs from "@/views/hello_troisJs.vue";
import birthday_cake from "@/views/birthday_cake.vue";
import div_model from "@/views/div_model.vue";
import audio_visualization from "@/views/audio_visualization.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:"/",
      component:hello_troisJs
    },
    {
      path:"/birthday_cake",
      component:birthday_cake
    },
    {
      path:"/div_model",
      component:div_model
    },
    {
      path:"/audio_visualization",
      component:audio_visualization
    }
  ]
})

export default router
