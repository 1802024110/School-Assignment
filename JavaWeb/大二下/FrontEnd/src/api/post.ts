import {baseUrl} from './index'
import {ResponseData} from "./interface/Response";
import {Post} from "./interface/Post";

// 上传文件
export const uploadFile = async (file: File): Promise<ResponseData<any>> => {
    const response = await uni.uploadFile({
        url: baseUrl + '/issue/user/file',
        method: 'POST',
        name: file.name,
        header: {
            'content-type': 'multipart/form-data'
        },
        formData: {
            'header': file
        }
    })
    return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}

// 发帖
export const post = async (title: string, content: string, userId: number, filesId: Array<string>): Promise<ResponseData<any>> => {
    const response = await uni.request({
        url: baseUrl + '/post',
        method: 'POST',
        data: {
            title,
            content,
            userId,
            filesId
        }
    })
    return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}

// 获取首页推荐
export const getRecommend = async (): Promise<ResponseData<{ hot: Post, newest: Post }>> => {
    const response = await uni.request({
        url: baseUrl + '/home/recommend',
        method: 'GET'
    })
    return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}

// 获得帖子详情
export const getPostDetail = async (id: number): Promise<ResponseData<Post>> => {
    const response = await uni.request({
        url: baseUrl + '/home/content/' + id,
        method: 'GET'
    })
    return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}

// 获得帖子评论
export const getPostComment = async (pid: number, father_start: number = 0, father_size: number = 10, child_start: number = 0, child_size: number = 3): Promise<ResponseData<any>> => {
    const response = await uni.request({
        url: baseUrl + '/comment/comments',
        method: 'POST',
        data: {
            iId: pid,
            fnumber: father_start,
            fsize: father_size,
            znumber: child_start,
            zsize: child_size
        }
    })
    return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}

// 获取分区列表
export const getSectionList = async (): Promise<ResponseData<any>> => {
    // const response = await uni.request({
    //     url: baseUrl + '/section/list',
    //     method: 'GET'
    // })
    // 模拟数据
    return {
        code: 200,
        message: "",
        data: [
            {
                id: 1,
                title: "校园生活",
            },
            {
                id: 2,
                title: "学习交流",
            },
            {
                id: 3,
                title: "情感天地"
            }
        ]
    }

    // return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}

/**
 * 根据分区获取帖子列表
 * @param sectionId 分区id
 * @param start 开始位置
 * @param size 获取数量
 * */
export const getPostListBySection = async (sectionId: number, start: number = 0, size: number = 10): Promise<ResponseData<any>> => {
    // const response = await uni.request({
    //     url: baseUrl + '/home/section/' + sectionId,
    //     method: 'POST',
    //     data: {
    //         start,
    //         size
    //     }
    // })
    // return typeof response.data === 'string' ? JSON.parse(response.data) : response.data

    // 模拟数据
    return {
        code: 200,
        message: "",
        data: [
            {
                // 用户id
                uid: 0,
                // 帖子id
                pid: 1,
                // 头像
                portrait: "https://picsum.photos/200",
                // 用户名
                nickName: "默认用户名",
                // 标题
                title: "基于ChatGpt的建议助手",
                // 内容
                content: "作为用户和产品之间的桥梁，社交分享在产品的发展过程中扮演了重要的角色。用户主动点击分享 绝大多数APP都是在详情页等需要分享的页面放置一个分享按钮，由用户自行选择分享。这种情况下用户是否分享主要是取决于产品内容本身，比如内容有趣或是有用。在一些APP中设计者会对这个分享按钮加一些鼓励的文案或着重的设计来促进用户分享。所以监听用户的截图操作，提示用户进行分享，既缩短了以前分享截图的操作路径，避免了在之前长路径中的行为流失（比如截图完成后忘记分享或觉得麻烦放弃分享等等），也让用户觉得更加贴心。在常用的社交分享组件中，微信（微信好友和朋友圈）、微博、QQ（QQ好友和QQ空间）是三大主要平台，而其中微信凭借高达9.38亿的月活跃用户以及高达29%的日均手机应用使用率，成为各款APP选择最多、排位最靠前的分享途径。即便同样是腾...",
                // 图片
                iorM: ["https://picsum.photos/200", "https://picsum.photos/200", "https://picsum.photos/200", "https://picsum.photos/200", "https://picsum.photos/200?id=1"],
                // 支持
                good: 20,
                // 反对
                no_good: 10,
                // 发布时间
                createdAt: "2023-3-3",
                // 关注人数
                attentionCount: 20,
                // 查看人数
                look: 20,
            },
            {
                // 用户id
                uid: 1,
                // 帖子id
                pid: 2,
                // 头像
                portrait: "https://picsum.photos/200",
                // 用户名
                nickName: "默认用户名",
                // 标题
                title: "基于ChatGpt的建议助手2",
                // 内容
                content: "作为用户和产品之间的桥梁，社交分享在产品的发展过程中扮演了重要的角色。用户主动点击分享 绝大多数APP都是在详情页等需要分享的页面放置一个分享按钮，由用户自行选择分享。这种情况下用户是否分享主要是取决于产品内容本身，比如内容有趣或是有用。在一些APP中设计者会对这个分享按钮加一些鼓励的文案或着重的设计来促进用户分享。所以监听用户的截图操作，提示用户进行分享，既缩短了以前分享截图的操作路径，避免了在之前长路径中的行为流失（比如截图完成后忘记分享或觉得麻烦放弃分享等等），也让用户觉得更加贴心。在常用的社交分享组件中，微信（微信好友和朋友圈）、微博、QQ（QQ好友和QQ空间）是三大主要平台，而其中微信凭借高达9.38亿的月活跃用户以及高达29%的日均手机应用使用率，成为各款APP选择最多、排位最靠前的分享途径。即便同样是腾...",
                // 图片
                iorM: [
                    "https://picsum.photos/200"
                    ],
                // 支持
                good: 50,
                // 反对
                no_good: 40,
                // 发布时间
                createdAt: "2023-3-3",
                // 关注人数
                attentionCount: 20,
                // 查看人数
                look: 20,
            }
        ]
    }
}