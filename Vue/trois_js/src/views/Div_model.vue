<template>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :resize="true" :pointer="{ intersectRecursive: true }" >
    <Camera :position="{z:3,x:0,y:0}"/>
    <Scene :background="0xffcc66">
      <PointLight :position="{y:50,z:50}"/>
      <GltfModel
          @click="onPointerEvent"
          ref="model"
          src="src/assets/model/naxida_bailu/1.glb" @load="onLoad">
      </GltfModel>
    </Scene>
  </Renderer>
</template>

<script setup>
import { ref} from "vue";

function onPointerEvent(event) {
  // console.log(event);
}

function onLoad(object){
  object.scene.traverse(function (child) {
    console.log(child.name);
    /*if (child.isMesh){
      console.log(child.name)
    }*/
  });
}

const model = ref(null)
</script>

<style scoped>

</style>