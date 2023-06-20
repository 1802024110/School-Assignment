<template>
    <tm-app>
        <view class="status_bar" style="height: var(--status-bar-height); width: 100%;" />
        <!--    顶部头图-->
        <view class="top-box" @click="back">
            <tm-button transprent icon="tmicon-arrow-left" fontColor="white" :width="86" :round="10" :height="86"
                :fontSize="40" :margin="[10]" :shadow="0" text size="normal"></tm-button>
        </view>
        <!--        正文内容-->
        <tm-sheet v-if="true" :margin="[0]" :padding="[30]" :round="3" :shadow="2">
            <!--            文章标题-->
            <tm-row>
                <tm-text _class="text-overflow-1 text-weight-b" :font-size="36" :label="tiezhiInfo.title"></tm-text>
            </tm-row>
            <!--            用户头像-->
            <tm-row :column="12" :margin="[0, 10]">
                <tm-col :height="0" align="start" :col="2">
                    <tm-avatar :round="12" :img="tiezhiInfo.portrait"></tm-avatar>
                </tm-col>
                <tm-col :col="7" align="start">
                    <tm-text _class="text-overflow-1 " :font-size="36" :label="tiezhiInfo.nick_name"></tm-text>
                </tm-col>
                <!--                关注按钮-->
                <tm-col :col="3" align="end">
                    <tm-button :margin="[1]" size="small" :shadow="0" :round="20" label="关注"></tm-button>
                </tm-col>
            </tm-row>
            <!--            正文文本-->
            <tm-row>
                <tm-html class="fulled" :content="tiezhiInfo.content" ></tm-html>
            </tm-row>
            <!--            正文附件-->
            <tm-sheet v-if="fileList.length != 0" :height="0" :padding="[0]" :margin="[10, 30]" :shadow="1" :round="2"
                :border="2">
                <!--                row标签-->
                <tm-row :column="8" :height="0" class="fulled">
                    <tm-col :col="downloadUrl != '' ? 5 : 8" :height="0">
                        <tm-row v-if="downloadUrl != ''" :column="6">
                            <tm-col :height="0" :col="1">
                                <tm-icon class="pt-18" :font-size="80" name="tmicon-ios-attach"></tm-icon>
                            </tm-col>
                            <tm-col :height="0" :col="5">
                                <tm-text _class="text-overflow-1" label=""></tm-text>
                            </tm-col>
                        </tm-row>
                        <tm-text v-else :font-size="downloadUrl != '' ? 32 : 48" _class="font-weight-b"
                            label="该帖子有附件，请支付下载"></tm-text>
                    </tm-col>
                    <tm-col :col="downloadUrl != '' ? 3 : 0" :height="0" align="center">
                        <tm-button icon="tmicon-clouddownload-fill" size="normal" label="下载"></tm-button>
                    </tm-col>
                </tm-row>
            </tm-sheet>
            <!--            支付卡片-->
            <tm-card v-if="fileList.length != 0" status="文件大小 100M" title="购买附件">
                <template v-slot:content>
                    <view class="flex flex-row flex-row-center-center flex-1">
                        <tm-button :round="24" :margin="[24, 0]" label="会员购买 66￥" :font-size="24"></tm-button>
                        <tm-button :round="24" color="white" label="直接购买  99￥" :font-size="24"></tm-button>
                    </view>
                </template>
            </tm-card>
            <!--             赞同和反对-->
            <tm-row :column="2">
                <tm-col :col="1" :height="0">
                    <tm-button color="blue" icon="tmicon-wind-smile" :width="86" :round="10" :height="86" :fontSize="40"
                        :margin="[10]" :shadow="0" text></tm-button>
                    <tm-text label="支持" />
                </tm-col>
                <tm-col :col="1" :height="0">
                    <tm-button color="red" icon="tmicon-wind-cry" :width="86" :round="10" :height="86" :fontSize="40"
                        :margin="[10]" :shadow="0" text></tm-button>
                    <tm-text label="反对" />
                </tm-col>
            </tm-row>
            <!--             时间和查看量-->
            <tm-row :column="12" :margin="[0, 20]">
                <tm-col :col="6" align="start">
                    <tm-text label="2021-08-08 12:00:00"></tm-text>
                </tm-col>
                <tm-col :col="4" align="end">
                    <tm-text label="2323万 次查看"></tm-text>
                </tm-col>
                <tm-col :col="2" align="end">
                    <view class="flex flex-row flex-center">
                        <tm-icon name="tmicon-exclamation-circle"></tm-icon>
                        <tm-text _class="pl-10 nowrap" label="举报"></tm-text>
                    </view>
                </tm-col>
            </tm-row>
        </tm-sheet>

        <!--        评论区-->
        <tm-sheet v-if="true" color="white" :margin="[0, 10]" class="round-10">
            <tm-sheet :margin="[16, 16]" :padding="[0]">
                <tm-tabs :list="tabsTitle" align="left" :width="636" :height="300" default-name="1" itemModel="line"
                    activeColor="primary" activeFontColor="primary" @change="sortComment">
                </tm-tabs>
            </tm-sheet>
            <comment-card :comment="comment" v-for="(comment,index) in tiezhiInfo.commentList"/>
        </tm-sheet>
        <!-- 评论框 -->
        <comment-box class="fixed comment-box" />
    </tm-app>
</template>

<script setup lang="ts">

import tmTabs from "@/tmui/components/tm-tabs/tm-tabs.vue";
import commentBox from "@/component/comment/comment-box.vue";
import commentCard from "@/component/comment/comment-card.vue";
import tmBadge from "@/tmui/components/tm-badge/tm-badge.vue"
import tmCheckbox from "@/tmui/components/tm-checkbox/tm-checkbox.vue"
import tmCard from "@/tmui/components/tm-card/tm-card.vue"
import tmIcon from "@/tmui/components/tm-icon/tm-icon.vue"
import tmRow from "@/tmui/components/tm-row/tm-row.vue"
import tmText from "@/tmui/components/tm-text/tm-text.vue"
import tmButton from "@/tmui/components/tm-button/tm-button.vue"
import tmSheet from "@/tmui/components/tm-sheet/tm-sheet.vue"
import tmApp from "@/tmui/components/tm-app/tm-app.vue"
import TmCol from "@/tmui/components/tm-col/tm-col.vue";
import TmAvatar from "@/tmui/components/tm-avatar/tm-avatar.vue";
import TmButton from "@/tmui/components/tm-button/tm-button.vue";
import {onMounted, ref} from "vue";
import tmHtml from "@/tmui/components/tm-html/tm-html.vue"
import {onLoad} from "@dcloudio/uni-app";
import {getPostComment, getPostDetail} from "@/api/post";

// 帖子id
let pid = 1;

onLoad((option) => {
    pid = option?.pid;
})

const downloadUrl = ref('sf')

// 排序状态
const sortStatus = ref('up')

// 附件列表
const fileList = ref([
    { id: 1, name: '附件1', url: 'https://www.baidu.com' },
])

// 帖子信息
const tiezhiInfo = ref({
    // 帖主id
    u_id: 1,
    // 原价格
    price: 0,
    // 折扣价格
    discount_price: 0,
    // 头像
    portrait: "https://picsum.photos/200",
    // 用户名
    nick_name: "默认用户名",
    // 标题
    title: "基于ChatGpt的建议助手",
    // 内容
    content: `<div class="content_area" id="content_area">
             <!--repaste.body.begin--><p><strong>　　央视网消息：</strong>在安徽中稻迎来了丰收季。在肥东县相邻的两块地景象大不相同，农机作业的进度和效率也不同。<br></p><p style="text-align: center;" class="photo_img_20190808"><img src="//p4.img.cctvpic.com/photoworkspace/contentimg/2022/10/14/2022101414244666208.jpg" alt=""></p><p style="text-align: center;" class="photo_img_20190808"><img src="//p5.img.cctvpic.com/photoworkspace/contentimg/2022/10/14/2022101414244671910.jpg" alt=""></p><p>　　<strong>总台记者 吴俊：</strong>这里是肥东县古城镇，今天天气晴好，收割机已经进入高标准农田作业。去年秋季，肥东县有7.8万亩田地进行高标准农田改造。改造后的农田，可以说是田成方、林成网、渠相通、路相连。这里一路之隔，一侧是改造过的农田，不仅有了机耕路，农机可以直接到田边，而且修建了标准的灌渠，灌溉和排涝不愁。而路的一侧是还没改造的地块，只有窄窄的杂草丛生的田埂，灌渠也是这种土渠。另外从航拍画面对比来看，改造过的农田，通过小田变大田，打破了田埂，非常适合农机作业。而没有改造过的，田块大小不均、高低不平，农机也没办法下田作业。<br></p><p style="text-align: center;" class="photo_img_20190808"><img src="//p3.img.cctvpic.com/photoworkspace/contentimg/2022/10/14/2022101414250079300.jpg" alt=""></p><p style="text-align: center;" class="photo_img_20190808"><img src="//p3.img.cctvpic.com/photoworkspace/contentimg/2022/10/14/2022101414250072259.jpg" alt=""></p><p>　　改造后的高标准农田，配套了机械深耕、增施有机肥和土壤调理等综合措施，改善了土壤板结度、有机质含量以及酸碱平衡，这为眼前的好收成打下了基础。稻谷颗粒非常饱满，尽管今年水稻在抽穗扬花期遭遇了持续高温，但是高标准农田改造后，能够及时引水灌溉，而且今年当地还种植了抗病新品种，应用了绿色防控等新技术，水稻产量不仅没受太大影响，比去年每亩还高了100斤左右。<br></p><!--repaste.body.end-->
            </div>` ,
    // 支持率
    percent: 20,
    // 发布时间
    time: "2023-3-3",
    // 关注人数
    follow: 20,
    // 用户和帖子的关系
    COALESCE:{
        // 当前用户id
        u_id: 1,
        //
    },
    // 评论列表
    commentList: {
                // 评论id
                commentsId: 1,
                // 评论用户id
                nickName: "新用户",
                // 评论用户头像
                portrait: "https://q1.qlogo.cn/g?b=qq&nk=1802024110&s=640",
                // 评论内容
                commentText: "哈哈哈",
                // 评论图片
                commentImg: [],
                // 评论点赞数
                good: 0,
                // 当前用户是否点赞
                isGood: 0,
                // 评论回复数
                counts: 1,
                // 评论回复列表
                comments: [
                    {
                        // 评论用户id
                        nickName: "新用户",
                        // 评论用户头像
                        portrait: "https://q1.qlogo.cn/g?b=qq&nk=1802024110&s=640",
                        // 评论内容
                        commentText: "牛",
                    }
                ]
            }
})

const tabsTitle = ref([
    { key: "1", title: "评论", icon:"tmicon-sort-up"},
]  as Tmui.tabs)

// 评论排序函数
const sortComment = (e:number) => {
    if (e == 1) {
        if (sortStatus.value == 'up') {
            sortStatus.value = 'down'
            tabsTitle.value[0].icon = 'tmicon-sort-down'
        } else {
            sortStatus.value = 'up'
            tabsTitle.value[0].icon = 'tmicon-sort-up'
        }
    }
}

// 返回键事件
const back = () => {
    uni.navigateBack();
}

onMounted(() => {

    // 获取帖子信息
    getPostDetail(pid).then(res => {
        tiezhiInfo.value = res.data
    })
    // 获取帖子评论
    getPostComment(pid).then(res => {
        // 将获取到的评论列表赋值给commentList
        tiezhiInfo.value.commentList = res.data
    })
})
</script>

<style lang="scss">
.top-box {
    width: 100%;
    height: 400rpx;
    background-image: url("https://cdn.cdnjson.com/tvax3.sinaimg.cn//large/0072Vf1pgy1foxlol5zqjj310p1hc7se.jpg");
    background-size: cover;
    background-repeat: no-repeat;
}

.comment-box {
    width: 100%;
    bottom: 0;
}

</style>
