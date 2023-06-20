import { UserInfo } from './interface/User';
import { ResponseData } from './interface/Response';

/**
 * 获取已登录用户信息
 * */
export const getUserInfo = async (): Promise<ResponseData<UserInfo>> => {
 // const response = await uni.request({
 //     url: baseUrl + '/section/list',
 //     method: 'GET'
 // })
 // 模拟数据
 return {
  code: 200,
  message: '',
  data: {
   userName: 'admin',
   nickName: '管理员',
   email: '100120@qq.com',
   portrait: 'https://img.yzcdn.cn/vant/cat.jpeg',
   describeText: '这个人很懒，什么都没有留下',
   sex: 0,
   vip: 0,
   history: null,
   goldCount: 0,
   offlineTime: '1970-01-01',
   favorite: null,
   createdAt: '2020-12-12',
   updatedAt: '2020-12-12',
   phone: '123456789',
   attentionCount: 0,
   attention: 0,
   fans: 0,
   spirit: 0,
  },
 };
 // return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
};
