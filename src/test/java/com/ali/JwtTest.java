package com.ali;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT测试类，用于生成和解析JWT令牌
 */
public class JwtTest {

    /**
     * 测试生成JWT令牌的方法
     * 该方法创建一个包含用户信息的JWT令牌，并设置过期时间
     */
    @Test
    public void testGen(){
        // 创建载荷数据，包含用户ID和用户名
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");

        // 生成JWT令牌
        String token = JWT.create()
                .withClaim("user",claims)// 添加载荷信息
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))// 设置12小时后过期
                .sign(Algorithm.HMAC256("damuniu"));// 使用HMAC256算法签名，密钥为"damuniu"
        System.out.println(token);

    }

    /**
     * 测试解析JWT令牌的方法
     * 该方法验证并解析JWT令牌，提取其中的载荷信息
     */
    @Test
    public void testParse(){
        // 待解析的JWT令牌字符串
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3NjI0NDAzODl9" +
                ".RZYsp2DhbK28UMtboafdKW-5I7DjpwpVqSsjwpWFbwA";

        // 创建JWT验证器，使用相同的算法和密钥
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("damuniu")).build();

        // 验证令牌并获取解析后的JWT对象
        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        // 提取载荷中的所有声明
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}

