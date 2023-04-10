<script setup>
import {todoHitokotoGetter} from "@/alova/apis";
import {useRequest} from "alova";

const {loading, data } = useRequest(todoHitokotoGetter)
</script>

<template>
  <!-- 你可以直接使用 data 来渲染 todo 列表 -->
    <div v-if="loading">Loading...</div>
    <template v-else>
            <span>作者：{{ data.author }}</span>
        <br>
            <span>来源：{{ data.source }}</span>
        <br>
            <span>内容：{{ data.text }}</span>
    </template>
</template>
