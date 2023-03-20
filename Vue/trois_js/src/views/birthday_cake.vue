<template>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :resize="true">
    <Camera :position="{z:10}"/>
    <Scene :background="0xffcc66" ref="scene">
      <AmbientLight color="#cccccc" :position="{y:50,z:50}"/>
      <Cylinder :radialSegments="100" :radiusTop="4" :radiusBottom="4" :height="0.3">
        <BasicMaterial>
          <Texture src="src/assets/images/birthday/cake4.png" name="map"/>
        </BasicMaterial>
      </Cylinder>
      <Cylinder :radialSegments="100" :radiusTop="3.7" :radiusBottom="3.7" :position="{ y: 0.7}">
        <BasicMaterial>
          <Texture src="src/assets/images/birthday/cake2.png" name="map"/>
        </BasicMaterial>
      </Cylinder>
      <Cylinder :radialSegments="100" :radiusTop="2.7" :radiusBottom="2.7" :position="{ y: 1.7}">
        <BasicMaterial>
          <Texture src="src/assets/images/birthday/cake3.png" name="map"/>
        </BasicMaterial>
      </Cylinder>
      <Cylinder :radialSegments="100" :radiusTop="1.7" :radiusBottom="1.7" :position="{ y: 2.7}">
        <BasicMaterial>
          <Texture src="src/assets/images/birthday/cake1.png" name="map"/>
        </BasicMaterial>
      </Cylinder>
      <Group ref="cake">

      </Group>
    </Scene>
  </Renderer>
</template>

<script setup>
import {onMounted, ref} from "vue";
import {AxesHelper,MeshBasicMaterial,Mesh,MeshPhongMaterial} from "three";
import { FontLoader } from 'three/examples/jsm/loaders/FontLoader.js';
import { TextGeometry } from 'three//examples/jsm/geometries/TextGeometry.js';
const renderer = ref(null)
const scene = ref(null)
const cake = ref(null)
onMounted(() => {

  // 渲染器旋转
  renderer.value?.onBeforeRender(() => {
    scene.value.scene.rotation.y += .01
  });

  // 辅助线
  const axisHelper = new AxesHelper(5)
  // scene?.value.add(axisHelper)

  // 字体
  const fontLoader = new FontLoader();

  fontLoader.load('src/assets/font/MaokenZhuyuanTi_Regular.json',  (font) =>{
    const textGeo = new TextGeometry( "Happy", {
      font: font,
      size: .5,
      height: .1,
    } );

    const textMaterial = ['white', 'red'].map(color => new MeshBasicMaterial({color}));
    const mesh = new Mesh( textGeo, textMaterial );
    mesh.translateY(3.3)
    mesh.translateX(-1)
    cake.value.add( mesh );
  });

})
</script>

<style scoped>

</style>