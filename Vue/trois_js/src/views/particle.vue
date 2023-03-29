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
import {mergeBufferGeometries} from 'three/examples/jsm/utils/BufferGeometryUtils.js';
import {BufferGeometry, Mesh, Points, PointsMaterial} from "three";

const scene = ref(null)

function onLoad(object) {
  const bufferGeometries = [];
  object.scene.traverse((child) => {
    if (child instanceof Mesh) {
      // 将Mesh的Geometry 转换为BufferGeometry
      const bufferGeometry = new BufferGeometry().setFromPoints(child.geometry)
      bufferGeometries.push(bufferGeometry)
    }
  })
  // 合并所有 BufferGeometry
  const mergeBufferGeometry = mergeBufferGeometries(bufferGeometries)

  // 创建PointsMaterial 材质
  const pointsMaterial = new PointsMaterial({
    color: 0xffffff,
    size: 0.1,
  });

  // 使用合并后的 BufferGeometry 和 PointsMaterial 创建一个 Points 对象
  const particleSystem = new Points(mergeBufferGeometry, pointsMaterial);
  // object.scene = particleSystem
}

onMounted(() => {
})
</script>

<style scoped>

</style>