import { createRouter, createWebHistory } from 'vue-router'
import hello_cube from "@/views/hello_cube.vue";
import sun_earth_and_moon from "@/views/sun_earth_and_moon.vue";
import material from "@/views/material.vue";
import texture from "@/views/texture.vue";
import illumination from "@/views/illumination.vue";
import gsap from "@/views/gsap.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {path:'/',component:hello_cube},
    {path:'/sun_earth_and_moon',component:sun_earth_and_moon},
    {path:'/material',component:material},
    {path:'/texture',component:texture},
    {path:'/illumination',component:illumination},
    {path:'/gsap',component:gsap},
  ]
})

export default router
