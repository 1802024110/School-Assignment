<template>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :pointer="{ intersectRecursive: true }" :resize="true">
    <Camera :position="{z:-1,x:0,y:0}"/>
    <Scene :background="0xffcc66">
      <PointLight :position="{y:50,z:50,x:0}"/>
      <PointLight :position="{y:50,z:50,x:20}"/>
      <GltfModel
          ref="model"
          :position="{y:-1}"
          src="src/assets/model/naxida_bailu/1.glb"
          @click="onPointerEvent" @load="onLoad">
      </GltfModel>
    </Scene>
  </Renderer>
</template>

<script setup>
import {onMounted, ref} from "vue";
import {DoubleSide, MeshBasicMaterial, TextureLoader} from "three";

function onPointerEvent(event) {
  // console.log(event);
}

function onLoad(object) {
  // const textureLoader = new TextureLoader()
  object.scene.traverse(function (child) {
    switch (child.name) {
      case "白露1010":
        // 外套
        const texture0 = new TextureLoader().load("src/assets/model/naxida_bailu/外套n glow.png")
        child.material = new MeshBasicMaterial({map: texture0});
        break
      case "白露1010_1":
        // 脸
        const texture1 = new TextureLoader().load("src/assets/model/naxida_bailu/颜.png")
        child.material = new MeshBasicMaterial({map: texture1});
        break
      case "白露1010_2":
        // 头发
        const texture2 = new TextureLoader().load("src/assets/model/naxida_bailu/髮2.png")
        child.material = new MeshBasicMaterial({map: texture2, side: DoubleSide});
        break
      case "白露1010_3":
        // 衣服
        const texture3 = new TextureLoader().load("src/assets/model/naxida_bailu/衣服n.png")
        child.material = new MeshBasicMaterial({map: texture3});
        break
    }
  });
}

const model = ref(null)
const renderer = ref(null)
onMounted(() => {
})
</script>

<style scoped>

</style>