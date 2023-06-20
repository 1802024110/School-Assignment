// 引入Store定义函数
import { defineStore } from 'pinia'
import { ref } from 'vue'

// 第一个参数，唯一不可重复，字符串类型，作为仓库ID 以区分仓库
// 第二个参数，以对象形式配置仓库的state,getters,actions
export const useCommonStore = defineStore('useCommonStore',()=>{
})

export const useLoginStore = defineStore('userLoginStore',()=>{
  let  isLogin = ref(false);
  const checkLogin = ()=>{
    if(uni.getStorageSync('token') === ''){
      // 未登录,跳转登录页面
      uni.reLaunch({ url: '/pages/login/index' })
    }else{
      isLogin.value = true;
    }
  }
  return {
    isLogin,
    checkLogin
  }
})

export const useUserStore = defineStore('useCommonStore',()=>{
  let  userInfo = ref({});
  return {
    userInfo
  }
})