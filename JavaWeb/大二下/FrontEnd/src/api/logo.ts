// 通过用户名密码登录
import {baseUrl} from './index'
import {ResponseData} from "@/api/interface/Response";

// 通过用户名密码登录
export const loginByPassword = async (userName: string, passWord: string):Promise<ResponseData<any>> => {
    const response = await uni.request({
        url: baseUrl + '/user/login',
        method: 'POST',
        data: {
            userName,
            passWord
        }
    })
    return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}

// 通过邮箱验证码登录
export const loginByEmail = async (email: string, code: string):Promise<ResponseData<any>> => {
    const response = await uni.request({
        url: baseUrl + '/user/email/login',
        method: 'POST',
        data: {
            email,
            code
        }
    })
    return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}

// 注册用户
export const register = async (userName: string, passWord: string,email:string,code:string):Promise<ResponseData<any>> => {
    const response = await uni.request({
        url: baseUrl + '/user/sign',
        method: 'POST',
        data: {
            userName,
            passWord,
            email,
            code
        }
    })
    return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}

// 获取注册验证码
export const getCodeForRegister  = async (email: string): Promise<ResponseData<any>> => {
    const response = await uni.request({
        url: baseUrl + '/user/getcode/'+email,
        method: 'GET'
    })
    return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}

// 获取登录验证码
export const getCodeForLogin  = async (email: string): Promise<ResponseData<any>> => {
    const response = await uni.request({
        url: baseUrl + '/user/email/loginCode/'+email,
        method: 'GET'
    })
    return typeof response.data === 'string' ? JSON.parse(response.data) : response.data
}
