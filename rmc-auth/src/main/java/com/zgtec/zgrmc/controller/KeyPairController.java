package com.zgtec.zgrmc.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.jsonwebtoken.*;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.Map;

/**
 * @author zkc
 * 获取RSA公钥接口
 * Created by macro on 2020/6/19.
 */
@RestController
@Api(tags = "KeyPairController", description = "获取RSA公钥接口")
@RequestMapping("/rsa")
public class KeyPairController {

    @Autowired
    private KeyPair keyPair;

    @GetMapping("/publicKey")
    public Map<String, Object> getKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }


//    public static void main(String[] args) {
//
//    }
    private static KeyPair getKeyPairFromKeystore(KeyStore keyStore, String alias, char[] password) throws Exception {
        PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password);
        return new KeyPair(publicKey, privateKey);
    }

//    // 别名，用于获取密钥对
//    private static final String ALIAS = "zjwt";
//
//    // 签发 JWT 令牌
//    public static String generateJwtToken(String username, String roles) {
//        try {
//            // 从密钥库文件加载密钥对
//            KeyStore keyStore = KeyStore.getInstance("JKS");
//            InputStream jksInputStream = new FileInputStream("d://b//jwt.jks");
//            keyStore.load(jksInputStream, "zg123456".toCharArray());
//            PrivateKey privateKey = (PrivateKey) keyStore.getKey(ALIAS, "zg123456".toCharArray());
//
//            // 设置过期时间 1小时有效期
//            long expirationTimeMillis = System.currentTimeMillis() + 3600 * 1000;
//            Date expirationDate = new Date(expirationTimeMillis);
//
//            // 构建 JWT 令牌
//            JwtBuilder jwtBuilder = Jwts.builder()
//                    .setSubject(username)
//                    .claim("roles", roles)
//                    .setExpiration(expirationDate)
//                    .signWith(privateKey, SignatureAlgorithm.RS256);
//
//            return jwtBuilder.compact();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static void main(String[] args) {
//        // 假设用户信息如下
//        String username = "john_doe";
//        String roles = "user";
//
//        // 生成 JWT 令牌
//        String jwtToken = generateJwtToken(username, roles);
//        System.out.println("Generated JWT Token: " + jwtToken);
//
//
//
////        String jwtToken = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJqb2huX2RvZSIsInJvbGVzIjoidXNlciIsImV4cCI6MTY4OTgzNTk5NX0.FJqPLCr1LoUWCW35ise4wxA-Rc4mc1Db-Dmp3h6NTNr4FsqK0EwmX_fPGOcanjBuDYy446YyAVgbPKIR_hDuh2PZPOhEsoNcS3khcAFvDL4pE2EHRfhgZ2S6hyyncayXpf95oT3RWKMyRyk0XcxtpD7smjmukmU-futeT2K37d557Awiz_ReCqoWxs90mRJHO0_Iysr83_USLAg1aj8bF-IO66PjiizyFSj1MVMPVU9nycGnjYuJvPeTVOdmgmzcmMFlnLE1qaTBBWPC_XO5Em82EckOeEIXkOrUwilA9Eofjc02sMPLTa-fSoioEZJ3kQb5XOELvVDvd3ux-tR8nQ"; // 从 jwt.jks 中获取的 JWT 令牌
//        String keystorePassword = "zg123456"; // keystore 的密码
//        String alias = "zjwt"; // 证书的别名
//
//        try {
//            // 加载 keystore 文件
//            KeyStore keyStore = KeyStore.getInstance("JKS");
////            keyStore.load(KeyPairController.class.getResourceAsStream("d://b//jwt.jks"), keystorePassword.toCharArray());
//            InputStream jksInputStream = new FileInputStream("d://b//jwt.jks");
//            keyStore.load(jksInputStream, keystorePassword.toCharArray());
//
//
//
//            // 获取证书中的密钥对
//            KeyPair keyPair = getKeyPairFromKeystore(keyStore, alias, keystorePassword.toCharArray());
//
//            // 解析 JWT 令牌
//            Jws<Claims> jws = Jwts.parserBuilder()
//                    .setSigningKey(keyPair.getPublic())
//                    .build()
//                    .parseClaimsJws(jwtToken);
//
//            // 获取过期时间
//            Date expiration = jws.getBody().getExpiration();
//            System.out.println("##########"+expiration);
//            // 获取当前时间
//            Date now = new Date();
//
//            // 检查是否过期
//            if (expiration.before(now)) {
//                System.out.println("JWT Token 已过期");
//            } else {
//                System.out.println("JWT Token 有效");
//            }
//        } catch (ExpiredJwtException ex) {
//            System.out.println("JWT Token 已过期");
//        } catch (Exception ex) {
//            System.out.println("JWT Token 解析失败：" + ex.getMessage());
//        }
//    }
}
