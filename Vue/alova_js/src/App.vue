<script setup>
import Send_Auto from "@/components/Send_Auto.vue";
import Send_Manually from "@/components/Send_Manually.vue";
import {shallowRef} from "vue";

const tabs = [
    Send_Auto,
    Send_Manually
]

let currentTab = shallowRef(Send_Auto)

</script>

<template>
  <button
          v-for="(tab,index) in tabs"
          :key="index"
          @click="currentTab = tab"
  >
      {{tab.__name}}
  </button>
    <br>
  <component :is="currentTab"/>
</template>

<style scoped>
header {
  line-height: 1.5;
}
</style>
