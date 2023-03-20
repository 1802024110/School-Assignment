<template>
  <div id="playground"></div>
</template>

<script setup>
import * as PIXI from 'pixijs'
import {onMounted} from "vue";

const app = new PIXI.Application()
const renderer = app.renderer

onMounted(()=>{
  const playground = document.getElementById('playground')

  playground.appendChild(renderer.view)

// 设置别名
  const TextureCache = PIXI.utils.TextureCache;
  const Texture = PIXI.Texture;
  const Rectangle = PIXI.Rectangle;

//需要加载的雪碧图的地址（该图片服务器端已做跨域处理）
  const imgURL = "https://www.kkkk1000.com/images/learnPixiJS-AnimatedSprite/dnf.png";

// 加载图像，完成后执行setup函数
  PIXI.Loader.shared.add(imgURL).load(setup);

// 加载完成后处理雪碧图的方法
  function setup(){
    const base = TextureCache[imgURL];

    //第一个纹理
    const texture0 = new Texture(base);
    texture0.frame = new Rectangle(0, 0, 80, 143);
    //第二个纹理
    const texture1 = new Texture(base);
    texture1.frame = new Rectangle(80, 0, 80, 143);
    //第三个纹理
    const texture2 = new Texture(base);
    texture2.frame = new Rectangle(160, 0, 80, 143);
    //第四个纹理
    const texture3 = new Texture(base);
    texture3.frame = new Rectangle(240, 0, 80, 143);

    //创建纹理数组
    let textures = [texture0, texture1, texture2,texture3];
    //创建动画精灵
    const pixie = new PIXI.AnimatedSprite(textures);
    //设置动画精灵的速度
    pixie.animationSpeed=0.1;

    //把动画精灵添加到舞台
    app.stage.addChild(pixie);
    //播放动画精灵
    pixie.play();
  }
})
</script>

<style scoped>

</style>