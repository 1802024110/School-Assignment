export interface Post {
    id: number;
    title: string;
    content: string;
    images: string[];
    author: {
        id: number;
        portrait: string;
        nick_name: string;
    };
    created_at: string;
    u_id: number;
    price: number;
    discount_price: number;
    portrait: string;
    nick_name: string;
    percent: number;
    time: string;
    follow: number;
    COALESCE: any;
    commentList: any;
}