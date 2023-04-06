<script setup>
  import {todoHitokotoGetter} from "@/alova/apis";
  import {useRequest} from "alova";

  const {
      // loading是加载状态值，当加载时它的值为true，结束后自动更新为false
      // 它是一个Ref类型的值，你可以通过loading.value访问它，或直接绑定到界面中
      loading,

      // 响应数据
      data,

      // 请求错误对象，请求错误时有值，否则为undefined
      error,

      // 成功回调绑定
      onSuccess,

      // 失败回调绑定
      onError,

      // 完成回调绑定
      onComplete,

      // 直接将Method对象传入即可发送请求
  } = useRequest(todoHitokotoGetter)
  onSuccess((event,method) =>{
      data.value.json().then((data)=>{
          console.log(data)
      })
  })
</script>

<template>
    <!-- 你可以直接使用 data 来渲染 todo 列表 -->
    <div v-if="loading">Loading...</div>
    <div
        v-else-if="error"
        class="error">
        {{ error.message }}
    </div>
    <template v-else>
            <div class="todo-title">{{ data }}</div>
    </template>
</template>

<style scoped>
header {
  line-height: 1.5;
}
</style>
