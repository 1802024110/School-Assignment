<template>
  <div class="px-render" ref="container"></div>
</template>

<script setup>
import * as PIXI from 'pixijs'
import Dust from 'dust'
import {onMounted, ref} from "vue";

// 创建一个 PIXI.Application 实例
let app = new PIXI.Application({
  width: window.innerWidth,
  height: window.innerHeight,
});

// 获取模板中的容器元素
const container = ref(null);

// 在容器元素上挂载画布元素
onMounted(() => {
  container.value.appendChild(app.view);
});

// 创建一个 PIXI.loader 实例
let loader = new PIXI.Loader();

// 加载图片，并指定一个回调函数
loader.add("snowflake", require("@/assets/grain/snowflake.png")).load(setup);

// 定义回调函数
function setup() {
  // 创建一个平铺精灵作为背景
  let background = new PIXI.TilingSprite(
      // 获取加载好的纹理
      loader.resources["snowflake"].texture,
      // 设置宽度和高度
      app.stage.width,
      app.stage.height
  );
  // 添加到舞台上
  app.stage.addChild(background);
}
</script>

<style scoped>

</style>