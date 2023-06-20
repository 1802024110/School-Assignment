<template>
  <tm-sheet :margin="[0]" :round="3" :shadow="2" :width="580" :height="540" @click="toDetail">
<!--        头像和用户名-->
<tm-row :column="6" class="px-n1" :margin="[0,16]">
          <tm-col :height="0" align="start" :col="1">
              <tm-avatar
                      class=""
                      :round="12"
                      :img="info.portrait"
              ></tm-avatar>
          </tm-col >
            <tm-col align="start" :col="3">
                <tm-text :font-size="28" :label="info.nickName"/>
                <tm-text :font-size="24" color="grey-1" class="mt-n5" :label="info.attentionCount+'关注者'"/>
        </tm-col>
        <tm-col align="end" :col="2">
<!--            <tm-button :margin="[1]"  size="small" :shadow="0" :round="20" label="关注"></tm-button>-->
        </tm-col>
        </tm-row>
<!--        标题行-->
      <tm-row @click="toDetail">
          <tm-text
                  class="my-3 text-weight-b"
                  _class="text-overflow-1"
                  :label="info.title"
          >
          </tm-text>
      </tm-row >
<!--        内容行-->
      <tm-row @click="toDetail">
              <tm-text
                      _class="text-overflow-4"
                      :label="info.content"
              >
                  </tm-text>
      </tm-row>
<!--        图片行-->
      <tm-row :margin="[0,5]">
          <view class="overflow round-2">
              <tm-image-group v-if="info.iorM!=null">
                  <tm-image  :padding="[2,2]" preview :width="141" :height="141" :src="item" v-for="(item,index) in info.iorM.slice(0,4)" :key="index"></tm-image>
              </tm-image-group>
          </view>
      </tm-row>
<!-- 时间 -->
      <tm-row justify="end" class="py-10">
            <tm-text color="grey-1" :fontSize="18" :label="info.createdAt"/>
      </tm-row>

<!--        查看数、点赞量、评论量、投票量-->
      <tm-row :column="3">
        <tm-col :col="1">
          <view class="flex flex-row flex-col-bottom-center ">
            <tm-icon :font-size="46" name="tmicon-eye-fill" ></tm-icon>
            <tm-text class="ml-n1" :label="info.look"/>
            <tm-text :label="110>=100?'+':''"/>
          </view>
        </tm-col>
        <tm-col :col="1">
          <view class="flex flex-row flex-col-bottom-center ">
            <tm-icon :font-size="42" name="tmicon-heart-fill"></tm-icon>
            <tm-text class="ml-n1" :label="info.good"/>
            <tm-text :label="1000>=1000?'+':''"/>
            </view>
        </tm-col>
        <tm-col :col="1">
          <view class="flex flex-row flex-col-bottom-center ">
            <tm-icon :font-size="42" name="tmicon-chart-pie-alt"></tm-icon>
            <tm-text class="ml-n1" :label="percent+'%'"/>
          </view>
        </tm-col>
      </tm-row>
  </tm-sheet>
</template>

<script setup lang="ts">
import tmButton from "@/tmui/components/tm-button/tm-button.vue";
import TmIcon from "@/tmui/components/tm-icon/tm-icon.vue";
import TmImage from "@/tmui/components/tm-image/tm-image.vue";
import TmImageGroup from "@/tmui/components/tm-image-group/tm-image-group.vue";
import TmText from "@/tmui/components/tm-text/tm-text.vue";
import TmAvatar from "@/tmui/components/tm-avatar/tm-avatar.vue";
import TmCol from "@/tmui/components/tm-col/tm-col.vue";
import TmRow from "@/tmui/components/tm-row/tm-row.vue";
import TmSheet from "@/tmui/components/tm-sheet/tm-sheet.vue";
import {computed} from "vue";

const props =  defineProps({
    // 帖基本信息
    info:{
        type:Object,
        default:{
            // 用户id
            uid:0,
            // 帖子id
            pid:1,
            // 头像
            portrait:"https://picsum.photos/200",
            // 用户名
            nickName:"默认用户名",
            // 标题
            title:"基于ChatGpt的建议助手",
            // 内容
            content:"作为用户和产品之间的桥梁，社交分享在产品的发展过程中扮演了重要的角色。用户主动点击分享 绝大多数APP都是在详情页等需要分享的页面放置一个分享按钮，由用户自行选择分享。这种情况下用户是否分享主要是取决于产品内容本身，比如内容有趣或是有用。在一些APP中设计者会对这个分享按钮加一些鼓励的文案或着重的设计来促进用户分享。所以监听用户的截图操作，提示用户进行分享，既缩短了以前分享截图的操作路径，避免了在之前长路径中的行为流失（比如截图完成后忘记分享或觉得麻烦放弃分享等等），也让用户觉得更加贴心。在常用的社交分享组件中，微信（微信好友和朋友圈）、微博、QQ（QQ好友和QQ空间）是三大主要平台，而其中微信凭借高达9.38亿的月活跃用户以及高达29%的日均手机应用使用率，成为各款APP选择最多、排位最靠前的分享途径。即便同样是腾...",
            // 图片
            iorM:["https://picsum.photos/200","https://picsum.photos/200","https://picsum.photos/200","https://picsum.photos/200","https://picsum.photos/200?id=1"],
            // 支持
            good:20,
            // 反对
            no_good:10,
            // 发布时间
            createdAt:"2023-3-3",
            // 关注人数
            attentionCount:20,
            // 查看人数
            look:20,
        }
    }
})

// 跳转到详情页
const toDetail = () => {
    uni.navigateTo({ url: '/pages/post-detail/index?pid='+props.info.pid })
}

const percent = computed(() => {
    const info = props.info
    return parseInt(((info.good/(info.good+info.no_good))*100))
});
</script>

<style lang='scss'>
</style>