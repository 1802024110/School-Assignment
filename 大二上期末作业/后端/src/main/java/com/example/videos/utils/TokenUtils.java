package com.example.videos.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @desc   使用token验证用户是否登录
 * 参考文章: https://javaguide.cn/system-design/security/jwt-intro.html#%E4%BB%80%E4%B9%88%E6%98%AF-jwt
 **/
public class TokenUtils {
    //设置过期时间,毫秒
    public static final long EXPIRE_DATE=60000*60*2;
    //token秘钥
    private static final String TOKEN_SECRET = "b9f86abbca81ab98a516864389edc731";
    // 7天刷新令牌过期
    private static final long REFRESH_EXPIRE_DATE=60000*60*24*7;

    private static final String REFRESH_TOKEN_SECRET = "218eafd1fdf990d5a52319d1f9664085";

    public static String token (String email){

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("email",email)
                    .withClaim("expiration_time",date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }
    // 刷新令牌的令牌，把系统时间当作了盐。
    public static String refresh_token(String email){
        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+REFRESH_EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(REFRESH_TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("email", email)
                    .withClaim("expiration_time", date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }

    public static boolean verify(String token){
        /**
         * @desc   验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        }catch (Exception e){
            //e.printStackTrace();
            return  false;
        }
    }
    public static boolean verify_refresh(String token){
        /**
         * @desc   验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(REFRESH_TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        }catch (Exception e){
            //e.printStackTrace();
            return  false;
        }
    }

    public static DecodedJWT convert_token(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT;
    }

    public static DecodedJWT convert_refresh_token(String refresh_token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(REFRESH_TOKEN_SECRET)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);
        // TODO 这里解析出现了问题
        System.out.println(decodedJWT);
        return decodedJWT;
    }
}
