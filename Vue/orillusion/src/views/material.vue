<template>
    <canvas ref="canvas"/>
</template>

<script setup>
import {
    BoxGeometry,
    Camera3D, Color,
    Engine3D,
    HoverCameraController,
    MeshRenderer,
    Object3D,
    Vector3,
    LitMaterial,
    Texture,
    Scene3D, UnLitMaterial, View3D
} from "@orillusion/core";
import {Stats} from "@orillusion/stats";
import dat from "dat.gui/src/dat/index.js";
import {onMounted, ref} from "vue";

async function run(canvas){
    // 开启阴影
    Engine3D.setting.shadow.enable = true;
    // 开启阴影调试
    Engine3D.setting.shadow.debug = true;
    // 阴影边界
    Engine3D.setting.shadow.shadowBound = 10;
    // 阴影偏移
    Engine3D.setting.shadow.shadowBias = -0.00016;
    // 自动更新整形
    Engine3D.setting.shadow.autoUpdate = true;
    // 阴影更新的频率
    Engine3D.setting.shadow.updateFrameRate = 1;
    // 点光源阴影偏移
    Engine3D.setting.shadow.pointShadowBias = 3;

    await Engine3D.init({
        canvasConfig: {
            canvas: canvas
        },
    });

    const scene = new Scene3D();
    scene.addComponent(Stats);

    // 添加相机
    const cameraObj = new Object3D();
    const camera = cameraObj.addComponent(Camera3D);
    // 视角、宽高比、近平面、远平面
    camera.perspective(60, window.innerWidth / window.innerHeight, 1, 5000);
    const controller = cameraObj.addComponent(HoverCameraController);
    controller.setCamera(20, -20, 25)

    scene.addChild(cameraObj);

    // 添加正方体1
    const boxObj1 = new Object3D();
    boxObj1.localPosition = new Vector3(-10, 0, 0);
    const mr = boxObj1.addComponent(MeshRenderer);
    mr.geometry = new BoxGeometry(5, 5, 5);

    // 添加贴图
    mr.material = new LitMaterial();
    scene.addChild(boxObj1);

    // 添加正方体2
    const boxObj2 = new Object3D();
    boxObj2.localPosition = new Vector3(10, 0, 0);
    const mr2 = boxObj2.addComponent(MeshRenderer);
    mr2.geometry = new BoxGeometry(5, 5, 5);

    // 添加贴图
    mr2.material = new UnLitMaterial();
    scene.addChild(boxObj2);

    // 创建地板
    const floor = new Object3D();
    floor.y = -2.5;
    const material = new LitMaterial();
    const meshRenderer = floor.addComponent(MeshRenderer);
    meshRenderer.geometry = new BoxGeometry(40, 1, 30);
    meshRenderer.receiveShadow = true;
    meshRenderer.material = material;
    scene.addChild(floor);

    // 添加GUI
    const gui = new dat.GUI();

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