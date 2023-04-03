<template>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :pointer="{ intersectRecursive: true }" :resize="true">
    <Camera :position="{z:800}" :far="20000"/>
    <Scene :background="0x000000">
      <HemisphereLight color="#B1E1FF" :intensity="0.6"/>
      <DirectionalLight  color="#FFFFFF" :intensity="0.8" :position="{x:5,y:10,z:2}"/>
      <GltfModel
          ref="model"
          src="src/assets/model/cartoon_lowpoly_small_city_free_pack/scene.gltf"
      @load="onLoad">
      </GltfModel>
    </Scene>
  </Renderer>
</template>

<script setup>
import {onMounted, ref} from "vue";
import {DoubleSide, Float32BufferAttribute, MeshBasicMaterial, TextureLoader} from "three";

function dumpObject(obj, lines = [], isLast = true, prefix = '') {
  const localPrefix = isLast ? '└─' : '├─';
  lines.push(`${prefix}${prefix ? localPrefix : ''}${obj.name || '*no-name*'} [${obj.type}]`);
  const newPrefix = prefix + (isLast ? '  ' : '│ ');
  const lastNdx = obj.children.length - 1;
  obj.children.forEach((child, ndx) => {
    const isLast = ndx === lastNdx;
    dumpObject(child, lines, isLast, newPrefix);
  });
  return lines;
}

function onLoad(object){
  const cars = object.scene.getObjectByName('Cars')
  // console.log(cars)
}

const model = ref(null)
const renderer = ref(null)
onMounted(() => {
  renderer?.value.onBeforeRender(()=>{
    const cars = model.value.scene.getObjectByName('Cars')
    if (cars){
      cars.children.forEach((car)=>{
        car.rotation.y += 0.01
      })
    }
  })
})
</script>

<style scoped>

</style>