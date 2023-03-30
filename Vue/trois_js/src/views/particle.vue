<!--https://juejin.cn/post/6844903615438553096-->
<!--https://github.com/youngdro/3DPoints-->
<template>
    <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :resize="true">
        <Camera :position="{z:1,y:1}"/>
        <Scene ref="scene" :background="0x000000">
            <PointLight :position="{y:50,z:50}"/>
        </Scene>
    </Renderer>
</template>

<script setup>
import {onMounted, ref} from "vue";
import {GLTFLoader} from "three/examples/jsm/loaders/GLTFLoader";
import {PointsMaterial, BufferGeometry, Color, Points, ShaderMaterial, AdditiveBlending, Matrix4} from "three";
import {mergeBufferGeometries} from "three/examples/jsm/utils/BufferGeometryUtils";
import vertexShader from './shaders/vertex.glsl'
import fragmentShader from './shaders/fragment.glsl'
import {FBXLoader} from "three/examples/jsm/loaders/FBXLoader";


const scene = ref(null)

onMounted(() => {
    const loader = new FBXLoader()
    loader.load('src/assets/model/particle/robot.FBX', (gltf) => {
        const bufferGeometries = [];
        gltf.scene.traverse((node) => {
            if (node.isMesh) {
                const naxida = node.geometry;
                naxida.scale(0.08, 0.08, 0.08)
                naxida.rotateX(-Math.PI / 2);
                naxida.applyMatrix4(new Matrix4().makeTranslation(0, 10, 0));

                // 将Mesh的Geometry 转换为BufferGeometry
                const bufferGeometry = new BufferGeometry().setFromPoints(naxida)
                bufferGeometries.push(bufferGeometry)
            }
        })
        const mergeBufferGeometry = mergeBufferGeometries(bufferGeometries)

        const uniforms = {
            // 传递的颜色属性
            color: {
                type: 'v3', // 指定变量类型为三维向量
                value: new Color(0xffffff)
            }
        };

        // 创建着色器材料
        let shaderMaterial = new ShaderMaterial({
            // 传递给shader的属性
            uniforms: uniforms,
            // 获取顶点着色器代码
            vertexShader: vertexShader,
            // 获取片元着色器代码
            fragmentShader: fragmentShader,
            // 渲染粒子时的融合模式
            blending: AdditiveBlending,
            // 关闭深度测试
            depthTest: false,
            // 开启透明度
            transparent: true
        });

        const particleSystem = new Points(mergeBufferGeometry, shaderMaterial)
        // scene?.value.add(gltf.scene)
        console.log(particleSystem)
        scene?.value.add(particleSystem)
    })
})
</script>

<style scoped>

</style>