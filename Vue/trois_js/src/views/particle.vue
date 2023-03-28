<!--https://juejin.cn/post/6844903615438553096-->
<!--https://github.com/youngdro/3DPoints-->
<template>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :resize="true">
    <Camera :position="{z:1}"/>
    <Scene ref="scene" :background="0xffcc66">
      <PointLight :position="{y:50,z:50}"/>
      <GltfModel
          ref="model"
          :position="{y:-1}"
          src="src/assets/model/naxida_bailu/1.glb"
          @load="onLoad">
      </GltfModel>
    </Scene>
  </Renderer>
</template>

<script setup>
import {onMounted, ref} from "vue";
import {BufferGeometryUtils} from 'three/examples/jsm/utils/BufferGeometryUtils.js';

const scene = ref(null)

function onLoad(object) {
  const geometry = object.scene.children
  const bufferGeometry = BufferGeometryUtils.fromGeometry(geometry)
  console.log(geometry)
}

onMounted(() => {
})
</script>

<style scoped>

</style>