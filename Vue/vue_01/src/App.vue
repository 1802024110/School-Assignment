<script setup>
import { ref } from "@vue/reactivity"

  const message = "Hello"
  const rawHtml = '<span style="color: red">This should be red.</span>'
  const redText = "color: red"
  const msg = ref
</script>

<template>
  <span>Message: {{message}}</span>
  <p>Using text interpolation: {{ rawHtml }}</p>
  <p>Using v-html directive: <span v-html="rawHtml"></span></p>
</template>

<style scoped>
</style>