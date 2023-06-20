<template>
    <tm-comment :margin="[16,0]" :padding="[0]" authorColor="black" :author="comment.nickName" :avatar="comment.portrait"
        :time="comments.time">
        <!-- 父评论区内容 -->
        <template v-slot:content>
            <tm-text ref="fatherContent" v-if="commentsAllShow" _class="wrap" :label="comment.commentText" />
            <tm-text ref="fatherContent" v-else _class="text-overflow-4 wrap" :label="comment.commentText" />

            <!--        图片行-->
            <tm-row :margin="[-13, 5]">
                <view class="overflow round-2">
                    <tm-image-group v-if="comment.images != null">
                        <tm-image class="d-inline-block" :padding="[2, 2]" preview :width="190" :height="190"
                            :src="image" v-for="(image,index) in comment.images" :key="index"></tm-image>
                    </tm-image-group>
                </view>
            </tm-row>
        </template>
        <!-- 父评论功能区 -->
        <template v-slot:actions>
            <view class="flex flex-row norwap fulled"  v-if="commentsShow">
                <tm-button :margin="[0]" transprent text :shadow="0" :width="60" :height="30" :label="commentsAllShow?'收起':'展开'" @click="commentsAllShow=!commentsAllShow"></tm-button>
            </view>
            <view class="flex flex-row">
                <view class="flex flex-row flex-center pl-16">
                    <tm-icon :font-size="24" name="tmicon-comment-dots"></tm-icon>
                    <tm-text _class="pl-10 nowrap" :font-size="24" label="回复"></tm-text>
                </view>
                <view class="flex flex-row flex-center pl-16">
                    <tm-icon :font-size="24" name="tmicon-md-heart"></tm-icon>
                    <tm-text _class="pl-10 nowrap" :font-size="24" :label="comment.good"></tm-text>
                </view>
                <view class="flex flex-row flex-center pl-16">
                    <tm-icon :font-size="24" name="tmicon-exclamation-circle"></tm-icon>
                    <tm-text _class="pl-10 nowrap" :font-size="24" label="举报"></tm-text>
                </view>
            </view>
        </template>
        <!-- 子评论 -->
        <tm-comment :margin="[0]" :padding="[12, 0]" v-for="(reply,index) in comment.comments" :key="index">
            <template v-slot:content>
                <view>
                    <tm-text class="nowrap" :label="reply.nickName + ':'"></tm-text>
                    <tm-text :line-height="24" :font-size="16" class="ml-n2 wrap" :label="'   ' + reply.commentText"></tm-text>
                </view>
            </template>
            <template v-slot:time>
                <view></view>
            </template>
        </tm-comment>
        <view class="flex flex-row norwap fulled mt-n3" v-if="replyCount>=0" @click="replyCount -= 3">
            <tm-text :font-size="16" color="primary" :label="'还有 ' + replyCount + ' 条评论(查看更多)'" />
        </view>
    </tm-comment>
    <tm-divider color="grey"></tm-divider>
</template>

<script setup lang="ts">

import tmImageGroup from "@/tmui/components/tm-image-group/tm-image-group.vue"
import tmImage from "@/tmui/components/tm-image/tm-image.vue"
import tmRow from "@/tmui/components/tm-row/tm-row.vue"
import tmCol from "@/tmui/components/tm-col/tm-col.vue"
import tmApp from "@/tmui/components/tm-app/tm-app.vue"
import tmSheet from "@/tmui/components/tm-sheet/tm-sheet.vue"
import tmText from "@/tmui/components/tm-text/tm-text.vue"
import tmIcon from "@/tmui/components/tm-icon/tm-icon.vue"
import tmDivider from "@/tmui/components/tm-divider/tm-divider.vue"
import tmButton from "@/tmui/components/tm-button/tm-button.vue"
import tmComment from "@/tmui/components/tm-comment/tm-comment.vue"
import tmInput from "@/tmui/components/tm-input/tm-input.vue"
import {ref, watch} from "vue"
import { onReady } from "@dcloudio/uni-app"
import { onMounted } from "vue"

const props = defineProps({
    comments: {
        type: Object,
        default: {
            avatar: 'https://picsum.photos/200/200',
            author: 'user',
            time: '2021-02-01T00:00:00.000Z',
            content: 'Hlorlrodlorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrodod!lorlrodod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!lorlrod!!',
            images: [
                { id: 1, src: 'https://picsum.photos/312/312?id=1' },
                { id: 2, src: 'https://picsum.photos/312/312?id=2' },
                { id: 3, src: 'https://picsum.photos/312/312?id=3' },
            ],
            likes: 100,
            reply: [
                {
                    id: 1,
                    author: '电风扇电士是',
                    content: 'Hello Worlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorld!',
                },
                {
                    id: 2,
                    author: 'user',
                    content: 'Hello World!',
                },
                {
                    id: 3,
                    author: 'user',
                    content: 'Hello World!',
                },
                {
                    id: 4,
                    author: '电风扇电士是',
                    content: 'Hello Worlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorlorld!',
                },
                {
                    id: 5,
                    author: 'user',
                    content: 'Hello World!',
                },
                {
                    id: 6,
                    author: 'user',
                    content: 'Hello World!',
                }
            ],
            reply_count: 6
        }
    },
    comment: "",
})

// 展开评论按钮是否显示
const commentsShow = ref(false)

// 是否展示所有评论
const commentsAllShow = ref(true)

// 没有展开的回复的数量
const replyCount = ref(props.comment.counts - 3);
watch(replyCount, (newVal) => {
    if (newVal <= 0) {
        replyCount.value = 0;
    }
})

// 获取评论内容长度
const contentLength = props.comments.content.length;
// 评论内容是否超过4行,178字
if (contentLength > 182) {
    commentsShow.value = true;
}

const fatherContent = ref<InstanceType<typeof tmText> | null>(null)

onMounted(()=>{
    // 一行的高度
    const lineHeight = 19;

    // 显示的行数
    const lineCount = 4;

    // 获取评论框的高度
    const height = fatherContent.value.$el.offsetHeight;

    // 如果内容超过4行,则显示展开按钮
    if (height > lineHeight * lineCount) {
        commentsAllShow.value = false;
    }else{
        commentsAllShow.value = true;
    }

    console.log(props.comment)
})

</script>

<style lang="scss"></style>
