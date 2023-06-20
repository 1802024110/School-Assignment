<template>
  <tm-app color="white">
    <!-- Logo页面 -->
    <tm-row class="flex flex-row-center-center">
      <view class="rounded overflow my-n25">
        <!--  -->
        <tm-image :width="300" :height="300" :src="Logo" errorLabel="这里有一张logo但是它加载失败了"></tm-image>
      </view>
    </tm-row>
    <!-- 登录注册 -->
    <tm-sheet :margin="[0]" :padding="[0]" >
      <tm-tabs class="pl--n20" showTabsLineAni :showTabsLine="false" :item-width="316" :width="636" :defaultName="1">
        <tm-tabs-pane :name="1" title="登录">
          <!-- 密码登录输入框表单 -->
          <tm-form class="flex-1 overflow" :modelValue="fromValue" :margin="[0, 100]" :padding="[0]">
            <tm-sheet :margin="[100, 0, 0, 0]" :padding="[0]">
              <!-- 账号输入框 -->
              <tm-input :height="100" v-model="fromValue.userName" placeholder="用户名"></tm-input>
              <tm-input v-model="fromValue.password" :margin="[0, 60]" :height="100" placeholder="请输入密码" password></tm-input>
              <tm-button @click="loginByPasswd" :shadow="0" :margin="[66, 0, 0, 0]" size="large" label="登录"></tm-button>
              <tm-button @click="toRegister" :margin="[66, 20, 0, 0]" :shadow="0" text size="large" outlined label="注册"></tm-button>
              <tm-button :margin="[66, 10, 0, 0]" transprent text :shadow="0" size="large" label="忘记密码"
                fontColor="black"></tm-button>
            </tm-sheet>
          </tm-form>
        </tm-tabs-pane>
        <tm-tabs-pane :name="2" title="验证码登录">
          <!-- 验证码登录输入框表单 -->
          <tm-form class="flex-1 overflow" :modelValue="fromValue" :margin="[0, 100]" :padding="[0]">
            <tm-sheet :margin="[100, 0, 0, 0]" :padding="[0]">
              <!-- 账号输入框 -->
              <tm-input :height="100" v-model="fromValue.email" placeholder="邮箱"></tm-input>
              <!-- 验证码 -->
              <tm-row :column="6" :height="0" class="my-n15">
                <tm-col :col="4">
                  <tm-codeinput @click="checkEmail" :value="fromValue.code" :gutter="8" :size="80" outlined
                    :round="4"></tm-codeinput>
                </tm-col>
                <tm-col :col="2" :height="100">
                  <tm-button @click="sendCode" :disabled="sendButton.disabled" :width="160" :shadow="0" :label="sendButton.label" :icon="sendButton.icon"></tm-button>
                </tm-col>
              </tm-row>
              <tm-button @click="loginByCode" :shadow="0" :margin="[66, 0, 0]" size="large" label="登录"></tm-button>
              <tm-button @click="toRegister" :margin="[66, 20, 0, 0]" :shadow="0" text size="large" outlined label="注册"></tm-button>
              <tm-button :margin="[66, 10, 0, 0]" transprent text :shadow="0" size="large" label="忘记密码"
                fontColor="black"></tm-button>
            </tm-sheet>
          </tm-form>
        </tm-tabs-pane>
      </tm-tabs>
      <!-- 弹出键盘 -->
    </tm-sheet>
    <!-- 小键盘 -->
    <tm-keyboard type="number" :decimal="false"  v-model:show="show" v-model="fromValue.code"></tm-keyboard>
    <!-- 消息通知 -->
    <tm-notification placement="topRight" ref="msg"></tm-notification>
  </tm-app>
</template>

<script setup lang="ts">
import { ref } from "vue";

import Logo from "@/static/logo.png";

import tmNotification from "@/tmui/components/tm-notification/tm-notification.vue";
import tmApp from "@/tmui/components/tm-app/tm-app.vue";
import tmKeyboard from "@/tmui/components/tm-keyboard/tm-keyboard.vue";
import tmCol from "@/tmui/components/tm-col/tm-col.vue";
import tmCodeinput from "@/tmui/components/tm-codeinput/tm-codeinput.vue";
import tmButton from "@/tmui/components/tm-button/tm-button.vue";
import tmInput from "@/tmui/components/tm-input/tm-input.vue";
import tmForm from "@/tmui/components/tm-form/tm-form.vue";
import tmTabs from '@/tmui/components/tm-tabs/tm-tabs.vue';
import tmTabsPane from "@/tmui/components/tm-tabs-pane/tm-tabs-pane.vue"
import tmSheet from '@/tmui/components/tm-sheet/tm-sheet.vue';
import tmImage from '@/tmui/components/tm-image/tm-image.vue';
import tmRow from '@/tmui/components/tm-row/tm-row.vue';
import { getCodeForLogin, getCodeForRegister,loginByEmail,loginByPassword } from "@/api/logo";
import { useUserStore } from "@/stores/useCommonStore";

// 是否显示键盘
const show = ref(false);

// 表单的值
const fromValue = ref({
  userName: "梦无念",
  email: "1802024110@qq.com",
  password: "2002zengyuan",
  code: "",
});

// 发送按钮状态
const sendButton = ref({
  label: "发送",
  icon: "tmicon-mail",
  disabled: false,
});

// 弹窗内容
const msg = ref();


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

// 跳转到注册
const toRegister = () => {
    console.log('跳转到注册页面')
    // 跳转到注册页面
    uni.navigateTo({
        url: "/pages/register/index",
    });
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
    getCodeForLogin(email).then((data)=>{
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

// 通过密码登录
const loginByPasswd = () => {
    const userName = fromValue.value.userName;
    const password = fromValue.value.password;

    loginByPassword(userName,password).then((data)=>{
        if (data.code == 200) {

          const token = data.data.token;
          uni.setStorageSync("token", token);

          const userInfo = data.data.user;
          useUserStore().userInfo = userInfo;

          msg.value?.show({
            label: "登录成功",
            color: "green"
          })
          // 跳转到首页
          uni.switchTab({
            url: "/",
          });
        } else {
          msg.value?.show({
            label: "登录失败"+data.data,
            color: "red"
          })
        }
    })
};

// 通过验证码登录
const loginByCode = () => {
    const email = fromValue.value.email;
    const code = fromValue.value.code;
  
    loginByEmail(email,code).then((data)=>{
        if (data.code == 200) {
          const token = data.data.token;
          uni.setStorageSync("token", token);

          const userInfo = data.data.user;
          useUserStore().userInfo = userInfo;

          msg.value?.show({
            label: "登录成功",
            color: "green"
          })
          // 跳转到首页
          uni.switchTab({
            url: "/",
          });
        } else {
          msg.value?.show({
            label: "登录失败"+data.data,
            color: "red"
          })
        }
    })
};
</script>

<style scoped>
</style>