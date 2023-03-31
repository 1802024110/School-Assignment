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
import {
    BufferGeometry, CircleBufferGeometry,
    Color, Float32BufferAttribute,
    Particle,
    ParticleBasicMaterial, ParticleSystem,
    Points,
    PointsMaterial,
    RawShaderMaterial, SphereBufferGeometry,
    SphereGeometry,
    Sprite, Vector3
} from "three";
import {Geometry} from "three/examples/jsm/deprecated/Geometry";

const scene = ref(null)
const renderer = ref(null)

onMounted(()=>{
    const geo = new SphereGeometry(40, 30, 30);
    const material = new PointsMaterial({
        size: 4,
        vertexColors: true,
        color: 0xffffff
    });

    const positions = [];
    const colors = [];

    for (let i = -5; i < 5; i++) {
        for (let j = -5; j < 5; j++) {
            const x = 10 * i;
            const y = 10 * j;
            const z = 0;
            positions.push(x, y, z);
            colors.push(Math.random(), Math.random(), Math.random());
        }
    }

    geo.setAttribute('position', new Float32BufferAttribute(positions, 3));
    geo.setAttribute('color', new Float32BufferAttribute(colors, 3));

    const system = new Points(geo, material);
    scene?.value.add(system);

    renderer?.value.onBeforeRender(() => {
        const time = performance.now() * 0.001;
        const positions = geo.attributes.position.array;

        for (let i = 0; i < positions.length; i += 3) {
            const x = positions[i];
            const y = positions[i + 1];
            const z = positions[i + 2];
            positions[i + 2] = z + Math.sin(x * 0.5 + time) * 2 + Math.sin(y * 0.5 + time) * 2;
        }

        geo.attributes.position.needsUpdate = true;
    });
})
</script>

<style scoped>

</style>