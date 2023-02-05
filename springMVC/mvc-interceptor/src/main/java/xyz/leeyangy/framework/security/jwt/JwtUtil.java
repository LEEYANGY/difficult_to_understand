package xyz.leeyangy.framework.security.jwt;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 * @Package: xyz.leeyangy.jwt.util
 * @Author: LEEYANGYANG
 * @Create: 2022/10/31 0:38
 * @Description: 用户登录后生成的jwt
 * 使用hs256算法
 * jwt组成：header.payload.signature
 */
public class JwtUtil {

    //    时间                    一天 1s*60*60*24
//    private static long time = 1000 * 60 * 60 * 24;
    //    100s
    private static long time = 1000 * 100;
    //    签名
    private static String signature = "admin";

    public static String createToken(Object object) {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header
                .setHeaderParam("typ", "JWT")
//                加密算法
                .setHeaderParam("alg", "HS256")
//                信息payload
//                .claim("username", "admin")
//                .claim("password", "admin")
//                将用户信息写入token中
                .claim("userInfo", object)
//                主题
                .setSubject("test-jwt")
//                过期时间
                .setExpiration(new Date(System.currentTimeMillis() + time))
//                id
                .setId(UUID.randomUUID().toString())
//                signature
                .signWith(SignatureAlgorithm.HS256, signature)
//                三部分信息组合到一块
                .compact();
        return jwtToken;
    }

    public static boolean checkToken(String token) {
//        token==null,直接返回false
        if (token == null) {
            return false;
        }
        try {
//        解析token
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
//            如果抛出异常，说明token有问题，返回false进行后续操作
        } catch (Exception e) {
            return false;
        }
//        返回true说明token没问题
        return true;
    }

}
