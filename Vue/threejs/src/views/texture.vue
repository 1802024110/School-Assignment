<template>
  <canvas id="canvas"/>
</template>

<script setup>
import * as THREE from 'three'
import imgUrl from "@/assets/img/texture/wall.jpg";
import {onMounted} from "vue";
onMounted(()=>{
  const canvas = document.getElementById('canvas')

  // 创建渲染器
  const renderer = new THREE.WebGLRenderer({
    antialias:true,
    canvas
  })

  // 创建相机
  // 视野范围
  const fov = 75
  // 画布的宽高比
  const aspect = canvas.clientWidth / canvas.clientHeight
  // 近平面
  const near = 0.1
  // 远平面
  const far = 5
  const camera = new THREE.PerspectiveCamera(fov,aspect,near,far)
  camera.updateProjectionMatrix()
  // 将摄像机在z轴方向向后移动2
  camera.position.z = 2.3

  // 创建一个场景
  const scene = new THREE.Scene()

  // 创建一个立体几何体
  const geometry = new THREE.BoxGeometry(1,1,1)

  // 渲染器渲染
  renderer.render(scene,camera)

  const color = 0xFFFFFF;
  const intensity = 1;
  // 创建一个灯光
  const light = new THREE.DirectionalLight(color, intensity);
  light.position.set(-1, 2, 4);
  scene.add(light);

  const cubes = [
    makeInstance(geometry, 0x44aa88,  0),
  ];

  function makeInstance(geometry, color, x) {
    const loader = new THREE.TextureLoader()
    const material = new THREE.MeshPhongMaterial({
      map: loader.load(imgUrl)
    });

    const cube = new THREE.Mesh(geometry, material);
    scene.add(cube);

    cube.position.x = x;

    return cube;
  }

  function resizeRendererToDisplaySize(renderer) {
    const canvas = renderer.domElement;
    const width = canvas.clientWidth;
    const height = canvas.clientHeight;
    const needResize = canvas.width !== width || canvas.height !== height;
    if (needResize) {
      renderer.setSize(width, height, false);
    }
    return needResize;
  }

  function render(time){
    time *= 0.001

    if (resizeRendererToDisplaySize(renderer)) {
      const canvas = renderer.domElement;
      camera.aspect = canvas.clientWidth / canvas.clientHeight;
      camera.updateProjectionMatrix();
    }

    cubes.forEach((cube, ndx) => {
      const speed = 1 + ndx * .1;
      const rot = time * speed;
      cube.rotation.x = rot;
      cube.rotation.y = rot;
    });

    renderer.render(scene, camera);

    requestAnimationFrame(render);
  }
  requestAnimationFrame(render);
})
</script>

<style scoped>
html, body {
  margin: 0;
  height: 100%;
}
</style>