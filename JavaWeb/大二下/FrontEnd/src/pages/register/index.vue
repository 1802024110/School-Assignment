<template>
  <tm-app color="white">
    <top-bar back title="创建账户" />
    <!-- Logo页面 -->
    <tm-row class="flex flex-row-center-center">
      <view class="rounded overflow my-n25">
        <!--  -->
        <tm-image :width="300" :height="300" :src="Logo" errorLabel="这里有一张logo但是它加载失败了"></tm-image>
      </view>
    </tm-row>
    <!-- 验证码登录输入框表单 -->
    <tm-sheet :margin="[80]">
      <tm-form :modelValue="fromValue" :margin="[0, 0]" :padding="[0]">
        <!-- 账号输入框 -->
        <tm-input :height="100" v-model="fromValue.username" placeholder="用户名"></tm-input>
        <!-- 账号输入框 -->
        <tm-input :height="100" v-model="fromValue.email" :margin="[0,30]" placeholder="邮箱"></tm-input>
        <!-- 验证码 -->
        <tm-row :column="6" :margin="[0,30]">
          <tm-col :col="4">
            <tm-codeinput @click="checkEmail" :value="fromValue.code" :gutter="8" :size="80" outlined :round="4"></tm-codeinput>
          </tm-col>
          <tm-col :col="2" :height="100">
            <tm-button @click="sendCode" :disabled="sendButton.disabled" :width="160" :shadow="0" :label="sendButton.label" :icon="sendButton.icon"></tm-button>
          </tm-col>
        </tm-row>

        <tm-input v-model="fromValue.password" :height="100" placeholder="请输入密码" password></tm-input>
        <tm-input v-model="fromValue.password2" :margin="[0,30]" :height="100" placeholder="请确认密码" password></tm-input>
        <view  class="fulled 	flex-center" >
          <tm-button @click="registerAccount" :shadow="0" size="large" label="注册"></tm-button>
        </view>
      </tm-form>
    </tm-sheet>
    <!-- 小键盘 -->
    <tm-keyboard type="number" :decimal="false"  v-model:show="show" v-model="fromValue.code"></tm-keyboard>
    <!-- 消息通知 -->
    <view class="mb--60">
      <tm-notification placement="topRight" ref="msg"></tm-notification>
    </view>
  </tm-app>
</template>

<script setup lang="ts">
import Logo from "@/static/logo.png";

import { ref } from "vue";

import TopBar from "@/component/top-bar.vue";
import tmNotification from "@/tmui/components/tm-notification/tm-notification.vue";
import tmApp from "@/tmui/components/tm-app/tm-app.vue";
import tmKeyboard from "@/tmui/components/tm-keyboard/tm-keyboard.vue";
import tmCol from "@/tmui/components/tm-col/tm-col.vue";
import tmCodeinput from "@/tmui/components/tm-codeinput/tm-codeinput.vue";
import tmButton from "@/tmui/components/tm-button/tm-button.vue";
import tmInput from "@/tmui/components/tm-input/tm-input.vue";
import tmForm from "@/tmui/components/tm-form/tm-form.vue";
import tmSheet from '@/tmui/components/tm-sheet/tm-sheet.vue';
import tmImage from '@/tmui/components/tm-image/tm-image.vue';
import tmRow from '@/tmui/components/tm-row/tm-row.vue';
import {getCodeForRegister,register} from "@/api/logo";
// 是否显示键盘
const show = ref(false);

// 弹窗内容
const msg = ref();

// 发送按钮状态
const sendButton = ref({
  label: "发送",
  icon: "tmicon-mail",
  disabled: false,
});

// 表单的值
const fromValue = ref({
  username: "梦无念",
  email:  "1802024110@qq.com",
  password: "2002zengyuan",
  password2: "2002zengyuan",
  code: "",
});

// 检查邮箱格式，判断是否展示键盘
const checkEmail = () => {
  // 正则表达式匹配邮箱
  const reg = /^([a-zA-Z]|[0-9])(\w|-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;

  if (reg.test(fromValue.value.email)) {
    show.value = true;
  } else {
    msg.value?.show({
      label: "邮箱格式错误",
      color: "red"
    })
    show.value = false;
  }
};

// 发送验证码
const sendCode = () => {
    if (sendButton.value.label != "发送") {
      return;
    }
    // 正则表达式检查邮箱
    const reg = /^([a-zA-Z]|[0-9])(\w|-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    const email = fromValue.value.email;
    if (!reg.test(email)) {
      msg.value?.show({
        label: "邮箱格式错误",
        color: "red"
      })
      return;
    }
    // 发送验证码
    getCodeForRegister(email).then((data)=>{
        if (data.code == 200) {
          msg.value?.show({
            label: "验证码发送成功",
            color: "green"
          })

          sendButton.value.label = "60";
          setInterval(() => {
            if (sendButton.value.label == "1") {
              sendButton.value.label = "发送";
              sendButton.value.icon = "tmicon-mail";
              sendButton.value.disabled = false;
            } else {
              sendButton.value.label = (parseInt(sendButton.value.label) - 1).toString();
              sendButton.value.icon = "";
              sendButton.value.disabled = true;
            }
          }, 1000);
        } else {
          console.log(data);
          
          msg.value?.show({
            label: "验证码发送失败"+data.data,
            color: "red"
          })
        }
    })
};

// 注册
const registerAccount  = () => {
  const username = fromValue.value.username;
  const password = fromValue.value.password;
  const password2 = fromValue.value.password2;
  const code = fromValue.value.code;
  const email = fromValue.value.email;

  // 检查两次密码是否一致
  if (password != password2) {
    msg.value?.show({
      label: "两次密码不一致",
      color: "red"
    })
    return;
  }

  register(username,password,email,code).then((data)=>{
    if (data.code == 200) {
      msg.value?.show({
        label: "注册成功",
        color: "green"
      })
      setTimeout(() => {
        uni.navigateBack();
      }, 1000);
    } else {
      msg.value?.show({
        label: "注册失败"+data.data,
        color: "red"
      })
    }
  })
}

</script>

<style lang='scss' >
.a{
  color: red;
}
</style>