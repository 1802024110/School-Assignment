<template>
    <canvas ref="canvas"/>
</template>

<script setup>
import {
    AtmosphericComponent, BoxGeometry,
    Camera3D,
    DirectLight,
    Engine3D,
    HoverCameraController, LitMaterial, MeshRenderer,
    Object3D,
    Scene3D, View3D
} from "@orillusion/core";
import { onMounted, ref } from 'vue'
import dat from "dat.gui/src/dat/index.js";
const canvas = ref(null)

async function drawSquare(canvas){
    await Engine3D.init({
        canvasConfig: {
            canvas: canvas
        },
        beforeRender:()=>{
            // 每一帧渲染前执行
        },
        renderLoop:()=>{
            // 每一帧渲染中执行
        },
        lateRender:()=>{
            // 每一帧渲染后执行
        }
    });

    // 创建场景
    const scene3D = new Scene3D();

    // 添加天空组件
    scene3D.addComponent(AtmosphericComponent)

    // 添加摄像机
    const cameraObj = new Object3D();
    const camera = cameraObj.addComponent(Camera3D);
    camera.perspective(60, window.innerWidth / window.innerHeight, 1, 5000);
    const controller = camera.object3D.addComponent(HoverCameraController);
    controller.setCamera(0, 0, 15)
    scene3D.addChild(cameraObj);

    // 添加光照
    const light = new Object3D();
    const component = light.addComponent(DirectLight);
    light.rotationX = 45;
    light.rotationY = 30;
    component.intensity = 2;
    scene3D.addChild(light);

    // 创建集合物体，且添加材质渲染
    const obj = new Object3D();
    const mesh = obj.addComponent(MeshRenderer);
    mesh.geometry = new BoxGeometry(5, 5, 5);
    mesh.material = new LitMaterial();
    scene3D.addChild(obj);

    // 添加性能监控
    // scene3D.addComponent(Stats)

    // 添加dat.gui
    const gui = new dat.GUI();
    const geometryInfo = {
        x: 0,
        y: 0,
        z: 0,
    }
    gui.add(geometryInfo,"x",-100,100).step(0.1).onChange((value)=>{
        obj.x = value
    })
    gui.add(geometryInfo,"y",-100,100).step(0.1).onChange((value)=>{
        obj.y = value
    })
    gui.add(geometryInfo,"z",-100,100).step(0.1).onChange((value)=>{
        obj.z = value
    })

    // 渲染场景
    const view = new View3D();
    view.scene = scene3D;
    view.camera = camera;
    Engine3D.startRenderView(view);
}

onMounted(()=>{
    drawSquare(canvas.value)
})

</script>

<style>
</style>