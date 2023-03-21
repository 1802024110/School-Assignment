<template>
  <Box :position="position" :scale="scale">
    <PhongMaterial :color="color"/>
  </Box>
</template>

<script setup>
import {ref} from 'vue'
import {Box, PhongMaterial} from 'troisjs'

const position = ref({x: 0, y: 0, z: 0})
const color = ref('#9acd32')
const props = defineProps({
  index: {
    type: Number,
    required: true
  },
  scale: {
    type: Object,
    default: {
      x: 1,
      y: 1,
      z: 1
    }
  }
})

position.value = {x: (10 + 10) * props.index, y: 0, z: 0}
</script>

<style scoped>

</style>