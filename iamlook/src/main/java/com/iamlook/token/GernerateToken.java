package com.iamlook.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 描述.
 *
 * @author yx
 * @version 1.0
 * @since 20-4-29上午10:14
 */
public class GernerateToken {

    public static void main(String[] args) {

        //https://jwt.io/ 解析token


        Date expireTime = new Date();
        Algorithm algorithm = Algorithm.HMAC256("admin");
        Date now = new Date();

        Collection<String> roles = new ArrayList<>();
        roles.add("adminskdadsa");

        // 附带username信息
        String token = JWT.create()
                .withIssuer("www.yike.com")
                .withSubject("userID")
                .withJWTId("tokenId")
                .withIssuedAt(now)
                .withNotBefore(now)
                .withExpiresAt(expireTime)
                .withClaim("site", "ruoyi")
                .withClaim("endpoint", "endpoint")
                .withClaim("username", "name")
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                .sign(algorithm);

        System.out.println(token);
    }


    //解析token

    /*String token = request.getHeader("Authorization");
    String userId = null;
        if (StringUtils.isNotEmpty(token)) {
        DecodedJWT jwt = JWT.decode(token);
        userId = jwt.getClaim("sub").asString();
    }*/
}
