<template>
    <tm-app ref="app" color="white">
        <tm-sheet :margin="[30,0]" :padding="[0]" >
               <!-- 状态栏 -->
        <top-bar title="首页" />

        <!-- 搜索和通知 -->
        <tm-row class="fulled" :column="6" :height="80" :margin="[0,10]">
            <tm-col :col="5" color="grey-4">
                <tm-input :border="4" :transprent="true" class="fulled" :round="25" placeholder="搜索想要的灵感"
                    suffix="tmicon-search"></tm-input>
            </tm-col>
            <tm-col color="grey-4" :col="1">
                <tm-badge dot color="red" :right="25" >
                    <tm-icon name="tmicon-tongzhifill" :fontSize="42"/>
                </tm-badge>
            </tm-col>
        </tm-row>

        <!-- 热门灵感 -->
        <tm-text class="fulled mb-n3" :fontSize="32">热门灵感</tm-text>
        
        <!-- 热门帖子卡片 -->
        <view class="flex flex-row-center-start	overflow-y ml--10 hidden-scroll">
            <view class="px-6"  >
                <hot-cards />
            </view>
        </view>

        <!-- 最新灵感 -->
        <tm-text class="fulled mt-n8" :fontSize="32">最新灵感</tm-text>
        </tm-sheet>

        <!-- 最新灵感tabs -->
        <tm-sheet>
            <view class="ml-n2">
                <view class="mt-n6" v-for="(item,index) in recommendList.newest" :key="index">
                    <new-cards :info="item"/>
                </view>
            </view>
        </tm-sheet>
    </tm-app>
</template>

<script setup lang="ts">

import NewCards from "@/component/home/new-cards.vue";
import TmSheet from "@/tmui/components/tm-sheet/tm-sheet.vue";
import HotCards from "@/component/home/hot-cards.vue";
import TmText from "@/tmui/components/tm-text/tm-text.vue";
import TmBadge from "@/tmui/components/tm-badge/tm-badge.vue";
import TmIcon from "@/tmui/components/tm-icon/tm-icon.vue";
import TmRow from "@/tmui/components/tm-row/tm-row.vue";
import TmCol from "@/tmui/components/tm-col/tm-col.vue";
import TmInput from "@/tmui/components/tm-input/tm-input.vue";
import TmApp from "@/tmui/components/tm-app/tm-app.vue";
import TopBar from "@/component/top-bar.vue";
import { ref,onMounted   } from "vue";
import {getRecommend} from "../../api/post";
import {Post} from "@/api/interface/Post";

const searchValue = ref("");

// 首页推荐帖子列表
const recommendList = ref({
});

onMounted(()=>{
    getRecommend().then(res=>{
        recommendList.value = res.data;
    })
})
</script>

<style scoped>

/* 隐藏滚动条 */
.hidden-scroll::-webkit-scrollbar { display: none; }

</style>
