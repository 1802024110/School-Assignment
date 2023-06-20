<template>
    <tm-navbar :transparent="false" :hideHome="true">

<!--        <template v-if="!back" v-slot:left>-->
<!--            <tm-text class="ml-n6">{{ title }}</tm-text>-->
<!--        </template>-->

        <template v-if="!back" v-slot:default>
            <tm-text></tm-text>
        </template>

<!--        <template v-if="back" v-slot:left>-->
<!--            <tm-icon _class="px-32" name="tmicon-arrow-left" :font-size="42"></tm-icon>-->
<!--        </template>-->

        <template v-if="back" v-slot:default>
            <tm-text>{{ title }}</tm-text>
        </template>
    </tm-navbar>
</template>

<script setup lang="ts">
import TmText from "@/tmui/components/tm-text/tm-text.vue";
import TmIcon from "@/tmui/components/tm-icon/tm-icon.vue";
import TmNavbar from "@/tmui/components/tm-navbar/tm-navbar.vue";

// props
defineProps({
    // 标题
    title: {
        type: String,
        default: "标题导航栏"
    },
    // 返回按钮
    back: {
        type: Boolean,
        default: false
    }
})
</script>
<style lang="scss">
</style>