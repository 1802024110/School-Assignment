<template>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :resize="true">
    <Camera :position="{z:10}"/>
    <Scene :background="0xffcc66">
      <PointLight :position="{y:50,z:50}"/>
      <Box ref="box" :rotation="{y:Math.PI/4,z:Math.PI /4}">
        <PhongMaterial/>
      </Box>
    </Scene>
  </Renderer>
</template>

<script setup>
import {onMounted, ref} from "vue";
const renderer = ref(null)
const box  = ref(null)

onMounted(()=>{
  renderer.value?.onBeforeRender(() => {
    box.value.mesh.rotation.x += 0.01;
  });
})
</script>

<style scoped>

</style>