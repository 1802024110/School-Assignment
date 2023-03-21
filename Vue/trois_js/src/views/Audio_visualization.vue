<template>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :resize="true">
    <Camera ref="camera" :position="{z:300}"/>
    <Scene ref="scene" :background="0xffcc66">
      <PointLight :position="{x:0,y:300,z:40}" color="#ffffff"/>
      <Group :position="{x:-(10+10*CUBE_NUM )}">
        <Box v-for="i in CUBE_NUM" :key="i" ref="cubes" :position="{x:(10+10)*i}" :scale="{x: 10, y: 1, z: 10}">
          <PhongMaterial color="#9acd32"/>
        </Box>
      </Group>
    </Scene>
  </Renderer>
</template>

<script setup>
import {onMounted, ref} from "vue";

const STEP = 50
const CUBE_NUM = Math.ceil(1024 / STEP)

const renderer = ref(null)

let audioCtx = new AudioContext();
let source;
const analyser = audioCtx.createAnalyser()

const cubes = ref(null)
const camera = ref(null)
const scene = ref(null)

function getData() {
  source = audioCtx.createBufferSource()

  return fetch('src/assets/music/一路生花.mp3').then((res) => {
    if (!res.ok) {
      throw new Error("解析音乐错误，错误代码：" + res.status)
    }
    return res.arrayBuffer()
  }).then((arrayBuffer) => {
    audioCtx.decodeAudioData(arrayBuffer, (decodedData) => {
      source.buffer = decodedData
      source.connect(analyser)
      analyser.connect(audioCtx.destination)
    })
  })
}

onMounted(() => {


  renderer.value?.onBeforeRender(() => {
    const frequencyData = new Uint8Array(analyser.frequencyBinCount);
    analyser.getByteFrequencyData(frequencyData);

// 计算每个分组的平均频谱数据
    const averageFrequencyData = [];
    for (let i = 0; i < frequencyData.length; i += STEP) {
      let sum = 0;
      for (let j = i; j < i + STEP; j++) {
        sum += frequencyData[j];
      }
      averageFrequencyData.push(sum / STEP);
    }
    // 设置立方体的 scaleY
    for (let i = 0; i < cubes?.value.length; i++) {
      cubes.value[i].scale.y = Math.floor(averageFrequencyData[i] * 0.4)
    }
  });
})

let count = 1
document.addEventListener("mousedown", () => {
  if (count == 1) {
    getData().then(() => {
      source.start(0)
    })
    count += 1
  }
})
</script>

<style scoped>

</style>