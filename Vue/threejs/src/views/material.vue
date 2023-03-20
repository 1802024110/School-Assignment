<template>
  <canvas id="canvas"></canvas>
</template>

<script setup>
import * as THREE from 'three';
import GUI from 'lil-gui';
import {onMounted} from "vue";

onMounted(()=>{
  const canvas = document.getElementById('canvas')

  // 创建渲染器
  const renderer = new THREE.WebGLRenderer({
    antialias:true,
    canvas
  })

  // 创建相机
  // 获取画布宽度和高度
  const width = canvas.clientWidth;
  const height = canvas.clientHeight;
  // 根据画布宽高比计算相机参数
  const left = -width / 2;
  const right = width / 2;
  const top = height / 2;
  const bottom = -height / 2;
  // 调整near和far参数
  const near = 300;
  const far = -300;

  const camera = new THREE.OrthographicCamera(left, right, top, bottom, near, far);

  // 创建一个场景
  const scene = new THREE.Scene()


  // 渲染器渲染
  renderer.render(scene,camera)

  const color = 0xFFFFFF;
  const intensity = 1;
  // 创建一个灯光
  const light = new THREE.DirectionalLight(color, intensity);
  light.position.set(-1, 2, 4);
  scene.add(light);

  // 创建一个红色的光泽材质
  const material = new THREE.MeshPhongMaterial({color: 0x9652ec,shininess:40});
  const basicMaterial = new THREE.MeshBasicMaterial({color: 0x9652ec});
  const lambertMaterial = new THREE.MeshLambertMaterial({color:0x9652ec})
  const toonMaterial = new THREE.MeshToonMaterial({color:0x9652ec})
  const standardMaterial = new THREE.MeshStandardMaterial({color:0x9652ec,roughness:0.5,metalness:0.5})
  const physicalMaterial = new THREE.MeshPhysicalMaterial({color:0x9652ec,clearcoat:0.5})
  const depthMaterial = new THREE.MeshDepthMaterial({color:0x9652ec,clearcoat:0.5})
  const normalMaterial = new THREE.MeshNormalMaterial()
  const shaderMaterial = new THREE.ShaderMaterial()
  const cubes =[
    makeInstance(material,250),
    makeInstance(basicMaterial,190),
    makeInstance(lambertMaterial,120),
    makeInstance(toonMaterial,60),
    makeInstance(standardMaterial,0),
    makeInstance(physicalMaterial,-60),
    makeInstance(depthMaterial,-120),
    makeInstance(normalMaterial,-180),
    makeInstance(shaderMaterial,-240),
  ]

  function makeInstance(material,x) {
// 创建一个半径为1，水平分段数为32，垂直分段数为16的球体几何体
    const geometry = new THREE.SphereGeometry(30, 5, 5);

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

  // 将相机向后移动3个单位
  camera.position.z = 3;
// 将灯光向右移动2个单位
  light.position.x = 2;
  renderer.render(scene, camera);
})
</script>

<style scoped>

</style>