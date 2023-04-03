<template>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :pointer="{ intersectRecursive: true }" :resize="true">
    <Camera :position="{z:800}" :far="20000"/>
    <Scene ref="scene" :background="0x000000">
      <HemisphereLight color="#B1E1FF" :intensity="0.7"/>
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
import * as THREE from "three";


const model = ref(null)
const scene = ref(null)
const renderer = ref(null)

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
const cars = []

function onLoad(object){
  const loadedCars  = object.scene.getObjectByName('Cars')
  const fixes = [
    { prefix: 'Car_08', rot: [Math.PI * .5, 0, Math.PI * .5], },
    { prefix: 'CAR_03', rot: [0, Math.PI, 0], },
    { prefix: 'Car_04', rot: [0, Math.PI, 0], },
  ]
  object.scene.updateMatrixWorld()


  loadedCars.children.slice().forEach((car)=>{
    console.log(car.name)
    const fix = fixes.find(fix => car.name.startsWith(fix.prefix))
    const obj = new THREE.Object3D()
    car.getWorldPosition(obj.position)
    car.position.set(0,0,0)
    car.rotation.set(...fix.rot)
    obj.add(car)
    scene?.value.add(obj)
    cars.push(obj)
  })
}

onMounted(() => {
  renderer?.value.onBeforeRender(()=>{
    if (cars.length!=0){
      cars.forEach((car)=>{
        car.rotation.y += 0.01
      })
    }
  })
})
</script>

<style scoped>

</style>