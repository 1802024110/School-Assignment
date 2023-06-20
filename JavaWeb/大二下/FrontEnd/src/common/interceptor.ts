// 页面白名单
const pageWhiteList = [
  '/page/login/*',
    "/pages/register/*"
];

// 是否页面有权限
export function hasPagePermission(url:string) : boolean{
  // 判断是否在白名单中
  if(pageWhiteList.indexOf(url) !== -1){
    return true;
  }

  return uni.getStorageSync('token') === ''? false: true;
}

// 拦截器
uni.addInterceptor('switchTab', {
  invoke(args) {
    return hasPagePermission(args.url) ? true : uni.reLaunch({ url: '/pages/login/index' });
  },
  success(args) {
    console.log('navigateTo success', args);
  }
});

// 拦截网络请求,加上token
uni.addInterceptor('request', {
    invoke(args) {
        if (hasPagePermission(args.url)) {
            args.header = {
                ...args.header,
                "Authorization": uni.getStorageSync('token')
            }
            return true;
        }
    }
}
);