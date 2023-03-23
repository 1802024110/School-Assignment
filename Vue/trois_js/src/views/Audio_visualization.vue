<template>
  <button @click="play">开始</button>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :resize="true">
    <Camera ref="camera" :position="{z:650,y:200}"/>
    <Scene ref="scene" :background="0xffcc66">
      <PointLight :position="{x:0,y:300,z:40}" color="#ffffff"/>
      <PointLight :position="{x:0,y:0,z:800}" color="#ffffff"/>
      <PointLight :position="{x:0,y:0,z:-800}" color="#ffffff"/>
      <Group ref="cubes"  :position="{x:-(10+10.2*CUBE_NUM )}">
        <Box v-for="i in CUBE_NUM" :key="i" :position="{x:(10+10)*i}" :scale="{x: 10, y: 1, z: 10}">
          <PhongMaterial color="#9acd32"/>
        </Box>
      </Group>
    </Scene>
  </Renderer>
</template>

<script setup>
import {onMounted, ref} from "vue";

const STEP = 20
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
      source.buffer = decodedData;
      // 创建立体声平衡节点
      const panner = audioCtx.createStereoPanner();
      // 连接音频源到平衡节点
      source.connect(panner);
      // 连接平衡节点到分析器
      panner.connect(analyser);
      // 连接分析器到目的地
      analyser.connect(audioCtx.destination);
    })
  })
}

onMounted(() => {
  renderer.value.onBeforeRender(() => {
    const frequencyData = new Uint8Array(analyser.frequencyBinCount);
    analyser.getByteFrequencyData(frequencyData);

// 计算每个分组的平均频谱数据
    const averageFrequencyData = [];
    for (let i = 0; i < frequencyData.length; i += STEP) {
      // 获取左右声道的音频数据
      const leftData = new Uint8Array(analyser.frequencyBinCount / 2);
      const rightData = new Uint8Array(analyser.frequencyBinCount / 2);
      analyser.getByteFrequencyData(leftData);
      analyser.getByteFrequencyData(rightData);
      // 将左右声道的音频数据进行加权平均
      for (let i = 0; i < leftData.length; i++) {
        averageFrequencyData[i] = (leftData[i] + rightData[i]) / 2;
      }
    }
    // 设置立方体的 scaleY
    for (let i = 0; i < cubes.value.group.children.length; i++) {
      cubes.value.group.children[i].scale.y = Math.floor(averageFrequencyData[i] * 0.4)
    }
  });
})

let count = 1

function play(){
  if (audioCtx.state != 'running') {
    getData().then(() => {
      source.start(0)
    })
  }
}
</script>

<style scoped>

</style>