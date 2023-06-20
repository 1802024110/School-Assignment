<template>
   <tm-app>
      <top-bar title="分区" />
      <tm-sheet :padding="[0]" :margin="[0]" class="fulled ">
         <!-- 分区tabs -->
         <tm-tabs @change="changePartition" showTabsLineAni :item-width="120" :width="750" :height="0" default-id="1" :gutter="20">
            <tm-tabs-pane v-for="item in partitionList" :key="item.id" :name="item.id" :title="item.title">
               <view class="ml-n15">
                  <view class="mt-n6" v-for="(card,index) in newCards" :key="index">
                     <new-cards :info="card"/>
                  </view>
               </view>
            </tm-tabs-pane>
         </tm-tabs>
      </tm-sheet>
   </tm-app>
</template>

<script setup lang="ts">
import NewCards from "@/component/home/new-cards.vue";
import TopBar from "@/component/top-bar.vue";
import tmApp from "@/tmui/components/tm-app/tm-app.vue";
import tmSheet from "@/tmui/components/tm-sheet/tm-sheet.vue";
import tmTabs from "@/tmui/components/tm-tabs/tm-tabs.vue";
import tmTabsPane from "@/tmui/components/tm-tabs-pane/tm-tabs-pane.vue"
import { ref,onMounted } from "vue";
import {getPostListBySection, getSectionList} from "../../api/post";

const partitionList = ref();

// 分区帖子列表
const newCards = ref();

onMounted(() => {
   // 获取分区列表
   getSectionList().then((res) => {
      partitionList.value = res.data;
   });

   // 获取分区帖子列表
   getPostListBySection(1).then((res) => {
        newCards.value = res.data;
    });
});

// 切换分区
const changePartition = (id) => {
    getPostListBySection(id).then((res) => {
        newCards.value = res.data;
    });
};

</script>

<style scoped></style>