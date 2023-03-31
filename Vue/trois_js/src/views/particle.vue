<!--https://juejin.cn/post/6844903615438553096-->
<!--https://github.com/youngdro/3DPoints-->
<template>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :resize="true">
    <Camera :position="{z:100}"/>
    <Scene :background="0xffcc66" ref="scene">
      <PointLight :position="{y:50,z:50}"/>
    </Scene>
  </Renderer>
</template>

<script setup>
import {onMounted, ref} from "vue";
import {
    Particle,
    ParticleBasicMaterial,
    Points,
    PointsMaterial,
    RawShaderMaterial,
    SphereGeometry,
    Sprite
} from "three";

const scene = ref(null)
const renderer = ref(null)

onMounted(()=>{
    const material = new PointsMaterial()

    for (let i = -5 ; i < 5; i++){
        for (let j = -5 ; j < 5; j++){
            const particle = new Sprite(material)
            particle.position.set(i*10,j*10,0)
            scene?.value.add(particle)
        }
    }

    renderer?.value.onBeforeRender(() => {

        }
    )
})
</script>

<style scoped>

</style>