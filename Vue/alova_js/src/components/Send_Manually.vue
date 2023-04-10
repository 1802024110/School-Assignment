<script setup>

import {todoHitokotoGetter} from "@/alova/apis";
import {useRequest} from "alova";
import {ref} from "vue";

const {send: addTodo} = useRequest(todoHitokotoGetter,{
    // 当immediate为false时，默认不发出
    immediate: false,
    // force 默认为 false，设置为 true 时将每次穿透缓存，并发送请求
    force: true
})
let data = ref(null)

function handleAddTodo(){
    addTodo().then(result => {
        data.value = result
    })
}
const name = "手动请求"
</script>

<template>
    <button @click="handleAddTodo">请求</button>
    <br>
    <template v-if="data!=null">
        <span>作者：{{ data.author }}</span>
        <br>
        <span>来源：{{ data.source }}</span>
        <br>
        <span>内容：{{ data.text }}</span>
    </template>
</template>
