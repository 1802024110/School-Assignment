/**
 * 用户表
 */
export interface UserInfo {
    userName: string;
    nickName: string;
    email: string | null;
    portrait: string;
    describeText: string |null;
    sex: number | null;
    vip: number;
    history: string | null;
    goldCount: number | null;
    offlineTime: string | null;
    favorite: string | null;
    createdAt: string | null;
    updatedAt: string | null;
    phone: string | null;
    attentionCount: number | null;
    // 关注的人数
    attention: number | null;
    // 粉丝数
    fans: number | null;
    // 灵值
    spirit: number | null;
}