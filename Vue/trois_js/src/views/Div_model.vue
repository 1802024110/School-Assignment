<template>
  <Renderer ref="renderer" :antialias="true" :orbit-ctrl="true" :resize="true">
    <Camera :position="{z:10}"/>
    <Scene :background="0xffcc66">
      <PointLight :position="{y:50,z:50}"/>
<!--      <GltfModel-->
<!--        src="src/assets/model/t1.glb"-->
<!--      />-->
      <GltfModel :postion="{y:2}"
                 @load="onReady"
        src="src/assets/model/t2.glb"
    />
    </Scene>
  </Renderer>
</template>

<script setup>
</script>

<style scoped>

</style>