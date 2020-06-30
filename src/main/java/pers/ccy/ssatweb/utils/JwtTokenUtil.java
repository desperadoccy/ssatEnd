package pers.ccy.ssatweb.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

/**
 * @author desperado
 * @ClassName JwtTokenUtil
 * @Description
 * @date 2020/6/30 16:30
 * @Version 1.0
 */
public class JwtTokenUtil {
    private static InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.jks"); // 寻找证书文件
    private static PrivateKey privateKey = null;
    private static PublicKey publicKey = null;

    static { // 将证书文件里边的私钥公钥拿出来
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS"); // java key store 固定常量
            keyStore.load(inputStream, "SSAT16".toCharArray());
            privateKey = (PrivateKey) keyStore.getKey("jwt", "SSAT16".toCharArray()); // jwt 为 命令生成整数文件时的别名
            publicKey = keyStore.getCertificate("jwt").getPublicKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @MethodName generateToken
     * @Description 使用私钥加密token
     * @param [subject, expirationSeconds]
     */
    public static String generateToken(String subject, int expirationSeconds) {
        return Jwts.builder()
                .setClaims(null)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }

    /**
     * @MethodName generateToken
     * @Description 不使用公钥私钥加密token
     * @param [subject, expirationSeconds, salt]
     */
    public static String generateToken(String subject, int expirationSeconds, String salt) {
        return Jwts.builder()
                .setClaims(null)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
                .signWith(SignatureAlgorithm.HS512, salt) // 不使用公钥私钥
                .compact();
    }

    /**
     * @MethodName parseToken
     * @Description 通过公钥解密token
     * @param [token, salt]
     */
    public static String parseToken(String token,String salt) {
        String subject = null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(salt) // 不使用公钥私钥
                    .parseClaimsJws(token).getBody();
            subject = claims.getSubject();
        } catch (Exception e) {
        }
        return subject;
    }

    /**
     * @MethodName parseToken
     * @Description 不通过公钥解密token
     * @param [token]
     */
    public static String parseToken(String token) {
        String subject = null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(publicKey)
                    .parseClaimsJws(token).getBody();
            subject = claims.getSubject();
        } catch (Exception e) {
        }
        return subject;
    }
}
