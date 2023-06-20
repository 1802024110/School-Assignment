<template>
  <tm-collapse>
    <!-- 分区 -->
    <tm-collapse-item title="选择分区" name="1">
      <tm-indexes :height="150">
        <tm-indexes-item >
          <view class="my-10 flex flex-row flex-wrap fulled-height">
            <tm-tag @click="selectPartition(item)" outlined :label="item.name" v-for="item in partitionList"
              :key="item.id" />
          </view>
        </tm-indexes-item>
      </tm-indexes>
    </tm-collapse-item>
    <!-- TAG -->
    <tm-collapse-item title="选择TAG" name="2">
      <tm-indexes :height="150">
        <tm-indexes-item >
          <!-- tag搜索按钮 -->
          <tm-input v-model="tagValue" @search="addTag" prefix="tmicon-tag" searchLabel="添加"
            placeholder="添加标签"></tm-input>
          <!-- tag展示列表 -->
          <view class="my-10 flex flex-row flex-wrap" style="height: 300rpx;">
            <tm-tag :round="10" text :border="1" borderStyle="dashed" :shadow="0" color="light-blue" size="m"
              :label="item.name" v-for="item in chooseValue.tag" :key="item.id">
            </tm-tag>
          </view>
        </tm-indexes-item>
      </tm-indexes>
    </tm-collapse-item>
    <!-- 私密 -->
    <tm-cell :margin="[0, 0]" :titleFontSize="30" title="设置私密">
      <template v-slot:right>
        <tm-checkbox @update:modelValue="chooseValue.private" :round="12"></tm-checkbox>
      </template>
    </tm-cell>
    <!-- 价格 -->
    <tm-cell :margin="[0, 0]" :titleFontSize="30" title="出售价格">
      <template v-slot:right>
        <tm-input class="flex-5" v-model="chooseValue.price" :maxlength="20" placeholder="空为免费" :width="100"></tm-input>
      </template>
    </tm-cell>
    <!-- 附件 -->
    <tm-cell :margin="[0, 0]" :titleFontSize="30" title="选择附件">
      <template v-slot:right>
        <uni-file-picker  class="flex flex-row flex-row-bottom-end" @select="selectFile" file-mediatype="all" :limit="1">
          <button class="fileButton">选择文件</button>
        </uni-file-picker>
      </template>
    </tm-cell>
  </tm-collapse>
</template>

<script lang="ts" setup>
import { ref } from "vue"
import tmCollapse from "@/tmui/components/tm-collapse/tm-collapse.vue"
import tmCollapseItem from "@/tmui/components/tm-collapse-item/tm-collapse-item.vue"
import tmIndexesItem from "@/tmui/components/tm-indexes-item/tm-indexes-item.vue"
import tmIndexes from "@/tmui/components/tm-indexes/tm-indexes.vue"
import tmTag from "@/tmui/components/tm-tag/tm-tag.vue"
import tmCell from "@/tmui/components/tm-cell/tm-cell.vue"
import tmInput from "@/tmui/components/tm-input/tm-input.vue"
import tmCheckbox from "@/tmui/components/tm-checkbox/tm-checkbox.vue"
import uniFilePicker from "@/uni_modules/uni-file-picker_1.0.4/components/uni-file-picker/uni-file-picker.vue"

defineProps({
  // 分区列表
  partition: {
    type: Number,
    default: 0
  },
  // tag列表
  tagList: {
    type: Array<Number>,
    default: () => []
  },
  // 私有的值
  private: {
    type: Boolean,
    default: false
  },
  // 价格
  price: {
    type: Number,
    default: ''
  }
})

const chooseValue = ref({
  partition: '',
  tag: [
  {
    name: "记录",
    id: 1,
  }
  ],
  private: false,
  price: '',
  file: ''
})

// 分区列表
const partitionList = ref([
  {
    name: "人工智能",
    id: 1,
  },
  {
    name: "物联网",
    id: 2,
  },
  {
    name: "大数据",
    id: 3,
  },
  {
    name: "云计算",
    id: 4,
  },
  {
    name: "软件开发",
    id: 5,
  },
  {
    name: "人工智能",
    id: 6,
  },
  {
    name: "云计算",
    id: 7,
  },
  {
    name: "软件开发",
    id: 8,
  },
  {
    name: "软件开发",
    id: 9,
  },
  {
    name: "软件开发",
    id: 10,
  },
])

// 选择分区事件
const selectPartition = (item: {name:string}): void => {
  chooseValue.value.partition = item.name
  
}

// tag搜索的值
const tagValue = ref('')
// 添加tag事件
const addTag = () => {
  // 如果tag不在列表中
  if (chooseValue.value.tag.findIndex((item) => item.name === tagValue.value) === -1) {
    chooseValue.value.tag.push({
      name: tagValue.value,
      id: chooseValue.value.tag.length + 1
    })
  }

  console.log(chooseValue.value.tag);
}

// 文件选中函数
const selectFile = (e: any) => {
  chooseValue.value.file = e.tempFiles[0].file
}
</script>

<style scoped="scss">
.fileButton{
  margin-right: 0;
  padding: 2rpx;
  widows: 100rpx;
}
</style>