<template>
    <tm-sheet :padding="[16]" :margin="[0]">
        <!--      拿来唬人的评论框-->
        <tm-row :column="12">
            <tm-col :col="10" class="">
                <view class="flex flex-row flex-row-center-start fulled" @click="changPos()">
                    <tm-icon :font-size="42" name="tmicon-edit"></tm-icon>
                    <!--                  按钮-->
                    <tm-text class="ml-n6" label="此处回复"></tm-text>
                </view>
            </tm-col>
            <tm-col :col="1">
                <tm-icon :font-size="42" name="tmicon-share"></tm-icon>
            </tm-col>
            <tm-col :col="1">
                <tm-icon :font-size="42" name="tmicon-ios-star-outline"></tm-icon>
            </tm-col>
        </tm-row>
        <!--      这里才是真正的评论框-->
        <tm-drawer :height="600" cancelText="回复" okText="发布" ref="calendarView" placement="bottom" v-model:show="showWin">
            <tm-row>
                <textarea
                    class="flex-1 px-20"
                    // #ifdef MP-WEIXIN
                   style="height: 350rpx"
                    // #endif
                   :maxlength="300" fixed />
            </tm-row>
            <!-- 图片行-->
            <tm-row>
                <view class="overflow">
                    <tm-image-group >
                        <tm-image :width="90" :height="100" :padding="[5,2]" preview :src="item"
                                  v-for="item in info.images.slice(0,3)" :key="item"></tm-image>
                    </tm-image-group>
                </view>
            </tm-row>
            <tm-row :column="3" :margin="[0,10]">
                <tm-col :col="1">
                    <tm-icon :font-size="42" name="tmicon-wind-smile"></tm-icon>
                </tm-col>
                <tm-col :col="1">
                    <tm-icon :font-size="42" name="tmicon-picture"></tm-icon>
                </tm-col>
                <tm-col :col="1">
                    <tm-icon :font-size="42" name="tmicon-ios-at"></tm-icon>
                </tm-col>
            </tm-row>
        </tm-drawer>
    </tm-sheet>
</template>

<script setup lang="ts">

import tmSheet from "@/tmui/components/tm-sheet/tm-sheet.vue"
import tmIcon from "@/tmui/components/tm-icon/tm-icon.vue"
import tmCol from "@/tmui/components/tm-col/tm-col.vue";
import tmRow from "@/tmui/components/tm-row/tm-row.vue"
import tmButton from "@/tmui/components/tm-button/tm-button.vue"
import tmInput from "@/tmui/components/tm-input/tm-input.vue"
import {ref, getCurrentInstance, nextTick} from "vue"
import {onShow, onLoad} from "@dcloudio/uni-app";
import tmApp from "@/tmui/components/tm-app/tm-app.vue"
import tmText from "@/tmui/components/tm-text/tm-text.vue"
import tmDivider from "@/tmui/components/tm-divider/tm-divider.vue"
import tmDrawer from "@/tmui/components/tm-drawer/tm-drawer.vue"
import tmPicker from "@/tmui/components/tm-picker/tm-picker.vue"
import TmRow from "@/tmui/components/tm-row/tm-row.vue";
import TmImage from "@/tmui/components/tm-image/tm-image.vue";
import TmImageGroup from "@/tmui/components/tm-image-group/tm-image-group.vue";
import TmDrawer from "@/tmui/components/tm-drawer/tm-drawer.vue";

const showWin = ref(false)

// 底部弹出框
const calendarView = ref<InstanceType<typeof TmDrawer>>(null)

function changPos() {
    showWin.value = true
}

defineProps({
    // 帖基本信息
    info:{
        type:Object,
        default:{
            // 头像
            avatar:"https://picsum.photos/200",
            // 用户名
            username:"默认用户名",
            // 标题
            title:"基于ChatGpt的建议助手",
            // 内容
            content:"作为用户和产品之间的桥梁，社交分享在产品的发展过程中扮演了重要的角色。用户主动点击分享 绝大多数APP都是在详情页等需要分享的页面放置一个分享按钮，由用户自行选择分享。这种情况下用户是否分享主要是取决于产品内容本身，比如内容有趣或是有用。在一些APP中设计者会对这个分享按钮加一些鼓励的文案或着重的设计来促进用户分享。所以监听用户的截图操作，提示用户进行分享，既缩短了以前分享截图的操作路径，避免了在之前长路径中的行为流失（比如截图完成后忘记分享或觉得麻烦放弃分享等等），也让用户觉得更加贴心。在常用的社交分享组件中，微信（微信好友和朋友圈）、微博、QQ（QQ好友和QQ空间）是三大主要平台，而其中微信凭借高达9.38亿的月活跃用户以及高达29%的日均手机应用使用率，成为各款APP选择最多、排位最靠前的分享途径。即便同样是腾...",
            // 图片
            images:(()=>{
                let list = []
                for(let i = 0;i<4;i++){
                    list.push("https://picsum.photos/312/312?id="+i)
                }
                return list
            })(),
            // 支持率
            percent:20,
            // 发布时间
            time:"2023-3-3",
            // 查看数
            view:100,
            // 点赞数
            like:100,
            // 评论数
            comment:100,
            // 关注人数
            follow:20
        }
    }
})
</script>

<style scoped>
</style>