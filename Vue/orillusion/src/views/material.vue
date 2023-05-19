<template>
    <canvas ref="canvas"/>
</template>

<script setup>
import {
    AtmosphericComponent,
    BoxGeometry,
    Camera3D, Color,
    Engine3D,
    HoverCameraController,
    MeshRenderer,
    Object3D,
    Scene3D, UnLitMaterial, View3D
} from "@orillusion/core";
import {Stats} from "@orillusion/stats";
import dat from "dat.gui/src/dat/index.js";
import {onMounted, ref} from "vue";

async function run(canvas){
    await Engine3D.init({
        canvas: canvas
    });

    const scene = new Scene3D();
    scene.addComponent(Stats);

    // 添加天空组件
    scene.addComponent(AtmosphericComponent)

    // 添加相机
    const cameraObj = new Object3D();
    const camera = cameraObj.addComponent(Camera3D);
    // 视角、宽高比、近平面、远平面
    camera.perspective(60, window.innerWidth / window.innerHeight, 1, 5000);
    const controller = cameraObj.addComponent(HoverCameraController);
    controller.setCamera(20, -20, 25)

    scene.addChild(cameraObj);

    // 添加正方体
    const boxObj = new Object3D();
    const mr = boxObj.addComponent(MeshRenderer);
    mr.geometry = new BoxGeometry(5, 5, 5);

    // 添加贴图
    const material = new UnLitMaterial();
    material.baseMap = await Engine3D.res.loadTexture("src/assets/texture/wall.jpg");
    mr.material = material;
    scene.addChild(boxObj);

    // 添加GUI
    const gui = new dat.GUI();
    const materialInfo = {
        baseColor:'#fff',
    }

    gui.addColor(materialInfo, 'baseColor').onChange((val)=>{
        const color = new Color()
        color.setHex(val)
        material.baseColor = color
    })

    const view = new View3D();
    view.scene = scene;
    view.camera = camera;
    Engine3D.startRenderView(view);
}

const canvas = ref(null)
onMounted(()=>{
    run(canvas.value)
})
</script>

<style scoped>

</style>