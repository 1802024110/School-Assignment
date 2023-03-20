import Home from "@/views/home.vue";
import Texture from "@/views/texture.vue";
import animatedSprites from "@/views/animatedSprites.vue";
import particle from "@/views/particle.vue";
import wave_droplets from "@/views/wave_droplets.vue";

const routes = [
    { path: '/',  component:Home},
    { path: '/texture',  component:Texture},
    { path: '/animatedSprites',  component:animatedSprites},
    { path: '/particle',  component:particle},
]

export default routes