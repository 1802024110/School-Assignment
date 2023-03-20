<template>
  <button id="start-btn">开始</button>
  <button id="stop-btn">结束</button>
  <div id="px-render"></div>
</template>

<script setup>
import * as PIXI from 'pixijs'
import {onMounted} from "vue";

onMounted(()=>{
  // 创建应用
  const app = new PIXI.Application({
    width: 400,
    height: 300,
    transparent: true,
  })

// 创建一个渲染器
  const renderer = app.renderer

// 置换图精灵
  let displacementSprite

// 滤镜
  let displacementFilter

// 舞台(容器)，包含图片精灵和置换图精灵
  let stage

// 展示元素
  const playground = document.getElementById('px-render')

  function setScene(url){
    // 添加pixi视图到页面
    playground.appendChild(renderer.view)

    // 重新构建容器
    stage = new PIXI.Container()

    // 构建图片精灵
    const preview = PIXI.Sprite.from(url)

    // 构建置换图精灵，在置换滤镜时使用
    displacementSprite = PIXI.Sprite.from('https://www.kkkk1000.com/images/learnPixiJS/sprite.png')

    // 构建置换滤镜
    displacementFilter = new PIXI.filters.DisplacementFilter(displacementSprite)

    // 添加 图片精灵 到舞台
    stage.addChild(preview)

    // 添加 置换精灵 到舞台
    stage.addChild(displacementSprite)

    // 把 stage 添加到根容器
    app.stage.addChild(stage)
  }

// 置换精灵的移动速度
  const velocity = 1

// raf 是调用 requestAnimationFrame方法的返回值，停止动画效果时需要用到
  let raf

  function animate(){
    raf = requestAnimationFrame(animate)

    // 改变置换图精灵的位置
    displacementSprite.x += velocity
    displacementSprite.y += velocity
  }

// 设置屏幕背景
  setScene('https://www.kkkk1000.com/images/learnPixiJS/view.jpg');

  const start = document.querySelector('#start-btn');
  const stop = document.querySelector('#stop-btn');

  start.onclick = function () {
    // 设置舞台的滤镜
    stage.filters = [displacementFilter];
    // 开始动画
    animate();
  }

  stop.onclick = function () {
    // 取消滤镜
    stage.filters = [];
    // 停止动画
    cancelAnimationFrame(raf);
  }
})
</script>

<style scoped>
</style>