<template>
  <router-link to="/texture">纹理</router-link>
  <br>
  <router-link to="/animatedSprites">动画精灵</router-link>
  <br>
  <router-link to="/particle">粒子</router-link>
</template>

<script setup>
import * as PIXI from 'pixijs'

</script>

<style scoped>
canvas{
  width: 100vw;
  height: 100vh;
  position: fixed;
  left: 0;
  top: 0;
}
</style>