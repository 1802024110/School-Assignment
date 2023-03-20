<template>
  <canvas id="canvas"/>
</template>

<script setup>
import * as THREE from 'three'
import {onMounted} from "vue";
import {OrbitControls} from "three/addons/controls/OrbitControls";
import imgUrl from "@/assets/img/illumination/checker.png";
import GUI from "lil-gui";

// 在组件挂载后执行的函数
onMounted(()=>{
  // 获取画布元素
  const canvas = document.getElementById('canvas')

  // 创建渲染器
  const renderer = new THREE.WebGLRenderer({antialias: true, canvas});

  // 创建相机
  const fov = 45;  // 视角
  const aspect = 2;  // 画布比例
  const near = 0.1;  // 近截面
  const far = 100;  // 远截面
  const camera = new THREE.PerspectiveCamera(fov, aspect, near, far);  // 使用透视相机
  camera.position.set(0, 10, 30);  // 设置相机位置

  // 创建控制器
  const controls = new OrbitControls(camera, canvas);
  controls.target.set(0, 5, 0);  // 设置控制点
  controls.update();  // 更新控制器状态

  // 创建场景
  const scene = new THREE.Scene();
  scene.background = new THREE.Color('black');  // 设置场景背景颜色

  // 创建平面
  {
    const planeSize = 40;  // 平面尺寸

    // 创建纹理
    const loader = new THREE.TextureLoader();
    const texture = loader.load(imgUrl);  // 加载纹理
    texture.wrapS = THREE.RepeatWrapping;  // 水平重复
    texture.wrapT = THREE.RepeatWrapping;  // 垂直重复
    texture.magFilter = THREE.NearestFilter;  // 纹理放大方式
    const repeats = planeSize / 2;  // 重复次数
    texture.repeat.set(repeats, repeats);  // 设置重复次数

    // 创建平面网格
    const planeGeo = new THREE.PlaneGeometry(planeSize, planeSize);
    const planeMat = new THREE.MeshPhongMaterial({
      map: texture,  // 使用纹理
      side: THREE.DoubleSide,  // 双面材质
    });
    const mesh = new THREE.Mesh(planeGeo, planeMat);
    mesh.rotation.x = Math.PI * -.5;  // 旋转平面
    scene.add(mesh);  // 将平面添加到场景中
  }

  // 创建立方体
  {
    const cubeSize = 4;  // 立方体尺寸
    const cubeGeo = new THREE.BoxGeometry(cubeSize, cubeSize, cubeSize);
    const cubeMat = new THREE.MeshPhongMaterial({color: '#8AC'});  // 设置材质颜色
    const mesh = new THREE.Mesh(cubeGeo, cubeMat);
    mesh.position.set(cubeSize + 1, cubeSize , 0);  // 设置立方体位置
    scene.add(mesh);  // 将立方体添加到场景中
  }

  // 创建球体
  {
    const sphereRadius = 3; // 球体半径
    const sphereWidthDivisions = 32; // 球体宽度分段数
    const sphereHeightDivisions = 16; // 球体高度分段数
    const sphereGeo = new THREE.SphereGeometry(sphereRadius, sphereWidthDivisions, sphereHeightDivisions); // 创建球体几何体
    const sphereMat = new THREE.MeshPhongMaterial({color: '#CA8'}); // 创建球体材质
    const mesh = new THREE.Mesh(sphereGeo, sphereMat); // 创建球体网格
    mesh.position.set(-sphereRadius - 1, sphereRadius + 2, 0); // 设置球体位置
    scene.add(mesh); // 将球体添加到场景中
  }

  class ColorGUIHelper {
    constructor(object, prop) {
      this.object = object;
      this.prop = prop;
    }
    get value() {
      return `#${this.object[this.prop].getHexString()}`;
    }
    set value(hexString) {
      this.object[this.prop].set(hexString);
    }
  }

  const gui = new GUI(); // 创建GUI界面

  {
    const skyColor = 0xB1E1FF;  // 浅蓝色
    const groundColor = 0xB97A20;  // 棕橙色
    const intensity = 1;
    const light = new THREE.HemisphereLight(skyColor, groundColor, intensity)
    scene.add(light);

    gui.addColor(new ColorGUIHelper(light, 'color'), 'value').name('skyColor');
    gui.addColor(new ColorGUIHelper(light, 'groundColor'), 'value').name('groundColor')
    gui.add(light, 'intensity', 0, 2, 0.01); // 添加光强度滑动条
  }

  {
    const color = 0xFFFFFF;
    const intensity = 1;
    const light = new THREE.DirectionalLight(color, intensity);
    light.position.set(0, 10, 0);
    light.target.position.set(-5, 0, 0);
    scene.add(light);
    scene.add(light.target);

    gui.addColor(new ColorGUIHelper(light, 'color'), 'value').name('color');
    gui.add(light, 'intensity', 0, 2, 0.01);
    gui.add(light.target.position, 'x', -10, 10);
    gui.add(light.target.position, 'z', -10, 10);
    gui.add(light.target.position, 'y', 0, 10);

    const helper = new THREE.DirectionalLightHelper(light);
    scene.add(helper);

    {
      function makeXYZGUI(gui, vector3, name, onChangeFn) {
        const folder = gui.addFolder(name);
        folder.add(vector3, 'x', -10, 10).onChange(onChangeFn);
        folder.add(vector3, 'y', 0, 10).onChange(onChangeFn);
        folder.add(vector3, 'z', -10, 10).onChange(onChangeFn);
        folder.open();
      }

      function updateLight() {
        light.target.updateMatrixWorld();
        helper.update();
      }
      updateLight();

      const gui = new GUI();
      gui.addColor(new ColorGUIHelper(light, 'color'), 'value').name('color');
      gui.add(light, 'intensity', 0, 2, 0.01);

      makeXYZGUI(gui, light.position, 'position', updateLight);
      makeXYZGUI(gui, light.target.position, 'target', updateLight);
    }
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

  function render() {

    if (resizeRendererToDisplaySize(renderer)) {
      const canvas = renderer.domElement;
      camera.aspect = canvas.clientWidth / canvas.clientHeight;
      camera.updateProjectionMatrix();
    }

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