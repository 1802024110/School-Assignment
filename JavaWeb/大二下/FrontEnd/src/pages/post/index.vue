<template>
  <tm-app color="white">
    <top-bar title="发布帖子" />
    <tm-sheet>
      <!-- 标题 -->
      <view>
        <tm-input v-model="fromValue.title" :maxlength="20" transprent placeholder="好的标题能吸引更多人的注意奥（最多20字）"
          showCharNumber></tm-input>
        <tm-divider class="mt--20"></tm-divider>
      </view>

      <!-- 内容 -->
      <view>
        <piaoyiEditor :values="richEditorOptions.values" :name="richEditorOptions.name" :maxlength="richEditorOptions.maxlength" @changes="richEditorOptions.saveContent" :readOnly="richEditorOptions.readOnly" :photoUrl="richEditorOptions.photoUrl" :api="richEditorOptions.api"/>
      </view>

      <partition-tag  :price="fromValue.price" :private="fromValue.private" :tag-list="fromValue.tag" :partition="fromValue.partition"  v-model:show="isCellShow.partition" v-model="fromValue"/>

      <!-- 发布按钮 -->
      <view>
        <tm-button @click="publish" block label="发布" class="flex-1"></tm-button>
      </view>
    </tm-sheet>
  </tm-app>
</template>

<script setup lang="ts">
import TopBar from "@/component/top-bar.vue";
import TmApp from "@/tmui/components/tm-app/tm-app.vue";
import tmInput from "@/tmui/components/tm-input/tm-input.vue"
import TmSheet from "@/tmui/components/tm-sheet/tm-sheet.vue"
import tmDivider from "@/tmui/components/tm-divider/tm-divider.vue";
import tmCell from "@/tmui/components/tm-cell/tm-cell.vue"
import tmButton from "../../tmui/components/tm-button/tm-button.vue"

import piaoyiEditor from "@/uni_modules/piaoyi-editor_1.0.3/components/piaoyi-editor/piaoyi-editor.vue";

import PartitionTag from "@/component/post/partition-tag.vue";

import { reactive, ref } from "vue";

// 单元格抽屉是否显示
const isCellShow = ref({
  // 分区抽屉栏
  partition:true,
  // Tag抽屉栏
  tag:false,
  // 添加附件抽屉栏
  attachment:false,
})

const fromValue = ref({
  // 标题
  title:"",
  // 内容
  content:"",
  // 分区
  partition:0,
  // Tag
  tag:[],
  // 私密
  private:false,
  // 价格
  price : 0,
  // 附件
  attachment:undefined,
})

// 富文本编辑器设置
const richEditorOptions  = ref({
  readOnly: false, //是否只读
  photoUrl: '', //服务器图片域名或者ip
  api: '', //上传图片接口地址
  name: 'file', //上传图片接口的key值
  values: '', //默认值,
  maxlength: 3000, //最大输入长度
  saveContent: (e:{html:string}):void => {
    fromValue.value.content = e?.html
    console.log(fromValue)
  }
})

// 发布
const publish = () => {
  console.log(fromValue.value)
}
</script>

<style scoped></style>