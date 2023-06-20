<script setup lang="ts">
import { onLaunch, onShow, onHide } from "@dcloudio/uni-app";
import { useLoginStore } from "./stores/useCommonStore";

onLaunch(() => {
	console.log("App Launch");
});
onShow(() => {
	// 判断是否登录

	// #ifdef MP-WEIXIN
	useLoginStore().checkLogin();
	// #endif
});
onHide(() => {
	console.log("App Hide");
});
</script>
<style >
/* #ifdef APP-NVUE */
@import './tmui/scss/nvue.css';
/* #endif */
/* #ifndef APP-NVUE */
@import './tmui/scss/noNvue.css';
/* #endif */
</style>