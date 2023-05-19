<script setup>
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
    <nav class="nav">
        <RouterLink to="/">首页</RouterLink>
        <RouterLink to="/material">材质</RouterLink>
    </nav>
  <RouterView/>
</template>

<style>
 .nav{
     width: 100%;
     height: 20px;
     margin: auto 50%;
 }
</style>
