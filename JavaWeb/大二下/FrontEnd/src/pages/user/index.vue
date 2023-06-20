<template>
   <tm-app color="white">
    <top-bar title="我的" />
    <tm-sheet :margin="[0,60]">
      <!-- 头像用户名和编辑资料 -->
      <tm-row :column="16">
         <tm-col :col="3" :height="0" align="start">
            <tm-avatar  :round="14" :size="120" :img="userInfo?.portrait"></tm-avatar>
         </tm-col >
         <tm-col :col="7" align="start" :height="0">
            <tm-text :fontSize="32" :label="userInfo?.nickName"/>
         </tm-col>
         <tm-col :col="6" :height="0" align="end">
            <tm-button @click="toUserInfo" label="编辑资料" :width="160"/>
         </tm-col>
      </tm-row>
      <!-- 个人简介 -->
      <tm-text class="mt-12" :fontSize="24" :label="userInfo?.describeText" :margin="[0,0,0,0]"/>
      <!-- 关注粉丝灵值 -->
      <tm-row :column="15" :margin="[0,40]">
         <tm-col :col="3" :height="0" align="center">
            <tm-text label="关注" :fontSize="32"/>
            <tm-text :label="userInfo?.attention" :fontSize="26"/>
         </tm-col>
         <tm-col :col="9" :height="0" align="center">
            <tm-text label="粉丝" :fontSize="32"/>
            <tm-text :label="userInfo?.fans" :fontSize="26"/>
         </tm-col>
         <tm-col :col="3" :height="0" align="center">
            <tm-text label="灵值" :fontSize="32"/>
            <tm-text :label="userInfo?.spirit" :fontSize="26"/>
         </tm-col>
      </tm-row>
      <!-- 我的服务 -->
      <tm-divider :margin="[0]"></tm-divider>
      <tm-text class="mt-40" :fontSize="32" label="我的服务" :margin="[0,0,0,0]"/>
      <!-- 我的服务选项 -->
      <tm-row :column="3" :margin="[0,30]">
         <tm-col :col="1" :height="0" align="center">
            <tm-avatar  :size="80" :img="taskCenter"></tm-avatar>
            <tm-text label="任务中心" :fontSize="26"/>
         </tm-col>
         <tm-col :col="1" :height="0" align="center">
            <tm-avatar  :size="80" :img="myComment"></tm-avatar>
            <tm-text label="我的评论" :fontSize="26"/>
         </tm-col>
         <tm-col :col="1" :height="0" align="center">
            <tm-avatar  :size="80" :img="myCollect"></tm-avatar>
            <tm-text label="我的收藏" :fontSize="26"/>
         </tm-col>
         <tm-col :col="1" :height="0" align="center">
            <tm-avatar  :size="80" :img="myVip"></tm-avatar>
            <tm-text label="会员" :fontSize="26"/>
         </tm-col>
         <tm-col :col="1" :height="0" align="center">
            <tm-avatar  :size="80" :img="myHistory"></tm-avatar>
            <tm-text label="浏览记录" :fontSize="26"/>
         </tm-col>
      </tm-row>
      <!-- 我的工具 -->
      <tm-text class="mt-40" :fontSize="32" label="我的工具" :margin="[0,0,0,0]"/>
      <!-- 我的工具选项 -->
      <tm-row :column="3" :margin="[0,30]">
         <tm-col :col="1" :height="0" align="center">
            <tm-avatar  :size="80" :img="myFeedback"></tm-avatar>
            <tm-text label="意见反馈" :fontSize="26"/>
         </tm-col>
         <tm-col :col="1" :height="0" align="center">
            <tm-avatar  :size="80" :img="myBlackHouse"></tm-avatar>
            <tm-text label="小黑屋" :fontSize="26"/>
         </tm-col>
         <tm-col :col="1" :height="0" align="center">
            <tm-avatar  :size="80" :img="mySetting"></tm-avatar>
            <tm-text label="设置" :fontSize="26"/>
         </tm-col>
      </tm-row>
    </tm-sheet>
   </tm-app>
</template>

<script setup lang="ts">
import tmApp from '@/tmui/components/tm-app/tm-app.vue';
import TopBar from "@/component/top-bar.vue";
import TmSheet from "@/tmui/components/tm-sheet/tm-sheet.vue";
import TmRow from "@/tmui/components/tm-row/tm-row.vue";
import TmCol from "@/tmui/components/tm-col/tm-col.vue";
import TmAvatar from "@/tmui/components/tm-avatar/tm-avatar.vue";
import TmText from "@/tmui/components/tm-text/tm-text.vue";
import TmButton from "@/tmui/components/tm-button/tm-button.vue";
import tmDivider from "@/tmui/components/tm-divider/tm-divider.vue"
import { onMounted, ref } from "vue";
import { getUserInfo } from "@/api/user";

// 任务中心
import  taskCenter from "@/static/user/taskCenter.png";
// 我的评论
import  myComment from "@/static/user/myComment.png";
// 我的收藏
import  myCollect from "@/static/user/myCollect.png";
// 我的会员
import  myVip from "@/static/user/myVip.png";
// 浏览记录
import  myHistory from "@/static/user/myHistory.png";
// 意见反馈
import  myFeedback from "@/static/user/myFeedback.png";
// 小黑屋
import  myBlackHouse from "@/static/user/myBlackHouse.png";
// 设置
import  mySetting from "@/static/user/mySetting.png";
import { UserInfo } from '@/api/interface/User';

// 跳转到个人资料
const toUserInfo = () => {
   uni.navigateTo({ url: '/pages/user/personal-data' })
}

// 用户信息
const userInfo = ref<UserInfo>()

onMounted(() => {
   getUserInfo().then(res => {
      userInfo.value = res.data
      console.log(userInfo.value)
   })
})
</script>

<style scoped></style>