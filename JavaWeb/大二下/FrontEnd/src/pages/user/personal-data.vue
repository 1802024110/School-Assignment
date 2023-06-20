<template>
  <tm-app color="white">
    <top-bar back title="个人资料" />
    <tm-sheet :padding="[0]">
      <!-- 头像 -->
      <tm-row justify="center" :margin="[0, 30]">
        <tm-avatar :round="12" :size="300"
          img="https://picsum.photos/312/312?id=12"></tm-avatar>
      </tm-row>
      <!-- 单元格列表 -->
      <!-- 账号 -->
      <tm-cell :margin="[0, 0]" :titleFontSize="30" title="账号">
        <template #right>
          <tm-text color="grey-1"  label="82021986"/>
        </template>
      </tm-cell>
      <!-- 注册时间 -->
      <tm-cell :margin="[0, 0]" :titleFontSize="30" title="注册时间">
        <template #right>
          <tm-text color="grey-1"  label="2022年7月31日"/>
        </template>
      </tm-cell>
      <!-- 等级 -->
      <tm-cell :margin="[0, 0]" :titleFontSize="30" title="等级">
        <template #right>
          <tm-text color="grey-1"  label="LV 1"/>
        </template>
      </tm-cell>
      <!-- 昵称 -->
      <tm-cell :margin="[0, 0]" :titleFontSize="30" title="昵称">
        <template #rightText>
          <tm-text label="张伟新" class="mr-20"/>
        </template>
      </tm-cell>
      <!-- 个人简介 -->
      <tm-cell :margin="[0, 0]" :titleFontSize="30" title="个人简介">
        <template #rightText>
          <tm-text label="这个人很懒，什么都没有留下" class="mr-20"/>
        </template>
      </tm-cell>
      <!-- 性别 -->
      <tm-cell :margin="[0, 0]" :titleFontSize="30" title="性别">
        <template #rightText>
          <tm-text label="男" class="mr-20"/>
        </template>
      </tm-cell>
      <!-- 邮箱 -->
      <tm-cell :margin="[0, 0]" :titleFontSize="30" title="邮箱">
        <template #rightText>
          <tm-text label="ebgilnv@vip.qq.com" class="mr-20"/>
        </template>
      </tm-cell>
    </tm-sheet>
    <!-- 修改昵称抽屉 -->
    
  </tm-app>
</template>

<script setup lang="ts">
import tmApp from '@/tmui/components/tm-app/tm-app.vue';
import TopBar from "@/component/top-bar.vue";
import TmAvatar from "@/tmui/components/tm-avatar/tm-avatar.vue";
import TmRow from "@/tmui/components/tm-row/tm-row.vue";
import tmCell from "@/tmui/components/tm-cell/tm-cell.vue"
import TmSheet from "@/tmui/components/tm-sheet/tm-sheet.vue";
import TmText from "@/tmui/components/tm-text/tm-text.vue";
</script>

<style scoped></style>