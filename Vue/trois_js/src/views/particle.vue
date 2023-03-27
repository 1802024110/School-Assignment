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
import { Points, PointsMaterial, RawShaderMaterial, SphereGeometry} from "three";
import Stats from "three/examples/jsm/libs/stats.module";
import {FBXLoader} from "three/examples/jsm/loaders/FBXLoader";
import {OBJLoader} from "three/examples/jsm/loaders/OBJLoader";
import {MTLLoader} from "three/examples/jsm/loaders/MTLLoader";

const scene = ref(null)

function createShaderMaterial() {
  const vertexShader = `
      void main() {
        gl_PointSize = 4.;
        gl_Position = projectionMatrix * modelViewMatrix * vec4(position, 1.0);
      }
    `;
  const fragmentShader = `
      uniform vec3 color;
      void main() {
        gl_FragColor = vec4(color, 1.0);
      }
    `;
  return new RawShaderMaterial({
    vertexShader,
    fragmentShader,
    uniforms: {
      color: { value: new Color(0xffffff) },
    },
    transparent: true,
  });
}

function init(){
  const stats = new Stats()
  stats.domElement.style.position = 'absolute'
  stats.domElement.style.bottom = '0px'
  stats.domElement.style.zIndex = 100
  document.getElementsByTagName('canvas')[0].appendChild(stats.domElement)
}

onMounted(()=>{
})
</script>

<style scoped>

</style>